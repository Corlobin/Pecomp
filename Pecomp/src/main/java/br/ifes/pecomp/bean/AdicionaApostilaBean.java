package br.ifes.pecomp.bean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.ifes.pecomp.entity.Apostila;
import br.ifes.pecomp.repository.ApostilaRepositoryImpl;


@ManagedBean(name = "adicionaApostilaBean")
@ViewScoped
public class AdicionaApostilaBean extends AbstractBean implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Apostila apostila;
	private UploadedFile file;
	private ApostilaRepositoryImpl apostilaRepository;
	private String imagemBaixada;
	
	public AdicionaApostilaBean(){
		super();
	}
	
	@PostConstruct
	public void init() {
		apostilaRepository = new ApostilaRepositoryImpl();
		apostila = new Apostila();
	}
	
	public Apostila getApostila() {
		return apostila;
	}
	
	public void setApostila(Apostila apostila) {
		this.apostila = apostila;
	}
	
	public UploadedFile getFile() {
		return file;
	}
	
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public String getImagemBaixada() {
		return imagemBaixada;
	}
	
	public void setImagemBaixada(String imagemBaixada) {
		this.imagemBaixada = imagemBaixada;
	}
	
	public String cadastrarApostila() {
		apostila.setImagem(file.getFileName());
		apostilaRepository.inserir(apostila);
		this.sucess("Apostila cadastrada com sucesso!");

		return "";
	}

	public void upload(FileUploadEvent event) throws IOException {

		try {
			file = event.getFile();

			FacesContext aFacesContext = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();

			String realPath = context.getRealPath("/resources/ApostilasEnviadas/");

			byte[] arquivo = file.getContents();
			String caminho = realPath + file.getFileName();
			System.out.println("caminho apostila: " + caminho);

			// esse trecho grava o arquivo no diretório
			FileOutputStream fos = new FileOutputStream(caminho);
			fos.write(arquivo);
			fos.close();

			FacesContext instance = FacesContext.getCurrentInstance();
			instance.addMessage("mensagens",
					new FacesMessage(FacesMessage.SEVERITY_INFO, file.getFileName() + "Sucesso", null));

		} catch (Exception ex) {
			System.out.println("Erro no upload de imagem" + ex);
		}
	}
}
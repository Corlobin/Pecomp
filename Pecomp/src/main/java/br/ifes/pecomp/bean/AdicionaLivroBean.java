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

import br.ifes.pecomp.entity.Livro;
import br.ifes.pecomp.repository.LivroRepositoryImpl;

@ManagedBean(name = "adicionaLivroBean")
@ViewScoped
public class AdicionaLivroBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Livro livro;
	private UploadedFile file;
	private LivroRepositoryImpl livroRepository;
	private String imagemBaixada;

	public AdicionaLivroBean() {

	}

	@PostConstruct
	public void init() {
		livroRepository = new LivroRepositoryImpl();
		livro = new Livro();
	}

	public String getImagemBaixada() {
		return imagemBaixada;
	}

	public void setImagemBaixada(String imagemBaixada) {
		this.imagemBaixada = imagemBaixada;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String cadastrarLivro() {
		livro.setImagem(file.getFileName());
		livroRepository.inserir(livro);
		this.sucess("Livro cadastrado com sucesso!");

		return "";
	}

	public void upload(FileUploadEvent event) throws IOException {
		try {
			file = event.getFile();

			FacesContext aFacesContext = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();

			String realPath = context.getRealPath("/resources/LivrosEnviados/");

			byte[] arquivo = file.getContents();
			String caminho = realPath + file.getFileName();
			System.out.println("caminho" + caminho);

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

		/*
		 * System.out.println("entrou no metodo"); file = event.getFile();
		 * 
		 * if (file != null) { System.out.println("entrou if");
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * ServletContext sc = (ServletContext)
		 * context.getExternalContext().getContext();
		 * System.out.println(sc.getRealPath("/LivrosEnviados"));
		 * System.out.println("^^^esse eh o caminho?");
		 * 
		 * File file1 = new File("/webapp/resources/LivrosEnviados",
		 * file.getFileName()); file1.createNewFile();
		 * 
		 * try { FileOutputStream fos = new FileOutputStream(file1);
		 * fos.write(event.getFile().getContents()); fos.close();
		 * 
		 * FacesContext instance = FacesContext.getCurrentInstance();
		 * instance.addMessage("mensagens", new FacesMessage(
		 * FacesMessage.SEVERITY_ERROR, file.getFileName() +
		 * " Anexado com sucesso", null)); } catch (FileNotFoundException e) {
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
		 * catch block System.out.println("entrou catch 2");
		 * e.printStackTrace(); } }
		 */
	}

}

package br.ifes.pecomp.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.ifes.pecomp.entity.Curso;
import br.ifes.pecomp.entity.Instituicao;
import br.ifes.pecomp.entity.Pessoa;

@ManagedBean(name = "perfilBean")
@RequestScoped
public class PerfilBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public UploadedFile arquivo;

	public StreamedContent foto = null;

	private Pessoa pessoa;

	private Instituicao instituicao;

	private Curso curso;

	private List<Curso> listCurso;

	private String filename;

	private LoginBean loginBean;

	public PerfilBean() {
		filename = "";

		FacesContext facesContext = FacesContext.getCurrentInstance();
		loginBean = (LoginBean) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "loginBean");

	}

	public List<Curso> getListCurso() {
		return listCurso;
	}

	public void setListCurso(List<Curso> listCurso) {
		this.listCurso = listCurso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public void save() {
		this.sucess("Dados atualizados com sucesso!");
		loginBean.salvarUsuario();

	}

	public String solicitarAtualizacao() {
		return "";
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}

	public StreamedContent getFoto() {
		return this.foto;
	}

	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}

	private String getRandomImageName() {
		int i = (int) (Math.random() * 10000000);

		return String.valueOf(i);
	}

	public String getFilename() {
		return filename;
	}

	public void oncapture(CaptureEvent captureEvent) {
		filename = getRandomImageName();
		byte[] data = captureEvent.getData();

		String file2Name = "C:\\resources\\fotos\\"+filename+".jpeg";
		
		loginBean.getUsuario().setImageName(filename);
		loginBean.salvarUsuario();
		
		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(new File(file2Name));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();

			

		} catch (Exception e) {
			throw new FacesException("Error in writing captured image.");
		}
				
	}

	public StreamedContent getImage() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		// So, browser is requesting the image. Return a real StreamedContent
		// with the image bytes.
		FacesContext aFacesContext = FacesContext.getCurrentInstance();
		ServletContext contexta = (ServletContext) aFacesContext.getExternalContext().getContext();
		String realPath = contexta.getRealPath("/resources/FotosEnviadas/");
		
		
		String newFileName = realPath + filename;
		String filename = this.getUserImage();
		File file = new File("C:\\resources\\fotos\\", filename);
		FileInputStream fst = new FileInputStream(file);

		return new DefaultStreamedContent(fst, "image/png");

	}

	public String getUserImage() {
		
		String imagem = this.loginBean.getUsuario().getImageName();
		if (imagem == null) {
			return "resources/TemaPadrao/images/aluno5.png";
		} else {
			return "images/" + imagem + ".jpeg";
		}

	}

	/*
	 * public String salvarRegistro(){ for(Usuario usu: lista){
	 * if(usu.getEdita()){ UsuarioCrudJDBC objUsuarioCrudJDBC = new
	 * UsuarioCrudJDBC(); objUsuarioCrudJDBC.alterar(usu); }
	 * usu.setEdita(false); } lista = objUsuarioCrudJDBC.listar(); return null;
	 * }
	 */

}

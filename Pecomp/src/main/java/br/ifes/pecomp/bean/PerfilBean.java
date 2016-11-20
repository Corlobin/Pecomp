package br.ifes.pecomp.bean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;

import org.primefaces.event.CaptureEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.ifes.pecomp.entity.Curso;
import br.ifes.pecomp.entity.Instituicao;
import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.repository.CursoRepositoryImpl;
import br.ifes.pecomp.repository.InstituicaoRepositoryImpl;

@ManagedBean(value="perfilBean")
@SessionScoped
public class PerfilBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    //public Perfil perfil = null;
    //public Usuario usuario = Fachada.getInstancia().recuperarUsuarioDaSessao();
    public UploadedFile arquivo;
    public StreamedContent foto = null;
    
	private Pessoa pessoa;
	
	private Instituicao instituicao;
	
	private InstituicaoRepositoryImpl instituicoesRepository;
	
	private Curso curso;
	
	private CursoRepositoryImpl cursosRepository;
	
   private String filename;
	   	
	@PostConstruct
    public void init() {
		instituicoesRepository = new InstituicaoRepositoryImpl();
		cursosRepository = new CursoRepositoryImpl();
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
	
	public List<Instituicao> getInstituicoes() {
		return instituicoesRepository.getAll();
	}
	
	public List<Curso> getCursos() {
		return cursosRepository.getAll();
	}
	
    public void save() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User Saved"));
        instituicao = null;
        curso = null;
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setDataNascimento(null);
        pessoa.setSenha(null);
        
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
 
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String newFileName = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" +
                                    File.separator + "images" + File.separator + "photocam" + File.separator + filename + ".jpeg";
         
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        }
        catch(IOException e) {
            throw new FacesException("Error in writing captured image.", e);
        }
    }
    

}
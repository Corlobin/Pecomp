package br.ifes.pecomp.bean;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.ifes.pecomp.entity.Curso;
import br.ifes.pecomp.entity.Instituicao;
import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.repository.CursoRepositoryImpl;
import br.ifes.pecomp.repository.InstituicaoRepositoryImpl;
import br.ifes.pecomp.repository.PessoaRepositoryImpl;

@ManagedBean(name = "cadastroBean")
@ViewScoped
public class CadastroBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	
	private String confirmaSenha;
	
	private Instituicao instituicao;
	
	private InstituicaoRepositoryImpl instituicoesRepository;
	
	private List<Instituicao> listInstituicao;
	
	private Curso curso;
	
	private List<Curso> listCurso;
	
	private CursoRepositoryImpl cursosRepository;
	
	private PessoaRepositoryImpl pessoaRepository;
	
	@PostConstruct
    public void init() {
		instituicoesRepository = new InstituicaoRepositoryImpl();
		listInstituicao = instituicoesRepository.getAll();
		
		cursosRepository = new CursoRepositoryImpl();
		listCurso = cursosRepository.getAll(); 
		
		pessoaRepository = new PessoaRepositoryImpl();
		pessoa = new Pessoa();
		instituicao = new Instituicao();
		curso = new Curso();
	}
	
	public List<Curso> getListCurso() {
		return listCurso;
	}

	public void setListCurso(List<Curso> listCurso) {
		this.listCurso = listCurso;
	}

	public List<Instituicao> getListInstituicao() {
		return listInstituicao;
	}

	public void setListInstituicao(List<Instituicao> listInstituicao) {
		this.listInstituicao = listInstituicao;
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
	
	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public List<Instituicao> getInstituicoes() {
		return instituicoesRepository.getAll();
	}
	
	public List<Curso> getCursos() {
		return cursosRepository.getAll();
	}
	
    public String cadastrarPessoa() 
    {
    	if(!cadastrarValidation()) return "";
    	
    	pessoa.setDataEntrou(new Date(System.currentTimeMillis()));
    	pessoa.setInstituiccao(instituicao);
    	pessoa.setCurso(curso);
    	
    	pessoaRepository.inserir(pessoa);
    	
        this.sucess("Usuário cadastrado com sucesso!");
        resetaDadosUsuario();
        
        return "";
    }
    
    public boolean cadastrarValidation()
    {
    	boolean erro = true;
    	
		if (!this.pessoa.getSenha().equalsIgnoreCase(confirmaSenha)) {
			this.error("Senha confirmada incorretamente.");
			erro = false;
		}
		if( pessoaRepository.confereEmailUnico(this.pessoa.getEmail()) != null){
			this.error("E-mail já cadastrado!");
			erro = false;
		}
		return erro;
    }
    
    public void resetaDadosUsuario()
    {
        instituicao = null;
        curso = null;
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setDataNascimento(null);
        pessoa.setSenha(null);
    }
	
}

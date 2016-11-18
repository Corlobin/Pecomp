package br.ifes.pecomp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.ifes.pecomp.entity.Curso;
import br.ifes.pecomp.entity.Instituicao;
import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.repository.CursoRepositoryImpl;
import br.ifes.pecomp.repository.InstituicaoRepositoryImpl;

@ManagedBean(name = "cadastroBean")
@ViewScoped
public class CadastroBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	
	private Instituicao instituicao;
	
	private InstituicaoRepositoryImpl instituicoesRepository;
	
	private Curso curso;
	
	private CursoRepositoryImpl cursosRepository;
	
	private EntityManager entityManager;
	
	
	@PostConstruct
    public void init() {
		instituicoesRepository = new InstituicaoRepositoryImpl(entityManager);
		cursosRepository = new CursoRepositoryImpl(entityManager);
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
        this.sucess("User saved");
        instituicao = null;
        curso = null;
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setDataNascimento(null);
        pessoa.setSenha(null);
        
    }
	
}

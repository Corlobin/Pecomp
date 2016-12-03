package br.ifes.pecomp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_PESSOA")
public class Pessoa extends AbstractEntity {
	
	private static final long serialVersionUID = 8942577475182858896L;

	@Column(name="TB_PES_NOME")
	private String nome;
	
	@Column(name="TB_PES_EMAIL")
	private String email;
	
	@Column(name="TB_PES_SENHA")
	private String senha;
	
	@Column(name="TB_PES_NASCIMENTO")
	private Date dataNascimento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Instituicao instituicao;
	
	@Column(name="TB_PES_DT_ENTRADA")
	private Date dataEntrou;
	
	@ManyToOne
	//@JoinColumn(name="id",referencedColumnName = "id")
	private Curso curso;
	
	@Column(name="TB_PES_PROFISSAO")
	private String profissao;
	
	@Column(name="TB_PES_IMG_NAME")
	private String imageName;
	
	@OneToMany(mappedBy="pessoa")
	private List<PessoaAcertos> questaoTentadas;
		
	//andre bonitao
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String email, String senha, Date dataNascimento, Instituicao instituicao,
			Date dataEntrou, Curso curso, String profissao) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.instituicao = instituicao;
		this.dataEntrou = dataEntrou;
		this.curso = curso;
		this.profissao = profissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituiccao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Date getDataEntrou() {
		return dataEntrou;
	}

	public void setDataEntrou(Date dataEntrou) {
		this.dataEntrou = dataEntrou;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
			
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public List<PessoaAcertos> getQuestaoTentadas() {
		return questaoTentadas;
	}

	public void setQuestaoTentadas(List<PessoaAcertos> questaoTentadas) {
		this.questaoTentadas = questaoTentadas;
	}
	
	
	
}

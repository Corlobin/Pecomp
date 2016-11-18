package br.ifes.pecomp.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Pessoa extends AbstractEntity {
	
	private static final long serialVersionUID = 8942577475182858896L;

	private String nome;
	
	private String email;
	
	private String senha;
	
	private Date dataNascimento;
	
	private Instituicao instituicao;
		
	private Date dataEntrou;
	
	private Curso curso;
	
	private String profissao;
	
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
			
	
}

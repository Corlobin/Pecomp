package br.ifes.pecomp.entity;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Pessoa extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8942577475182858896L;

	private String nome;
	
	private Date dataNascimento;
	
	private Instituicao instituicao;
		
	private Date dataEntrou;
	
	private String curso;
	
	private String profissao;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Date getDataEntrou() {
		return dataEntrou;
	}

	public void setDataEntrou(Date dataEntrou) {
		this.dataEntrou = dataEntrou;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
			
	
}

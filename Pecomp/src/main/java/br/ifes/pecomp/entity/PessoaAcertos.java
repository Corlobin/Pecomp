package br.ifes.pecomp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PESSOA_ACERTOS")
public class PessoaAcertos extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1931291784749271090L;
	
	@ManyToOne
	private Pessoa pessoa;
	
	@OneToOne
	private Questao questao;
	
	@Column(name = "TB_ACERTO")
	private boolean acertou;

	
	public PessoaAcertos() {
		// TODO Auto-generated constructor stub
	}
	
	public PessoaAcertos(Pessoa pessoa, Questao questao, boolean acertou) {
		super();
		this.pessoa = pessoa;
		this.questao = questao;
		this.acertou = acertou;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public boolean isAcertou() {
		return acertou;
	}

	public void setAcertou(boolean acertou) {
		this.acertou = acertou;
	}
	
	
	
}

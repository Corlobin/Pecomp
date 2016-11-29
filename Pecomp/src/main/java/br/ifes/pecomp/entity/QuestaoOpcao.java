package br.ifes.pecomp.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity(name="TB_QST_OPCAO")
public class QuestaoOpcao extends AbstractEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9013258064615678645L;

	@Column(name="TB_QST_TEXTO")
	private String texto;
	
	@Column(name="TB_QST_GABARITO")
	private boolean gabarito;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Questao questao;
	
	public QuestaoOpcao() {
		// TODO Auto-generated constructor stub
	}
	public QuestaoOpcao(String string) {
		this.texto = string;
		// TODO Auto-generated constructor stub
	}

	public boolean getGabarito() {
		return gabarito;
	}

	public void setGabarito(boolean gabarito) {
		this.gabarito = gabarito;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
}

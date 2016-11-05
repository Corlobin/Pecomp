package br.ifes.pecomp.entity;
import javax.persistence.Entity;

@Entity
public class QuestaoOpcao extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9013258064615678645L;

	private String texto;
	
	private QuestaoOpcao resposta;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public QuestaoOpcao getResposta() {
		return resposta;
	}

	public void setResposta(QuestaoOpcao resposta) {
		this.resposta = resposta;
	}
	
	
}

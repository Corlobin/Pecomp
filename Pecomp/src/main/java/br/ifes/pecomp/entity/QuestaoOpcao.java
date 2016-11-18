package br.ifes.pecomp.entity;
import javax.persistence.Entity;

@Entity
public class QuestaoOpcao extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9013258064615678645L;

	private String texto;
	
	private boolean gabarito;
	
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
	
}

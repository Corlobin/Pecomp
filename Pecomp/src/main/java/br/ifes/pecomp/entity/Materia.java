package br.ifes.pecomp.entity;
import javax.persistence.Entity;

@Entity
public class Materia extends AbstractEntity {
	
	public Materia(String descricao) {
		super();
		this.descricao = descricao;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3140725144190525822L;
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	@Override
	public String toString() {
		return this.getDescricao();

	}
}

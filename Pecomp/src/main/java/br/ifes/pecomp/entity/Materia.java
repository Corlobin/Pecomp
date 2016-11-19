package br.ifes.pecomp.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name="TB_MATERIA")
public class Materia extends AbstractEntity {
	
	private static final long serialVersionUID = 3140725144190525822L;
	
	@Column(name="TB_MAT_DESCRICAO")
	private String descricao;

	@OneToMany(mappedBy="materia")	
	private List<Questao> questoes;
	
	public Materia(String descricao) {
		super();
		this.descricao = descricao;
	}


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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
	
	
}

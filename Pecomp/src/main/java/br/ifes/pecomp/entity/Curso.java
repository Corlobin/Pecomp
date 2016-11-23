package br.ifes.pecomp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name="TB_CURSO")
public class Curso extends AbstractEntity implements Serializable  {
		
	private static final long serialVersionUID = 1324251634604039802L;

	@Column(name="TB_CRS_NOME")
	private String Nome;
	
	@OneToMany(mappedBy="curso")
	private List<Pessoa> pessoas;
	
	public Curso(){
		super();
	}
	
	public Curso(String nome) {
		super();
		this.Nome = nome;
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
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
		Curso other = (Curso) obj;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		return true;
	}
	
	
	
}

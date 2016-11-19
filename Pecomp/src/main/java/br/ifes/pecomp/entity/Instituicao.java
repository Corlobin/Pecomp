package br.ifes.pecomp.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="TB_INSTITUICAO")
public class Instituicao extends AbstractEntity  {
	
	
	private static final long serialVersionUID = 1324251634604039802L;

	@Column(name="TB_INS_NOME")
	private String Nome;
	
	@Column(name="TB_INS_URL")
	private String InstituicaoURL;

	
	@OneToMany(mappedBy="instituicao",fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private List<Pessoa> pessoas;
		
	public Instituicao() {
		super();
	}
	
	public Instituicao(String nome) {
		super();
		this.Nome = nome;
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	
	public String getInstituicaoURL() {
		return InstituicaoURL;
	}

	public void setInstituicaoURL(String instituicaoURL) {
		InstituicaoURL = instituicaoURL;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((InstituicaoURL == null) ? 0 : InstituicaoURL.hashCode());
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
		Instituicao other = (Instituicao) obj;
		if (InstituicaoURL == null) {
			if (other.InstituicaoURL != null)
				return false;
		} else if (!InstituicaoURL.equals(other.InstituicaoURL))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		return true;
	}
	
}

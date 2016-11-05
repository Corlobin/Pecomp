package br.ifes.pecomp.entity;
import javax.persistence.Entity;

@Entity
public class Instituicao extends AbstractEntity  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1324251634604039802L;

	private String Nome;
	
	private String InstituicaoURL;

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
	
	
}

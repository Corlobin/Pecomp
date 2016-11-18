package br.ifes.pecomp.entity;

public class Curso extends AbstractEntity  {
	
	
	public Curso(String nome) {
		super();
		this.Nome = nome;
	}
	
	private static final long serialVersionUID = 1324251634604039802L;

	private String Nome;
	
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
}

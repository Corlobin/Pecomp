package br.ifes.pecomp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="TB_APOSTILA")
public class Apostila extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6634895957652106558L;
	
	@Column(name="TB_IMAGEM")
	private String imagem;
	
	private String titulo;
	
	private String URLApostila;

	public Apostila(String imagem, String titulo, String uRLLivro) {
		super();
		this.imagem = imagem;
		this.titulo = titulo;
		URLApostila = uRLLivro;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getURLApostila() {
		return URLApostila;
	}

	public void setURLApostila(String URLApostila) {
		this.URLApostila = URLApostila;
	}
	
	
}

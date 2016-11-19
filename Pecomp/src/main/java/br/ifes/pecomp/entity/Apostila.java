package br.ifes.pecomp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="TB_APOSTILA")
public class Apostila extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6634895957652106558L;
	
	@Column(name="TB_APS_IMAGEM")
	private String imagem;
	
	@Column(name="TB_APS_TITULO")
	private String titulo;
	
	@Column(name="TB_APS_URL")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((URLApostila == null) ? 0 : URLApostila.hashCode());
		result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Apostila other = (Apostila) obj;
		if (URLApostila == null) {
			if (other.URLApostila != null)
				return false;
		} else if (!URLApostila.equals(other.URLApostila))
			return false;
		if (imagem == null) {
			if (other.imagem != null)
				return false;
		} else if (!imagem.equals(other.imagem))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
}

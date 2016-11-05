package br.ifes.pecomp.entity;
import javax.persistence.Entity;

@Entity
public class Livro extends AbstractEntity  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3432744540272060552L;

	private String imagem;
	
	private String titulo;
	
	private String URLLivro;

		
	public Livro(String imagem, String titulo, String uRLLivro) {
		super();
		this.setImagem(imagem);
		this.titulo = titulo;
		URLLivro = uRLLivro;
	}

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getURLLivro() {
		return URLLivro;
	}

	public void setURLLivro(String uRLLivro) {
		URLLivro = uRLLivro;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
}

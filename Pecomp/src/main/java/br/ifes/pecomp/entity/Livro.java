package br.ifes.pecomp.entity;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="TB_LIVRO")
public class Livro extends AbstractEntity  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3432744540272060552L;

	@Column(name="TB_LVR_IMAGEM")
	private String imagem;
	
	@Column(name="TB_LVR_TITULO")
	private String titulo;
	
	@Column(name="TB_LVR_URL")
	private String URLLivro;

	public Livro(){
		super();
	}
	
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((URLLivro == null) ? 0 : URLLivro.hashCode());
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
		Livro other = (Livro) obj;
		if (URLLivro == null) {
			if (other.URLLivro != null)
				return false;
		} else if (!URLLivro.equals(other.URLLivro))
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

package br.ifes.pecomp.entity;
import javax.persistence.Entity;

@Entity
public class Video extends AbstractEntity {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 7352231341016231928L;

	private String titulo;

	private Materia materia;
		
	private String URLVideo;
	

	public Video(String titulo, Materia materia, String uRLVideo) {
		super();
		this.titulo = titulo;
		this.materia = materia;
		URLVideo = uRLVideo;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}


	public String getURLVideo() {
		return URLVideo;
	}

	public void setURLVideo(String uRLVideo) {
		URLVideo = uRLVideo;
	}
	
	
}

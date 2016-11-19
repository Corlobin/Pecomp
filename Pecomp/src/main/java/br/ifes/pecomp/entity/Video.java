package br.ifes.pecomp.entity;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="TB_VIDEO")
public class Video extends AbstractEntity {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 7352231341016231928L;

	@Column(name="TB_VID_TITULO")
	private String titulo;

	@Column(name="TB_VID_URL")
	private String URLVideo;
	

	public Video(String titulo, String uRLVideo) {
		super();
		this.titulo = titulo;
		URLVideo = uRLVideo;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getURLVideo() {
		return URLVideo;
	}

	public void setURLVideo(String uRLVideo) {
		URLVideo = uRLVideo;
	}
	
	
}

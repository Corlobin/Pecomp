package br.ifes.pecomp.bean;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.ifes.pecomp.entity.Video;
import br.ifes.pecomp.repository.VideoRepositoryImpl;


 
@ManagedBean(name="videoBean")
@ViewScoped
public class VideoBean extends AbstractBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Video> videos;
    
	private Video videoSelecionado;
     
    private VideoRepositoryImpl repository;
     
    public VideoBean(){
    	
    }
    
    @PostConstruct
    public void init() {
        repository = new VideoRepositoryImpl();
    	videos = repository.findAll();
    	videoSelecionado = new Video();
    }

    public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Video getVideoSelecionado() {
		return videoSelecionado;
	}

	public void setVideoSelecionado(Video videoSelecionado) {
		this.videoSelecionado = videoSelecionado;
	}

	public VideoRepositoryImpl getRepository() {
		return repository;
	}

	public void setRepository(VideoRepositoryImpl repository) {
		this.repository = repository;
	}
	
	public String cadastrarVideo(){
		repository.inserir(videoSelecionado);
		this.sucess("Vídeo cadastrado com sucesso!");

		return "";
	}

	
}

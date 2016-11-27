package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.ifes.pecomp.entity.Video;



public class VideoRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	public VideoRepositoryImpl() {
		super();
	}
	
	public List<Video> findAll() {
		/*
		TypedQuery<Video> query = getSession().createQuery("select obj from Video obj", Video.class);
		List<Video> videos = query.getResultList();
		return videos;
		*/
		
        List<Video> lista = new ArrayList<Video>();
        lista.add( new Video("Video 1",  "http://www.youtube.com/v/yY0PBoDlHMI"));
        lista.add( new Video("Video 2",  "http://www.youtube.com/v/yY0PBoDlHMI"));
        lista.add( new Video("Video 3",  "http://www.youtube.com/v/yY0PBoDlHMI"));
        lista.add( new Video("Video 4",  "http://www.youtube.com/v/yY0PBoDlHMI"));
        return lista;
        
    }


}

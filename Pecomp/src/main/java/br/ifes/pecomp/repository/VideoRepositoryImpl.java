package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ifes.pecomp.entity.Video;



public class VideoRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	public VideoRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Video> findAll() {
        List<Video> lista = new ArrayList<Video>();
        lista.add( new Video("Video 1", null, "http://www.youtube.com/v/yY0PBoDlHMI"));
        lista.add( new Video("Video 2", null, "http://www.youtube.com/v/yY0PBoDlHMI"));
        lista.add( new Video("Video 3", null, "http://www.youtube.com/v/yY0PBoDlHMI"));
        lista.add( new Video("Video 4", null, "http://www.youtube.com/v/yY0PBoDlHMI"));
        return lista;
    }


}

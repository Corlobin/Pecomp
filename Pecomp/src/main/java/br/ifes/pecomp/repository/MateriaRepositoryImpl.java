package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ifes.pecomp.entity.Materia;
public class MateriaRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	public MateriaRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Materia> getAll() {
        List<Materia> lista = new ArrayList<Materia>();
        lista.add( new Materia("Matematica") );
        return lista;
    }
	
	

}

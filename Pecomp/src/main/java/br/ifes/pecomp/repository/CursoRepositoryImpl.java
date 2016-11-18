package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ifes.pecomp.entity.Curso;

public class CursoRepositoryImpl extends AbstractRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public CursoRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Curso> getAll() {
        List<Curso> lista = new ArrayList<Curso>();
        lista.add( new Curso("Sistemas de Informação") );
        lista.add( new Curso("Ciência da Computação") );
        lista.add( new Curso("Engenharia da Computação") );
        return lista;
    }
}

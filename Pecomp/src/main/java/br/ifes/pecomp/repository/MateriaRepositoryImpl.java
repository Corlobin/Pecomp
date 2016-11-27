package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.ifes.pecomp.entity.Instituicao;
import br.ifes.pecomp.entity.Materia;
public class MateriaRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	public MateriaRepositoryImpl() {
		super();
	}
	
	public List<Materia> getAll() {
		/*
 		TypedQuery<Materia> query = getSession().createQuery("select obj from Materia obj", Materia.class);
		List<Materia> materias = query.getResultList();
		return materias;
		 */
		
		
        List<Materia> lista = new ArrayList<Materia>();
        lista.add( new Materia("Matematica"));
        return lista;
    }
	
	

}

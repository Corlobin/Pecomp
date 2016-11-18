package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ifes.pecomp.entity.Apostila;



public class ApostilaRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	public ApostilaRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Apostila> findAll() {
        List<Apostila> lista = new ArrayList<Apostila>();
        lista.add( new Apostila("apostila1.jpg", "Curso Pr�tico de Memoriza��o", "http://google.com.br"));
        lista.add( new Apostila("apostila2.jpg", "CIJUN T�cnico de TI", "http://google.com.br"));
        lista.add( new Apostila("apostila3.jpg", "Computa��o na Nuvem", "http://google.com.br"));         
        return lista;
    }


}

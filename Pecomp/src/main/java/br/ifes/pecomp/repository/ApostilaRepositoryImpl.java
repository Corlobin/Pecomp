package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.ifes.pecomp.entity.Apostila;
import br.ifes.pecomp.entity.Livro;



public class ApostilaRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	public ApostilaRepositoryImpl() {
		super();
	}
	
	public List<Apostila> findAll() {
		TypedQuery<Apostila> query = getSession().createQuery("select obj from TB_APOSTILA obj", Apostila.class);
		List<Apostila> apostilas = query.getResultList();
		return apostilas;
		
		/*
        List<Apostila> lista = new ArrayList<Apostila>();
        lista.add( new Apostila("apostila1.jpg", "Curso Pr�tico de Memoriza��o", "http://google.com.br"));
        lista.add( new Apostila("apostila2.jpg", "CIJUN T�cnico de TI", "http://google.com.br"));
        lista.add( new Apostila("apostila3.jpg", "Computa��o na Nuvem", "http://google.com.br"));         
        return lista;
        */
    }


}

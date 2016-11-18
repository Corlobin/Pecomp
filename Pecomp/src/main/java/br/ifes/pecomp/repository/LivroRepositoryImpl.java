package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ifes.pecomp.entity.Livro;



public class LivroRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	public LivroRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Livro> findAll() {
        List<Livro> lista = new ArrayList<Livro>();
        lista.add( new Livro("livro1.gif", "Computa��o Forense", "http://google.com.br"));
        lista.add( new Livro("livro2.jpg", "Computa��o Quantica", "http://google.com.br"));
        lista.add( new Livro("livro3.jpg", "Teoria da Computa��o", "http://google.com.br"));         
        lista.add( new Livro("livro4.jpg", "Fundamentos de Ci�ncia da Computa��o", "http://google.com.br"));         
        return lista;
    }


}

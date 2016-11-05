package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ifes.pecomp.entity.Livro;



public class LivroRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	public LivroRepositoryImpl(){
		super();
	}
	
	public List<Livro> findAll() {
        List<Livro> lista = new ArrayList<Livro>();
        lista.add( new Livro("livro1.gif", "Computação Forense", "http://google.com.br"));
        lista.add( new Livro("livro2.jpg", "Computação Quantica", "http://google.com.br"));
        lista.add( new Livro("livro3.jpg", "Teoria da Computação", "http://google.com.br"));         
        lista.add( new Livro("livro4.jpg", "Fundamentos de Ciência da Computação", "http://google.com.br"));         
        return lista;
    }


}

package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ifes.pecomp.entity.Apostila;



public class ApostilaRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	public ApostilaRepositoryImpl(){
		super();
	}
	
	public List<Apostila> findAll() {
        List<Apostila> lista = new ArrayList<Apostila>();
        lista.add( new Apostila("apostila1.jpg", "Curso Prático de Memorização", "http://google.com.br"));
        lista.add( new Apostila("apostila2.jpg", "CIJUN Técnico de TI", "http://google.com.br"));
        lista.add( new Apostila("apostila3.jpg", "Computação na Nuvem", "http://google.com.br"));         
        return lista;
    }


}

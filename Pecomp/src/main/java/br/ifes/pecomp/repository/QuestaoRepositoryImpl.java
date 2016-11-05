package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import br.ifes.pecomp.entity.Questao;

public class QuestaoRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	public QuestaoRepositoryImpl(){
		super();
	}
	
	public List<Questao> getAll() {
        List<Questao> lista = new ArrayList<Questao>();
        lista.add( new Questao(2010, "Questao 1", "", null, null, null));
        return lista;
    }
	
	
	public Questao findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Integer> getAllYears(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(new Integer(2010));
		lista.add(new Integer(2011));
		lista.add(new Integer(2012));
		lista.add(new Integer(2013));
		lista.add(new Integer(2014));
		lista.add(new Integer(2015));
		return lista;
	}

}
package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.entity.Questao;

public class QuestaoRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	public QuestaoRepositoryImpl() {
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
	
	@SuppressWarnings("unchecked")
	public List<Integer> getAllYears(){
		List<Integer> lista = this.getEntityManager().createQuery("select obj.ano from Questao obj group by obj.ano").getResultList();		
		return lista;
	}

}
package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.ifes.pecomp.entity.Materia;
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
	
	public List<Questao> getByAno(int ano){
		
		TypedQuery<Questao> query = getSession().createQuery("select obj from Questao obj where obj.ano = :ano", Questao.class);
		query.setParameter("ano", ano);
		List<Questao> questoes = query.getResultList();
		
		return questoes;		
	}
	
	public List<Questao> getByDisciplina(Materia materia){
		
		TypedQuery<Questao> query = getSession().createQuery("select obj from Questao obj where obj.materia = :materia", Questao.class);
		query.setParameter("materia", materia);
		List<Questao> questoes = query.getResultList();
		
		return questoes;		
	}
	
	public List<Questao> getByQuantidade(int quantidade){
		
		//TODO: buscar de forma aleatoria
		TypedQuery<Questao> query = getSession().createQuery("select obj from Questao obj", Questao.class);
		List<Questao> questoes = query.setMaxResults(quantidade).getResultList();
		
		return questoes;		
	}
	
	

}
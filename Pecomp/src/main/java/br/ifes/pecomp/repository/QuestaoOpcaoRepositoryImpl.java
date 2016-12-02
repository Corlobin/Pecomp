package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.entity.Questao;
import br.ifes.pecomp.entity.QuestaoOpcao;

public class QuestaoOpcaoRepositoryImpl extends AbstractRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	public QuestaoOpcaoRepositoryImpl() {
		super();
	}
	
	
	public QuestaoOpcao getById(Long id)
	{
		TypedQuery<QuestaoOpcao> query = getSession().createQuery("select obj from TB_QST_OPCAO obj where obj.id = :id", QuestaoOpcao.class);
		query.setParameter("id", id);
		QuestaoOpcao opcao = null;
		try{ 
			opcao = query.getSingleResult();
		}
		catch(Exception ex) { }
		
		return opcao;
	}
	
	public ArrayList<QuestaoOpcao> getByIdQuestao(Questao questao){
		
		TypedQuery<QuestaoOpcao> query = getSession().createQuery("select obj from TB_QST_OPCAO obj where obj.questao = :questao", QuestaoOpcao.class);
		query.setParameter("questao", questao);
		ArrayList<QuestaoOpcao> questoes = (ArrayList<QuestaoOpcao>) query.getResultList();
		
		return questoes;
		
	}
	

}

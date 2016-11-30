package br.ifes.pecomp.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.entity.Poscomp;

public class PoscompRepositoryImpl extends AbstractRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public PoscompRepositoryImpl() {
		super();
	}
	
	public Poscomp getDatas()
	{
		//TODO: trocar essa query por uma q delete todos os registros da tabela e adicione o novo
		TypedQuery<Poscomp> query = getSession().createQuery("select obj from TB_DT_POSCOMP obj order by obj.id desc", Poscomp.class);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Poscomp datas = null;
		datas = query.getSingleResult();
		
		return datas;
		
		/*
		TypedQuery<Poscomp> query = getSession().createQuery("select obj from TB_DT_POSCOMP obj order by obj.id desc limit 1", Poscomp.class);
		Poscomp datas = null;
		try{ 
			datas = query.getSingleResult();
		}
		catch(Exception ex) { }
		
		return datas;*/
	}
	
	public void inserirDatas(Poscomp poscomp){
		//int deletedCount = getSession().createQuery("DELETE FROM TB_DT_POSCOMP").executeUpdate();
		clear();
		inserir(poscomp);
	}

}

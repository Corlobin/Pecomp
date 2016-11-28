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
		TypedQuery<Poscomp> query = getSession().createQuery("select obj from TB_DT_POSCOMP obj", Poscomp.class);
		Poscomp datas = null;
		try{ 
			datas = query.getSingleResult();
		}
		catch(Exception ex) { }
		
		return datas;
	}

}

package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.ifes.pecomp.entity.Instituicao;

public class InstituicaoRepositoryImpl extends AbstractRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public InstituicaoRepositoryImpl() {
		super();
//		Instituicao inst = new Instituicao();
//		inst.setId((long) 1);
//		inst.setNome("IFES");
//		inserir(inst);

	}
	
	public Instituicao findByNome(String nome)
	{
		TypedQuery<Instituicao> query = getSession().createQuery("select obj from Instituicao obj where obj.nome = :nome", Instituicao.class);
		query.setParameter("nome", nome);
		Instituicao i = null;
		try{ 
			i = query.getSingleResult();
		}
		catch(Exception ex) { }
		
		return i;
	}
	
	public List<Instituicao> getAll() {
		TypedQuery<Instituicao> query = getSession().createQuery("select obj from Instituicao obj", Instituicao.class);
		List<Instituicao> instituicoes = query.getResultList();
		return instituicoes;
    }
}

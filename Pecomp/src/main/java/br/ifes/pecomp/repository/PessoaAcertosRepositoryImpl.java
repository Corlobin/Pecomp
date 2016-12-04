package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.entity.PessoaAcertos;

public class PessoaAcertosRepositoryImpl extends AbstractRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public List<Object[]> getAcertosInstituicaoGeral(){
		
		List<Object[]> results = getSession().createQuery("select i.Nome, count(i.id) from  PessoaAcertos pa join pa.pessoa p join p.instituicao i where pa.acertou = true group by i.id").getResultList();
		
		return results;
	}
	
	public List<Object[]> getErrosInstituicaoGeral(){
		
		List<Object[]> results = getSession().createQuery("select i.Nome, count(i.id) "
				+ "from  PessoaAcertos pa join pa.pessoa p join p.instituicao i "
				+ "where pa.acertou = false "
				+ "group by i.id").getResultList();
		
		return results;
	}
	
	public List<Object[]> getAcertosInstituicaoPorMateria(Long id){
		
		TypedQuery<Object[]> query = getSession().createQuery(
				"select m.descricao, count(m.id) "
				+ "from  PessoaAcertos pa join pa.pessoa p "
				+ "join p.instituicao i "
				+ "join pa.questao q "
				+ "join q.materia m "
				+ "where pa.acertou = true and i.id = :id "
				+ "group by m.id");
		query.setParameter("id", id);
		
		List<Object[]> results = query.getResultList();
		
		return results;
	}
	
	public List<Object[]> getErrosInstituicaoPorMateria(Long id){
		
		TypedQuery<Object[]> query = getSession().createQuery(
				"select m.descricao, count(m.id) "
				+ "from  PessoaAcertos pa join pa.pessoa p "
				+ "join p.instituicao i "
				+ "join pa.questao q "
				+ "join q.materia m "
				+ "where pa.acertou = false and i.id = :id "
				+ "group by m.id");
		query.setParameter("id", id);
		
		List<Object[]> results = query.getResultList();
		
		return results;
	}
	
	/*
	select count(m.id), m.id
	from tb_pessoa p inner join tb_pessoa_acertos pa on(p.id = pa.pessoa_id)
	inner join tb_instituicao i on(i.id = p.instituicao_id)
	inner join tb_questoes q on(q.id = pa.questao_id)
	inner join tb_materia m on(m.id = q.materia_id)
	where pa.tb_acerto = true
	and i.id = 3
	group by m.id
	*/

}

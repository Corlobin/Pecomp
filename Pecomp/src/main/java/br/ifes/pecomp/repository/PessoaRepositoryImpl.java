package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ifes.pecomp.entity.Curso;
import br.ifes.pecomp.entity.Instituicao;
import br.ifes.pecomp.entity.Pessoa;

public class PessoaRepositoryImpl extends AbstractRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public PessoaRepositoryImpl() {
		super();

	}
	
	public List<Pessoa> findAll()
	{
		TypedQuery<Pessoa> query = getSession().createQuery("select obj from Pessoa obj", Pessoa.class);
		List<Pessoa> pessoas = query.getResultList();
		return pessoas;
	}
	
	public Pessoa findByUsuarioAndSenha(String email, String senha)
	{
		TypedQuery<Pessoa> query = getSession().createQuery("select obj from Pessoa obj where obj.email = :email and obj.senha = :senha", Pessoa.class);
		query.setParameter("email", email);
		query.setParameter("senha", senha);		
		Pessoa pessoa = null;
		try{ 
			pessoa = query.getSingleResult();
		}
		catch(Exception ex) { }
		
		return pessoa;
	}
	
	public Pessoa confereEmailUnico(String email)
	{
		TypedQuery<Pessoa> query = getSession().createQuery("select obj from Pessoa obj where obj.email = :email", Pessoa.class);
		query.setParameter("email", email);
		Pessoa pessoa = null;
		try{ 
			pessoa = query.getSingleResult();
		}
		catch(Exception ex) { }
		
		return pessoa;
	}
	
	/*
	@SuppressWarnings("unchecked")
	public void testar(){
		
		Pessoa ricardo = new Pessoa();
		ricardo.setNome("ricardo");
		ricardo.setSenha("123");
		
		inserir(ricardo);
				
		Pessoa retorno = findByUsuarioAndSenha("ricardo", "123");
		
		TypedQuery<Pessoa> query = getSession().createQuery("select obj from Pessoa obj", Pessoa.class);
		List<Pessoa> pessoas = query.getResultList();
		
		System.out.println("pessoas " + pessoas);
		
	}*/
	

}

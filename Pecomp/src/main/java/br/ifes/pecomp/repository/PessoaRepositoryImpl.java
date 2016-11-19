package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.hibernate.Transaction;

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
	
	public Pessoa findByUsuarioAndSenha(String usuario, String senha)
	{
		TypedQuery<Pessoa> query = getSession().createQuery("select obj from Pessoa obj where obj.nome = :nome and obj.senha :senha ", Pessoa.class);
		query.setParameter("nome", usuario);
		query.setParameter("senha", senha);		
		
		Pessoa pessoa = query.getSingleResult();
		
		return pessoa;
	}
	
	//Implementar metodo:
	//busca usuario com nome e senha enviadas
	//se retornar um usário, acesso permitido
	//se não retornar nenhum usuário, acesso negado
	//----- public Pessoa getUsuario( String email, String senha) {
	public boolean possuiAcesso( String email, String senha) {
		return (email == "hanna@email.com") && (senha == "123");
    }

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
		
	}
	

}

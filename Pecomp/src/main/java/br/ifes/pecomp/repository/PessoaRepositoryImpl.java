package br.ifes.pecomp.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaRepositoryImpl extends AbstractRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public PessoaRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	//Implementar metodo:
	//busca usuario com nome e senha enviadas
	//se retornar um usário, acesso permitido
	//se não retornar nenhum usuário, acesso negado
	//----- public Pessoa getUsuario( String email, String senha) {
	public boolean possuiAcesso( String email, String senha) {
		return (email == "hanna@email.com") && (senha == "123");
    }
	
	public void testar(){
		EntityManagerFactory factory = Persistence.
		          createEntityManagerFactory("pecomp");

	    factory.close();

	
	}
	

}

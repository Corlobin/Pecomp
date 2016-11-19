package br.ifes.pecomp.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ifes.pecomp.entity.Pessoa;


public class AbstractRepository 
{
	//private static SessionFactory sessionFactory = buildSessionFactory();
	
	private EntityManager entityManager;

	public AbstractRepository() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Pecomp");
		this.entityManager = factory.createEntityManager();
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public Session getSession() {
		return (Session) entityManager.getDelegate();
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		return getEntityManager().getCriteriaBuilder();
	}

	public <T> void persist(T entidade) {
		entityManager.persist(entidade);
	}

	public <T> T merge(T entidade) {
		return entityManager.merge(entidade);
	}

	public <T> void remove(T entidade) {
		entityManager.remove(entidade);
	}

	public <T> void clear() {
		entityManager.clear();
	}

	public <T> T find(Class<T> tipo, Serializable id) {
		return entityManager.find(tipo, id);
	}

	public <T> T getReference(Class<T> tipo, Serializable id) {
		return entityManager.getReference(tipo, id);
	}

	public <T> boolean contains(T entidade) {
		return entityManager.contains(entidade);
	}
	
	public <T> void inserir(T entidade) {
		Transaction t = getSession().beginTransaction();
		getSession().save(entidade);
		t.commit();
	}
	
	/*
	private static SessionFactory buildSessionFactory()
	{
		return null;
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	public static void close()
	{
		getSessionFactory().close();
	}
	*/
	

}

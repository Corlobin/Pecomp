package br.ifes.pecomp.repository;

import org.hibernate.SessionFactory;


public class AbstractRepository 
{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}

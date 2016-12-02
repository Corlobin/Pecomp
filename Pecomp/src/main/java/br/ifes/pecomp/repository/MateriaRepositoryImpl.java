package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.ifes.pecomp.entity.Instituicao;
import br.ifes.pecomp.entity.Materia;
import br.ifes.pecomp.entity.Pessoa;
public class MateriaRepositoryImpl extends AbstractRepository implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	public MateriaRepositoryImpl() {
		super();
	}
	
	public Materia getByDescricao(String descricao){
		TypedQuery<Materia> query = getSession().createQuery("select obj from TB_MATERIA obj where obj.descricao = :descricao", Materia.class);
		query.setParameter("descricao", descricao);
		Materia materia = null;
		try{ 
			materia = query.getSingleResult();
		}
		catch(Exception ex) { }
		
		return materia;
	}
	
	public Materia getById(Long id){
		TypedQuery<Materia> query = getSession().createQuery("select obj from TB_MATERIA obj where obj.id = :id", Materia.class);
		query.setParameter("id", id);
		Materia materia = null;
		try{ 
			materia = query.getSingleResult();
		}
		catch(Exception ex) { }
		
		return materia;
	}
	
	public List<Materia> getAll() {
		
 		TypedQuery<Materia> query = getSession().createQuery("select obj from TB_MATERIA obj", Materia.class);
		List<Materia> materias = query.getResultList();
		return materias;
		 
		
		/*
        List<Materia> lista = new ArrayList<Materia>();
        lista.add( new Materia("Matematica"));
        return lista;
        */
    }
	
	

}

package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.hibernate.sql.Insert;

import br.ifes.pecomp.entity.Curso;
import br.ifes.pecomp.entity.Instituicao;

public class CursoRepositoryImpl extends AbstractRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public CursoRepositoryImpl() {
		super();
		/*
		Curso curso = new Curso();
		curso.setId((long) 1);
		curso.setNome("Sistemas de Informação");
		inserir(curso);
		*/
	}
	
	public List<Curso> getAll() {
		TypedQuery<Curso> query = getSession().createQuery("select obj from TB_CURSO obj", Curso.class);
		List<Curso> cursos = query.getResultList();
		return cursos;
		
		/*
		List<Curso> lista = new ArrayList<Curso>();
        lista.add( new Curso("Sistemas de Informação") );
        lista.add( new Curso("Ciência da Computação") );
        lista.add( new Curso("Engenharia da Computação") );
        return lista;
        */
    }
}

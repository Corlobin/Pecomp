package br.ifes.pecomp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.ifes.pecomp.entity.Instituicao;

public class InstituicaoRepositoryImpl extends AbstractRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public InstituicaoRepositoryImpl() {
		super();
	}
	
	public List<Instituicao> getAll() {
        List<Instituicao> lista = new ArrayList<Instituicao>();
        lista.add( new Instituicao("IFES") );
        lista.add( new Instituicao("UFES") );
        lista.add( new Instituicao("UCL") );
        lista.add( new Instituicao("UVV") );
        lista.add( new Instituicao("FAESA") );
        return lista;
    }
}

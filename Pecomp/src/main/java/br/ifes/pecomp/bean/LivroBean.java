package br.ifes.pecomp.bean;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.ifes.pecomp.entity.Livro;
import br.ifes.pecomp.repository.LivroRepositoryImpl;


 
@ManagedBean(name="livroBean")
@ViewScoped
public class LivroBean extends AbstractBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Livro> livros;
    
    private Livro livroSelecionado;
     
    private LivroRepositoryImpl repository;
    
     
    @PostConstruct
    public void init() {
        repository = new LivroRepositoryImpl();
    	livros = repository.findAll();
    }

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Livro getLivroSelecionado() {
		return livroSelecionado;
	}

	public void setLivroSelecionado(Livro livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}

	public LivroRepositoryImpl getRepository() {
		return repository;
	}

	public void setRepository(LivroRepositoryImpl repository) {
		this.repository = repository;
	}
 
	
}

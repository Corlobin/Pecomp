package br.ifes.pecomp.bean;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.ifes.pecomp.entity.Apostila;
import br.ifes.pecomp.repository.ApostilaRepositoryImpl;


 
@ManagedBean(name="apostilaBean")
@ViewScoped
public class ApostilaBean extends AbstractBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Apostila> apostilas;
    
    private Apostila apostilaSelecionada;
     
    private ApostilaRepositoryImpl repository;
     
    
    @PostConstruct
    public void init() {
        repository = new ApostilaRepositoryImpl();
    	apostilas = repository.findAll();
    }
 
    public List<Apostila> getApostilas() {
        return apostilas;
    }
 
    public Apostila getApostilaSelecionada() {
        return apostilaSelecionada;
    }
 
    public void setApostilaSelecionada(Apostila apostilaSelecionada) {
        this.apostilaSelecionada = apostilaSelecionada;
    }
	
}

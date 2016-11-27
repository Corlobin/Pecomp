package br.ifes.pecomp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.primefaces.event.FlowEvent;

import br.ifes.pecomp.entity.Materia;
import br.ifes.pecomp.entity.Questao;
import br.ifes.pecomp.entity.QuestaoOpcao;
import br.ifes.pecomp.repository.MateriaRepositoryImpl;
import br.ifes.pecomp.repository.PessoaRepositoryImpl;

@ManagedBean(name="userWizard")
public class UserWizard extends AbstractBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private Questao questao = new Questao();
	private List<Materia> listMaterias;
	
	@PersistenceContext
	private EntityManager entity;
	
	@Inject
	private transient PessoaRepositoryImpl pessoaRepository;
	
	private MateriaRepositoryImpl materiaRepository;
    
	public UserWizard()
	{
		questao = new Questao();
		questao.inicializaQuestoes();
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		/*
		if( pessoaRepository != null) {
			pessoaRepository.testar();
		}
		else {
			System.out.println("nulo ..");
		}
		*/
	}
	
	@PostConstruct
    public void init() {
		materiaRepository = new MateriaRepositoryImpl();
		listMaterias = materiaRepository.getAll();
	}
     
    public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
     
    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

}

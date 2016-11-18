package br.ifes.pecomp.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.primefaces.event.FlowEvent;

import br.ifes.pecomp.entity.Questao;
import br.ifes.pecomp.entity.QuestaoOpcao;
import br.ifes.pecomp.entity.User;
import br.ifes.pecomp.repository.PessoaRepositoryImpl;

@ManagedBean(name="userWizard")
@ViewScoped
public class UserWizard implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private Questao questao = new Questao();
	
	private EntityManager entityManager;
    
	public UserWizard()
	{
		questao = new Questao();
		questao.inicializaQuestoes();
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		PessoaRepositoryImpl repo = new PessoaRepositoryImpl(entityManager);
		repo.testar();
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

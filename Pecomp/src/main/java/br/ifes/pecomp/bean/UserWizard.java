package br.ifes.pecomp.bean;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.primefaces.event.FlowEvent;

import br.ifes.pecomp.entity.Materia;
import br.ifes.pecomp.entity.Questao;
import br.ifes.pecomp.entity.QuestaoOpcao;
import br.ifes.pecomp.repository.MateriaRepositoryImpl;
import br.ifes.pecomp.repository.PessoaRepositoryImpl;
import br.ifes.pecomp.repository.QuestaoOpcaoRepositoryImpl;
import br.ifes.pecomp.repository.QuestaoRepositoryImpl;

@ManagedBean(name="userWizard")
@ViewScoped
public class UserWizard extends AbstractBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private Questao questao = new Questao();
	private List<Materia> listMaterias;
	private Materia materia;
	
	@PersistenceContext
	private EntityManager entity;
	
	@Inject
	private transient PessoaRepositoryImpl pessoaRepository;
	private MateriaRepositoryImpl materiaRepository;
	private QuestaoRepositoryImpl questaoRepository;
	private QuestaoOpcaoRepositoryImpl questaoOpcaoRepository;
    
	public UserWizard()
	{
		questao = new Questao();
		questao.inicializaQuestoes();
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
		questao.getOpcoes().add(new QuestaoOpcao(""));
	}
	
	@PostConstruct
    public void init() {
		materiaRepository = new MateriaRepositoryImpl();
		listMaterias = materiaRepository.getAll();
		questaoRepository = new QuestaoRepositoryImpl();
		questaoOpcaoRepository = new QuestaoOpcaoRepositoryImpl();
		materia = new Materia();
	}
	
     
    public List<Materia> getListMaterias() {
		return listMaterias;
	}

	public void setListMaterias(List<Materia> listMaterias) {
		this.listMaterias = listMaterias;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

    public String save() { 
    	
    	materia = materiaRepository.getByDescricao(materia.getDescricao());
    	questao.setMateria(materia);
    	questaoRepository.inserir(questao);

    	ajustaOpcoes();
    	
    	for(QuestaoOpcao o: questao.getOpcoes()){
    		o.setQuestao(questao);
    		questaoOpcaoRepository.inserir(o);    	
    	}
    	
        this.sucess("Questão cadastrada com sucesso!");
        
        return "";
    }
    
    public void ajustaOpcoes(){
    	Iterator<QuestaoOpcao> it = questao.getOpcoes().iterator();

        while(it.hasNext()){
            if(it.next().getTexto().equals("")){
                it.remove();
            }
        }
                
    }
     
     
    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

}

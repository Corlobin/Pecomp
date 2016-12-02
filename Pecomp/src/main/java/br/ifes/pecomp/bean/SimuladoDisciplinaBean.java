package br.ifes.pecomp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.ifes.pecomp.entity.Materia;
import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.entity.PessoaAcertos;
import br.ifes.pecomp.entity.Questao;
import br.ifes.pecomp.entity.QuestaoOpcao;
import br.ifes.pecomp.repository.MateriaRepositoryImpl;
import br.ifes.pecomp.repository.PessoaAcertosRepositoryImpl;
import br.ifes.pecomp.repository.QuestaoOpcaoRepositoryImpl;
import br.ifes.pecomp.repository.QuestaoRepositoryImpl;

@ManagedBean(name="simuladoDisciplinaBean")
@ViewScoped
public class SimuladoDisciplinaBean extends AbstractBean implements Serializable  {
	 
	private static final long serialVersionUID = 1L;
	
	
	private List<Questao> questoes;
	
	private Long idMateriaSelecionada;
	
	private Materia materia;
	
	private List<Materia> materias;
	
	private LoginBean loginBean;
		
	private QuestaoRepositoryImpl questaoRepository;
	
	private QuestaoOpcaoRepositoryImpl questaoOpcaoRepository;
	
	private PessoaAcertosRepositoryImpl pessoaAcertosRepository;
	
	private MateriaRepositoryImpl materiaRepository;
	
	private List<ArrayList<QuestaoOpcao>> alternativas; 
	
	private Long alternativaSelecionada;
	
	private boolean selecaoAtiva;
	
	
	public SimuladoDisciplinaBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		loginBean = (LoginBean) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "loginBean");
	}


	@PostConstruct
    public void init() {
		    	
		questaoRepository = new QuestaoRepositoryImpl();
		questaoOpcaoRepository = new QuestaoOpcaoRepositoryImpl();
		materiaRepository = new MateriaRepositoryImpl();
		pessoaAcertosRepository = new PessoaAcertosRepositoryImpl();
    	alternativas = new ArrayList<ArrayList<QuestaoOpcao>>();
    	
    	materias = materiaRepository.getAll();
		questoes = questaoRepository.getAll();
    	
    }
	
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Long getIdMateriaSelecionada() {
		return idMateriaSelecionada;
	}

	public void setIdMateriaSelecionada(Long idMateriaSelecionada) {
		this.idMateriaSelecionada = idMateriaSelecionada;
	}

	public List<ArrayList<QuestaoOpcao>> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<ArrayList<QuestaoOpcao>> alternativas) {
		this.alternativas = alternativas;
	}

	public Long getAlternativaSelecionada() {
		return alternativaSelecionada;
	}

	public void setAlternativaSelecionada(Long alternativaSelecionada) {
		this.alternativaSelecionada = alternativaSelecionada;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public List<Materia> getMaterias() {
		
		return materiaRepository.getAll();
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public QuestaoRepositoryImpl getQuestaoRepository() {
		return questaoRepository;
	}


	public void setQuestaoRepository(QuestaoRepositoryImpl questaoRepository) {
		this.questaoRepository = questaoRepository;
	}


	public MateriaRepositoryImpl getMateriaRepository() {
		return materiaRepository;
	}


	public void setMateriaRepository(MateriaRepositoryImpl materiaRepository) {
		this.materiaRepository = materiaRepository;
	}

	public boolean isSelecaoAtiva() {
		return selecaoAtiva;
	}

	public void setSelecaoAtiva(boolean selecaoAtiva) {
		this.selecaoAtiva = selecaoAtiva;
	}


	public void enviarResposta(ActionEvent actionEvent){
		
		if(alternativaSelecionada != null){
			QuestaoOpcao opcaoSel = questaoOpcaoRepository.getById(alternativaSelecionada);
			Questao questaoRespondida = opcaoSel.getQuestao();
			Pessoa usuario = loginBean.getUsuario();
			
			PessoaAcertos correcao = new PessoaAcertos(usuario, questaoRespondida, opcaoSel.getGabarito());
			pessoaAcertosRepository.inserir(correcao);		
			
			//validacoes nao estao aparecendo na tela
			if(opcaoSel.getGabarito()){
				this.sucess("Arrasou queridaaa!!");
			}else{
				this.error("Que burro! Dá zero p ele!!!");
			}
		}
		
		this.error("Selecione uma alternativa");
		
	}
	
	public void buscarQuestoesDisciplina(ActionEvent actionEvent){
		
		System.out.println("id materiaaaaaaaaaaaaaaaaaaaaaaa: " + idMateriaSelecionada );
		
		questoes = null;
		
		Materia mat = materiaRepository.getById(idMateriaSelecionada);
		questoes = questaoRepository.getByDisciplina(mat);
		
		for(Questao q: questoes){
			ArrayList<QuestaoOpcao> l_questao_opcao = questaoOpcaoRepository.getByIdQuestao(q);
			alternativas.add(l_questao_opcao);
			q.setOpcoes(l_questao_opcao);
		}
		
		selecaoAtiva = true;
		
	}


	

}

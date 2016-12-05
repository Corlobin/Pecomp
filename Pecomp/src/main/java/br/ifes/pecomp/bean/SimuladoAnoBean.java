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

@ManagedBean(name="simuladoAnoBean")
@ViewScoped
public class SimuladoAnoBean extends AbstractBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> anos;
	
	private List<Questao> questoes;
	
	private Integer anoSelecionado;
	
	private Materia materia;
	
	private LoginBean loginBean;
		
	private QuestaoRepositoryImpl questaoRepository;
	
	private QuestaoOpcaoRepositoryImpl questaoOpcaoRepository;
	
	private PessoaAcertosRepositoryImpl pessoaAcertosRepository;
	
	private MateriaRepositoryImpl materiaRepository;
	
	private Integer quantidadeQuestoesAleatorias;
	
	private List<ArrayList<QuestaoOpcao>> alternativas; 
	
	private String pergunta;
	
	private Long alternativaSelecionada;
	
	private boolean selecaoAtiva;
	
	
	public SimuladoAnoBean() {
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
    	
		questoes = questaoRepository.getAll();

    	anos = questaoRepository.getAllYears();
    	
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

	public List<Integer> getAnos() {
		return anos;
	}

	public Integer getAno() {
		return anoSelecionado;
	}

	public void setAno(Integer anoSelecionado) {
		this.anoSelecionado = anoSelecionado;
	}

	public List<Materia> getMaterias() {
		
		return materiaRepository.getAll();
	}

	public Integer getQuantidadeQuestoesAleatorias() {
		return quantidadeQuestoesAleatorias;
	}

	public void setQuantidadeQuestoesAleatorias(Integer quantidadeQuestoesAleatorias) {
		this.quantidadeQuestoesAleatorias = quantidadeQuestoesAleatorias;
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

	public String getPergunta() {
		return pergunta;
	}


	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}


	public void setAnos(List<Integer> anos) {
		this.anos = anos;
	}
	

	public Integer getAnoSelecionado() {
		return anoSelecionado;
	}


	public void setAnoSelecionado(Integer anoSelecionado) {
		this.anoSelecionado = anoSelecionado;
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
				this.sucess("Resposta coreta!");
			}else{
				this.error("Resposta errada!");
			}
		}else{
			this.error("Selecione uma alternativa");
		}
		
	}
	
	public void buscarQuestoesAno(ActionEvent actionEvent){
		
		questoes = null;
		questoes = questaoRepository.getByAno(anoSelecionado);
		
		for(Questao q: questoes){
			ArrayList<QuestaoOpcao> l_questao_opcao = questaoOpcaoRepository.getByIdQuestao(q);
			alternativas.add(l_questao_opcao);
			q.setOpcoes(l_questao_opcao);
		}
		
		selecaoAtiva = true;
		
	}

}

package br.ifes.pecomp.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.ifes.pecomp.entity.Materia;
import br.ifes.pecomp.entity.Questao;
import br.ifes.pecomp.repository.MateriaRepositoryImpl;
import br.ifes.pecomp.repository.QuestaoRepositoryImpl;

@ManagedBean(name="simuladoBean")
@ViewScoped
public class SimuladoBean extends AbstractBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> anos;
	
	private List<Questao> questoes;
	
	private Integer ano;
	
	private Materia materia;
		
	private QuestaoRepositoryImpl questaoRepository;
	
	private MateriaRepositoryImpl materiaRepository;
	
	private Integer quantidadeQuestoesAleatorias;
	
	private ArrayList<String> perguntas;
	
	private String pergunta;
	
	private boolean selecaoAtiva;
	
	@PostConstruct
    public void init() {
		    	
		questaoRepository = new QuestaoRepositoryImpl();
		materiaRepository = new MateriaRepositoryImpl();
    	perguntas = new ArrayList<String>();
    	
		questoes = questaoRepository.getAll();

    	anos = questaoRepository.getAllYears();
    	
    	quantidadeQuestoesAleatorias = 0;
    	perguntas.add("Aproximado");
    	perguntas.add("Divis�o-e-conquista");
    	perguntas.add("Guloso");
    	perguntas.add("Recursivo");
    	perguntas.add("Tentativa e erro");
    	
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
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
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


	public ArrayList<String> getPerguntas() {
		return perguntas;
	}


	public void setPerguntas(ArrayList<String> perguntas) {
		this.perguntas = perguntas;
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


	public boolean isSelecaoAtiva() {
		return selecaoAtiva;
	}


	public void setSelecaoAtiva(boolean selecaoAtiva) {
		this.selecaoAtiva = selecaoAtiva;
	}
	
}
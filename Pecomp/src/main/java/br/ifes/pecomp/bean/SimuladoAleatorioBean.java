package br.ifes.pecomp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.entity.PessoaAcertos;
import br.ifes.pecomp.entity.Questao;
import br.ifes.pecomp.entity.QuestaoOpcao;
import br.ifes.pecomp.repository.PessoaAcertosRepositoryImpl;
import br.ifes.pecomp.repository.QuestaoOpcaoRepositoryImpl;
import br.ifes.pecomp.repository.QuestaoRepositoryImpl;

@ManagedBean(name="simuladoAleatorioBean")
@ViewScoped
public class SimuladoAleatorioBean extends AbstractBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private List<Questao> questoes;
	
	private LoginBean loginBean;
		
	private QuestaoRepositoryImpl questaoRepository;
	
	private QuestaoOpcaoRepositoryImpl questaoOpcaoRepository;
	
	private PessoaAcertosRepositoryImpl pessoaAcertosRepository;
	
	private Integer quantidadeQuestoesAleatorias;
	
	
	
	private Long alternativaSelecionada;
	
	private boolean selecaoAtiva;
	
	
	public SimuladoAleatorioBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		loginBean = (LoginBean) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "loginBean");
	}


	@PostConstruct
    public void init() {
		    	
		questaoRepository = new QuestaoRepositoryImpl();
		questaoOpcaoRepository = new QuestaoOpcaoRepositoryImpl();
		pessoaAcertosRepository = new PessoaAcertosRepositoryImpl();
    	
    	
		questoes = questaoRepository.getAll();
    	
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

	public Integer getQuantidadeQuestoesAleatorias() {
		return quantidadeQuestoesAleatorias;
	}

	public void setQuantidadeQuestoesAleatorias(Integer quantidadeQuestoesAleatorias) {
		this.quantidadeQuestoesAleatorias = quantidadeQuestoesAleatorias;
	}


	public QuestaoRepositoryImpl getQuestaoRepository() {
		return questaoRepository;
	}


	public void setQuestaoRepository(QuestaoRepositoryImpl questaoRepository) {
		this.questaoRepository = questaoRepository;
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
	
	public void buscarQuestoesAleatorias(ActionEvent actionEvent){
		questoes = null;
		questoes = questaoRepository.getByQuantidade(quantidadeQuestoesAleatorias);
		
		for(Questao q: questoes){
			ArrayList<QuestaoOpcao> l_questao_opcao = questaoOpcaoRepository.getByIdQuestao(q);
			q.setOpcoes(l_questao_opcao);
		}
		
		selecaoAtiva = true;
		
	}

}

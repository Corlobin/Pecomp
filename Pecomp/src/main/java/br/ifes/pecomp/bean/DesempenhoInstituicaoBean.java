package br.ifes.pecomp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.ifes.pecomp.entity.Instituicao;
import br.ifes.pecomp.entity.PessoaAcertos;
import br.ifes.pecomp.repository.InstituicaoRepositoryImpl;
import br.ifes.pecomp.repository.PessoaAcertosRepositoryImpl;


@ManagedBean(name="desempenhoInstituicaoBean")
@ViewScoped
public class DesempenhoInstituicaoBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = -5178777946416459173L;
	
	private BarChartModel animatedModel1;
	
	private LineChartModel graficoInstituicao;
	
	private PessoaAcertosRepositoryImpl pessoaAcertosRepository;
	
	private Instituicao instituicao;
	
	private Long idInstituicaoSelecionada;
	
	private List<Instituicao> listInstituicao;
	
	private InstituicaoRepositoryImpl instituicoesRepository;
 
	private boolean selecaoAtiva;
	
    @PostConstruct
    public void init() {
    	pessoaAcertosRepository = new PessoaAcertosRepositoryImpl();
        createAnimatedModels();
        
        instituicoesRepository = new InstituicaoRepositoryImpl();
		listInstituicao = instituicoesRepository.getAll();
		instituicao = new Instituicao();
    }
    
    
    public Long getIdInstituicaoSelecionada() {
		return idInstituicaoSelecionada;
	}
    
	public void setIdInstituicaoSelecionada(Long idInstituicaoSelecionada) {
		this.idInstituicaoSelecionada = idInstituicaoSelecionada;
	}

	public LineChartModel getGraficoInstituicao() {
		return graficoInstituicao;
	}
    
	public void setGraficoInstituicao(LineChartModel graficoInstituicao) {
		this.graficoInstituicao = graficoInstituicao;
	}

	public boolean isSelecaoAtiva() {
		return selecaoAtiva;
	}

	public void setSelecaoAtiva(boolean selecaoAtiva) {
		this.selecaoAtiva = selecaoAtiva;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public List<Instituicao> getListInstituicao() {
		return listInstituicao;
	}

	public void setListInstituicao(List<Instituicao> listInstituicao) {
		this.listInstituicao = listInstituicao;
	}

	public BarChartModel getAnimatedModel1() {
        return animatedModel1;
    }
  
    private void createAnimatedModels() {
        animatedModel1 = initBarModel();
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        model.setTitle("Todas as Instituições");
        model.setAnimate(true);
        model.setLegendPosition("ne");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(20);
        
        ChartSeries acertos = new ChartSeries();
        acertos.setLabel("Acertos");
       
        //busca no banco acertos por instituicao
        List<Object[]> acertosInstituicao = pessoaAcertosRepository.getAcertosInstituicaoGeral();
    	
		for (Object[] result : acertosInstituicao) {
		    String nomeInstituicao = (String) result[0];
		    int count = ((Number) result[1]).intValue();
		    acertos.set(nomeInstituicao, count);
		}
		
		ChartSeries erros = new ChartSeries();
        erros.setLabel("Erros");
		
        //busca no banco erros por instituicao
        List<Object[]> errosInstituicao = pessoaAcertosRepository.getErrosInstituicaoGeral();
    	
		for (Object[] result : errosInstituicao) {
		    String nomeInstituicao = (String) result[0];
		    int count = ((Number) result[1]).intValue();
		    erros.set(nomeInstituicao, count);
		}
        
        model.addSeries(acertos);
        model.addSeries(erros);
         
        return model;
    }
    
    private LineChartModel initLinearPorInsituicao() {
        this.instituicao = instituicoesRepository.getById(idInstituicaoSelecionada);
    	
    	LineChartModel model = new LineChartModel();
        
        model.setStacked(true);
        model.setShowPointLabels(true);
        model.setTitle(instituicao.getNome());
        model.setLegendPosition("ne");
        
        Axis xAxis = new CategoryAxis("Disciplinas");
        model.getAxes().put(AxisType.X, xAxis);
        
        xAxis.setLabel("Disciplinas");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(20);

        
        LineChartSeries acertos = new LineChartSeries();
        acertos.setLabel("Acertos");
        
        List<Object[]> acertosInstituicaoMat = pessoaAcertosRepository.getAcertosInstituicaoPorMateria(idInstituicaoSelecionada);
    	
  		for (Object[] result : acertosInstituicaoMat) {
  		    String nomeInstituicao = (String) result[0];
  		    int count = ((Number) result[1]).intValue();
  		    acertos.set(nomeInstituicao, count);
  		}
  		
        LineChartSeries erros = new LineChartSeries();
        erros.setLabel("Erros");
        
        List<Object[]> errosInstituicaoMat = pessoaAcertosRepository.getErrosInstituicaoPorMateria(idInstituicaoSelecionada);
    	
  		for (Object[] result : errosInstituicaoMat) {
  		    String nomeInstituicao = (String) result[0];
  		    int count = ((Number) result[1]).intValue();
  		  erros.set(nomeInstituicao, count);
  		}
 
        model.addSeries(acertos);
        model.addSeries(erros);
        
        idInstituicaoSelecionada = null;
         
        return model;
    
    }
    
    public void buscarGraficoPorInstituicao(ActionEvent actionEvent){
    	
    	if(idInstituicaoSelecionada != null){
    		selecaoAtiva = true;	
    		graficoInstituicao =  initLinearPorInsituicao();
    	}else{
    		selecaoAtiva = false;
    	}
    }

}

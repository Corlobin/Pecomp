package br.ifes.pecomp.bean;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import br.ifes.pecomp.entity.Materia;
import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.repository.MateriaRepositoryImpl;
import br.ifes.pecomp.repository.PessoaAcertosRepositoryImpl;
 
@ManagedBean(name="desempenhoEstudanteBean")
public class DesempenhoEstudanteBean extends AbstractBean implements Serializable {
 
	private static final long serialVersionUID = -5178777946416459173L;
	
	
	private LineChartModel animatedModel1;
    
	private BarChartModel animatedModel2;
	
	private BarChartModel animatedModel3;
	
	private List<Materia> listMaterias;
	
	private MateriaRepositoryImpl materiaRepository;
	
	private PessoaAcertosRepositoryImpl pessoaAcertosRepository;
	
	private LoginBean loginBean;
	
	
	public DesempenhoEstudanteBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		loginBean = (LoginBean) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "loginBean");
	}
 
    @PostConstruct
    public void init() {
    	pessoaAcertosRepository = new PessoaAcertosRepositoryImpl();
    	materiaRepository = new MateriaRepositoryImpl();
		listMaterias = materiaRepository.getAll();
		
        createAnimatedModels();
    }
 
    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
    
    public BarChartModel getAnimatedModel3() {
        return animatedModel3;
    }
 
    private void createAnimatedModels() {
        //animatedModel1 = initLinearModel(); 
        animatedModel3 = initBarModelIndividual();
        animatedModel2 = initBarModel();
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        model.setTitle("Desempenho geral");
        model.setAnimate(true);
        model.setLegendPosition("ne");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(20);
        
        ChartSeries acertos = new ChartSeries();
        acertos.setLabel("Acertos");
        
        ChartSeries erros = new ChartSeries();
        erros.setLabel("Erros");
        
        for (int i = 0; i < listMaterias.size(); i++) {
       
        	Long acertosMateria = pessoaAcertosRepository.getAcertosMateriaGeral(listMaterias.get(i).getId());
        	acertos.set(listMaterias.get(i).getDescricao(), acertosMateria);
        	
        	Long errosMateria = pessoaAcertosRepository.getErrosMateriaGeral(listMaterias.get(i).getId());
        	erros.set(listMaterias.get(i).getDescricao(), errosMateria);
        }
    		
        
        model.addSeries(acertos);
        model.addSeries(erros);
         
        return model;
    }
    
    private BarChartModel initBarModelIndividual() {
        BarChartModel model = new BarChartModel();
        model.setTitle("Desempenho individual");
        model.setAnimate(true);
        model.setLegendPosition("ne");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(20);
        
        Pessoa usuario = loginBean.getUsuario();
        
        ChartSeries acertos = new ChartSeries();
        acertos.setLabel("Acertos");
        
        ChartSeries erros = new ChartSeries();
        erros.setLabel("Erros");
        
        for (int i = 0; i < listMaterias.size(); i++) {
       
        	Long acertosMat = pessoaAcertosRepository.getAcertosMateriaIndividual(listMaterias.get(i).getId(), usuario.getId());
        	acertos.set(listMaterias.get(i).getDescricao(), acertosMat);
        	
        	Long errosMat = pessoaAcertosRepository.getErrosMateriaIndividual(listMaterias.get(i).getId(), usuario.getId());
        	erros.set(listMaterias.get(i).getDescricao(), errosMat);
        }
    		
        
        model.addSeries(acertos);
        model.addSeries(erros);
         
        return model;
    }
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        
        model.setStacked(true);
        model.setShowPointLabels(true);
        model.setTitle("Matematica");
        model.setLegendPosition("ne");
        
        Axis xAxis = new CategoryAxis("Anos");
        model.getAxes().put(AxisType.X, xAxis);
        
        xAxis.setLabel("Quantidade");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(20);

        
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Acertos");
        series1.set("2014", 50);
        series1.set("2013", 40);
        series1.set("2012", 30);
        series1.set("2011", 20);
        series1.set("2010", 10);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Erros"); 
        series2.set("2014", 20);
        series2.set("2013", 19);
        series2.set("2012", 16);
        series2.set("2011", 14);
        series2.set("2010", 12);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
    
}
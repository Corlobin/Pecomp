package br.ifes.pecomp.bean;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean(name="desempenhoEstudanteBean")
public class DesempenhoEstudanteBean extends AbstractBean implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -5178777946416459173L;
	
	
	private LineChartModel animatedModel1;
    private BarChartModel animatedModel2;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    private void createAnimatedModels() {
        animatedModel1 = initLinearModel();

        
        animatedModel2 = initBarModel();
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        model.setTitle("Todas as disciplinas");
        model.setAnimate(true);
        model.setLegendPosition("ne");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
    	
        ChartSeries acertos = new ChartSeries();
        acertos.setLabel("Acertos");
        acertos.set("2004", 120);
        acertos.set("2005", 100);
        acertos.set("2006", 44);
        acertos.set("2007", 150);
        acertos.set("2008", 25);
 
        ChartSeries erros = new ChartSeries();
        erros.setLabel("Erros");
        erros.set("2004", 52);
        erros.set("2005", 60);
        erros.set("2006", 110);
        erros.set("2007", 135);
        erros.set("2008", 120);
 
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
        yAxis.setMax(100);

        
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
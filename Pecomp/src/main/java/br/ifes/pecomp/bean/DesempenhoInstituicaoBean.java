package br.ifes.pecomp.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;


@ManagedBean(name="desempenhoInstituicaoBean")
public class DesempenhoInstituicaoBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = -5178777946416459173L;
	
	private BarChartModel animatedModel1;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
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

}

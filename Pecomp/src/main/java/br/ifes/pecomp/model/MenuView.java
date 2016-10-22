package br.ifes.pecomp.model;

 
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
 
@ManagedBean
public class MenuView {
     
    private MenuModel model;
 
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu menuInicio = new DefaultSubMenu("Inicio");
                 
        DefaultMenuItem item = new DefaultMenuItem("Noticias");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("fa-newspaper o");
        menuInicio.addElement(item);
         
        model.addElement(menuInicio);
         
        //Second submenu
        DefaultSubMenu menuSimulado = new DefaultSubMenu("Simulados");
 
        item = new DefaultMenuItem("Simulado por disciplina");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuView.save}");
        item.setUpdate("messages");
        menuSimulado.addElement(item);
         
        item = new DefaultMenuItem("Simulado por ano");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        menuSimulado.addElement(item);
         
        item = new DefaultMenuItem("Simulado aleatório");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuView.redirect}");
        menuSimulado.addElement(item);
 
        model.addElement(menuSimulado);

    
        DefaultSubMenu menuConteudos = new DefaultSubMenu("Conteudos");
        
        item = new DefaultMenuItem("Livros");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("fa-book");
        menuConteudos.addElement(item);
         
        item = new DefaultMenuItem("Apostilas");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("fa-book");
        menuConteudos.addElement(item);

        item = new DefaultMenuItem("Videos");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("fa-video-camera");
        menuConteudos.addElement(item);

        model.addElement(menuConteudos);


        DefaultSubMenu menuDesempenho = new DefaultSubMenu("Desempenho");
        
        item = new DefaultMenuItem("Estudantes");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("fa-line-chart");
        menuDesempenho.addElement(item);
         
        item = new DefaultMenuItem("Escolas");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("fa-bar-chart-o");
        menuDesempenho.addElement(item);

        model.addElement(menuDesempenho);

        DefaultMenuItem menuSair = new DefaultMenuItem("Sair");
        menuSair.setIcon("fa-arrow-circle-left");
        menuSair.setUrl("http://google.com.br");
        menuDesempenho.addElement(menuSair);
        

    
    }
 
    public MenuModel getModel() {
        return model;
    }   
     
    public void save() {
        addMessage("Success", "Data saved");
    }
     
    public void update() {
        addMessage("Success", "Data updated");
    }
     
    public void delete() {
        addMessage("Success", "Data deleted");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
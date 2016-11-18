package br.ifes.pecomp.bean;

 
import java.io.Serializable;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;


import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

 
@ManagedBean(name="menuView")
public class MenuBean extends AbstractBean implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private transient MenuModel model;
 
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu menuInicio = new DefaultSubMenu("Início");
                 
        DefaultMenuItem item = new DefaultMenuItem("Notícias");
        item.setIcon("fa fa-newspaper-o");
        item.setUrl("noticias.jsf");
        menuInicio.addElement(item);
         
        model.addElement(menuInicio);
         
        item = new DefaultMenuItem("Meu perfil");
        item.setIcon("fa fa-user");
        item.setUrl("perfil.jsf");
        menuInicio.addElement(item);
        
        item = new DefaultMenuItem("Cadastro - Provisório");
        item.setIcon("fa fa-user");
        item.setUrl("cadastro.jsf");
        menuInicio.addElement(item);
         
        
        //Second submenu
        DefaultSubMenu menuSimulado = new DefaultSubMenu("Simulados");
 
        item = new DefaultMenuItem("Simulado por disciplina");
        item.setIcon("fa fa-calculator");
        item.setUrl("simulado_disciplina.jsf");

        menuSimulado.addElement(item);
         
        item = new DefaultMenuItem("Simulado por ano");
        item.setUrl("simulado_ano.jsf");
        item.setIcon("fa fa-calendar-o");


    	menuSimulado.addElement(item);
         
        item = new DefaultMenuItem("Simulado aleatório");
        item.setUrl("simulado_aleatorio.jsf");
        item.setIcon("fa fa-bars");

        menuSimulado.addElement(item);
 
        model.addElement(menuSimulado);

    
        DefaultSubMenu menuConteudos = new DefaultSubMenu("Conteúdos");
        
        item = new DefaultMenuItem("Livros");
        item.setUrl("livros.jsf");
        item.setIcon("fa fa-book");
        menuConteudos.addElement(item);
         
        item = new DefaultMenuItem("Apostilas");
        item.setUrl("apostilas.jsf");
        item.setIcon("fa fa-book");
        menuConteudos.addElement(item);

        item = new DefaultMenuItem("Vídeos");
        item.setUrl("videos.jsf");
        item.setIcon("fa fa-video-camera");
        menuConteudos.addElement(item);

        model.addElement(menuConteudos);


        DefaultSubMenu menuDesempenho = new DefaultSubMenu("Desempenho");
        
        item = new DefaultMenuItem("Estudantes");
        item.setUrl("desempenho_estudante.jsf");
        item.setIcon("fa fa-line-chart");
        menuDesempenho.addElement(item);
         
        item = new DefaultMenuItem("Instituições");
        item.setUrl("desempenho_instituicao.jsf");
        item.setIcon("fa fa-bar-chart-o");
        menuDesempenho.addElement(item);

        model.addElement(menuDesempenho);

        DefaultMenuItem menuSair = new DefaultMenuItem("Sair");
        menuSair.setIcon("fa fa-arrow-circle-left");
        menuSair.setUrl("http://google.com.br");
        menuDesempenho.addElement(menuSair);
        
        DefaultSubMenu menuAdministrador = new DefaultSubMenu("Administrador");
        
        item = new DefaultMenuItem("Adicionar Questão");
        item.setUrl("adicionar_questao.jsf");
        item.setIcon("fa fa-cog");

        menuAdministrador.addElement(item);
        
        item = new DefaultMenuItem("Adicionar Conteúdo");
        item.setUrl("adicionar_conteudo.jsf");
        item.setIcon("fa fa-cog");
        
        menuAdministrador.addElement(item);

        model.addElement(menuAdministrador);
    }
 
    public MenuModel getModel() {
        return model;
    }   
     
   
}
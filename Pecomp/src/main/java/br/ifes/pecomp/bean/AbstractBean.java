package br.ifes.pecomp.bean;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AbstractBean {
	
	public void sucess() {
        addMessageSucess("Success", "Salvo");
    }     
    
	public void sucess(String mensagem) {
        addMessageSucess("Success", mensagem);
    }
     
    public void update() {
        addMessageSucess("Success", "Atualizado");
    }
    
    public void update(String mensagem) {
        addMessageSucess("Success", mensagem);
    }
     
    public void delete() {
        addMessageSucess("Success", "Data deleted");
    }
    public void delete(String mensagem) {
        addMessageSucess("Success", mensagem);
    }

    public void error() {
        addMessageError("Ocorreu um erro", "Error");
    }

    public void error(String mensagem) {
        addMessageError("Ocorreu um erro", mensagem);
    }
   
    public void addMessageSucess(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void addMessageError(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}

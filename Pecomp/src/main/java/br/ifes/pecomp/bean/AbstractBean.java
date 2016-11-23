package br.ifes.pecomp.bean;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AbstractBean {
	
	public void sucess() {
        addMessageSucess("Successo", "Salvo");
    }     
    
	public void sucess(String mensagem) {
        addMessageSucess("Sucesso", mensagem);
    }
     
    public void update() {
        addMessageSucess("Successo", "Atualizado");
    }
    
    public void update(String mensagem) {
        addMessageSucess("Successo", mensagem);
    }
     
    public void delete() {
        addMessageSucess("Successo", "Data deleted");
    }
    public void delete(String mensagem) {
        addMessageSucess("Succesos", mensagem);
    }

    public void error() {
        addMessageError("Ocorreu um erro", "Error");
    }

    public void error(String mensagem) {
        addMessageError("", mensagem);
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

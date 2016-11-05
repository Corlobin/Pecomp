package br.ifes.pecomp.bean;




import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AbstractBean {
	
	public void sucess() {
        addMessage("Success", "Salvo");
    }     
    
	public void sucess(String mensagem) {
        addMessage("Success", mensagem);
    }
     
    public void update() {
        addMessage("Success", "Atualizado");
    }
    
    public void update(String mensagem) {
        addMessage("Success", mensagem);
    }
     
    public void delete() {
        addMessage("Success", "Data deleted");
    }
    public void delete(String mensagem) {
        addMessage("Success", mensagem);
    }

    public void error() {
        addMessage("Error", "Error");
    }

    public void error(String mensagem) {
        addMessage("Error", mensagem);
    }
   
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

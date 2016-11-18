package br.ifes.pecomp.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.ifes.pecomp.repository.PessoaRepositoryImpl;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	
	private String senha;
	
	private PessoaRepositoryImpl pessoaRepository;

	public LoginBean() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean verificaAcesso(String email, String senha){
		return pessoaRepository.possuiAcesso(email, senha);
	}
	
}

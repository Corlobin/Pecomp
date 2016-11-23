package br.ifes.pecomp.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.ifes.pecomp.entity.Pessoa;
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
		pessoaRepository = new PessoaRepositoryImpl();
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
	
	
	public String verificaAcesso()
	{
		Pessoa pessoa = pessoaRepository.findByUsuarioAndSenha(email, senha);
		if (pessoa == null)
		{
			this.error("Usuário ou senha inválidos!");
			return "";
		}
		else
		{
			this.sucess("Logado com sucesso!");
			return "noticias.jsf";
		}
	}
	
}

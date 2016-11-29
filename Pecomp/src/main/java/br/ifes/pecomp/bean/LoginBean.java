package br.ifes.pecomp.bean;

import java.io.Serializable;
import br.ifes.pecomp.session.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.ifes.pecomp.entity.Pessoa;
import br.ifes.pecomp.repository.PessoaRepositoryImpl;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{usuario}")
	private Pessoa usuario;
	
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
			usuario = pessoa;


			return "noticias.jsf";
		}
	}
	
	public String doLogout()
	{

		this.sucess("Deslogado com sucesso");
		return "index.jsf";
	}
	
	public boolean isLogged()
	{
		
		return true;
	}
	
	public Pessoa getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}
	
	
	public void salvarUsuario()
	{
		this.pessoaRepository.update(usuario);
	}
	
	
    /**
     * Retorna usuario logado
     * 
    public Pessoa getUser() {
       return (Pessoa) SessionContext.getInstance().getUsuarioLogado();
    }
    */
	
}

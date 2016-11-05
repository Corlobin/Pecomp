package br.ifes.pecomp.security;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.service.spi.InjectService;

@ManagedBean(name="usuarioBean")
@ViewScoped
public class Usuario {

	private boolean logado;

	public boolean getLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	
}

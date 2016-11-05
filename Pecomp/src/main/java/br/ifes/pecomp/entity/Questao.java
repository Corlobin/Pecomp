package br.ifes.pecomp.entity;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="questoes")
@ManagedBean("questao")

public class Questao extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3230169398962718768L;

	private Integer ano;
	
	private String titulo;
	
	private String enunciado;
	
	private Materia materia;
	
	private String texto;
	
	private List<QuestaoOpcao> opcoes;
	
	public List<QuestaoOpcao> getOpcoes() {
		return opcoes;
	}

	public Questao(Integer ano, String titulo, String enunciado, Materia materia, String texto,
			List<QuestaoOpcao> opcoes) {
		super();
		this.ano = ano;
		this.titulo = titulo;
		this.enunciado = enunciado;
		this.materia = materia;
		this.texto = texto;
		this.opcoes = opcoes;
	}

	public void setOpcoes(List<QuestaoOpcao> opcoes) {
		this.opcoes = opcoes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	

}

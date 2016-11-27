package br.ifes.pecomp.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="TB_QUESTOES")
public class Questao extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3230169398962718768L;

	@Column(name="TB_QST_ANO")
	private Integer ano;
	
	@Column(name="TB_QST_TITULO")
	private String titulo;
	
	@Column(name="TB_QST_ENUNCIADO")
	private String enunciado;
	
	@ManyToOne()
	private Materia materia;
	
	@Column(name="TB_QST_TEXTO")
	private String texto;
	
	@OneToMany(mappedBy="questao",fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private List<QuestaoOpcao> opcoes;
	
	//private List<Comentario> comentarios;
	
	public List<QuestaoOpcao> getOpcoes() {
		return opcoes;
	}

	public Questao(){
		super();
		materia = new Materia();
	}
	
	public Questao(Integer ano, String titulo, String enunciado, Materia materia, String texto,
			ArrayList<QuestaoOpcao> opcoes) {
		super();
		this.ano = ano;
		this.titulo = titulo;
		this.enunciado = enunciado;
		this.materia = materia;
		this.texto = texto;
		this.opcoes = opcoes;
	}

	public void setOpcoes(ArrayList<QuestaoOpcao> opcoes) {
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
	
	public void inicializaQuestoes()
	{
		this.opcoes = new ArrayList<QuestaoOpcao>();
	}
		

}

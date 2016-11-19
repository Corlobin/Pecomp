package br.ifes.pecomp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="TB_DT_POSCOMP")
public class Poscomp extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1311738322905987941L;

	@Column(name="TB_DT_PROVA")
	private Date dataProva;
	
	@Column(name="TB_DT_INSCRICAO")
	private Date dataInscricao;

	public Date getDataProva() {
		return dataProva;
	}

	public void setDataProva(Date dataProva) {
		this.dataProva = dataProva;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}
	
	
}

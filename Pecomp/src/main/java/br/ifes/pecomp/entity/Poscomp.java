package br.ifes.pecomp.entity;

import java.sql.Date;
import javax.persistence.Entity;

@Entity
public class Poscomp extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1311738322905987941L;

	private Date dataProva;
	
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

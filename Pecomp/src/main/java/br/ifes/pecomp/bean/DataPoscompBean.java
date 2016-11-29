package br.ifes.pecomp.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ifes.pecomp.entity.Poscomp;
import br.ifes.pecomp.repository.PoscompRepositoryImpl;

@ManagedBean(name="dataPoscompBean")
@ViewScoped
public class DataPoscompBean extends AbstractBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Poscomp poscomp;
	private PoscompRepositoryImpl poscompRepository;
	private int quantidadeDiasProva;
	private int quantidadeDiasInscricao;
	
	public DataPoscompBean(){
	
	}
	
	@PostConstruct
	public void init(){
		poscomp = new Poscomp();
		poscompRepository = new PoscompRepositoryImpl();
		poscomp = poscompRepository.getDatas();
		setQuantidadeDiasProva();
		setQuantidadeDiasInscricao();
	}
	
	
	
	public int getQuantidadeDiasInscricao() {
		return quantidadeDiasInscricao;
	}

	public void setQuantidadeDiasInscricao() {
		Date dataAtual = new Date(System.currentTimeMillis());
		this.quantidadeDiasInscricao = (int) ( (poscomp.getDataInscricao().getTime() - dataAtual.getTime()) / 86400000L);
	}

	public int getQuantidadeDiasProva() {
		return quantidadeDiasProva;
	}

	public void setQuantidadeDiasProva() {
		Date dataAtual = new Date(System.currentTimeMillis());
		this.quantidadeDiasProva = (int) ( (poscomp.getDataProva().getTime() - dataAtual.getTime()) / 86400000L);
		
	}

	public Poscomp getPoscomp() {
		return poscomp;
	}

	public void setPoscomp(Poscomp poscomp) {
		this.poscomp = poscomp;
	}
	
	

}

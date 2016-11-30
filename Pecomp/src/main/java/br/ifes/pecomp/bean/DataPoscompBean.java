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
	private String mensagemDataInscricao;
	private String mensagemDataProva;
	
	public DataPoscompBean(){
		super();
	}
	
	@PostConstruct
	public void init(){
		poscomp = new Poscomp();
		poscompRepository = new PoscompRepositoryImpl();
		poscomp = poscompRepository.getDatas();
		setQuantidadeDiasProva();
		setQuantidadeDiasInscricao();
	}
	
	public String getMensagemDataInscricao() {
		if(quantidadeDiasInscricao > 0){
			mensagemDataInscricao =  "Faltam "+ quantidadeDiasInscricao + " dias para o fim das inscrições";
		}else{
			mensagemDataInscricao = "O período de inscrição já se encerrou!";
		}
		return mensagemDataInscricao;
	}

	public void setMensagemDataInscricao(String mensagemDataInscricao) {
		this.mensagemDataInscricao = mensagemDataInscricao;
	}
	
	public String getMensagemDataProva() {
		if(quantidadeDiasProva > 0){
			mensagemDataProva =  "Faltam "+ quantidadeDiasProva + " dias para a prova";
		}else{
			mensagemDataProva = "A prova já foi aplicada!";
		}
		return mensagemDataProva;
	}

	public void setMensagemDataProva(String mensagemDataProva) {
		this.mensagemDataProva = mensagemDataProva;
	}

	public int getQuantidadeDiasInscricao() {
		return quantidadeDiasInscricao;
	}

	public void setQuantidadeDiasInscricao() {
		if(poscomp != null){
			Date dataAtual = new Date(System.currentTimeMillis());
			this.quantidadeDiasInscricao = (int) ( (poscomp.getDataInscricao().getTime() - dataAtual.getTime()) / 86400000L);
		}
	}

	public int getQuantidadeDiasProva() {
		return quantidadeDiasProva;
	}

	public void setQuantidadeDiasProva() {
		if(poscomp != null){
			Date dataAtual = new Date(System.currentTimeMillis());
			this.quantidadeDiasProva = (int) ( (poscomp.getDataProva().getTime() - dataAtual.getTime()) / 86400000L);
		}
	}

	public Poscomp getPoscomp() {
		return poscomp;
	}

	public void setPoscomp(Poscomp poscomp) {
		this.poscomp = poscomp;
	}
	
	public String salvarDatas(){
		Date dataAtual = new Date(System.currentTimeMillis());
		if(poscomp.getDataProva().after(dataAtual) && poscomp.getDataInscricao().after(dataAtual)){
			poscompRepository.inserirDatas(poscomp);
			this.sucess("Datas cadastradas com sucesso!");
		}else{
			this.error("As datas devem ser maiores que a data atual");
		}
		
		return "";
	}
	
}

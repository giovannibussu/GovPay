package it.govpay.model;

import java.util.Date;


public class AvvisoDigitaleEsito extends BasicModel {

	private static final long serialVersionUID = 1L;
	
	public long getIdAvvisoDigitale() {
		return idAvvisoDigitale;
	}
	public void setIdAvvisoDigitale(long idAvvisoDigitale) {
		this.idAvvisoDigitale = idAvvisoDigitale;
	}
	public String getIdentificativoCanale() {
		return identificativoCanale;
	}
	public void setIdentificativoCanale(String identificativoCanale) {
		this.identificativoCanale = identificativoCanale;
	}
	public long getTipoCanaleEsito() {
		return tipoCanaleEsito;
	}
	public void setTipoCanaleEsito(long tipoCanaleEsito) {
		this.tipoCanaleEsito = tipoCanaleEsito;
	}
	public Date getDataEsito() {
		return dataEsito;
	}
	public void setDataEsito(Date dataEsito) {
		this.dataEsito = dataEsito;
	}
	public long getCodiceEsito() {
		return codiceEsito;
	}
	public void setCodiceEsito(long codiceEsito) {
		this.codiceEsito = codiceEsito;
	}
	public String getDescrizioneEsito() {
		return descrizioneEsito;
	}
	public void setDescrizioneEsito(String descrizioneEsito) {
		this.descrizioneEsito = descrizioneEsito;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private long idAvvisoDigitale;
	private String identificativoCanale;
	private long tipoCanaleEsito;
	private Date dataEsito;
	private long codiceEsito;
	private String descrizioneEsito;
	private long id;

}

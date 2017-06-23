package it.govpay.model;

import java.util.Date;


public class AvvisoDigitale extends BasicModel {

	private static final long serialVersionUID = 1L;

	private String idMessaggioRichiesta;
	private long idDominio;
	private String codiceAvviso;
	private String stato;
	private String descrizioneStato;
	private double importoAvviso;
	private String descrizionePagamento;
	private String tassonomia;
	private String anagraficaPagatore;
	private String tipoIdentificativoUnivoco;
	private String codiceIdentificativoUnivoco;
	private String emailSoggettoPagatore;
	private String cellulareSoggettoPagatore;
	private Date dataScadenzaPagamento;
	private Date dataScadenzaAvviso;
	private Date dataCreazione;
	private String urlAvviso;
	private long id;
	
	public String getIdMessaggioRichiesta() {
		return idMessaggioRichiesta;
	}
	public void setIdMessaggioRichiesta(String idMessaggioRichiesta) {
		this.idMessaggioRichiesta = idMessaggioRichiesta;
	}
	public long getIdDominio() {
		return idDominio;
	}
	public void setIdDominio(long idDominio) {
		this.idDominio = idDominio;
	}
	public String getCodiceAvviso() {
		return codiceAvviso;
	}
	public void setCodiceAvviso(String codiceAvviso) {
		this.codiceAvviso = codiceAvviso;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getDescrizioneStato() {
		return descrizioneStato;
	}
	public void setDescrizioneStato(String descrizioneStato) {
		this.descrizioneStato = descrizioneStato;
	}
	public double getImportoAvviso() {
		return importoAvviso;
	}
	public void setImportoAvviso(double importoAvviso) {
		this.importoAvviso = importoAvviso;
	}
	public String getDescrizionePagamento() {
		return descrizionePagamento;
	}
	public void setDescrizionePagamento(String descrizionePagamento) {
		this.descrizionePagamento = descrizionePagamento;
	}
	public String getTassonomia() {
		return tassonomia;
	}
	public void setTassonomia(String tassonomia) {
		this.tassonomia = tassonomia;
	}
	public String getAnagraficaPagatore() {
		return anagraficaPagatore;
	}
	public void setAnagraficaPagatore(String anagraficaPagatore) {
		this.anagraficaPagatore = anagraficaPagatore;
	}
	public String getTipoIdentificativoUnivoco() {
		return tipoIdentificativoUnivoco;
	}
	public void setTipoIdentificativoUnivoco(String tipoIdentificativoUnivoco) {
		this.tipoIdentificativoUnivoco = tipoIdentificativoUnivoco;
	}
	public String getCodiceIdentificativoUnivoco() {
		return codiceIdentificativoUnivoco;
	}
	public void setCodiceIdentificativoUnivoco(String codiceIdentificativoUnivoco) {
		this.codiceIdentificativoUnivoco = codiceIdentificativoUnivoco;
	}
	public String getEmailSoggettoPagatore() {
		return emailSoggettoPagatore;
	}
	public void setEmailSoggettoPagatore(String emailSoggettoPagatore) {
		this.emailSoggettoPagatore = emailSoggettoPagatore;
	}
	public String getCellulareSoggettoPagatore() {
		return cellulareSoggettoPagatore;
	}
	public void setCellulareSoggettoPagatore(String cellulareSoggettoPagatore) {
		this.cellulareSoggettoPagatore = cellulareSoggettoPagatore;
	}
	public Date getDataScadenzaPagamento() {
		return dataScadenzaPagamento;
	}
	public void setDataScadenzaPagamento(Date dataScadenzaPagamento) {
		this.dataScadenzaPagamento = dataScadenzaPagamento;
	}
	public Date getDataScadenzaAvviso() {
		return dataScadenzaAvviso;
	}
	public void setDataScadenzaAvviso(Date dataScadenzaAvviso) {
		this.dataScadenzaAvviso = dataScadenzaAvviso;
	}
	public Date getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public String getUrlAvviso() {
		return urlAvviso;
	}
	public void setUrlAvviso(String urlAvviso) {
		this.urlAvviso = urlAvviso;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}

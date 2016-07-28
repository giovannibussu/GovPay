package it.agid.pap.model;

import it.agid.pap.util.DateAdapter;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "singoloImportoPagato", "esitoSingoloPagamento", "dataEsitoSingoloPagamento", "identificativoUnivocoRiscossione", "causaleVersamento",
"datiSpecificiRiscossione" })
@JsonIgnoreProperties(value = {  "id" ,"insertDate", "lastUpdate", "cancelled", "handler", "hibernateLazyInitializer", "datiPagamento", "rendicontazione" })
public class DatiSingoloPagamento extends AbstractSingleMoneyTransfer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6030093011177253650L;

	private BigDecimal singoloImportoPagato;

	private String esitoSingoloPagamento;

	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dataEsitoSingoloPagamento;

	private String identificativoUnivocoRiscossione; // IUR

	@XmlTransient
	private DatiPagamento datiPagamento;
	
	@XmlTransient
	private Long rendicontazione;
	

	public DatiPagamento getDatiPagamento() {
		return datiPagamento;
	}

	public void setDatiPagamento(DatiPagamento datiPagamento) {
		this.datiPagamento = datiPagamento;
	}

	public BigDecimal getSingoloImportoPagato() {
		return singoloImportoPagato;
	}

	public void setSingoloImportoPagato(BigDecimal value) {
		this.singoloImportoPagato = value;
	}

	public String getEsitoSingoloPagamento() {
		return esitoSingoloPagamento;
	}

	public void setEsitoSingoloPagamento(String value) {
		this.esitoSingoloPagamento = value;
	}

	public Date getDataEsitoSingoloPagamento() {
		return this.dataEsitoSingoloPagamento != null ? new Date(this.dataEsitoSingoloPagamento.getTime()) : null;
	}

	public void setDataEsitoSingoloPagamento(Date value) {
		if (value != null) {
			this.dataEsitoSingoloPagamento = new Date(value.getTime());
		}
	}

	public String getIdentificativoUnivocoRiscossione() {
		return identificativoUnivocoRiscossione;
	}

	public void setIdentificativoUnivocoRiscossione(String value) {
		this.identificativoUnivocoRiscossione = value;
	}

	public Long getRendicontazione() {
		return rendicontazione;
	}

	public void setRendicontazione(Long rendicontazione) {
		this.rendicontazione = rendicontazione;
	}
	
	

}
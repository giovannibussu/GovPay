package it.agid.pap.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "importoSingoloVersamento", "commissioneCaricoPA",
		"ibanAccredito", "bicAccredito", "ibanAppoggio", "bicAppoggio",
		"credenzialiPagatore", "causaleVersamento", "datiSpecificiRiscossione", })
public class DatiSingoloVersamento extends AbstractSingleMoneyTransfer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4264855618855359924L;

	private BigDecimal importoSingoloVersamento;

	private BigDecimal commissioneCaricoPA;

	private String ibanAccredito;

	private String bicAccredito;

	private String ibanAppoggio;

	private String bicAppoggio;

	private String credenzialiPagatore;

	@XmlTransient
	private DatiVersamento datiVersamento;

	public DatiVersamento getDatiVersamento() {
		return datiVersamento;
	}

	public void setDatiVersamento(DatiVersamento datiVersamento) {
		this.datiVersamento = datiVersamento;
	}

	public BigDecimal getImportoSingoloVersamento() {
		return importoSingoloVersamento;
	}

	public void setImportoSingoloVersamento(BigDecimal importoSingoloVersamento) {
		this.importoSingoloVersamento = importoSingoloVersamento;
	}

	public String getIbanAccredito() {
		return ibanAccredito;
	}

	public void setIbanAccredito(String ibanAccredito) {
		this.ibanAccredito = ibanAccredito;
	}

	public String getCredenzialiPagatore() {
		return credenzialiPagatore;
	}

	public void setCredenzialiPagatore(String credenzialiPagatore) {
		this.credenzialiPagatore = credenzialiPagatore;
	}

	public BigDecimal getCommissioneCaricoPA() {
		return commissioneCaricoPA;
	}

	public void setCommissioneCaricoPA(BigDecimal commissioneCaricoPA) {
		this.commissioneCaricoPA = commissioneCaricoPA;
	}

	public String getBicAccredito() {
		return bicAccredito;
	}

	public void setBicAccredito(String bicAccredito) {
		this.bicAccredito = bicAccredito;
	}

	public String getIbanAppoggio() {
		return ibanAppoggio;
	}

	public void setIbanAppoggio(String ibanAppoggio) {
		this.ibanAppoggio = ibanAppoggio;
	}

	public String getBicAppoggio() {
		return bicAppoggio;
	}

	public void setBicAppoggio(String bicAppoggio) {
		this.bicAppoggio = bicAppoggio;
	}

}
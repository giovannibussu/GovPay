package it.agid.pap.model;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "dataEsecuzionePagamento", "importoTotaleDaVersare", "tipoVersamento", "identificativoUnivocoVersamento",
		"codiceContestoPagamento", "ibanAddebito", "bicAddebito","firmaRicevuta", "datiSingoloVersamento" })
public class DatiVersamento extends AbstractMoneyTransfer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5747508621494395833L;

	private Date dataEsecuzionePagamento;

	private BigDecimal importoTotaleDaVersare;

	private String tipoVersamento;

	private Byte firmaRicevuta;

	private String ibanAddebito;

	private String bicAddebito;

	private List<DatiSingoloVersamento> datiSingoloVersamento;

	public Date getDataEsecuzionePagamento() {
		return this.dataEsecuzionePagamento != null ? new Date(this.dataEsecuzionePagamento.getTime()) : null;
	}

	public void setDataEsecuzionePagamento(Date dataEsecuzionePagamento) {
		if (dataEsecuzionePagamento != null) {
			this.dataEsecuzionePagamento = new Date(dataEsecuzionePagamento.getTime());
		}
	}

	public BigDecimal getImportoTotaleDaVersare() {
		return importoTotaleDaVersare;
	}

	public void setImportoTotaleDaVersare(BigDecimal importoTotaleDaVersare) {
		this.importoTotaleDaVersare = importoTotaleDaVersare;
	}

	public String getTipoVersamento() {
		return tipoVersamento;
	}

	public void setTipoVersamento(String tipoVersamento) {
		this.tipoVersamento = tipoVersamento;
	}

	public Byte getFirmaRicevuta() {
		return firmaRicevuta;
	}

	public void setFirmaRicevuta(Byte firmaRicevuta) {
		this.firmaRicevuta = firmaRicevuta;
	}

	public List<DatiSingoloVersamento> getDatiSingoloVersamento() {
		return datiSingoloVersamento;
	}

	public void setDatiSingoloVersamento(List<DatiSingoloVersamento> datiSingoloVersamento) {
		this.datiSingoloVersamento = datiSingoloVersamento;
	}

	public String getIbanAddebito() {
		return ibanAddebito;
	}

	public void setIbanAddebito(String ibanAddebito) {
		this.ibanAddebito = ibanAddebito;
	}

	public String getBicAddebito() {
		return bicAddebito;
	}

	public void setBicAddebito(String bicAddebito) {
		this.bicAddebito = bicAddebito;
	}

}
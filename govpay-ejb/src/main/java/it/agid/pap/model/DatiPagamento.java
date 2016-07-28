package it.agid.pap.model;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "codiceEsitoPagamento", "importoTotalePagato", "identificativoUnivocoVersamento", "codiceContestoPagamento",
		 "datiSingoloPagamento" })
public class DatiPagamento extends AbstractMoneyTransfer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2800485001403190299L;

	private Byte codiceEsitoPagamento;

	private BigDecimal importoTotalePagato;

	private List<DatiSingoloPagamento> datiSingoloPagamento;

	public Byte getCodiceEsitoPagamento() {
		return codiceEsitoPagamento;
	}

	public void setCodiceEsitoPagamento(Byte value) {
		this.codiceEsitoPagamento = value;
	}

	public BigDecimal getImportoTotalePagato() {
		return importoTotalePagato;
	}

	public void setImportoTotalePagato(BigDecimal value) {
		this.importoTotalePagato = value;
	}

	public List<DatiSingoloPagamento> getDatiSingoloPagamento() {
		return this.datiSingoloPagamento;
	}

	public void setDatiSingoloPagamento(List<DatiSingoloPagamento> datiSingoloPagamento) {
		this.datiSingoloPagamento = datiSingoloPagamento;
	}

}

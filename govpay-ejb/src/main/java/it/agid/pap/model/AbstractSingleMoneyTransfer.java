package it.agid.pap.model;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class AbstractSingleMoneyTransfer extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4453030986135504248L;

	private String causaleVersamento;

	private String datiSpecificiRiscossione;

	public String getCausaleVersamento() {
		return causaleVersamento;
	}

	public void setCausaleVersamento(String value) {
		this.causaleVersamento = value;
	}

	public String getDatiSpecificiRiscossione() {
		return datiSpecificiRiscossione;
	}

	public void setDatiSpecificiRiscossione(String value) {
		this.datiSpecificiRiscossione = value;
	}

}
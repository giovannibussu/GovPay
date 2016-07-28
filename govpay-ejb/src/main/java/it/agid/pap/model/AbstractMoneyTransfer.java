package it.agid.pap.model;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class AbstractMoneyTransfer extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7611804953384140297L;

	private String codiceContestoPagamento;

	private String identificativoUnivocoVersamento; // IUV

	public String getCodiceContestoPagamento() {
		return codiceContestoPagamento;
	}

	public void setCodiceContestoPagamento(String value) {
		this.codiceContestoPagamento = value;
	}

	public String getIdentificativoUnivocoVersamento() {
		return identificativoUnivocoVersamento;
	}

	public void setIdentificativoUnivocoVersamento(String value) {
		this.identificativoUnivocoVersamento = value;
	}

}
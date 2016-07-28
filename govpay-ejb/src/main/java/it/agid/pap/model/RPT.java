package it.agid.pap.model;

import it.agid.pap.util.DateTimeAdapter;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "RPT")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "versioneOggetto", "dominio", "identificativoMessaggioRichiesta", "dataOraMessaggioRichiesta", "autenticazioneSoggetto",
		"soggettoVersante", "soggettoPagatore", "enteBeneficiario", "datiVersamento", "identificativoPSP", "identificativoIntermediarioPSP",
		"identificativoCanale" })
public class RPT extends AbstractComunicationEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3729503160845929182L;

	private String identificativoMessaggioRichiesta;

	@XmlJavaTypeAdapter(value=DateTimeAdapter.class)
	private Date dataOraMessaggioRichiesta;

	private String autenticazioneSoggetto;

	private DatiVersamento datiVersamento;

	@XmlTransient
	private String xml;

	private String identificativoPSP;

	private String identificativoIntermediarioPSP;

	private String identificativoCanale;

	public String getIdentificativoMessaggioRichiesta() {
		return identificativoMessaggioRichiesta;
	}

	public void setIdentificativoMessaggioRichiesta(String value) {
		this.identificativoMessaggioRichiesta = value;
	}

	public Date getDataOraMessaggioRichiesta() {
		return this.dataOraMessaggioRichiesta != null ? new Date(this.dataOraMessaggioRichiesta.getTime()) : null;
	}

	public void setDataOraMessaggioRichiesta(Date value) {
		if (value != null) {
			this.dataOraMessaggioRichiesta = new Date(value.getTime());
		}
	}

	public String getAutenticazioneSoggetto() {
		return autenticazioneSoggetto;
	}

	public void setAutenticazioneSoggetto(String value) {
		this.autenticazioneSoggetto = value;
	}

	public DatiVersamento getDatiVersamento() {
		return datiVersamento;
	}

	public void setDatiVersamento(DatiVersamento value) {
		this.datiVersamento = value;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getIdentificativoPSP() {
		return identificativoPSP;
	}

	public void setIdentificativoPSP(String identificativoPSP) {
		this.identificativoPSP = identificativoPSP;
	}

	public String getIdentificativoIntermediarioPSP() {
		return identificativoIntermediarioPSP;
	}

	public void setIdentificativoIntermediarioPSP(String identificativoIntermediarioPSP) {
		this.identificativoIntermediarioPSP = identificativoIntermediarioPSP;
	}

	public String getIdentificativoCanale() {
		return identificativoCanale;
	}

	public void setIdentificativoCanale(String identificativoCanale) {
		this.identificativoCanale = identificativoCanale;
	}

}

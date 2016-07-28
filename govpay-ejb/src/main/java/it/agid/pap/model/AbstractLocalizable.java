package it.agid.pap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlAccessorType(XmlAccessType.NONE)
@JsonIgnoreProperties(value = { "denominazione", "cap", "indirizzo", "denomUnitOper", "localita", "provincia", "nazione" })
public abstract class AbstractLocalizable extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6864264973175547950L;

	private String denominazione;

	private String denomUnitOper;

	private String indirizzo;

	private String cap;

	private String localita;

	private String provincia;

	private String nazione;

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getDenomUnitOper() {
		return denomUnitOper;
	}

	public void setDenomUnitOper(String denomUnitOper) {
		this.denomUnitOper = denomUnitOper;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

}

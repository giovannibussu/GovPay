package it.agid.pap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
public class SoggettoPagatore extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6507790048815656342L;

	private IdentificativoUnivocoPagatore identificativoUnivocoPagatore;

	private String anagraficaPagatore;

	private String indirizzoPagatore;

	private String civicoPagatore;

	private String capPagatore;

	private String localitaPagatore;

	private String provinciaPagatore;

	@XmlElement(name = "nazionePagatore", required = false)
	private String nazionePagatore;

	@XmlElement(name = "e-mailPagatore", required = false)
	@JsonProperty("e-mailPagatore")
	private String emailPagatore;

	public IdentificativoUnivocoPagatore getIdentificativoUnivocoPagatore() {
		return identificativoUnivocoPagatore;
	}

	public void setIdentificativoUnivocoPagatore(IdentificativoUnivocoPagatore value) {
		this.identificativoUnivocoPagatore = value;
	}

	public String getAnagraficaPagatore() {
		return anagraficaPagatore;
	}

	public void setAnagraficaPagatore(String value) {
		this.anagraficaPagatore = value;
	}

	public String getIndirizzoPagatore() {
		return indirizzoPagatore;
	}

	public void setIndirizzoPagatore(String value) {
		this.indirizzoPagatore = value;
	}

	public String getCivicoPagatore() {
		return civicoPagatore;
	}

	public void setCivicoPagatore(String value) {
		this.civicoPagatore = value;
	}

	public String getCapPagatore() {
		return capPagatore;
	}

	public void setCapPagatore(String value) {
		this.capPagatore = value;
	}

	public String getLocalitaPagatore() {
		return localitaPagatore;
	}

	public void setLocalitaPagatore(String value) {
		this.localitaPagatore = value;
	}

	public String getProvinciaPagatore() {
		return provinciaPagatore;
	}

	public void setProvinciaPagatore(String value) {
		this.provinciaPagatore = value;
	}

	@JsonProperty("e-mailPagatore")
	public String getEmailPagatore() {
		return emailPagatore;
	}

	public void setEmailPagatore(String emailPagatore) {
		this.emailPagatore = emailPagatore;
	}

	public String getNazionePagatore() {
		return nazionePagatore;
	}

	public void setNazionePagatore(String nazionePagatore) {
		this.nazionePagatore = nazionePagatore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((identificativoUnivocoPagatore == null) ? 0 : identificativoUnivocoPagatore.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SoggettoPagatore)) {
			return false;
		}
		SoggettoPagatore other = (SoggettoPagatore) obj;
		if (identificativoUnivocoPagatore == null) {
			if (other.identificativoUnivocoPagatore != null) {
				return false;
			}
		} else if (!identificativoUnivocoPagatore.equals(other.identificativoUnivocoPagatore)) {
			return false;
		}
		return true;
	}

}
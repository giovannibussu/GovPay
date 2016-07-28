package it.agid.pap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
public class SoggettoVersante extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3075500345570080947L;

	private IdentificativoUnivocoVersante identificativoUnivocoVersante;

	private String anagraficaVersante;

	private String indirizzoVersante;

	private String civicoVersante;

	private String capVersante;

	private String localitaVersante;

	private String provinciaVersante;

	private String nazioneVersante;

	@XmlElement(name = "e-mailVersante")
	@JsonProperty("e-mailVersante")
	private String eMailVersante;

	/**
	 * Gets the value of the identificativoUnivocoVersante property.
	 * 
	 * @return possible object is
	 *         {@link RPT.SoggettoVersante.IdentificativoUnivocoVersante }
	 * 
	 */
	public IdentificativoUnivocoVersante getIdentificativoUnivocoVersante() {
		return identificativoUnivocoVersante;
	}

	/**
	 * Sets the value of the identificativoUnivocoVersante property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link RPT.SoggettoVersante.IdentificativoUnivocoVersante }
	 * 
	 */
	public void setIdentificativoUnivocoVersante(IdentificativoUnivocoVersante value) {
		this.identificativoUnivocoVersante = value;
	}

	/**
	 * Gets the value of the anagraficaVersante property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAnagraficaVersante() {
		return anagraficaVersante;
	}

	/**
	 * Sets the value of the anagraficaVersante property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAnagraficaVersante(String value) {
		this.anagraficaVersante = value;
	}

	/**
	 * Gets the value of the indirizzoVersante property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIndirizzoVersante() {
		return indirizzoVersante;
	}

	/**
	 * Sets the value of the indirizzoVersante property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIndirizzoVersante(String value) {
		this.indirizzoVersante = value;
	}

	/**
	 * Gets the value of the civicoVersante property.
	 * 
	 */
	public String getCivicoVersante() {
		return civicoVersante;
	}

	/**
	 * Sets the value of the civicoVersante property.
	 * 
	 */
	public void setCivicoVersante(String value) {
		this.civicoVersante = value;
	}

	/**
	 * Gets the value of the capVersante property.
	 * 
	 */
	public String getCapVersante() {
		return capVersante;
	}

	/**
	 * Sets the value of the capVersante property.
	 * 
	 */
	public void setCapVersante(String value) {
		this.capVersante = value;
	}

	/**
	 * Gets the value of the localitaVersante property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocalitaVersante() {
		return localitaVersante;
	}

	/**
	 * Sets the value of the localitaVersante property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocalitaVersante(String value) {
		this.localitaVersante = value;
	}

	/**
	 * Gets the value of the provinciaVersante property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProvinciaVersante() {
		return provinciaVersante;
	}

	/**
	 * Sets the value of the provinciaVersante property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProvinciaVersante(String value) {
		this.provinciaVersante = value;
	}

	/**
	 * Gets the value of the nazioneVersante property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNazioneVersante() {
		return nazioneVersante;
	}

	/**
	 * Sets the value of the nazioneVersante property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNazioneVersante(String value) {
		this.nazioneVersante = value;
	}

	/**
	 * Gets the value of the eMailVersante property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@JsonProperty("e-mailVersante")
	public String getEMailVersante() {
		return eMailVersante;
	}

	/**
	 * Sets the value of the eMailVersante property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEMailVersante(String value) {
		this.eMailVersante = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((identificativoUnivocoVersante == null) ? 0 : identificativoUnivocoVersante.hashCode());
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
		if (!(obj instanceof SoggettoVersante)) {
			return false;
		}
		SoggettoVersante other = (SoggettoVersante) obj;
		if (identificativoUnivocoVersante == null) {
			if (other.identificativoUnivocoVersante != null) {
				return false;
			}
		} else if (!identificativoUnivocoVersante.equals(other.identificativoUnivocoVersante)) {
			return false;
		}
		return true;
	}

}

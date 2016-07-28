package it.agid.pap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder = { "identificativoUnivocoAttestante", "denominazioneAttestante", "codiceUnitOperAttestante", "denomUnitOperAttestante",
		"indirizzoAttestante", "civicoAttestante", "capAttestante", "localitaAttestante", "provinciaAttestante", "nazioneAttestante"

})
public class IstitutoAttestante extends AbstractLocalizable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6947538343817371289L;

	private IdentificativoUnivocoAttestante identificativoUnivocoAttestante;

	private String codiceUnitOperAttestante;

	private String civicoAttestante;

	public IdentificativoUnivocoAttestante getIdentificativoUnivocoAttestante() {
		return identificativoUnivocoAttestante;
	}

	public void setIdentificativoUnivocoAttestante(IdentificativoUnivocoAttestante value) {
		this.identificativoUnivocoAttestante = value;
	}

	public String getDenominazioneAttestante() {
		return super.getDenominazione();
	}

	public void setDenominazioneAttestante(String denominazioneAttestante) {
		super.setDenominazione(denominazioneAttestante);
	}

	public String getCodiceUnitOperAttestante() {
		return codiceUnitOperAttestante;
	}

	public void setCodiceUnitOperAttestante(String codiceUnitOperAttestante) {
		this.codiceUnitOperAttestante = codiceUnitOperAttestante;
	}

	public String getDenomUnitOperAttestante() {
		return super.getDenomUnitOper();
	}

	public void setDenomUnitOperAttestante(String denomUnitOperAttestante) {
		super.setDenomUnitOper(denomUnitOperAttestante);
	}

	public String getIndirizzoAttestante() {
		return super.getIndirizzo();
	}

	public void setIndirizzoAttestante(String indirizzoAttestante) {
		super.setIndirizzo(indirizzoAttestante);
	}

	public String getCivicoAttestante() {
		return this.civicoAttestante;
	}

	public void setCivicoAttestante(String civicoAttestante) {
		this.civicoAttestante = civicoAttestante;
	}

	public String getCapAttestante() {
		return super.getCap();
	}

	public void setCapAttestante(String capAttestante) {
		super.setCap(capAttestante);
	}

	public String getLocalitaAttestante() {
		return super.getLocalita();
	}

	public void setLocalitaAttestante(String localistaAttestante) {
		super.setLocalita(localistaAttestante);
	}

	public String getProvinciaAttestante() {
		return super.getProvincia();
	}

	public void setProvinciaAttestante(String provinciaAttestante) {
		super.setProvincia(provinciaAttestante);
	}

	public String getNazioneAttestante() {
		return super.getNazione();
	}

	public void setNazioneAttestante(String nazioneAttestante) {
		super.setNazione(nazioneAttestante);
	}

}
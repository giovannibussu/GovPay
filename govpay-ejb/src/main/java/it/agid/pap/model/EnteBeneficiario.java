package it.agid.pap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder = { "identificativoUnivocoBeneficiario", "denominazioneBeneficiario", "codiceUnitOperBeneficiario", "denomUnitOperBeneficiario",
		"indirizzoBeneficiario", "civicoBeneficiario", "capBeneficiario", "localitaBeneficiario", "provinciaBeneficiario", "nazioneBeneficiario"

})
public class EnteBeneficiario extends AbstractLocalizable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2582550084210697572L;

	private IdentificativoUnivocoBeneficiario identificativoUnivocoBeneficiario;

	private String civicoBeneficiario;

	private String codiceUnitOperBeneficiario;

	public IdentificativoUnivocoBeneficiario getIdentificativoUnivocoBeneficiario() {
		return identificativoUnivocoBeneficiario;
	}

	public void setIdentificativoUnivocoBeneficiario(IdentificativoUnivocoBeneficiario identificativoUnivocoBeneficiario) {
		this.identificativoUnivocoBeneficiario = identificativoUnivocoBeneficiario;
	}

	public String getDenominazioneBeneficiario() {
		return super.getDenominazione();
	}

	public void setDenominazioneBeneficiario(String denominazioneBeneficiario) {
		super.setDenominazione(denominazioneBeneficiario);
	}

	public String getCodiceUnitOperBeneficiario() {
		return codiceUnitOperBeneficiario;
	}

	public void setCodiceUnitOperBeneficiario(String codiceUnitOperBeneficiario) {
		this.codiceUnitOperBeneficiario = codiceUnitOperBeneficiario;
	}

	public String getDenomUnitOperBeneficiario() {
		return super.getDenomUnitOper();
	}

	public void setDenomUnitOperBeneficiario(String denomUnitOperBeneficiario) {
		super.setDenomUnitOper(denomUnitOperBeneficiario);
	}

	public String getIndirizzoBeneficiario() {
		return super.getIndirizzo();
	}

	public void setIndirizzoBeneficiario(String indirizzoBeneficiario) {
		super.setIndirizzo(indirizzoBeneficiario);
	}

	public String getCivicoBeneficiario() {
		return this.civicoBeneficiario;
	}

	public void setCivicoBeneficiario(String civicoBeneficiario) {
		this.civicoBeneficiario = civicoBeneficiario;
	}

	public String getCapBeneficiario() {
		return super.getCap();
	}

	public void setCapBeneficiario(String capBeneficiario) {
		super.setCap(capBeneficiario);
	}

	public String getLocalitaBeneficiario() {
		return super.getLocalita();
	}

	public void setLocalitaBeneficiario(String localitaBeneficiario) {
		super.setLocalita(localitaBeneficiario);
	}

	public String getProvinciaBeneficiario() {
		return super.getProvincia();
	}

	public void setProvinciaBeneficiario(String provinciaBeneficiario) {
		super.setProvincia(provinciaBeneficiario);
	}

	public String getNazioneBeneficiario() {
		return super.getNazione();
	}

	public void setNazioneBeneficiario(String nazioneBeneficiario) {
		super.setNazione(nazioneBeneficiario);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((identificativoUnivocoBeneficiario == null) ? 0 : identificativoUnivocoBeneficiario.hashCode());
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
		if (!(obj instanceof EnteBeneficiario)) {
			return false;
		}
		EnteBeneficiario other = (EnteBeneficiario) obj;
		if (identificativoUnivocoBeneficiario == null) {
			if (other.identificativoUnivocoBeneficiario != null) {
				return false;
			}
		} else if (!identificativoUnivocoBeneficiario.equals(other.identificativoUnivocoBeneficiario)) {
			return false;
		}
		return true;
	}

}
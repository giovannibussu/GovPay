package it.agid.pap.model;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class AbstractComunicationEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7489560111936981000L;

	private String versioneOggetto;

	private Dominio dominio;

	private SoggettoVersante soggettoVersante;

	private SoggettoPagatore soggettoPagatore;

	private EnteBeneficiario enteBeneficiario;

	public String getVersioneOggetto() {
		return versioneOggetto;
	}

	public void setVersioneOggetto(String versioneOggetto) {
		this.versioneOggetto = versioneOggetto;
	}

	public Dominio getDominio() {
		return dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}

	public SoggettoVersante getSoggettoVersante() {
		return soggettoVersante;
	}

	public void setSoggettoVersante(SoggettoVersante soggettoVersante) {
		this.soggettoVersante = soggettoVersante;
	}

	public SoggettoPagatore getSoggettoPagatore() {
		return soggettoPagatore;
	}

	public void setSoggettoPagatore(SoggettoPagatore soggettoPagatore) {
		this.soggettoPagatore = soggettoPagatore;
	}

	public EnteBeneficiario getEnteBeneficiario() {
		return enteBeneficiario;
	}

	public void setEnteBeneficiario(EnteBeneficiario value) {
		this.enteBeneficiario = value;
	}

}

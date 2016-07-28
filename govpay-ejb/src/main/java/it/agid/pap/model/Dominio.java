package it.agid.pap.model;

public class Dominio extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7385086508811758221L;

	private String identificativoDominio;

	private String identificativoStazioneRichiedente;

	public String getIdentificativoDominio() {
		return identificativoDominio;
	}

	public void setIdentificativoDominio(String identificativoDominio) {
		this.identificativoDominio = identificativoDominio;
	}

	public String getIdentificativoStazioneRichiedente() {
		return identificativoStazioneRichiedente;
	}

	public void setIdentificativoStazioneRichiedente(String identificativoStazioneRichiedente) {
		this.identificativoStazioneRichiedente = identificativoStazioneRichiedente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((identificativoDominio == null) ? 0 : identificativoDominio.hashCode());
		result = (prime * result) + ((identificativoStazioneRichiedente == null) ? 0 : identificativoStazioneRichiedente.hashCode());
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
		if (!(obj instanceof Dominio)) {
			return false;
		}
		Dominio other = (Dominio) obj;
		if (identificativoDominio == null) {
			if (other.getIdentificativoDominio() != null) {
				return false;
			}
		} else if (!identificativoDominio.equals(other.getIdentificativoDominio())) {
			return false;
		}
		if (identificativoStazioneRichiedente == null) {
			if (other.identificativoStazioneRichiedente != null) {
				return false;
			}
		} else if (!identificativoStazioneRichiedente.equals(other.getIdentificativoStazioneRichiedente())) {
			return false;
		}
		return true;
	}

}
package it.agid.pap.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "tipoIdentificativoUnivoco", "codiceIdentificativoUnivoco" })
public abstract class AbstractUniqueIdentifier extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2356012790323353479L;

	private String tipoIdentificativoUnivoco;

	private String codiceIdentificativoUnivoco;

	public String getTipoIdentificativoUnivoco() {
		return tipoIdentificativoUnivoco;
	}

	public void setTipoIdentificativoUnivoco(String tipoIdentificativoUnivoco) {
		this.tipoIdentificativoUnivoco = tipoIdentificativoUnivoco;
	}

	public String getCodiceIdentificativoUnivoco() {
		return codiceIdentificativoUnivoco;
	}

	public void setCodiceIdentificativoUnivoco(String codiceIdentificativoUnivoco) {
		this.codiceIdentificativoUnivoco = codiceIdentificativoUnivoco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((codiceIdentificativoUnivoco == null) ? 0 : codiceIdentificativoUnivoco.hashCode());
		result = (prime * result) + ((tipoIdentificativoUnivoco == null) ? 0 : tipoIdentificativoUnivoco.hashCode());
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
		if (!(obj instanceof AbstractUniqueIdentifier)) {
			return false;
		}
		AbstractUniqueIdentifier other = (AbstractUniqueIdentifier) obj;
		if (codiceIdentificativoUnivoco == null) {
			if (other.codiceIdentificativoUnivoco != null) {
				return false;
			}
		} else if (!codiceIdentificativoUnivoco.equals(other.codiceIdentificativoUnivoco)) {
			return false;
		}
		if (tipoIdentificativoUnivoco == null) {
			if (other.tipoIdentificativoUnivoco != null) {
				return false;
			}
		} else if (!tipoIdentificativoUnivoco.equals(other.tipoIdentificativoUnivoco)) {
			return false;
		}
		return true;
	}

}

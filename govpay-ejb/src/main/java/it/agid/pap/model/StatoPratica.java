package it.agid.pap.model;

public class StatoPratica {

	public enum StatoPraticaType {

		IUV_APPENA_CREATO, IN_ATTESA_DI_PSP, RPT_STORICIZZATA, INVIO_RPT_AL_NODO_KO, IN_ATTESA_DI_RT, RT_ERRATA, RT_VERIFICATA, PSP_ERRATO, PAGAMENTO_DIRETTO_ANNULLATO

	}

	private String stato;

	private String descrizione;

	/**
	 * @return the {@link StatoPratica#stato}
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * @param stato
	 *            the stato to set
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * @return the {@link StatoPratica#descrizione}
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione
	 *            the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}

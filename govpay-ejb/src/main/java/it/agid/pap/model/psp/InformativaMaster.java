package it.agid.pap.model.psp;

/**
 * Aggregazione corrispondente ai dati comuni del presente flusso di
 * informativa.
 */
public class InformativaMaster  {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	/**
	 * Data e ora di pubblicazione del flusso informativo da parte del PSP,
	 * secondo il formato ISO 8601<br>
	 * [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss]<br>
	 * Dev'essere maggiore della dataPubblicazione contenuta nell' ultimo flusso
	 * di informativa del PSP caricato nel Nodo.
	 */
	private String dataPubblicazione;

	/**
	 * Data e ora in cui inizier� la validit� del flusso informativo caricato
	 * nel Nodo, per la nodoChiediInformativaPSP<br>
	 * e per la scelta del CANALE quando non specificato dalla PA (si veda tag
	 * &lt;priorita&gt;).<br>
	 * <ul>
	 * <li>Deve seguire il formato ISO 8601:[YYYY]-[MM]-[DD]T[hh]:[mm]:[ss]</li>
	 * <li>Dev�essere maggiore o uguale alla data di Pubblicazione e maggiore
	 * della data corrente.</li>
	 * <li>La validit� parte comunque dalle 00:00:00 del giorno indicato.</li>
	 * </ul>
	 */
	private String dataInizioValidita;

	/**
	 * URL di un sito web con informazioni specifiche del servizio offerto dal
	 * PSP
	 */
	private String urlInformazioniPSP;

	/**
	 * @return the {@link InformativaMaster#dataPubblicazione}
	 */
	public String getDataPubblicazione() {
		return dataPubblicazione;
	}

	/**
	 * @param dataPubblicazione
	 *            the dataPubblicazione to set
	 */
	public void setDataPubblicazione(String dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	/**
	 * @return the {@link InformativaMaster#dataInizioValidita}
	 */
	public String getDataInizioValidita() {
		return dataInizioValidita;
	}

	/**
	 * @param dataInizioValidita
	 *            the dataInizioValidita to set
	 */
	public void setDataInizioValidita(String dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	/**
	 * @return the {@link InformativaMaster#urlInformazioniPSP}
	 */
	public String getUrlInformazioniPSP() {
		return urlInformazioniPSP;
	}

	/**
	 * @param urlInformazioniPSP
	 *            the urlInformazioniPSP to set
	 */
	public void setUrlInformazioniPSP(String urlInformazioniPSP) {
		this.urlInformazioniPSP = urlInformazioniPSP;
	}
}

package it.agid.pap.model.psp;

/**
 * Informativa relative al singolo CANALE /Intermediario del PSP.
 */
public class InformativaDetail {

	/**
	 * Identificativo dell'Intermediario del PSP che fornisce lo specifico
	 * CANALE per l'accesso al PSP da parte del Nodo.
	 */
	private String identificativoIntermediario;

	/**
	 * Identificativo del CANALE di cui si riportano le condizioni
	 */
	private String identificativoCanale;

	/**
	 * Tipo di versamento a cui si riferiscono le condizioni di seguito<br>
	 * Puo' assumere gli stessi valori dell' omonimo campo dell' RPT<br>
	 * <ul>
	 * <li>BBT = Bonifico Bancario di Tesoreria</li>
	 * <li>BP = Bollettino Postale</li>
	 * <li>AD = Addebito diretto</li>
	 * <li>CP = Carta di pagamento</li>
	 * <li>PO = Pagamento attivato presso PSP</li>
	 * </ul>
	 */
	private String tipoVersamento;

	/**
	 * Numero intero indicante la priorita' con cui viene scelto il CANALE dal
	 * Nodo per l' invio al PSP,<br>
	 * nel caso in cui questo non sia specificato dalla PA nella primitiva
	 * nodoInviaRPT.<br>
	 * Ad un intero minore corrisponde una priorit� piu' elevata.
	 */
	private String priorita;

	/**
	 * testo libero in cui e' possibile specificare orari o restrizioni del
	 * servizio
	 */
	private String disponibilitaServizio;

	/**
	 * testo libero in cui e' possibile specificare natura e condizioni del
	 * servizio (non economiche)
	 */
	private String descrizioneServizio;

	/**
	 * importo della condizione economica piu' elevata dovuta per il servizio
	 * specifico
	 */
	private String condizioniEconomicheMassime;

	/**
	 * url di un sito web con informazioni specifiche del canale
	 */
	private String urlInformazioniCanale;

	/**
	 * @return the {@link InformativaDetail#identificativoIntermediario}
	 */
	public String getIdentificativoIntermediario() {
		return identificativoIntermediario;
	}

	/**
	 * @param identificativoIntermediario
	 *            the identificativoIntermediario to set
	 */
	public void setIdentificativoIntermediario(
			String identificativoIntermediario) {
		this.identificativoIntermediario = identificativoIntermediario;
	}

	/**
	 * @return the {@link InformativaDetail#identificativoCanale}
	 */
	public String getIdentificativoCanale() {
		return identificativoCanale;
	}

	/**
	 * @param identificativoCanale
	 *            the identificativoCanale to set
	 */
	public void setIdentificativoCanale(String identificativoCanale) {
		this.identificativoCanale = identificativoCanale;
	}

	/**
	 * @return the {@link InformativaDetail#tipoVersamento}
	 */
	public String getTipoVersamento() {
		return tipoVersamento;
	}

	/**
	 * @param tipoVersamento
	 *            the tipoVersamento to set
	 */
	public void setTipoVersamento(String tipoVersamento) {
		this.tipoVersamento = tipoVersamento;
	}

	/**
	 * @return the {@link InformativaDetail#priorita}
	 */
	public String getPriorita() {
		return priorita;
	}

	/**
	 * @param priorita
	 *            the priorita to set
	 */
	public void setPriorita(String priorita) {
		this.priorita = priorita;
	}

	/**
	 * @return the {@link InformativaDetail#disponibilitaServizio}
	 */
	public String getDisponibilitaServizio() {
		return disponibilitaServizio;
	}

	/**
	 * @param disponibilitaServizio
	 *            the disponibilitaServizio to set
	 */
	public void setDisponibilitaServizio(String disponibilitaServizio) {
		this.disponibilitaServizio = disponibilitaServizio;
	}

	/**
	 * @return the {@link InformativaDetail#descrizioneServizio}
	 */
	public String getDescrizioneServizio() {
		return descrizioneServizio;
	}

	/**
	 * @param descrizioneServizio
	 *            the descrizioneServizio to set
	 */
	public void setDescrizioneServizio(String descrizioneServizio) {
		this.descrizioneServizio = descrizioneServizio;
	}

	/**
	 * @return the {@link InformativaDetail#condizioniEconomicheMassime}
	 */
	public String getCondizioniEconomicheMassime() {
		return condizioniEconomicheMassime;
	}

	/**
	 * @param condizioniEconomicheMassime
	 *            the condizioniEconomicheMassime to set
	 */
	public void setCondizioniEconomicheMassime(
			String condizioniEconomicheMassime) {
		this.condizioniEconomicheMassime = condizioniEconomicheMassime;
	}

	/**
	 * @return the {@link InformativaDetail#urlInformazioniCanale}
	 */
	public String getUrlInformazioniCanale() {
		return urlInformazioniCanale;
	}

	/**
	 * @param urlInformazioniCanale
	 *            the urlInformazioniCanale to set
	 */
	public void setUrlInformazioniCanale(String urlInformazioniCanale) {
		this.urlInformazioniCanale = urlInformazioniCanale;
	}

}

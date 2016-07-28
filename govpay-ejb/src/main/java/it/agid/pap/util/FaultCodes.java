package it.agid.pap.util;

public enum FaultCodes {

	// I SEGUENTI CODICI POSSONO ESSERE RITORNATI DAL NODO NEI SEGUENTI CASI :
	//
	PPT_SINTASSI_XSD,
	/**
	 * IdentificativoDominio sconosciuto.
	 */
	PPT_DOMINIO_SCONOSCIUTO,
	/**
	 * Dominio disabilitato.
	 */
	PPT_DOMINIO_DISABILITATO,
	/**
	 * IdentificativoStazioneRichiedente sconosciuto.
	 */
	PPT_STAZIONE_INT_PA_SCONOSCIUTA,
	/**
	 * Stazione disabilitata.
	 */
	PPT_STAZIONE_INT_PA_DISABILITATA,
	/**
	 * Errore di connessione verso la Stazione
	 */
	PPT_STAZIONE_INT_PA_IRRAGGIUNGIBILE,
	/**
	 * Il Servizio Applicativo della Stazione non e�attivo
	 */
	PPT_STAZIONE_INT_PA_SERVIZIO_NONATTIVO,
	/**
	 * Canale sconosciuto.
	 */
	PPT_CANALE_SCONOSCIUTO,
	/**
	 * Errore di connessione verso il Canale.
	 */
	PPT_CANALE_IRRAGGIUNGIBILE,
	/**
	 * Il Servizio Applicativo del Canale non � attivo.
	 */
	PPT_CANALE_SERVIZIO_NONATTIVO,
	/**
	 * Timeout risposta dal Canale.
	 */
	PPT_CANALE_TIMEOUT,
	/**
	 * Canale conosciuto ma disabilitato da configurazione.
	 */
	PPT_CANALE_DISABILITATO,
	/**
	 * Il canale non � specificato, e nessun canale risulta utilizzabile secondo
	 * configurazione.
	 */
	PPT_CANALE_NONRISOLVIBILE,
	/**
	 * Nessun canale utilizzabile e abilitato.
	 */
	PPT_CANALE_INDISPONIBILE,
	/**
	 * Errore restituito dal Canale.
	 */
	PPT_CANALE_ERRORE,
	/**
	 * Parametri restituiti dal Canale per identificare il pagamento non
	 * corretti
	 */
	PPT_CANALE_ERR_PARAM_PAG_IMM,
	/**
	 * La response ricevuta dal Canale � vuota o non corretta sintatticamente o
	 * semanticamente
	 */
	PPT_CANALE_ERRORE_RESPONSE,
	/**
	 * PSP sconosciuto
	 */
	PPT_PSP_SCONOSCIUTO,
	/**
	 * PSP conosciuto ma disabilitato da configurazione
	 */
	PPT_PSP_DISABILITATO,
	/**
	 * RPT duplicata.
	 */
	PPT_RPT_DUPLICATA,
	/**
	 * RPT sconosciuta.
	 */
	PPT_RPT_SCONOSCIUTA,
	/**
	 * RT sconosciuta.
	 */
	PPT_RT_SCONOSCIUTA,
	/**
	 * RT non ancora pronta.
	 */
	PPT_RT_NONDISPONIBILE,
	/**
	 * Una qualche soglia fissata per PPT � temporaneamente superata e la
	 * richiesta � quindi rifiutata.
	 */
	PPT_SUPERAMENTOSOGLIA,
	/**
	 * Il campo tipoFirma non corrisponde ad alcun valore previsto.
	 */
	PPT_TIPOFIRMA_SCONOSCIUTO,
	/**
	 * Formato busta di firma errato o non corrispondente al tipoFirma.
	 */
	PPT_ERRORE_FORMATO_BUSTA_FIRMATA,
	/**
	 * Impossibile firmare.
	 */
	PPT_FIRMA_INDISPONIBILE,
	/**
	 * Valore di codificaInfrastruttura PSP non censito.
	 */
	PPT_CODIFICA_PSP_SCONOSCIUTA,
	/**
	 * Identificativo flusso sconosciuto.
	 */
	PPT_ID_FLUSSO_SCONOSCIUTO,
	/**
	 * Errore restituito dall�ente creditoreA.
	 */
	PPT_ERRORE_EMESSO_DA_PAA,
	/**
	 * Errore generico.
	 */
	PPT_SYSTEM_ERROR,
	/**
	 * La PAA non corrisponde al Dominio indicato.<br>
	 */
	PAA_ID_DOMINIO_ERRATO,
	/**
	 * Identificativo intermediario non corrispondente.<br>
	 */
	PAA_ID_INTERMEDIARIO_ERRATO,
	/**
	 * Stazione intermediario non corrispondente.<br>
	 */
	PAA_STAZIONE_INT_ERRATA,
	/**
	 * La RPT risulta sconosciuta.<br>
	 */
	PAA_RPT_SCONOSCIUTA,
	/**
	 * Descrzione Nodo : La RT � gi� stata accettata.<br>
	 */
	PAA_RT_DUPLICATA,
	/**
	 * Il campo tipoFirma non corrisponde ad alcun valore previsto.
	 */
	PAA_TIPOFIRMA_SCONOSCIUTO,
	/**
	 * 
	 Formato busta di firma errato o non corrispondente al tipoFirma.
	 */
	PAA_ERRORE_FORMATO_BUSTA_FIRMATA,
	/**
	 * Errore di firma.
	 */
	PAA_FIRMA_ERRATA,
	/**
	 * Impossibile firmare.
	 */
	PAA_FIRMA_INDISPONIBILE,
	/**
	 * Pagamento in attesa risulta sconosciuto all�ente creditoreA.
	 */
	PAA_PAGAMENTO_SCONOSCIUTO,
	/**
	 * Pagamento in attesa risulta concluso all�ente creditoreA.
	 */
	PAA_PAGAMENTO_DUPLICATO,
	/**
	 * Pagamento in attesa risulta in corso all�ente creditoreA.
	 */
	PAA_PAGAMENTO_IN_CORSO,
	/**
	 * Pagamento in attesa risulta annullato all�ente creditoreA.
	 */
	PAA_PAGAMENTO_ANNULLATO,
	/**
	 * Pagamento in attesa risulta scaduto all�ente creditoreA.
	 */
	PAA_PAGAMENTO_SCADUTO,
	/**
	 * Descrzione Nodo : Errore di sintassi XSD.<br>
	 * Descrzione PAP : 
	 */
	PAA_SINTASSI_XSD,
	/**
	 * Descrzione Nodo : Errore di sintassi extra XSD.<br>
	 * Descrzione PAP : Codice di errore restituito se la struttura di una una
	 * {@link RPT} o una {@link RT} non corrisponde all'XSD definito nelle
	 * specifiche del Nodo dei Pagamenti SPC. Nello specifico vengono passati
	 * dei campi extra rispetto a quelli definiti
	 */
	PAA_SINTASSI_EXTRAXSD,
	/**
	 * Descrizione Nodo : Errore semantico.<br>
	 * Descrizione PAP : Codice di errore restituito se la struttura di una una
	 * {@link RT} non corrisponde alla sua {@link RPT}. Nello specifico
	 * potrebbero essere diversi gli identificativi del soggetto pagatore,
	 * versante, ente beneficiario o la versione oggetto della {@link RT}
	 */
	PAA_SEMANTICA,
	/**
	 * Errore di sintassi XSD.
	 */
	CANALE_SINTASSI_XSD,
	/**
	 * Errore di sintassi extra XSD.
	 */
	CANALE_SINTASSI_EXTRAXSD,
	/**
	 * Errore semantico.
	 */
	CANALE_SEMANTICA,
	/**
	 * RPT duplicata.
	 */
	CANALE_RPT_DUPLICATA,
	/**
	 * RPT sconosciuta.
	 */
	CANALE_RPT_SCONOSCIUTA,
	/**
	 * RT sconosciuta.
	 */
	CANALE_RT_SCONOSCIUTA,
	/**
	 * Si vedano pspChiediListaRT e pspChiediRT
	 */
	CANALE_RT_NON_DISPONIBILE,
	/**
	 * Servizio non disponibile.
	 */
	CANALE_INDISPONIBILE,
	/**
	 * Identificativo richiedente non valido.
	 */
	CANALE_RICHIEDENTE_ERRATO,
	/**
	 * Errore generico.
	 */
	CANALE_SYSTEM_ERROR,

	// FINE SEZIONE

	/**
	 * Codice di errore restituito se in fase di creazione di una nuova
	 * {@link RPT} viene passato in input uno IUV, generato internamente o
	 * esternamente, corrispondente ad una {@link Pratica} esistente.
	 */
	PAP_IUV_DUPLICATO,
	/**
	 * Codice di errore restituito se in fase di creazione di una nuova
	 * {@link RPT} non viene passato in input uno IUV o lo IUV passato � vuoto
	 */
	PAP_IUV_ASSENTE,
	/**
	 * Codice di errore restituito se la verifica dell'{@link RPT} inviata
	 * fallisce rispetto all'XSD definito nelle specifiche del Nodo dei
	 * Pagamenti SPC
	 */
	PAP_RPT_MALFORMATA,
	/**
	 * Codice di errore restituito se la verifica dell'{@link RT} inviato
	 * fallisce rispetto all'XSD definito nelle specifiche del Nodo dei
	 * Pagamenti SPC
	 */
	PAP_RT_MALFORMATA,
	/**
	 * Codice di errore restituito se l'{@link RT} corrispondente allo IUV
	 * passato in input non e' ancora pervenuta e storicizzata sul DB della PAP
	 */
	PAP_RT_NON_DISPONIBILE,
//	/**
//	 * Codice di errore restituito se per qualche errore interno non si e'
//	 * riusciti a cancellare la lista dei {@link PSP} in fase di aggiornamento
//	 */
//	PAP_ERRORE_CANCELLAZIONE_PSP,
//	/**
//	 * Codice di errore restituito in fase di aggiornamento della lista dei
//	 * {@link PSP} se questa risulta malformata ed e' quindi impossibile
//	 * procedere con la storicizzazione sul DB della PAP. In questo caso viene
//	 * mantenuta la lista dei {@link PSP} presente nel DB prima della chiamata
//	 */
//	PAP_ERRORE_LISTA_PSP,
	/**
	 * Codice di errore restituito in caso in cui non sia possibile individuare
	 * puntualmente l'errore verificatosi
	 */
	PAP_UNEXPECTED_ERROR,
	/**
	 * Codice di errore restituito in caso di Nodo non raggiungibile per timeout
	 * o connessione non disponibile
	 */
	PAP_FAULT_NODO_NON_RAGGIUNGIBILE,
	/**
	 * Codice di errore restituito in caso in cui la data sia malformata o non
	 * valida(es. data from maggiore di data to)
	 */
	PAP_ERRORE_DATA,
	/**
	 * Codice di errore restituito in caso in cui venga passata una size minore
	 * o uguale a zero.
	 */
	PAP_ERROR_SIZE, 
	/**
	 * Codice di errore restituito in caso in cui ci sia un errore nel salvataggio o recupero
	 * di uno o piu' eventi nel GdE
	 */
	PAP_ERRORE_GDE,
	/**
	 * Codice di errore restituito se la stazione passata non
	 * corrisponde con quella configurata nei file di configurazione della PAP
	 */
	PAP_STAZIONE_INT_ERRATA,
	/**
	 * Codice di errore restituito se il dominio passato non
	 * corrisponde con quello configurato nei file di configurazione della PAP
	 */
	PAP_ID_DOMINIO_ERRATO,
	/**
	 * Codice di errore restituito se la struttura di una una
	 * {@link RPT} o una {@link RT} non corrisponde all'XSD definito nelle
	 * specifiche del Nodo dei Pagamenti SPC
	 */
	PAP_SINTASSI_XSD, 
	/**
	 * Codice di errore restituito se la verifica di esistenza di un {@link PSP} 
	 * sul DB della PAP fallisce 
	 */
	PAP_PSP_NON_DISPONIBILE,
	/**
	 * Codice di errore restituito se il metodo invocato � in uno stato
	 * non atteso rispetto al workflow dei pagamenti
	 */
	PAP_STATO_ERRATO, 
	/**
	 * Codice di errore restituito se la RT contiene un importo totale diverso
	 * da quello riportato dalla rendicontazione
	 */
	PAP_ERRORE_IMPORTO_RT, 
	/**
	 * Codice di errore restituito se le verifiche di importi o totali quadrature
	 * fallisce
	 */
	PAP_QUADRATURA_ERROR, 
	
	/**
	 * Codice di errore restituito se la RT non contiene un pagamento con lo iur
	 * presente nella rendicontazione
	 */
	PAP_PAGAMENTO_RT_ASSENTE, 
	/**
	 * Codice di errore restituito se non viene trovato alcun PSP per il tipo
	 * di versamento passato
	 */
	PAP_PSP_ERRATO, 
	/**
	 * Codice di errore restitutito se vi � un errore nella rendicontazione
	 */
	PAP_ERRORE_RENDICONTAZIONE, 
	/**
	 * Codice di errore restitutito a seguito di validazioni fallite
	 */
	PAP_SEMANTICA, 
	/**
	 *  Formato busta di firma errato o non corrispondente al tipoFirma.
	 */
	PAP_ERRORE_FORMATO_BUSTA_FIRMATA, 
	/**
	 * Codice di errore restituito se l'intermediario passato
	 * non corrisponde con quello configurato nei file di configurazione della
	 * PAP
	 */
	PAP_ID_INTERMEDIARIO_ERRATO,
	/**
	 * Codice di errore restituito in fase di invio della
	 * {@link RT} da parte del Nodo, se e' gia' presente una {@link Pratica} in
	 * stato {@link StatoPraticaType#RT_VERIFICATA}
	 */
	PAP_RT_DUPLICATA,
}

package it.agid.pap.util;

import java.math.BigDecimal;

public final class PapConstants {

	private PapConstants() {
	}

	public static final String ESITO_OK = "OK";
	public static final String ESITO_KO = "KO";
	public static final String PWD_INVIA_RPT = "password_nodo_invia_rpt";
	public static final String FIRMA_INVIA_RPT = "tipo_firma_nodo_invia_rpt";
	public static final String IDENT_INTERMEDIATE_INVIA_RPT = "identificativo_intermediario_PA_nodo_invia_rpt";
	public static final String IDENT_STAZ_INTERMEDIATE_INVIA_RPT = "identificativo_stazione_intermediario_PA_nodo_invia_rpt";
	public static final String CODICE_PAP = "codice_pap";
	public static final String IDENT_DOMINIO_PA = "identificativoDominio_PA_nodo_invia_rpt";

	public static final String FAULT_NODO_NON_RAGGIUNGIBILE = "PAP_NODO_NON_RAGGIUNGIBILE";
//	public static final String GENERIC_ERROR = "ERRORE_GENERICO";

	public static final String CCP_FESP_OPEN_TAG = "CodiceContestoPagamento>";
	public static final String CCP_FESP_CLOSE_TAG = "/CodiceContestoPagamento>";

	public static final String CCP_PAP_OPEN_TAG = "codiceContestoPagamento>";
	public static final String CCP_PAP_CLOSE_TAG = "/codiceContestoPagamento>";
	public static final String FIRMATA = "CADES";
	public static final int MAX_RESULT_LIST = 100;
	public static final String TIPO_VERSAMENTO_PSP = "PO";
	public static final String CCP_NO_PSP = "n/a";
	
	public static final Integer LIST_RESULTS = 10;
	public static final String LIST_RESULTS_PARAM = "10";
	
	public static final Integer LIST_PAGE = 1;
	public static final String LIST_PAGE_PARAM = "1";
	public static final String QUADRATURA_DAYS = "giorni_quadratura";
	public static final String QUADRATURA_DAYS_DEFAULT = "1";
	public static final Integer MIN_LIST_PAGE = LIST_PAGE;
	public static final String GDE_PARAM_ND = "N/D";
	public static final BigDecimal RPT_IMPORTO_PAGAMENTO_BAD = BigDecimal.valueOf(0.0);
}

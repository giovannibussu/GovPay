package it.agid.pap.util;

import it.agid.pap.model.StatoPratica.StatoPraticaType;
import it.govpay.model.Rpt.StatoRpt;

public class GpWrapperUtils {
	
	public static StatoPraticaType statoRpt2statoPratica(StatoRpt stato) {
		switch (stato) {
		
		case RPT_ERRORE_INVIO_A_NODO:
		case RPT_RIFIUTATA_NODO:
		case RPT_RIFIUTATA_PSP:
			return StatoPraticaType.INVIO_RPT_AL_NODO_KO;
		
		case RT_RIFIUTATA_PA:
			return StatoPraticaType.RT_ERRATA;

		case RT_ACCETTATA_PA:
			return StatoPraticaType.RT_VERIFICATA;

		default:
			return StatoPraticaType.IN_ATTESA_DI_RT;
		}
	}

}

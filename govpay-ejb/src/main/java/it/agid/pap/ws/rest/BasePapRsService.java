package it.agid.pap.ws.rest;

import org.openspcoop2.generic_project.exception.NotFoundException;
import org.openspcoop2.generic_project.exception.ServiceException;

import it.govpay.bd.BasicBD;
import it.govpay.bd.anagrafica.AnagraficaManager;
import it.govpay.model.Applicazione;
import it.govpay.model.Portale;
import it.govpay.core.exceptions.GovPayException;
import it.govpay.core.utils.GovpayConfig;
import it.govpay.servizi.commons.EsitoOperazione;
import it.govpay.web.rs.BaseRsService;

public class BasePapRsService extends BaseRsService {

	public BasePapRsService(){
		super();
	}

	public BasePapRsService(String nomeServizio) {
		super(nomeServizio);
	}

	@Override
	protected Applicazione getApplicazioneAutenticata(BasicBD bd) throws GovPayException, ServiceException {
		try {
			return super.getApplicazioneAutenticata(bd);
		} catch(GovPayException e) {
			try {
				if(e.getCodEsito().equals(EsitoOperazione.AUT_000))
					return AnagraficaManager.getApplicazione(bd, GovpayConfig.getInstance().getGuestPapCode());
				else 
					throw e;
			} catch (NotFoundException nf) {
				throw new GovPayException(EsitoOperazione.AUT_000);
			}
		}
	}

	@Override
	protected Portale getPortaleAutenticato(BasicBD bd) throws GovPayException, ServiceException {
		try {
			return super.getPortaleAutenticato(bd);
		} catch(GovPayException e) {
			try {
				if(e.getCodEsito().equals(EsitoOperazione.AUT_000))
					return AnagraficaManager.getPortale(bd, GovpayConfig.getInstance().getGuestPapCode());
				else 
					throw e;
			} catch (NotFoundException nf) {
				throw new GovPayException(EsitoOperazione.AUT_000);
			}
		}
	}
}

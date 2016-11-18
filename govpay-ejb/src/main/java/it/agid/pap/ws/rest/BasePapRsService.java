package it.agid.pap.ws.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
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
	
	public ByteArrayOutputStream logRequest(UriInfo uriInfo, HttpHeaders rsHttpHeaders,String nomeOperazione,InputStream in) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		IOUtils.copy(in, baos);
		logRequest(uriInfo, rsHttpHeaders, nomeOperazione, baos);
		return baos;
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

	protected Portale getPortaleAutenticato(BasicBD bd) throws GovPayException, ServiceException {
		try {
			if(getPrincipal() == null) {
				throw new GovPayException(EsitoOperazione.AUT_000);
			}

			try {
				return AnagraficaManager.getPortaleByPrincipal(bd,getPrincipal());
			} catch (NotFoundException e) {
				throw new GovPayException(EsitoOperazione.AUT_001, getPrincipal());
			}
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
	
	private static ObjectMapper mapper = new ObjectMapper();
	protected ByteArrayOutputStream toOutputStream(Object o) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try { 
			mapper.writeValue(baos, o);
		} catch (Exception e) {
			log.error("Errore nella serializzazione del messaggio di risposta",e);
			try {baos.write("Errore nella serializzazione del messaggio di risposta".getBytes());} catch (Exception e2) {}
		}
		
		return baos;
	}
}

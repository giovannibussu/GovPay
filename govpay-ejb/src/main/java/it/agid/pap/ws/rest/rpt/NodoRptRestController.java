package it.agid.pap.ws.rest.rpt;

import it.gov.digitpa.schemas._2011.ws.paa.EsitoChiediStatoRPT;
import it.gov.digitpa.schemas._2011.ws.paa.FaultBean;
import it.gov.digitpa.schemas._2011.ws.paa.NodoChiediStatoRPTRisposta;
import it.govpay.bd.BasicBD;
import it.govpay.bd.model.Portale;
import it.govpay.bd.model.Rpt;
import it.govpay.core.exceptions.GovPayException;
import it.govpay.core.utils.GpContext;
import it.govpay.core.utils.GpThreadLocal;
import it.govpay.servizi.commons.EsitoOperazione;
import it.govpay.web.rs.BaseRsService;
import it.agid.pap.util.FaultCodes;
import java.io.InputStream;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

@Path("/pap/{codDominio}/nodorpts")
public class NodoRptRestController extends BaseRsService {

	@GET
	@Path("/{iuv}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestNodoChiediStatoRPT(InputStream is, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders, @PathParam("codDominio") String codDominio, @PathParam("iuv") String iuv, @DefaultValue("n/a") @QueryParam("codiceContestoPagamento") String codicePagamento) {

		log.info("Richiesta operazione papRestNodoChiediStatoRPT per la transazione con dominio (" + codDominio + "), iuv (" +  iuv +") e ccp (" + codicePagamento + ")");
		
		logRequest(uriInfo, httpHeaders, "papRestNodoChiediStatoRPT", is);
		
		GpContext ctx = GpThreadLocal.get();
		
		BasicBD bd = null;
		try {
			ctx.log("pap.ricevutaRichiesta");
			bd = BasicBD.newInstance(ctx.getTransactionId());
			
			Portale portaleAutenticato = getPortaleAutenticato(bd);
			it.govpay.core.business.Pagamento pagamentoBusiness = new it.govpay.core.business.Pagamento(bd);
			Rpt rpt = pagamentoBusiness.chiediTransazione(portaleAutenticato, codDominio, iuv, codicePagamento);
			
			NodoChiediStatoRPTRisposta wsResponse = new NodoChiediStatoRPTRisposta();
			EsitoChiediStatoRPT esito = new EsitoChiediStatoRPT();
			if(rpt.getPspRedirectURL() != null) {
				esito.setRedirect(1);
				esito.setUrl(rpt.getPspRedirectURL());
			}
			esito.setStato(rpt.getStato().toString());
			wsResponse.setEsito(esito);
			ctx.log("gpprt.ricevutaRichiestaOk");
			return Response.status(Status.OK).entity(wsResponse).build();
		} catch (Exception e) {
			new GovPayException(e).log(log);
			ctx.log("gpapp.ricevutaRichiestaKo", EsitoOperazione.INTERNAL.toString(), e.getMessage());
			FaultBean fault = new FaultBean();
			fault.setFaultCode(FaultCodes.PAP_UNEXPECTED_ERROR.name());
			fault.setFaultString(e.getMessage());
			logResponse(uriInfo, httpHeaders,"papRestNodoChiediStatoRPT", toOutputStream(fault));
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(fault).build();
		} finally {
			if(ctx != null) {
				ctx.log();
			}
			if(bd != null) bd.closeConnection();
		}
	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response papRestNodoChiediListaPendentiRpt(@QueryParam("from") String rangeDa,
//			@QueryParam("to") String rangeA, @DefaultValue("10") @QueryParam("size") long pageSize) {
//
//		return Response.status(Status.BAD_REQUEST)
//				.entity("{\"esito\":\"" + PapConstants.ESITO_KO + "\"}")
//				.build();
//	}

}

package it.agid.pap.ws.rest.rt;

import java.io.InputStream;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import it.agid.pap.util.FaultCodes;
import it.agid.pap.util.GpWrapperUtils;
import it.agid.pap.util.PapConstants;
import it.agid.pap.util.PapUtils;
import it.agid.pap.ws.clients.json.ChiediRTRisposta;
import it.agid.pap.ws.clients.json.StatiPraticaRisposta;
import it.agid.pap.ws.rest.BasePapRsService;
import it.gov.digitpa.schemas._2011.ws.paa.FaultBean;
import it.govpay.bd.BasicBD;
import it.govpay.model.Portale;
import it.govpay.bd.model.Rpt;
import it.govpay.core.exceptions.GovPayException;
import it.govpay.core.utils.GpContext;
import it.govpay.core.utils.GpThreadLocal;
import it.govpay.servizi.commons.EsitoOperazione;

@Path("/pap/{codDominio}/rts")
public class RtRestController extends BasePapRsService {
	
	public RtRestController() {
		super("PapRest");
	}

	@GET
	@Path("/{iuv}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestChiediRT(InputStream is, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders, @PathParam("codDominio") String codDominio, @PathParam("iuv") String iuv) {

		GpContext ctx = GpThreadLocal.get();

		BasicBD bd = null;
		try {
			logRequest(uriInfo, httpHeaders,"papRestChiediRT", is);
			
			ctx.log("pap.ricevutaRichiesta");
			bd = BasicBD.newInstance(ctx.getTransactionId());

			Portale portale = getPortaleAutenticato(bd);
			ChiediRTRisposta wsResponse = new ChiediRTRisposta();

			it.govpay.core.business.Pagamento pagamentoBusiness = new it.govpay.core.business.Pagamento(bd);
			Rpt rpt = pagamentoBusiness.chiediTransazione(portale, codDominio, iuv, Rpt.CCP_NA);
			
			if(rpt.getXmlRt() != null) {
				wsResponse.setRt(rpt.getXmlRt());
			}
			
			wsResponse.setTipoFirma(rpt.getFirmaRichiesta().getCodifica());
			wsResponse.setStatoPratica(GpWrapperUtils.statoRpt2statoPratica(rpt.getStato()).toString());
			ctx.log("pap.ricevutaRichiestaOk");
			logResponse(uriInfo, httpHeaders,"papRestChiediRT", toOutputStream(wsResponse));
			return Response.status(Status.OK).entity(wsResponse).build();
		} catch (GovPayException e) {
			e.log(log);
			ctx.log("pap.ricevutaRichiestaKo", e.getCodEsito().toString(), e.getMessage());
			FaultBean fault = new FaultBean();
			fault.setFaultCode(FaultCodes.PAP_UNEXPECTED_ERROR.name());
			fault.setFaultString(e.getMessage());
			logResponse(uriInfo, httpHeaders,"papRestChiediRT", toOutputStream(fault));
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(fault).build();
		} catch (Exception e) {
			new GovPayException(e).log(log);
			ctx.log("pap.ricevutaRichiestaKo", EsitoOperazione.INTERNAL.toString(), e.getMessage());
			FaultBean fault = new FaultBean();
			fault.setFaultCode(FaultCodes.PAP_UNEXPECTED_ERROR.name());
			fault.setFaultString(e.getMessage());
			logResponse(uriInfo, httpHeaders,"papRestChiediRT", toOutputStream(fault));
			return Response.status(Status.BAD_REQUEST).entity(fault).build();
		} finally {
			if(ctx != null) {
				ctx.log();
			}
			if(bd != null) bd.closeConnection();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestChiediStoricoRT(
			@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate,
			@QueryParam("idUtente") String idUtente,
			@QueryParam("statoPagamento") String statoPagamento,
			@DefaultValue(PapConstants.LIST_RESULTS_PARAM) @QueryParam("risultati") Integer risultati,
			@DefaultValue(PapConstants.LIST_PAGE_PARAM) @QueryParam("pagina") Integer pagina) {

		return Response.status(Status.BAD_REQUEST)
				.entity("{\"esito\":\"" + PapConstants.ESITO_KO + "\"}")
				.build();


	}

	/*
	 * Se non viene passato lo iuv viene chiamato questo metodo altrimenti
	 * chiamerebbe il metodo di riferimento con un valore iuv sballato pari al
	 * path 'recuperadanodo'
	 */
	@POST
	@Path("/recuperadanodo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestRecuperaRTDaNodoDummy(
			@DefaultValue(PapConstants.CCP_NO_PSP) @QueryParam("codiceContestoPagamento") String codicePagamento) {

		return Response.status(Status.BAD_REQUEST)
				.entity("{\"esito\":\"" + PapConstants.ESITO_KO + "\"}")
				.build();


	}

	@POST
	@Path("/recuperadanodo/{iuv}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestRecuperaRTDaNodo(
			@PathParam("iuv") String iuv,
			@QueryParam("codiceContestoPagamento") String codicePagamento) {

		try {
			StatiPraticaRisposta stati = new StatiPraticaRisposta();
			return Response.status(Status.CREATED).entity(stati).build();
		} catch (Exception e) {
			FaultBean fault = PapUtils.createFaultBean(
					FaultCodes.PAP_UNEXPECTED_ERROR.name(), e.getMessage());
			return Response.status(Status.BAD_REQUEST).entity(fault).build();
		}

	}

}

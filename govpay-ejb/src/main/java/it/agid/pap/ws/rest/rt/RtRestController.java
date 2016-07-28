package it.agid.pap.ws.rest.rt;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.agid.pap.util.FaultCodes;
import it.agid.pap.util.PapConstants;
import it.agid.pap.util.PapUtils;
import it.agid.pap.ws.clients.json.ChiediRTRisposta;
import it.agid.pap.ws.clients.json.StatiPraticaRisposta;
import it.gov.digitpa.schemas._2011.ws.paa.FaultBean;

@Path("/pap/rts")
public class RtRestController {

	protected final Log log = LogFactory.getLog(getClass());

	@GET
	@Path("/{iuv}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestChiediRT(@PathParam("iuv") String iuv) {

		ChiediRTRisposta wsResponse;
		try {
			wsResponse = new ChiediRTRisposta();
		} catch (Exception e) {
			FaultBean fault = PapUtils.createFaultBean(
					FaultCodes.PAP_UNEXPECTED_ERROR.name(), e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(fault)
					.build();

		}

		return Response.status(Status.OK).entity(wsResponse).build();
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

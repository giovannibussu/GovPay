package it.agid.pap.ws.rest.rpt;

import it.gov.digitpa.schemas._2011.ws.paa.FaultBean;
import it.gov.digitpa.schemas._2011.ws.paa.NodoChiediStatoRPTRisposta;
import it.agid.pap.util.PapConstants;
import it.agid.pap.util.PapUtils;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/pap/nodorpts")
public class NodoRptRestController { //extends RestJournalController

	@GET
	@Path("/{iuv}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestNodoChiediStatoRPT(@PathParam("iuv") String iuv, @DefaultValue("n/a") @QueryParam("codiceContestoPagamento") String codicePagamento) {


		NodoChiediStatoRPTRisposta wsResponse = null;
		try {
			wsResponse = new NodoChiediStatoRPTRisposta();
		} catch (Exception e) {
			FaultBean fault = PapUtils.createFaultBean(PapConstants.ESITO_KO, e.getMessage());
			return Response.status(Status.BAD_REQUEST).entity(fault).build();
		}

		return Response.status(Status.OK).entity(wsResponse).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestNodoChiediListaPendentiRpt(@QueryParam("from") String rangeDa,
			@QueryParam("to") String rangeA, @DefaultValue("10") @QueryParam("size") long pageSize) {

		return Response.status(Status.BAD_REQUEST)
				.entity("{\"esito\":\"" + PapConstants.ESITO_KO + "\"}")
				.build();
	}

}

package it.agid.pap.ws.rest.psp;

import it.gov.digitpa.schemas._2011.ws.paa.FaultBean;
import it.agid.pap.model.psp.PSP;
import it.agid.pap.util.FaultCodes;
import it.agid.pap.util.PapConstants;
import it.agid.pap.util.PapUtils;
import it.agid.pap.ws.clients.json.JsonList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/pap/psps")
public class PspRestController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestChiediListaPSP(
			@DefaultValue(PapConstants.LIST_RESULTS_PARAM) @QueryParam("risultati") Integer risultati,
			@DefaultValue(PapConstants.LIST_PAGE_PARAM) @QueryParam("pagina") Integer pagina) {

		JsonList<PSP> jsonList;
		try {
			jsonList = new JsonList<PSP>();
			//TODO
		} catch (Exception e) {
			FaultBean fault = PapUtils.createFaultBean(FaultCodes.PAP_UNEXPECTED_ERROR.name(), e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(fault)
					.build();
		}

		return Response.status(Status.OK).entity(jsonList).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestAggiornaListaPSP() {
		return Response.status(Status.CREATED).build();
	}
}

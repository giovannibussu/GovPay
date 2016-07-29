package it.agid.pap.ws.rest.rpt;

import it.gov.digitpa.schemas._2011.ws.paa.FaultBean;
import it.gov.digitpa.schemas._2011.ws.paa.NodoInviaRPTRisposta;
import it.agid.pap.model.RPT;
import it.agid.pap.util.FaultCodes;
import it.agid.pap.util.PapUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/pap/rpts")
public class RptRestController {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestInviaRpt(RPT rpt) {
		NodoInviaRPTRisposta wsResponse = null;
		try {
			wsResponse = new NodoInviaRPTRisposta();
		} catch (Exception e) {
			FaultBean fault = PapUtils.createFaultBean(
					FaultCodes.PAP_UNEXPECTED_ERROR.name(), e.getMessage());
			return Response.status(Status.BAD_REQUEST).entity(fault).build();
		}
		return Response.status(Status.CREATED).entity(wsResponse).build();
	}

//	@POST
//	@Path("/pagamentodiretto")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response papRestCaricaPagamentoDiretto(RPT rpt) {
//		return Response.status(Status.BAD_REQUEST).build();
//	}
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response papRestChiediStoricoRPT(
//			@QueryParam("startDate") String startDate,
//			@QueryParam("endDate") String endDate,
//			@QueryParam("idUtente") String idUtente,
//			@QueryParam("statoPagamento") String statoPagamento,
//			@DefaultValue(PapConstants.LIST_RESULTS_PARAM) @QueryParam("risultati") Integer risultati,
//			@DefaultValue(PapConstants.LIST_PAGE_PARAM) @QueryParam("pagina") Integer pagina) {
//
//		return Response.status(Status.BAD_REQUEST)
//				.entity("{\"esito\":\"" + PapConstants.ESITO_KO + "\"}")
//				.build();
//	}
//
//	@PUT
//	@Path("/pagamentodiretto")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response papRestAnnullaPagamentoDirettoDummy() {
//
//		return Response.status(Status.BAD_REQUEST)
//				.entity("{\"esito\":\"" + PapConstants.ESITO_KO + "\"}")
//				.build();
//
//	}
//
//	@PUT
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/pagamentodiretto/{iuv}")
//	public Response papRestAnnullaPagamentoDiretto(@PathParam("iuv") String iuv) {
//
//		return Response.status(Status.BAD_REQUEST)
//				.entity("{\"esito\":\"" + PapConstants.ESITO_KO + "\"}")
//				.build();
//	}
}

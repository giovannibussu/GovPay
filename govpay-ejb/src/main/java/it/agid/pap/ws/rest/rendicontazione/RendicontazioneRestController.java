package it.agid.pap.ws.rest.rendicontazione;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/pap/{codDominio}/rends")
public class RendicontazioneRestController {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestScaricaNuoviFlussiRendicontazione() {
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Path("/elabora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestElaboraFlussiRendicontazione() {
		return Response.status(Status.CREATED).build();
	}
}

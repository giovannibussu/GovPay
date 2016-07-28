package it.agid.pap.ws.rest.quadrature;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/pap/quads")
public class QuadratureRestController {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestScaricaNuoviFlussiQuadraturaPA(@QueryParam("dominioPA") String dominioPAQuad) {
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Path("/elabora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestElaboraFlussiQuadraturaPA() {
		return Response.status(Status.CREATED).build();
	}

}

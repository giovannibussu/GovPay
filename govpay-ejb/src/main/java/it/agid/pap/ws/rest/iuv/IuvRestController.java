package it.agid.pap.ws.rest.iuv;

import it.gov.digitpa.schemas._2011.ws.paa.FaultBean;
import it.govpay.bd.BasicBD;
import it.govpay.bd.anagrafica.AnagraficaManager;
import it.govpay.bd.model.Applicazione;
import it.govpay.bd.model.Dominio;
import it.govpay.bd.model.Iuv;
import it.govpay.bd.pagamento.IuvBD;
import it.govpay.bd.pagamento.IuvBD.Algoritmo;
import it.govpay.core.exceptions.GovPayException;
import it.govpay.core.utils.GpContext;
import it.govpay.core.utils.GpThreadLocal;
import it.govpay.servizi.commons.EsitoOperazione;
import it.agid.pap.util.FaultCodes;
import it.agid.pap.ws.rest.BasePapRsService;

import java.io.InputStream;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.openspcoop2.utils.logger.constants.proxy.Result;

@Path(value = "/pap/{codDominio}/iuvs")
public class IuvRestController extends BasePapRsService {

	public IuvRestController() {
		super("PapRest");
	}

	@POST
	@Produces("application/json")
	public Response papRestGeneraIUV(InputStream is, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders, @PathParam("codDominio") String codDominio, @DefaultValue("true")@QueryParam(value="iso11649") boolean  iso11649) {
		
		log.info("Richiesta operazione gpGeneraIuv");
		GpContext ctx = GpThreadLocal.get();
		BasicBD bd = null;
		try {
			logRequest(uriInfo, httpHeaders,"papRestGeneraIUV", is);

			bd = BasicBD.newInstance(ctx.getTransactionId());
			Applicazione applicazioneAutenticata = getApplicazioneAutenticata(bd);
			ctx.log("pap.ricevutaRichiesta");
			IuvBD iuvBD = new IuvBD(bd);
			Dominio dominio = AnagraficaManager.getDominio(bd, codDominio);
			Iuv iuv = iuvBD.generaIuv(applicazioneAutenticata, dominio, null, it.govpay.bd.model.Iuv.AUX_DIGIT, dominio.getStazione(bd).getApplicationCode(), it.govpay.bd.model.Iuv.TipoIUV.ISO11694, Algoritmo.PAP, false);
			ctx.log("pap.ricevutaRichiestaOk");
			ctx.setResult(Result.SUCCESS);
			Object entity = "{\"iuv\" : \"" + iuv.getIuv() + "\"}";
			logResponse(uriInfo, httpHeaders,"papRestGeneraIUV", toOutputStream(entity));
			return Response.status(Status.CREATED).entity("{\"iuv\" : \"" + iuv.getIuv() + "\"}").build();
		} catch (GovPayException e) {
			e.log(log);
			ctx.log("pap.ricevutaRichiestaKo", e.getCodEsito().toString(), e.getMessage());
			FaultBean fault = new FaultBean();
			fault.setFaultCode(FaultCodes.PAP_UNEXPECTED_ERROR.name());
			fault.setFaultString(e.getMessage());
			logResponse(uriInfo, httpHeaders,"papRestGeneraIUV", toOutputStream(fault));
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(fault).build();
		} catch (Exception e) {
			new GovPayException(e).log(log);
			ctx.log("pap.ricevutaRichiestaKo", EsitoOperazione.INTERNAL.toString(), e.getMessage());
			FaultBean fault = new FaultBean();
			fault.setFaultCode(FaultCodes.PAP_UNEXPECTED_ERROR.name());
			fault.setFaultString(e.getMessage());
			logResponse(uriInfo, httpHeaders,"papRestGeneraIUV", toOutputStream(fault));
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(fault).build();
		} finally {
			if(ctx != null) {
				ctx.log();
			}
			if(bd != null) bd.closeConnection();
		}
	}
	
}

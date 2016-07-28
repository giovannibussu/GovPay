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
import it.govpay.servizi.gpapp.GpGeneraIuvResponse;
import it.govpay.web.rs.BaseRsService;
import it.agid.pap.util.FaultCodes;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.openspcoop2.utils.logger.constants.proxy.Result;

@Path(value = "/pap/iuvs")
public class IuvRestController extends BaseRsService {


	@POST
	@Produces("application/json")
	public Response papRestGeneraIUV(@DefaultValue("true")@QueryParam(value="iso11649") boolean  iso11649) {
		
		log.info("Richiesta operazione gpGeneraIuv");
		GpContext ctx = GpThreadLocal.get();
		BasicBD bd = null;
		try {
			bd = BasicBD.newInstance(GpThreadLocal.get().getTransactionId());
			Applicazione applicazioneAutenticata = getApplicazioneAutenticata(bd);
			ctx.log("gpapp.ricevutaRichiesta");
			
			IuvBD iuvBD = new IuvBD(bd);
			Dominio dominio = AnagraficaManager.getDominio(bd, "12345678903");
			Iuv iuv = iuvBD.generaIuv(applicazioneAutenticata, dominio, null, it.govpay.bd.model.Iuv.AUX_DIGIT, dominio.getStazione(bd).getApplicationCode(), it.govpay.bd.model.Iuv.TipoIUV.ISO11694, Algoritmo.PAP, false);
			ctx.log("gpapp.ricevutaRichiestaOk");
			ctx.setResult(Result.SUCCESS);
			return Response.status(Status.CREATED).entity("{\"iuv\" : \"" + iuv.getIuv() + "\"}").build();
		} catch (GovPayException e) {
			e.log(log);
			ctx.log("gpapp.ricevutaRichiestaKo", e.getCodEsito().toString(), e.getMessage());
			FaultBean fault = new FaultBean();
			fault.setFaultCode(FaultCodes.PAP_UNEXPECTED_ERROR.name());
			fault.setFaultString(e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(fault).build();
		} catch (Exception e) {
			new GovPayException(e).log(log);
			ctx.log("gpapp.ricevutaRichiestaKo", EsitoOperazione.INTERNAL.toString(), e.getMessage());
			FaultBean fault = new FaultBean();
			fault.setFaultCode(FaultCodes.PAP_UNEXPECTED_ERROR.name());
			fault.setFaultString(e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(fault).build();
		} finally {
			if(ctx != null) {
				ctx.log();
			}
			if(bd != null) bd.closeConnection();
		}
	}
}

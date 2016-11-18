package it.agid.pap.ws.rest.psp;

import it.gov.digitpa.schemas._2011.ws.paa.FaultBean;
import it.govpay.bd.BasicBD;
import it.govpay.bd.anagrafica.PspBD;
import it.govpay.core.exceptions.GovPayException;
import it.govpay.core.utils.GpContext;
import it.govpay.core.utils.GpThreadLocal;
import it.govpay.servizi.commons.EsitoOperazione;
import it.agid.pap.model.psp.InformativaDetail;
import it.agid.pap.model.psp.InformativaMaster;
import it.agid.pap.model.psp.PSP;
import it.agid.pap.util.FaultCodes;
import it.agid.pap.util.PapConstants;
import it.agid.pap.ws.clients.json.JsonList;
import it.agid.pap.ws.rest.BasePapRsService;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

@Path("/pap/{codDominio}/psps")
public class PspRestController extends BasePapRsService {
	
	public PspRestController() {
		super("PapRest");
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestChiediListaPSP(InputStream is, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders, 
			@DefaultValue(PapConstants.LIST_RESULTS_PARAM) @QueryParam("risultati") Integer risultati,
			@DefaultValue(PapConstants.LIST_PAGE_PARAM) @QueryParam("pagina") Integer pagina) {

		
		GpContext ctx = GpThreadLocal.get();
		
		BasicBD bd = null;
		try {
			logRequest(uriInfo, httpHeaders,"papRestChiediListaPSP", is);

			ctx.log("pap.ricevutaRichiesta");
			bd = BasicBD.newInstance(ctx.getTransactionId());
			PspBD pspBD = new PspBD(bd);
			List<it.govpay.bd.model.Psp> psps = pspBD.getPsp(true);

			JsonList<PSP> jsonList = new JsonList<PSP>();
			jsonList.setList(new ArrayList<PSP>());
			
			for(it.govpay.bd.model.Psp pspModel : psps) {
				PSP psp = new PSP();
				psp.setIdentificativoFlusso(pspModel.getCodFlusso());
				psp.setIdentificativoPSP(pspModel.getCodPsp());

				InformativaMaster informativaMaster = new InformativaMaster();
				informativaMaster.setDataInizioValidita("1970-01-01T00:00:00");
				informativaMaster.setDataPubblicazione("1970-01-01T00:00:00");
				informativaMaster.setUrlInformazioniPSP(pspModel.getUrlInfo());
				psp.setInformativaMaster(informativaMaster);

				List<InformativaDetail> listaInformativaDetail = new ArrayList<InformativaDetail>();
				for(it.govpay.bd.model.Canale canaleModel : pspModel.getCanalis()) {
					InformativaDetail informativa = new InformativaDetail();
					informativa.setCondizioniEconomicheMassime(canaleModel.getCondizioni());
					informativa.setDescrizioneServizio(canaleModel.getDescrizione());
					informativa.setDisponibilitaServizio(canaleModel.getDisponibilita());
					informativa.setIdentificativoCanale(canaleModel.getCodCanale());
					informativa.setIdentificativoIntermediario(canaleModel.getCodIntermediario());
					informativa.setPriorita("0");
					informativa.setTipoVersamento(canaleModel.getTipoVersamento().getCodifica());
					informativa.setUrlInformazioniCanale(canaleModel.getUrlInfo());
					listaInformativaDetail.add(informativa);
				}

				psp.setListaInformativaDetail(listaInformativaDetail);
				psp.setRagioneSociale(pspModel.getRagioneSociale());
				jsonList.getList().add(psp);
			}
			jsonList.setCount(jsonList.getList().size());
			ctx.log("pap.ricevutaRichiestaOk");
			logResponse(uriInfo, httpHeaders,"papRestChiediListaPSP", toOutputStream(jsonList));
			return Response.status(Status.OK).entity(jsonList).build();
		} catch (Exception e) {
			new GovPayException(e).log(log);
			ctx.log("pap.ricevutaRichiestaKo", EsitoOperazione.INTERNAL.toString(), e.getMessage());
			FaultBean fault = new FaultBean();
			fault.setFaultCode(FaultCodes.PAP_UNEXPECTED_ERROR.name());
			fault.setFaultString(e.getMessage());
			logResponse(uriInfo, httpHeaders,"papRestChiediListaPSP", toOutputStream(fault));
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(fault).build();
		} finally {
			if(ctx != null) {
				ctx.log();
			}
			if(bd != null) bd.closeConnection();
		}

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response papRestAggiornaListaPSP() {
		return Response.status(Status.CREATED).build();
	}
}

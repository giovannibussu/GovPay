package it.agid.pap.ws.wrapper.nodo;

import it.agid.pap.ws.wrapper.AbstractWsWrapper;
import it.gov.spcoop.nodopagamentispc.servizi.pagamentitelematicirpt.PagamentiTelematiciRPT;
import it.gov.spcoop.nodopagamentispc.servizi.pagamentitelematicirpt.PagamentiTelematiciRPTservice;

public class NodoWrapper extends AbstractWsWrapper<PagamentiTelematiciRPT, PagamentiTelematiciRPTservice> implements
		INodoWrapper<PagamentiTelematiciRPT> {

	private static final String NODO_PER_PA_WSDL = "Nodo_per_PA.wsdl";
	private static final String NAMESPACE = "http://NodoPagamentiSPC.spcoop.gov.it/servizi/PagamentiTelematiciRPT";

	@Override
	protected String getNamespace() {
		return NAMESPACE;
	}

	@Override
	protected String getWsClassName() {
		return PagamentiTelematiciRPT.class.getName();
	}

	@Override
	protected String getWsBindClassName() {
		return PagamentiTelematiciRPTservice.class.getName();
	}

	@Override
	protected String getWSDLName() {
		return NODO_PER_PA_WSDL;
	}

}

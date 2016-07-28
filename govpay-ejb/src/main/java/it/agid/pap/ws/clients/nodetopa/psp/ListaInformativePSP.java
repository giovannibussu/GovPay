package it.agid.pap.ws.clients.nodetopa.psp;

import it.agid.pap.model.psp.PSP;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaInformativePSP {
	
	 @XmlElement(name="informativaPSP")
	private List<PSP> listaInformativePSP;

	public List<PSP> getListaInformativePSP() {
		return listaInformativePSP;
	}

	public void setListaInformativePSP(List<PSP> listaInformativePSP) {
		this.listaInformativePSP = listaInformativePSP;
	}
	
}

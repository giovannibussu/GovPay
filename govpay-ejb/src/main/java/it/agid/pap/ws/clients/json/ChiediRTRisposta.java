package it.agid.pap.ws.clients.json;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import it.gov.digitpa.schemas._2011.ws.paa.NodoChiediCopiaRTRisposta;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodoChiediCopiaRTRisposta", propOrder = {
    "tipoFirma",
    "rt",
    "statoPratica"
})
@JsonSerialize(include = Inclusion.NON_NULL)
public class ChiediRTRisposta extends NodoChiediCopiaRTRisposta {

	private String statoPratica;

	public String getStatoPratica() {
		return statoPratica;
	}

	public void setStatoPratica(String statoPratica) {
		this.statoPratica = statoPratica;
	}

	
}

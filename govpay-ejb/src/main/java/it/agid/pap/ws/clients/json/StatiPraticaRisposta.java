package it.agid.pap.ws.clients.json;

import javax.xml.bind.annotation.XmlElement;


public class StatiPraticaRisposta {

	private String statoIniziale;
	private String statoFinale;
	
	@XmlElement(name="stato_iniziale")
	public String getStatoIniziale() {
		return statoIniziale;
	}
	
	public void setStatoIniziale(String statoIniziale) {
		this.statoIniziale = statoIniziale;
	}
	
	@XmlElement(name="stato_finale")
	public String getStatoFinale() {
		return statoFinale;
	}
	public void setStatoFinale(String statoFinale) {
		this.statoFinale = statoFinale;
	}
	
	
	
}

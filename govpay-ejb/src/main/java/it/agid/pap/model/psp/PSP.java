package it.agid.pap.model.psp;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PSP {

	/**
	 * Identificativo dell�informativa del PSP utile ad identificare la
	 * comunicazione (es. numero di protocollo).
	 */
	@XmlElement(name = "identificativoFlusso")
	private String identificativoFlusso;

	/**
	 * Identificativo del PSP (codice utilizzato nelle primitive web services) a
	 * cui si riferisce il flusso di informativa.
	 */
	@XmlElement(name = "identificativoPSP")
	private String identificativoPSP;

	/**
	 * Ragione sociale del PSP.
	 */
	private String ragioneSociale;

	/**
	 * Aggregazione corrispondente ai dati comuni del presente flusso di
	 * informativa.
	 */
	private InformativaMaster informativaMaster;

	/**
	 * Aggregazione corrispondente alla lista di informative relative ai singoli
	 * CANALI /Intermediari del PSP.
	 */
	@XmlElementWrapper(name = "listaInformativaDetail")
	@XmlElement(name = "informativaDetail")
	private List<InformativaDetail> listaInformativaDetail;

	/**
	 * @return the {@link PSP#identificativoFlusso}
	 */
	public String getIdentificativoFlusso() {
		return identificativoFlusso;
	}

	/**
	 * @param identificativoFlusso
	 *            the identificativoFlusso to set
	 */
	public void setIdentificativoFlusso(String identificativoFlusso) {
		this.identificativoFlusso = identificativoFlusso;
	}

	/**
	 * @return the {@link PSP#identificativoPSP}
	 */
	public String getIdentificativoPSP() {
		return identificativoPSP;
	}

	/**
	 * @param identificativoPSP
	 *            the identificativoPSP to set
	 */
	public void setIdentificativoPSP(String identificativoPSP) {
		this.identificativoPSP = identificativoPSP;
	}

	/**
	 * @return the {@link PSP#ragioneSociale}
	 */
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	/**
	 * @param ragioneSociale
	 *            the ragioneSociale to set
	 */
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	/**
	 * @return the {@link PSP#informativaMaster}
	 */
	public InformativaMaster getInformativaMaster() {
		return informativaMaster;
	}

	/**
	 * @param informativaMaster
	 *            the informativaMaster to set
	 */
	public void setInformativaMaster(InformativaMaster informativaMaster) {
		this.informativaMaster = informativaMaster;
	}

	/**
	 * @return the {@link PSP#listaInformativaDetail}
	 */
	public List<InformativaDetail> getListaInformativaDetail() {
		return listaInformativaDetail;
	}

	/**
	 * @param listaInformativaDetail
	 *            the listaInformativaDetail to set
	 */
	public void setListaInformativaDetail(
			List<InformativaDetail> listaInformativaDetail) {
		this.listaInformativaDetail = listaInformativaDetail;
	}

}

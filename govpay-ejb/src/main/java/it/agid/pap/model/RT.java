package it.agid.pap.model;

import it.agid.pap.util.DateAdapter;
import it.agid.pap.util.DateTimeAdapter;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement(name = "RT")
@JsonIgnoreProperties({"data",  "id" ,"insertDate", "lastUpdate", "cancelled", "tipoFirma", "statoRendicontazione"}) //xml
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "versioneOggetto", "dominio", "identificativoMessaggioRicevuta", "dataOraMessaggioRicevuta", "riferimentoMessaggioRichiesta", "riferimentoDataRichiesta", "istitutoAttestante",
		"enteBeneficiario","soggettoVersante", "soggettoPagatore", "datiPagamento" })
public class RT extends AbstractComunicationEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1483046617119146607L;

	private String identificativoMessaggioRicevuta;

	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private Date dataOraMessaggioRicevuta;

	private String riferimentoMessaggioRichiesta;

	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date riferimentoDataRichiesta;

	private IstitutoAttestante istitutoAttestante;

	private DatiPagamento datiPagamento;

//	@Column(name = "rt_xml", columnDefinition = "MEDIUMTEXT")
//	@XmlTransient
//	private String xml;
	
	@XmlTransient
	private byte[] data;
	
	@XmlTransient
	private String tipoFirma;

	@XmlTransient
	private String statoRendicontazione;
	
	public String getIdentificativoMessaggioRicevuta() {
		return identificativoMessaggioRicevuta;
	}

	public void setIdentificativoMessaggioRicevuta(String value) {
		this.identificativoMessaggioRicevuta = value;
	}

	public Date getDataOraMessaggioRicevuta() {
		return this.dataOraMessaggioRicevuta != null ? new Date(this.dataOraMessaggioRicevuta.getTime()) : null;
	}

	public void setDataOraMessaggioRicevuta(Date value) {
		if (value != null) {
			this.dataOraMessaggioRicevuta = new Date(value.getTime());
		}
	}

	public String getRiferimentoMessaggioRichiesta() {
		return riferimentoMessaggioRichiesta;
	}

	public void setRiferimentoMessaggioRichiesta(String value) {
		this.riferimentoMessaggioRichiesta = value;
	}

	public Date getRiferimentoDataRichiesta() {
		return this.riferimentoDataRichiesta != null ? new Date(this.riferimentoDataRichiesta.getTime()) : null;
	}

	public void setRiferimentoDataRichiesta(Date value) {
		if (value != null) {
			this.riferimentoDataRichiesta = new Date(value.getTime());
		}
	}

	public IstitutoAttestante getIstitutoAttestante() {
		return istitutoAttestante;
	}

	public void setIstitutoAttestante(IstitutoAttestante value) {
		this.istitutoAttestante = value;
	}

	public DatiPagamento getDatiPagamento() {
		return datiPagamento;
	}

	public void setDatiPagamento(DatiPagamento value) {
		this.datiPagamento = value;
	}

//	public String getXml() {
//		return xml;
//	}
//
//	public void setXml(String xml) {
//		this.xml = xml;
//	}
	
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getTipoFirma() {
		return tipoFirma;
	}

	public void setTipoFirma(String tipoFirma) {
		this.tipoFirma = tipoFirma;
	}

	public String getStatoRendicontazione() {
		return statoRendicontazione;
	}

	public void setStatoRendicontazione(String statoRendicontazione) {
		this.statoRendicontazione = statoRendicontazione;
	}
	
	
	
}

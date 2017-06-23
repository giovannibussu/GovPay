/*
 * GovPay - Porta di Accesso al Nodo dei Pagamenti SPC 
 * http://www.gov4j.it/govpay
 * 
 * Copyright (c) 2014-2017 Link.it srl (http://www.link.it).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3, as published by
 * the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package it.govpay.orm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/** <p>Java class for AvvisoDigitale complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AvvisoDigitale">
 * 		&lt;sequence>
 * 			&lt;element name="idMessaggioRichiesta" type="{http://www.govpay.it/orm}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="idDominio" type="{http://www.govpay.it/orm}id-dominio" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="codiceAvviso" type="{http://www.govpay.it/orm}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="stato" type="{http://www.govpay.it/orm}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="descrizioneStato" type="{http://www.govpay.it/orm}string" minOccurs="0" maxOccurs="1"/>
 * 			&lt;element name="importoAvviso" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="descrizionePagamento" type="{http://www.govpay.it/orm}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="tassonomia" type="{http://www.govpay.it/orm}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="anagraficaPagatore" type="{http://www.govpay.it/orm}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="tipoIdentificativoUnivoco" type="{http://www.govpay.it/orm}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="codiceIdentificativoUnivoco" type="{http://www.govpay.it/orm}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="emailSoggettoPagatore" type="{http://www.govpay.it/orm}string" minOccurs="0" maxOccurs="1"/>
 * 			&lt;element name="cellulareSoggettoPagatore" type="{http://www.govpay.it/orm}string" minOccurs="0" maxOccurs="1"/>
 * 			&lt;element name="dataScadenzaPagamento" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="dataScadenzaAvviso" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="dataCreazione" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="urlAvviso" type="{http://www.govpay.it/orm}string" minOccurs="0" maxOccurs="1"/>
 * 		&lt;/sequence>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev$, $Date$
 * 
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvvisoDigitale", 
  propOrder = {
  	"idMessaggioRichiesta",
  	"idDominio",
  	"codiceAvviso",
  	"stato",
  	"descrizioneStato",
  	"importoAvviso",
  	"descrizionePagamento",
  	"tassonomia",
  	"anagraficaPagatore",
  	"tipoIdentificativoUnivoco",
  	"codiceIdentificativoUnivoco",
  	"emailSoggettoPagatore",
  	"cellulareSoggettoPagatore",
  	"dataScadenzaPagamento",
  	"dataScadenzaAvviso",
  	"dataCreazione",
  	"urlAvviso"
  }
)

@XmlRootElement(name = "AvvisoDigitale")

public class AvvisoDigitale extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public AvvisoDigitale() {
  }

  public Long getId() {
    if(this.id!=null)
		return this.id;
	else
		return new Long(-1);
  }

  public void setId(Long id) {
    if(id!=null)
		this.id=id;
	else
		this.id=new Long(-1);
  }

  public java.lang.String getIdMessaggioRichiesta() {
    return this.idMessaggioRichiesta;
  }

  public void setIdMessaggioRichiesta(java.lang.String idMessaggioRichiesta) {
    this.idMessaggioRichiesta = idMessaggioRichiesta;
  }

  public IdDominio getIdDominio() {
    return this.idDominio;
  }

  public void setIdDominio(IdDominio idDominio) {
    this.idDominio = idDominio;
  }

  public java.lang.String getCodiceAvviso() {
    return this.codiceAvviso;
  }

  public void setCodiceAvviso(java.lang.String codiceAvviso) {
    this.codiceAvviso = codiceAvviso;
  }

  public java.lang.String getStato() {
    return this.stato;
  }

  public void setStato(java.lang.String stato) {
    this.stato = stato;
  }

  public java.lang.String getDescrizioneStato() {
    return this.descrizioneStato;
  }

  public void setDescrizioneStato(java.lang.String descrizioneStato) {
    this.descrizioneStato = descrizioneStato;
  }

  public double getImportoAvviso() {
    return this.importoAvviso;
  }

  public void setImportoAvviso(double importoAvviso) {
    this.importoAvviso = importoAvviso;
  }

  public java.lang.String getDescrizionePagamento() {
    return this.descrizionePagamento;
  }

  public void setDescrizionePagamento(java.lang.String descrizionePagamento) {
    this.descrizionePagamento = descrizionePagamento;
  }

  public java.lang.String getTassonomia() {
    return this.tassonomia;
  }

  public void setTassonomia(java.lang.String tassonomia) {
    this.tassonomia = tassonomia;
  }

  public java.lang.String getAnagraficaPagatore() {
    return this.anagraficaPagatore;
  }

  public void setAnagraficaPagatore(java.lang.String anagraficaPagatore) {
    this.anagraficaPagatore = anagraficaPagatore;
  }

  public java.lang.String getTipoIdentificativoUnivoco() {
    return this.tipoIdentificativoUnivoco;
  }

  public void setTipoIdentificativoUnivoco(java.lang.String tipoIdentificativoUnivoco) {
    this.tipoIdentificativoUnivoco = tipoIdentificativoUnivoco;
  }

  public java.lang.String getCodiceIdentificativoUnivoco() {
    return this.codiceIdentificativoUnivoco;
  }

  public void setCodiceIdentificativoUnivoco(java.lang.String codiceIdentificativoUnivoco) {
    this.codiceIdentificativoUnivoco = codiceIdentificativoUnivoco;
  }

  public java.lang.String getEmailSoggettoPagatore() {
    return this.emailSoggettoPagatore;
  }

  public void setEmailSoggettoPagatore(java.lang.String emailSoggettoPagatore) {
    this.emailSoggettoPagatore = emailSoggettoPagatore;
  }

  public java.lang.String getCellulareSoggettoPagatore() {
    return this.cellulareSoggettoPagatore;
  }

  public void setCellulareSoggettoPagatore(java.lang.String cellulareSoggettoPagatore) {
    this.cellulareSoggettoPagatore = cellulareSoggettoPagatore;
  }

  public java.util.Date getDataScadenzaPagamento() {
    return this.dataScadenzaPagamento;
  }

  public void setDataScadenzaPagamento(java.util.Date dataScadenzaPagamento) {
    this.dataScadenzaPagamento = dataScadenzaPagamento;
  }

  public java.util.Date getDataScadenzaAvviso() {
    return this.dataScadenzaAvviso;
  }

  public void setDataScadenzaAvviso(java.util.Date dataScadenzaAvviso) {
    this.dataScadenzaAvviso = dataScadenzaAvviso;
  }

  public java.util.Date getDataCreazione() {
    return this.dataCreazione;
  }

  public void setDataCreazione(java.util.Date dataCreazione) {
    this.dataCreazione = dataCreazione;
  }

  public java.lang.String getUrlAvviso() {
    return this.urlAvviso;
  }

  public void setUrlAvviso(java.lang.String urlAvviso) {
    this.urlAvviso = urlAvviso;
  }

  private static final long serialVersionUID = 1L;

  @XmlTransient
  private Long id;

  private static it.govpay.orm.model.AvvisoDigitaleModel modelStaticInstance = null;
  private static synchronized void initModelStaticInstance(){
	  if(it.govpay.orm.AvvisoDigitale.modelStaticInstance==null){
  			it.govpay.orm.AvvisoDigitale.modelStaticInstance = new it.govpay.orm.model.AvvisoDigitaleModel();
	  }
  }
  public static it.govpay.orm.model.AvvisoDigitaleModel model(){
	  if(it.govpay.orm.AvvisoDigitale.modelStaticInstance==null){
	  		initModelStaticInstance();
	  }
	  return it.govpay.orm.AvvisoDigitale.modelStaticInstance;
  }


  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="idMessaggioRichiesta",required=true,nillable=false)
  protected java.lang.String idMessaggioRichiesta;

  @XmlElement(name="idDominio",required=true,nillable=false)
  protected IdDominio idDominio;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="codiceAvviso",required=true,nillable=false)
  protected java.lang.String codiceAvviso;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="stato",required=true,nillable=false)
  protected java.lang.String stato;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="descrizioneStato",required=false,nillable=false)
  protected java.lang.String descrizioneStato;

  @javax.xml.bind.annotation.XmlSchemaType(name="double")
  @XmlElement(name="importoAvviso",required=true,nillable=false)
  protected double importoAvviso;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="descrizionePagamento",required=true,nillable=false)
  protected java.lang.String descrizionePagamento;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="tassonomia",required=true,nillable=false)
  protected java.lang.String tassonomia;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="anagraficaPagatore",required=true,nillable=false)
  protected java.lang.String anagraficaPagatore;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="tipoIdentificativoUnivoco",required=true,nillable=false)
  protected java.lang.String tipoIdentificativoUnivoco;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="codiceIdentificativoUnivoco",required=true,nillable=false)
  protected java.lang.String codiceIdentificativoUnivoco;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="emailSoggettoPagatore",required=false,nillable=false)
  protected java.lang.String emailSoggettoPagatore;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="cellulareSoggettoPagatore",required=false,nillable=false)
  protected java.lang.String cellulareSoggettoPagatore;

  @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.Date2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="date")
  @XmlElement(name="dataScadenzaPagamento",required=true,nillable=false,type=java.lang.String.class)
  protected java.util.Date dataScadenzaPagamento;

  @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.Date2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="date")
  @XmlElement(name="dataScadenzaAvviso",required=true,nillable=false,type=java.lang.String.class)
  protected java.util.Date dataScadenzaAvviso;

  @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.Date2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="date")
  @XmlElement(name="dataCreazione",required=true,nillable=false,type=java.lang.String.class)
  protected java.util.Date dataCreazione;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="urlAvviso",required=false,nillable=false)
  protected java.lang.String urlAvviso;

}

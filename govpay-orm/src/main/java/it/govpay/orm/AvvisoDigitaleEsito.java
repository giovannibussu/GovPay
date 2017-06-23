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


/** <p>Java class for AvvisoDigitaleEsito complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AvvisoDigitaleEsito">
 * 		&lt;sequence>
 * 			&lt;element name="idMessaggioRichiesta" type="{http://www.govpay.it/orm}string" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="idAvvisoDigitale" type="{http://www.govpay.it/orm}id-avviso-digitale" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="identificativoCanale" type="{http://www.govpay.it/orm}string" minOccurs="0" maxOccurs="1"/>
 * 			&lt;element name="tipoCanaleEsito" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="dataEsito" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="codiceEsito" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="1" maxOccurs="1"/>
 * 			&lt;element name="descrizioneEsito" type="{http://www.govpay.it/orm}string" minOccurs="0" maxOccurs="1"/>
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
@XmlType(name = "AvvisoDigitaleEsito", 
  propOrder = {
  	"idMessaggioRichiesta",
  	"idAvvisoDigitale",
  	"identificativoCanale",
  	"tipoCanaleEsito",
  	"dataEsito",
  	"codiceEsito",
  	"descrizioneEsito"
  }
)

@XmlRootElement(name = "AvvisoDigitaleEsito")

public class AvvisoDigitaleEsito extends org.openspcoop2.utils.beans.BaseBean implements Serializable , Cloneable {
  public AvvisoDigitaleEsito() {
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

  public IdAvvisoDigitale getIdAvvisoDigitale() {
    return this.idAvvisoDigitale;
  }

  public void setIdAvvisoDigitale(IdAvvisoDigitale idAvvisoDigitale) {
    this.idAvvisoDigitale = idAvvisoDigitale;
  }

  public java.lang.String getIdentificativoCanale() {
    return this.identificativoCanale;
  }

  public void setIdentificativoCanale(java.lang.String identificativoCanale) {
    this.identificativoCanale = identificativoCanale;
  }

  public long getTipoCanaleEsito() {
    return this.tipoCanaleEsito;
  }

  public void setTipoCanaleEsito(long tipoCanaleEsito) {
    this.tipoCanaleEsito = tipoCanaleEsito;
  }

  public java.util.Date getDataEsito() {
    return this.dataEsito;
  }

  public void setDataEsito(java.util.Date dataEsito) {
    this.dataEsito = dataEsito;
  }

  public long getCodiceEsito() {
    return this.codiceEsito;
  }

  public void setCodiceEsito(long codiceEsito) {
    this.codiceEsito = codiceEsito;
  }

  public java.lang.String getDescrizioneEsito() {
    return this.descrizioneEsito;
  }

  public void setDescrizioneEsito(java.lang.String descrizioneEsito) {
    this.descrizioneEsito = descrizioneEsito;
  }

  private static final long serialVersionUID = 1L;

  @XmlTransient
  private Long id;

  private static it.govpay.orm.model.AvvisoDigitaleEsitoModel modelStaticInstance = null;
  private static synchronized void initModelStaticInstance(){
	  if(it.govpay.orm.AvvisoDigitaleEsito.modelStaticInstance==null){
  			it.govpay.orm.AvvisoDigitaleEsito.modelStaticInstance = new it.govpay.orm.model.AvvisoDigitaleEsitoModel();
	  }
  }
  public static it.govpay.orm.model.AvvisoDigitaleEsitoModel model(){
	  if(it.govpay.orm.AvvisoDigitaleEsito.modelStaticInstance==null){
	  		initModelStaticInstance();
	  }
	  return it.govpay.orm.AvvisoDigitaleEsito.modelStaticInstance;
  }


  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="idMessaggioRichiesta",required=true,nillable=false)
  protected java.lang.String idMessaggioRichiesta;

  @XmlElement(name="idAvvisoDigitale",required=true,nillable=false)
  protected IdAvvisoDigitale idAvvisoDigitale;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="identificativoCanale",required=false,nillable=false)
  protected java.lang.String identificativoCanale;

  @javax.xml.bind.annotation.XmlSchemaType(name="long")
  @XmlElement(name="tipoCanaleEsito",required=true,nillable=false)
  protected long tipoCanaleEsito;

  @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.openspcoop2.utils.jaxb.Date2String.class)
  @javax.xml.bind.annotation.XmlSchemaType(name="date")
  @XmlElement(name="dataEsito",required=true,nillable=false,type=java.lang.String.class)
  protected java.util.Date dataEsito;

  @javax.xml.bind.annotation.XmlSchemaType(name="long")
  @XmlElement(name="codiceEsito",required=true,nillable=false)
  protected long codiceEsito;

  @javax.xml.bind.annotation.XmlSchemaType(name="string")
  @XmlElement(name="descrizioneEsito",required=false,nillable=false)
  protected java.lang.String descrizioneEsito;

}

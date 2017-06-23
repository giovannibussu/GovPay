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
package it.govpay.orm.model;

import it.govpay.orm.AvvisoDigitaleEsito;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model AvvisoDigitaleEsito 
 *
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class AvvisoDigitaleEsitoModel extends AbstractModel<AvvisoDigitaleEsito> {

	public AvvisoDigitaleEsitoModel(){
	
		super();
	
		this.ID_MESSAGGIO_RICHIESTA = new Field("idMessaggioRichiesta",java.lang.String.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
		this.ID_AVVISO_DIGITALE = new it.govpay.orm.model.IdAvvisoDigitaleModel(new Field("idAvvisoDigitale",it.govpay.orm.IdAvvisoDigitale.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class));
		this.IDENTIFICATIVO_CANALE = new Field("identificativoCanale",java.lang.String.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
		this.TIPO_CANALE_ESITO = new Field("tipoCanaleEsito",long.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
		this.DATA_ESITO = new Field("dataEsito",java.util.Date.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
		this.CODICE_ESITO = new Field("codiceEsito",long.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
		this.DESCRIZIONE_ESITO = new Field("descrizioneEsito",java.lang.String.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
	
	}
	
	public AvvisoDigitaleEsitoModel(IField father){
	
		super(father);
	
		this.ID_MESSAGGIO_RICHIESTA = new ComplexField(father,"idMessaggioRichiesta",java.lang.String.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
		this.ID_AVVISO_DIGITALE = new it.govpay.orm.model.IdAvvisoDigitaleModel(new ComplexField(father,"idAvvisoDigitale",it.govpay.orm.IdAvvisoDigitale.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class));
		this.IDENTIFICATIVO_CANALE = new ComplexField(father,"identificativoCanale",java.lang.String.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
		this.TIPO_CANALE_ESITO = new ComplexField(father,"tipoCanaleEsito",long.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
		this.DATA_ESITO = new ComplexField(father,"dataEsito",java.util.Date.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
		this.CODICE_ESITO = new ComplexField(father,"codiceEsito",long.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
		this.DESCRIZIONE_ESITO = new ComplexField(father,"descrizioneEsito",java.lang.String.class,"AvvisoDigitaleEsito",AvvisoDigitaleEsito.class);
	
	}
	
	

	public IField ID_MESSAGGIO_RICHIESTA = null;
	 
	public it.govpay.orm.model.IdAvvisoDigitaleModel ID_AVVISO_DIGITALE = null;
	 
	public IField IDENTIFICATIVO_CANALE = null;
	 
	public IField TIPO_CANALE_ESITO = null;
	 
	public IField DATA_ESITO = null;
	 
	public IField CODICE_ESITO = null;
	 
	public IField DESCRIZIONE_ESITO = null;
	 

	@Override
	public Class<AvvisoDigitaleEsito> getModeledClass(){
		return AvvisoDigitaleEsito.class;
	}
	
	@Override
	public String toString(){
		if(this.getModeledClass()!=null){
			return this.getModeledClass().getName();
		}else{
			return "N.D.";
		}
	}

}
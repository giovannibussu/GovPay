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

import it.govpay.orm.AvvisoDigitale;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model AvvisoDigitale 
 *
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class AvvisoDigitaleModel extends AbstractModel<AvvisoDigitale> {

	public AvvisoDigitaleModel(){
	
		super();
	
		this.ID_MESSAGGIO_RICHIESTA = new Field("idMessaggioRichiesta",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.ID_DOMINIO = new it.govpay.orm.model.IdDominioModel(new Field("idDominio",it.govpay.orm.IdDominio.class,"AvvisoDigitale",AvvisoDigitale.class));
		this.CODICE_AVVISO = new Field("codiceAvviso",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.STATO = new Field("stato",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.DESCRIZIONE_STATO = new Field("descrizioneStato",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.IMPORTO_AVVISO = new Field("importoAvviso",double.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.DESCRIZIONE_PAGAMENTO = new Field("descrizionePagamento",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.TASSONOMIA = new Field("tassonomia",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.ANAGRAFICA_PAGATORE = new Field("anagraficaPagatore",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.TIPO_IDENTIFICATIVO_UNIVOCO = new Field("tipoIdentificativoUnivoco",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.CODICE_IDENTIFICATIVO_UNIVOCO = new Field("codiceIdentificativoUnivoco",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.EMAIL_SOGGETTO_PAGATORE = new Field("emailSoggettoPagatore",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.CELLULARE_SOGGETTO_PAGATORE = new Field("cellulareSoggettoPagatore",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.DATA_SCADENZA_PAGAMENTO = new Field("dataScadenzaPagamento",java.util.Date.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.DATA_SCADENZA_AVVISO = new Field("dataScadenzaAvviso",java.util.Date.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.DATA_CREAZIONE = new Field("dataCreazione",java.util.Date.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.URL_AVVISO = new Field("urlAvviso",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
	
	}
	
	public AvvisoDigitaleModel(IField father){
	
		super(father);
	
		this.ID_MESSAGGIO_RICHIESTA = new ComplexField(father,"idMessaggioRichiesta",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.ID_DOMINIO = new it.govpay.orm.model.IdDominioModel(new ComplexField(father,"idDominio",it.govpay.orm.IdDominio.class,"AvvisoDigitale",AvvisoDigitale.class));
		this.CODICE_AVVISO = new ComplexField(father,"codiceAvviso",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.STATO = new ComplexField(father,"stato",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.DESCRIZIONE_STATO = new ComplexField(father,"descrizioneStato",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.IMPORTO_AVVISO = new ComplexField(father,"importoAvviso",double.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.DESCRIZIONE_PAGAMENTO = new ComplexField(father,"descrizionePagamento",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.TASSONOMIA = new ComplexField(father,"tassonomia",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.ANAGRAFICA_PAGATORE = new ComplexField(father,"anagraficaPagatore",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.TIPO_IDENTIFICATIVO_UNIVOCO = new ComplexField(father,"tipoIdentificativoUnivoco",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.CODICE_IDENTIFICATIVO_UNIVOCO = new ComplexField(father,"codiceIdentificativoUnivoco",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.EMAIL_SOGGETTO_PAGATORE = new ComplexField(father,"emailSoggettoPagatore",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.CELLULARE_SOGGETTO_PAGATORE = new ComplexField(father,"cellulareSoggettoPagatore",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.DATA_SCADENZA_PAGAMENTO = new ComplexField(father,"dataScadenzaPagamento",java.util.Date.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.DATA_SCADENZA_AVVISO = new ComplexField(father,"dataScadenzaAvviso",java.util.Date.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.DATA_CREAZIONE = new ComplexField(father,"dataCreazione",java.util.Date.class,"AvvisoDigitale",AvvisoDigitale.class);
		this.URL_AVVISO = new ComplexField(father,"urlAvviso",java.lang.String.class,"AvvisoDigitale",AvvisoDigitale.class);
	
	}
	
	

	public IField ID_MESSAGGIO_RICHIESTA = null;
	 
	public it.govpay.orm.model.IdDominioModel ID_DOMINIO = null;
	 
	public IField CODICE_AVVISO = null;
	 
	public IField STATO = null;
	 
	public IField DESCRIZIONE_STATO = null;
	 
	public IField IMPORTO_AVVISO = null;
	 
	public IField DESCRIZIONE_PAGAMENTO = null;
	 
	public IField TASSONOMIA = null;
	 
	public IField ANAGRAFICA_PAGATORE = null;
	 
	public IField TIPO_IDENTIFICATIVO_UNIVOCO = null;
	 
	public IField CODICE_IDENTIFICATIVO_UNIVOCO = null;
	 
	public IField EMAIL_SOGGETTO_PAGATORE = null;
	 
	public IField CELLULARE_SOGGETTO_PAGATORE = null;
	 
	public IField DATA_SCADENZA_PAGAMENTO = null;
	 
	public IField DATA_SCADENZA_AVVISO = null;
	 
	public IField DATA_CREAZIONE = null;
	 
	public IField URL_AVVISO = null;
	 

	@Override
	public Class<AvvisoDigitale> getModeledClass(){
		return AvvisoDigitale.class;
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
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

import it.govpay.orm.Dominio;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model Dominio 
 *
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class DominioModel extends AbstractModel<Dominio> {

	public DominioModel(){
	
		super();
	
		this.ID_STAZIONE = new it.govpay.orm.model.IdStazioneModel(new Field("idStazione",it.govpay.orm.IdStazione.class,"Dominio",Dominio.class));
		this.COD_DOMINIO = new Field("codDominio",java.lang.String.class,"Dominio",Dominio.class);
		this.GLN = new Field("gln",java.lang.String.class,"Dominio",Dominio.class);
		this.ABILITATO = new Field("abilitato",boolean.class,"Dominio",Dominio.class);
		this.RAGIONE_SOCIALE = new Field("ragioneSociale",java.lang.String.class,"Dominio",Dominio.class);
		this.XML_CONTI_ACCREDITO = new Field("xmlContiAccredito",byte[].class,"Dominio",Dominio.class);
		this.XML_TABELLA_CONTROPARTI = new Field("xmlTabellaControparti",byte[].class,"Dominio",Dominio.class);
		this.RIUSO_IUV = new Field("riusoIUV",boolean.class,"Dominio",Dominio.class);
		this.CUSTOM_IUV = new Field("customIUV",boolean.class,"Dominio",Dominio.class);
		this.ID_APPLICAZIONE_DEFAULT = new it.govpay.orm.model.IdApplicazioneModel(new Field("idApplicazioneDefault",it.govpay.orm.IdApplicazione.class,"Dominio",Dominio.class));
		this.AUX_DIGIT = new Field("auxDigit",int.class,"Dominio",Dominio.class);
		this.IUV_PREFIX = new Field("iuvPrefix",java.lang.String.class,"Dominio",Dominio.class);
		this.IUV_PREFIX_STRICT = new Field("iuvPrefixStrict",boolean.class,"Dominio",Dominio.class);
		this.SEGREGATION_CODE = new Field("segregationCode",java.lang.Integer.class,"Dominio",Dominio.class);
		this.NDP_STATO = new Field("ndpStato",java.lang.Integer.class,"Dominio",Dominio.class);
		this.NDP_OPERAZIONE = new Field("ndpOperazione",java.lang.String.class,"Dominio",Dominio.class);
		this.NDP_DESCRIZIONE = new Field("ndpDescrizione",java.lang.String.class,"Dominio",Dominio.class);
		this.NDP_DATA = new Field("ndpData",java.util.Date.class,"Dominio",Dominio.class);
		this.AVVISI_DIGITALI = new Field("avvisiDigitali",boolean.class,"Dominio",Dominio.class);
	
	}
	
	public DominioModel(IField father){
	
		super(father);
	
		this.ID_STAZIONE = new it.govpay.orm.model.IdStazioneModel(new ComplexField(father,"idStazione",it.govpay.orm.IdStazione.class,"Dominio",Dominio.class));
		this.COD_DOMINIO = new ComplexField(father,"codDominio",java.lang.String.class,"Dominio",Dominio.class);
		this.GLN = new ComplexField(father,"gln",java.lang.String.class,"Dominio",Dominio.class);
		this.ABILITATO = new ComplexField(father,"abilitato",boolean.class,"Dominio",Dominio.class);
		this.RAGIONE_SOCIALE = new ComplexField(father,"ragioneSociale",java.lang.String.class,"Dominio",Dominio.class);
		this.XML_CONTI_ACCREDITO = new ComplexField(father,"xmlContiAccredito",byte[].class,"Dominio",Dominio.class);
		this.XML_TABELLA_CONTROPARTI = new ComplexField(father,"xmlTabellaControparti",byte[].class,"Dominio",Dominio.class);
		this.RIUSO_IUV = new ComplexField(father,"riusoIUV",boolean.class,"Dominio",Dominio.class);
		this.CUSTOM_IUV = new ComplexField(father,"customIUV",boolean.class,"Dominio",Dominio.class);
		this.ID_APPLICAZIONE_DEFAULT = new it.govpay.orm.model.IdApplicazioneModel(new ComplexField(father,"idApplicazioneDefault",it.govpay.orm.IdApplicazione.class,"Dominio",Dominio.class));
		this.AUX_DIGIT = new ComplexField(father,"auxDigit",int.class,"Dominio",Dominio.class);
		this.IUV_PREFIX = new ComplexField(father,"iuvPrefix",java.lang.String.class,"Dominio",Dominio.class);
		this.IUV_PREFIX_STRICT = new ComplexField(father,"iuvPrefixStrict",boolean.class,"Dominio",Dominio.class);
		this.SEGREGATION_CODE = new ComplexField(father,"segregationCode",java.lang.Integer.class,"Dominio",Dominio.class);
		this.NDP_STATO = new ComplexField(father,"ndpStato",java.lang.Integer.class,"Dominio",Dominio.class);
		this.NDP_OPERAZIONE = new ComplexField(father,"ndpOperazione",java.lang.String.class,"Dominio",Dominio.class);
		this.NDP_DESCRIZIONE = new ComplexField(father,"ndpDescrizione",java.lang.String.class,"Dominio",Dominio.class);
		this.NDP_DATA = new ComplexField(father,"ndpData",java.util.Date.class,"Dominio",Dominio.class);
		this.AVVISI_DIGITALI = new ComplexField(father,"avvisiDigitali",boolean.class,"Dominio",Dominio.class);
	
	}
	
	

	public it.govpay.orm.model.IdStazioneModel ID_STAZIONE = null;
	 
	public IField COD_DOMINIO = null;
	 
	public IField GLN = null;
	 
	public IField ABILITATO = null;
	 
	public IField RAGIONE_SOCIALE = null;
	 
	public IField XML_CONTI_ACCREDITO = null;
	 
	public IField XML_TABELLA_CONTROPARTI = null;
	 
	public IField RIUSO_IUV = null;
	 
	public IField CUSTOM_IUV = null;
	 
	public it.govpay.orm.model.IdApplicazioneModel ID_APPLICAZIONE_DEFAULT = null;
	 
	public IField AUX_DIGIT = null;
	 
	public IField IUV_PREFIX = null;
	 
	public IField IUV_PREFIX_STRICT = null;
	 
	public IField SEGREGATION_CODE = null;
	 
	public IField NDP_STATO = null;
	 
	public IField NDP_OPERAZIONE = null;
	 
	public IField NDP_DESCRIZIONE = null;
	 
	public IField NDP_DATA = null;
	 
	public IField AVVISI_DIGITALI = null;
	 

	@Override
	public Class<Dominio> getModeledClass(){
		return Dominio.class;
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
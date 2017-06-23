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
package it.govpay.orm.dao.jdbc.converter;

import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.IModel;
import org.openspcoop2.generic_project.exception.ExpressionException;
import org.openspcoop2.generic_project.expression.impl.sql.AbstractSQLFieldConverter;
import org.openspcoop2.utils.TipiDatabase;

import it.govpay.orm.AvvisoDigitale;


/**     
 * AvvisoDigitaleFieldConverter
 *
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class AvvisoDigitaleFieldConverter extends AbstractSQLFieldConverter {

	private TipiDatabase databaseType;
	
	public AvvisoDigitaleFieldConverter(String databaseType){
		this.databaseType = TipiDatabase.toEnumConstant(databaseType);
	}
	public AvvisoDigitaleFieldConverter(TipiDatabase databaseType){
		this.databaseType = databaseType;
	}


	@Override
	public IModel<?> getRootModel() throws ExpressionException {
		return AvvisoDigitale.model();
	}
	
	@Override
	public TipiDatabase getDatabaseType() throws ExpressionException {
		return this.databaseType;
	}
	


	@Override
	public String toColumn(IField field,boolean returnAlias,boolean appendTablePrefix) throws ExpressionException {
		
		// In the case of columns with alias, using parameter returnAlias​​, 
		// it is possible to drive the choice whether to return only the alias or 
		// the full definition of the column containing the alias
		
		if(field.equals(AvvisoDigitale.model().ID_MESSAGGIO_RICHIESTA)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".id_messaggio_richiesta";
			}else{
				return "id_messaggio_richiesta";
			}
		}
		if(field.equals(AvvisoDigitale.model().ID_DOMINIO.COD_DOMINIO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".cod_dominio";
			}else{
				return "cod_dominio";
			}
		}
		if(field.equals(AvvisoDigitale.model().CODICE_AVVISO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".codice_avviso";
			}else{
				return "codice_avviso";
			}
		}
		if(field.equals(AvvisoDigitale.model().STATO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".stato";
			}else{
				return "stato";
			}
		}
		if(field.equals(AvvisoDigitale.model().DESCRIZIONE_STATO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".descrizione_stato";
			}else{
				return "descrizione_stato";
			}
		}
		if(field.equals(AvvisoDigitale.model().IMPORTO_AVVISO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".importo_avviso";
			}else{
				return "importo_avviso";
			}
		}
		if(field.equals(AvvisoDigitale.model().DESCRIZIONE_PAGAMENTO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".descrizione_pagamento";
			}else{
				return "descrizione_pagamento";
			}
		}
		if(field.equals(AvvisoDigitale.model().TASSONOMIA)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".tassonomia";
			}else{
				return "tassonomia";
			}
		}
		if(field.equals(AvvisoDigitale.model().ANAGRAFICA_PAGATORE)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".anagrafica_pagatore";
			}else{
				return "anagrafica_pagatore";
			}
		}
		if(field.equals(AvvisoDigitale.model().TIPO_IDENTIFICATIVO_UNIVOCO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".tipo_identificativo_univoco";
			}else{
				return "tipo_identificativo_univoco";
			}
		}
		if(field.equals(AvvisoDigitale.model().CODICE_IDENTIFICATIVO_UNIVOCO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".codice_identificativo_univoco";
			}else{
				return "codice_identificativo_univoco";
			}
		}
		if(field.equals(AvvisoDigitale.model().EMAIL_SOGGETTO_PAGATORE)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".email_soggetto_pagatore";
			}else{
				return "email_soggetto_pagatore";
			}
		}
		if(field.equals(AvvisoDigitale.model().CELLULARE_SOGGETTO_PAGATORE)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".cellulare_soggetto_pagatore";
			}else{
				return "cellulare_soggetto_pagatore";
			}
		}
		if(field.equals(AvvisoDigitale.model().DATA_SCADENZA_PAGAMENTO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".data_scadenza_pagamento";
			}else{
				return "data_scadenza_pagamento";
			}
		}
		if(field.equals(AvvisoDigitale.model().DATA_SCADENZA_AVVISO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".data_scadenza_avviso";
			}else{
				return "data_scadenza_avviso";
			}
		}
		if(field.equals(AvvisoDigitale.model().DATA_CREAZIONE)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".data_creazione";
			}else{
				return "data_creazione";
			}
		}
		if(field.equals(AvvisoDigitale.model().URL_AVVISO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".url_avviso";
			}else{
				return "url_avviso";
			}
		}


		return super.toColumn(field,returnAlias,appendTablePrefix);
		
	}
	
	@Override
	public String toTable(IField field,boolean returnAlias) throws ExpressionException {
		
		// In the case of table with alias, using parameter returnAlias​​, 
		// it is possible to drive the choice whether to return only the alias or 
		// the full definition of the table containing the alias
		
		if(field.equals(AvvisoDigitale.model().ID_MESSAGGIO_RICHIESTA)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().ID_DOMINIO.COD_DOMINIO)){
			return this.toTable(AvvisoDigitale.model().ID_DOMINIO, returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().CODICE_AVVISO)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().STATO)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().DESCRIZIONE_STATO)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().IMPORTO_AVVISO)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().DESCRIZIONE_PAGAMENTO)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().TASSONOMIA)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().ANAGRAFICA_PAGATORE)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().TIPO_IDENTIFICATIVO_UNIVOCO)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().CODICE_IDENTIFICATIVO_UNIVOCO)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().EMAIL_SOGGETTO_PAGATORE)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().CELLULARE_SOGGETTO_PAGATORE)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().DATA_SCADENZA_PAGAMENTO)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().DATA_SCADENZA_AVVISO)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().DATA_CREAZIONE)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitale.model().URL_AVVISO)){
			return this.toTable(AvvisoDigitale.model(), returnAlias);
		}


		return super.toTable(field,returnAlias);
		
	}

	@Override
	public String toTable(IModel<?> model,boolean returnAlias) throws ExpressionException {
		
		// In the case of table with alias, using parameter returnAlias​​, 
		// it is possible to drive the choice whether to return only the alias or 
		// the full definition of the table containing the alias
		
		if(model.equals(AvvisoDigitale.model())){
			return "avvisi_digitali";
		}
		if(model.equals(AvvisoDigitale.model().ID_DOMINIO)){
			return "domini";
		}


		return super.toTable(model,returnAlias);
		
	}

}

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

import it.govpay.orm.AvvisoDigitaleEsito;


/**     
 * AvvisoDigitaleEsitoFieldConverter
 *
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class AvvisoDigitaleEsitoFieldConverter extends AbstractSQLFieldConverter {

	private TipiDatabase databaseType;
	
	public AvvisoDigitaleEsitoFieldConverter(String databaseType){
		this.databaseType = TipiDatabase.toEnumConstant(databaseType);
	}
	public AvvisoDigitaleEsitoFieldConverter(TipiDatabase databaseType){
		this.databaseType = databaseType;
	}


	@Override
	public IModel<?> getRootModel() throws ExpressionException {
		return AvvisoDigitaleEsito.model();
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
		
		if(field.equals(AvvisoDigitaleEsito.model().ID_MESSAGGIO_RICHIESTA)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".id_messaggio_richiesta";
			}else{
				return "id_messaggio_richiesta";
			}
		}
		if(field.equals(AvvisoDigitaleEsito.model().ID_AVVISO_DIGITALE.ID_MESSAGGIO_RICHIESTA)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".id_messaggio_richiesta";
			}else{
				return "id_messaggio_richiesta";
			}
		}
		if(field.equals(AvvisoDigitaleEsito.model().IDENTIFICATIVO_CANALE)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".identificativo_canale";
			}else{
				return "identificativo_canale";
			}
		}
		if(field.equals(AvvisoDigitaleEsito.model().TIPO_CANALE_ESITO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".tipo_canale_esito";
			}else{
				return "tipo_canale_esito";
			}
		}
		if(field.equals(AvvisoDigitaleEsito.model().DATA_ESITO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".data_esito";
			}else{
				return "data_esito";
			}
		}
		if(field.equals(AvvisoDigitaleEsito.model().CODICE_ESITO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".codice_esito";
			}else{
				return "codice_esito";
			}
		}
		if(field.equals(AvvisoDigitaleEsito.model().DESCRIZIONE_ESITO)){
			if(appendTablePrefix){
				return this.toAliasTable(field)+".descrizione_esito";
			}else{
				return "descrizione_esito";
			}
		}


		return super.toColumn(field,returnAlias,appendTablePrefix);
		
	}
	
	@Override
	public String toTable(IField field,boolean returnAlias) throws ExpressionException {
		
		// In the case of table with alias, using parameter returnAlias​​, 
		// it is possible to drive the choice whether to return only the alias or 
		// the full definition of the table containing the alias
		
		if(field.equals(AvvisoDigitaleEsito.model().ID_MESSAGGIO_RICHIESTA)){
			return this.toTable(AvvisoDigitaleEsito.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitaleEsito.model().ID_AVVISO_DIGITALE.ID_MESSAGGIO_RICHIESTA)){
			return this.toTable(AvvisoDigitaleEsito.model().ID_AVVISO_DIGITALE, returnAlias);
		}
		if(field.equals(AvvisoDigitaleEsito.model().IDENTIFICATIVO_CANALE)){
			return this.toTable(AvvisoDigitaleEsito.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitaleEsito.model().TIPO_CANALE_ESITO)){
			return this.toTable(AvvisoDigitaleEsito.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitaleEsito.model().DATA_ESITO)){
			return this.toTable(AvvisoDigitaleEsito.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitaleEsito.model().CODICE_ESITO)){
			return this.toTable(AvvisoDigitaleEsito.model(), returnAlias);
		}
		if(field.equals(AvvisoDigitaleEsito.model().DESCRIZIONE_ESITO)){
			return this.toTable(AvvisoDigitaleEsito.model(), returnAlias);
		}


		return super.toTable(field,returnAlias);
		
	}

	@Override
	public String toTable(IModel<?> model,boolean returnAlias) throws ExpressionException {
		
		// In the case of table with alias, using parameter returnAlias​​, 
		// it is possible to drive the choice whether to return only the alias or 
		// the full definition of the table containing the alias
		
		if(model.equals(AvvisoDigitaleEsito.model())){
			return "avvisi_digitali_esiti";
		}
		if(model.equals(AvvisoDigitaleEsito.model().ID_AVVISO_DIGITALE)){
			return "avvisi_digitali";
		}


		return super.toTable(model,returnAlias);
		
	}

}

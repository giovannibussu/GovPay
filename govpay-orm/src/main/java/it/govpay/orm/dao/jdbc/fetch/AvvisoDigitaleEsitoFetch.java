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
package it.govpay.orm.dao.jdbc.fetch;

import org.openspcoop2.generic_project.beans.IModel;
import org.openspcoop2.generic_project.dao.jdbc.utils.AbstractJDBCFetch;
import org.openspcoop2.generic_project.dao.jdbc.utils.JDBCParameterUtilities;
import org.openspcoop2.generic_project.exception.ServiceException;

import java.sql.ResultSet;
import java.util.Map;

import org.openspcoop2.utils.TipiDatabase;
import org.openspcoop2.utils.jdbc.IKeyGeneratorObject;

import it.govpay.orm.AvvisoDigitaleEsito;


/**     
 * AvvisoDigitaleEsitoFetch
 *
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class AvvisoDigitaleEsitoFetch extends AbstractJDBCFetch {

	@Override
	public Object fetch(TipiDatabase tipoDatabase, IModel<?> model , ResultSet rs) throws ServiceException {
		
		try{
			JDBCParameterUtilities jdbcParameterUtilities =  
					new JDBCParameterUtilities(tipoDatabase);

			if(model.equals(AvvisoDigitaleEsito.model())){
				AvvisoDigitaleEsito object = new AvvisoDigitaleEsito();
				setParameter(object, "setId", Long.class,
					jdbcParameterUtilities.readParameter(rs, "id", Long.class));
				setParameter(object, "setIdMessaggioRichiesta", AvvisoDigitaleEsito.model().ID_MESSAGGIO_RICHIESTA.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "id_messaggio_richiesta", AvvisoDigitaleEsito.model().ID_MESSAGGIO_RICHIESTA.getFieldType()));
				setParameter(object, "setIdentificativoCanale", AvvisoDigitaleEsito.model().IDENTIFICATIVO_CANALE.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "identificativo_canale", AvvisoDigitaleEsito.model().IDENTIFICATIVO_CANALE.getFieldType()));
				setParameter(object, "setTipoCanaleEsito", AvvisoDigitaleEsito.model().TIPO_CANALE_ESITO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "tipo_canale_esito", AvvisoDigitaleEsito.model().TIPO_CANALE_ESITO.getFieldType()));
				setParameter(object, "setDataEsito", AvvisoDigitaleEsito.model().DATA_ESITO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "data_esito", AvvisoDigitaleEsito.model().DATA_ESITO.getFieldType()));
				setParameter(object, "setCodiceEsito", AvvisoDigitaleEsito.model().CODICE_ESITO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "codice_esito", AvvisoDigitaleEsito.model().CODICE_ESITO.getFieldType()));
				setParameter(object, "setDescrizioneEsito", AvvisoDigitaleEsito.model().DESCRIZIONE_ESITO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "descrizione_esito", AvvisoDigitaleEsito.model().DESCRIZIONE_ESITO.getFieldType()));
				return object;
			}
			
			else{
				throw new ServiceException("Model ["+model.toString()+"] not supported by fetch: "+this.getClass().getName());
			}	
					
		}catch(Exception e){
			throw new ServiceException("Model ["+model.toString()+"] occurs error in fetch: "+e.getMessage(),e);
		}
		
	}
	
	@Override
	public Object fetch(TipiDatabase tipoDatabase, IModel<?> model , Map<String,Object> map ) throws ServiceException {
		
		try{

			if(model.equals(AvvisoDigitaleEsito.model())){
				AvvisoDigitaleEsito object = new AvvisoDigitaleEsito();
				setParameter(object, "setId", Long.class,
					this.getObjectFromMap(map,"id"));
				setParameter(object, "setIdMessaggioRichiesta", AvvisoDigitaleEsito.model().ID_MESSAGGIO_RICHIESTA.getFieldType(),
					this.getObjectFromMap(map,"idMessaggioRichiesta"));
				setParameter(object, "setIdentificativoCanale", AvvisoDigitaleEsito.model().IDENTIFICATIVO_CANALE.getFieldType(),
					this.getObjectFromMap(map,"identificativoCanale"));
				setParameter(object, "setTipoCanaleEsito", AvvisoDigitaleEsito.model().TIPO_CANALE_ESITO.getFieldType(),
					this.getObjectFromMap(map,"tipoCanaleEsito"));
				setParameter(object, "setDataEsito", AvvisoDigitaleEsito.model().DATA_ESITO.getFieldType(),
					this.getObjectFromMap(map,"dataEsito"));
				setParameter(object, "setCodiceEsito", AvvisoDigitaleEsito.model().CODICE_ESITO.getFieldType(),
					this.getObjectFromMap(map,"codiceEsito"));
				setParameter(object, "setDescrizioneEsito", AvvisoDigitaleEsito.model().DESCRIZIONE_ESITO.getFieldType(),
					this.getObjectFromMap(map,"descrizioneEsito"));
				return object;
			}
			
			else{
				throw new ServiceException("Model ["+model.toString()+"] not supported by fetch: "+this.getClass().getName());
			}	
					
		}catch(Exception e){
			throw new ServiceException("Model ["+model.toString()+"] occurs error in fetch: "+e.getMessage(),e);
		}
		
	}
	
	
	@Override
	public IKeyGeneratorObject getKeyGeneratorObject( IModel<?> model )  throws ServiceException {
		
		try{

			if(model.equals(AvvisoDigitaleEsito.model())){
				return new org.openspcoop2.utils.jdbc.CustomKeyGeneratorObject("avvisi_digitali_esiti","id","seq_avvisi_digitali_esiti","avvisi_digitali_esiti_init_seq");
			}
			
			else{
				throw new ServiceException("Model ["+model.toString()+"] not supported by getKeyGeneratorObject: "+this.getClass().getName());
			}

		}catch(Exception e){
			throw new ServiceException("Model ["+model.toString()+"] occurs error in getKeyGeneratorObject: "+e.getMessage(),e);
		}
		
	}

}

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

import it.govpay.orm.AvvisoDigitale;


/**     
 * AvvisoDigitaleFetch
 *
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class AvvisoDigitaleFetch extends AbstractJDBCFetch {

	@Override
	public Object fetch(TipiDatabase tipoDatabase, IModel<?> model , ResultSet rs) throws ServiceException {
		
		try{
			JDBCParameterUtilities jdbcParameterUtilities =  
					new JDBCParameterUtilities(tipoDatabase);

			if(model.equals(AvvisoDigitale.model())){
				AvvisoDigitale object = new AvvisoDigitale();
				setParameter(object, "setId", Long.class,
					jdbcParameterUtilities.readParameter(rs, "id", Long.class));
				setParameter(object, "setIdMessaggioRichiesta", AvvisoDigitale.model().ID_MESSAGGIO_RICHIESTA.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "id_messaggio_richiesta", AvvisoDigitale.model().ID_MESSAGGIO_RICHIESTA.getFieldType()));
				setParameter(object, "setCodiceAvviso", AvvisoDigitale.model().CODICE_AVVISO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "codice_avviso", AvvisoDigitale.model().CODICE_AVVISO.getFieldType()));
				setParameter(object, "setStato", AvvisoDigitale.model().STATO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "stato", AvvisoDigitale.model().STATO.getFieldType()));
				setParameter(object, "setDescrizioneStato", AvvisoDigitale.model().DESCRIZIONE_STATO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "descrizione_stato", AvvisoDigitale.model().DESCRIZIONE_STATO.getFieldType()));
				setParameter(object, "setImportoAvviso", AvvisoDigitale.model().IMPORTO_AVVISO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "importo_avviso", AvvisoDigitale.model().IMPORTO_AVVISO.getFieldType()));
				setParameter(object, "setDescrizionePagamento", AvvisoDigitale.model().DESCRIZIONE_PAGAMENTO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "descrizione_pagamento", AvvisoDigitale.model().DESCRIZIONE_PAGAMENTO.getFieldType()));
				setParameter(object, "setTassonomia", AvvisoDigitale.model().TASSONOMIA.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "tassonomia", AvvisoDigitale.model().TASSONOMIA.getFieldType()));
				setParameter(object, "setAnagraficaPagatore", AvvisoDigitale.model().ANAGRAFICA_PAGATORE.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "anagrafica_pagatore", AvvisoDigitale.model().ANAGRAFICA_PAGATORE.getFieldType()));
				setParameter(object, "setTipoIdentificativoUnivoco", AvvisoDigitale.model().TIPO_IDENTIFICATIVO_UNIVOCO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "tipo_identificativo_univoco", AvvisoDigitale.model().TIPO_IDENTIFICATIVO_UNIVOCO.getFieldType()));
				setParameter(object, "setCodiceIdentificativoUnivoco", AvvisoDigitale.model().CODICE_IDENTIFICATIVO_UNIVOCO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "codice_identificativo_univoco", AvvisoDigitale.model().CODICE_IDENTIFICATIVO_UNIVOCO.getFieldType()));
				setParameter(object, "setEmailSoggettoPagatore", AvvisoDigitale.model().EMAIL_SOGGETTO_PAGATORE.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "email_soggetto_pagatore", AvvisoDigitale.model().EMAIL_SOGGETTO_PAGATORE.getFieldType()));
				setParameter(object, "setCellulareSoggettoPagatore", AvvisoDigitale.model().CELLULARE_SOGGETTO_PAGATORE.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "cellulare_soggetto_pagatore", AvvisoDigitale.model().CELLULARE_SOGGETTO_PAGATORE.getFieldType()));
				setParameter(object, "setDataScadenzaPagamento", AvvisoDigitale.model().DATA_SCADENZA_PAGAMENTO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "data_scadenza_pagamento", AvvisoDigitale.model().DATA_SCADENZA_PAGAMENTO.getFieldType()));
				setParameter(object, "setDataScadenzaAvviso", AvvisoDigitale.model().DATA_SCADENZA_AVVISO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "data_scadenza_avviso", AvvisoDigitale.model().DATA_SCADENZA_AVVISO.getFieldType()));
				setParameter(object, "setDataCreazione", AvvisoDigitale.model().DATA_CREAZIONE.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "data_creazione", AvvisoDigitale.model().DATA_CREAZIONE.getFieldType()));
				setParameter(object, "setUrlAvviso", AvvisoDigitale.model().URL_AVVISO.getFieldType(),
					jdbcParameterUtilities.readParameter(rs, "url_avviso", AvvisoDigitale.model().URL_AVVISO.getFieldType()));
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

			if(model.equals(AvvisoDigitale.model())){
				AvvisoDigitale object = new AvvisoDigitale();
				setParameter(object, "setId", Long.class,
					this.getObjectFromMap(map,"id"));
				setParameter(object, "setIdMessaggioRichiesta", AvvisoDigitale.model().ID_MESSAGGIO_RICHIESTA.getFieldType(),
					this.getObjectFromMap(map,"idMessaggioRichiesta"));
				setParameter(object, "setCodiceAvviso", AvvisoDigitale.model().CODICE_AVVISO.getFieldType(),
					this.getObjectFromMap(map,"codiceAvviso"));
				setParameter(object, "setStato", AvvisoDigitale.model().STATO.getFieldType(),
					this.getObjectFromMap(map,"stato"));
				setParameter(object, "setDescrizioneStato", AvvisoDigitale.model().DESCRIZIONE_STATO.getFieldType(),
					this.getObjectFromMap(map,"descrizioneStato"));
				setParameter(object, "setImportoAvviso", AvvisoDigitale.model().IMPORTO_AVVISO.getFieldType(),
					this.getObjectFromMap(map,"importoAvviso"));
				setParameter(object, "setDescrizionePagamento", AvvisoDigitale.model().DESCRIZIONE_PAGAMENTO.getFieldType(),
					this.getObjectFromMap(map,"descrizionePagamento"));
				setParameter(object, "setTassonomia", AvvisoDigitale.model().TASSONOMIA.getFieldType(),
					this.getObjectFromMap(map,"tassonomia"));
				setParameter(object, "setAnagraficaPagatore", AvvisoDigitale.model().ANAGRAFICA_PAGATORE.getFieldType(),
					this.getObjectFromMap(map,"anagraficaPagatore"));
				setParameter(object, "setTipoIdentificativoUnivoco", AvvisoDigitale.model().TIPO_IDENTIFICATIVO_UNIVOCO.getFieldType(),
					this.getObjectFromMap(map,"tipoIdentificativoUnivoco"));
				setParameter(object, "setCodiceIdentificativoUnivoco", AvvisoDigitale.model().CODICE_IDENTIFICATIVO_UNIVOCO.getFieldType(),
					this.getObjectFromMap(map,"codiceIdentificativoUnivoco"));
				setParameter(object, "setEmailSoggettoPagatore", AvvisoDigitale.model().EMAIL_SOGGETTO_PAGATORE.getFieldType(),
					this.getObjectFromMap(map,"emailSoggettoPagatore"));
				setParameter(object, "setCellulareSoggettoPagatore", AvvisoDigitale.model().CELLULARE_SOGGETTO_PAGATORE.getFieldType(),
					this.getObjectFromMap(map,"cellulareSoggettoPagatore"));
				setParameter(object, "setDataScadenzaPagamento", AvvisoDigitale.model().DATA_SCADENZA_PAGAMENTO.getFieldType(),
					this.getObjectFromMap(map,"dataScadenzaPagamento"));
				setParameter(object, "setDataScadenzaAvviso", AvvisoDigitale.model().DATA_SCADENZA_AVVISO.getFieldType(),
					this.getObjectFromMap(map,"dataScadenzaAvviso"));
				setParameter(object, "setDataCreazione", AvvisoDigitale.model().DATA_CREAZIONE.getFieldType(),
					this.getObjectFromMap(map,"dataCreazione"));
				setParameter(object, "setUrlAvviso", AvvisoDigitale.model().URL_AVVISO.getFieldType(),
					this.getObjectFromMap(map,"urlAvviso"));
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

			if(model.equals(AvvisoDigitale.model())){
				return new org.openspcoop2.utils.jdbc.CustomKeyGeneratorObject("avvisi_digitali","id","seq_avvisi_digitali","avvisi_digitali_init_seq");
			}
			
			else{
				throw new ServiceException("Model ["+model.toString()+"] not supported by getKeyGeneratorObject: "+this.getClass().getName());
			}

		}catch(Exception e){
			throw new ServiceException("Model ["+model.toString()+"] occurs error in getKeyGeneratorObject: "+e.getMessage(),e);
		}
		
	}

}

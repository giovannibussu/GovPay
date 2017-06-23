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
package it.govpay.orm.dao.jdbc;

import java.sql.Connection;

import org.openspcoop2.utils.sql.ISQLQueryObject;

import org.apache.log4j.Logger;

import org.openspcoop2.generic_project.dao.jdbc.IJDBCServiceCRUDWithId;
import it.govpay.orm.IdAvvisoDigitale;
import org.openspcoop2.generic_project.beans.NonNegativeNumber;
import org.openspcoop2.generic_project.beans.UpdateField;
import org.openspcoop2.generic_project.beans.UpdateModel;

import org.openspcoop2.generic_project.dao.jdbc.utils.JDBCUtilities;
import org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject;
import org.openspcoop2.generic_project.exception.NotFoundException;
import org.openspcoop2.generic_project.exception.NotImplementedException;
import org.openspcoop2.generic_project.exception.ServiceException;
import org.openspcoop2.generic_project.expression.IExpression;
import org.openspcoop2.generic_project.dao.jdbc.JDBCExpression;
import org.openspcoop2.generic_project.dao.jdbc.JDBCPaginatedExpression;

import org.openspcoop2.generic_project.dao.jdbc.JDBCServiceManagerProperties;

import it.govpay.orm.AvvisoDigitale;
import it.govpay.orm.dao.jdbc.JDBCServiceManager;

/**     
 * JDBCAvvisoDigitaleServiceImpl
 *
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class JDBCAvvisoDigitaleServiceImpl extends JDBCAvvisoDigitaleServiceSearchImpl
	implements IJDBCServiceCRUDWithId<AvvisoDigitale, IdAvvisoDigitale, JDBCServiceManager> {

	@Override
	public void create(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, AvvisoDigitale avvisoDigitale, org.openspcoop2.generic_project.beans.IDMappingBehaviour idMappingResolutionBehaviour) throws NotImplementedException,ServiceException,Exception {

		org.openspcoop2.generic_project.dao.jdbc.utils.JDBCPreparedStatementUtilities jdbcUtilities = 
				new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCPreparedStatementUtilities(sqlQueryObject.getTipoDatabaseOpenSPCoop2(), log, connection);
		
		// default behaviour (id-mapping)
		if(idMappingResolutionBehaviour==null){
			idMappingResolutionBehaviour = org.openspcoop2.generic_project.beans.IDMappingBehaviour.valueOf("USE_TABLE_ID");
		}
		
		ISQLQueryObject sqlQueryObjectInsert = sqlQueryObject.newSQLQueryObject();
				

		// Object _dominio
		Long id_dominio = null;
		it.govpay.orm.IdDominio idLogic_dominio = null;
		idLogic_dominio = avvisoDigitale.getIdDominio();
		if(idLogic_dominio!=null){
			if(idMappingResolutionBehaviour==null ||
				(org.openspcoop2.generic_project.beans.IDMappingBehaviour.ENABLED.equals(idMappingResolutionBehaviour))){
				id_dominio = ((JDBCDominioServiceSearch)(this.getServiceManager().getDominioServiceSearch())).findTableId(idLogic_dominio, false);
			}
			else if(org.openspcoop2.generic_project.beans.IDMappingBehaviour.USE_TABLE_ID.equals(idMappingResolutionBehaviour)){
				id_dominio = idLogic_dominio.getId();
				if(id_dominio==null || id_dominio<=0){
					throw new Exception("Logic id not contains table id");
				}
			}
		}


		// Object avvisoDigitale
		sqlQueryObjectInsert.addInsertTable(this.getAvvisoDigitaleFieldConverter().toTable(AvvisoDigitale.model()));
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().ID_MESSAGGIO_RICHIESTA,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().CODICE_AVVISO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().STATO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().DESCRIZIONE_STATO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().IMPORTO_AVVISO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().DESCRIZIONE_PAGAMENTO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().TASSONOMIA,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().ANAGRAFICA_PAGATORE,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().TIPO_IDENTIFICATIVO_UNIVOCO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().CODICE_IDENTIFICATIVO_UNIVOCO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().EMAIL_SOGGETTO_PAGATORE,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().CELLULARE_SOGGETTO_PAGATORE,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().DATA_SCADENZA_PAGAMENTO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().DATA_SCADENZA_AVVISO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().DATA_CREAZIONE,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().URL_AVVISO,false),"?");
		sqlQueryObjectInsert.addInsertField("id_dominio","?");

		// Insert avvisoDigitale
		org.openspcoop2.utils.jdbc.IKeyGeneratorObject keyGenerator = this.getAvvisoDigitaleFetch().getKeyGeneratorObject(AvvisoDigitale.model());
		long id = jdbcUtilities.insertAndReturnGeneratedKey(sqlQueryObjectInsert, keyGenerator, jdbcProperties.isShowSql(),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getIdMessaggioRichiesta(),AvvisoDigitale.model().ID_MESSAGGIO_RICHIESTA.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getCodiceAvviso(),AvvisoDigitale.model().CODICE_AVVISO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getStato(),AvvisoDigitale.model().STATO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getDescrizioneStato(),AvvisoDigitale.model().DESCRIZIONE_STATO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getImportoAvviso(),AvvisoDigitale.model().IMPORTO_AVVISO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getDescrizionePagamento(),AvvisoDigitale.model().DESCRIZIONE_PAGAMENTO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getTassonomia(),AvvisoDigitale.model().TASSONOMIA.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getAnagraficaPagatore(),AvvisoDigitale.model().ANAGRAFICA_PAGATORE.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getTipoIdentificativoUnivoco(),AvvisoDigitale.model().TIPO_IDENTIFICATIVO_UNIVOCO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getCodiceIdentificativoUnivoco(),AvvisoDigitale.model().CODICE_IDENTIFICATIVO_UNIVOCO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getEmailSoggettoPagatore(),AvvisoDigitale.model().EMAIL_SOGGETTO_PAGATORE.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getCellulareSoggettoPagatore(),AvvisoDigitale.model().CELLULARE_SOGGETTO_PAGATORE.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getDataScadenzaPagamento(),AvvisoDigitale.model().DATA_SCADENZA_PAGAMENTO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getDataScadenzaAvviso(),AvvisoDigitale.model().DATA_SCADENZA_AVVISO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getDataCreazione(),AvvisoDigitale.model().DATA_CREAZIONE.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitale.getUrlAvviso(),AvvisoDigitale.model().URL_AVVISO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(id_dominio,Long.class)
		);
		avvisoDigitale.setId(id);

	}

	@Override
	public void update(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, IdAvvisoDigitale oldId, AvvisoDigitale avvisoDigitale, org.openspcoop2.generic_project.beans.IDMappingBehaviour idMappingResolutionBehaviour) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		ISQLQueryObject sqlQueryObjectUpdate = sqlQueryObject.newSQLQueryObject();
		Long longIdByLogicId = this.findIdAvvisoDigitale(jdbcProperties, log, connection, sqlQueryObjectUpdate.newSQLQueryObject(), oldId, true);
		Long tableId = avvisoDigitale.getId();
		if(tableId != null && tableId.longValue() > 0) {
			if(tableId.longValue() != longIdByLogicId.longValue()) {
				throw new Exception("Ambiguous parameter: avvisoDigitale.id ["+tableId+"] does not match logic id ["+longIdByLogicId+"]");
			}
		} else {
			tableId = longIdByLogicId;
			avvisoDigitale.setId(tableId);
		}
		if(tableId==null || tableId<=0){
			throw new Exception("Retrieve tableId failed");
		}

		this.update(jdbcProperties, log, connection, sqlQueryObject, tableId, avvisoDigitale, idMappingResolutionBehaviour);
	}
	@Override
	public void update(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId, AvvisoDigitale avvisoDigitale, org.openspcoop2.generic_project.beans.IDMappingBehaviour idMappingResolutionBehaviour) throws NotFoundException, NotImplementedException, ServiceException, Exception {
	
		org.openspcoop2.generic_project.dao.jdbc.utils.JDBCPreparedStatementUtilities jdbcUtilities = 
				new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCPreparedStatementUtilities(sqlQueryObject.getTipoDatabaseOpenSPCoop2(), log, connection);
		
		// default behaviour (id-mapping)
		if(idMappingResolutionBehaviour==null){
			idMappingResolutionBehaviour = org.openspcoop2.generic_project.beans.IDMappingBehaviour.valueOf("USE_TABLE_ID");
		}
		
		ISQLQueryObject sqlQueryObjectInsert = sqlQueryObject.newSQLQueryObject();
		ISQLQueryObject sqlQueryObjectDelete = sqlQueryObjectInsert.newSQLQueryObject();
		ISQLQueryObject sqlQueryObjectGet = sqlQueryObjectDelete.newSQLQueryObject();
		ISQLQueryObject sqlQueryObjectUpdate = sqlQueryObjectGet.newSQLQueryObject();
		
		boolean setIdMappingResolutionBehaviour = 
			(idMappingResolutionBehaviour==null) ||
			org.openspcoop2.generic_project.beans.IDMappingBehaviour.ENABLED.equals(idMappingResolutionBehaviour) ||
			org.openspcoop2.generic_project.beans.IDMappingBehaviour.USE_TABLE_ID.equals(idMappingResolutionBehaviour);
			

		// Object _avvisoDigitale_dominio
		Long id_avvisoDigitale_dominio = null;
		it.govpay.orm.IdDominio idLogic_avvisoDigitale_dominio = null;
		idLogic_avvisoDigitale_dominio = avvisoDigitale.getIdDominio();
		if(idLogic_avvisoDigitale_dominio!=null){
			if(idMappingResolutionBehaviour==null ||
				(org.openspcoop2.generic_project.beans.IDMappingBehaviour.ENABLED.equals(idMappingResolutionBehaviour))){
				id_avvisoDigitale_dominio = ((JDBCDominioServiceSearch)(this.getServiceManager().getDominioServiceSearch())).findTableId(idLogic_avvisoDigitale_dominio, false);
			}
			else if(org.openspcoop2.generic_project.beans.IDMappingBehaviour.USE_TABLE_ID.equals(idMappingResolutionBehaviour)){
				id_avvisoDigitale_dominio = idLogic_avvisoDigitale_dominio.getId();
				if(id_avvisoDigitale_dominio==null || id_avvisoDigitale_dominio<=0){
					throw new Exception("Logic id not contains table id");
				}
			}
		}


		// Object avvisoDigitale
		sqlQueryObjectUpdate.setANDLogicOperator(true);
		sqlQueryObjectUpdate.addUpdateTable(this.getAvvisoDigitaleFieldConverter().toTable(AvvisoDigitale.model()));
		boolean isUpdate_avvisoDigitale = true;
		java.util.List<JDBCObject> lstObjects_avvisoDigitale = new java.util.ArrayList<JDBCObject>();
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().ID_MESSAGGIO_RICHIESTA,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getIdMessaggioRichiesta(), AvvisoDigitale.model().ID_MESSAGGIO_RICHIESTA.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().CODICE_AVVISO,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getCodiceAvviso(), AvvisoDigitale.model().CODICE_AVVISO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().STATO,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getStato(), AvvisoDigitale.model().STATO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().DESCRIZIONE_STATO,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getDescrizioneStato(), AvvisoDigitale.model().DESCRIZIONE_STATO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().IMPORTO_AVVISO,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getImportoAvviso(), AvvisoDigitale.model().IMPORTO_AVVISO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().DESCRIZIONE_PAGAMENTO,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getDescrizionePagamento(), AvvisoDigitale.model().DESCRIZIONE_PAGAMENTO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().TASSONOMIA,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getTassonomia(), AvvisoDigitale.model().TASSONOMIA.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().ANAGRAFICA_PAGATORE,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getAnagraficaPagatore(), AvvisoDigitale.model().ANAGRAFICA_PAGATORE.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().TIPO_IDENTIFICATIVO_UNIVOCO,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getTipoIdentificativoUnivoco(), AvvisoDigitale.model().TIPO_IDENTIFICATIVO_UNIVOCO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().CODICE_IDENTIFICATIVO_UNIVOCO,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getCodiceIdentificativoUnivoco(), AvvisoDigitale.model().CODICE_IDENTIFICATIVO_UNIVOCO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().EMAIL_SOGGETTO_PAGATORE,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getEmailSoggettoPagatore(), AvvisoDigitale.model().EMAIL_SOGGETTO_PAGATORE.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().CELLULARE_SOGGETTO_PAGATORE,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getCellulareSoggettoPagatore(), AvvisoDigitale.model().CELLULARE_SOGGETTO_PAGATORE.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().DATA_SCADENZA_PAGAMENTO,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getDataScadenzaPagamento(), AvvisoDigitale.model().DATA_SCADENZA_PAGAMENTO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().DATA_SCADENZA_AVVISO,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getDataScadenzaAvviso(), AvvisoDigitale.model().DATA_SCADENZA_AVVISO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().DATA_CREAZIONE,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getDataCreazione(), AvvisoDigitale.model().DATA_CREAZIONE.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleFieldConverter().toColumn(AvvisoDigitale.model().URL_AVVISO,false), "?");
		lstObjects_avvisoDigitale.add(new JDBCObject(avvisoDigitale.getUrlAvviso(), AvvisoDigitale.model().URL_AVVISO.getFieldType()));
		if(setIdMappingResolutionBehaviour){
			sqlQueryObjectUpdate.addUpdateField("id_dominio","?");
		}
		if(setIdMappingResolutionBehaviour){
			lstObjects_avvisoDigitale.add(new JDBCObject(id_avvisoDigitale_dominio, Long.class));
		}
		sqlQueryObjectUpdate.addWhereCondition("id=?");
		lstObjects_avvisoDigitale.add(new JDBCObject(tableId, Long.class));

		if(isUpdate_avvisoDigitale) {
			// Update avvisoDigitale
			jdbcUtilities.executeUpdate(sqlQueryObjectUpdate.createSQLUpdate(), jdbcProperties.isShowSql(), 
				lstObjects_avvisoDigitale.toArray(new JDBCObject[]{}));
		}


	}
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, IdAvvisoDigitale id, UpdateField ... updateFields) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleFieldConverter().toTable(AvvisoDigitale.model()), 
				this._getMapTableToPKColumn(), 
				this._getRootTablePrimaryKeyValues(jdbcProperties, log, connection, sqlQueryObject, id),
				this.getAvvisoDigitaleFieldConverter(), this, null, updateFields);
	}
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, IdAvvisoDigitale id, IExpression condition, UpdateField ... updateFields) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleFieldConverter().toTable(AvvisoDigitale.model()), 
				this._getMapTableToPKColumn(), 
				this._getRootTablePrimaryKeyValues(jdbcProperties, log, connection, sqlQueryObject, id),
				this.getAvvisoDigitaleFieldConverter(), this, condition, updateFields);
	}
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, IdAvvisoDigitale id, UpdateModel ... updateModels) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleFieldConverter().toTable(AvvisoDigitale.model()), 
				this._getMapTableToPKColumn(), 
				this._getRootTablePrimaryKeyValues(jdbcProperties, log, connection, sqlQueryObject, id),
				this.getAvvisoDigitaleFieldConverter(), this, updateModels);
	}	
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId, UpdateField ... updateFields) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		java.util.List<Object> ids = new java.util.ArrayList<Object>();
		ids.add(tableId);
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleFieldConverter().toTable(AvvisoDigitale.model()), 
				this._getMapTableToPKColumn(), 
				ids,
				this.getAvvisoDigitaleFieldConverter(), this, null, updateFields);
	}
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId, IExpression condition, UpdateField ... updateFields) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		java.util.List<Object> ids = new java.util.ArrayList<Object>();
		ids.add(tableId);
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleFieldConverter().toTable(AvvisoDigitale.model()), 
				this._getMapTableToPKColumn(), 
				ids,
				this.getAvvisoDigitaleFieldConverter(), this, condition, updateFields);
	}
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId, UpdateModel ... updateModels) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		java.util.List<Object> ids = new java.util.ArrayList<Object>();
		ids.add(tableId);
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleFieldConverter().toTable(AvvisoDigitale.model()), 
				this._getMapTableToPKColumn(), 
				ids,
				this.getAvvisoDigitaleFieldConverter(), this, updateModels);
	}
	
	@Override
	public void updateOrCreate(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, IdAvvisoDigitale oldId, AvvisoDigitale avvisoDigitale, org.openspcoop2.generic_project.beans.IDMappingBehaviour idMappingResolutionBehaviour) throws NotImplementedException,ServiceException,Exception {
	
		// default behaviour (id-mapping)
		if(idMappingResolutionBehaviour==null){
			idMappingResolutionBehaviour = org.openspcoop2.generic_project.beans.IDMappingBehaviour.valueOf("USE_TABLE_ID");
		}
		
		if(this.exists(jdbcProperties, log, connection, sqlQueryObject, oldId)) {
			this.update(jdbcProperties, log, connection, sqlQueryObject, oldId, avvisoDigitale,idMappingResolutionBehaviour);
		} else {
			this.create(jdbcProperties, log, connection, sqlQueryObject, avvisoDigitale,idMappingResolutionBehaviour);
		}
		
	}
	
	@Override
	public void updateOrCreate(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId, AvvisoDigitale avvisoDigitale, org.openspcoop2.generic_project.beans.IDMappingBehaviour idMappingResolutionBehaviour) throws NotImplementedException,ServiceException,Exception {
		// default behaviour (id-mapping)
		if(idMappingResolutionBehaviour==null){
			idMappingResolutionBehaviour = org.openspcoop2.generic_project.beans.IDMappingBehaviour.valueOf("USE_TABLE_ID");
		}
		
		if(this.exists(jdbcProperties, log, connection, sqlQueryObject, tableId)) {
			this.update(jdbcProperties, log, connection, sqlQueryObject, tableId, avvisoDigitale,idMappingResolutionBehaviour);
		} else {
			this.create(jdbcProperties, log, connection, sqlQueryObject, avvisoDigitale,idMappingResolutionBehaviour);
		}
	}
	
	@Override
	public void delete(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, AvvisoDigitale avvisoDigitale) throws NotImplementedException,ServiceException,Exception {
		
		
		Long longId = null;
		if( (avvisoDigitale.getId()!=null) && (avvisoDigitale.getId()>0) ){
			longId = avvisoDigitale.getId();
		}
		else{
			IdAvvisoDigitale idAvvisoDigitale = this.convertToId(jdbcProperties,log,connection,sqlQueryObject,avvisoDigitale);
			longId = this.findIdAvvisoDigitale(jdbcProperties,log,connection,sqlQueryObject,idAvvisoDigitale,false);
			if(longId == null){
				return; // entry not exists
			}
		}		
		
		this._delete(jdbcProperties, log, connection, sqlQueryObject, longId);
		
	}

	private void _delete(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, Long id) throws NotImplementedException,ServiceException,Exception {
	
		if(id!=null && id.longValue()<=0){
			throw new ServiceException("Id is less equals 0");
		}
		
		org.openspcoop2.generic_project.dao.jdbc.utils.JDBCPreparedStatementUtilities jdbcUtilities = 
				new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCPreparedStatementUtilities(sqlQueryObject.getTipoDatabaseOpenSPCoop2(), log, connection);
		
		ISQLQueryObject sqlQueryObjectDelete = sqlQueryObject.newSQLQueryObject();
		

		// Object avvisoDigitale
		sqlQueryObjectDelete.setANDLogicOperator(true);
		sqlQueryObjectDelete.addDeleteTable(this.getAvvisoDigitaleFieldConverter().toTable(AvvisoDigitale.model()));
		if(id != null)
			sqlQueryObjectDelete.addWhereCondition("id=?");

		// Delete avvisoDigitale
		jdbcUtilities.execute(sqlQueryObjectDelete.createSQLDelete(), jdbcProperties.isShowSql(), 
			new JDBCObject(id,Long.class));

	}

	@Override
	public void deleteById(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, IdAvvisoDigitale idAvvisoDigitale) throws NotImplementedException,ServiceException,Exception {

		Long id = null;
		try{
			id = this.findIdAvvisoDigitale(jdbcProperties, log, connection, sqlQueryObject, idAvvisoDigitale, true);
		}catch(NotFoundException notFound){
			return;
		}
		this._delete(jdbcProperties, log, connection, sqlQueryObject, id);
		
	}
	
	@Override
	public NonNegativeNumber deleteAll(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject) throws NotImplementedException,ServiceException,Exception {
		
		return this.deleteAll(jdbcProperties, log, connection, sqlQueryObject, new JDBCExpression(this.getAvvisoDigitaleFieldConverter()));

	}

	@Override
	public NonNegativeNumber deleteAll(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, JDBCExpression expression) throws NotImplementedException, ServiceException,Exception {

		java.util.List<Long> lst = this.findAllTableIds(jdbcProperties, log, connection, sqlQueryObject, new JDBCPaginatedExpression(expression));
		
		for(Long id : lst) {
			this._delete(jdbcProperties, log, connection, sqlQueryObject, id);
		}
		
		return new NonNegativeNumber(lst.size());
	
	}



	// -- DB
	
	@Override
	public void deleteById(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId) throws ServiceException, NotImplementedException, Exception {
		this._delete(jdbcProperties, log, connection, sqlQueryObject, Long.valueOf(tableId));
	}
}

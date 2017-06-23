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

import org.openspcoop2.generic_project.dao.jdbc.IJDBCServiceCRUDWithoutId;
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

import it.govpay.orm.AvvisoDigitaleEsito;
import it.govpay.orm.dao.jdbc.JDBCServiceManager;

/**     
 * JDBCAvvisoDigitaleEsitoServiceImpl
 *
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class JDBCAvvisoDigitaleEsitoServiceImpl extends JDBCAvvisoDigitaleEsitoServiceSearchImpl
	implements IJDBCServiceCRUDWithoutId<AvvisoDigitaleEsito, JDBCServiceManager> {

	@Override
	public void create(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, AvvisoDigitaleEsito avvisoDigitaleEsito, org.openspcoop2.generic_project.beans.IDMappingBehaviour idMappingResolutionBehaviour) throws NotImplementedException,ServiceException,Exception {

		org.openspcoop2.generic_project.dao.jdbc.utils.JDBCPreparedStatementUtilities jdbcUtilities = 
				new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCPreparedStatementUtilities(sqlQueryObject.getTipoDatabaseOpenSPCoop2(), log, connection);
		
		// default behaviour (id-mapping)
		if(idMappingResolutionBehaviour==null){
			idMappingResolutionBehaviour = org.openspcoop2.generic_project.beans.IDMappingBehaviour.valueOf("USE_TABLE_ID");
		}
		
		ISQLQueryObject sqlQueryObjectInsert = sqlQueryObject.newSQLQueryObject();
				

		// Object _avvisoDigitale
		Long id_avvisoDigitale = null;
		it.govpay.orm.IdAvvisoDigitale idLogic_avvisoDigitale = null;
		idLogic_avvisoDigitale = avvisoDigitaleEsito.getIdAvvisoDigitale();
		if(idLogic_avvisoDigitale!=null){
			if(idMappingResolutionBehaviour==null ||
				(org.openspcoop2.generic_project.beans.IDMappingBehaviour.ENABLED.equals(idMappingResolutionBehaviour))){
				id_avvisoDigitale = ((JDBCAvvisoDigitaleServiceSearch)(this.getServiceManager().getAvvisoDigitaleServiceSearch())).findTableId(idLogic_avvisoDigitale, false);
			}
			else if(org.openspcoop2.generic_project.beans.IDMappingBehaviour.USE_TABLE_ID.equals(idMappingResolutionBehaviour)){
				id_avvisoDigitale = idLogic_avvisoDigitale.getId();
				if(id_avvisoDigitale==null || id_avvisoDigitale<=0){
					throw new Exception("Logic id not contains table id");
				}
			}
		}


		// Object avvisoDigitaleEsito
		sqlQueryObjectInsert.addInsertTable(this.getAvvisoDigitaleEsitoFieldConverter().toTable(AvvisoDigitaleEsito.model()));
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleEsitoFieldConverter().toColumn(AvvisoDigitaleEsito.model().IDENTIFICATIVO_CANALE,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleEsitoFieldConverter().toColumn(AvvisoDigitaleEsito.model().TIPO_CANALE_ESITO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleEsitoFieldConverter().toColumn(AvvisoDigitaleEsito.model().DATA_ESITO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleEsitoFieldConverter().toColumn(AvvisoDigitaleEsito.model().CODICE_ESITO,false),"?");
		sqlQueryObjectInsert.addInsertField(this.getAvvisoDigitaleEsitoFieldConverter().toColumn(AvvisoDigitaleEsito.model().DESCRIZIONE_ESITO,false),"?");
		sqlQueryObjectInsert.addInsertField("id_avviso_digitale","?");

		// Insert avvisoDigitaleEsito
		org.openspcoop2.utils.jdbc.IKeyGeneratorObject keyGenerator = this.getAvvisoDigitaleEsitoFetch().getKeyGeneratorObject(AvvisoDigitaleEsito.model());
		long id = jdbcUtilities.insertAndReturnGeneratedKey(sqlQueryObjectInsert, keyGenerator, jdbcProperties.isShowSql(),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitaleEsito.getIdentificativoCanale(),AvvisoDigitaleEsito.model().IDENTIFICATIVO_CANALE.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitaleEsito.getTipoCanaleEsito(),AvvisoDigitaleEsito.model().TIPO_CANALE_ESITO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitaleEsito.getDataEsito(),AvvisoDigitaleEsito.model().DATA_ESITO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitaleEsito.getCodiceEsito(),AvvisoDigitaleEsito.model().CODICE_ESITO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(avvisoDigitaleEsito.getDescrizioneEsito(),AvvisoDigitaleEsito.model().DESCRIZIONE_ESITO.getFieldType()),
			new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCObject(id_avvisoDigitale,Long.class)
		);
		avvisoDigitaleEsito.setId(id);

	}

	@Override
	public void update(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, AvvisoDigitaleEsito avvisoDigitaleEsito, org.openspcoop2.generic_project.beans.IDMappingBehaviour idMappingResolutionBehaviour) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		
		Long tableId = avvisoDigitaleEsito.getId();
		if(tableId==null || tableId<=0){
			throw new Exception("Retrieve tableId failed");
		}

		this.update(jdbcProperties, log, connection, sqlQueryObject, tableId, avvisoDigitaleEsito, idMappingResolutionBehaviour);
	}
	@Override
	public void update(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId, AvvisoDigitaleEsito avvisoDigitaleEsito, org.openspcoop2.generic_project.beans.IDMappingBehaviour idMappingResolutionBehaviour) throws NotFoundException, NotImplementedException, ServiceException, Exception {
	
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
			

		// Object _avvisoDigitaleEsito_avvisoDigitale
		Long id_avvisoDigitaleEsito_avvisoDigitale = null;
		it.govpay.orm.IdAvvisoDigitale idLogic_avvisoDigitaleEsito_avvisoDigitale = null;
		idLogic_avvisoDigitaleEsito_avvisoDigitale = avvisoDigitaleEsito.getIdAvvisoDigitale();
		if(idLogic_avvisoDigitaleEsito_avvisoDigitale!=null){
			if(idMappingResolutionBehaviour==null ||
				(org.openspcoop2.generic_project.beans.IDMappingBehaviour.ENABLED.equals(idMappingResolutionBehaviour))){
				id_avvisoDigitaleEsito_avvisoDigitale = ((JDBCAvvisoDigitaleServiceSearch)(this.getServiceManager().getAvvisoDigitaleServiceSearch())).findTableId(idLogic_avvisoDigitaleEsito_avvisoDigitale, false);
			}
			else if(org.openspcoop2.generic_project.beans.IDMappingBehaviour.USE_TABLE_ID.equals(idMappingResolutionBehaviour)){
				id_avvisoDigitaleEsito_avvisoDigitale = idLogic_avvisoDigitaleEsito_avvisoDigitale.getId();
				if(id_avvisoDigitaleEsito_avvisoDigitale==null || id_avvisoDigitaleEsito_avvisoDigitale<=0){
					throw new Exception("Logic id not contains table id");
				}
			}
		}


		// Object avvisoDigitaleEsito
		sqlQueryObjectUpdate.setANDLogicOperator(true);
		sqlQueryObjectUpdate.addUpdateTable(this.getAvvisoDigitaleEsitoFieldConverter().toTable(AvvisoDigitaleEsito.model()));
		boolean isUpdate_avvisoDigitaleEsito = true;
		java.util.List<JDBCObject> lstObjects_avvisoDigitaleEsito = new java.util.ArrayList<JDBCObject>();
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleEsitoFieldConverter().toColumn(AvvisoDigitaleEsito.model().IDENTIFICATIVO_CANALE,false), "?");
		lstObjects_avvisoDigitaleEsito.add(new JDBCObject(avvisoDigitaleEsito.getIdentificativoCanale(), AvvisoDigitaleEsito.model().IDENTIFICATIVO_CANALE.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleEsitoFieldConverter().toColumn(AvvisoDigitaleEsito.model().TIPO_CANALE_ESITO,false), "?");
		lstObjects_avvisoDigitaleEsito.add(new JDBCObject(avvisoDigitaleEsito.getTipoCanaleEsito(), AvvisoDigitaleEsito.model().TIPO_CANALE_ESITO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleEsitoFieldConverter().toColumn(AvvisoDigitaleEsito.model().DATA_ESITO,false), "?");
		lstObjects_avvisoDigitaleEsito.add(new JDBCObject(avvisoDigitaleEsito.getDataEsito(), AvvisoDigitaleEsito.model().DATA_ESITO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleEsitoFieldConverter().toColumn(AvvisoDigitaleEsito.model().CODICE_ESITO,false), "?");
		lstObjects_avvisoDigitaleEsito.add(new JDBCObject(avvisoDigitaleEsito.getCodiceEsito(), AvvisoDigitaleEsito.model().CODICE_ESITO.getFieldType()));
		sqlQueryObjectUpdate.addUpdateField(this.getAvvisoDigitaleEsitoFieldConverter().toColumn(AvvisoDigitaleEsito.model().DESCRIZIONE_ESITO,false), "?");
		lstObjects_avvisoDigitaleEsito.add(new JDBCObject(avvisoDigitaleEsito.getDescrizioneEsito(), AvvisoDigitaleEsito.model().DESCRIZIONE_ESITO.getFieldType()));
		if(setIdMappingResolutionBehaviour){
			sqlQueryObjectUpdate.addUpdateField("id_avviso_digitale","?");
		}
		if(setIdMappingResolutionBehaviour){
			lstObjects_avvisoDigitaleEsito.add(new JDBCObject(id_avvisoDigitaleEsito_avvisoDigitale, Long.class));
		}
		sqlQueryObjectUpdate.addWhereCondition("id=?");
		lstObjects_avvisoDigitaleEsito.add(new JDBCObject(tableId, Long.class));

		if(isUpdate_avvisoDigitaleEsito) {
			// Update avvisoDigitaleEsito
			jdbcUtilities.executeUpdate(sqlQueryObjectUpdate.createSQLUpdate(), jdbcProperties.isShowSql(), 
				lstObjects_avvisoDigitaleEsito.toArray(new JDBCObject[]{}));
		}


	}
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, AvvisoDigitaleEsito avvisoDigitaleEsito, UpdateField ... updateFields) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleEsitoFieldConverter().toTable(AvvisoDigitaleEsito.model()), 
				this._getMapTableToPKColumn(), 
				this._getRootTablePrimaryKeyValues(jdbcProperties, log, connection, sqlQueryObject, avvisoDigitaleEsito),
				this.getAvvisoDigitaleEsitoFieldConverter(), this, null, updateFields);
	}
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, AvvisoDigitaleEsito avvisoDigitaleEsito, IExpression condition, UpdateField ... updateFields) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleEsitoFieldConverter().toTable(AvvisoDigitaleEsito.model()), 
				this._getMapTableToPKColumn(), 
				this._getRootTablePrimaryKeyValues(jdbcProperties, log, connection, sqlQueryObject, avvisoDigitaleEsito),
				this.getAvvisoDigitaleEsitoFieldConverter(), this, condition, updateFields);
	}
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, AvvisoDigitaleEsito avvisoDigitaleEsito, UpdateModel ... updateModels) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleEsitoFieldConverter().toTable(AvvisoDigitaleEsito.model()), 
				this._getMapTableToPKColumn(), 
				this._getRootTablePrimaryKeyValues(jdbcProperties, log, connection, sqlQueryObject, avvisoDigitaleEsito),
				this.getAvvisoDigitaleEsitoFieldConverter(), this, updateModels);
	}	
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId, UpdateField ... updateFields) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		java.util.List<Object> ids = new java.util.ArrayList<Object>();
		ids.add(tableId);
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleEsitoFieldConverter().toTable(AvvisoDigitaleEsito.model()), 
				this._getMapTableToPKColumn(), 
				ids,
				this.getAvvisoDigitaleEsitoFieldConverter(), this, null, updateFields);
	}
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId, IExpression condition, UpdateField ... updateFields) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		java.util.List<Object> ids = new java.util.ArrayList<Object>();
		ids.add(tableId);
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleEsitoFieldConverter().toTable(AvvisoDigitaleEsito.model()), 
				this._getMapTableToPKColumn(), 
				ids,
				this.getAvvisoDigitaleEsitoFieldConverter(), this, condition, updateFields);
	}
	
	@Override
	public void updateFields(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId, UpdateModel ... updateModels) throws NotFoundException, NotImplementedException, ServiceException, Exception {
		java.util.List<Object> ids = new java.util.ArrayList<Object>();
		ids.add(tableId);
		JDBCUtilities.updateFields(jdbcProperties, log, connection, sqlQueryObject, 
				this.getAvvisoDigitaleEsitoFieldConverter().toTable(AvvisoDigitaleEsito.model()), 
				this._getMapTableToPKColumn(), 
				ids,
				this.getAvvisoDigitaleEsitoFieldConverter(), this, updateModels);
	}
	
	@Override
	public void updateOrCreate(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, AvvisoDigitaleEsito avvisoDigitaleEsito, org.openspcoop2.generic_project.beans.IDMappingBehaviour idMappingResolutionBehaviour) throws NotImplementedException,ServiceException,Exception {
	
		// default behaviour (id-mapping)
		if(idMappingResolutionBehaviour==null){
			idMappingResolutionBehaviour = org.openspcoop2.generic_project.beans.IDMappingBehaviour.valueOf("USE_TABLE_ID");
		}
		
		Long id = avvisoDigitaleEsito.getId();
		if(id != null && this.exists(jdbcProperties, log, connection, sqlQueryObject, id)) {
			this.update(jdbcProperties, log, connection, sqlQueryObject, avvisoDigitaleEsito,idMappingResolutionBehaviour);		
		} else {
			this.create(jdbcProperties, log, connection, sqlQueryObject, avvisoDigitaleEsito,idMappingResolutionBehaviour);
		}
		
	}
	
	@Override
	public void updateOrCreate(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, long tableId, AvvisoDigitaleEsito avvisoDigitaleEsito, org.openspcoop2.generic_project.beans.IDMappingBehaviour idMappingResolutionBehaviour) throws NotImplementedException,ServiceException,Exception {
		// default behaviour (id-mapping)
		if(idMappingResolutionBehaviour==null){
			idMappingResolutionBehaviour = org.openspcoop2.generic_project.beans.IDMappingBehaviour.valueOf("USE_TABLE_ID");
		}
		
		if(this.exists(jdbcProperties, log, connection, sqlQueryObject, tableId)) {
			this.update(jdbcProperties, log, connection, sqlQueryObject, tableId, avvisoDigitaleEsito,idMappingResolutionBehaviour);
		} else {
			this.create(jdbcProperties, log, connection, sqlQueryObject, avvisoDigitaleEsito,idMappingResolutionBehaviour);
		}
	}
	
	@Override
	public void delete(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, AvvisoDigitaleEsito avvisoDigitaleEsito) throws NotImplementedException,ServiceException,Exception {
		
		
		Long longId = null;
		if(avvisoDigitaleEsito.getId()==null){
			throw new Exception("Parameter "+avvisoDigitaleEsito.getClass().getName()+".id is null");
		}
		if(avvisoDigitaleEsito.getId()<=0){
			throw new Exception("Parameter "+avvisoDigitaleEsito.getClass().getName()+".id is less equals 0");
		}
		longId = avvisoDigitaleEsito.getId();
		
		this._delete(jdbcProperties, log, connection, sqlQueryObject, longId);
		
	}

	private void _delete(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject, Long id) throws NotImplementedException,ServiceException,Exception {
	
		if(id!=null && id.longValue()<=0){
			throw new ServiceException("Id is less equals 0");
		}
		
		org.openspcoop2.generic_project.dao.jdbc.utils.JDBCPreparedStatementUtilities jdbcUtilities = 
				new org.openspcoop2.generic_project.dao.jdbc.utils.JDBCPreparedStatementUtilities(sqlQueryObject.getTipoDatabaseOpenSPCoop2(), log, connection);
		
		ISQLQueryObject sqlQueryObjectDelete = sqlQueryObject.newSQLQueryObject();
		

		// Object avvisoDigitaleEsito
		sqlQueryObjectDelete.setANDLogicOperator(true);
		sqlQueryObjectDelete.addDeleteTable(this.getAvvisoDigitaleEsitoFieldConverter().toTable(AvvisoDigitaleEsito.model()));
		if(id != null)
			sqlQueryObjectDelete.addWhereCondition("id=?");

		// Delete avvisoDigitaleEsito
		jdbcUtilities.execute(sqlQueryObjectDelete.createSQLDelete(), jdbcProperties.isShowSql(), 
			new JDBCObject(id,Long.class));

	}

	
	@Override
	public NonNegativeNumber deleteAll(JDBCServiceManagerProperties jdbcProperties, Logger log, Connection connection, ISQLQueryObject sqlQueryObject) throws NotImplementedException,ServiceException,Exception {
		
		return this.deleteAll(jdbcProperties, log, connection, sqlQueryObject, new JDBCExpression(this.getAvvisoDigitaleEsitoFieldConverter()));

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

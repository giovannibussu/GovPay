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
package it.govpay.bd.pagamento;

import it.govpay.bd.BasicBD;
import it.govpay.bd.IFilter;
import it.govpay.bd.model.Dominio;
import it.govpay.bd.model.converter.AvvisoDigitaleConverter;
import it.govpay.bd.pagamento.filters.AvvisiDigitaliFilter;
import it.govpay.model.AvvisoDigitale;
import it.govpay.orm.IdAvvisoDigitale;
import it.govpay.orm.dao.jdbc.converter.AvvisoDigitaleFieldConverter;

import java.util.ArrayList;
import java.util.List;

import org.openspcoop2.generic_project.beans.CustomField;
import org.openspcoop2.generic_project.exception.ExpressionException;
import org.openspcoop2.generic_project.exception.ExpressionNotImplementedException;
import org.openspcoop2.generic_project.exception.MultipleResultException;
import org.openspcoop2.generic_project.exception.NotFoundException;
import org.openspcoop2.generic_project.exception.NotImplementedException;
import org.openspcoop2.generic_project.exception.ServiceException;
import org.openspcoop2.generic_project.expression.IExpression;

public class AvvisiDigitaliBD extends BasicBD {

	public AvvisiDigitaliBD(BasicBD basicBD) {
		super(basicBD);
	}

	public AvvisoDigitale insertAvvisoDigitale(AvvisoDigitale dto) throws ServiceException {
		it.govpay.orm.AvvisoDigitale vo = AvvisoDigitaleConverter.toVO(dto);
		try {
			this.getAvvisoDigitaleService().create(vo);
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		}
		dto.setId(vo.getId());
		return dto;
	}
	
	public AvvisoDigitale updateAvvisoDigitale(AvvisoDigitale dto) throws ServiceException, NotFoundException {
		it.govpay.orm.AvvisoDigitale vo = AvvisoDigitaleConverter.toVO(dto);
		try {
			this.getAvvisoDigitaleService().update(this.getAvvisoDigitaleService().convertToId(vo), vo);
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		}
		dto.setId(vo.getId());
		return dto;
	}
	
	public AvvisiDigitaliFilter newFilter() throws ServiceException {
		return new AvvisiDigitaliFilter(this.getAvvisoDigitaleService());
	}
	
	public AvvisiDigitaliFilter newFilter(boolean simpleSearch) throws ServiceException {
		return new AvvisiDigitaliFilter(this.getAvvisoDigitaleService(),simpleSearch);
	}

	public long count(IFilter filter) throws ServiceException {
		try {
			return this.getAvvisoDigitaleService().count(filter.toExpression()).longValue();
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		}
	}

	public List<AvvisoDigitale> findAll(IFilter filter) throws ServiceException {
		try {
			List<AvvisoDigitale> avvisoDigitaleLst = new ArrayList<AvvisoDigitale>();
			List<it.govpay.orm.AvvisoDigitale> avvisoDigitaleVOLst = this.getAvvisoDigitaleService().findAll(filter.toPaginatedExpression()); 
			for(it.govpay.orm.AvvisoDigitale avvisoDigitaleVO: avvisoDigitaleVOLst) {
				avvisoDigitaleLst.add(AvvisoDigitaleConverter.toDTO(avvisoDigitaleVO));
			}
			return avvisoDigitaleLst;
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		}
	}

	public AvvisoDigitale get(String idMessaggioRichiesta) throws ServiceException, NotFoundException, MultipleResultException {
		try {
			IdAvvisoDigitale id = new IdAvvisoDigitale();
			id.setIdMessaggioRichiesta(idMessaggioRichiesta);
			it.govpay.orm.AvvisoDigitale avvisoDigitale = this.getAvvisoDigitaleService().get(id); 
			return AvvisoDigitaleConverter.toDTO(avvisoDigitale);
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		}
	}

	public AvvisoDigitale get(Dominio dominio, String codiceAvviso) throws ServiceException, NotFoundException, MultipleResultException {
		try {
			IExpression exp = this.getAvvisoDigitaleService().newExpression();
			AvvisoDigitaleFieldConverter converter = new AvvisoDigitaleFieldConverter(this.getJdbcProperties().getDatabase());
			CustomField cf = new CustomField("id_dominio", Long.class, "id_dominio", converter.toTable(it.govpay.orm.AvvisoDigitale.model()));
			exp.equals(cf, dominio.getId());
			exp.equals(it.govpay.orm.AvvisoDigitale.model().CODICE_AVVISO, codiceAvviso);
			return AvvisoDigitaleConverter.toDTO(this.getAvvisoDigitaleService().find(exp));
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		} catch (ExpressionException e) {
			throw new ServiceException(e);
		} catch (ExpressionNotImplementedException e) {
			throw new ServiceException(e);
		}
	}
}

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
import it.govpay.bd.model.converter.AvvisoDigitaleEsitoConverter;
import it.govpay.bd.pagamento.filters.AvvisiDigitaliEsitiFilter;
import it.govpay.model.AvvisoDigitaleEsito;
import it.govpay.orm.dao.jdbc.JDBCAvvisoDigitaleEsitoServiceSearch;

import java.util.ArrayList;
import java.util.List;

import org.openspcoop2.generic_project.exception.MultipleResultException;
import org.openspcoop2.generic_project.exception.NotFoundException;
import org.openspcoop2.generic_project.exception.NotImplementedException;
import org.openspcoop2.generic_project.exception.ServiceException;

public class AvvisiDigitaliEsitiBD extends BasicBD {

	public AvvisiDigitaliEsitiBD(BasicBD basicBD) {
		super(basicBD);
	}

	public AvvisoDigitaleEsito insertAvvisoDigitaleEsito(AvvisoDigitaleEsito dto) throws ServiceException {
		it.govpay.orm.AvvisoDigitaleEsito vo = AvvisoDigitaleEsitoConverter.toVO(dto);
		try {
			this.getAvvisoDigitaleEsitoService().create(vo);
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		}
		dto.setId(vo.getId());
		return dto;
	}
	
	public AvvisoDigitaleEsito updateAvvisoDigitaleEsito(AvvisoDigitaleEsito dto) throws ServiceException, NotFoundException {
		it.govpay.orm.AvvisoDigitaleEsito vo = AvvisoDigitaleEsitoConverter.toVO(dto);
		try {
			this.getAvvisoDigitaleEsitoService().update(vo);
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		}
		dto.setId(vo.getId());
		return dto;
	}
	
	public AvvisoDigitaleEsito get(long idAvvisoDigitaleEsito) throws ServiceException, NotFoundException {
		try {
			it.govpay.orm.AvvisoDigitaleEsito avvisoDigitaleEsito = ((JDBCAvvisoDigitaleEsitoServiceSearch)this.getAvvisoDigitaleEsitoService()).get(idAvvisoDigitaleEsito); 
			return AvvisoDigitaleEsitoConverter.toDTO(avvisoDigitaleEsito);
		} catch (MultipleResultException e) {
			throw new ServiceException(e);
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		}
	}

	public AvvisiDigitaliEsitiFilter newFilter() throws ServiceException {
		return new AvvisiDigitaliEsitiFilter(this.getAvvisoDigitaleEsitoService());
	}
	
	public AvvisiDigitaliEsitiFilter newFilter(boolean simpleSearch) throws ServiceException {
		return new AvvisiDigitaliEsitiFilter(this.getAvvisoDigitaleEsitoService(),simpleSearch);
	}

	public long count(IFilter filter) throws ServiceException {
		try {
			return this.getAvvisoDigitaleEsitoService().count(filter.toExpression()).longValue();
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		}
	}

	public List<AvvisoDigitaleEsito> findAll(IFilter filter) throws ServiceException {
		try {
			List<AvvisoDigitaleEsito> eventoLst = new ArrayList<AvvisoDigitaleEsito>();
			List<it.govpay.orm.AvvisoDigitaleEsito> eventoVOLst = this.getAvvisoDigitaleEsitoService().findAll(filter.toPaginatedExpression()); 
			for(it.govpay.orm.AvvisoDigitaleEsito eventoVO: eventoVOLst) {
				eventoLst.add(AvvisoDigitaleEsitoConverter.toDTO(eventoVO));
			}
			return eventoLst;
		} catch (NotImplementedException e) {
			throw new ServiceException(e);
		}
	}

}

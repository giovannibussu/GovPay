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
package it.govpay.bd.model.converter;

import it.govpay.model.AvvisoDigitale;
import it.govpay.orm.IdDominio;

import org.openspcoop2.generic_project.exception.ServiceException;

public class AvvisoDigitaleConverter {

	public static AvvisoDigitale toDTO(it.govpay.orm.AvvisoDigitale vo) throws ServiceException {
		AvvisoDigitale dto = new AvvisoDigitale();

		dto.setIdMessaggioRichiesta(vo.getIdMessaggioRichiesta());
		dto.setIdDominio(vo.getIdDominio().getId());
		dto.setCodiceAvviso(vo.getCodiceAvviso());
		dto.setStato(vo.getStato());
		dto.setDescrizioneStato(vo.getDescrizioneStato());
		dto.setImportoAvviso(vo.getImportoAvviso());
		dto.setDescrizionePagamento(vo.getDescrizionePagamento());
		dto.setTassonomia(vo.getTassonomia());
		dto.setAnagraficaPagatore(vo.getAnagraficaPagatore());
		dto.setTipoIdentificativoUnivoco(vo.getTipoIdentificativoUnivoco());
		dto.setCodiceIdentificativoUnivoco(vo.getCodiceIdentificativoUnivoco());
		dto.setEmailSoggettoPagatore(vo.getEmailSoggettoPagatore());
		dto.setCellulareSoggettoPagatore(vo.getCellulareSoggettoPagatore());
		dto.setDataScadenzaPagamento(vo.getDataScadenzaPagamento());
		dto.setDataScadenzaAvviso(vo.getDataScadenzaAvviso());
		dto.setDataCreazione(vo.getDataCreazione());
		dto.setUrlAvviso(vo.getUrlAvviso());
		dto.setId(vo.getId());

		return dto;
	}

	public static it.govpay.orm.AvvisoDigitale toVO(AvvisoDigitale dto) {
		it.govpay.orm.AvvisoDigitale vo = new it.govpay.orm.AvvisoDigitale();
		vo.setIdMessaggioRichiesta(dto.getIdMessaggioRichiesta());
		
		IdDominio idDominio = new IdDominio();
		idDominio.setId(dto.getIdDominio());
		vo.setIdDominio(idDominio);
		
		vo.setCodiceAvviso(dto.getCodiceAvviso());
		vo.setStato(dto.getStato());
		vo.setDescrizioneStato(dto.getDescrizioneStato());
		vo.setImportoAvviso(dto.getImportoAvviso());
		vo.setDescrizionePagamento(dto.getDescrizionePagamento());
		vo.setTassonomia(dto.getTassonomia());
		vo.setAnagraficaPagatore(dto.getAnagraficaPagatore());
		vo.setTipoIdentificativoUnivoco(dto.getTipoIdentificativoUnivoco());
		vo.setCodiceIdentificativoUnivoco(dto.getCodiceIdentificativoUnivoco());
		vo.setEmailSoggettoPagatore(dto.getEmailSoggettoPagatore());
		vo.setCellulareSoggettoPagatore(dto.getCellulareSoggettoPagatore());
		vo.setDataScadenzaPagamento(dto.getDataScadenzaPagamento());
		vo.setDataScadenzaAvviso(dto.getDataScadenzaAvviso());
		vo.setDataCreazione(dto.getDataCreazione());
		vo.setUrlAvviso(dto.getUrlAvviso());
		vo.setId(dto.getId());
		return vo;
	}
}

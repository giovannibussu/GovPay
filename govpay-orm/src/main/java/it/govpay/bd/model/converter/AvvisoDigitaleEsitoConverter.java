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

import it.govpay.model.AvvisoDigitaleEsito;
import it.govpay.orm.IdAvvisoDigitale;

import org.openspcoop2.generic_project.exception.ServiceException;

public class AvvisoDigitaleEsitoConverter {

	public static AvvisoDigitaleEsito toDTO(it.govpay.orm.AvvisoDigitaleEsito vo) throws ServiceException {
		AvvisoDigitaleEsito dto = new AvvisoDigitaleEsito();

		dto.setIdMessaggioRichiesta(vo.getIdMessaggioRichiesta());
		dto.setIdAvvisoDigitale(vo.getIdAvvisoDigitale().getId());
		dto.setIdentificativoCanale(vo.getIdentificativoCanale());
		dto.setTipoCanaleEsito(vo.getTipoCanaleEsito());
		dto.setDataEsito(vo.getDataEsito());
		dto.setCodiceEsito(vo.getCodiceEsito());
		dto.setDescrizioneEsito(vo.getDescrizioneEsito());
		dto.setId(vo.getId());
		
		return dto;
	}

	public static it.govpay.orm.AvvisoDigitaleEsito toVO(AvvisoDigitaleEsito dto) {
		it.govpay.orm.AvvisoDigitaleEsito vo = new it.govpay.orm.AvvisoDigitaleEsito();
		
		vo.setIdMessaggioRichiesta(dto.getIdMessaggioRichiesta());
		
		IdAvvisoDigitale idAvvisoDigitale = new IdAvvisoDigitale();
		idAvvisoDigitale.setId(dto.getIdAvvisoDigitale());
		vo.setIdAvvisoDigitale(idAvvisoDigitale);

		vo.setIdentificativoCanale(dto.getIdentificativoCanale());
		vo.setTipoCanaleEsito(dto.getTipoCanaleEsito());
		vo.setDataEsito(dto.getDataEsito());
		vo.setCodiceEsito(dto.getCodiceEsito());
		vo.setDescrizioneEsito(dto.getDescrizioneEsito());
		vo.setId(dto.getId());

		return vo;
	}
}

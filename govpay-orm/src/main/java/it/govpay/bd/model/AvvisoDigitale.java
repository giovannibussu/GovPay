/**
 * 
 */
package it.govpay.bd.model;

import it.govpay.bd.BasicBD;
import it.govpay.bd.anagrafica.AnagraficaManager;

import org.openspcoop2.generic_project.exception.ServiceException;

/**
 * @author Bussu Giovanni (bussu@link.it)
 * @author  $Author: bussu $
 */
public class AvvisoDigitale extends it.govpay.model.AvvisoDigitale {

	private static final long serialVersionUID = 1L;
	
	private transient Dominio dominio;

	public Dominio getPsp(BasicBD bd) throws ServiceException {
		if(dominio == null) {
			dominio = AnagraficaManager.getDominio(bd, this.getIdDominio());
		}
		return dominio;
	}

	@Override
	public void setIdDominio(long idDominio) {
		super.setIdDominio(idDominio);
		this.dominio = null;
	}

}

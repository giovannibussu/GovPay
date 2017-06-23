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
public class AvvisoDigitaleEsito extends it.govpay.model.AvvisoDigitaleEsito {

	private static final long serialVersionUID = 1L;
	
	private transient AvvisoDigitale avvisoDigitale;

	public AvvisoDigitale getPsp(BasicBD bd) throws ServiceException {
		if(avvisoDigitale == null) {
			avvisoDigitale = AnagraficaManager.getAvvisoDigitale(bd, this.getIdAvvisoDigitale());
		}
		return avvisoDigitale;
	}

	@Override
	public void setIdAvvisoDigitale(long idAvvisoDigitale) {
		super.setIdAvvisoDigitale(idAvvisoDigitale);
		this.avvisoDigitale = null;
	}

}

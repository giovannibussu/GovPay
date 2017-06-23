/**
 * 
 */
package it.govpay.bd.model;

import it.govpay.bd.BasicBD;
import it.govpay.bd.pagamento.AvvisiDigitaliBD;

import org.openspcoop2.generic_project.exception.NotFoundException;
import org.openspcoop2.generic_project.exception.ServiceException;

/**
 * @author Bussu Giovanni (bussu@link.it)
 * @author  $Author: bussu $
 */
public class AvvisoDigitaleEsito extends it.govpay.model.AvvisoDigitaleEsito {

	private static final long serialVersionUID = 1L;
	
	private transient it.govpay.model.AvvisoDigitale avvisoDigitale;

	public it.govpay.model.AvvisoDigitale getAvvisoDigitale(BasicBD bd) throws ServiceException, NotFoundException {
		if(avvisoDigitale == null) {
			avvisoDigitale = new AvvisiDigitaliBD(bd).get(this.getIdAvvisoDigitale());
		}
		return avvisoDigitale;
	}

	@Override
	public void setIdAvvisoDigitale(long idAvvisoDigitale) {
		super.setIdAvvisoDigitale(idAvvisoDigitale);
		this.avvisoDigitale = null;
	}

}

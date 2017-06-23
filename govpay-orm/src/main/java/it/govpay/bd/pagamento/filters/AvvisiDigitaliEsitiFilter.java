package it.govpay.bd.pagamento.filters;

import it.govpay.bd.AbstractFilter;
import it.govpay.orm.AvvisoDigitaleEsito;

import org.apache.commons.lang.StringUtils;
import org.openspcoop2.generic_project.dao.IExpressionConstructor;
import org.openspcoop2.generic_project.exception.ExpressionException;
import org.openspcoop2.generic_project.exception.ExpressionNotImplementedException;
import org.openspcoop2.generic_project.exception.NotImplementedException;
import org.openspcoop2.generic_project.exception.ServiceException;
import org.openspcoop2.generic_project.expression.IExpression;

public class AvvisiDigitaliEsitiFilter extends AbstractFilter{
	
	private String idMessaggioRichiesta;
	
	public AvvisiDigitaliEsitiFilter(IExpressionConstructor expressionConstructor) {
		this(expressionConstructor,false);
	}
	
	public AvvisiDigitaliEsitiFilter(IExpressionConstructor expressionConstructor, boolean simpleSearch) {
		super(expressionConstructor, simpleSearch);
	}

	@Override
	public IExpression _toExpression() throws ServiceException {
		try {
			IExpression newExpression = newExpression();
			
			boolean addAnd = false;
			
			if(this.idMessaggioRichiesta != null && StringUtils.isNotEmpty(this.idMessaggioRichiesta)) {
				if(addAnd)
					newExpression.and();
				
				newExpression.equals(AvvisoDigitaleEsito.model().ID_AVVISO_DIGITALE.ID_MESSAGGIO_RICHIESTA, this.idMessaggioRichiesta);
				addAnd = true;
			}
			
			return newExpression;
		}  catch (NotImplementedException e) {
			throw new ServiceException(e);
		} catch (ExpressionNotImplementedException e) {
			throw new ServiceException(e);
		} catch (ExpressionException e) {
			throw new ServiceException(e);
		}
	}

	
}

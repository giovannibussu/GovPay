package it.govpay.bd.pagamento.filters;

import it.govpay.bd.AbstractFilter;
import it.govpay.orm.AvvisoDigitale;
import it.govpay.orm.dao.jdbc.converter.AvvisoDigitaleFieldConverter;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.openspcoop2.generic_project.beans.CustomField;
import org.openspcoop2.generic_project.dao.IExpressionConstructor;
import org.openspcoop2.generic_project.exception.ExpressionException;
import org.openspcoop2.generic_project.exception.ExpressionNotImplementedException;
import org.openspcoop2.generic_project.exception.NotImplementedException;
import org.openspcoop2.generic_project.exception.ServiceException;
import org.openspcoop2.generic_project.expression.IExpression;

public class AvvisiDigitaliFilter extends AbstractFilter{
	
	private String idDominio;
	private String stato;
	private Date dataInizioInserimento;
	private Date dataFineInserimento;
	
	public AvvisiDigitaliFilter(IExpressionConstructor expressionConstructor) {
		this(expressionConstructor,false);
	}
	
	public AvvisiDigitaliFilter(IExpressionConstructor expressionConstructor, boolean simpleSearch) {
		super(expressionConstructor, simpleSearch);
	}

	@Override
	public IExpression _toExpression() throws ServiceException {
		try {
			IExpression newExpression = newExpression();
			
			boolean addAnd = false;
			
			if(this.idDominio != null){
				AvvisoDigitaleFieldConverter converter = new AvvisoDigitaleFieldConverter(this.getRootTable());  
				CustomField customFieldIdDominio = new CustomField("id_dominio", Long.class, "id_dominio", converter.toAliasTable(AvvisoDigitale.model()));
				newExpression.equals(customFieldIdDominio, this.idDominio);
				addAnd = true;
			}
			
			if(this.stato != null && StringUtils.isNotEmpty(this.stato)) {
				if(addAnd)
					newExpression.and();
				
				newExpression.equals(AvvisoDigitale.model().STATO, this.stato);
				addAnd = true;
			}
			
			
			if(this.dataInizioInserimento != null && this.dataFineInserimento != null) {
				if(addAnd)
					newExpression.and();

				newExpression.between(AvvisoDigitale.model().DATA_CREAZIONE, this.dataInizioInserimento,this.dataFineInserimento);
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

	public String getIdDominio() {
		return idDominio;
	}

	public void setIdDominio(String idDominio) {
		this.idDominio = idDominio;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataInizioInserimento() {
		return dataInizioInserimento;
	}

	public void setDataInizioInserimento(Date dataInizioInserimento) {
		this.dataInizioInserimento = dataInizioInserimento;
	}

	public Date getDataFineInserimento() {
		return dataFineInserimento;
	}

	public void setDataFineInserimento(Date dataFineInserimento) {
		this.dataFineInserimento = dataFineInserimento;
	}
	

	
}

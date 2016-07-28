package it.agid.pap.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

	private final NumberFormat numberFormat = NumberFormat.getInstance(Locale.ITALIAN);
	
	@Override
	public String marshal(BigDecimal v) {
		return numberFormat.format(v);
	}

	@Override
	public BigDecimal unmarshal(String v) throws ParseException {
		return BigDecimal.valueOf(numberFormat.parse(v).doubleValue());
	}

}
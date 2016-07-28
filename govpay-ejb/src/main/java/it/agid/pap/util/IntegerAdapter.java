package it.agid.pap.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IntegerAdapter extends XmlAdapter<String, Integer> {

	private final NumberFormat numberFormat = NumberFormat.getInstance(Locale.ITALIAN);
	
	@Override
	public String marshal(Integer v) {
		return numberFormat.format(v);
	}

	@Override
	public Integer unmarshal(String v) throws ParseException {
		return numberFormat.parse(v).intValue();
	}

}
package it.agid.pap.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateISO8601Adapter extends XmlAdapter<String, Date> {

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T':hh:mm:ss'.'S");

	@Override
	public String marshal(Date v) {
		return dateFormat.format(v);
	}

	@Override
	public Date unmarshal(String v) throws ParseException {
		if (v.contains("-")) {
			return dateFormat.parse(v);
		}

		return new Date(Long.parseLong(v));

	}

	public enum DateRange {
		MIN_HOUR, MAX_HOUR
	}

}
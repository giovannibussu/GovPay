package it.agid.pap.model;

public class IUV extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7993807096622991091L;

	private String checkDigit;

	private String papCode;

	private String julianDate;

	private String counter;

	private String code;

	public String getCheckDigit() {
		return checkDigit;
	}

	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}

	public String getPapCode() {
		return papCode;
	}

	public void setPapCode(String papCode) {
		this.papCode = papCode;
	}

	public String getJulianDate() {
		return julianDate;
	}

	public void setJulianDate(String julianDate) {
		this.julianDate = julianDate;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

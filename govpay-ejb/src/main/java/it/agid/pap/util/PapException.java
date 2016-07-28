package it.agid.pap.util;

public class PapException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7249846208579324118L;

	private String errorCode;

	public PapException(FaultCodes errorCode) {
		super();
		this.errorCode = errorCode.name();
	}

	public PapException(FaultCodes errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode.name();
	}

	public PapException(FaultCodes errorCode, String msg, Throwable t) {
		super(msg, t);
		this.errorCode = errorCode.name();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}

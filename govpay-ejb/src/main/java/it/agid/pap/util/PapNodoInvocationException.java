package it.agid.pap.util;

public class PapNodoInvocationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8082585804745908773L;

	private final String errorCode;

	public PapNodoInvocationException(String errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
	}

	public PapNodoInvocationException(String errorCode, String errorMsg, Throwable t) {
		super(errorMsg, t);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}

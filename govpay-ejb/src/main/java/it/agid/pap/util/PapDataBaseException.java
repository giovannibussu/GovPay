package it.agid.pap.util;

public class PapDataBaseException extends PapException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2122574131836210053L;

	public PapDataBaseException(FaultCodes errorCode, String msg) {
		super(errorCode, msg);
	}

}

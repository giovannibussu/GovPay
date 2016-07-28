package it.agid.pap.model;

import javax.xml.bind.annotation.XmlTransient;

public class Pratica extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -887614211203395630L;

	private String iuv;

	private RPT rpt;

	private RT rt;

	private StatoPratica state;

	private String errorMsg;

	private boolean iuvInterno;

	/**
	 * TODO - Aggiunta Flussi
	 */

	/**
	 * @return the {@link Pratica#iuv}
	 */
	public String getIuv() {
		return iuv;
	}

	/**
	 * @param iuv
	 *            the iuv to set
	 */
	public void setIuv(String iuv) {
		this.iuv = iuv;
	}

	/**
	 * @return the {@link Pratica#rpt}
	 */
	public RPT getRpt() {
		return rpt;
	}

	/**
	 * @param rpt
	 *            the rpt to set
	 */
	public void setRpt(RPT rpt) {
		this.rpt = rpt;
	}

	/**
	 * @return the {@link Pratica#rt}
	 */
	public RT getRt() {
		return rt;
	}

	/**
	 * @param rt
	 *            the rt to set
	 */
	public void setRt(RT rt) {
		this.rt = rt;
	}

	/**
	 * @return the {@link Pratica#state}
	 */
	public StatoPratica getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(StatoPratica state) {
		this.state = state;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean isIuvInterno() {
		return iuvInterno;
	}

	public void setIuvInterno(boolean iuvInterno) {
		this.iuvInterno = iuvInterno;
	}

	@XmlTransient
	public String getStatoPratica() {
		return this.state != null ? this.getState().getStato() : null;
	}

	

}

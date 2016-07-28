package it.agid.pap.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
@JsonIgnoreProperties({ "id" ,"insertDate", "lastUpdate", "cancelled" })
public abstract class AbstractEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -499993316928367894L;

	private Long id;
	
	@XmlTransient
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Date insertDate;

	private Date lastUpdate;

	private boolean cancelled;

	public void initInsertDate() {
		this.insertDate = new Date();
		this.lastUpdate = this.insertDate;
	}

	public void initLastUpdate() {
		this.lastUpdate = new Date();
	}

	@XmlTransient
	public Date getInsertDate() {
		return this.insertDate != null ? new Date(this.insertDate.getTime())
				: null;
	}

	public void setInsertDate(Date insertDate) {
		if (insertDate != null) {
			this.insertDate = new Date(insertDate.getTime());
		}
	}

	@XmlTransient
	public Date getLastUpdate() {
		return this.lastUpdate != null ? new Date(lastUpdate.getTime()) : null;
	}

	public void setLastUpdate(Date lastUpdate) {
		if (lastUpdate != null) {
			this.lastUpdate = new Date(lastUpdate.getTime());
		}
	}

	@XmlTransient
	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}

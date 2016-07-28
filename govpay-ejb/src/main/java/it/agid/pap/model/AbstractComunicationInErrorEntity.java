package it.agid.pap.model;

public abstract class AbstractComunicationInErrorEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3914448525208385244L;

//	@Column(name = "data_content", columnDefinition = "MEDIUMTEXT", nullable = false)
//	private String xmlContent;
	
	private byte[] content;

	private String errorDescription;

	private String iuv;

//	public String getXmlContent() {
//		return xmlContent;
//	}
//
//	public void setXmlContent(String xmlContent) {
//		this.xmlContent = xmlContent;
//	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getIuv() {
		return iuv;
	}

	public void setIuv(String iuv) {
		this.iuv = iuv;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	

}

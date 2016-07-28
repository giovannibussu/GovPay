package it.agid.pap.util;

import it.gov.digitpa.schemas._2011.ws.paa.FaultBean;
import it.agid.pap.util.DateAdapter.DateRange;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSSignedData;
import org.codehaus.jackson.map.ObjectMapper;

public final class PapUtils {

	private static Log log = LogFactory.getLog(PapUtils.class);

	private static final DateAdapter DATE_ADAPTER = new DateAdapter();

	private PapUtils() {
	}

	/**
	 * Da java (Object) a xml (String)
	 * 
	 * @param obj
	 * @return
	 */
	public static String toXml(Object obj) throws PapException {
		StringWriter sw = new StringWriter();
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(obj.getClass());

			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(obj, sw);
		} catch (JAXBException e) {
			log.error("Marshalling error", e);
			throw new PapException(FaultCodes.PAA_SINTASSI_XSD, e.getMessage(),
					e);
		}
		return sw.toString();
	}

	/**
	 * Da xml (String) a java(Object)
	 * 
	 * @param obj
	 * @return
	 */
	public static Object fromXml(String str, Class<?> clazz)
			throws PapException {
		Object obj = null;
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(clazz);
			ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
			Unmarshaller m = jc.createUnmarshaller();
			obj = m.unmarshal(bais);
		} catch (JAXBException e) {
			log.error("Unmarshalling error", e);
			throw new PapException(FaultCodes.PAA_SINTASSI_XSD, e.getMessage(),
					e);
		}

		return obj;
	}


	public static String fromDataHandler(DataHandler dataHandler) {
		String result = null;
		InputStream in = null;
		try {
			in = dataHandler.getInputStream();
			result = getStringFromInputStream(in);
		} catch (IOException e) {
			log.error("Error with input stream", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {

				}
			}
		}
		return result;
	}


	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			log.error("Error while reading from InputStream", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					log.error("Error trying to close BufferedReader", e);
				}
			}
		}

		return sb.toString();

	}

	public static FaultBean papIntGetFaultBean(PapException e) {
		return createFaultBean(e.getErrorCode(), e.getMessage());
	}

	public static FaultBean createFaultBean(String code, String message) {
		FaultBean fault = new FaultBean();
		fault.setFaultCode(code);
		if (message != null) {
			fault.setFaultString(message);
		}
		String dominioPAP = System.getProperty(PapConstants.IDENT_DOMINIO_PA);
		fault.setId(dominioPAP);
		return fault;
	}

	public static XMLGregorianCalendar papIntDateToXMLGregorianCalendar(
			Date date) {
		return papIntDateToXMLGregorianCalendar(date, null);
	}

	public static XMLGregorianCalendar papIntDateToXMLGregorianCalendar(
			Date date, DateRange range) {
		XMLGregorianCalendar value = null;
		if (date != null) {
			GregorianCalendar gc = (GregorianCalendar) GregorianCalendar
					.getInstance();
			gc.setTime(date);
			if (range != null) {
				switch (range) {
				case MIN_HOUR:
					gc.set(Calendar.HOUR_OF_DAY, 0);
					gc.set(Calendar.MINUTE, 0);
					gc.set(Calendar.SECOND, 1);
					break;
				case MAX_HOUR:
					gc.set(Calendar.HOUR_OF_DAY, 24);
					gc.set(Calendar.MINUTE, 0);
					gc.set(Calendar.SECOND, 0);
				}
			}
			DatatypeFactory dataTypeFactory = null;
			try {
				dataTypeFactory = DatatypeFactory.newInstance();
				value = dataTypeFactory.newXMLGregorianCalendar(gc);
			} catch (DatatypeConfigurationException e) {
				log.error("Impossibile ottenere istanza di DatatypeFactory. Returning null value");
			}
		}
		return value;
	}

	public static XMLGregorianCalendar papIntStringToXMLGregorianCalendar(
			Date date) {
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			log.error("Impossibile ottenere istanza di DatatypeFactory. Returning null value");
		}
		
		
		return date2;
	}
	
	public static XMLGregorianCalendar papIntStringToXMLGregorianCalendar(
			String date) {
		return papIntStringToXMLGregorianCalendar(date, null);
	}

	public static XMLGregorianCalendar papIntStringToXMLGregorianCalendar(
			String date, DateRange range) {
		Date parsedDate = parseDate(date);
		return parsedDate != null ? papIntDateToXMLGregorianCalendar(
				parsedDate, range) : null;
	}

	public static Date parseDate(String date) {
		Date result = null;
		try {
			result = DATE_ADAPTER.unmarshal(date);
		} catch (NumberFormatException e) {
			log.error("Impossibile effettuare parsing della data " + date
					+ ". Returning null value!");
		} catch (ParseException e) {
			log.error("Impossibile effettuare parsing della data " + date
					+ ". Returning null value!");
		}
		return result;
	}

	public static String formatDate(Date date) {
		return DATE_ADAPTER.marshal(date);
	}

	public static byte[] getUnSignedContent(InputStream is) throws PapException {
		byte[] result = null;
		try {
			CMSSignedData sdp = new CMSSignedData(is);
			CMSProcessable cmsp = sdp.getSignedContent();

			result = (byte[]) cmsp.getContent();
		} catch (Exception e) {
			log.error("Impossibile effettuare lo sbustamento: "
					+ e.getMessage());
			throw new PapException(FaultCodes.PAP_ERRORE_FORMATO_BUSTA_FIRMATA,
					"Impossibile effettuare lo sbustamento: " + e.getMessage());
		}

		return result;
	}

	public static byte[] getUnSignedContent(byte[] signetContent)
			throws PapException {
		byte[] result = null;
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(signetContent);
			CMSSignedData sdp = new CMSSignedData(is);
			CMSProcessable cmsp = sdp.getSignedContent();

			result = (byte[]) cmsp.getContent();
		} catch (Exception e) {
			log.error("Impossibile effettuare lo sbustamento: "
					+ e.getMessage());
			throw new PapException(FaultCodes.PAP_ERRORE_FORMATO_BUSTA_FIRMATA,
					"Impossibile effettuare lo sbustamento: " + e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {

				}
			}
		}

		return result;
	}

	/**
	 * Da java (Object) a JSON (String)
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJSON(Object obj) {
		String result = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			result = objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			log.error("JSON Marshalling error", e);
		}
		return result;
	}

	/**
	 * Da JSON (String) a java(Object)
	 * 
	 * @param obj
	 * @return
	 */

	public static BigDecimal roundDecimals(BigDecimal decimal) {
		decimal = decimal.setScale(2,
				RoundingMode.HALF_EVEN);
		return decimal;
	}

}

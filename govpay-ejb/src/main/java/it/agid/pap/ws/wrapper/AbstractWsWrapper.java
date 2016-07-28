package it.agid.pap.ws.wrapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceClient;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractWsWrapper<X, Y extends Service> implements WsWrapper<X, Service> {

	private static final String EXCEPTION_MSG = "Exception catched!";
	private final Log log = LogFactory.getLog(getClass());

	protected abstract String getNamespace();

	protected abstract String getWsClassName();

	protected abstract String getWsBindClassName();

	protected String getExposedServiceName() {
		return StringUtils.EMPTY;
	}

	protected void addBindingProviderProperties(BindingProvider bindingProvider) {
		log.info("addBindingProviderProperties DEFAULT -> SKIPPING");
	}

	protected void beforeServicePortInvocation() {
		log.info("beforeServicePortInvocation DEFAULT -> SKIPPING");
	}

	private String getEndpoint() {
		return this.getInternalPropertyByKey(StringUtils.EMPTY);
	}

	protected abstract String getWSDLName();

	private String getInternalPropertyByKey(String propKey) {
		log.info("Accessing endpoint ...");
		String result = StringUtils.EMPTY;

		String simpleName = this.getClass().getSimpleName();

		String endpointType = System.getProperty(simpleName + "_TYPE");

		log.info("simple name = " + simpleName + ", endpoint type = " + endpointType);

		if (StringUtils.isNotBlank(endpointType)) {

			result = System.getProperty(simpleName + ((StringUtils.isNotBlank(propKey)) ? propKey : "_") + endpointType);

			log.info("endpoint value = " + result);
			if (StringUtils.isBlank(result)) {
				log.error("endpoint value is empty!");
				throw new IllegalArgumentException("Attenzione, e' stato specificato un tipo di puntamento non valido per la classe wrapper "
						+ simpleName);
			}

		} else {
			log.error("endpoint type is empty!");
			throw new IllegalArgumentException("Attenzione, non e' stato specificato un tipo di puntamento per la classe wrapper " + simpleName);
		}

		return result;
	}

	@Override
	public X getService() {
		return this.getService(this.getEndpoint(), this.getWSDLName());
	}

	private X getService(String endpoint, String wsdlLocation) {
		log.info("Accessing service instance ... START");
		X service = null;
		URL wsdlFile = getClass().getClassLoader().getResource(wsdlLocation);
		log.info("WSDL URL = " + wsdlFile.getPath());
		try {

			String nameWs = this.determineWsName();
			this.beforeServicePortInvocation();
			Y serviceBind = this.accessServiceBind(nameWs, wsdlFile);
			service = this.accessService(endpoint, serviceBind);

		} catch (SecurityException e) {
			log.error(EXCEPTION_MSG, e);
		} catch (NoSuchMethodException e) {
			log.error(EXCEPTION_MSG, e);
		} catch (ClassNotFoundException e) {
			log.error(EXCEPTION_MSG, e);
		} catch (IllegalArgumentException e) {
			log.error(EXCEPTION_MSG, e);
		} catch (MalformedURLException e) {
			log.error(EXCEPTION_MSG, e);
		} catch (InstantiationException e) {
			log.error(EXCEPTION_MSG, e);
		} catch (IllegalAccessException e) {
			log.error(EXCEPTION_MSG, e);
		} catch (InvocationTargetException e) {
			log.error(EXCEPTION_MSG, e);
		} catch (javax.xml.ws.WebServiceException e) {
			log.error(EXCEPTION_MSG, e);
		}

		return service;
	}

	private String determineWsName() throws ClassNotFoundException {
		String exposedServiceName = this.determineExposedServiceName();
		String nameWs = StringUtils.isNotBlank(exposedServiceName) ? exposedServiceName : this.getExposedServiceName();
		return nameWs;
	}

	@SuppressWarnings("unchecked")
	private X accessService(String url, Y serviceBind) throws ClassNotFoundException {
		X service = (X) serviceBind.getPort(Class.forName(this.getWsClassName()));
		log.info("Service = " + service);

		if (service != null) {
			log.info("Endpoint address: " + url);
			BindingProvider bp = (BindingProvider) service;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
			this.addBindingProviderProperties(bp);

			log.info("Service obtained = [" + serviceBind + "]");
		}
		return service;
	}

	private Y accessServiceBind(String nameWs, URL wsdlLocation) throws InstantiationException, IllegalAccessException, InvocationTargetException,
			MalformedURLException, NoSuchMethodException, ClassNotFoundException {

		Constructor<?> constructor = Class.forName(this.getWsBindClassName()).getConstructor(URL.class, QName.class);

		@SuppressWarnings("unchecked")
		Y serviceBind = (Y) constructor.newInstance(wsdlLocation,
				new QName(this.getNamespace(), StringUtils.substring(nameWs, StringUtils.lastIndexOf(nameWs, '.') + 1)));

		log.info("Service Binding = " + serviceBind);

		return serviceBind;
	}

	private String determineExposedServiceName() throws ClassNotFoundException {
		String exposedServiceName = StringUtils.EMPTY;
		Class<?> serviceClass = Class.forName(this.getWsBindClassName());
		if (serviceClass.isAnnotationPresent(WebServiceClient.class)) {
			WebServiceClient wsAnnotation = serviceClass.getAnnotation(WebServiceClient.class);
			exposedServiceName = wsAnnotation.name();
		}
		log.info("Exposed service name = [" + exposedServiceName + "]");
		return exposedServiceName;
	}

}

package org.governance.ea.platform.part.forms.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author Chika
 *
 */
public class WSDLServiceModel {

	private String processName;
	private String wsdlName;
	private String serviceName;
	private String portBinding;
	private String operationName;
	private String requestName;
	private String responseName;
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public WSDLServiceModel(String processName, String wsdlName, String serviceName, String portBinding, String operationName,
			String requestName, String responseName) {
		super();
		this.processName = processName;
		this.wsdlName = wsdlName;
		this.serviceName = serviceName;
		this.portBinding = portBinding;
		this.operationName = operationName;
		this.requestName = requestName;
		this.responseName = responseName;
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public WSDLServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getWsdlName() {
		return wsdlName;
	}

	public void setWsdlName(String wsdlName) {
		this.wsdlName = wsdlName;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getOperationName() {
		return this.operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getRequestName() {
		return this.requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public String getResponseName() {
		return this.responseName;
	}

	public void setResponseName(String responseName) {
		this.responseName = responseName;
	}

	public String getPortBinding() {
		return portBinding;
	}

	public void setPortBinding(String portBinding) {
		this.portBinding = portBinding;
	}

}

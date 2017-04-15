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
	private String ServiceName;
	private String OperationName;
	private String RequestName;
	private String ResponseName;
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public WSDLServiceModel(String processName, String wsdlName, String serviceName, String operationName,
			String requestName, String responseName) {
		super();
		this.processName = processName;
		this.wsdlName = wsdlName;
		ServiceName = serviceName;
		OperationName = operationName;
		RequestName = requestName;
		ResponseName = responseName;
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
		return ServiceName;
	}

	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}

	public String getOperationName() {
		return OperationName;
	}

	public void setOperationName(String operationName) {
		OperationName = operationName;
	}

	public String getRequestName() {
		return RequestName;
	}

	public void setRequestName(String requestName) {
		RequestName = requestName;
	}

	public String getResponseName() {
		return ResponseName;
	}

	public void setResponseName(String responseName) {
		ResponseName = responseName;
	}

}

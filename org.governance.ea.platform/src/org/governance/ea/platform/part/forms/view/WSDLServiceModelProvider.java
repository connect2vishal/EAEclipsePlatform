package org.governance.ea.platform.part.forms.view;

import java.util.ArrayList;
import java.util.List;

import org.governance.ea.platform.util.GridViewUtil;

public enum WSDLServiceModelProvider {
    INSTANCE;

    private List<WSDLServiceModel> wsdlServiceModel;

	private WSDLServiceModelProvider() {
		wsdlServiceModel = new ArrayList<WSDLServiceModel>();
		
		wsdlServiceModel.add(new WSDLServiceModel("ProcessName1", "WSDL Name1", "Service Name1","Port 1", "Operation 1","Request 1","Response 1"));
		wsdlServiceModel.add(new WSDLServiceModel("ProcessName 2 ", "WSDL Name2", "Service Name2","Port 2", "Operation 2","Request 2","Response 2"));
	}

	public List<WSDLServiceModel> getWsdlServiceModel() {
		return wsdlServiceModel;
	}
//
//	public void setWsdlServiceModel(List<WSDLServiceModel> wsdlServiceModel) {
//		this.wsdlServiceModel = wsdlServiceModel;
//	}

	public List<WSDLServiceModel> getDatafromFiles() {		
		wsdlServiceModel = new ArrayList<WSDLServiceModel>();
		return GridViewUtil.getViewerModel(wsdlServiceModel);
	}

}

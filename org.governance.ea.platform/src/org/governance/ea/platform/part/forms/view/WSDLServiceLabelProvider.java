/**
 * 
 */
package org.governance.ea.platform.part.forms.view;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author Chika
 *
 */
public class WSDLServiceLabelProvider extends LabelProvider implements ITableLabelProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.
	 * Object, int)
	 */
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.
	 * Object, int)
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {

		WSDLServiceModel wsdlServiceModel = (WSDLServiceModel) element;
		String text = "";
		switch (columnIndex) {
		case 0:
			text = wsdlServiceModel.getProcessName();
			break;
		case 1:
			text = wsdlServiceModel.getWsdlName();
			break;
		case 2:
			text = wsdlServiceModel.getServiceName();
			break;
		case 3:
			text = wsdlServiceModel.getPortBinding();
			break;
		case 4:
			text = wsdlServiceModel.getOperationName();
			break;
		case 5:
			text = wsdlServiceModel.getRequestName();
			break;
		case 6:
			text = wsdlServiceModel.getResponseName();
			break;
		}
		return text;
	}

}

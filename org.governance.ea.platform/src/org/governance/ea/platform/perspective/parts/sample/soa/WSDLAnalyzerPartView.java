package org.governance.ea.platform.perspective.parts.sample.soa;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class WSDLAnalyzerPartView extends ViewPart {

	public static final String ID = "org.governance.ea.platform.parts.soa.WSDLAnalyzerPartView"; //$NON-NLS-1$

	public WSDLAnalyzerPartView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		{
			Label lblWsdlAnalyzer = new Label(container, SWT.NONE);
			GridData gd_lblWsdlAnalyzer = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblWsdlAnalyzer.widthHint = 496;
			lblWsdlAnalyzer.setLayoutData(gd_lblWsdlAnalyzer);
			lblWsdlAnalyzer.setText("WSDL Analyzer");
		}

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}

package org.governance.ea.platform.perspective.parts.sample;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;

public class Welcome1PageBookView extends Page {

	private Composite control;

	/**
	 * Create the PageBookView Page.
	 */
	public Welcome1PageBookView() {
	}

	/**
	 * Create contents of the PageBookView Page.
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		control = container;
	}

	@Override
	public Control getControl() {
		return control;
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		createActions();
		initializeToolBar();
		initializeMenu();
	}

	@Override
	public void setFocus() {
		// Set the focus
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
		IToolBarManager toolbarManager = getSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getSite().getActionBars().getMenuManager();
	}

}

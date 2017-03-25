package org.governance.ea.platform.perspective.parts.sample;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class FormDetailPage implements IDetailsPage {
	public FormDetailPage() {
	}

	private IManagedForm managedForm;
	private Text text;
	private Text text_1;

	/**
	 * Initialize the details page.
	 * @param form
	 */
	public void initialize(IManagedForm form) {
		managedForm = form;
	}

	/**
	 * Create contents of the details page.
	 * @param parent
	 */
	@PostConstruct
	public void createContents(Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		parent.setLayout(new FillLayout());
		//		
		Section sctnWelcome = toolkit.createSection(parent, ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR);
		sctnWelcome.setText("Welcome");
		//
		Composite composite = toolkit.createComposite(sctnWelcome, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnWelcome.setClient(composite);
		composite.setLayout(new GridLayout(3, false));
		
		Label lblName = new Label(composite, SWT.NONE);
		GridData gd_lblName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblName.widthHint = 109;
		lblName.setLayoutData(gd_lblName);
		toolkit.adapt(lblName, true, true);
		lblName.setText("Name : ");
		new Label(composite, SWT.NONE);
		
		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(text, true, true);
		
		Label lblClass = new Label(composite, SWT.NONE);
		toolkit.adapt(lblClass, true, true);
		lblClass.setText("Class : ");
		new Label(composite, SWT.NONE);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(text_1, true, true);
	}

	public void dispose() {
		// Dispose
	}

	public void setFocus() {
		// Set focus
	}

	private void update() {
		// Update
	}

	public boolean setFormInput(Object input) {
		return false;
	}

	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		update();
	}

	public void commit(boolean onSave) {
		// Commit
	}

	public boolean isDirty() {
		return false;
	}

	public boolean isStale() {
		return false;
	}

	public void refresh() {
		update();
	}

}

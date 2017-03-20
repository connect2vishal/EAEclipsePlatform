package org.governance.ea.platform.perspective.parts.sample;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.Section;

public class FormPage extends org.eclipse.ui.forms.editor.FormPage {

	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public FormPage(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public FormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Empty FormPage");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		
		Form frmNewForm = managedForm.getToolkit().createForm(managedForm.getForm().getBody());
		frmNewForm.setBounds(10, 213, 200, 104);
		managedForm.getToolkit().paintBordersFor(frmNewForm);
		frmNewForm.setText("New Form");
		
		Section sctnNewSection = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setBounds(10, 10, 355, 142);
		managedForm.getToolkit().paintBordersFor(sctnNewSection);
		sctnNewSection.setText("New Section");
	}
}

package org.governance.ea.platform.perspective.parts.sample.soa;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;

public class SOAEditorPartView extends EditorPart {

	public static final String ID = "org.governance.ea.platform.perspective.parts.sample.SOAEditorPartView"; //$NON-NLS-1$
	private Text welcome;

	public SOAEditorPartView() {
	}

	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	@Override
	@PostConstruct
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		
		welcome = new Text(container, SWT.BORDER);
		welcome.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblWelcome = new Label(container, SWT.NONE);
		lblWelcome.setText("Welcome");

	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// Initialize the editor part
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
}

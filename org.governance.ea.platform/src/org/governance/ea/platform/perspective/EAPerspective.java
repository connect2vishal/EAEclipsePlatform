package org.governance.ea.platform.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class EAPerspective implements IPerspectiveFactory {

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
		layout.addView("org.governance.ea.platform.parts.soa.WSDLAnalyzerPartView", IPageLayout.LEFT, 0.33f, IPageLayout.ID_EDITOR_AREA);
		layout.addView("org.governance.ea.platform.parts.soa.EANavigatorPartView", IPageLayout.RIGHT, 0.5f, IPageLayout.ID_EDITOR_AREA);
		layout.addView("org.governance.ea.platform.parts.soa.SOAEditorPartView", IPageLayout.BOTTOM, 0.5f, IPageLayout.ID_EDITOR_AREA);
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
	}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {
	}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
	}

}

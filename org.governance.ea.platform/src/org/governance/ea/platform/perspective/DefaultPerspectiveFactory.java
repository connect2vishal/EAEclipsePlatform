package org.governance.ea.platform.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class DefaultPerspectiveFactory  implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		addFastViews(layout);
		// TODO Auto-generated method stub
		
	}

	private void addFastViews(IPageLayout layout) {
	}
}

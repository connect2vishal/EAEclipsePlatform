package org.governance.ea.platform.perspective;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	@Override
	public String getInitialWindowPerspectiveId() {
		// TODO Auto-generated method stub
		return null;
	}

	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
}

//	public void preWindowOpen() {
//	        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
//	        configurer.setInitialSize(new Point(400, 300));
//	        configurer.setShowCoolBar(false);
//	        configurer.setShowStatusLine(false);
//	        configurer.setTitle("Todo"); //$NON-NLS-1$
//	}
}

package org.governance.ea.platform.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class EAPerspectiveHandler {

	@Execute
	public void execute(MApplication app, EPartService partService, EModelService modelService) {
       
		System.out.println("EA Perspective Handler Started !!!");
        
       MPerspective element = (MPerspective) modelService.find("org.governance.ea.platform.perspective.EAPerpective", app);
        // now switch perspective
        partService.switchPerspective(element);
        
       System.out.println("EA Perspective Handler Handled !!!");
	}

}

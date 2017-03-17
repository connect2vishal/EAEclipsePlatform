package org.governance.ea.platform.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

public class ExitPlatformHandler {
/*    @Execute
    public void execute() {
      System.out.println((this.getClass().getSimpleName() + " called"));
    }*/
	
	@Execute
    public void execute(IWorkbench workbench) {
            workbench.close();
    }
}

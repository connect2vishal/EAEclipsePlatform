package com.example.e4.rcp.todo;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class RunToolItem {
    @PostConstruct
    public void createControls(Composite parent) {
            final Composite comp = new Composite(parent, SWT.NONE);
            comp.setLayout(new GridLayout());
//            Text text = new Text(comp, SWT.SEARCH | SWT.ICON_SEARCH | SWT.CANCEL
//                            | SWT.BORDER);
            Button button = new Button(comp, SWT.BORDER);
            button.setText("Search");
            GridDataFactory.fillDefaults().hint(130, SWT.DEFAULT).applyTo(button);

    }

}

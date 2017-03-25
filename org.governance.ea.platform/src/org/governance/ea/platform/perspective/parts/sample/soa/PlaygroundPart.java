package org.governance.ea.platform.perspective.parts.sample.soa;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

public class PlaygroundPart {
	private Text text;
    private Browser browser;

    @PostConstruct
    public void createControls(Composite parent) {
            parent.setLayout(new GridLayout(2, false));

            text = new Text(parent, SWT.BORDER);
            text.setMessage("Enter City");
            text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

            Button button = new Button(parent, SWT.PUSH);
            button.setText("Search");
            button.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                            String city = text.getText();
                            if (city.isEmpty()) {
                                    return;
                            }
                            try {
                                    // not supported at the moment by Google
                                    // browser.setUrl("http://maps.google.com/maps?q="
                                    // + URLEncoder.encode(city, "UTF-8")
                                    // + "&output=embed");
                                    browser.setUrl("https://www.google.com/maps/place/"
                                                    + URLEncoder.encode(city, "UTF-8")
                                                    + "/&output=embed");

                            } catch (UnsupportedEncodingException e1) {
                                    e1.printStackTrace();
                            }
                    }
            });

            browser = new Browser(parent, SWT.NONE);
            browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

    }

    @Focus
    public void onFocus() {
            text.setFocus();
    }
    
    public void test(){
    	
//        FormToolkit toolkit = new FormToolkit(parent.getDisplay());
//        ScrolledForm form = toolkit.createScrolledForm(parent);
//        form.setText("Eclipse Forms API Example");
//
//        // Lets make a layout for the first section of the screen
//        GridLayout layout = new GridLayout();
//        layout.numColumns = 1;
//        layout.marginWidth = 2;
//        layout.marginHeight = 2;
//        // Creating the Screen
//        Section section = toolkit.createSection(parent, Section.DESCRIPTION
//                        | Section.TITLE_BAR);
//        section.setText("Section 1 for demonstration"); //$NON-NLS-1$
//        section.setDescription("This demonstrates the usage of section");
//        // Composite for storing the data
//        Composite client = toolkit.createComposite(section, SWT.WRAP);
//        layout = new GridLayout();
//        layout.numColumns = 2;
//        layout.marginWidth = 2;
//        layout.marginHeight = 2;
//        client.setLayout(layout);
//        Table t = toolkit.createTable(client, SWT.NONE);
//        GridData gd = new GridData(GridData.FILL_BOTH);
//        gd.heightHint = 20;
//        gd.widthHint = 100;
//        t.setLayoutData(gd);
//        toolkit.paintBordersFor(client);
//        Button b = toolkit.createButton(client, "Do something", SWT.PUSH); //$NON-NLS-1$
//        gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
//        b.setLayoutData(gd);
//        section.setClient(client);
//        viewer = new TableViewer(t);
//
////           viewer.setContentProvider(ArrayContentProvider().getInstance());
//
//        TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
//        viewerColumn.getColumn().setWidth(100);
//        viewerColumn.setLabelProvider(new ColumnLabelProvider() {
//                @Override
//                public String getText(Object element) {
//                        return element.toString();
//                };
//
//                public Image getImage(Object element) {
//                        return PlatformUI.getWorkbench().getSharedImages()
//                                        .getImage(ISharedImages.IMG_OBJ_ELEMENT);
//                };
//        }
//
//        );
//        //viewer.setInput(getViewSite());

    }
}

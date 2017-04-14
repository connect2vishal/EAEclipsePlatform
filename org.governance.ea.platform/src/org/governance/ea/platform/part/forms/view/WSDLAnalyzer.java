 
package org.governance.ea.platform.part.forms.view;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;

public class WSDLAnalyzer{
	private static class ContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			return new Object[0];
		}
		public void dispose() {
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		public String getColumnText(Object element, int columnIndex) {
			Person person = (Person) element;
		    String text = "";
		    switch (columnIndex) {
		    case PersonConst.COLUMN_FIRST_NAME:
		      text = person.getFirstName();
		      break;
		    case PersonConst.COLUMN_LAST_NAME:
		      text = person.getLastName();
		      break;		   
		    }
		    return text;
		 }
	}
	
    public static final String ID = "org.governance.ea.platform.part.forms.view.wsdlanalyzer";
    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    @PostConstruct
    public void createPartControl(Composite parent) {
            FormToolkit toolkit = new FormToolkit(parent.getDisplay());
            ScrolledForm form = toolkit.createScrolledForm(parent);
            toolkit.decorateFormHeading(form.getForm());
            form.setText("WSDL Analyzer");
            form.getBody().setLayout(null);
            
            Section sctnNewSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
            sctnNewSection.setBounds(10, 4, 1076, 155);
            toolkit.paintBordersFor(sctnNewSection);
            sctnNewSection.setText("New Section");
            sctnNewSection.setExpanded(true);
            
            Composite composite = new Composite(sctnNewSection, SWT.NONE);
            toolkit.adapt(composite);
            toolkit.paintBordersFor(composite);
            sctnNewSection.setClient(composite);
            composite.setLayout(new GridLayout(20, false));
            
            Label lblFolderPath = new Label(composite, SWT.NONE);
            toolkit.adapt(lblFolderPath, true, true);
            lblFolderPath.setText("Folder Path :");
            
            Label lblNewLabel = toolkit.createLabel(composite, "Select Folder", SWT.NONE);
            GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
            gd_lblNewLabel.widthHint = 578;
            lblNewLabel.setLayoutData(gd_lblNewLabel);
            lblNewLabel.setBackground(SWTResourceManager.getColor(192, 192, 192));
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            new Label(composite, SWT.NONE);
            
            Button btnSelectFolder = toolkit.createButton(composite, "Select Folder", SWT.NONE);
            
            Section sctnWsdlActions = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
            sctnWsdlActions.setBounds(10, 164, 1071, 69);
            toolkit.paintBordersFor(sctnWsdlActions);
            sctnWsdlActions.setText("WSDL Actions");
            sctnWsdlActions.setExpanded(true);
            
            Composite wsdlActionComposite = toolkit.createComposite(sctnWsdlActions, SWT.NONE);
            toolkit.paintBordersFor(wsdlActionComposite);
            sctnWsdlActions.setClient(wsdlActionComposite);
            wsdlActionComposite.setLayout(new GridLayout(1, false));
            
            Button btnAnalyze = toolkit.createButton(wsdlActionComposite, "Analyze", SWT.NONE);
            GridData gd_btnAnalyze = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
            gd_btnAnalyze.widthHint = 147;
            btnAnalyze.setLayoutData(gd_btnAnalyze);
            
            Section sctnAnalyzisView = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
            sctnAnalyzisView.setBounds(10, 267, 1076, 512);
            toolkit.paintBordersFor(sctnAnalyzisView);
            sctnAnalyzisView.setText("Analyzis view");
            sctnAnalyzisView.setExpanded(true);
            
            Composite wsdlViewerComposite = toolkit.createComposite(sctnAnalyzisView, SWT.NONE);
            toolkit.paintBordersFor(wsdlViewerComposite);
            sctnAnalyzisView.setClient(wsdlViewerComposite);
            
            TableViewer tableViewer = new TableViewer(wsdlViewerComposite, SWT.BORDER | SWT.FULL_SELECTION);
            Table table = tableViewer.getTable();
            table.setBounds(0, 0, 620, 396);
            //table.setBounds(0,0,sctnAnalyzisView.getBounds().width,sctnAnalyzisView.getBounds().height);//0, 0, 620, 396);
            //System.out.println("Size : "+sctnAnalyzisView.getBounds());
            table.setHeaderVisible(true);
            table.setLinesVisible(true);
            toolkit.paintBordersFor(table);
            
            TableViewerColumn tvcFirstName = new TableViewerColumn(tableViewer, SWT.LEFT);
            TableColumn tcFirstName = tvcFirstName.getColumn();
            tcFirstName.setWidth(100);
            tcFirstName.setText("FirstName");
            
            TableViewerColumn tvcLastName = new TableViewerColumn(tableViewer, SWT.NONE);
            TableColumn tcLastName = tvcLastName.getColumn();
            tcLastName.setWidth(100);
            tcLastName.setText("Last Name");
            
             tableViewer.setLabelProvider(new TableLabelProvider());
             tableViewer.setContentProvider(new ArrayContentProvider());
             tableViewer.setInput(ModelProvider.INSTANCE.getPersons());
           
             // define layout for the viewer
             GridData gridData = new GridData();
             gridData.verticalAlignment = GridData.FILL;
             gridData.horizontalSpan = 2;
             gridData.grabExcessHorizontalSpace = true;
             gridData.grabExcessVerticalSpace = true;
             gridData.horizontalAlignment = GridData.FILL;
             tableViewer.getControl().setLayoutData(gridData);
             
            //createViewer(parent, tableViewer);
     }
    
    private void createViewer(Composite parent, TableViewer viewer) {
        createColumns(parent, viewer);
        final Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        viewer.setContentProvider(new ArrayContentProvider());
        // get the content for the viewer, setInput will call getElements in the
        // contentProvider
        viewer.setInput(ModelProvider.INSTANCE.getPersons());
        // make the selection available to other views
        //getSite().setSelectionProvider(tableViewer);
        // set the sorter for the table

        // define layout for the viewer
        GridData gridData = new GridData();
        gridData.verticalAlignment = GridData.FILL;
        gridData.horizontalSpan = 2;
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = true;
        gridData.horizontalAlignment = GridData.FILL;
        viewer.getControl().setLayoutData(gridData);
	}

    // create the columns for the table
    private void createColumns(final Composite parent, final TableViewer viewer) {
            String[] titles = { "First name", "Last name", "Gender"};
            int[] bounds = { 100, 100, 100, 100 };

            // first column is for the first name
            TableViewerColumn col = createTableViewerColumn(viewer, titles[0], bounds[0], 0);
            col.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                            Person p = (Person) element;
                            return p.getFirstName();
                    }
            });

            // second column is for the last name
            TableViewerColumn col1 = createTableViewerColumn(viewer, titles[1], bounds[1], 1);
            col1.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                            Person p = (Person) element;
                            return p.getLastName();
                    }
            });

            // now the gender
            TableViewerColumn col2 = createTableViewerColumn(viewer, titles[2], bounds[2], 2);
            col2.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                            Person p = (Person) element;
                            return p.getGender();
                    }
            });

    }

    private TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, int bound, final int colNumber) {
            final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
            final TableColumn column = viewerColumn.getColumn();
            column.setText(title);
            column.setWidth(bound);
            column.setResizable(true);
            column.setMoveable(true);
            return viewerColumn;
    }
    
	@Focus
	public void setFocus() {
		//tableViewer.getControl().setFocus();
		
	}
}

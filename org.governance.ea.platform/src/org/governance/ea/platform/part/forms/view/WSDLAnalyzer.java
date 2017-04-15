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
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;

public class WSDLAnalyzer{
	
    public static final String ID = "org.governance.ea.platform.part.forms.view.wsdlanalyzer";
	private TableViewer tableViewer;
	private Table table_1;
	private Table table_2;
    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    /**
     * @param parent
     */
    /**
     * @param parent
     */
    @PostConstruct
    public void createPartControl(Composite parent) {
            FormToolkit toolkit = new FormToolkit(parent.getDisplay());
            ScrolledForm form = toolkit.createScrolledForm(parent);
            toolkit.decorateFormHeading(form.getForm());
            form.setText("WSDL Analyzer");
            form.getBody().setLayout(new ColumnLayout());
            
            Section sctnNewSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
            toolkit.paintBordersFor(sctnNewSection);
            sctnNewSection.setText("New Section");
            sctnNewSection.setExpanded(true);
            sctnNewSection.setSize(1020, 70);
            
            Composite selectionComposite = new Composite(sctnNewSection, SWT.NONE);
            
            toolkit.adapt(selectionComposite);
            toolkit.paintBordersFor(selectionComposite);
            sctnNewSection.setClient(selectionComposite);
            selectionComposite.setLayout(new GridLayout(5, false));
            
            Label lblFolderPath = new Label(selectionComposite, SWT.NONE);
            toolkit.adapt(lblFolderPath, true, true);
            lblFolderPath.setText("Folder Path :");
            
            Label lblNewLabel = toolkit.createLabel(selectionComposite, "Select Folder", SWT.NONE);
            GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
            gd_lblNewLabel.widthHint = 1005;
            lblNewLabel.setLayoutData(gd_lblNewLabel);
            lblNewLabel.setBackground(SWTResourceManager.getColor(192, 192, 192));
            
            Button btnSelectFolder = toolkit.createButton(selectionComposite, "Select Folder", SWT.NONE);
            btnSelectFolder.addSelectionListener(new SelectionAdapter() {
            	@Override
            	public void widgetSelected(SelectionEvent e) {
            		addNewSetDatatoTableViewer();
            	}
            });
            new Label(selectionComposite, SWT.NONE);
            new Label(selectionComposite, SWT.NONE);
              
            Section sctnWsdlActions = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
            toolkit.paintBordersFor(sctnWsdlActions);
            sctnWsdlActions.setText("WSDL Actions");
            sctnWsdlActions.setExpanded(true);
            //sctnWsdlActions.setBounds(5, 150, 1020, 50);//Size(1020, 50);
            //TableWrapData td = new TableWrapData(TableWrapData.FILL);
            //td.colspan = 2;
            //sctnWsdlActions.setLayoutData(td);
            sctnWsdlActions.addExpansionListener(new ExpansionAdapter() {
             public void expansionStateChanged(ExpansionEvent e) {
              form.reflow(true);
             }
            });
            
            
            Composite wsdlActionComposite = toolkit.createComposite(sctnWsdlActions, SWT.NONE);
            wsdlActionComposite.setBounds(5, 150, 1020, 50);//Size(1020, 50);
            toolkit.paintBordersFor(wsdlActionComposite);
            sctnWsdlActions.setClient(wsdlActionComposite);
            wsdlActionComposite.setLayout(new GridLayout(1, false));
            wsdlActionComposite.setBounds(5, 150, 1020, 50);//Size(1020, 50);
           
            Button btnAnalyze = toolkit.createButton(wsdlActionComposite, "Analyze", SWT.NONE);
            btnAnalyze.addSelectionListener(new SelectionAdapter() {
            	@Override
            	public void widgetSelected(SelectionEvent e) {
            		addNewSetDatatoTableViewer();
            	}
            });
            GridData gd_btnAnalyze = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
            gd_btnAnalyze.widthHint = 147;
            btnAnalyze.setLayoutData(gd_btnAnalyze);
            
            /*Composite composite = new Composite(form.getBody(), SWT.NONE);
            toolkit.adapt(composite);
            toolkit.paintBordersFor(composite);
            composite.setLayout(new TableColumnLayout());
            
            TableViewer tableViewer_1 = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
            table_1 = tableViewer_1.getTable();
            table_1.setHeaderVisible(true);
            table_1.setLinesVisible(true);
            toolkit.paintBordersFor(table_1);*/
            
            Section sctnAnalyzisView = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
            toolkit.paintBordersFor(sctnAnalyzisView);
            sctnAnalyzisView.setText("Analyzis view");
            sctnAnalyzisView.setExpanded(true);
            
            Composite wsdlViewerComposite = new Composite(sctnAnalyzisView, SWT.NONE);
            toolkit.adapt(wsdlViewerComposite);
            toolkit.paintBordersFor(wsdlViewerComposite);
            sctnAnalyzisView.setClient(wsdlViewerComposite);
            TableColumnLayout tclWSDLViewerComposite = new TableColumnLayout();
            wsdlViewerComposite.setLayout(tclWSDLViewerComposite);
            
            tableViewer = new TableViewer(wsdlViewerComposite, SWT.BORDER | SWT.FULL_SELECTION);
            Table table = tableViewer.getTable();
            table.setBounds(0, 0, 620, 396);
            table.setHeaderVisible(true);
            table.setLinesVisible(true);
            toolkit.paintBordersFor(table);
             
            TableViewerColumn tvcProcessName = new TableViewerColumn(tableViewer, SWT.LEFT);
            TableColumn tcProcessName = tvcProcessName.getColumn();
            tclWSDLViewerComposite.setColumnData(tcProcessName, new ColumnPixelData(250, true, true));            
            tcProcessName.setText("Process Name");
            
            TableViewerColumn tvcWSDLName = new TableViewerColumn(tableViewer, SWT.LEFT);
            TableColumn tcWSDLName = tvcWSDLName.getColumn();
            tclWSDLViewerComposite.setColumnData(tcWSDLName, new ColumnPixelData(200, true, true));            
            tcWSDLName.setText("WSDL Name");
            
            TableViewerColumn tvcServiceName = new TableViewerColumn(tableViewer, SWT.LEFT);
            TableColumn tcServiceName = tvcServiceName.getColumn();
            tclWSDLViewerComposite.setColumnData(tcServiceName, new ColumnPixelData(200, true, true));            
            tcServiceName.setText("Service Name");
            
            TableViewerColumn tvcPortBindName = new TableViewerColumn(tableViewer, SWT.LEFT);
            TableColumn tcPortBindName = tvcPortBindName.getColumn();
            tclWSDLViewerComposite.setColumnData(tcPortBindName, new ColumnPixelData(250, true, true));            
            tcPortBindName.setText("Port Binding Name");            
            
            TableViewerColumn tvcOperationName = new TableViewerColumn(tableViewer, SWT.LEFT);
            TableColumn tcOperationName = tvcOperationName.getColumn();
            tclWSDLViewerComposite.setColumnData(tcOperationName, new ColumnPixelData(250, true, true));            
            tcOperationName.setText("Operation Name");
            
            TableViewerColumn tvcRequestName = new TableViewerColumn(tableViewer, SWT.LEFT);
            TableColumn tcRequestName = tvcRequestName.getColumn();
            tclWSDLViewerComposite.setColumnData(tcRequestName, new ColumnPixelData(300, true, true));            
            tcRequestName.setText("Request Name");
            
            TableViewerColumn tvcResponseName = new TableViewerColumn(tableViewer, SWT.LEFT);
            TableColumn tcResponseName = tvcResponseName.getColumn();
            tclWSDLViewerComposite.setColumnData(tcResponseName, new ColumnPixelData(300, true, true));            
            tcResponseName.setText("Response Name");
            
             tableViewer.setLabelProvider(new WSDLServiceLabelProvider());
             tableViewer.setContentProvider(new ArrayContentProvider());
             tableViewer.setInput(WSDLServiceModelProvider.INSTANCE.getWsdlServiceModel());
           
             // define layout for the viewer
             GridData gridData = new GridData();
             gridData.verticalAlignment = GridData.FILL;
             gridData.horizontalSpan = 2;
             gridData.grabExcessHorizontalSpace = true;
             gridData.grabExcessVerticalSpace = true;
             gridData.horizontalAlignment = GridData.FILL;
             //tableViewer.getControl().setLayoutData(gridData);
             
            //createViewer(parent, tableViewer);
     }
    
    protected void addNewSetDatatoTableViewer() {
		// TODO Auto-generated method stub
        tableViewer.setInput(WSDLServiceModelProvider.INSTANCE.getDatafromFiles());
        		//ModelProvider.INSTANCE.getNewPersons());
		
	}

    
	@Focus
	public void setFocus() {
		//tableViewer.getControl().setFocus();
		
	}
}
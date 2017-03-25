 
package org.governance.ea.platform.part.forms.view;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
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
    public static final String ID = "org.governance.ea.platform.part.forms.wsdlanalyzer";

    private TableViewer viewer;
    // static fields to hold the images
    private static final ImageDescriptor CHECKED = null;//getImageDescriptor("checked.gif");
    private static final ImageDescriptor UNCHECKED = null;//getImageDescriptor("unchecked.gif");
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
            form.getBody().setLayout(new GridLayout(2, false));
            
            Label lblFolderPath = new Label(form.getBody(), SWT.NONE);
            toolkit.adapt(lblFolderPath, true, true);
            lblFolderPath.setText("Folder Path :");
            new Label(form.getBody(), SWT.NONE);
            
            Label lblNewLabel = toolkit.createLabel(form.getBody(), "Select Folder", SWT.NONE);
            lblNewLabel.setBackground(SWTResourceManager.getColor(192, 192, 192));
            GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
            gd_lblNewLabel.widthHint = 978;
            lblNewLabel.setLayoutData(gd_lblNewLabel);
            
            Button btnSelectFolder = toolkit.createButton(form.getBody(), "Select Folder", SWT.NONE);
            new Label(form.getBody(), SWT.NONE);
            new Label(form.getBody(), SWT.NONE);
            
            Section sctnWsdlActions = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
            GridData gd_sctnWsdlActions = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
            gd_sctnWsdlActions.widthHint = 1056;
            sctnWsdlActions.setLayoutData(gd_sctnWsdlActions);
            toolkit.paintBordersFor(sctnWsdlActions);
            sctnWsdlActions.setText("WSDL Actions");
            sctnWsdlActions.setExpanded(true);
            
            Composite composite = toolkit.createComposite(sctnWsdlActions, SWT.NONE);
            toolkit.paintBordersFor(composite);
            sctnWsdlActions.setClient(composite);
            
            Button btnAnalyze = toolkit.createButton(composite, "Analyze", SWT.NONE);
            btnAnalyze.setBounds(0, 10, 90, 30);
            
            Section sctnAnalyzisView = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
            GridData gd_sctnAnalyzisView = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
            gd_sctnAnalyzisView.widthHint = 183;
            sctnAnalyzisView.setLayoutData(gd_sctnAnalyzisView);
            toolkit.paintBordersFor(sctnAnalyzisView);
            sctnAnalyzisView.setText("Analyzis view");
            sctnAnalyzisView.setExpanded(true);
            
            Composite composite_1 = toolkit.createComposite(sctnAnalyzisView, SWT.NONE);
            toolkit.paintBordersFor(composite_1);
            sctnAnalyzisView.setClient(composite_1);
            
            table = toolkit.createTable(composite_1, SWT.NONE);
            table.setBounds(10, 10, 85, 47);
            toolkit.paintBordersFor(table);
            table.setHeaderVisible(true);
            table.setLinesVisible(true);


    }


    private void createViewer(Composite parent) {
            viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
            createColumns(parent, viewer);
            final Table table = viewer.getTable();
            table.setHeaderVisible(true);
            table.setLinesVisible(true);

            viewer.setContentProvider(new ArrayContentProvider());
            // get the content for the viewer, setInput will call getElements in the
            // contentProvider
            viewer.setInput(ModelProvider.INSTANCE.getPersons());
            // make the selection available to other views
            getSite().setSelectionProvider(viewer);
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

    public TableViewer getViewer() {
            return viewer;
    }

    // create the columns for the table
    private void createColumns(final Composite parent, final TableViewer viewer) {
            String[] titles = { "First name", "Last name", "Gender", "Married" };
            int[] bounds = { 100, 100, 100, 100 };

            // first column is for the first name
            TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
            col.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                            Person p = (Person) element;
                            return p.getFirstName();
                    }
            });

            // second column is for the last name
            col = createTableViewerColumn(titles[1], bounds[1], 1);
            col.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                            Person p = (Person) element;
                            return p.getLastName();
                    }
            });

            // now the gender
            col = createTableViewerColumn(titles[2], bounds[2], 2);
            col.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                            Person p = (Person) element;
                            return p.getGender();
                    }
            });

            // now the status married
            col = createTableViewerColumn(titles[3], bounds[3], 3);
            col.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                            return null;
                    }

                    @Override
                    public Image getImage(Object element) {
                            if (((Person) element).isMarried()) {
                                    return CHECKED;
                            } else {
                                    return UNCHECKED;
                            }
                    }
            });

    }

    private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
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
		// TODO Auto-generated method stub
		
	}
	
	// nat table
    
    // property names of the Person class
//       String[] propertyNames = {"firstName", "lastName", "gender", "married", "birthday"};
//
//       // create the data provider
//       IColumnPropertyAccessor<Person> columnPropertyAccessor = new ReflectiveColumnPropertyAccessor<Person>(propertyNames);
//       PersonService personService = new PersonService();
//		IDataProvider bodyDataProvider = new ListDataProvider<Person>(personService.getPersons(10), columnPropertyAccessor);
//
//       final DataLayer bodyDataLayer = new DataLayer(bodyDataProvider);
//
//       // use different style bits to avoid rendering of inactive scrollbars for small table
//       // Note: The enabling/disabling and showing of the scrollbars is handled by the ViewportLayer.
//       //                Without the ViewportLayer the scrollbars will always be visible with the default
//       //                style bits of NatTable.
//       final NatTable natTable = new NatTable(
//                       parent,
//                       SWT.NO_REDRAW_RESIZE | SWT.DOUBLE_BUFFERED | SWT.BORDER,
//                       bodyDataLayer);

      // GridDataFactory.fillDefaults().grab(true, true).applyTo(natTable);
}
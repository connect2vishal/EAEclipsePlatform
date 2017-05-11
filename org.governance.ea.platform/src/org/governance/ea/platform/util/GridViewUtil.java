/**
 * 
 */
package org.governance.ea.platform.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.apache.commons.io.FileUtils;
import org.governance.ea.platform.part.forms.view.WSDLServiceModel;

import com.predic8.schema.Appinfo;
import com.predic8.schema.Attribute;
import com.predic8.schema.ComplexContent;
import com.predic8.schema.ComplexType;
import com.predic8.schema.Derivation;
import com.predic8.schema.Documentation;
import com.predic8.schema.Element;
import com.predic8.schema.Import;
import com.predic8.schema.Include;
import com.predic8.schema.ModelGroup;
import com.predic8.schema.Schema;
import com.predic8.schema.SchemaComponent;
import com.predic8.schema.SimpleType;
import com.predic8.wsdl.AbstractSOAPBinding;
import com.predic8.wsdl.Binding;
import com.predic8.wsdl.BindingOperation;
import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.Fault;
import com.predic8.wsdl.Message;
import com.predic8.wsdl.Operation;
import com.predic8.wsdl.Part;
import com.predic8.wsdl.Port;
import com.predic8.wsdl.PortType;
import com.predic8.wsdl.Service;
import com.predic8.wsdl.WSDLParser;

/**
 * @author Chika
 *
 */
public class GridViewUtil {

	private static void printWSDLSchema(Schema schema){

		out("=============================================== I am back again==========================");
		
		out("-------------- Schema Information --------------");
        out("  Schema TargetNamespace: " + schema.getTargetNamespace());
        out("  AttributeFormDefault: " + schema.getAttributeFormDefault());
        out("  ElementFormDefault: " + schema.getElementFormDefault());
        out("");
 
        if (schema.getImports().size() > 0) {
            out("  Schema Imports: ");
            for (Import imp : schema.getImports()) {
                out("    Import Namespace: " + imp.getNamespace());
                out("    Import Location: " + imp.getSchemaLocation());
            }
            out("");
        }
 
        if (schema.getIncludes().size() > 0) {
            out("  Schema Includes: ");
            for (Include inc : schema.getIncludes()) {
                out("    Include Location: " + inc.getSchemaLocation());
            }
            out("");
        }
 
        out("  Schema Elements: ");
        for (Element e : schema.getAllElements()) {
            //out("    Element Name: " + e.getName());
            if (e.getType() != null) {
                /*
                 * schema.getType() delivers a TypeDefinition (SimpleType orComplexType)
                 * object.
                 */
//                out("    Element Type Name: " + schema.getType(e.getType()).getName());
//                out("    Element minoccurs: " + e.getMinOccurs());
//                out("    Element maxoccurs: " + e.getMaxOccurs());
            	out("      "+ e.getClass().getSimpleName() +"< "+e.getType().getLocalPart() +" : "+ e.getName() +" >");
            	
            	//print complex Type
                /*for (ComplexType ct : schema.getComplexTypes()) {
                	if(ct.getName().equals(schema.getType(e.getType()).getName())){
                        if (ct.getModel() instanceof ModelGroup) {
                            for (SchemaComponent sc : ((ModelGroup) ct.getModel()).getParticles()) {
                            	out("      "+sc.getClass().getSimpleName() +"[ "+ e.getType().getLocalPart() +" ] < " + e.getType().getLocalPart() +" : "+sc.getName() +" >");
                            	//schema.getType(e.getType()).getName()
                            }
                        }
                		
                	}
                }*/
            	if (e.getAnnotation() != null)
                    annotationOut(e);
            }
        }
        
        
       out("");
       StringBuilder elementTraverse = new StringBuilder(); 
       out(" Schema traversing ");

       for (Element e1 : schema.getAllElements()) { 
        	if (e1.getType() != null) {
        		elementTraverse = new StringBuilder();
        		elementTraverse.append(e1.getName());
        		//elementTraverse.append(printComplexTypeAsString(elementTraverse, schema, e));
        	}
       }
        
       out("Elements >> " + elementTraverse.toString()); 
       
        out("");
        
        out("  Schema ComplexTypes: ");
        for (ComplexType ct : schema.getComplexTypes()) {
            out("    ComplexType Name: " + ct.getName());
            if (ct.getAnnotation() != null)
                annotationOut(ct);
            if (ct.getAttributes().size() > 0) {
                out("    ComplexType Attributes: ");
                /*
                 * If available, attributeGroup could be read as same as attribute in
                 * the following.
                 */
                for (Attribute attr : ct.getAttributes()) {
                    out("      Attribute Name: " + attr.getName());
                    out("      Attribute Form: " + attr.getForm());
                    out("      Attribute ID: " + attr.getId());
                    out("      Attribute Use: " + attr.getUse());
                    out("      Attribute FixedValue: " + attr.getFixedValue());
                    out("      Attribute DefaultValue: " + attr.getDefaultValue());
                }
            }
            /*
             * ct.getModel() delivers the child element used in complexType. In case
             * of 'sequence' you can also use the getSequence() method.
             */
            out("    ComplexType Model: " + ct.getModel().getClass().getSimpleName());
            if (ct.getModel() instanceof ModelGroup) {
                out("    Model Particles: ");
                for (SchemaComponent sc : ((ModelGroup) ct.getModel()).getParticles()) {
//                    out("      Particle Kind: " + sc.getClass().getSimpleName());
//                    out("      Particle Name: " + sc.getName() + "\n");
//                    out("      Particle Type: " + ((Element)sc).getType().getLocalPart() + "\n");
                	out("      "+sc.getClass().getSimpleName() +"< " + ((Element)sc).getType().getLocalPart() +" : "+sc.getName() +" >");
                }
            }
 
            if (ct.getModel() instanceof ComplexContent) {
                Derivation der = ((ComplexContent) ct.getModel()).getDerivation();
                out("      ComplexConten Derivation: " + der.getClass().getSimpleName());
                out("      Derivation Base: " + der.getBase());
            }
 
            if (ct.getAbstractAttr() != null)
                out("    ComplexType AbstractAttribute: " + ct.getAbstractAttr());
            if (ct.getAnyAttribute() != null)
                out("    ComplexType AnyAttribute: " + ct.getAnyAttribute());
 
            out("");
        }
 
        if (schema.getSimpleTypes().size() > 0) {
            out("  Schema SimpleTypes: ");
            for (SimpleType st : schema.getSimpleTypes()) {
                out("    SimpleType Name: " + st.getName());
                out("    SimpleType Restriction: " + st.getRestriction());
                out("    SimpleType Union: " + st.getUnion());
                out("    SimpleType List: " + st.getList());
            }
        }
    }
 
    private static StringBuilder printComplexTypeAsString(StringBuilder elementTraverse, Schema schema, Element e) {
    	//print complex Type
        for (ComplexType ct : schema.getComplexTypes()) {
        	if(ct.getName().equals(schema.getType(e.getType()).getName())){
                if (ct.getModel() instanceof ModelGroup) {
                    for (SchemaComponent sc : ((ModelGroup) ct.getModel()).getParticles()) {
                    	//if(sc.getComplexTypes())
                    	elementTraverse.append(" >> "+e.getType().getLocalPart());
                    	//out("      "+sc.getClass().getSimpleName() +"[ "+ e.getType().getLocalPart() +" ] < " + e.getType().getLocalPart() +" : "+sc.getName() +" >");
                    	//schema.getType(e.getType()).getName()
                    }
                }
        		
        	}
        }
		return elementTraverse.append(printComplexTypeAsString(elementTraverse, schema, e));
	}

	private static void annotationOut(SchemaComponent sc) {
        if (sc.getAnnotation().getAppinfos().size() > 0) {
            System.out
                .print("    Annotation (appinfos) available with the content: ");
            for (Appinfo appinfo : sc.getAnnotation().getAppinfos()) {
                out(appinfo.getContent());
            }
        } else {
            System.out
                .print("    Annotation (documentation) available with the content: ");
            for (Documentation doc : sc.getAnnotation().getDocumentations()) {
                out(doc.getContent());
            }
        }
    }	
	
	private static void printWSDL(Definitions tempDefs){
		
		Definitions defs = tempDefs;
	 
	    out("-------------- WSDL Details --------------");
	    out("TargenNamespace: \t" + defs.getTargetNamespace());
	    //out("Style: \t\t\t" + defs.getStyle());
	    if (defs.getDocumentation() != null) {
	        out("Documentation: \t\t" + defs.getDocumentation());
	    }
	    out("\n");
	
	    /* For detailed schema information see the FullSchemaParser.java sample.*/
	    out("Schemas: ");
	    for (Schema schema : defs.getSchemas()) {
	        out("  TargetNamespace: \t" + schema.getTargetNamespace());
	    }
	    out("\n");
	     
	    out("Messages: ");
	    for (Message msg : defs.getMessages()) {
	        out("  Message Name: " + msg.getName());
	        out("  Message Parts: ");
	        for (Part part : msg.getParts()) {
	            out("    Part Name: " + part.getName());
	            out("    Part Element: " + ((part.getElement() != null) ? part.getElement() : "not available!"));
	            out("    Part Type: " + ((part.getType() != null) ? part.getType() : "not available!" ));
	            out("");
	        }
	    }
	    out("");
	
	    out("PortTypes: ");
	    for (PortType pt : defs.getPortTypes()) {
	        out("  PortType Name: " + pt.getName());
	        out("  PortType Operations: ");
	        for (Operation op : pt.getOperations()) {
	            out("    Operation Name: " + op.getName());
	            out("    Operation Input Name: "
	                + ((op.getInput().getName() != null) ? op.getInput().getName() : "not available!"));
	            out("    Operation Input Message: "
	                + op.getInput().getMessage().getQname());
	            out("    Operation Output Name: "
	                + ((op.getOutput().getName() != null) ? op.getOutput().getName() : "not available!"));
	            out("    Operation Output Message: "
	                + op.getOutput().getMessage().getQname());
	            out("    Operation Faults: ");
	            if (op.getFaults().size() > 0) {
	                for (Fault fault : op.getFaults()) {
	                    out("      Fault Name: " + fault.getName());
	                    out("      Fault Message: " + fault.getMessage().getQname());
	                }
	            } else out("      There are no faults available!");
	             
	        }
	        out("");
	    }
	    out("");
	
	    out("Bindings: ");
	    for (Binding bnd : defs.getBindings()) {
	        out("  Binding Name: " + bnd.getName());
	        out("  Binding Type: " + bnd.getPortType().getName());
	        out("  Binding Protocol: " + bnd.getBinding().getProtocol());
	        if(bnd.getBinding() instanceof AbstractSOAPBinding) out("  Style: " + (((AbstractSOAPBinding)bnd.getBinding()).getStyle()));
	        out("  Binding Operations: ");
	        for (BindingOperation bop : bnd.getOperations()) {
	            out("    Operation Name: " + bop.getName());
	            if(bnd.getBinding() instanceof AbstractSOAPBinding) {
	                out("    Operation SoapAction: " + bop.getOperation().getSoapAction());
	                out("    SOAP Body Use: " + bop.getInput().getBindingElements().get(0).getUse());
	            }
	        }
	        out("");
	    }
	    out("");
	
	    out("Services: ");
	    for (Service service : defs.getServices()) {
	        out("  Service Name: " + service.getName());
	        out("  Service Potrs: ");
	        for (Port port : service.getPorts()) {
	            out("    Port Name: " + port.getName());
	            out("    Port Binding: " + port.getBinding().getName());
	            out("    Port Address Location: " + port.getAddress().getLocation()
	                + "\n");
	        }
	    }
	    out("");
	}
	
	private static void out(String str) {
	    System.out.println(str);
	}

	/**
	 * @return
	 */
	public static List<File> getWSDLFiles() {

		File wsdlDirectory = new File("C:\\Users\\Chika\\workspace\\SwingDev\\iEATool\\resources\\wsdl");
		String[] extensions = new String[] { "wsdl" };

		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".wsdl");
			}
		};

		out(">>>>>> ===== Printing the File >>>>>>>>>>>> =========");
		List<File> files = (List<File>) FileUtils.listFiles(wsdlDirectory, extensions, true);// ,
																								// TrueFileFilter.INSTANCE);

		//File[] files = f.listFiles(textFilter);
		
		return files;
	}

	public static List<WSDLServiceModel> getViewerModel(List<WSDLServiceModel> reqWSDLServiceModelList) {
	
		System.out.println("File Parsing Started.....");
		WSDLParser parser = new WSDLParser();
		Definitions defs = null;// parser.parse("C:\\Users\\Chika\\workspace\\SwingDev\\iEATool\\resources\\wsdl\\BLZService.wsdl");

		for (File file : getWSDLFiles()) {
			try {
				System.out.println("Starting File : " + file.getCanonicalPath());
				defs = parser.parse(file.getCanonicalPath().toString());//new FileInputStream(file));
			} catch (IOException e) {
				System.out.println("File cannot be found n parsed....");
				System.out.println("Message : " + e.getLocalizedMessage());
			}
			
			String name = file.getName(); 
			String folderName = "";
			
			try {
				 folderName = file.getParentFile().getName();
			} catch (Exception e) {
				folderName = "--N/A--";
			} 
			//printWSDL(defs);
			reqWSDLServiceModelList.addAll(getWSDLServiceModel(name, folderName, defs));
			//if(name.equals("BLZService.wsdl"))	break;
		}

		System.out.println("File Parse Finished.....");

		return reqWSDLServiceModelList;
	}

	private static List<WSDLServiceModel> getWSDLServiceModel(String name, String folderName,
			Definitions defs) {
		
		// create List of model name		
		List <WSDLServiceModel> wsdlServiceModelList = new ArrayList<WSDLServiceModel>();
		
		// add service name
//		StringBuilder serviceListString = new StringBuilder("S: ");
//		StringBuilder portListString = new StringBuilder("Port :");
//		StringBuilder bindingOperationListString = new StringBuilder(" Ops : ");
//		StringBuilder opsInputListString = new StringBuilder("Input : ");
//		StringBuilder opsOutputListString = new StringBuilder("Output : ");

		
		for (Service serv : defs.getServices()) {
			//serviceListString.append(serv.getName() + "\n");

			// add ports
			for (Port port : serv.getPorts()) {
				try {
					//portListString.append(port.getName() + "\n ");
					// + "\n - PBinding" + port.getBinding().getName() + "\n");

					// add operations
					for (Operation ops : port.getBinding().getPortType().getOperations()) {
						
						// BindingOperation bdngOps : port.getBinding().getOperations()) {
						//bindingOperationListString.append(ops.getName() + "\n");

						WSDLServiceModel wsdlServiceModel = new WSDLServiceModel();
						// add process name		
						wsdlServiceModel.setProcessName(folderName);
						
						// add wsdl name
						wsdlServiceModel.setWsdlName(name);						
						wsdlServiceModel.setServiceName(serv.getName());
						wsdlServiceModel.setPortBinding(port.getName());
						wsdlServiceModel.setOperationName(ops.getName());
						//wsdlServiceModel.setRequestName(ops.getInput().getMessage().getName());//.getParts().get(0).getElement().getName());//.getName());//getName());
						
						wsdlServiceModel.setRequestName(ops.getInput().getMessage().getParts().get(0).getElement().getName());
						wsdlServiceModel.setResponseName(ops.getOutput().getMessage().getName());
						
						wsdlServiceModelList.add(wsdlServiceModel);
					}
				} catch (Exception ex) {
					//portListString.append("N/A");
					//bindingOperationListString.append("N/A" + "\n");
				}
			}
		}

	    for (Schema schema : defs.getSchemas()) {
	    	
	    	printWSDLSchema(schema);

//	        for (Element e : schema.getAllElements()) {
//	            if (e.getType() != null) {
//	            	out("      "+ e.getClass().getSimpleName() +"< "+e.getType().getLocalPart() +" : "+ e.getName() +" >");
//	            }
//	        }
//	        System.out.println("  TargetNamespace: \t" + schema.getTargetNamespace());
//	        for (Element element : schema.getAllElements()){
//	        	System.out.println("   Element: \t" + element.getName() );
//	        	try{		
//	        		System.out.println(" - ComplexType - " + ((element.getType().getLocalPart() != null)? element.getType().getLocalPart() : " N/A "));
//	        		
//	        		
//	        	}catch(Exception ex){
//	        		
//	        	}
//	        }
	        
//	        for (ComplexType complexType : schema.getComplexTypes()){
//	        	System.out.println("   -- Complex Type: \t" + complexType.getName());
//	        }
	    }

		return wsdlServiceModelList;
	}

	/**
	 * @param tableModel
	 * @return
	 */
	public static DefaultTableModel getTabelModel(DefaultTableModel tableModel) {

		System.out.println("File Parsing Started.....");
		WSDLParser parser = new WSDLParser();
		Definitions defs = null;// parser.parse("C:\\Users\\Chika\\workspace\\SwingDev\\iEATool\\resources\\wsdl\\BLZService.wsdl");
		Vector ServiceDetailList = new Vector();
		for (File file : getWSDLFiles()) {
			try {
				System.out.println("Starting File : " + file.getCanonicalPath());
				defs = parser.parse(file.getCanonicalPath().toString());// new
																		// FileInputStream(file));
			} catch (IOException e) {
				System.out.println("File cannot be found n parsed....");
				System.out.println("Message : " + e.getLocalizedMessage());
			}

			String name = file.getName();
			String folderName = "";
			try {
				folderName = file.getParentFile().getName();
			} catch (Exception e) {
				folderName = "--N/A--";
			}
			tableModel.addRow(convertDefinitiontoTableModel(name, folderName, tableModel, defs));

			// break;
		}

		System.out.println("File Parse Finished.....");

		return tableModel;
	}

	public static Vector<String> convertDefinitiontoTableModel(String name, String folderName,
			DefaultTableModel currentTableModel, Definitions def) {// initionList){

		// currentTableModel = new DefaultTableModel();

		Vector<String> serviceDetail;
		// 2 prepare table model
		// for(Definitions def : definitionList){

		serviceDetail = new Vector<String>();
		serviceDetail.add("<Group>");
		serviceDetail.add(folderName);

		// add wsdl name
		serviceDetail.add(name + ".WSDL");

		// add service name
		StringBuilder serviceListString = new StringBuilder("S: ");
		StringBuilder portListString = new StringBuilder("Port :");
		StringBuilder bindingOperationListString = new StringBuilder(" Ops : ");
		StringBuilder opsInputListString = new StringBuilder("Input : ");
		StringBuilder opsOutputListString = new StringBuilder("Output : ");

		for (Service serv : def.getServices()) {
			serviceListString.append(serv.getName() + "\n");

			// add ports
			for (Port port : serv.getPorts()) {
				try {
					portListString.append(port.getName() + "\n ");// + "\n -
																	// PBinding"
																	// +
																	// port.getBinding().getName()
																	// + "\n");

					// add operations
					for (Operation ops : port.getBinding().getPortType().getOperations()) {// BindingOperation
																							// bdngOps
																							// :
																							// port.getBinding().getOperations())
																							// {
						bindingOperationListString.append(ops.getName() + "\n");

						// add Input
						// opsInputListString.append(ops.getInput().getName()+"\n");
						// for(Part parts :
						// ops.getInput().getMessage().getParts()){
						// parts.getElement().
						// }

						// add Output
						// opsOutputListString.append(bdngOps.getOutput().getName()+"\n");
					}
				} catch (Exception ex) {
					portListString.append("N/A");
					bindingOperationListString.append("N/A" + "\n");
				}

				// Find Binding Port type and get its operation & its input
				// output

				// PortType portType =
				// port.getBinding().getPortType().getOperations();

			}
		}

		serviceDetail.add(serviceListString.toString());
		serviceDetail.add(portListString.toString());
		serviceDetail.add(bindingOperationListString.toString());
		serviceDetail.add(opsInputListString.toString());
		serviceDetail.add(opsOutputListString.toString());

		// add operations
		/*
		 * for (PortType pt : defs.getPortTypes()) {
		 * System.out.println(pt.getName()); for (Operation op :
		 * pt.getOperations()) { System.out.println(" -" + op.getName()); } }
		 */
		// serviceDetail.add(def.getP);

		// add attribute elements
		// serviceDetail.add("");

		// add elements constraints
		// serviceDetail.add("");

		// 3 Add Row to tabelModel
		// currentTableModel.setColum
		// System.out.println("check params......");
		// System.out.println("serviceDetail - "+serviceDetail.toString());
		// currentTableModel.addRow(serviceDetail);
		// ServiceDetailList.add(serviceDetail);
		// currentTableModel = new
		// DefaultTableModel(ServiceDetailList,getDefaultColumn());

		// }
		return serviceDetail;// currentTableModel;
	}

	public static DefaultTableModel convertWSDLtoTableModel(Definitions definitions) {
		return null;

	}

	private static Vector getDefaultColumn() {
		// Vector columnRow = new Vector();
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Service Group");
		columnNames.add("Service Engine");
		columnNames.add("WSDL File");
		columnNames.add("Service Name");
		columnNames.add("port");
		columnNames.add("Binding Operation");
		columnNames.add("Operation Input");
		columnNames.add("Operation Output");

		// columnRow.add(columnNames);
		// {"Service Group", "Service Engine", "WSDL File", "Service
		// Name","Service Operation", "Operation Field", "Field Constrains"};

		return columnNames;
	}

}

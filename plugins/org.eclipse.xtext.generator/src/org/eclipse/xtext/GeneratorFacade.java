/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.XtextgenFactory;
import org.eclipse.xtext.xtextgen.XtextgenPackage;
import org.eclipse.xtext.xtextutil.XtextutilPackage;
import org.openarchitectureware.expression.Variable;
import org.openarchitectureware.xpand2.XpandExecutionContextImpl;
import org.openarchitectureware.xpand2.XpandFacade;
import org.openarchitectureware.xpand2.output.Outlet;
import org.openarchitectureware.xpand2.output.OutputImpl;
/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GeneratorFacade {
	private static Log log = LogFactory.getLog(GeneratorFacade.class);

	public static void generate(Grammar grammarModel, String srcGenPath,
			String uiProjectPath, String... modelFileExtensions) throws IOException {
	    GenModel genModel = assembleGeneratorModel(grammarModel, srcGenPath, uiProjectPath, modelFileExtensions);
	    generate(genModel);
	}
	
	
	private static void generate(GenModel genModel) throws IOException {
	    
	    EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XtextPackage.eNS_URI, XtextPackage.eINSTANCE);
		
		// configure outlets
		OutputImpl output = new OutputImpl();
		EMap<String, String> outletMap = genModel.getOutletMap();
        for(String key : outletMap.keySet()) {
		    Outlet outlet = new Outlet(outletMap.get(key));
		    if(!key.equals("")) {
		        outlet.setName(key);
		    }
		    output.addOutlet(outlet);
		}

        // create execution context
        Map<String, Variable> globalVarsMap = new HashMap<String, Variable>();
        Variable genModelVariable = new Variable("genModel", genModel);
        globalVarsMap.put("genModel", genModelVariable);
		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null, globalVarsMap, null, null);
		EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[] { XtextPackage.eINSTANCE, XtextutilPackage.eINSTANCE, XtextgenPackage.eINSTANCE, EcorePackage.eINSTANCE };
			}
		};
		execCtx.registerMetaModel(metamodel);
		
		// save grammar model
		XtextResourceSet setImpl = new XtextResourceSet();
		String xmiPath = GrammarUtil.getClasspathRelativePathToXmi(genModel.getGrammar());
		Resource resource = setImpl.createResource(URI.createURI(outletMap.get("") + "/"+ xmiPath));
		resource.getContents().add(genModel.getGrammar());
		resource.save(null);

		// generate services
		XpandFacade facade = XpandFacade.create(execCtx);
		EList<GenService> services = genModel.getServices();
		for (GenService service : services) {
            String templatePath = service.getTemplatePath();
            if(templatePath != null) {
                facade.evaluate(templatePath, service);
            }
        }
		
		facade.evaluate("org::eclipse::xtext::ILanguage::root", genModel);
		facade.evaluate("org::eclipse::xtext::StandaloneSetup::root", genModel);
        
        if (genModel.getUiPluginBundleID() != null) {
            facade.evaluate("org::eclipse::xtext::ui::UIPlugin::root", genModel);
            // TODO outline service, copy images
        }
	}
	
	private static GenModel assembleGeneratorModel(Grammar grammarModel, String srcGenPath, String uiProjectPath, String... modelFileExtensions) {
        String languageName = GrammarUtil.getName(grammarModel);
        String namespace = GrammarUtil.getNamespace(grammarModel);
        String uiPluginID = uiProjectPath.substring(uiProjectPath.lastIndexOf('/')+1);

        GenModel genModel = XtextgenFactory.eINSTANCE.createGenModel();
	    genModel.setGrammar(grammarModel);
	    genModel.getModelFileExtensions().addAll(Arrays.asList(modelFileExtensions));
	    genModel.setFileHeader("Generated with Xtext");
	    genModel.setLanguageInterfaceFQName(namespace + ".I" + languageName);
	    genModel.setStandaloneSetupClassFQName(namespace + "." + languageName + "StandaloneSetup");
	    if(uiProjectPath != null) {
	        genModel.setNonUIPluginBundleID(namespace);
	        genModel.setUiPluginBundleID(uiPluginID);
	    }
        
	    genModel.getOutletMap().put("", srcGenPath);
	    genModel.getOutletMap().put("UI", uiProjectPath);
	    genModel.getOutletMap().put("UI_SRC_GEN", uiProjectPath + "/src-gen");
	    genModel.getOutletMap().put("UI_MANIFEST", uiProjectPath + "/META-INF");

	    GenService grammarAccessService = XtextgenFactory.eINSTANCE.createGenService();
	    grammarAccessService.setServiceInterfaceFQName("org.eclipse.xtext.IGrammarAccess");
	    grammarAccessService.setGenClassFQName(namespace + ".services." + languageName + "GrammarAccess");
	    grammarAccessService.setTemplatePath("org::eclipse::xtext::grammaraccess::GrammarAccess::root");
	    grammarAccessService.setExtensionPointID("org.eclipse.xtext.ui.grammarAccess");
	    genModel.getServices().add(grammarAccessService);
	    
	    GenService metamodelAccessService = XtextgenFactory.eINSTANCE.createGenService();
	    metamodelAccessService.setServiceInterfaceFQName("org.eclipse.xtext.IMetamodelAccess");
	    metamodelAccessService.setGenClassFQName(namespace + ".services." + languageName + "MetamodelAccess");
	    metamodelAccessService.setTemplatePath("org::eclipse::xtext::metamodelaccess::MetamodelAccess::root");
	    metamodelAccessService.setExtensionPointID("org.eclipse.xtext.ui.metamodelAccess");
	    genModel.getServices().add(metamodelAccessService);
	    

	    if (!GrammarUtil.isAbstract(grammarModel)) {

            GenService elementFactoryService = XtextgenFactory.eINSTANCE.createGenService();
            elementFactoryService.setServiceInterfaceFQName("org.eclipse.xtext.parser.IAstFactory");
            elementFactoryService.setGenClassFQName("org.eclipse.xtext.parser.GenericEcoreElementFactory");
            // no template, as service is generic. Nevertheless, we need the individual registration to avoid conflicts
            elementFactoryService.setExtensionPointID("org.eclipse.xtext.ui.aSTFactory");
            genModel.getServices().add(elementFactoryService);
            
            GenService parserService = XtextgenFactory.eINSTANCE.createGenService();
            parserService.setServiceInterfaceFQName("org.eclipse.xtext.parser.IParser");
            parserService.setGenClassFQName(namespace + ".parser." + languageName + "Parser");
            parserService.setTemplatePath("org::eclipse::xtext::parser::Parser::root");
            parserService.setExtensionPointID("org.eclipse.xtext.ui.parser");
            genModel.getServices().add(parserService);

            GenService resourceFactoryService = XtextgenFactory.eINSTANCE.createGenService();
            resourceFactoryService.setServiceInterfaceFQName("org.eclipse.xtext.resource.IResourceFactory");
            resourceFactoryService.setGenClassFQName(namespace + ".services." + languageName + "ResourceFactory");
            resourceFactoryService.setTemplatePath("org::eclipse::xtext::resourcefactory::ResourceFactory::root");
            resourceFactoryService.setExtensionPointID("org.eclipse.xtext.ui.resourceFactory");
            genModel.getServices().add(resourceFactoryService);

            GenService parsetreeConstructorService = XtextgenFactory.eINSTANCE.createGenService();
            parsetreeConstructorService.setServiceInterfaceFQName("org.eclipse.xtext.parsetree.IParseTreeConstructor");
            parsetreeConstructorService.setGenClassFQName(namespace + ".parsetree." + languageName + "ParseTreeConstructor");
            parsetreeConstructorService.setTemplatePath("org::eclipse::xtext::parsetree::ParseTreeConstructor::root");
            parsetreeConstructorService.setExtensionPointID("org.eclipse.xtext.ui.parseTreeConstructor");
            genModel.getServices().add(parsetreeConstructorService);
        }
	    
        return genModel;
    }
	
	public static void cleanFolder(String srcGenPath) throws FileNotFoundException {
		File f = new File(srcGenPath);
		if (!f.exists()) {
			throw new FileNotFoundException(srcGenPath);
		}
		log.info("Cleaning folder " + srcGenPath);
		final File[] contents = f.listFiles();
		for (int j = 0; j < contents.length; j++) {
			final File file = contents[j];
			if (file.isDirectory()) {
			    cleanFolder(file.getAbsolutePath());
			}
			else {
    			if (!isCVSFile(file)) {
    				if (!file.delete()) {
    					log.error("Couldn't delete " + file.getAbsolutePath());
    				}
    			}
			}
		}
	}
	
	private static boolean isCVSFile(File file) {
        if (".cvsignore".equals(file.getName())) return true;
        if ("CVS".equals(file.getName())) return true;
        if ("Entries".equals(file.getName())) return true;
        if ("Repository".equals(file.getName())) return true;
        if ("Root".equals(file.getName())) return true;
	    return false;
	}

}

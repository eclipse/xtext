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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtextgen.GenClass;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.GenPlugin;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.RootTemplate;
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
	
	
	@SuppressWarnings("unchecked")
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
		ResourceSetImpl setImpl = new ResourceSetImpl();
		Resource resource = setImpl.createResource(URI.createURI(genModel.getGrammarResourceURI()));
		resource.getContents().add(genModel.getGrammar());
		resource.save(null);

		// generate services
		XpandFacade facade = XpandFacade.create(execCtx);
		EList<RootTemplate> templates = genModel.getRootTemplates();
		for (RootTemplate templateCall : templates) {
            String templatePath = templateCall.getTemplatePath();
            facade.evaluate(templatePath, templateCall);
        }
		
		
		
//		facade.evaluate("org::eclipse::xtext::StandaloneSetup::file", grammarModel);
//		facade.evaluate("org::eclipse::xtext::services::GrammarAccess::file", grammarModel);
//		facade.evaluate("org::eclipse::xtext::services::MetamodelAccess::file", grammarModel);
//		if (!GrammarUtil.isAbstract(grammarModel)) {
//			facade.evaluate("org::eclipse::xtext::ILanguage::file", grammarModel);
//            facade.evaluate("org::eclipse::xtext::services::ResourceFactory::file", grammarModel);
//			facade.evaluate("org::eclipse::xtext::parser::IParser::parser", grammarModel);
//			facade.evaluate("org::eclipse::xtext::parser::AntlrGrammar::grammar", grammarModel);
//			String grammar = languageNamespace + "/parser/internal/Internal" + languageName + ".g";
//			Tool antlr = new Tool(new String[] { srcGenPath + "/" + grammar });
//			antlr.process();
//			facade.evaluate("org::eclipse::xtext::parsetree::ParseTreeConstructor::file", grammarModel);
//			// generate EPackage
//			ExecutionContextImpl executionContext = new ExecutionContextImpl();
//			executionContext.registerMetaModel(metamodel);
//			XtendFacade xtendfacade = XtendFacade.create(executionContext,
//					"org::eclipse::xtext::xtext2ecore::Xtext2Ecore");
//			List<EPackage> result = (List<EPackage>) xtendfacade.call("getGeneratedEPackages", grammarModel);
//
//			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
//			for (EPackage pack : result) {
//				URI uri = URI.createFileURI(srcGenPath + "/" + languageNamespace + "/" + pack.getName() + ".ecore");
//				Resource metaModelResource = new ResourceSetImpl().createResource(uri);
//				metaModelResource.getContents().add(pack);
//				metaModelResource.save(null);
//			}
//			if (uiProjectPath != null) {
//				facade.evaluate("org::eclipse::xtext::ui::Project::root", grammarModel);
//				facade.evaluate("org::eclipse::xtext::ui::Plugin::file", grammarModel);
//				facade.evaluate("org::eclipse::xtext::ui::Manifest::file", grammarModel);
//				facade.evaluate("org::eclipse::xtext::ui::Editor::file", grammarModel);
//				
//				CopyImages copier = new CopyImages();
//				copier.setTargetDir(uiProjectPath + "/icons/");
//				copier.invoke(null, null, new IssuesImpl());
//			}
//		}
	}

    private static GenModel assembleGeneratorModel(Grammar grammarModel, String srcGenPath, String uiProjectPath, String... modelFileExtensions) {
        String languageName = GrammarUtil.getName(grammarModel);
        String namespace = GrammarUtil.getNamespace(grammarModel);

        GenModel genModel = XtextgenFactory.eINSTANCE.createGenModel();
	    genModel.setGrammar(grammarModel);
	    genModel.setGrammarResourceURI(srcGenPath + "/" + Strings.concat("/", grammarModel.getIdElements(),1) + "/" + languageName + ".xmi");
	    genModel.getModelFileExtensions().addAll(Arrays.asList(modelFileExtensions));
	    genModel.setFileHeader("Generated using Xtext at " + new Date());
	    
	    genModel.getOutletMap().put("", srcGenPath);
	    genModel.getOutletMap().put("UI", uiProjectPath);
	    genModel.getOutletMap().put("UI_SRC_GEN", uiProjectPath + "/src-gen");
	    genModel.getOutletMap().put("UI_MANIFEST", uiProjectPath + "/META-INF");

	    GenService grammarAccessService = XtextgenFactory.eINSTANCE.createGenService();
	    grammarAccessService.setServiceInterfaceFQName("org.eclipse.xtext.IGrammarAccess");
	    grammarAccessService.setGenClassFQName(namespace + ".services." + languageName + "GrammarAccess");
	    grammarAccessService.setTemplatePath("org::eclipse::xtext::grammaraccess::GrammarAccess::root");
	    grammarAccessService.setExtensionPointID("org.eclipse.xtext.ui.grammarAccess");
	    genModel.getRootTemplates().add(grammarAccessService);
	    
	    GenService metamodelAccessService = XtextgenFactory.eINSTANCE.createGenService();
	    metamodelAccessService.setServiceInterfaceFQName("org.eclipse.xtext.IMetamodelAccess");
	    metamodelAccessService.setGenClassFQName(namespace + ".services." + languageName + "MetamodelAccess");
	    metamodelAccessService.setTemplatePath("org::eclipse::xtext::MetamodelAccess::MetamodelAccess::root");
	    metamodelAccessService.setExtensionPointID("org.eclipse.xtext.ui.metamodelAccess");
	    genModel.getRootTemplates().add(metamodelAccessService);
	    
	    GenClass languageInterface = XtextgenFactory.eINSTANCE.createGenClass();
	    languageInterface.setGenClassFQName(namespace + ".I" + languageName);
	    languageInterface.setTemplatePath("org::eclipse::xtext::ILanguage::root");
	    genModel.getRootTemplates().add(languageInterface);
	    
	    GenClass standaloneSetup = XtextgenFactory.eINSTANCE.createGenClass();
	    standaloneSetup.setGenClassFQName(namespace + "." + languageName + "StandaloneSetup");
	    standaloneSetup.setTemplatePath("org::eclipse::xtext::StandaloneSetup::root");
	    genModel.getRootTemplates().add(standaloneSetup);
	    

	    if (!GrammarUtil.isAbstract(grammarModel)) {
	        
	        RootTemplate xtext2ecore = XtextgenFactory.eINSTANCE.createRootTemplate();
	        xtext2ecore.setTemplatePath("org::eclipse::xtext::xtext2ecore::EcoreMetamodels::root");
	        genModel.getRootTemplates().add(xtext2ecore);
	        
	    GenService parserService = XtextgenFactory.eINSTANCE.createGenService();
        parserService.setServiceInterfaceFQName("org.eclipse.xtext.parser.IParser");
        parserService.setGenClassFQName(namespace + ".parser." + languageName + "Parser");
        parserService.setTemplatePath("org::eclipse::xtext::parser::Parser::root");
        parserService.setExtensionPointID("org.eclipse.xtext.ui.parser");
        genModel.getRootTemplates().add(parserService);

        GenService resourceFactoryService = XtextgenFactory.eINSTANCE.createGenService();
        resourceFactoryService.setServiceInterfaceFQName("org.eclipse.xtext.resource.IResourceFactory");
        resourceFactoryService.setGenClassFQName(namespace + ".services." + languageName + "ResourceFactory");
        resourceFactoryService.setTemplatePath("org::eclipse::xtext::resourceFactory::ResourceFactory::root");
        resourceFactoryService.setExtensionPointID("org.eclipse.xtext.ui.resourceFactory");
        genModel.getRootTemplates().add(resourceFactoryService);
        
        GenService parsetreeConstructorService = XtextgenFactory.eINSTANCE.createGenService();
        parsetreeConstructorService.setServiceInterfaceFQName("org.eclipse.xtext.parsetree.IParseTreeConstructor");
        parsetreeConstructorService.setGenClassFQName(namespace + ".parsetree." + languageName + "ParseTreeConstructor");
        parsetreeConstructorService.setTemplatePath("org::eclipse::xtext::parsetree::ParsetreeConstructor::root");
        parsetreeConstructorService.setExtensionPointID("org.eclipse.xtext.ui.parseTreeConstructor");
        genModel.getRootTemplates().add(parsetreeConstructorService);
        
        if (uiProjectPath != null) {
        GenPlugin plugin = XtextgenFactory.eINSTANCE.createGenPlugin();
        plugin.setTemplatePath("org::eclipse::xtext::ui::UIPlugin::root");
        plugin.setBundleID(namespace + ".ui_gen");
        genModel.getRootTemplates().add(plugin);
	    }        }
        return genModel;
    }
	
	private static List<String> packages(Grammar g, String... subpackages) {
	    List<String> result = new ArrayList<String>(g.getIdElements());
	    result.remove(result.size()-1);
        result.addAll(Arrays.asList(subpackages));
        return result;
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

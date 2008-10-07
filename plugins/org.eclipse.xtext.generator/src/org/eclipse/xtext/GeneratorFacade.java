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
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.check.CheckFacade;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.XtextgenFactory;
import org.eclipse.xtext.xtextgen.XtextgenPackage;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GeneratorFacade {
	
	private static Logger log = Logger.getLogger(GeneratorFacade.class);

	public static void generate(Grammar grammarModel, String srcGenPath, String uiProjectPath,
			String... modelFileExtensions) throws IOException {
		List<EObject> list = EcoreUtil2.eAllContentsAsList(grammarModel);
		IssuesImpl issues = new IssuesImpl();
		ExecutionContextImpl ctx = new ExecutionContextImpl();
		ctx.registerMetaModel(new EmfRegistryMetaModel());
		CheckFacade.checkAll("org::eclipse::xtext::Xtext2", list, ctx, issues);
		
		System.err.println(issues);
		if (issues.hasErrors())
			return;
		
		CompositeNode rootNode = NodeUtil.getRootNode(grammarModel);
		EList<SyntaxError> allSyntaxErrors = rootNode.allSyntaxErrors();
		for (SyntaxError syntaxError : allSyntaxErrors) {
			System.err.println(syntaxError.getMessage()+":"+syntaxError.getNode().getLine());
		}
		if (!allSyntaxErrors.isEmpty())
			throw new IllegalStateException("The grammar has syntax errors.");
		GenModel genModel = assembleGeneratorModel(grammarModel, srcGenPath, uiProjectPath, modelFileExtensions);
		generate(genModel);
	}

	private static void generate(GenModel genModel) throws IOException {

		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XtextPackage.eNS_URI, XtextPackage.eINSTANCE);

		// configure outlets
		OutputImpl output = new OutputImpl();
		EList<org.eclipse.xtext.xtextgen.Outlet> outletMap = genModel.getOutlets();
		for (org.eclipse.xtext.xtextgen.Outlet o : outletMap) {
			Outlet outlet = new Outlet(o.getTargetFolder());
			if (o.getName().length()>0)
				outlet.setName(o.getName());
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
				return new EPackage[] { XtextPackage.eINSTANCE,XtextgenPackage.eINSTANCE,
						EcorePackage.eINSTANCE };
			}
		};
		execCtx.registerMetaModel(metamodel);

		// save grammar model
		XtextResourceSet setImpl = new XtextResourceSet();
		String xmiPath = GrammarUtil.getClasspathRelativePathToXmi(genModel.getGrammar());
		Resource resource = setImpl.createResource(URI.createURI(defaultPath(genModel) + "/" + xmiPath));
		resource.getContents().add(genModel.getGrammar());
		resource.save(null);

		// generate services
		XpandFacade facade = XpandFacade.create(execCtx);
		EList<GenService> services = genModel.getServices();
		for (GenService service : services) {
			String templatePath = service.getTemplatePath();
			if (templatePath != null) {
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

	private static String defaultPath(GenModel genModel) {
		return genModel.getOutlets().get(0).getTargetFolder();
	}

	private static GenModel assembleGeneratorModel(Grammar grammarModel, String srcGenPath, String uiProjectPath,
			String... modelFileExtensions) {
		String languageName = GrammarUtil.getName(grammarModel);
		String namespace = GrammarUtil.getNamespace(grammarModel);

		GenModel genModel = XtextgenFactory.eINSTANCE.createGenModel();
		genModel.setGrammar(grammarModel);
		genModel.getModelFileExtensions().addAll(Arrays.asList(modelFileExtensions));
		genModel.setFileHeader("Generated with Xtext");
		genModel.setLanguageInterfaceFQName(namespace + ".I" + languageName);

		genModel.getOutlets().add(outlet("", srcGenPath));

		if (uiProjectPath != null) {
			String uiPluginID = uiProjectPath.substring(uiProjectPath.lastIndexOf('/') + 1);
			genModel.setNonUIPluginBundleID(namespace);
			genModel.setUiPluginBundleID(uiPluginID);

			genModel.getOutlets().add(outlet("UI", uiProjectPath));
			genModel.getOutlets().add(outlet("UI_SRC_GEN", uiProjectPath + "/src-gen"));
			genModel.getOutlets().add(outlet("UI_MANIFEST", uiProjectPath + "/META-INF"));
			genModel.getOutlets().add(outlet("UI_TEMPLATES", uiProjectPath + "/templates"));
		}

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
			// no template, as service is generic. Nevertheless, we need the
			// individual registration to avoid conflicts
			elementFactoryService.setExtensionPointID("org.eclipse.xtext.ui.aSTFactory");
			genModel.getServices().add(elementFactoryService);

			GenService parserService = XtextgenFactory.eINSTANCE.createGenService();
			parserService.setServiceInterfaceFQName("org.eclipse.xtext.parser.IParser");
			parserService.setGenClassFQName(namespace + ".parser." + languageName + "Parser");
			parserService.setTemplatePath("org::eclipse::xtext::parser::Parser::root");
			parserService.setExtensionPointID("org.eclipse.xtext.ui.parser");
			genModel.getServices().add(parserService);

			GenService tokenFileProviderService = XtextgenFactory.eINSTANCE.createGenService();
			tokenFileProviderService.setServiceInterfaceFQName("org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider");
			tokenFileProviderService.setGenClassFQName(namespace + ".parser." + languageName + "AntlrTokenFileProvider");
			tokenFileProviderService.setTemplatePath("org::eclipse::xtext::parser::AntlrTokenFileProvider::root");
			//tokenFileProviderService.setExtensionPointID("org.eclipse.xtext.ui.parser");
			genModel.getServices().add(tokenFileProviderService);

			GenService resourceFactoryService = XtextgenFactory.eINSTANCE.createGenService();
			resourceFactoryService.setServiceInterfaceFQName("org.eclipse.xtext.resource.IResourceFactory");
			resourceFactoryService.setGenClassFQName(namespace + ".services." + languageName + "ResourceFactory");
			resourceFactoryService.setTemplatePath("org::eclipse::xtext::resourcefactory::ResourceFactory::root");
			resourceFactoryService.setExtensionPointID("org.eclipse.xtext.ui.resourceFactory");
			genModel.getServices().add(resourceFactoryService);

			GenService parsetreeReconstructorService = XtextgenFactory.eINSTANCE.createGenService();
			parsetreeReconstructorService
					.setServiceInterfaceFQName("org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor");
			parsetreeReconstructorService.setGenClassFQName(namespace + ".parsetree.reconstr." + languageName
					+ "ParseTreeConstructor");
			parsetreeReconstructorService
					.setTemplatePath("org::eclipse::xtext::parsetree::reconstr::ParseTreeConstructor::root");
			parsetreeReconstructorService.setExtensionPointID("org.eclipse.xtext.ui.parseTreeConstructor");
			genModel.getServices().add(parsetreeReconstructorService);
			
			if (uiProjectPath != null) {
				GenService tokenScannerService = XtextgenFactory.eINSTANCE.createGenService();
				tokenScannerService.setServiceInterfaceFQName("org.eclipse.xtext.parser.antlr.Lexer");
				tokenScannerService.setGenClassFQName(namespace + ".parser.internal.Internal" + languageName + "Lexer");
				tokenScannerService.setUiService(true);
				genModel.getServices().add(tokenScannerService);
			}

		}

		return genModel;
	}

	private static org.eclipse.xtext.xtextgen.Outlet outlet(String name, String srcGenPath) {
		org.eclipse.xtext.xtextgen.Outlet result = XtextgenFactory.eINSTANCE.createOutlet();
		result.setName(name);
		result.setTargetFolder(srcGenPath);
		return result;
	}

	public static void cleanFolder(String srcGenPath) throws FileNotFoundException {
		File f = new File(srcGenPath);
		if (!f.exists()) {
			throw new FileNotFoundException(srcGenPath + " " + f.getAbsolutePath());
		}
		log.info("Cleaning folder " + srcGenPath);
		final File[] contents = f.listFiles();
		for (int j = 0; j < contents.length; j++) {
			final File file = contents[j];
			if (file.isDirectory()) {
				cleanFolder(file.getAbsolutePath());
			} else {
				if (!isCVSFile(file)) {
					if (!file.delete()) {
						log.error("Couldn't delete " + file.getAbsolutePath());
					}
				}
			}
		}
	}

	private static boolean isCVSFile(File file) {
		if (".cvsignore".equals(file.getName()))
			return true;
		if ("CVS".equals(file.getName()))
			return true;
		if ("Entries".equals(file.getName()))
			return true;
		if ("Repository".equals(file.getName()))
			return true;
		if ("Root".equals(file.getName()))
			return true;
		return false;
	}

}

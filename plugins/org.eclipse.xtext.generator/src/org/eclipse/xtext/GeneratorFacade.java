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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.internal.xtend.util.StringHelper;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.check.CheckFacade;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.ecore.GenerateJavaFromEcore;
import org.eclipse.xtext.grammaraccess.GrammarAccessUtil;
import org.eclipse.xtext.parser.antlr.AntlrConnector;
import org.eclipse.xtext.resource.metamodel.Xtext2EcoreTransformer;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.PluginDependency;
import org.eclipse.xtext.xtextgen.XtextgenFactory;
import org.eclipse.xtext.xtextgen.XtextgenPackage;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GeneratorFacade {

	private static Logger log = Logger.getLogger(GeneratorFacade.class);

	public static void generate(Grammar grammarModel, String runtimeProjectPath, String uiProjectPath, String... modelFileExtensions)
			throws IOException {
		generate(grammarModel, runtimeProjectPath, uiProjectPath, false, true, false, modelFileExtensions);
	}
	
	public static void generate(Grammar grammarModel, String runtimeProjectPath, String uiProjectPath,
				boolean isGenerateXtendServices, boolean isGenerateJavaServices, boolean isGenerateEcore, String... modelFileExtensions)
				throws IOException {
		if (!grammarModel.eResource().getErrors().isEmpty()) {
			log.error(grammarModel.eResource().getErrors());
			return;
		}
		if (!grammarModel.eResource().getWarnings().isEmpty()) {
			log.warn(grammarModel.eResource().getWarnings());
		}

		List<EObject> list = EcoreUtil2.eAllContentsAsList(grammarModel);
		Issues issues = new IssuesImpl();
		ExecutionContextImpl ctx = new ExecutionContextImpl();
		ctx.registerMetaModel(new EmfRegistryMetaModel());
		CheckFacade.checkAll("org::eclipse::xtext::Checks", list, ctx, issues);

		if (issues.hasErrors()) {
			log.error(issues);
			return;
		}

		// CompositeNode rootNode = NodeUtil.getRootNode(grammarModel);
		// EList<SyntaxError> allSyntaxErrors = rootNode.allSyntaxErrors();
		// for (SyntaxError syntaxError : allSyntaxErrors) {
		// log.error(syntaxError.getMessage() + ":" +
		// syntaxError.getNode().getTotalLine());
		// }
		// if (!allSyntaxErrors.isEmpty())
		// throw new IllegalStateException("The grammar has syntax errors.");
		GenModel genModel = assembleGeneratorModel(grammarModel, runtimeProjectPath, uiProjectPath,
				isGenerateXtendServices, isGenerateJavaServices, modelFileExtensions);
		generate(genModel, isGenerateEcore, runtimeProjectPath.equals(uiProjectPath));
	}

	private static void generate(GenModel genModel, boolean generateEcore, boolean generateMergedPluginXml) throws IOException {

		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XtextPackage.eNS_URI, XtextPackage.eINSTANCE);

		// configure outlets
		OutputImpl output = new OutputImpl();
		EList<org.eclipse.xtext.xtextgen.Outlet> outletMap = genModel.getOutlets();
		for (org.eclipse.xtext.xtextgen.Outlet o : outletMap) {
			Outlet outlet = new Outlet(o.getTargetFolder());
			if (o.getName().length() > 0)
				outlet.setName(o.getName());
			outlet.setOverwrite(o.isOverwrite());
			output.addOutlet(outlet);
		}

		// create execution context
		Map<String, Variable> globalVarsMap = new HashMap<String, Variable>();
		Variable genModelVariable = new Variable("genModel", genModel);
		globalVarsMap.put("genModel", genModelVariable);
		Variable generateMergedPluginXmlVariable = new Variable("generateMergedPluginXml", generateMergedPluginXml); 
		globalVarsMap.put("generateMergedPluginXml", generateMergedPluginXmlVariable);
		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null, globalVarsMap, null, null);
		EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[] { XtextPackage.eINSTANCE, XtextgenPackage.eINSTANCE, EcorePackage.eINSTANCE };
			}
		};
		execCtx.registerMetaModel(metamodel);

		// save grammar model
		ResourceSet setImpl = genModel.getGrammar().eResource().getResourceSet();
		String xmiPath = GrammarUtil.getClasspathRelativePathToXmi(genModel.getGrammar());
		Resource resource = setImpl.createResource(URI.createURI(GenExtensions.outletPath(genModel, "SRC_GEN") + "/"
				+ xmiPath));
		resource.getContents().add(genModel.getGrammar());
		resource.save(null);

		// generate ecore java classes
		if (generateEcore) {
			String basePackageName = GrammarUtil.getNamespace(genModel.getGrammar()) + "."
					+ StringHelper.firstLower(GrammarUtil.getName(genModel.getGrammar()));
			GenerateJavaFromEcore.generateEcoreJavaClasses(Xtext2EcoreTransformer.doGetGeneratedPackages(genModel
					.getGrammar()), basePackageName, URI.createURI(GenExtensions.outletPath(genModel, "SRC_GEN"))
					.toString());
		}
		// generate services
		XpandFacade facade = XpandFacade.create(execCtx);
		EList<GenService> services = genModel.getServices();
		for (GenService service : services) {
			String templatePath = service.getTemplatePath();
			if (templatePath != null) {
				facade.evaluate(templatePath, service);
			}
		}

		facade.evaluate("org::eclipse::xtext::RuntimePlugin::root", genModel);

		if (genModel.getUiPluginBundleID() != null) {
			facade.evaluate("org::eclipse::xtext::ui::UIPlugin::root", genModel);
			// TODO outline service, copy images
		}
	}

	private static GenModel assembleGeneratorModel(Grammar grammarModel, String runtimeProjectPath,
			String uiProjectPath, boolean isGenerateXtendServices, boolean isGenerateJavaServices,
			String... modelFileExtensions) {
		String languageName = GrammarUtil.getName(grammarModel);
		String namespace = GrammarUtil.getNamespace(grammarModel);

		GenModel genModel = XtextgenFactory.eINSTANCE.createGenModel();
		genModel.setGrammar(grammarModel);
		genModel.getModelFileExtensions().addAll(Arrays.asList(modelFileExtensions));
		genModel.setFileHeader("Generated with Xtext");
		genModel.setLanguageInterfaceFQName(namespace + ".I" + languageName);

		genModel.getOutlets().add(outlet("RUNTIME", runtimeProjectPath, false));
		genModel.getOutlets().add(outlet("SRC", runtimeProjectPath + "/src", false));
		genModel.getOutlets().add(outlet("SRC_GEN", runtimeProjectPath + "/src-gen", true));

		if (uiProjectPath != null) {
			String uiPluginID = uiProjectPath.substring(uiProjectPath.lastIndexOf('/') + 1);
			genModel.setNonUIPluginBundleID(namespace);
			genModel.setUiPluginBundleID(uiPluginID);

			genModel.getOutlets().add(outlet("UI", uiProjectPath, false));
			genModel.getOutlets().add(outlet("UI_SRC", uiProjectPath + "/src", false));
			genModel.getOutlets().add(outlet("UI_SRC_GEN", uiProjectPath + "/src-gen", true));
			// genModel.getOutlets().add(outlet("UI_TEMPLATES", uiProjectPath +
			// "/templates", true));
		}

		GenService metamodelAccessService = XtextgenFactory.eINSTANCE.createGenService();
		metamodelAccessService.setServiceInterfaceFQName("org.eclipse.xtext.IMetamodelAccess");
		metamodelAccessService.setGenClassFQName(namespace + ".services." + languageName + "MetamodelAccess");
		metamodelAccessService.setTemplatePath("org::eclipse::xtext::ecore::Ecore::root");
		metamodelAccessService.setExtensionPointID("org.eclipse.xtext.ui.metamodelAccess");
		genModel.getServices().add(metamodelAccessService);

		// Moritz: I've refactored the determination of the GrammarAccessFQName
		// to GrammarAccessUtil,
		// since there are other services (e.g. Serialization, eventually
		// Parsing) that have hard
		// dependencies on the GrammarAccess specific to their language. By hard
		// dependency I mean that
		// they are not satisfied with some implementation of the interface, but
		// need exactly the
		// implementation for their language.
		GenService grammarAccessService = XtextgenFactory.eINSTANCE.createGenService();
		grammarAccessService.setServiceInterfaceFQName("org.eclipse.xtext.IGrammarAccess");
		grammarAccessService.setGenClassFQName(GrammarAccessUtil.getGrammarAccessFQName(grammarModel));
		grammarAccessService.setTemplatePath("org::eclipse::xtext::grammaraccess::GrammarAccess::root");
		// grammarAccessService.setExtensionPointID(
		// "org.eclipse.xtext.ui.grammarAccess");
		genModel.getServices().add(grammarAccessService);

		GenService packratParser = XtextgenFactory.eINSTANCE.createGenService();
		packratParser.setServiceInterfaceFQName("org.eclipse.xtext.parser.packrat.IPackratParser");
		packratParser.setGenClassFQName(namespace + ".parser.packrat." + languageName + "PackratParser");
		packratParser.setTemplatePath("org::eclipse::xtext::parser::packrat::PackratParserGen::root");
		genModel.getServices().add(packratParser);

		if (!GrammarUtil.isAbstract(grammarModel)) {

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

			GenService serializationStrategy = XtextgenFactory.eINSTANCE.createGenService();
			serializationStrategy.setServiceInterfaceFQName("org.eclipse.xtext.parsetree.reconstr.ITokenSerializer");
			serializationStrategy
					.setGenClassFQName("org.eclipse.xtext.parsetree.reconstr.impl.WhitespacePreservingTokenSerializer");
			genModel.getServices().add(serializationStrategy);

			GenService crossRefSerializer = XtextgenFactory.eINSTANCE.createGenService();
			crossRefSerializer
					.setServiceInterfaceFQName("org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer");
			crossRefSerializer
					.setGenClassFQName("org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer");
			genModel.getServices().add(crossRefSerializer);

			GenService transientValueService = XtextgenFactory.eINSTANCE.createGenService();
			transientValueService
					.setServiceInterfaceFQName("org.eclipse.xtext.parsetree.reconstr.ITransientValueService");
			transientValueService
					.setGenClassFQName("org.eclipse.xtext.parsetree.reconstr.impl.SimpleTransientValueService");
			genModel.getServices().add(transientValueService);

			if (uiProjectPath != null) {
				if (isGenerateXtendServices) {
					GenService xtendProposalProvider = XtextgenFactory.eINSTANCE.createGenService();
					xtendProposalProvider
							.setServiceInterfaceFQName("org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider");
					xtendProposalProvider.setGenClassFQName(namespace + ".Xtend" + languageName + "ProposalProvider");
					xtendProposalProvider.setUiService(true);
					xtendProposalProvider
							.setTemplatePath("org::eclipse::xtext::ui::contentassist::XtendProposals::root");
					PluginDependency xtendPlugin = XtextgenFactory.eINSTANCE.createPluginDependency();
					xtendPlugin.setBundleID("org.eclipse.xtext.ui.common.xtend");
					xtendProposalProvider.getPluginDependencies().add(xtendPlugin);
					genModel.getServices().add(xtendProposalProvider);
				}
				if (isGenerateJavaServices) {
					GenService proposalProvider = XtextgenFactory.eINSTANCE.createGenService();
					proposalProvider
							.setServiceInterfaceFQName("org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider");
					proposalProvider.setGenClassFQName(namespace + ".Gen" + languageName + "ProposalProvider");
					proposalProvider.setUiService(true);
					proposalProvider
							.setTemplatePath("org::eclipse::xtext::ui::contentassist::GenProposalProvider::root");
					genModel.getServices().add(proposalProvider);
				}

				GenService contentAssistProcessor = XtextgenFactory.eINSTANCE.createGenService();
				contentAssistProcessor
						.setServiceInterfaceFQName("org.eclipse.jface.text.contentassist.IContentAssistProcessor");
				contentAssistProcessor
						.setGenClassFQName("org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor");
				contentAssistProcessor.setUiService(true);
				genModel.getServices().add(contentAssistProcessor);

				GenService templateContentAssistProcessor = XtextgenFactory.eINSTANCE.createGenService();
				templateContentAssistProcessor
						.setServiceInterfaceFQName("org.eclipse.xtext.ui.common.editor.contentassist.ITemplateContentAssistProcessor");
				templateContentAssistProcessor
						.setGenClassFQName("org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultTemplateContentAssistProcessor");
				templateContentAssistProcessor.setUiService(true);
				genModel.getServices().add(templateContentAssistProcessor);

				GenService contentAssistCalculator = XtextgenFactory.eINSTANCE.createGenService();
				contentAssistCalculator
						.setServiceInterfaceFQName("org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistCalculator");
				contentAssistCalculator
						.setGenClassFQName("org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistCalculator");
				contentAssistCalculator.setUiService(true);
				genModel.getServices().add(contentAssistCalculator);

				// Outline: Semantic Model to Outline Model Transformer
				GenService semanticModelTransformer = XtextgenFactory.eINSTANCE.createGenService();
				semanticModelTransformer
						.setServiceInterfaceFQName("org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer");
				semanticModelTransformer
						.setGenClassFQName("org.eclipse.xtext.ui.common.editor.outline.impl.DefaultSemanticModelTransformer");
				semanticModelTransformer.setUiService(true);
				genModel.getServices().add(semanticModelTransformer);

				// Outline: Lazy Tree Provider
				GenService lazyTreeProvider = XtextgenFactory.eINSTANCE.createGenService();
				lazyTreeProvider
						.setServiceInterfaceFQName("org.eclipse.xtext.ui.common.editor.outline.ILazyTreeProvider");
				lazyTreeProvider
						.setGenClassFQName("org.eclipse.xtext.ui.common.editor.outline.impl.LazyTransformingTreeProvider");
				lazyTreeProvider.setUiService(true);
				genModel.getServices().add(lazyTreeProvider);
			}
		}
		
		new AntlrConnector().assemble(genModel);

		return genModel;
	}

	private static org.eclipse.xtext.xtextgen.Outlet outlet(String name, String srcGenPath, boolean overwrite) {
		org.eclipse.xtext.xtextgen.Outlet result = XtextgenFactory.eINSTANCE.createOutlet();
		result.setName(name);
		result.setTargetFolder(srcGenPath);
		result.setOverwrite(overwrite);
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

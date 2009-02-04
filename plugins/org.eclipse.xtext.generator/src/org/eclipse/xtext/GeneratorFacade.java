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
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.xtext.parser.ParserAssembler;
import org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.metamodel.Xtext2EcoreTransformer;
import org.eclipse.xtext.util.Files;
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

	private static Set<String> excludes = new HashSet<String>();

	private static String[] defaultExcludes = new String[] { "CVS", ".cvsignore", ".svn" };

	private static boolean useDefaultExcludes = true;

	public static void generate(Grammar grammarModel, String runtimeProjectPath, String uiProjectPath,
			String... modelFileExtensions) throws IOException {
		generate(grammarModel, runtimeProjectPath, uiProjectPath, false, true, false, modelFileExtensions);
	}

	public static void generate(Grammar grammarModel, String runtimeProjectPath, String uiProjectPath,
			boolean isGenerateXtendServices, boolean isGenerateJavaServices, boolean isGenerateEcore,
			String... modelFileExtensions) throws IOException {
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

	private static void generate(GenModel genModel, boolean generateEcore, boolean generateMergedPluginXml)
			throws IOException {

		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XtextPackage.eNS_URI, XtextPackage.eINSTANCE);

		// configure outlets
		OutputImpl output = new OutputImpl();
		EList<org.eclipse.xtext.xtextgen.Outlet> outletMap = genModel.getOutlets();
		for (org.eclipse.xtext.xtextgen.Outlet o : outletMap) {
			Outlet outlet = new Outlet(o.getTargetFolder());
			if (o.getName().length() > 0) {
				outlet.setName(o.getName());
			}
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
		metamodelAccessService.setServiceInterfaceFQName(IMetamodelAccess.class.getName());
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
		grammarAccessService.setServiceInterfaceFQName(IGrammarAccess.class.getName());
		grammarAccessService.setGenClassFQName(GrammarAccessUtil.getGrammarAccessFQName(grammarModel));
		grammarAccessService.setTemplatePath("org::eclipse::xtext::grammaraccess::GrammarAccess::root");
		// grammarAccessService.setExtensionPointID(
		// "org.eclipse.xtext.ui.grammarAccess");
		genModel.getServices().add(grammarAccessService);

		if (!GrammarUtil.isAbstract(grammarModel)) {

			GenService elementFactoryService = XtextgenFactory.eINSTANCE.createGenService();
			elementFactoryService.setServiceInterfaceFQName(org.eclipse.xtext.parser.IAstFactory.class.getName());
			elementFactoryService.setGenClassFQName("org.eclipse.xtext.parser.DefaultEcoreElementFactory");
			// no template, as service is generic. Nevertheless, we need the
			// individual registration to avoid conflicts
			elementFactoryService.setExtensionPointID("org.eclipse.xtext.ui.aSTFactory");
			genModel.getServices().add(elementFactoryService);

			GenService resourceFactoryService = XtextgenFactory.eINSTANCE.createGenService();
			resourceFactoryService.setServiceInterfaceFQName(IResourceFactory.class.getName());
			resourceFactoryService.setGenClassFQName(namespace + ".services." + languageName + "ResourceFactory");
			resourceFactoryService.setTemplatePath("org::eclipse::xtext::resourcefactory::ResourceFactory::root");
			resourceFactoryService.setExtensionPointID("org.eclipse.xtext.ui.resourceFactory");
			genModel.getServices().add(resourceFactoryService);

			GenService parsetreeReconstructorService = XtextgenFactory.eINSTANCE.createGenService();
			parsetreeReconstructorService.setServiceInterfaceFQName(IParseTreeConstructor.class.getName());
			parsetreeReconstructorService.setGenClassFQName(namespace + ".parsetree.reconstr." + languageName
					+ "ParseTreeConstructor");
			parsetreeReconstructorService
					.setTemplatePath("org::eclipse::xtext::parsetree::reconstr::ParseTreeConstructor::root");
			parsetreeReconstructorService.setExtensionPointID("org.eclipse.xtext.ui.parseTreeConstructor");
			genModel.getServices().add(parsetreeReconstructorService);

			GenService serializationStrategy = XtextgenFactory.eINSTANCE.createGenService();
			serializationStrategy.setServiceInterfaceFQName(ITokenSerializer.class.getName());
			serializationStrategy
					.setGenClassFQName("org.eclipse.xtext.parsetree.reconstr.impl.WhitespacePreservingTokenSerializer");
			genModel.getServices().add(serializationStrategy);

			GenService crossRefSerializer = XtextgenFactory.eINSTANCE.createGenService();
			crossRefSerializer.setServiceInterfaceFQName(ICrossReferenceSerializer.class.getName());
			crossRefSerializer
					.setGenClassFQName("org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer");
			genModel.getServices().add(crossRefSerializer);

			GenService transientValueService = XtextgenFactory.eINSTANCE.createGenService();
			transientValueService.setServiceInterfaceFQName(ITransientValueService.class.getName());
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
					xtendPlugin.setBundleID("org.eclipse.xtext.xtend");
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
			}
		}

		new ParserAssembler().assemble(genModel);

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
		if (!f.exists())
			throw new FileNotFoundException(srcGenPath + " " + f.getAbsolutePath());
		log.info("Cleaning folder " + f.getPath());
		Files.cleanFolder(f, new FileFilter() {
			private final Collection<String> excludes = new HashSet<String>(
					useDefaultExcludes ? Arrays.asList(defaultExcludes) : GeneratorFacade.excludes); 
			public boolean accept(File pathname) {
				return !excludes.contains(pathname.getName());
			}
		}, false, false);
	}

	/**
	 * Returns if the default excludes are used.
	 * 
	 * @return <code>true</code>, if the default excludes are used, otherwise
	 *         <code>false</code>.
	 */
	public static boolean isUseDefaultExcludes() {
		return useDefaultExcludes;
	}

	/**
	 * Sets if the default excludes are used.
	 * 
	 * @param useDefaultExcludes
	 *            If <code>true</code>, the default excludes are used, if
	 *            <code>false</code>, the default excludes are ignored.
	 */
	public static void setUseDefaultExcludes(final boolean useDefaultExcludes) {
		GeneratorFacade.useDefaultExcludes = useDefaultExcludes;
	}

	/**
	 * Adds an exclude.
	 * 
	 * @param exclude
	 *            the exclude
	 */
	public static void addExclude(final String exclude) {
		excludes.add(exclude);
	}

}

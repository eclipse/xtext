/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.XtextStandaloneSetup;

import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 * 
 *         The main xtext generator. Can be configured with
 *         {@link IGeneratorFragment} instances as well as with some properties
 *         declared via setter or adder methods.
 */
public class Generator extends AbstractWorkflowComponent2 {

	private final Logger log = Logger.getLogger(getClass());

	public static final String SRC_GEN_UI = "SRC_GEN_UI";
	public static final String SRC_UI = "SRC_UI";
	public static final String PLUGIN_UI = "PLUGIN_UI";
	public static final String SRC = "SRC";
	public static final String SRC_GEN = "SRC_GEN";
	public static final String PLUGIN_RT = "PLUGIN";
	
	private Naming naming = new Naming();
	
	public void setNaming(Naming naming) {
		this.naming = naming;
	}

	public Generator() {
		new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
	protected void checkConfigurationInternal(Issues issues) {
		naming.setUiBasePackage(getProjectNameUi());
		Map<String,Grammar> uris = new HashMap<String,Grammar>();
		for (LanguageConfig config : languageConfigs) {
			config.registerNaming(naming);
			config.checkConfiguration(issues);
			Grammar grammar = config.getGrammar();
			List<GeneratedMetamodel> select = EcoreUtil2.typeSelect(grammar.getMetamodelDeclarations(), GeneratedMetamodel.class);
			for (GeneratedMetamodel generatedMetamodel : select) {
				String nsURI = generatedMetamodel.getEPackage().getNsURI();
				if (uris.containsKey(nsURI)) {
					issues.addError("Duplicate generated grammar with nsURI '"+nsURI+"' in "+uris.get(nsURI).getName()+" and "+grammar.getName());
				} else {
					uris.put(nsURI, grammar);
				}
			}
		}
		if (getProjectNameRt() == null)
			issues.addError("The property 'projectNameRt' is mandatory");
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();

		try {
			XpandExecutionContext exeCtx = createExecutionContext();
			for (LanguageConfig config : languageConfigs) {
				generate(config, exeCtx);
				addToStandaloneSetup(config, exeCtx);
				generateGuiceModuleRt(config, exeCtx);
				if (isUi()) {
					generateGuiceModuleUi(config, exeCtx);
					generateExecutableExtensionsFactory(config, exeCtx);
				}
			}
			generatePluginXmlRt(languageConfigs, exeCtx);
			generateManifestRt(languageConfigs, exeCtx);
			if (isUi()) {
				generatePluginXmlUi(languageConfigs, exeCtx);
				generateManifestUi(languageConfigs, exeCtx);
				generateActivator(languageConfigs, exeCtx);
			}
		} catch (WorkflowInterruptedException e) {
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private String pathRtProject = ".";
	private String pathUiProject = null;
	private String srcPath = "/src";
	private String srcGenPath = "/src-gen";

	public String getPathRtProject() {
		return pathRtProject;
	}

	public void setPathRtProject(String pathRtProject) {
		this.pathRtProject = pathRtProject;
	}

	public String getPathUiProject() {
		return pathUiProject;
	}

	public void setPathUiProject(String pathUiProject) {
		this.pathUiProject = pathUiProject;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getSrcGenPath() {
		return srcGenPath;
	}

	public void setSrcGenPath(String srcGenPath) {
		this.srcGenPath = srcGenPath;
	}

	private XpandExecutionContext createExecutionContext() {
		// configure outlets
		OutputImpl output = new OutputImpl();

		output.addOutlet(new Outlet(false, getEncoding(), PLUGIN_RT, false, getPathRtProject()));
		output.addOutlet(new Outlet(false, getEncoding(), SRC, false, getPathRtProject() + getSrcPath()));
		output.addOutlet(new Outlet(false, getEncoding(), SRC_GEN, true, getPathRtProject() + getSrcGenPath()));
		if (isUi()) {
			output.addOutlet(new Outlet(false, getEncoding(), PLUGIN_UI, false, getPathUiProject()));
			output.addOutlet(new Outlet(false, getEncoding(), SRC_UI, false, getPathUiProject() + getSrcPath()));
			output.addOutlet(new Outlet(false, getEncoding(), SRC_GEN_UI, true, getPathUiProject() + getSrcGenPath()));
		} else {
			output.addOutlet(new Outlet(false, getEncoding(), PLUGIN_UI, false, getPathRtProject()));
			output.addOutlet(new Outlet(false, getEncoding(), SRC_UI, false, getPathRtProject() + getSrcPath()));
			output.addOutlet(new Outlet(false, getEncoding(), SRC_GEN_UI, true, getPathRtProject() + getSrcGenPath()));
		}
		// initialize global vars
		Map<String,Variable> globalVars = Maps.newHashMap();
		globalVars.put(Naming.GLOBAL_VAR_NAME, new Variable(Naming.GLOBAL_VAR_NAME,naming));
		
		// create execution context
		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null,globalVars,null,null);
		//since our templates are all encoded in ISO-8859-1, we have to fix it here.
		execCtx.getResourceManager().setFileEncoding("ISO-8859-1");
		
		execCtx.registerMetaModel(new JavaBeansMetaModel());
		// add default value for 'modelPluginID' for generated GenModel required
		// for further .edit/.editor generation
		execCtx = (XpandExecutionContextImpl) execCtx.cloneWithVariable(new Variable("modelPluginID", getProjectNameRt()));
		return execCtx;
	}

	private String getEncoding() {
		return System.getProperty("file.encoding");
	}

	private final List<LanguageConfig> languageConfigs = new ArrayList<LanguageConfig>();

	public void addLanguage(LanguageConfig langConfig) {
		langConfig.initialize(isUi());
		this.languageConfigs.add(langConfig);
	}

	private List<Grammar> getGrammars(List<LanguageConfig> configs) {
		List<Grammar> grammars = new ArrayList<Grammar>();
		for (LanguageConfig conf : configs) {
			grammars.add(conf.getGrammar());
		}
		return grammars;
	}

	private void generatePluginXmlRt(List<LanguageConfig> configs, XpandExecutionContext ctx) {
		String filePath = fileExists(ctx, "plugin.xml", PLUGIN_RT) ? "plugin.xml_gen" : "plugin.xml";
		deleteFile(ctx, filePath, PLUGIN_RT);
		ctx.getOutput().openFile(filePath, PLUGIN_RT);
		try {
			XpandFacade facade = XpandFacade.create(ctx);
			List<Grammar> grammars = getGrammars(configs);
			facade.evaluate("org::eclipse::xtext::generator::Plugin::pre", grammars);
			for (LanguageConfig conf : languageConfigs) {
				conf.addToPluginXmlRt(conf.getGrammar(), ctx);
				if (isMergedProjects()) {
					conf.addToPluginXmlUi(conf.getGrammar(), ctx);
				}
			}
			facade.evaluate("org::eclipse::xtext::generator::Plugin::post", grammars);
		} finally {
			ctx.getOutput().closeFile();
		}
	}

	private void generateExecutableExtensionsFactory(LanguageConfig config, XpandExecutionContext exeCtx) {
		XpandFacade facade = XpandFacade.create(exeCtx);
		facade.evaluate("org::eclipse::xtext::generator::ExecutableExtensionFactory::file", config.getGrammar(), getActivator());
	}

	private void generateActivator(List<LanguageConfig> configs, XpandExecutionContext exeCtx) {
		XpandFacade facade = XpandFacade.create(exeCtx);
		facade.evaluate("org::eclipse::xtext::generator::Activator::file", getGrammars(configs), getActivator());
	}

	private void generatePluginXmlUi(List<LanguageConfig> configs, XpandExecutionContext ctx) {
		if (isUi() && !isMergedProjects()) {
			String filePath = fileExists(ctx, "plugin.xml", PLUGIN_UI) ? "plugin.xml_gen" : "plugin.xml";
			deleteFile(ctx, filePath, PLUGIN_UI);
			ctx.getOutput().openFile(filePath, PLUGIN_UI);
			try {
				XpandFacade facade = XpandFacade.create(ctx);
				List<Grammar> grammars = getGrammars(configs);
				facade.evaluate("org::eclipse::xtext::generator::Plugin::pre", grammars);
				for (LanguageConfig conf : languageConfigs) {
					conf.addToPluginXmlUi(conf.getGrammar(), ctx);
				}
				facade.evaluate("org::eclipse::xtext::generator::Plugin::post", grammars);
			} finally {
				ctx.getOutput().closeFile();
			}
		}
	}

	private void addToStandaloneSetup(LanguageConfig config, XpandExecutionContext ctx) {
		ctx.getOutput().openFile(naming.asPath(naming.setupImpl(config.getGrammar())) + ".java", SRC_GEN);
		try {
			XpandFacade facade = XpandFacade.create(ctx);
			facade.evaluate("org::eclipse::xtext::generator::StandaloneSetup::pre", config.getGrammar());
			config.addToStandaloneSetup(config.getGrammar(), ctx);
			facade.evaluate("org::eclipse::xtext::generator::StandaloneSetup::post", config.getGrammar());
		} finally {
			ctx.getOutput().closeFile();
		}
	}

	private void generateGuiceModuleRt(LanguageConfig config, XpandExecutionContext ctx) {
		XpandFacade facade = XpandFacade.create(ctx);
		Set<Binding> bindings = config.getGuiceBindingsRt(config.getGrammar());
		facade.evaluate("org::eclipse::xtext::generator::GuiceModuleRt::generate", config.getGrammar(), bindings, config.getFileExtensions(config.getGrammar()));
	}

	private void generateGuiceModuleUi(LanguageConfig config, XpandExecutionContext ctx) {
		if (isUi()) {
			XpandFacade facade = XpandFacade.create(ctx);
			Set<Binding> bindings = config.getGuiceBindingsUi(config.getGrammar());
			facade.evaluate("org::eclipse::xtext::generator::GuiceModuleUi::generate", config.getGrammar(), bindings);
		}
	}

	private boolean isUi() {
		return getPathUiProject() != null;
	}

	private void generate(LanguageConfig config, XpandExecutionContext ctx) {
		config.generate(config.getGrammar(), ctx);
	}

	private void generateManifestRt(List<LanguageConfig> configs, XpandExecutionContext ctx) {
		String manifestPath = "META-INF/MANIFEST.MF";

		Set<String> exported = new LinkedHashSet<String>();
		Set<String> requiredBundles = new LinkedHashSet<String>();
		Set<String> imported = new LinkedHashSet<String>();
		String activator = null;
		if (isMergedProjects())
			activator = getActivator();
		for (LanguageConfig config : configs) {
			exported.addAll(Arrays.asList(config.getExportedPackagesRt(config.getGrammar())));
			requiredBundles.addAll(Arrays.asList(config.getRequiredBundlesRt(config.getGrammar())));
			imported.addAll(Arrays.asList(config.getImportedPackagesRt(config.getGrammar())));
			if (isMergedProjects()) {
				exported.addAll(Arrays.asList(config.getExportedPackagesUi(config.getGrammar())));
				imported.addAll(Arrays.asList(config.getImportedPackagesUi(config.getGrammar())));
				requiredBundles.addAll(Arrays.asList(config.getRequiredBundlesUi(config.getGrammar())));
			}
		}
		if (isMergeManifest()) {
			String path = ctx.getOutput().getOutlet(PLUGIN_RT).getPath() + "/" + manifestPath;
			mergeManifest(getProjectNameRt(), path, exported, requiredBundles, imported, activator);
		} else {
			manifestPath = manifestPath + "_gen";
			deleteFile(ctx, manifestPath, PLUGIN_RT);
			ctx.getOutput().openFile(manifestPath, PLUGIN_RT);
			try {
				XpandFacade facade = XpandFacade.create(ctx);
				generateManifest(facade, getProjectNameRt(), getProjectNameRt(), getBundleVersion(), exported, requiredBundles, imported, activator);
			} finally {
				ctx.getOutput().closeFile();
			}
		}
	}

	private void mergeManifest(String projectName, String path, Set<String> exported, Set<String> requiredBundles, Set<String> imported, String activator) {
		File file = new File(path);
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(file);
			MergeableManifest manifest = new MergeableManifest(in, projectName);
			manifest.addExportedPackages(exported);
			manifest.addRequiredBundles(requiredBundles);
			manifest.addImportedPackages(imported);
			if (activator != null && !manifest.getMainAttributes().containsKey(MergeableManifest.BUNDLE_ACTIVATOR)) {
				manifest.getMainAttributes().put(MergeableManifest.BUNDLE_ACTIVATOR, activator);
			}
			if (manifest.isModified()) {
				out = new FileOutputStream(file);
				manifest.write(out);
				out.close();
			}
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		}
	}

	private boolean mergeManifest = true;

	public void setMergeManifest(boolean mergeManifest) {
		this.mergeManifest = mergeManifest;
	}

	private boolean isMergeManifest() {
		return mergeManifest;
	}

	private void generateManifestUi(List<LanguageConfig> configs, XpandExecutionContext ctx) {
		if (isUi() && !isMergedProjects()) {
			String manifestPath = "META-INF/MANIFEST.MF";
			Set<String> exported = new LinkedHashSet<String>();
			Set<String> imported = new LinkedHashSet<String>();
			Set<String> requiredBundles = new LinkedHashSet<String>();
			for (LanguageConfig config : languageConfigs) {
				exported.addAll(Arrays.asList(config.getExportedPackagesUi(config.getGrammar())));
				imported.addAll(Arrays.asList(config.getImportedPackagesUi(config.getGrammar())));
				requiredBundles.addAll(Arrays.asList(config.getRequiredBundlesUi(config.getGrammar())));
			}

			if (isMergeManifest()) {
				String path = ctx.getOutput().getOutlet(PLUGIN_UI).getPath() + "/" + manifestPath;
				mergeManifest(getProjectNameUi(), path, exported, requiredBundles, imported, getActivator());
			} else {
				manifestPath = manifestPath + "_gen";
				deleteFile(ctx, manifestPath, PLUGIN_UI);
				ctx.getOutput().openFile(manifestPath, PLUGIN_UI);
				try {
					XpandFacade facade = XpandFacade.create(ctx);
					generateManifest(facade, getProjectNameUi(), getProjectNameUi(), getBundleVersion(), exported, requiredBundles,
							imported, getActivator());
				} finally {
					ctx.getOutput().closeFile();
				}
			}
		}
	}

	private String activator;

	private void deleteFile(XpandExecutionContext ctx, String filePath, String outlet) {
		String pathname = ctx.getOutput().getOutlet(outlet).getPath() + "/" + filePath;
		File file = new File(pathname);
		if (file.exists()) {
			if (!file.delete()) {
				throw new IllegalStateException("couldn't delete file '" + pathname);
			}
		}
	}

	private boolean fileExists(XpandExecutionContext ctx, String filePath, String outlet) {
		String pathname = ctx.getOutput().getOutlet(outlet).getPath() + "/" + filePath;
		File file = new File(pathname);
		return file.exists();
	}

	private boolean isMergedProjects() {
		return getPathRtProject().equals(getPathUiProject());
	}

	private String getBundleVersion() {
		return "0.0.1";
	}

	private String projectNameRt;

	public void setProjectNameRt(String projectNameRt) {
		this.projectNameRt = projectNameRt;
	}

	private String getProjectNameRt() {
		return projectNameRt;
	}

	private String projectNameUi;

	public void setProjectNameUi(String projectNameUi) {
		this.projectNameUi = projectNameUi;
	}

	private String getProjectNameUi() {
		if (projectNameUi == null)
			return getProjectNameRt() + ".ui";
		return projectNameUi;
	}

	private void generateManifest(XpandFacade facade, String name, String symbolicName, String version, Set<String> exported,
			Set<String> requiredBundles, Set<String> imported, String activator) {
		facade.evaluate("org::eclipse::xtext::generator::Manifest::file", 
				name, symbolicName, version, exported, requiredBundles, imported, activator);
	}

	public void setActivator(String activator) {
		this.activator = activator;
	}

	private String getActivator() {
		if (activator == null) {
			Grammar grammar = languageConfigs.get(0).getGrammar();
			return naming.basePackageUi(grammar) + ".internal." + GrammarUtil.getName(grammar) + "Activator";
		}
		return activator;
	}

}

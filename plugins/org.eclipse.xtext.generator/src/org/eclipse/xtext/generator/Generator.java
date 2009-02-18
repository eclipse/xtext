/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.generator;

import static org.eclipse.xtext.generator.Naming.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 *         The main xtext generator. Can be configured with
 *         {@link IGeneratorFragment} instances as well as with some properties
 *         declared via setter or adder methods.
 */
public class Generator extends AbstractWorkflowComponent2 {

	private Logger log = Logger.getLogger(getClass());

	public static final String SRC_GEN_UI = "SRC_GEN_UI";
	public static final String SRC_UI = "SRC_UI";
	public static final String PLUGIN_UI = "PLUGIN_UI";
	public static final String SRC = "SRC";
	public static final String SRC_GEN = "SRC_GEN";
	public static final String PLUGIN_RT = "PLUGIN";

	@Override
	protected void checkConfigurationInternal(Issues issues) {
	}

	private String grammarURI;

	public void setGrammarURI(String grammarURI) {
		this.grammarURI = grammarURI;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();
		Grammar grammar = loadGrammar();

		try {
			XpandExecutionContext exeCtx = createExecutionContext();
			generate(grammar, exeCtx);
			addToStandaloneSetup(grammar, exeCtx);
			generatePluginXmlRt(grammar, exeCtx);
			generatePluginXmlUi(grammar, exeCtx);
			generateManifestRt(grammar, exeCtx);
			generateManifestUi(grammar, exeCtx);
			generateGuiceModuleRt(grammar, exeCtx);
			generateGuiceModuleUi(grammar, exeCtx);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private Grammar loadGrammar() {
		XtextResourceSet rs = new XtextResourceSet();
		Resource resource = rs.getResource(URI.createURI(grammarURI), true);
		if (resource.getContents().isEmpty()) {
			throw new IllegalArgumentException("Couldn't load file '" + grammarURI + "'.");
		}
		return (Grammar) resource.getContents().get(0);
	}

	private String pathRtProject = ".";
	private String pathUiProject = null;

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

	private XpandExecutionContext createExecutionContext() {
		// configure outlets
		OutputImpl output = new OutputImpl();

		output.addOutlet(new Outlet(false, getEncoding(), PLUGIN_RT, false, getPathRtProject()));
		output.addOutlet(new Outlet(false, getEncoding(), SRC, false, getPathRtProject() + "/src"));
		output.addOutlet(new Outlet(false, getEncoding(), SRC_GEN, true, getPathRtProject() + "/src-gen"));
		if (isUi()) {
			output.addOutlet(new Outlet(false, getEncoding(), PLUGIN_UI, false, getPathUiProject()));
			output.addOutlet(new Outlet(false, getEncoding(), SRC_UI, false, getPathUiProject() + "/src"));
			output.addOutlet(new Outlet(false, getEncoding(), SRC_GEN_UI, true, getPathUiProject() + "/src-gen"));
		}
		// create execution context
		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null);
		EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[] { XtextPackage.eINSTANCE, EcorePackage.eINSTANCE };
			}
		};
		execCtx.registerMetaModel(metamodel);
		return execCtx;
	}

	private String getEncoding() {
		return System.getProperty("file.encoding");
	}

	private CompositeGeneratorFragment fragments = new CompositeGeneratorFragment();

	public void addFragment(IGeneratorFragment fragment) {
		this.fragments.addFragment(fragment);
	}

	public void addFragments(CompositeGeneratorFragment fragments) {
		this.fragments.addFragments(fragments);
	}

	public void generatePluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		String filePath = "plugin.xml_gen";
		deleteFile(ctx, filePath, PLUGIN_RT);
		try {
			ctx.getOutput().openFile(filePath, PLUGIN_RT);
			XpandFacade facade = XpandFacade.create(ctx);
			facade.evaluate("org::eclipse::xtext::generator::Plugin::pre", grammar);
			fragments.addToPluginXmlRt(grammar, ctx);
			if (isMergedProjects()) {
				fragments.addToPluginXmlUi(grammar, ctx);
			}
			facade.evaluate("org::eclipse::xtext::generator::Plugin::post", grammar);
		} finally {
			ctx.getOutput().closeFile();
		}
	}

	public void generatePluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		if (isUi() && !isMergedProjects()) {
			String filePath = "plugin.xml_gen";
			deleteFile(ctx, filePath, PLUGIN_UI);
			try {
				ctx.getOutput().openFile(filePath, PLUGIN_UI);
				XpandFacade facade = XpandFacade.create(ctx);
				facade.evaluate("org::eclipse::xtext::generator::Plugin::pre", grammar);
				fragments.addToPluginXmlUi(grammar, ctx);
				facade.evaluate("org::eclipse::xtext::generator::Plugin::post", grammar);
			} finally {
				ctx.getOutput().closeFile();
			}
		}
	}

	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		try {
			ctx.getOutput().openFile(asPath(setup(grammar)) + ".java", SRC_GEN);
			XpandFacade facade = XpandFacade.create(ctx);
			facade.evaluate("org::eclipse::xtext::generator::StandaloneSetup::pre", grammar);
			fragments.addToStandaloneSetup(grammar, ctx);
			facade.evaluate("org::eclipse::xtext::generator::StandaloneSetup::post", grammar);
		} finally {
			ctx.getOutput().closeFile();
		}
	}

	public void generateGuiceModuleRt(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade facade = XpandFacade.create(ctx);
		Map<String, String> bindings = fragments.getGuiceBindingsRt(grammar);
		facade.evaluate("org::eclipse::xtext::generator::GuiceModuleRt::generate", grammar, xpandify(bindings));
	}

	public void generateGuiceModuleUi(Grammar grammar, XpandExecutionContext ctx) {
		if (isUi()) {
			XpandFacade facade = XpandFacade.create(ctx);
			Map<String, String> bindings = fragments.getGuiceBindingsUi(grammar);
			facade.evaluate("org::eclipse::xtext::generator::GuiceModuleUi::generate", grammar, xpandify(bindings));
		}
	}

	private boolean isUi() {
		return getPathUiProject() != null;
	}

	private List<String> xpandify(Map<String, String> bindings) {
		List<String> result = new ArrayList<String>();
		for (Map.Entry<String, String> entry : bindings.entrySet()) {
			result.add(entry.getKey() + "::" + entry.getValue());
		}
		return result;
	}

	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		fragments.generate(grammar, ctx);
	}

	public void generateManifestRt(Grammar grammar, XpandExecutionContext ctx) {
		String manifestPath = "META-INF/MANIFEST.MF_gen";
		deleteFile(ctx, manifestPath, PLUGIN_RT);
		try {
			ctx.getOutput().openFile(manifestPath, PLUGIN_RT);
			XpandFacade facade = XpandFacade.create(ctx);
			String[] exported = fragments.getExportedPackagesRt(grammar);
			String[] requiredBundles = fragments.getRequiredBundlesRt(grammar);
			String activator = null;
			if (isMergedProjects()) {
				String[] exportedUi = fragments.getExportedPackagesUi(grammar);
				String[] requiredBundlesUi = fragments.getRequiredBundlesUi(grammar);
				activator = Naming.activator(grammar);

				Set<String> exportedSet = new LinkedHashSet<String>(Arrays.asList(exported));
				exportedSet.addAll(Arrays.asList(exportedUi));
				exported = exportedSet.toArray(new String[exportedSet.size()]);

				Set<String> reqBundSet = new LinkedHashSet<String>(Arrays.asList(requiredBundles));
				reqBundSet.addAll(Arrays.asList(requiredBundlesUi));
				requiredBundles = reqBundSet.toArray(new String[reqBundSet.size()]);
			}
			generateManifest(grammar, facade, getProjectNameRt(grammar), getProjectNameRt(grammar), getBundleVersion(),
					exported, requiredBundles, activator);
		} finally {
			ctx.getOutput().closeFile();
		}
	}

	private void deleteFile(XpandExecutionContext ctx, String filePath, String outlet) {
		String pathname = ctx.getOutput().getOutlet(outlet).getPath() + "/" + filePath;
		File file = new File(pathname);
		if (file.exists()) {
			if (!file.delete()) {
				throw new IllegalStateException("couldn't delete file '" + pathname);
			}
		}
	}

	private boolean isMergedProjects() {
		return getPathRtProject().equals(getPathUiProject());
	}

	private String getBundleVersion() {
		return "0.0.1";
	}

	private String getProjectNameRt(Grammar grammar) {
		return grammar.getName();
	}

	private String getProjectNameUi(Grammar grammar) {
		return grammar.getName() + ".ui";
	}

	private void generateManifest(Grammar grammar, XpandFacade facade, String name, String symbolicName,
			String version, String[] exported, String[] requiredBundles, String activator) {
		facade.evaluate("org::eclipse::xtext::generator::Manifest::file", grammar, name, symbolicName, version, Arrays
				.asList(exported), Arrays.asList(requiredBundles), activator);
	}

	public void generateManifestUi(Grammar grammar, XpandExecutionContext ctx) {
		if (isUi() && !isMergedProjects()) {
			String manifestPath = "META-INF/MANIFEST.MF_gen";
			deleteFile(ctx, manifestPath, PLUGIN_UI);
			try {
				ctx.getOutput().openFile(manifestPath, PLUGIN_UI);
				XpandFacade facade = XpandFacade.create(ctx);
				String[] exported = fragments.getExportedPackagesUi(grammar);
				String[] requiredBundles = fragments.getRequiredBundlesUi(grammar);
				generateManifest(grammar, facade, getProjectNameUi(grammar), getProjectNameUi(grammar),
						getBundleVersion(), exported, requiredBundles, Naming.activator(grammar));
			} finally {
				ctx.getOutput().closeFile();
			}
		}
	}

}

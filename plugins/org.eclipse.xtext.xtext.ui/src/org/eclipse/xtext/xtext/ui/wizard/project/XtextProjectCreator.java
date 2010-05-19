/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.ui.wizard.AbstractProjectCreator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * XtextProjectCreator handles the actual creation of the new Xtext project.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class XtextProjectCreator extends AbstractProjectCreator {

	protected static final String[] DSL_PROJECT_NATURES = new String[] { 
			JavaCore.NATURE_ID,
			"org.eclipse.pde.PluginNature", //$NON-NLS-1$
			XtextProjectHelper.NATURE_ID //$NON-NLS-1$
	};

	protected static final String[] DSL_UI_PROJECT_NATURES = new String[] { 
			JavaCore.NATURE_ID,
			"org.eclipse.pde.PluginNature" //$NON-NLS-1$
	};
	
	protected static final String[] BUILDERS = new String[]{
			JavaCore.BUILDER_ID, 
			"org.eclipse.pde.ManifestBuilder", //$NON-NLS-1$
			"org.eclipse.pde.SchemaBuilder", //$NON-NLS-1$
			XtextProjectHelper.BUILDER_ID
	};

	protected static final String[] GENERATOR_PROJECT_NATURES = DSL_UI_PROJECT_NATURES;

	protected static final String SRC_GEN_ROOT = "src-gen"; //$NON-NLS-1$
	protected static final String SRC_ROOT = "src"; //$NON-NLS-1$
	protected static final List<String> SRC_FOLDER_LIST = ImmutableList.of(SRC_ROOT, SRC_GEN_ROOT);

	@Inject
	private Provider<PluginProjectFactory> projectFactoryProvider;
	
	protected XtextProjectInfo getXtextProjectInfo() {
		return (XtextProjectInfo) getProjectInfo();
	}

	@Override
	protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
			InterruptedException {
		SubMonitor subMonitor = SubMonitor.convert(
				monitor, 
				getCreateModelProjectMessage(), 
				getXtextProjectInfo().isCreateGeneratorProject() ? 3 : 2);

		IProject project = createDslProject(subMonitor.newChild(1));
		createDslUiProject(subMonitor.newChild(1));

		if (getXtextProjectInfo().isCreateGeneratorProject()) {
			createGeneratorProject(subMonitor.newChild(1));
		}

		IFile dslGrammarFile = project.getFile(new Path(getModelFolderName()
				+ "/" + getXtextProjectInfo().getLanguageName().replace('.', '/') //$NON-NLS-1$
				+ ".xtext")); //$NON-NLS-1$
		BasicNewResourceWizard.selectAndReveal(dslGrammarFile, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		setResult(dslGrammarFile);
	}
	
	@Override
	protected PluginProjectFactory createProjectFactory() {
		return projectFactoryProvider.get();
	}
	
	@Override
	protected String getCreateModelProjectMessage() {
		return Messages.XtextProjectCreator_CreatingProjectsMessage2 + getXtextProjectInfo().getProjectName();
	}
	
	protected IProject createDslUiProject(final IProgressMonitor monitor) throws CoreException {
		PluginProjectFactory factory = createProjectFactory();
		configureDslUiProjectFactory(factory);
		return createProject(factory, getDslUiProjectTemplateName(), monitor);
	}

	protected void configureDslUiProjectFactory(PluginProjectFactory factory) {
		configureProjectFactory(factory);
		List<String> requiredBundles = getDslUiProjectRequiredBundles();
		factory.setProjectName(getXtextProjectInfo().getUiProjectName());
		factory.addProjectNatures(getDslUiProjectNatures());
		factory.addRequiredBundles(requiredBundles);
		factory.setLocation(getXtextProjectInfo().getUiProjectLocation());
	}

	protected List<String> getDslUiProjectRequiredBundles() {
		List<String> requiredBundles = Lists.newArrayList(getXtextProjectInfo().getProjectName()
				+ ";visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.xtext.ui", //$NON-NLS-1$
				"org.eclipse.ui.editors;bundle-version=\"3.5.0\"", //$NON-NLS-1$
				"org.eclipse.ui.ide;bundle-version=\"3.5.0\""); //$NON-NLS-1$
		return requiredBundles;
	}

	protected String[] getDslUiProjectNatures() {
		return DSL_UI_PROJECT_NATURES;
	}

	protected IProject createDslProject(final IProgressMonitor monitor) throws CoreException {
		PluginProjectFactory factory = createProjectFactory();
		configureDslProjectFactory(factory);
		return createProject(factory, getDslProjectTemplateName(), monitor);
	}

	protected void configureDslProjectFactory(PluginProjectFactory factory) {
		configureProjectFactory(factory);
		List<String> requiredBundles = getDslProjectRequiredBundles();
		factory.setProjectName(getXtextProjectInfo().getProjectName());
		factory.addProjectNatures(getDslProjectNatures());
		factory.addRequiredBundles(requiredBundles);
		factory.setLocation(getXtextProjectInfo().getProjectLocation());
	}

	protected List<String> getDslProjectRequiredBundles() {
		List<String> requiredBundles = Lists.newArrayList("org.eclipse.xtext", //$NON-NLS-1$
				"org.eclipse.xtext.generator;resolution:=optional", //$NON-NLS-1$
				"de.itemis.xtext.antlr;resolution:=optional", //$NON-NLS-1$
				"org.apache.commons.logging;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.emf.codegen.ecore;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.emf.mwe.utils;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.emf.mwe2.launch;resolution:=optional", //$NON-NLS-1$
				"com.ibm.icu;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.xtext.xtend;resolution:=optional"); //$NON-NLS-1$

		String[] bundles = getXtextProjectInfo().getWizardContribution().getRequiredBundles();
		for (String bundleId : bundles) {
			requiredBundles.add(bundleId.trim() + ";resolution:=optional"); //$NON-NLS-1$
		}
		for(String bundleId: getAdditionalRequiredBundles()) {
			requiredBundles.add(bundleId.trim());
		}
		return requiredBundles;
	}

	protected String[] getDslProjectNatures() {
		return DSL_PROJECT_NATURES;
	}
	
	@Override
	protected PluginProjectFactory configureProjectFactory(ProjectFactory factory) {
		PluginProjectFactory result = (PluginProjectFactory) factory;
		result.addWorkingSets(Arrays.asList(getXtextProjectInfo().getWorkingSets()));
		result.addBuilderIds(getBuilderIDs());
		result.addImportedPackages(getImportedPackages());
		result.addFolders(getAllFolders());
		return result;
	}

	protected String[] getBuilderIDs() {
		return BUILDERS;
	}

	protected IProject createGeneratorProject(final IProgressMonitor monitor) throws CoreException {
		PluginProjectFactory factory = createProjectFactory();
		configureGeneratorProjectBuilder(factory);
		return createProject(factory, getGeneratorProjectTemplateName(), monitor);
	}

	protected void configureGeneratorProjectBuilder(PluginProjectFactory factory) {
		configureProjectFactory(factory);
		List<String> requiredBundles = getGeneratorProjectRequiredBundles();
		factory.setProjectName(getXtextProjectInfo().getGeneratorProjectName());
		factory.addProjectNatures(getGeneratorProjectNatures());
		factory.addRequiredBundles(requiredBundles);
		factory.setLocation(getXtextProjectInfo().getGeneratorProjectLocation());
	}

	protected List<String> getGeneratorProjectRequiredBundles() {
		List<String> requiredBundles = Lists.newArrayList(
				getXtextProjectInfo().getProjectName() + ";visibility:=reexport", 
				"org.eclipse.xpand;visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.xtend;visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.xtext;visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.emf.mwe2.launch;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.emf.mwe.utils;visibility:=reexport",//$NON-NLS-1$
				"org.eclipse.xtend.typesystem.emf;visibility:=reexport"); //$NON-NLS-1$
		return requiredBundles;
	}

	protected String[] getGeneratorProjectNatures() {
		return GENERATOR_PROJECT_NATURES;
	}

	protected IProject createProject(ProjectFactory factory, String templateName,
			final IProgressMonitor monitor) throws CoreException {
		IProject result = factory.createProject(monitor, null);
		if (result == null) {
			return null;
		}

		IFolder srcFolder = (IFolder) result.findMember(getModelFolderName());

		OutputImpl output = new OutputImpl();
		output.addOutlet(new Outlet(false, getEncoding(), null, true, srcFolder.getLocation().makeAbsolute()
				.toOSString()));

		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null);
		execCtx.getResourceManager().setFileEncoding("iso-8859-1"); //$NON-NLS-1$
		execCtx.registerMetaModel(new JavaBeansMetaModel());

		// generate generator and activator for dsl and dsl.ui project
		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate(templateName, getXtextProjectInfo());

		// refresh folder and select file to edit
		result.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		return result;
	}

	protected String pathToTemplates() {
		return "org::eclipse::xtext::xtext::ui::wizard::project::"; //$NON-NLS-1$
	}

	protected String getDslProjectTemplateName() {
		return pathToTemplates() + "DslProject::main";
	}

	protected String getDslUiProjectTemplateName() {
		return pathToTemplates() + "DslUiProject::main";
	}

	protected String getGeneratorProjectTemplateName() {
		return pathToTemplates() + "GeneratorProject::main";
	}
	
	protected List<String> getImportedPackages() {
		return Lists.newArrayList("org.apache.log4j");
	}
	
	protected Collection<String> getAdditionalRequiredBundles() {
		return Collections.emptyList();
	}

	@Override
	protected String getModelFolderName() {
		return SRC_ROOT;
	}

	@Override
	protected List<String> getAllFolders() {
		return SRC_FOLDER_LIST;
	}
}
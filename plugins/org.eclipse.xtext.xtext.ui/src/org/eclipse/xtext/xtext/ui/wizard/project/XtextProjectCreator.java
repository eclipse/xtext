/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import static java.util.Collections.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.FeatureProjectFactory;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor;
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

	protected static final String[] DSL_PROJECT_NATURES = new String[] { JavaCore.NATURE_ID,
			"org.eclipse.pde.PluginNature", //$NON-NLS-1$
			XtextProjectHelper.NATURE_ID //$NON-NLS-1$
	};

	protected static final String[] DSL_UI_PROJECT_NATURES = new String[] { JavaCore.NATURE_ID,
			"org.eclipse.pde.PluginNature" //$NON-NLS-1$
	};

	protected static final String[] BUILDERS = new String[] { JavaCore.BUILDER_ID, "org.eclipse.pde.ManifestBuilder", //$NON-NLS-1$
			"org.eclipse.pde.SchemaBuilder", //$NON-NLS-1$
			XtextProjectHelper.BUILDER_ID };

	protected static final String[] GENERATOR_PROJECT_NATURES = DSL_UI_PROJECT_NATURES;
	protected static final String[] TEST_PROJECT_NATURES = DSL_UI_PROJECT_NATURES;

	protected static final String SRC_GEN_ROOT = "src-gen"; //$NON-NLS-1$
	protected static final String SRC_ROOT = "src"; //$NON-NLS-1$
	protected static final String XTEND_GEN_ROOT = "xtend-gen"; //$NON-NLS-1$
	protected static final List<String> SRC_FOLDER_LIST = ImmutableList.of(SRC_ROOT, SRC_GEN_ROOT);

	@Inject
	private Provider<PluginProjectFactory> projectFactoryProvider;
	@Inject
	private Provider<FeatureProjectFactory> featureProjFactoryProvider;

	protected XtextProjectInfo getXtextProjectInfo() {
		return (XtextProjectInfo) getProjectInfo();
	}

	@Override
	protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
			InterruptedException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, getCreateModelProjectMessage(), getMonitorTicks());

		IProject project = createDslProject(subMonitor.newChild(1));
		createDslUiProject(subMonitor.newChild(1));

		if (getXtextProjectInfo().isCreateTestProject()) {
			createTestProject(subMonitor.newChild(1));
		}
		if (getXtextProjectInfo().isCreateFeatureProject()) {
			createFeatureProject(subMonitor.newChild(1));
		}

		IFile dslGrammarFile = project.getFile(getModelFolderName() + "/" + getXtextProjectInfo().getGrammarFilePath());
		BasicNewResourceWizard.selectAndReveal(dslGrammarFile, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		setResult(dslGrammarFile);
	}

	protected int getMonitorTicks() {
		int ticks = 2;
		ticks = getXtextProjectInfo().isCreateTestProject() ? ticks + 1 : ticks;
		if (getXtextProjectInfo().isCreateFeatureProject()) {
			ticks++;
		}
		return ticks;
	}

	@Override
	protected PluginProjectFactory createProjectFactory() {
		return projectFactoryProvider.get();
	}

	protected FeatureProjectFactory createFeatureFactory() {
		return featureProjFactoryProvider.get();
	}

	@Override
	protected String getCreateModelProjectMessage() {
		return Messages.XtextProjectCreator_CreatingProjectsMessage2 + getXtextProjectInfo().getProjectName();
	}

	protected IProject createDslUiProject(final IProgressMonitor monitor) throws CoreException {
		PluginProjectFactory factory = createProjectFactory();
		configureDslUiProjectFactory(factory);
		return factory.createProject(monitor, null);
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
		return factory.createProject(monitor, null);
	}

	protected void configureDslProjectFactory(PluginProjectFactory factory) {
		configureProjectFactory(factory);
		factory.addFolders(singletonList(XTEND_GEN_ROOT));
		List<String> requiredBundles = getDslProjectRequiredBundles();
		factory.setProjectName(getXtextProjectInfo().getProjectName());
		factory.addProjectNatures(getDslProjectNatures());
		factory.addRequiredBundles(requiredBundles);
		factory.setLocation(getXtextProjectInfo().getDslProjectLocation());
		factory.addContributor(createDslProjectContributor());
	}

	/*
	 * WARNING!!! Before changing here something, look at the commit history and read following bug reports.
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=339004
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=370411
	 */
	protected List<String> getDslProjectRequiredBundles() {
		List<String> requiredBundles = Lists.newArrayList("org.eclipse.xtext;visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.xtext.xbase;resolution:=optional;visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.xtext.generator;resolution:=optional", //$NON-NLS-1$
				"org.apache.commons.logging;bundle-version=\"1.0.4\";resolution:=optional", //$NON-NLS-1$
				"org.eclipse.emf.codegen.ecore;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.emf.mwe.utils;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.emf.mwe2.launch;resolution:=optional"); //$NON-NLS-1$

		String[] bundles = getXtextProjectInfo().getWizardContribution().getRequiredBundles();
		for (String bundleId : bundles) {
			requiredBundles.add(bundleId.trim() + ";resolution:=optional"); //$NON-NLS-1$
		}
		for (String bundleId : getAdditionalRequiredBundles()) {
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

	protected String[] getTestProjectNatures() {
		return TEST_PROJECT_NATURES;
	}

	protected IProject createTestProject(final IProgressMonitor monitor) throws CoreException {
		PluginProjectFactory factory = createProjectFactory();
		configureTestProjectFactory(factory);
		factory.addContributor(createTestProjectContributor());
		return factory.createProject(monitor, null);
	}

	private TestProjectContributor createTestProjectContributor() {
		return new TestProjectContributor(getXtextProjectInfo());
	}

	protected IProject createFeatureProject(SubMonitor monitor) throws CoreException {
		FeatureProjectFactory factory = createFeatureFactory();
		configureFeatureProjectFactory(factory);
		return factory.createProject(monitor, null);
	}

	protected void configureFeatureProjectFactory(FeatureProjectFactory factory) {
		factory.setProjectName(getXtextProjectInfo().getFeatureProjectName());
		factory.setLocation(getXtextProjectInfo().getFeatureProjectLocation());
		factory.setFeatureLabel(String.format(Messages.XtextProjectCreator_FeatureLabel, getXtextProjectInfo()
				.getLanguageNameAbbreviation()));
		factory.addProjectNatures("org.eclipse.pde.FeatureNature");
		factory.addBuilderIds("org.eclipse.pde.FeatureBuilder");
		factory.addBundle(getXtextProjectInfo().getProjectName());
		factory.addBundle(getXtextProjectInfo().getUiProjectName());
		factory.addWorkingSets(Arrays.asList(getXtextProjectInfo().getWorkingSets()));
	}

	protected void configureTestProjectFactory(PluginProjectFactory factory) {
		configureProjectFactory(factory);
		List<String> requiredBundles = getTestProjectRequiredBundles();
		factory.setProjectName(getXtextProjectInfo().getTestProjectName());
		factory.addProjectNatures(getTestProjectNatures());
		factory.addRequiredBundles(requiredBundles);
		factory.addImportedPackages(getTestProjectImportedPackages());
		factory.setLocation(getXtextProjectInfo().getTestProjectLocation());
	}

	protected List<String> getTestProjectImportedPackages() {
		return Lists
				.newArrayList("org.junit;version=\"4.5.0\"", "org.junit.runner;version=\"4.5.0\"",
						"org.junit.runner.manipulation;version=\"4.5.0\"",
						"org.junit.runner.notification;version=\"4.5.0\"", "org.junit.runners;version=\"4.5.0\"",
						"org.junit.runners.model;version=\"4.5.0\"", "org.hamcrest.core");
	}

	protected List<String> getTestProjectRequiredBundles() {
		List<String> requiredBundles = Lists.newArrayList(getXtextProjectInfo().getProjectName(), getXtextProjectInfo()
				.getUiProjectName(), "org.eclipse.core.runtime", //$NON-NLS-1$
				"org.eclipse.xtext.junit4", //$NON-NLS-1$
				"org.eclipse.ui.workbench;resolution:=optional" //$NON-NLS-1$
		); //$NON-NLS-1$
		return requiredBundles;
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

	protected IProjectFactoryContributor createDslProjectContributor() {
		DslProjectContributor dslProjectContributor = new DslProjectContributor(getXtextProjectInfo());
		dslProjectContributor.setSourceRoot(SRC_ROOT);
		return dslProjectContributor;
	}
}
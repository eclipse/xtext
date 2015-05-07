/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.xtext.ui.util.IProjectFactoryContributor;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.ui.wizard.AbstractProjectCreator;

import com.google.common.base.Charsets;
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
			"org.eclipse.pde.PluginNature", //$NON-NLS-1$
			XtextProjectHelper.NATURE_ID };

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
	private Provider<ProjectFactory> plainProjectFactoryProvider;

	@Override
	protected XtextProjectInfo getProjectInfo() {
		return (XtextProjectInfo) super.getProjectInfo();
	}

	@Override
	protected void execute(final IProgressMonitor monitor)
			throws CoreException, InvocationTargetException, InterruptedException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, getCreateModelProjectMessage(), getMonitorTicks());

		IProject project = createDslProject(subMonitor.newChild(1));
		if (getProjectInfo().isCreateUiProject()) {
			createDslUiProject(subMonitor.newChild(1));
		}
		if (getProjectInfo().isCreateTestProject()) {
			createTestProject(subMonitor.newChild(1));
		}
		if (getProjectInfo().isCreateIdeProject()) {
			createIdeProject(subMonitor.newChild(1));
		}
		if (getProjectInfo().isCreateIntellijProject()) {
			createIntellijProject(subMonitor.newChild(1));
		}
		if (getProjectInfo().isCreateWebProject()) {
			createWebProject(subMonitor.newChild(1));
		}

		IFile dslGrammarFile = project.getFile(getModelFolderName() + "/" + getProjectInfo().getGrammarFilePath());
		BasicNewResourceWizard.selectAndReveal(dslGrammarFile, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		setResult(dslGrammarFile);
	}

	protected int getMonitorTicks() {
		int ticks = 2;
		ticks = getProjectInfo().isCreateTestProject() ? ticks + 1 : ticks;
		return ticks;
	}

	@Override
	protected PluginProjectFactory createProjectFactory() {
		return projectFactoryProvider.get();
	}

	@Override
	protected String getCreateModelProjectMessage() {
		return Messages.XtextProjectCreator_CreatingProjectsMessage2 + getProjectInfo().getProjectName();
	}

	protected IProject createDslUiProject(final IProgressMonitor monitor) throws CoreException {
		PluginProjectFactory factory = createProjectFactory();
		configureDslUiProjectFactory(factory);
		return factory.createProject(monitor, null);
	}

	protected void configureDslUiProjectFactory(PluginProjectFactory factory) {
		configureProjectFactory(factory);
		factory.addFolders(singletonList(XTEND_GEN_ROOT));
		List<String> requiredBundles = getDslUiProjectRequiredBundles();
		if (getProjectInfo().isCreateIdeProject()) {
			requiredBundles.add(getProjectInfo().getIdeProjectName());
		}
		factory.setProjectName(getProjectInfo().getUiProjectName());
		factory.addProjectNatures(getDslUiProjectNatures());
		factory.addRequiredBundles(requiredBundles);
		factory.setLocation(getProjectInfo().getUiProjectLocation());
	}

	protected List<String> getDslUiProjectRequiredBundles() {
		List<String> requiredBundles = Lists.newArrayList(getProjectInfo().getProjectName() + ";visibility:=reexport", //$NON-NLS-1$
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
		factory.setProjectName(getProjectInfo().getProjectName());
		factory.addProjectNatures(getDslProjectNatures());
		factory.addRequiredBundles(getDslProjectRequiredBundles());
		factory.addDevelopmentTimeBundles(getDslProjectDevelopmentBundles());
		factory.setLocation(getProjectInfo().getDslProjectLocation());
		factory.addContributor(createDslProjectContributor());
	}

	/*
	 * WARNING!!! Before changing here something, look at the commit history and read following bug reports.
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=446253 - org.eclipse.equinox.common
	 */
	protected List<String> getDslProjectRequiredBundles() {
		List<String> requiredBundles = Lists.newArrayList("org.eclipse.xtext;visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.equinox.common;bundle-version=\"3.5.0\""); //$NON-NLS-1$
		for (String bundleId : getAdditionalRequiredBundles()) {
			requiredBundles.add(bundleId.trim());
		}
		if (getProjectInfo().isCreateIntellijProject()) {
			requiredBundles.add("org.eclipse.xtext.idea.generator");
		}
		if (getProjectInfo().isCreateWebProject()) {
			requiredBundles.add("org.eclipse.xtext.web.generator");
		}
		return requiredBundles;
	}

	/* WARNING!!! Before changing here something, look at the commit history and read following bug reports.
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=339004 - o.a.commons.logging
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=370411 - org.apache.commons.logging & slf4j pack import
	 */
	protected List<String> getDslProjectDevelopmentBundles() {
		return Lists.newArrayList("org.eclipse.xtext.xbase", "org.eclipse.xtext.generator",
				"org.apache.commons.logging", "org.eclipse.emf.codegen.ecore", "org.eclipse.emf.mwe.utils",
				"org.eclipse.emf.mwe2.launch", "org.eclipse.xtext.common.types", "org.objectweb.asm");
	}

	protected String[] getDslProjectNatures() {
		return DSL_PROJECT_NATURES;
	}

	@Override
	protected PluginProjectFactory configureProjectFactory(ProjectFactory factory) {
		PluginProjectFactory result = (PluginProjectFactory) factory;
		result.addWorkingSets(Lists.newArrayList(getProjectInfo().getWorkingSets()));
		result.addBuilderIds(getBuilderIDs());
		result.addImportedPackages(getImportedPackages());
		result.addFolders(getAllFolders());
		result.setProjectDefaultCharset(Charsets.UTF_8.name());
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
		return new TestProjectContributor(getProjectInfo());
	}

	protected void configureTestProjectFactory(PluginProjectFactory factory) {
		configureProjectFactory(factory);
		factory.addFolders(singletonList(XTEND_GEN_ROOT));
		List<String> requiredBundles = getTestProjectRequiredBundles();
		factory.setProjectName(getProjectInfo().getTestProjectName());
		factory.addProjectNatures(getTestProjectNatures());
		factory.addRequiredBundles(requiredBundles);
		factory.addImportedPackages(getTestProjectImportedPackages());
		factory.setLocation(getProjectInfo().getTestProjectLocation());
	}

	protected List<String> getTestProjectImportedPackages() {
		return Lists.newArrayList("org.junit;version=\"4.5.0\"", "org.junit.runner;version=\"4.5.0\"",
				"org.junit.runner.manipulation;version=\"4.5.0\"", "org.junit.runner.notification;version=\"4.5.0\"",
				"org.junit.runners;version=\"4.5.0\"", "org.junit.runners.model;version=\"4.5.0\"",
				"org.hamcrest.core");
	}

	protected List<String> getTestProjectRequiredBundles() {
		List<String> requiredBundles = newArrayList(getProjectInfo().getProjectName(), "org.eclipse.xtext.junit4",
				"org.eclipse.xtext.xbase.lib");
		if (getProjectInfo().isCreateUiProject()) {
			requiredBundles.add(getProjectInfo().getUiProjectName());
			requiredBundles.add("org.eclipse.core.runtime");
			requiredBundles.add("org.eclipse.ui.workbench;resolution:=optional");
		}
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
		DslProjectContributor dslProjectContributor = new DslProjectContributor(getProjectInfo());
		dslProjectContributor.setSourceRoot(SRC_ROOT);
		return dslProjectContributor;
	}

	private IProject createIntellijProject(SubMonitor monitor) {
		ProjectFactory factory = plainProjectFactoryProvider.get();
		factory.setLocation(getProjectInfo().getIdeProjectLocation());
		factory.setProjectName(getProjectInfo().getIntellijProjectName());
		factory.setProjectDefaultCharset(Charsets.UTF_8.name());
		factory.addFolders(getAllFolders());
		factory.addFolders(singletonList(XTEND_GEN_ROOT));
		factory.addWorkingSets(Lists.newArrayList(getProjectInfo().getWorkingSets()));
		factory.addContributor(new IdeaProjectContributor(getProjectInfo()));
		return factory.createProject(monitor, null);
	}

	private IProject createWebProject(SubMonitor monitor) {
		ProjectFactory factory = plainProjectFactoryProvider.get();
		factory.setLocation(getProjectInfo().getWebProjectLocation());
		factory.setProjectName(getProjectInfo().getWebProjectName());
		factory.setProjectDefaultCharset(Charsets.UTF_8.name());
		factory.addFolders(ImmutableList.of("src", "src/main", "src/main/java"));
		factory.addWorkingSets(Lists.newArrayList(getProjectInfo().getWorkingSets()));
		factory.addContributor(new WebProjectContributor(getProjectInfo()));
		return factory.createProject(monitor, null);
	}

	private IProject createIdeProject(SubMonitor monitor) {
		PluginProjectFactory factory = configureProjectFactory(createProjectFactory());
		factory.setLocation(getProjectInfo().getIdeProjectLocation());
		factory.setProjectName(getProjectInfo().getIdeProjectName());
		List<String> requiredBundles = Lists.newArrayList(getProjectInfo().getProjectName(),
				"org.eclipse.xtext.ide;visibility:=reexport");
		factory.addRequiredBundles(requiredBundles);
		factory.addProjectNatures(getDslUiProjectNatures());
		return factory.createProject(monitor, null);
	}
}
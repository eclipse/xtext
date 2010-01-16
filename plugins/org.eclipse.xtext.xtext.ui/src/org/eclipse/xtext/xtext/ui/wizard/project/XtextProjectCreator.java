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
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
import org.eclipse.xtext.builder.nature.XtextNature;
import org.eclipse.xtext.ui.core.util.EclipseResourceUtil;
import org.eclipse.xtext.ui.core.wizard.DefaultProjectCreator;

/**
 * XtextProjectCreator handles the actual creation of the new Xtext project.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class XtextProjectCreator extends DefaultProjectCreator {

	private static final String[] DSL_PROJECT_NATURES = new String[] { 
			JavaCore.NATURE_ID,
			"org.eclipse.pde.PluginNature", //$NON-NLS-1$
			XtextNature.NATURE_ID //$NON-NLS-1$
	};

	private static final String[] DSL_UI_PROJECT_NATURES = new String[] { 
			JavaCore.NATURE_ID,
			"org.eclipse.pde.PluginNature" //$NON-NLS-1$
	};

	private static final String[] GENERATOR_PROJECT_NATURES = DSL_UI_PROJECT_NATURES;

	// some constants
	private static final String SRC_GEN_ROOT = "src-gen"; //$NON-NLS-1$
	private static final String SRC_ROOT = "src"; //$NON-NLS-1$
	private final List<String> SRC_FOLDER_LIST = Collections.unmodifiableList(Arrays.asList(SRC_ROOT, SRC_GEN_ROOT));

	protected XtextProjectInfo getXtextProjectInfo() {
		return (XtextProjectInfo) getProjectInfo();
	}

	@Override
	protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
			InterruptedException {
		SubMonitor subMonitor = SubMonitor.convert(
				monitor, 
				Messages.XtextProjectCreator_CreatingProjectsMessage2 + getXtextProjectInfo().getProjectName(), 
				getXtextProjectInfo().isCreateGeneratorProject() ? 3 : 2);

		IProject project = createDslProject(subMonitor.newChild(1));

		createDslUiProject(subMonitor.newChild(1));

		if (getXtextProjectInfo().isCreateGeneratorProject()) {
			createGeneratorProject(subMonitor.newChild(1));
		}

		IFile dslGrammarFile = project.getFile(new Path(SRC_ROOT
				+ "/" + getXtextProjectInfo().getLanguageName().replace('.', '/') //$NON-NLS-1$
				+ ".xtext")); //$NON-NLS-1$
		BasicNewResourceWizard.selectAndReveal(dslGrammarFile, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		setResult(dslGrammarFile);
	}

	private IProject createDslUiProject(final IProgressMonitor monitor) throws CoreException {
		
		String projectName = getXtextProjectInfo().getUiProjectName();

		LinkedHashSet<String> requiredBundles = new LinkedHashSet<String>(Arrays.asList(getXtextProjectInfo()
				.getProjectName().toLowerCase()
				+ ";visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.xtext.ui.core", "org.eclipse.xtext.ui.common", //$NON-NLS-1$ //$NON-NLS-2$
				"org.eclipse.ui.editors;bundle-version=\"3.5.0\"", //$NON-NLS-1$
				"org.eclipse.ui.ide;bundle-version=\"3.5.0\"")); //$NON-NLS-1$

		String templateName = pathToTemplates() + "DslUiProject::main"; //$NON-NLS-1$

		return createProject(getXtextProjectInfo(), projectName, DSL_UI_PROJECT_NATURES, requiredBundles, 
				Collections.singletonList("org.apache.log4j"), SRC_FOLDER_LIST, templateName, monitor);
	}

	private IProject createDslProject(final IProgressMonitor monitor) throws CoreException {
		String projectName = getXtextProjectInfo().getProjectName();

		LinkedHashSet<String> requiredBundles = new LinkedHashSet<String>(Arrays.asList("org.eclipse.xtext", //$NON-NLS-1$
				"org.eclipse.xtext.generator;resolution:=optional", //$NON-NLS-1$
				"de.itemis.xtext.antlr;resolution:=optional", //$NON-NLS-1$
				"org.apache.commons.logging;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.emf.codegen.ecore;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.emf.mwe.utils;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.emf.mwe.core;resolution:=optional", //$NON-NLS-1$
				"com.ibm.icu;resolution:=optional", //$NON-NLS-1$
				"org.eclipse.xtext.xtend;resolution:=optional")); //$NON-NLS-1$

		String[] bundles = getXtextProjectInfo().getWizardContribution().getRequiredBundles();
		for (String bundleId : bundles) {
			requiredBundles.add(bundleId.trim() + ";resolution:=optional"); //$NON-NLS-1$
		}

		String templateName = pathToTemplates() + "DslProject::main"; //$NON-NLS-1$
		return createProject(getXtextProjectInfo(), projectName, DSL_PROJECT_NATURES, requiredBundles, 
				Collections.singletonList("org.apache.log4j"), SRC_FOLDER_LIST, templateName, monitor);
	}

	private IProject createGeneratorProject(final IProgressMonitor monitor) throws CoreException {
		String projectName = getXtextProjectInfo().getGeneratorProjectName();

		LinkedHashSet<String> requiredBundles = new LinkedHashSet<String>(Arrays.asList(getXtextProjectInfo()
				.getProjectName().toLowerCase()
				+ ";visibility:=reexport", "org.eclipse.xpand;visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.xtend;visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.xtext;visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.emf.mwe.core;visibility:=reexport", //$NON-NLS-1$
				"org.eclipse.emf.mwe.utils;visibility:=reexport",//$NON-NLS-1$
				"org.eclipse.xtend.typesystem.emf;visibility:=reexport")); //$NON-NLS-1$

		String templateName = pathToTemplates() + "GeneratorProject::main"; //$NON-NLS-1$

		return createProject(getXtextProjectInfo(), projectName, GENERATOR_PROJECT_NATURES, requiredBundles,
				Collections.singletonList("org.apache.log4j"), SRC_FOLDER_LIST, templateName, monitor);
	}

	private IProject createProject(XtextProjectInfo xtextProjectInfo, String projectName, String[] projectNatures,
			Set<String> requiredBundles, List<String> importPackages, List<String> srcFolderList, String templateName,
			final IProgressMonitor monitor) throws CoreException {
		monitor.beginTask(Messages.XtextProjectCreator_CreatingProjectsMessage + projectName, 3);
		final IProject dslProject = EclipseResourceUtil.createProject(projectName, xtextProjectInfo.getLocation(),
				srcFolderList, Collections.<IProject> emptyList(), requiredBundles, null, importPackages, null,
				monitor, null, projectNatures, xtextProjectInfo.getWorkingSets(), xtextProjectInfo.getWorkbench());

		if (dslProject == null) {
			return null;
		}

		IFolder srcFolder = (IFolder) dslProject.findMember(srcFolderList.get(0));

		OutputImpl output = new OutputImpl();
		output.addOutlet(new Outlet(false, getEncoding(), null, true, srcFolder.getLocation().makeAbsolute()
				.toOSString()));

		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null);
		execCtx.getResourceManager().setFileEncoding("iso-8859-1"); //$NON-NLS-1$
		execCtx.registerMetaModel(new JavaBeansMetaModel());

		// generate generator and activator for dsl and dsl.ui project
		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate(templateName, xtextProjectInfo);

		monitor.worked(1);

		// refresh folder and select file to edit
		dslProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);

		monitor.worked(1);

		return dslProject;
	}

	private String pathToTemplates() {
		return "org::eclipse::xtext::xtext::ui::wizard::project::"; //$NON-NLS-1$
	}

}
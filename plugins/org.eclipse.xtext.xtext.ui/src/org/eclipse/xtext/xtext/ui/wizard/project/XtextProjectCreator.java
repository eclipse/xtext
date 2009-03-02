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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.internal.xtend.type.impl.java.JavaMetaModel;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtext.ui.core.util.EclipseResourceUtil;
import org.eclipse.xtext.ui.core.wizard.DefaultProjectCreator;

public class XtextProjectCreator extends DefaultProjectCreator {

	// some constants
	private static final String SRC_GEN_ROOT = "src-gen";
	private static final String SRC_ROOT = "src";
	private final List<String> SRC_FOLDER_LIST = Collections.unmodifiableList(Arrays.asList(SRC_ROOT, SRC_GEN_ROOT));

	protected XtextProjectInfo getXtextProjectInfo() {
		return (XtextProjectInfo) getProjectInfo();
	}

	@Override
	protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
			InterruptedException {
		monitor.beginTask("Creating dsl projects " + getXtextProjectInfo().getProjectName(), 3);

		String basePackage = getXtextProjectInfo().getBasePackage();
		// DSL Project
		List<String> exportedPackages = Arrays.asList(basePackage, basePackage + ".services");
		final IProject dslProject = EclipseResourceUtil
				.createProject(getXtextProjectInfo().getProjectName(), SRC_FOLDER_LIST, Collections
						.<IProject> emptyList(), new LinkedHashSet<String>(Arrays.asList(
						"org.eclipse.xtext.generator;resolution:=optional",
						"org.eclipse.xtext.ui.generator;resolution:=optional",
						"de.itemis.xtext.antlr;resolution:=optional",
						"org.apache.commons.logging;resolution:=optional",
						"org.eclipse.emf.codegen.ecore;resolution:=optional",
						"org.eclipse.xtext.log4j;resolution:=optional",
						"org.eclipse.emf.mwe.utils;resolution:=optional")), exportedPackages, null, null, monitor, null);

		if (dslProject == null) {
			return;
		}

		EclipseResourceUtil.createPackagesWithDummyClasses(dslProject, "src-gen", exportedPackages);
		monitor.worked(1);

		// DSL UI Project
		final IProject dslUIProject = EclipseResourceUtil.createProject(getXtextProjectInfo().getProjectName() + ".ui",
				SRC_FOLDER_LIST, Collections.<IProject> emptyList(), new LinkedHashSet<String>(Arrays.asList(
						getXtextProjectInfo().getProjectName().toLowerCase() + ";visibility:=reexport",
						"org.eclipse.xtext.ui.core", "org.eclipse.xtext.ui.common",
						"org.eclipse.xtext.log4j;bundle-version=\"1.2.15\"",
						"org.eclipse.ui.editors;bundle-version=\"3.4.0\"",
						"org.eclipse.ui.ide;bundle-version=\"3.4.0\"")), null, null, null, monitor, null);

		if (dslUIProject == null) {
			return;
		}
		monitor.worked(1);

		// Generator Project
		IProject dslGeneratorProject = null;
		if (getXtextProjectInfo().isCreateGeneratorProject()) {
			dslGeneratorProject = EclipseResourceUtil.createProject(getXtextProjectInfo().getGeneratorProjectName(),
					SRC_FOLDER_LIST, Collections.<IProject> emptyList(), new LinkedHashSet<String>(Arrays.asList(
							getXtextProjectInfo().getProjectName().toLowerCase(), "org.eclipse.xpand",
							"org.eclipse.xtend", "org.eclipse.xtend.typesystem.emf")),
					Collections.<String> emptyList(), null, null, monitor, null);

			if (dslGeneratorProject == null) {
				return;
			}
		}
		monitor.worked(1);

		IFolder basePackageFolder = createSubPackages(basePackage, dslProject, (IFolder) dslProject
				.findMember(SRC_ROOT), monitor);

		OutputImpl output = new OutputImpl();
		String defaultEncoding = System.getProperty("file.encoding");
		output.addOutlet(new Outlet(false, defaultEncoding, "GRAMMAR_GENERATOR_OUTLET", true, basePackageFolder
				.getLocation().makeAbsolute().toOSString()));
		if (dslGeneratorProject != null) {
			output.addOutlet(new Outlet(false, defaultEncoding, "GENERATOR_OUTLET", true, createSubPackages(
					basePackage, dslGeneratorProject, (IFolder) dslGeneratorProject.findMember(SRC_ROOT), monitor)
					.getLocation().makeAbsolute().toOSString()));
			EclipseResourceUtil.createFile("Model." + getXtextProjectInfo().getFirstFileExtension(), createSubPackages(
					"model", dslGeneratorProject, (IFolder) dslGeneratorProject.findMember(SRC_ROOT), monitor),
					"//Your model\n" + "foo test\n bar test2", monitor);
			EclipseResourceUtil.createFile("Template.xpt", createSubPackages("templates", dslGeneratorProject,
					(IFolder) dslGeneratorProject.findMember(SRC_ROOT), monitor), "«DEFINE root FOR myDsl::Model»\n"
					+ "«FILE \"output.txt\"»\n" + "«FOREACH this.elements AS e»\n" + "«e.name» («e.metaType»)\n"
					+ "«ENDFOREACH»\n" + "«ENDFILE»\n" + "«ENDDEFINE»\n", monitor);
		}
		// output.addOutlet(new Outlet(false, defaultEncoding,
		// "ACTIVATOR_OUTLET", true,
		// dslUIProject.getFolder(
		// SRC_ROOT + IPath.SEPARATOR +
		// getXtextProjectInfo().getBasePackagePath() + IPath.SEPARATOR + "ui"
		// ).getLocation().makeAbsolute().toOSString()));
		// output.addOutlet(new Outlet(false, defaultEncoding,
		// "ACTIVATOR_GEN_OUTLET", true,
		// dslUIProject.getFolder(
		// SRC_GEN_ROOT + IPath.SEPARATOR +
		// getXtextProjectInfo().getBasePackagePath() + IPath.SEPARATOR + "ui" +
		// IPath.SEPARATOR + "internal"
		// ).getLocation().makeAbsolute().toOSString()));
		// output.addOutlet(new Outlet(false, defaultEncoding, "SETUP_OUTLET",
		// true,
		// dslProject.getFolder(
		// SRC_GEN_ROOT + IPath.SEPARATOR +
		// getXtextProjectInfo().getBasePackagePath()
		// ).getLocation().makeAbsolute().toOSString()));
		// output.addOutlet(new Outlet(false, defaultEncoding,
		// "SETUP_UI_OUTLET", true,
		// dslUIProject.getFolder(
		// SRC_ROOT + IPath.SEPARATOR +
		// getXtextProjectInfo().getBasePackagePath()
		// ).getLocation().makeAbsolute().toOSString()));
		// output.addOutlet(new Outlet(false, defaultEncoding,
		// "WIZARD_UI_OUTLET", true,
		// dslUIProject.getFolder(
		// SRC_ROOT + IPath.SEPARATOR +
		// getXtextProjectInfo().getBasePackagePath() + IPath.SEPARATOR +
		// "wizard"
		// ).getLocation().makeAbsolute().toOSString()));
		// output.addOutlet(new Outlet(false, defaultEncoding,
		// "PLUGIN_XMI_UI_OUTLET", true,
		// dslUIProject.getLocation().makeAbsolute().toOSString()));
		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null);
		execCtx.registerMetaModel(new JavaMetaModel());

		// generate generator and activator for dsl and dsl.ui project
		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate("org::eclipse::xtext::xtext::ui::wizard::project::XtextTemplateFile::root",
				getXtextProjectInfo());
		facade.evaluate("org::eclipse::xtext::xtext::ui::wizard::project::GrammarGenerator::root",
				getXtextProjectInfo());
		// if (dslGeneratorProject != null)
		// facade.evaluate("org::eclipse::xtext::xtext::ui::wizard::project::Generator::root",
		// getXtextProjectInfo());
		// facade.evaluate("org::eclipse::xtext::xtext::ui::wizard::project::Activator::root",
		// getXtextProjectInfo());
		// facade.evaluate("org::eclipse::xtext::xtext::ui::wizard::project::Setup::root",
		// getXtextProjectInfo());
		// facade.evaluate("org::eclipse::xtext::xtext::ui::wizard::project::Wizard::root",
		// getXtextProjectInfo());
		// facade.evaluate("org::eclipse::xtext::xtext::ui::wizard::project::UIPlugin::root",
		// getXtextProjectInfo());

		monitor.worked(1);

		// refresh folder and select file to edit
		if (dslProject != null) {
			dslProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		}
		if (dslGeneratorProject != null) {
			dslGeneratorProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		}
		if (dslUIProject != null) {
			dslUIProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		}
		IFile dslGrammarFile = getDslGrammarFile(basePackageFolder);
		BasicNewResourceWizard.selectAndReveal(dslGrammarFile, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		setResult(dslGrammarFile);
	}

	private IFile getDslGrammarFile(IFolder folder) throws CoreException {
		for (IResource resource : folder.members()) {
			if (!"java".equals(resource.getFileExtension())) {
				return (IFile) resource;
			}
		}
		throw new IllegalStateException("No xtext file was found in folder '" + folder.toString() + "'!");
	}

	private IFolder createSubPackages(String basePackage, final IProject project, final IFolder srcFolder,
			final IProgressMonitor monitor) throws CoreException {
		IFolder srcFolderToUse = srcFolder;
		for (String packageName : basePackage.split("\\.")) {
			srcFolderToUse = project.getFolder(srcFolderToUse.getProjectRelativePath().toString() + IPath.SEPARATOR
					+ packageName);
			srcFolderToUse.create(true, true, new SubProgressMonitor(monitor, 1));
		}
		return srcFolderToUse;
	}

}
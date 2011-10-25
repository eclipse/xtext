/*******************************************************************************
 * Copyright (c) 2009 Dakshinamurthy Karra, itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dakshinamurthy Karra (Jalian Systems)
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.ui.wizard.XtextNewProjectWizard;
import org.eclipse.xtext.xtext.ui.Activator;

import com.google.inject.Inject;

/**
 * A project wizard to create Xtext projects.
 * 
 * @author KD - Initial contribution and API
 * @author Sven Efftinge
 * @author Michael Clay
 */
public class NewXtextProjectWizard extends XtextNewProjectWizard {

	private WizardNewXtextProjectCreationPage mainPage;

	/**
	 * Constructs a new wizard
	 */
	@Inject
	public NewXtextProjectWizard(IProjectCreator projectCreator) {
		super(projectCreator);
		setWindowTitle(Messages.NewXtextProjectWizard_WindowTitle);
		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/wizban/newxprj_wiz.png")); //$NON-NLS-1$
	}

	@Override
	public void addPages() {
		super.addPages();
		mainPage = new WizardNewXtextProjectCreationPage("mainPage", this.selection); //$NON-NLS-1$
		addPage(mainPage);
	}

	@Override
	protected IProjectInfo getProjectInfo() {
		XtextProjectInfo projectInfo = createProjectInfo();
		projectInfo.setCreateTestProject(true);
		projectInfo.setFileExtension(mainPage.getFileExtensions());
		projectInfo.setLanguageName(mainPage.getLanguageName());
		projectInfo.setProjectName(mainPage.getProjectName());
		projectInfo.setWorkingSets(mainPage.getSelectedWorkingSets());
		Map<String, WizardContribution> contributions = WizardContribution.getFromRegistry();
		projectInfo.setWizardContribution(contributions.get(mainPage.getGeneratorConfig()));
		projectInfo.setProjectLocation(new Path(mainPage.getLocationURI().getPath()));
		projectInfo.setWorkbench(getWorkbench());
		projectInfo.setCreateEclipseRuntimeLaunchConfig(!existsEclipseRuntimeLaunchConfig());
		String encoding = null;
		try {
			encoding = ResourcesPlugin.getWorkspace().getRoot().getDefaultCharset();
		}
		catch (final CoreException e) {
			encoding = System.getProperty("file.encoding");
		}
		projectInfo.setEncoding(encoding);
		return projectInfo;
	}

	private boolean existsEclipseRuntimeLaunchConfig() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject p : projects) {
			try {
				if (p.isAccessible() && p.getFile(".launch/Launch Runtime Eclipse.launch").exists())
					return true;
			} catch (Exception e) {
				// ignore
			}
		}
		return false;
	}

	protected XtextProjectInfo createProjectInfo() {
		return new XtextProjectInfo();
	}
	
}
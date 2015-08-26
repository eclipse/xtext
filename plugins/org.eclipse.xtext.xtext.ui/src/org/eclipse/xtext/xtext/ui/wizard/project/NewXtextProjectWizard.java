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

import java.nio.charset.Charset;
import java.util.Arrays;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.ui.wizard.XtextNewProjectWizard;
import org.eclipse.xtext.xtext.ui.Activator;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor.FileExtensions;

import com.google.inject.Inject;

/**
 * A project wizard to create Xtext projects.
 */
public class NewXtextProjectWizard extends XtextNewProjectWizard {

	private WizardNewXtextProjectCreationPage mainPage;
	private AdvancedNewProjectPage advancedPage;

	/**
	 * Constructs a new wizard
	 */
	@Inject
	public NewXtextProjectWizard(IProjectCreator projectCreator) {
		super(projectCreator);
		setWindowTitle(Messages.NewXtextProjectWizard_WindowTitle);
		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/wizban/newxprj_wiz.gif")); //$NON-NLS-1$
	}

	@Override
	public void addPages() {
		super.addPages();
		mainPage = new WizardNewXtextProjectCreationPage("mainPage", this.selection); //$NON-NLS-1$
		advancedPage = new AdvancedNewProjectPage("advancedPage");
		addPage(mainPage);
		addPage(advancedPage);
	}

	@Override
	protected IProjectInfo getProjectInfo() {
		XtextProjectInfo projectInfo = createProjectInfo();
		LanguageDescriptor language = projectInfo.getLanguage();
		language.setFileExtensions(FileExtensions.fromString(mainPage.getFileExtensions()));
		language.setName(mainPage.getLanguageName());
		projectInfo.setBaseName(mainPage.getProjectName());
		projectInfo.setWorkingSets(Arrays.asList(mainPage.getSelectedWorkingSets()));
		projectInfo.setRootLocation(mainPage.getLocationPath().toString());
		Charset encoding = null;
		try {
			encoding = Charset.forName(ResourcesPlugin.getWorkspace().getRoot().getDefaultCharset());
		}
		catch (final CoreException e) {
			encoding = Charset.defaultCharset();
		}
		projectInfo.setEncoding(encoding);
		projectInfo.setWorkbench(getWorkbench());
		BuildSystem buildSystem = advancedPage.getBuildSystem();
		projectInfo.setBuildSystem(buildSystem);
		projectInfo.setSourceLayout(advancedPage.getSourceLayout());
		
		projectInfo.getRuntimeProject().setEnabled(true);
		projectInfo.getUiProject().setEnabled(advancedPage.isCreateUiProject());
		projectInfo.getRuntimeProject().getTestProject().setEnabled(advancedPage.isCreateTestProject());
		projectInfo.getIdeProject().setEnabled(advancedPage.isCreateIdeProject());
		projectInfo.getIntellijProject().setEnabled(advancedPage.isCreateIntellijProject());
		projectInfo.getWebProject().setEnabled(advancedPage.isCreateWebProject());
		if (buildSystem.isMavenBuild() || buildSystem.isGradleBuild()) {
			projectInfo.getParentProject().setEnabled(true);
		}
		if (buildSystem.isPluginBuild() && buildSystem.isMavenBuild()) {
			projectInfo.getTargetPlatformProject().setEnabled(true);
		}
		return projectInfo;
	}

	protected XtextProjectInfo createProjectInfo() {
		return new XtextProjectInfo();
	}
	
}
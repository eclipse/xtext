/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import org.eclipse.xtext.ui.wizard.XtextNewProjectWizard;
import org.eclipse.xtext.xtext.ui.Activator;
import org.eclipse.xtext.xtext.ui.wizard.project.Messages;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class NewRelengProjectWizard extends XtextNewProjectWizard {

	private WizardNewRelengProjectCreationPage mainPage;

	@Inject
	public NewRelengProjectWizard(RelengProjectsCreator creator) {
		super(creator);
		setWindowTitle(Messages.NewRelengProjectWizard_WindowTitle);
		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/wizban/newxprj_wiz.gif")); //$NON-NLS-1$
	}

	@Override
	public void addPages() {
		super.addPages();
		mainPage = new WizardNewRelengProjectCreationPage("relengPage", this.selection); //$NON-NLS-1$
		addPage(mainPage);
	}

	@Override
	protected RelengProjectInfo getProjectInfo() {
		RelengProjectInfo projectInfo = new RelengProjectInfo();
		projectInfo.setNamespace(mainPage.getProjectNameSpace());
		projectInfo.setProjectName(mainPage.getProjectName());
		projectInfo.setBuildFeatureName(mainPage.getMainFeatureProjectName());
		projectInfo.setSiteFeatureName(mainPage.getSiteFeatureProjectName());
		projectInfo.setBuckyLocation(mainPage.getBuckyLocation());
		return projectInfo;
	}

}

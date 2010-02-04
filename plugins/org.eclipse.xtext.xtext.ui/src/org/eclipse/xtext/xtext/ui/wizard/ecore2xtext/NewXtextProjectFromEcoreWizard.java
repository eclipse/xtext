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
package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.xtext.ui.wizard.project.NewXtextProjectWizard;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;

import com.google.inject.Inject;

/**
 * A project wizard to create Xtext projects from given Ecore metamodels.
 * 
 * @author Jan Koehnlein
 */
public class NewXtextProjectFromEcoreWizard extends NewXtextProjectWizard {

	private WizardSelectImportedEPackagePage ePackageSelectionPage;

	/**
	 * Constructs a new wizard
	 */
	@Inject
	public NewXtextProjectFromEcoreWizard(Ecore2XtextProjectCreator creator) {
		super(creator);
		setWindowTitle(Messages.NewXtextProjectFromEcoreWizard_WindowTitle);
	}

	@Override
	public void addPages() {
		ePackageSelectionPage = new WizardSelectImportedEPackagePage("ePackageSelectionPage", selection);
		addPage(ePackageSelectionPage); //$NON-NLS-1$
		super.addPages();
	}

	@Override
	protected IProjectInfo getProjectInfo() {
		Ecore2XtextProjectInfo projectInfo = (Ecore2XtextProjectInfo) super.getProjectInfo();
		projectInfo.setEPackageInfos(ePackageSelectionPage.getEPackageInfos());
		projectInfo.setRootElementClass(ePackageSelectionPage.getRootElementClass());
		projectInfo.setDefaultEPackageInfo(ePackageSelectionPage.getDefaultEPackageInfo());
		return projectInfo;
	}

	@Override
	protected XtextProjectInfo createProjectInfo() {
		return new Ecore2XtextProjectInfo();
	}

}

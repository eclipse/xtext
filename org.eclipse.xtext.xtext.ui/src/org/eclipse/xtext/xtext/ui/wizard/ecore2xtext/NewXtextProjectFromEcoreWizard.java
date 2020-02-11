/*******************************************************************************
 * Copyright (c) 2009 Dakshinamurthy Karra, itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Dakshinamurthy Karra (Jalian Systems)
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.xtext.ui.wizard.project.NewXtextProjectWizard;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;
import org.eclipse.xtext.xtext.wizard.Ecore2XtextConfiguration;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;

import com.google.inject.Inject;

/**
 * A project wizard to create Xtext projects from given Ecore metamodels.
 * 
 * @author Jan Koehnlein
 */
public class NewXtextProjectFromEcoreWizard extends NewXtextProjectWizard {

	private WizardSelectImportedEPackagePage ePackageSelectionPage;
	private final IJdtHelper jdtHelper;

	/**
	 * Constructs a new wizard
	 */
	@Inject
	public NewXtextProjectFromEcoreWizard(XtextProjectCreator creator, IJdtHelper jdtHelper) {
		super(creator);
		this.jdtHelper = jdtHelper;
		setWindowTitle(Messages.NewXtextProjectFromEcoreWizard_WindowTitle);
	}

	@Override
	public void addPages() {
		ePackageSelectionPage = new WizardSelectImportedEPackagePage("ePackageSelectionPage", selection, jdtHelper);
		addPage(ePackageSelectionPage); //$NON-NLS-1$
		super.addPages();
	}

	@Override
	protected IProjectInfo getProjectInfo() {
		XtextProjectInfo projectInfo = (XtextProjectInfo) super.getProjectInfo();
		RuntimeProjectDescriptor runtimeProjectDescriptor = projectInfo.getRuntimeProject();
		runtimeProjectDescriptor.setWithPluginXml(false);
		Ecore2XtextConfiguration ecore2Xtext = projectInfo.getEcore2Xtext();
		ecore2Xtext.getEPackageInfos().addAll(ePackageSelectionPage.getEPackageInfos());
		ecore2Xtext.setRootElementClass(ePackageSelectionPage.getRootElementClass());
		ecore2Xtext.setDefaultEPackageInfo(ePackageSelectionPage.getDefaultEPackageInfo());
		return projectInfo;
	}

}
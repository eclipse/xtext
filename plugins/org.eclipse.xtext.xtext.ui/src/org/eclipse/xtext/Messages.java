/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.osgi.util.NLS;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.messages"; //$NON-NLS-1$
	public static String NewXtextProjectWizard_WindowTitle;
	public static String NewXtextProjectWizardPage_Title;
	public static String NewXtextProjectWizardPage_LanguageMustStartWithPackageName;
	public static String NewXtextProjectWizardPage_LanguageNameMandatory;
	public static String NewXtextProjectWizardPage_InvalidURI;
	public static String NewXtextProjectWizardPage_Description;
	public static String NewXtextProjectWizardPage_MainProjectName;
	public static String NewXtextProjectWizardPage_LanguageName;
	public static String NewXtextProjectWizardPage_LanguageProjectNameDifference;
	public static String NewXtextProjectWizardPage_LastElementMustStartWithUppercase;
	public static String NewXtextProjectWizardPage_FileExtension;
	public static String NewXtextProjectWizardPage_GeneratorProject;
	public static String NewXtextProjectWizardPage_ProjectNameValidationError;
	public static String NewXtextProjectWizardPage_DuplicateProjectName;
	public static String XtextProjectCreator_CreatingProjectsMessage;
	public static String XtextProjectCreator_CreatingProjectsMessage2;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}

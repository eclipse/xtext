/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import org.eclipse.osgi.util.NLS;

/**
 * @author koehnlein - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.messages"; //$NON-NLS-1$
	public static String EPackageChooser_ChooseGenModel;
	public static String EPackageChooser_ErrorFindingGenModels;
	public static String NewXtextProjectFromEcoreWizard_WindowTitle;
	public static String WizardSelectImportedEPackagePage_AddButtonText;
	public static String WizardSelectImportedEPackagePage_ListTitle;
	public static String WizardSelectImportedEPackagePage_RemoveButtonText;
	public static String WizardSelectImportedEPackagePage_WindowTitle;
	public static String WizardSelectImportedEPackagePage_DefaultMarker;
	public static String WizardSelectImportedEPackagePage_Description;
	public static String WizardSelectImportedEPackagePage_entryRuleLabelText;
	public static String WizardSelectImportedEPackagePage_SetDefault;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}

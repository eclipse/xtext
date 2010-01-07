package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.messages"; //$NON-NLS-1$
	public static String NewXtextProjectFromEcoreWizard_WindowTitle;
	public static String WizardSelectImportedEPackagePage_AddButtonText;
	public static String WizardSelectImportedEPackagePage_CheckButtonText;
	public static String WizardSelectImportedEPackagePage_ListTitle;
	public static String WizardSelectImportedEPackagePage_RemoveButtonText;
	public static String WizardSelectImportedEPackagePage_WindowTitle;
	public static String WizardSelectImportedEPackagePage_Description;
	public static String WizardSelectImportedEPackagePage_entryRuleLabelText;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}

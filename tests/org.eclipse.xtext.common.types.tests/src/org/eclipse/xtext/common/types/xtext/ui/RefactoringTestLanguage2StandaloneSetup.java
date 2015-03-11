
package org.eclipse.xtext.common.types.xtext.ui;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class RefactoringTestLanguage2StandaloneSetup extends RefactoringTestLanguage2StandaloneSetupGenerated{

	public static void doSetup() {
		new RefactoringTestLanguage2StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


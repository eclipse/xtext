
package org.eclipse.xtext.common.types.xtext.ui;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class RefactoringTestLanguage1StandaloneSetup extends RefactoringTestLanguage1StandaloneSetupGenerated{

	public static void doSetup() {
		new RefactoringTestLanguage1StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


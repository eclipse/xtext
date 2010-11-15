
package org.eclipse.xtext.ui.tests.refactoring;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class RefactoringTestLanguageStandaloneSetup extends RefactoringTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new RefactoringTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


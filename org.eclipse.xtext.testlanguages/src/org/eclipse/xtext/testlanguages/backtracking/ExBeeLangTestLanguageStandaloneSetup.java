
package org.eclipse.xtext.testlanguages.backtracking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ExBeeLangTestLanguageStandaloneSetup extends ExBeeLangTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ExBeeLangTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


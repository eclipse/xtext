
package org.eclipse.xtext.testlanguages.backtracking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BeeLangTestLanguageStandaloneSetup extends BeeLangTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new BeeLangTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


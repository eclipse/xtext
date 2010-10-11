
package org.eclipse.xtext.testlanguages.backtracking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SimpleBeeLangTestLanguageStandaloneSetup extends SimpleBeeLangTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SimpleBeeLangTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


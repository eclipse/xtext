
package org.eclipse.xtext.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class OptionalEmptyTestLanguageStandaloneSetup extends OptionalEmptyTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new OptionalEmptyTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


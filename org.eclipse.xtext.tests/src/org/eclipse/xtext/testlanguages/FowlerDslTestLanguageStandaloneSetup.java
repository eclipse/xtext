
package org.eclipse.xtext.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class FowlerDslTestLanguageStandaloneSetup extends FowlerDslTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new FowlerDslTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


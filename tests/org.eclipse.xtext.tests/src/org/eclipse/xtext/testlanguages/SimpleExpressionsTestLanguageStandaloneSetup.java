
package org.eclipse.xtext.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SimpleExpressionsTestLanguageStandaloneSetup extends SimpleExpressionsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SimpleExpressionsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


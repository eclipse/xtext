
package org.eclipse.xtext.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ActionTestLanguageStandaloneSetup extends ActionTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ActionTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.generator.ecore;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SuperTestLanguageStandaloneSetup extends SuperTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SuperTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


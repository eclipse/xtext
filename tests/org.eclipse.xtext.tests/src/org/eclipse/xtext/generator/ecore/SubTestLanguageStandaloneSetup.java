
package org.eclipse.xtext.generator.ecore;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SubTestLanguageStandaloneSetup extends SubTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SubTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


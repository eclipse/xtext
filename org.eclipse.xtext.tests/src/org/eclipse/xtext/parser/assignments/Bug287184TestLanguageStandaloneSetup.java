
package org.eclipse.xtext.parser.assignments;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug287184TestLanguageStandaloneSetup extends Bug287184TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug287184TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


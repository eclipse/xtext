
package org.eclipse.xtext.parser.assignments;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug288432TestLanguageStandaloneSetup extends Bug288432TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug288432TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


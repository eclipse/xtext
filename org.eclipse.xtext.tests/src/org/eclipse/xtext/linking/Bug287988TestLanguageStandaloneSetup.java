
package org.eclipse.xtext.linking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug287988TestLanguageStandaloneSetup extends Bug287988TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug287988TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.linking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug289059TestLanguageStandaloneSetup extends Bug289059TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug289059TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


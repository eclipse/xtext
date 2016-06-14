
package org.eclipse.xtext.linking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug313089TestLanguageStandaloneSetup extends Bug313089TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug313089TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


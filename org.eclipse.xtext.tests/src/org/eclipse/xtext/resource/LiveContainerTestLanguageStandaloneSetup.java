
package org.eclipse.xtext.resource;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LiveContainerTestLanguageStandaloneSetup extends LiveContainerTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new LiveContainerTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


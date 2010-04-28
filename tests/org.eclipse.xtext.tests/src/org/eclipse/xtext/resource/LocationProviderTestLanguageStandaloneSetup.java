
package org.eclipse.xtext.resource;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LocationProviderTestLanguageStandaloneSetup extends LocationProviderTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new LocationProviderTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


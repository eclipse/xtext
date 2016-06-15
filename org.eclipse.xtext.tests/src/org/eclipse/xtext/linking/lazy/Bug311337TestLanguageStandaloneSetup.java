
package org.eclipse.xtext.linking.lazy;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug311337TestLanguageStandaloneSetup extends Bug311337TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug311337TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


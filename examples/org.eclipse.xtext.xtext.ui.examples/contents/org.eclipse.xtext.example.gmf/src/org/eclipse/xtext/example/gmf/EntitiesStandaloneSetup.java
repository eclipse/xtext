
package org.eclipse.xtext.example.gmf;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EntitiesStandaloneSetup extends EntitiesStandaloneSetupGenerated{

	public static void doSetup() {
		new EntitiesStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.resource;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class FlatResourceSetBasedAllContainersStateTestLanguageStandaloneSetup extends FlatResourceSetBasedAllContainersStateTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new FlatResourceSetBasedAllContainersStateTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


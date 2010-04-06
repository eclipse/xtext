
package org.eclipse.xtext.example;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DomainmodelStandaloneSetup extends DomainmodelStandaloneSetupGenerated{

	public static void doSetup() {
		new DomainmodelStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.example;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class FowlerDslStandaloneSetup extends FowlerDslStandaloneSetupGenerated{

	public static void doSetup() {
		new FowlerDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


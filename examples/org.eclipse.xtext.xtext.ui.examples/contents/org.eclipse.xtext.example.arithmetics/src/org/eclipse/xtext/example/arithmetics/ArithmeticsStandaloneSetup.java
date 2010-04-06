
package org.eclipse.xtext.example.arithmetics;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ArithmeticsStandaloneSetup extends ArithmeticsStandaloneSetupGenerated{

	public static void doSetup() {
		new ArithmeticsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


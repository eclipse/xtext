
package org.eclipse.xtext.example;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EcoreDslStandaloneSetup extends EcoreDslStandaloneSetupGenerated{

	public static void doSetup() {
		new EcoreDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


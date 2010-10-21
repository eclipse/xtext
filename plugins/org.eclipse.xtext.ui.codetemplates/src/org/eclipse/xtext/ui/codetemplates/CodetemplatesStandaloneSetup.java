
package org.eclipse.xtext.ui.codetemplates;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CodetemplatesStandaloneSetup extends CodetemplatesStandaloneSetupGenerated{

	public static void doSetup() {
		new CodetemplatesStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


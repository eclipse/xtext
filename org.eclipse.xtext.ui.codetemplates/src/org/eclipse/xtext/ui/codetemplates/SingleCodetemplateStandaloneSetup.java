
package org.eclipse.xtext.ui.codetemplates;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SingleCodetemplateStandaloneSetup extends SingleCodetemplateStandaloneSetupGenerated{

	public static void doSetup() {
		new SingleCodetemplateStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.linking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug362902StandaloneSetup extends Bug362902StandaloneSetupGenerated{

	public static void doSetup() {
		new Bug362902StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


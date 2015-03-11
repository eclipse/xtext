
package org.eclipse.xtext.resource;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class Bug385636StandaloneSetup extends Bug385636StandaloneSetupGenerated{

	public static void doSetup() {
		new Bug385636StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

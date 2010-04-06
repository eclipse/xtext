
package org.eclipse.xtext.parsetree.impl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug305397StandaloneSetup extends Bug305397StandaloneSetupGenerated{

	public static void doSetup() {
		new Bug305397StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


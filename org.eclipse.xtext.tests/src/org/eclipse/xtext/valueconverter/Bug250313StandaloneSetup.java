
package org.eclipse.xtext.valueconverter;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug250313StandaloneSetup extends Bug250313StandaloneSetupGenerated{

	public static void doSetup() {
		new Bug250313StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


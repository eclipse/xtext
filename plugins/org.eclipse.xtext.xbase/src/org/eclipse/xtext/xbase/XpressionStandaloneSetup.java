
package org.eclipse.xtext.xbase;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XpressionStandaloneSetup extends XpressionStandaloneSetupGenerated{

	public static void doSetup() {
		new XpressionStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


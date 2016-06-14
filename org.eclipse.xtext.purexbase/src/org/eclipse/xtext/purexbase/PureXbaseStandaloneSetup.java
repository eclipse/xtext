
package org.eclipse.xtext.purexbase;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class PureXbaseStandaloneSetup extends PureXbaseStandaloneSetupGenerated{

	public static void doSetup() {
		new PureXbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


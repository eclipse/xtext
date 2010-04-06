
package org.eclipse.xtext.common;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TerminalsStandaloneSetup extends TerminalsStandaloneSetupGenerated{

	public static void doSetup() {
		new TerminalsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


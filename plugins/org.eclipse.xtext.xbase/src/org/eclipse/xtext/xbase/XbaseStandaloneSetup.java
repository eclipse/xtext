
package org.eclipse.xtext.xbase;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XbaseStandaloneSetup extends XbaseStandaloneSetupGenerated{

	public static void doSetup() {
		new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


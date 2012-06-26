
package org.eclipse.xpect;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XpectStandaloneSetup extends XpectStandaloneSetupGenerated{

	public static void doSetup() {
		new XpectStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.parser.terminalrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EcoreTerminalsTestLanguageStandaloneSetup extends EcoreTerminalsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EcoreTerminalsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


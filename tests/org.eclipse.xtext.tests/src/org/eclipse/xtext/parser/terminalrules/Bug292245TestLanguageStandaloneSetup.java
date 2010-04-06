
package org.eclipse.xtext.parser.terminalrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug292245TestLanguageStandaloneSetup extends Bug292245TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug292245TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


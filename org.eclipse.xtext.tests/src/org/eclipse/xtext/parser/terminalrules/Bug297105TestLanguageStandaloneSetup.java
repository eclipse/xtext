
package org.eclipse.xtext.parser.terminalrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug297105TestLanguageStandaloneSetup extends Bug297105TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug297105TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


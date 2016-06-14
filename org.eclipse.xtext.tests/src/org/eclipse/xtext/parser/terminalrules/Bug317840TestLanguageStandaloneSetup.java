
package org.eclipse.xtext.parser.terminalrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug317840TestLanguageStandaloneSetup extends Bug317840TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug317840TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


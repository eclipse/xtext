
package org.eclipse.xtext.parser.antlr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug301935TestLanguageStandaloneSetup extends Bug301935TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug301935TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


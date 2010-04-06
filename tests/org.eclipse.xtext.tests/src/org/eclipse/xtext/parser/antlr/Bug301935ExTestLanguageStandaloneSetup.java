
package org.eclipse.xtext.parser.antlr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug301935ExTestLanguageStandaloneSetup extends Bug301935ExTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug301935ExTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


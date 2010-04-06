
package org.eclipse.xtext.parser.antlr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug296889ExTestLanguageStandaloneSetup extends Bug296889ExTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug296889ExTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


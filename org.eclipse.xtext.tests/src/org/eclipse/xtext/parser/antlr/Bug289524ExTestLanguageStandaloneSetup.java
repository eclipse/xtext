
package org.eclipse.xtext.parser.antlr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug289524ExTestLanguageStandaloneSetup extends Bug289524ExTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug289524ExTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.parser.antlr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug289515TestLanguageStandaloneSetup extends Bug289515TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug289515TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


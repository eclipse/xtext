
package org.eclipse.xtext.parser.antlr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug299237TestLanguageStandaloneSetup extends Bug299237TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug299237TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.parser.antlr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug296889TestLanguageStandaloneSetup extends Bug296889TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug296889TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.parser.antlr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug289524TestLanguageStandaloneSetup extends Bug289524TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug289524TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


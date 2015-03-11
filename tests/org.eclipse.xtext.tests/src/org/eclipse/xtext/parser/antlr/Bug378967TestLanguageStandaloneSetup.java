
package org.eclipse.xtext.parser.antlr;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class Bug378967TestLanguageStandaloneSetup extends Bug378967TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug378967TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

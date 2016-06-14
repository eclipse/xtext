
package org.eclipse.xtext.generator.grammarAccess;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class GrammarAccessTestLanguageStandaloneSetup extends GrammarAccessTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new GrammarAccessTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


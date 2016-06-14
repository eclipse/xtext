
package org.eclipse.xtext.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ReferenceGrammarTestLanguageStandaloneSetup extends ReferenceGrammarTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ReferenceGrammarTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


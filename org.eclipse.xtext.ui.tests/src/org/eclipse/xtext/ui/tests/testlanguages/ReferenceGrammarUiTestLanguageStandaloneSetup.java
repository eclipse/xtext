
package org.eclipse.xtext.ui.tests.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ReferenceGrammarUiTestLanguageStandaloneSetup extends ReferenceGrammarUiTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ReferenceGrammarUiTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


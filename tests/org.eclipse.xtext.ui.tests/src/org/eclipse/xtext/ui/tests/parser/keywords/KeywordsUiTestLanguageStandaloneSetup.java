
package org.eclipse.xtext.ui.tests.parser.keywords;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class KeywordsUiTestLanguageStandaloneSetup extends KeywordsUiTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new KeywordsUiTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.parser.keywords;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class KeywordsTestLanguageStandaloneSetup extends KeywordsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new KeywordsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


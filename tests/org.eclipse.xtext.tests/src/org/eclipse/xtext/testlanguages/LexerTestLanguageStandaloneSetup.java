
package org.eclipse.xtext.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LexerTestLanguageStandaloneSetup extends LexerTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new LexerTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


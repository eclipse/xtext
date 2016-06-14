
package org.eclipse.xtext.lexer;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class IgnoreCaseLexerTestLanguageStandaloneSetup extends IgnoreCaseLexerTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new IgnoreCaseLexerTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


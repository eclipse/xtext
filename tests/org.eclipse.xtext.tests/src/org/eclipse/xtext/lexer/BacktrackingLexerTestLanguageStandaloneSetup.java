
package org.eclipse.xtext.lexer;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BacktrackingLexerTestLanguageStandaloneSetup extends BacktrackingLexerTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new BacktrackingLexerTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


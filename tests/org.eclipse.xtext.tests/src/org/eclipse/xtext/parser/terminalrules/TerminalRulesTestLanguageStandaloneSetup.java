
package org.eclipse.xtext.parser.terminalrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TerminalRulesTestLanguageStandaloneSetup extends TerminalRulesTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new TerminalRulesTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


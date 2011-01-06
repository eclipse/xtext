
package org.eclipse.xtext.parser.terminalrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UnicodeTestLanguageStandaloneSetup extends UnicodeTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new UnicodeTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


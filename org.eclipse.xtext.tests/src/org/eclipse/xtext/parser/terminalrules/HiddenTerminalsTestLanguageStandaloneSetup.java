
package org.eclipse.xtext.parser.terminalrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class HiddenTerminalsTestLanguageStandaloneSetup extends HiddenTerminalsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new HiddenTerminalsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


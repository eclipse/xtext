
package org.eclipse.xtext.parser.datatyperules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DatatypeRulesTestLanguageStandaloneSetup extends DatatypeRulesTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new DatatypeRulesTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


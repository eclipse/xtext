
package org.eclipse.xtext.enumrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EnumRulesTestLanguageStandaloneSetup extends EnumRulesTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EnumRulesTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.ui.tests.enumrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EnumRulesUiTestLanguageStandaloneSetup extends EnumRulesUiTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EnumRulesUiTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


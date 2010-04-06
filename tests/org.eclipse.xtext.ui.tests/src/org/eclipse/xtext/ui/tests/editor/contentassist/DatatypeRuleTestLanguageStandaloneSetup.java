
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DatatypeRuleTestLanguageStandaloneSetup extends DatatypeRuleTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new DatatypeRuleTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.xtext.ecoreInference;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UnassignedRuleCallTestLanguageStandaloneSetup extends UnassignedRuleCallTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new UnassignedRuleCallTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


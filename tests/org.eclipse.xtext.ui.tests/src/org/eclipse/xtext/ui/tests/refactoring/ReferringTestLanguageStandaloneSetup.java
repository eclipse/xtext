
package org.eclipse.xtext.ui.tests.refactoring;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ReferringTestLanguageStandaloneSetup extends ReferringTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ReferringTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


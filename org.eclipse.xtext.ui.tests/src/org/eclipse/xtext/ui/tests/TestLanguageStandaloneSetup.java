
package org.eclipse.xtext.ui.tests;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TestLanguageStandaloneSetup extends TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


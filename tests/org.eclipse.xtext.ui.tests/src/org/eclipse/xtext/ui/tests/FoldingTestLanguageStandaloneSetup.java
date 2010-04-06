
package org.eclipse.xtext.ui.tests;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class FoldingTestLanguageStandaloneSetup extends FoldingTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new FoldingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


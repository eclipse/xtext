
package org.eclipse.xtext.ui.tests.quickfix;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class QuickfixCrossrefTestLanguageStandaloneSetup extends QuickfixCrossrefTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new QuickfixCrossrefTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


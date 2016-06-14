
package org.eclipse.xtext.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LookaheadTestLanguageStandaloneSetup extends LookaheadTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new LookaheadTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


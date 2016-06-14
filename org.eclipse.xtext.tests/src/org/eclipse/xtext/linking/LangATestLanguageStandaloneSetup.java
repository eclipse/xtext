
package org.eclipse.xtext.linking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LangATestLanguageStandaloneSetup extends LangATestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new LangATestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


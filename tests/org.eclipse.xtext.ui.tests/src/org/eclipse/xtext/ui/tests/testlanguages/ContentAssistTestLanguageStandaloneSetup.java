
package org.eclipse.xtext.ui.tests.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ContentAssistTestLanguageStandaloneSetup extends ContentAssistTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ContentAssistTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


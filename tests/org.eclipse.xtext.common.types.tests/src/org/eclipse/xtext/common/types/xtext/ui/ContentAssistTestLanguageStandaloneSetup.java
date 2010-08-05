
package org.eclipse.xtext.common.types.xtext.ui;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ContentAssistTestLanguageStandaloneSetup extends ContentAssistTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ContentAssistTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


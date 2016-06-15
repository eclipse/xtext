
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ContentAssistContextTestLanguageStandaloneSetup extends ContentAssistContextTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ContentAssistContextTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


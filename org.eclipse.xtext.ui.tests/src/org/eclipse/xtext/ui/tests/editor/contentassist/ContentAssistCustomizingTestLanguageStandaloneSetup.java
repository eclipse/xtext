
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ContentAssistCustomizingTestLanguageStandaloneSetup extends ContentAssistCustomizingTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ContentAssistCustomizingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


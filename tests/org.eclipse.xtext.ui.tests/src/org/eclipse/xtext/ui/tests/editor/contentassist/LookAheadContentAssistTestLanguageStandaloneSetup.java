
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LookAheadContentAssistTestLanguageStandaloneSetup extends LookAheadContentAssistTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new LookAheadContentAssistTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


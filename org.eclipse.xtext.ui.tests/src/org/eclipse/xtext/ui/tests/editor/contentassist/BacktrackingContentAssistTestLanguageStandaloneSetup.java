
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BacktrackingContentAssistTestLanguageStandaloneSetup extends BacktrackingContentAssistTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new BacktrackingContentAssistTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


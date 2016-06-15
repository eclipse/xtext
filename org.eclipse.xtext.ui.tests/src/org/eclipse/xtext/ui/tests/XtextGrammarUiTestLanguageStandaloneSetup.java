
package org.eclipse.xtext.ui.tests;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XtextGrammarUiTestLanguageStandaloneSetup extends XtextGrammarUiTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new XtextGrammarUiTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


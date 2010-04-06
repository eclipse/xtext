
package org.eclipse.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XtextGrammarTestLanguageStandaloneSetup extends XtextGrammarTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new XtextGrammarTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


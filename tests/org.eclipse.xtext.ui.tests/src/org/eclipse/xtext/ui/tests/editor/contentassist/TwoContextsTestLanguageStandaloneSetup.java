
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TwoContextsTestLanguageStandaloneSetup extends TwoContextsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new TwoContextsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


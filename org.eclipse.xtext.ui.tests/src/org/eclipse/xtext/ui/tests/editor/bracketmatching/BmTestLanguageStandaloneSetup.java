
package org.eclipse.xtext.ui.tests.editor.bracketmatching;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BmTestLanguageStandaloneSetup extends BmTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new BmTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


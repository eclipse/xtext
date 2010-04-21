
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug309949TestLanguageStandaloneSetup extends Bug309949TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug309949TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


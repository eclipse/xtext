
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug304681TestLanguageStandaloneSetup extends Bug304681TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug304681TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


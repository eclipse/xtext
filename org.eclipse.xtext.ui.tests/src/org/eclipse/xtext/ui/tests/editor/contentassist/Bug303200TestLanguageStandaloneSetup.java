
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug303200TestLanguageStandaloneSetup extends Bug303200TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug303200TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


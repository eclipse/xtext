
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug348199TestLanguageStandaloneSetup extends Bug348199TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug348199TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


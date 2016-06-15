
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug360834TestLanguageStandaloneSetup extends Bug360834TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug360834TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


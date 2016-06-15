
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug287941TestLanguageStandaloneSetup extends Bug287941TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug287941TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


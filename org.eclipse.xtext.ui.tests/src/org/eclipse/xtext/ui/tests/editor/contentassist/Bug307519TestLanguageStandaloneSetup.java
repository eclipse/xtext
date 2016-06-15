
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug307519TestLanguageStandaloneSetup extends Bug307519TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug307519TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


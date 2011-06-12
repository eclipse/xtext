
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug348427TestLanguageStandaloneSetup extends Bug348427TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug348427TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


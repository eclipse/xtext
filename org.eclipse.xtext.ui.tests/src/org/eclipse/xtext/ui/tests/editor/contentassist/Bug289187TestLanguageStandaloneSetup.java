
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug289187TestLanguageStandaloneSetup extends Bug289187TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug289187TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


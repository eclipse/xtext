
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug288734TestLanguageStandaloneSetup extends Bug288734TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug288734TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug288760TestLanguageStandaloneSetup extends Bug288760TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug288760TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


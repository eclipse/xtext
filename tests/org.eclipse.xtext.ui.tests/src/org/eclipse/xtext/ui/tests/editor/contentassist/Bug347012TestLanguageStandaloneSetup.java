
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug347012TestLanguageStandaloneSetup extends Bug347012TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug347012TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


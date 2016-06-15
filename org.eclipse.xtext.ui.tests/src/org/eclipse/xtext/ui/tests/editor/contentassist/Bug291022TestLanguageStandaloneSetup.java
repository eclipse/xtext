
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug291022TestLanguageStandaloneSetup extends Bug291022TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug291022TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


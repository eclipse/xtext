
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class Bug377311TestLanguageStandaloneSetup extends Bug377311TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug377311TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

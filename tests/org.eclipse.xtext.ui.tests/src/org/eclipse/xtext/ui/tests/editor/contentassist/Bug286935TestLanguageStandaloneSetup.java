
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug286935TestLanguageStandaloneSetup extends Bug286935TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug286935TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


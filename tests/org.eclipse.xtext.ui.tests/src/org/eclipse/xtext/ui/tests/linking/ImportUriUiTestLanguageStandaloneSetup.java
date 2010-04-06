
package org.eclipse.xtext.ui.tests.linking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ImportUriUiTestLanguageStandaloneSetup extends ImportUriUiTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ImportUriUiTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


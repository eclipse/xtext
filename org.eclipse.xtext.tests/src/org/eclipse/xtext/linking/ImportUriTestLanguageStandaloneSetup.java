
package org.eclipse.xtext.linking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ImportUriTestLanguageStandaloneSetup extends ImportUriTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ImportUriTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


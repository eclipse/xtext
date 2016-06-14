
package org.eclipse.xtext.parsetree.reconstr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug302128TestLanguageStandaloneSetup extends Bug302128TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug302128TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


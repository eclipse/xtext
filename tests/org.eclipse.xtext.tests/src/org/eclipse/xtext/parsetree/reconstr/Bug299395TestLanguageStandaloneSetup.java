
package org.eclipse.xtext.parsetree.reconstr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug299395TestLanguageStandaloneSetup extends Bug299395TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug299395TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


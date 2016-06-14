
package org.eclipse.xtext.parsetree.reconstr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SerializationBug269362TestLanguageStandaloneSetup extends SerializationBug269362TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SerializationBug269362TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


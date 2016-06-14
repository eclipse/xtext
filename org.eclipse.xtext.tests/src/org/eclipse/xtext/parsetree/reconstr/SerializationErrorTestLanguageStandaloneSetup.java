
package org.eclipse.xtext.parsetree.reconstr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SerializationErrorTestLanguageStandaloneSetup extends SerializationErrorTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SerializationErrorTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


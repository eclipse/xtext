
package org.eclipse.xtext.parsetree.reconstr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class PartialSerializationTestLanguageStandaloneSetup extends PartialSerializationTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new PartialSerializationTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


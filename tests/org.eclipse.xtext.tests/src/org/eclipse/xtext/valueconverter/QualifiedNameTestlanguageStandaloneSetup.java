
package org.eclipse.xtext.valueconverter;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class QualifiedNameTestlanguageStandaloneSetup extends QualifiedNameTestlanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new QualifiedNameTestlanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


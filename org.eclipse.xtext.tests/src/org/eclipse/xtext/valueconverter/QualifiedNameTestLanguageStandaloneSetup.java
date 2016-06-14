
package org.eclipse.xtext.valueconverter;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class QualifiedNameTestLanguageStandaloneSetup extends QualifiedNameTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new QualifiedNameTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


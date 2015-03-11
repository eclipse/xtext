
package org.eclipse.xtext.metamodelreferencing.tests;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EcoreReferenceTestLanguageStandaloneSetup extends EcoreReferenceTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EcoreReferenceTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


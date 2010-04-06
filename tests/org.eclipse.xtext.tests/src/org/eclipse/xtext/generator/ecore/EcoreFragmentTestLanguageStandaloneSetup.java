
package org.eclipse.xtext.generator.ecore;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EcoreFragmentTestLanguageStandaloneSetup extends EcoreFragmentTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EcoreFragmentTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


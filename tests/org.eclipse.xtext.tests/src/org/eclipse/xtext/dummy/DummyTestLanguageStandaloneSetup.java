
package org.eclipse.xtext.dummy;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DummyTestLanguageStandaloneSetup extends DummyTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new DummyTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


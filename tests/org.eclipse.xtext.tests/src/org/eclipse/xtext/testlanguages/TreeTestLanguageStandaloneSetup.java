
package org.eclipse.xtext.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TreeTestLanguageStandaloneSetup extends TreeTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new TreeTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


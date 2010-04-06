
package org.eclipse.xtext.metamodelreferencing.tests;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MultiGenMMTestLanguageStandaloneSetup extends MultiGenMMTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new MultiGenMMTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


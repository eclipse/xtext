
package org.eclipse.xtext.linking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class IgnoreCaseNamespacesTestLanguageStandaloneSetup extends IgnoreCaseNamespacesTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new IgnoreCaseNamespacesTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


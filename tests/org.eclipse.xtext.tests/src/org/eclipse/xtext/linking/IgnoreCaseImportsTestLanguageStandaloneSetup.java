
package org.eclipse.xtext.linking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class IgnoreCaseImportsTestLanguageStandaloneSetup extends IgnoreCaseImportsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new IgnoreCaseImportsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


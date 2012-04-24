
package org.eclipse.xtext.resource;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LiveContainerBuilderIntegerationTestLanguageStandaloneSetup extends LiveContainerBuilderIntegerationTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new LiveContainerBuilderIntegerationTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.serializer;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ContextFinderTestLanguageStandaloneSetup extends ContextFinderTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ContextFinderTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


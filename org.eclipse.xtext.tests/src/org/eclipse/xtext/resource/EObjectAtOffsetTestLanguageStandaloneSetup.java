
package org.eclipse.xtext.resource;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EObjectAtOffsetTestLanguageStandaloneSetup extends EObjectAtOffsetTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EObjectAtOffsetTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


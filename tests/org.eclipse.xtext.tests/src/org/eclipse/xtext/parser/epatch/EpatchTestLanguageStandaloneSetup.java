
package org.eclipse.xtext.parser.epatch;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EpatchTestLanguageStandaloneSetup extends EpatchTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EpatchTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


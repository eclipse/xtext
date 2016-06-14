
package org.eclipse.xtext.enumrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EnumAndReferenceTestLanguageStandaloneSetup extends EnumAndReferenceTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EnumAndReferenceTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


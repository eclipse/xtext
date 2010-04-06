
package org.eclipse.xtext.parsetree.unassignedtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UnassignedTextTestLanguageStandaloneSetup extends UnassignedTextTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new UnassignedTextTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


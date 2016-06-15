
package org.eclipse.xtext.parsetree.reconstr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class HiddenTokensMergerTestLanguageStandaloneSetup extends HiddenTokensMergerTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new HiddenTokensMergerTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


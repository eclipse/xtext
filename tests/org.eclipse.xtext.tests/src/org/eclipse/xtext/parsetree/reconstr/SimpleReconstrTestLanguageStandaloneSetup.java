
package org.eclipse.xtext.parsetree.reconstr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SimpleReconstrTestLanguageStandaloneSetup extends SimpleReconstrTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SimpleReconstrTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.parsetree.reconstr;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ComplexReconstrTestLanguageStandaloneSetup extends ComplexReconstrTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ComplexReconstrTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


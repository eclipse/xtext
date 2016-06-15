
package org.eclipse.xtext.parsetree.transientvalues;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TransientValuesTestStandaloneSetup extends TransientValuesTestStandaloneSetupGenerated{

	public static void doSetup() {
		new TransientValuesTestStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


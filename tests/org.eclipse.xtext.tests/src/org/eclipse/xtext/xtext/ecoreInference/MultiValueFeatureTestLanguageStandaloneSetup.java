
package org.eclipse.xtext.xtext.ecoreInference;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MultiValueFeatureTestLanguageStandaloneSetup extends MultiValueFeatureTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new MultiValueFeatureTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


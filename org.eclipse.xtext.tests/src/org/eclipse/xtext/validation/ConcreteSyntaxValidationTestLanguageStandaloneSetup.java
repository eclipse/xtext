
package org.eclipse.xtext.validation;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ConcreteSyntaxValidationTestLanguageStandaloneSetup extends ConcreteSyntaxValidationTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ConcreteSyntaxValidationTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


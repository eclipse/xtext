
package org.eclipse.xtext.grammarinheritance;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class InheritanceTestLanguageStandaloneSetup extends InheritanceTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new InheritanceTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


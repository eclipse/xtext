
package org.eclipse.xtext.grammarinheritance;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class InheritanceTest2LanguageStandaloneSetup extends InheritanceTest2LanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new InheritanceTest2LanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


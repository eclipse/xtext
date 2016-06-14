
package org.eclipse.xtext.grammarinheritance;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ConcreteTestLanguageStandaloneSetup extends ConcreteTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ConcreteTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.grammarinheritance;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BaseInheritanceTestLanguageStandaloneSetup extends BaseInheritanceTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new BaseInheritanceTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


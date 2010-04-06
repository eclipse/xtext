
package org.eclipse.xtext.grammarinheritance;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class AbstractTestLanguageStandaloneSetup extends AbstractTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new AbstractTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


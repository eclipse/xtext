
package org.eclipse.xtext.builder.tests;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BuilderTestLanguageStandaloneSetup extends BuilderTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new BuilderTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


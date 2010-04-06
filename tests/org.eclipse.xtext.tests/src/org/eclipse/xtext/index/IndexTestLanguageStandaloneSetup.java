
package org.eclipse.xtext.index;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class IndexTestLanguageStandaloneSetup extends IndexTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new IndexTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


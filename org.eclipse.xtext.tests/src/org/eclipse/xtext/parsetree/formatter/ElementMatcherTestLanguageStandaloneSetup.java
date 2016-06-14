
package org.eclipse.xtext.parsetree.formatter;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ElementMatcherTestLanguageStandaloneSetup extends ElementMatcherTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ElementMatcherTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.testlanguages.indent;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class IndentationAwareTestLanguageStandaloneSetup extends IndentationAwareTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new IndentationAwareTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


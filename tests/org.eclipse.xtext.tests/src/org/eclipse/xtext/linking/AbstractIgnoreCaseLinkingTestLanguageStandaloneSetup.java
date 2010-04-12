
package org.eclipse.xtext.linking;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class AbstractIgnoreCaseLinkingTestLanguageStandaloneSetup extends AbstractIgnoreCaseLinkingTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new AbstractIgnoreCaseLinkingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


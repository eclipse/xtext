
package org.eclipse.xtext.testlanguages;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class PartialParserTestLanguageStandaloneSetup extends PartialParserTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new PartialParserTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


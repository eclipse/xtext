
package org.eclipse.xtext.parser.encoding;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EncodingTestLanguageStandaloneSetup extends EncodingTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EncodingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


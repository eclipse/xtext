
package org.eclipse.xtext.ui.tests.editor.encoding;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EncodingTestLanguageStandaloneSetup extends EncodingTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EncodingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


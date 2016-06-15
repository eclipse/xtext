
package org.eclipse.xtext.ui.tests.editor.encoding;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EncodingUiTestLanguageStandaloneSetup extends EncodingUiTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new EncodingUiTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


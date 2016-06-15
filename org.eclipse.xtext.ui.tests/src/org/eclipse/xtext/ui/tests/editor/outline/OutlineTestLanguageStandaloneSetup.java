
package org.eclipse.xtext.ui.tests.editor.outline;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class OutlineTestLanguageStandaloneSetup extends OutlineTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new OutlineTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


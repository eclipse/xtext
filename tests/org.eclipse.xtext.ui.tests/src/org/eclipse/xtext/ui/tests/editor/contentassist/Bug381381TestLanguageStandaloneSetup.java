
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Bug381381TestLanguageStandaloneSetup extends Bug381381TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new Bug381381TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


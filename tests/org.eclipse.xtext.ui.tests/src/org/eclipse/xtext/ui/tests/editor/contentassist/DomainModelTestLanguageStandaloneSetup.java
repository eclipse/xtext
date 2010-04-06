
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DomainModelTestLanguageStandaloneSetup extends DomainModelTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new DomainModelTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipse.xtext.xtext.ui.ecore2xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Ecore2XtextTestStandaloneSetup extends Ecore2XtextTestStandaloneSetupGenerated{

	public static void doSetup() {
		new Ecore2XtextTestStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


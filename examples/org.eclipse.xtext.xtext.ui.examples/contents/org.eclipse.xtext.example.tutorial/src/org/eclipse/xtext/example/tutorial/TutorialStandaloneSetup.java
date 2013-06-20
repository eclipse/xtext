
package org.eclipse.xtext.example.tutorial;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TutorialStandaloneSetup extends TutorialStandaloneSetupGenerated{

	public static void doSetup() {
		new TutorialStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


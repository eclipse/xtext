
package org.eclipse.xtext.serializer;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SequencerTestLanguageStandaloneSetup extends SequencerTestLanguageStandaloneSetupGenerated {

	public static void doSetup() {
		new SequencerTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


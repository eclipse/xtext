
package org.eclipse.xtext.serializer;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SyntacticSequencerTestLanguageStandaloneSetup extends SyntacticSequencerTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SyntacticSequencerTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


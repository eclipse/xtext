
package org.eclipse.xtext.ui.tests.editor.contentassist;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CrossReferenceProposalTestLanguageStandaloneSetup extends CrossReferenceProposalTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new CrossReferenceProposalTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


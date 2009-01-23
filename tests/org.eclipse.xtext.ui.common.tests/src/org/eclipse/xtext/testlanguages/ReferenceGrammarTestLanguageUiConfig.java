/*
Generated with Xtext
 */
package org.eclipse.xtext.testlanguages;

import java.util.Set;

import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;

/**
 * used to register components to be used within the IDE.
 */
public class ReferenceGrammarTestLanguageUiConfig extends
		org.eclipse.xtext.testlanguages.GenReferenceGrammarTestLanguageUiConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> registrations = super.registrations();
		registrations.addAll(scope(ReferenceGrammarTestLanguageStandaloneSetup.getServiceScope()).with(
				IProposalProvider.class,
				(UseXtendSwitch.useXtend) ? XtendReferenceGrammarTestLanguageProposalProvider.class
						: GenReferenceGrammarTestLanguageProposalProvider.class,  UseXtendSwitch.higherPriority++)
				.registrations());
		return registrations;
	}

}

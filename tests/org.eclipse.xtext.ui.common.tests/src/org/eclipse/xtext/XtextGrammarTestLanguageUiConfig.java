/*
Generated with Xtext
*/
package org.eclipse.xtext;

import java.util.Set;

import org.eclipse.xtext.testlanguages.UseXtendSwitch;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;

/**
 * used to register components to be used within the IDE.
 */
public class XtextGrammarTestLanguageUiConfig extends org.eclipse.xtext.GenXtextGrammarTestLanguageUiConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> registrations = super.registrations();
		registrations.addAll(scope(XtextGrammarTestLanguageStandaloneSetup.getServiceScope()).with(
				IProposalProvider.class,
				(UseXtendSwitch.useXtend) ? XtendXtextGrammarTestLanguageProposalProvider.class
						: GenXtextGrammarTestLanguageProposalProvider.class, UseXtendSwitch.higherPriority++)
				.registrations());
		return registrations;
	}

}

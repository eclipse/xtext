/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * GENERATED! Manual modification goes to ReferenceGrammarUiConfig
 */
public class GenReferenceGrammarUiConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.reference.IReferenceGrammar.SCOPE)
			.with(org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider.class, org.eclipse.xtext.reference.ReferenceGrammarGenProposalProvider.class)
			.with(org.eclipse.jface.text.contentassist.IContentAssistProcessor.class, org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor.class)
			.registrations();
	}

}

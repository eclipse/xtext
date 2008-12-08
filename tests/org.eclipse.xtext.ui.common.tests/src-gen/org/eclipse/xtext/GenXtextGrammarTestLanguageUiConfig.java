/*
Generated with Xtext
*/
package org.eclipse.xtext;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * GENERATED! Manual modification goes to XtextGrammarTestLanguageUiConfig
 */
public class GenXtextGrammarTestLanguageUiConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.IXtextGrammarTestLanguage.SCOPE)
			.with(org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider.class, org.eclipse.xtext.XtextGrammarTestLanguageGenProposalProvider.class)
			.with(org.eclipse.jface.text.contentassist.IContentAssistant.class, org.eclipse.jface.text.contentassist.ContentAssistant.class)
			.with(org.eclipse.jface.text.contentassist.IContentAssistProcessor.class, org.eclipse.xtext.ui.common.editor.codecompletion.DefaultContentAssistProcessor.class)
			.with(org.eclipse.xtext.ui.common.editor.codecompletion.ILinkingCandidatesService.class, org.eclipse.xtext.ui.common.editor.codecompletion.impl.DefaultLinkingCandidatesService.class)
			.registrations();
	}

}

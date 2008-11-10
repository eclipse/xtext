/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * GENERATED! Manual modification goes to FowlerDslUiConfig
 */
public class GenFowlerDslUiConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.example.IFowlerDsl.SCOPE)
			.with(org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider.class, org.eclipse.xtext.example.FowlerDslGenProposalProvider.class)
			.with(org.eclipse.jface.text.contentassist.IContentAssistant.class, org.eclipse.jface.text.contentassist.ContentAssistant.class)
			.with(org.eclipse.jface.text.contentassist.IContentAssistProcessor.class, org.eclipse.xtext.ui.common.editor.codecompletion.DefaultContentAssistProcessor.class)
			.registrations();
	}

}

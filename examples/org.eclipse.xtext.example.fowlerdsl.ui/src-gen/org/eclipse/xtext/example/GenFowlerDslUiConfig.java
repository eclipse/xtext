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
			.with(org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider.class, org.eclipse.xtext.example.FowlerDslGenProposalProvider.class)
			.with(org.eclipse.jface.text.contentassist.IContentAssistProcessor.class, org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor.class)
			.with(org.eclipse.xtext.ui.common.editor.contentassist.impl.IContentAssistInvocationHandler.class, org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistMethodInvoker.class)
			.with(org.eclipse.xtext.ui.common.editor.contentassist.ITemplateContentAssistProcessor.class, org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultTemplateContentAssistProcessor.class)
			.with(org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistCalculator.class, org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistCalculator.class)
			.registrations();
	}

}

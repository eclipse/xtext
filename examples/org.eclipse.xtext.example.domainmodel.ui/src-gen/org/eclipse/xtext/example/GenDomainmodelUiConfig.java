/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * GENERATED! Manual modification goes to DomainmodelUiConfig
 */
public class GenDomainmodelUiConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.example.IDomainmodel.SCOPE)
			.with(org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider.class, org.eclipse.xtext.example.DomainmodelGenProposalProvider.class)
			.with(org.eclipse.jface.text.contentassist.IContentAssistProcessor.class, org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor.class)
			.with(org.eclipse.xtext.ui.common.editor.contentassist.impl.IContentAssistInvocationHandler.class, org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistMethodInvoker.class)
			.with(org.eclipse.xtext.ui.common.editor.contentassist.ITemplateContentAssistProcessor.class, org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultTemplateContentAssistProcessor.class)
			.with(org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistCalculator.class, org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistCalculator.class)
			.with(org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer.class, org.eclipse.xtext.ui.common.editor.outline.impl.DefaultSemanticModelTransformer.class)
			.with(org.eclipse.xtext.ui.common.editor.outline.ILazyTreeProvider.class, org.eclipse.xtext.ui.common.editor.outline.impl.LazyTransformingTreeProvider.class)
			.registrations();
	}

}

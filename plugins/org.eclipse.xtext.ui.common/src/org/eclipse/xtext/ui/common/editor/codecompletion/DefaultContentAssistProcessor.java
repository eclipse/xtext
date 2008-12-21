/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.common.editor.codecompletion.impl.DefaultContentAssistContext;
import org.eclipse.xtext.ui.common.editor.codecompletion.impl.DefaultTemplateContentAssistProcessor;
import org.eclipse.xtext.ui.common.editor.codecompletion.impl.DefaultContentAssistCalculator;
import org.eclipse.xtext.ui.common.editor.codecompletion.impl.ProposalProviderInvokerSwitch;

/**
 * The default implementation of interface {@link IContentAssistProcessor} provided with Xtext.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Heiko Behrens
 */
public class DefaultContentAssistProcessor implements IContentAssistProcessor {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Inject (optional=true)
	private ITemplateContentAssistProcessor templateContentAssistProcessor;

	@Inject (optional=true)
	private IContentAssistCalculator contentAssistCalculator;
	
	@Inject
	private IProposalProvider proposalProvider;
	
	@Inject
	protected IServiceScope serviceScope;

	/**
	 * Computes the possible grammar elements following the one at the given offset and calls the respective methods on
	 * the proposal provider.
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, final int offset) {

		ICompletionProposal[] completionProposals = null;

		IContentAssistContext contentAssistContext = getContentAssistContext(viewer, offset);

		List<AbstractElement> computeProposalElements = getContentAssistCalculator().computeProposalElements(
				contentAssistContext);

		ProposalProviderInvokerSwitch proposalProviderInvokerSwitch = new ProposalProviderInvokerSwitch(
				contentAssistContext, proposalProvider);

		List<ICompletionProposal> completionProposalList = proposalProviderInvokerSwitch
				.collectCompletionProposalList(computeProposalElements);

		for (TemplateContextType templateContextType : proposalProviderInvokerSwitch.getTemplateContextTypeList()) {
			addTemplates(viewer, offset, contentAssistContext, templateContextType, completionProposalList);
		}

		List<? extends ICompletionProposal> processedCompletionProposalList = proposalProvider.sortAndFilter(
				completionProposalList, contentAssistContext);

		completionProposals = processedCompletionProposalList
				.toArray(new ICompletionProposal[processedCompletionProposalList.size()]);

		return completionProposals;
	}

	
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
	 */
	public String getErrorMessage() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer, int)
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
	 */
	public IContextInformationValidator getContextInformationValidator() {
		return new ContextInformationValidator(this);
	}
	
	/**
	 * adds templates to the list of proposals
	 * 
	 * @param viewer the viewer whose document is used to compute the proposals
	 * @param offset an offset within the document for which completions should be computed
	 * @param contentAssistContext the current context of the content assist proposal request
	 * @param templateContextType within which templates are resolved
	 * @param completionProposalList list of proposal to add to
	 */
	protected void addTemplates(ITextViewer viewer, int offset, IContentAssistContext contentAssistContext,
			TemplateContextType templateContextType, List<ICompletionProposal> completionProposalList) {
		if (getTemplateContentAssistProcessor() != null) {
			getTemplateContentAssistProcessor().setContentAssistContext(contentAssistContext);
			getTemplateContentAssistProcessor().setContextType(templateContextType);
			completionProposalList.addAll(Arrays.asList(getTemplateContentAssistProcessor().computeCompletionProposals(
					viewer, offset)));
		}
	}
	
	/**
	 * @param viewer the viewer whose document is used to compute the proposals
	 * @param offset an offset within the document for which completions should be computed
	 * @return an implementation of <code>IContentAssistContext</code>
	 */
	protected IContentAssistContext getContentAssistContext(ITextViewer textViewer,int offset) {
		return new DefaultContentAssistContext(textViewer,offset);
		
	}
	
	/**
	 * @return an implementation of <code>ITemplateContentAssistProcessor</code>
	 */
	protected ITemplateContentAssistProcessor getTemplateContentAssistProcessor() {
		if (templateContentAssistProcessor == null) {
			templateContentAssistProcessor = new DefaultTemplateContentAssistProcessor();
			ServiceRegistry.injectServices(this.serviceScope, templateContentAssistProcessor);
		}
		return templateContentAssistProcessor;
	}
	
	/**
	 * @return an implementation of <code>IContentAssistCalculator</code>
	 */
	protected IContentAssistCalculator getContentAssistCalculator() {
		if (this.contentAssistCalculator == null) {
			contentAssistCalculator = new DefaultContentAssistCalculator();
			ServiceRegistry.injectServices(this.serviceScope, contentAssistCalculator);
		}
		return contentAssistCalculator;
	}
	


}

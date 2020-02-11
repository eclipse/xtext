/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import java.util.Arrays;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextContentAssistProcessor implements IContentAssistProcessor, CompletionProposalComputer.State, ContextInformationComputer.State {

	public static final String COMPLETION_AUTO_ACTIVATION_CHARS = "org.eclipse.xtext.ui.editor.XtextContentAssistProcessor.COMPLETION_AUTO_ACTIVATION_CHARS";

	public static final String CONTEXT_INFO_AUTO_ACTIVATION_CHARS = "org.eclipse.xtext.ui.editor.XtextContentAssistProcessor.CONTEXT_INFO_AUTO_ACTIVATION_CHARS";

	public static final String ERROR_MESSAGE = "org.eclipse.xtext.ui.editor.XtextContentAssistProcessor.ERROR_MESSAGE";
	
	@Inject
	private ContentAssistContext.Factory contextFactory;
	
	@Inject(optional = true)
	private ITemplateProposalProvider templateProposalProvider;
	
	@Inject(optional = true)
	private IContentProposalProvider contentProposalProvider;
	
	@Inject(optional = true)
	private IContextInformationProvider contextInformationProvider;
	
	@Inject
	private ICompletionProposalComparator completionProposalComparator;
	
	@Inject
	private ICompletionProposalPostProcessor completionProposalPostProcessor;
	
	@Inject(optional = true)
	@Named(value=COMPLETION_AUTO_ACTIVATION_CHARS)
	private String completionProposalAutoActivationCharacters = null;
	
	@Inject(optional = true)
	@Named(value=CONTEXT_INFO_AUTO_ACTIVATION_CHARS)
	private String contextInformationAutoActivationCharacters = null;
	
	@Inject(optional = true)
	@Named(value=ERROR_MESSAGE)
	private String errorMessage = null;
	
	/**
	 * @since 2.19
	 */
	@Inject
	private XtextDocumentUtil xtextDocumentUtil;
	
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		if (contentProposalProvider == null)
			return null;
		
		IXtextDocument document = xtextDocumentUtil.getXtextDocument(viewer);
		ICompletionProposal[] result = document.priorityReadOnly(createCompletionProposalComputer(viewer, offset));
		Arrays.sort(result, completionProposalComparator);
		result = completionProposalPostProcessor.postProcess(result);
		return result;
	}

	protected CompletionProposalComputer createCompletionProposalComputer(ITextViewer viewer, int offset) {
		return new CompletionProposalComputer(this, viewer, offset);
	}

	@Override
	public IContextInformation[] computeContextInformation(final ITextViewer viewer, final int offset) {
		if (contextInformationProvider == null)
			return null;
		
		IXtextDocument document = xtextDocumentUtil.getXtextDocument(viewer);
		return document.priorityReadOnly(createContextInformationComputer(viewer, offset));
	}

	protected ContextInformationComputer createContextInformationComputer(final ITextViewer viewer, final int offset) {
		return new ContextInformationComputer(this, viewer, offset);
	}

	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		if (completionProposalAutoActivationCharacters != null)
			return completionProposalAutoActivationCharacters.toCharArray();
		return null;
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		if (contextInformationAutoActivationCharacters != null)
			return contextInformationAutoActivationCharacters.toCharArray();
		return null;
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		return new SmartInformationAwareContextInformationValidator(this);
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setCompletionProposalAutoActivationCharacters(String completionProposalAutoActivationCharacters) {
		this.completionProposalAutoActivationCharacters = completionProposalAutoActivationCharacters;
	}

	public void setContextFactory(ContentAssistContext.Factory contextFactory) {
		this.contextFactory = contextFactory;
	}

	@Override
	public ContentAssistContext.Factory getContextFactory() {
		return contextFactory;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setContextInformationAutoActivationCharacters(String contextInformationAutoActivationCharacters) {
		this.contextInformationAutoActivationCharacters = contextInformationAutoActivationCharacters;
	}

	public void setContentProposalProvider(IContentProposalProvider contentProposalProvider) {
		this.contentProposalProvider = contentProposalProvider;
	}

	@Override
	public IContentProposalProvider getContentProposalProvider() {
		return contentProposalProvider;
	}

	public void setTemplateProposalProvider(ITemplateProposalProvider templateProposalProvider) {
		this.templateProposalProvider = templateProposalProvider;
	}

	@Override
	public ITemplateProposalProvider getTemplateProposalProvider() {
		return templateProposalProvider;
	}

	@Override
	public IContextInformationProvider getContextInformationProvider() {
		return contextInformationProvider;
	}
	
	@Override
	public ICompletionProposalAcceptor decorateAcceptor(ICompletionProposalAcceptor acceptor) {
		return acceptor;
	}
	
	@Override
	public ITemplateAcceptor decorateAcceptor(ITemplateAcceptor acceptor) {
		return acceptor;
	}

	@Override
	public IContextInformationAcceptor decorateAcceptor(IContextInformationAcceptor acceptor) {
		return acceptor;
	}

	public void setCompletionProposalPostProcessor(ICompletionProposalPostProcessor completionProposalPostProcessor) {
		this.completionProposalPostProcessor = completionProposalPostProcessor;
	}

	public ICompletionProposalPostProcessor getCompletionProposalPostProcessor() {
		return completionProposalPostProcessor;
	}
	
	/**
	 * @since 2.7
	 */
	public ICompletionProposalComparator getCompletionProposalComparator() {
		return completionProposalComparator;
	}

}


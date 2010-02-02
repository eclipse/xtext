/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import java.util.Arrays;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.inject.Inject;
import com.google.inject.Provider;
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
	private Provider<ICompletionProposalAcceptor.Delegate> completionProposalAcceptorProvider;
	
	@Inject
	private Provider<ITemplateAcceptor.Delegate> templateAcceptorProvider;
	
	@Inject
	private Provider<IContextInformationAcceptor.Delegate> contextInformationAcceptorProvider;
	
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
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		if (contentProposalProvider == null)
			return null;
		
		IXtextDocument document = (IXtextDocument) viewer.getDocument();
		ICompletionProposal[] result = document.readOnly(createCompletionProposalComputer(viewer, offset));
		Arrays.sort(result, completionProposalComparator);
		result = completionProposalPostProcessor.postProcess(result);
		return result;
	}

	protected CompletionProposalComputer createCompletionProposalComputer(ITextViewer viewer, int offset) {
		return new CompletionProposalComputer(this, viewer, offset);
	}

	public IContextInformation[] computeContextInformation(final ITextViewer viewer, final int offset) {
		if (contextInformationProvider == null)
			return null;
		
		IXtextDocument document = (IXtextDocument) viewer.getDocument();
		return document.readOnly(createContextInformationComputer(viewer, offset));
	}

	protected ContextInformationComputer createContextInformationComputer(final ITextViewer viewer, final int offset) {
		return new ContextInformationComputer(this, viewer, offset);
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		if (completionProposalAutoActivationCharacters != null)
			return completionProposalAutoActivationCharacters.toCharArray();
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		if (contextInformationAutoActivationCharacters != null)
			return contextInformationAutoActivationCharacters.toCharArray();
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return new ContextInformationValidator(this);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setCompletionProposalAutoActivationCharacters(String completionProposalAutoActivationCharacters) {
		this.completionProposalAutoActivationCharacters = completionProposalAutoActivationCharacters;
	}

	public void setContextFactory(ContentAssistContext.Factory contextFactory) {
		this.contextFactory = contextFactory;
	}

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

	public IContentProposalProvider getContentProposalProvider() {
		return contentProposalProvider;
	}

	public void setTemplateProposalProvider(ITemplateProposalProvider templateProposalProvider) {
		this.templateProposalProvider = templateProposalProvider;
	}

	public ITemplateProposalProvider getTemplateProposalProvider() {
		return templateProposalProvider;
	}

	public IContextInformationProvider getContextInformationProvider() {
		return contextInformationProvider;
	}
	
	public ICompletionProposalAcceptor createAcceptor(ICompletionProposalAcceptor delegate) {
		ICompletionProposalAcceptor.Delegate result = completionProposalAcceptorProvider.get();
		result.setDelegate(delegate);
		return result;
	}
	
	public ITemplateAcceptor createAcceptor(ITemplateAcceptor delegate) {
		ITemplateAcceptor.Delegate result = templateAcceptorProvider.get();
		result.setDelegate(delegate);
		return result;
	}

	public IContextInformationAcceptor createAcceptor(IContextInformationAcceptor delegate) {
		IContextInformationAcceptor.Delegate result = contextInformationAcceptorProvider.get();
		result.setDelegate(delegate);
		return result;
	}

	public void setCompletionProposalPostProcessor(ICompletionProposalPostProcessor completionProposalPostProcessor) {
		this.completionProposalPostProcessor = completionProposalPostProcessor;
	}

	public ICompletionProposalPostProcessor getCompletionProposalPostProcessor() {
		return completionProposalPostProcessor;
	}

}


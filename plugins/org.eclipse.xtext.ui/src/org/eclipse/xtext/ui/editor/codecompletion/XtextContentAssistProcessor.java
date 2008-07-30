/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.codecompletion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;
import org.eclipse.xtext.ui.service.IProposalsProvider;
import org.eclipse.xtext.ui.service.IProposalsProvider.ICompletionContext;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextContentAssistProcessor implements IContentAssistProcessor {
	private final IProposalsProvider proposalProvider;
	private String errorMessage;
	private final IEditorModelProvider modelProvider;

	public XtextContentAssistProcessor(IEditorModelProvider modelProvider, IProposalsProvider proposalProvider) {
		this.modelProvider = modelProvider;
		this.proposalProvider = proposalProvider;
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();

		if (proposalProvider instanceof IProposalsProvider) {
			IProposalsProvider proposalsProvider2 = (IProposalsProvider) proposalProvider;

			ICompletionContext completionContext = proposalsProvider2.computeContext(modelProvider.getModel(), viewer,
					offset);
			List<ICompletionProposal> proposals = proposalsProvider2.getProposals(completionContext);
			List<ICompletionProposal> templateProposals = proposalsProvider2.getTemplateProposals(completionContext);

			if (proposals != null) {
				result.addAll(proposals);
			}
			if (templateProposals != null) {
				result.addAll(templateProposals);
			}

			if (result != null && !result.isEmpty()) {
				return result.toArray(new ICompletionProposal[0]);
			}
		}
		return null;
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		List<IContextInformation> retVal = new ArrayList<IContextInformation>();
		for (ICompletionProposal proposal : proposalProvider.getAllProposals(modelProvider.getModel(), viewer, offset)) {
			retVal.add(proposal.getContextInformation());
		}
		return retVal.toArray(new IContextInformation[0]);
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		// TODO ask preference store
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		// TODO ask preference store
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return new ContextInformationValidator(this);
	}

	public String getErrorMessage() {
		// TODO create error handler
		return errorMessage;
	}

}

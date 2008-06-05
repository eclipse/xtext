/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.codecompletion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.xtext.ui.core.service.IProposalsProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextContentAssistProcessor implements IContentAssistProcessor {
	private final IProposalsProvider proposalProvider;
	private String errorMessage;

	public XtextContentAssistProcessor(IProposalsProvider proposalProvider) {
		this.proposalProvider = proposalProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.IContentAssistProcessor#
	 * computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		List<ICompletionProposal> retVal = new ArrayList<ICompletionProposal>();
		List<Proposal> proposals = proposalProvider.getProposals(viewer, offset);
		if (proposals != null) {
			for (Proposal proposal : proposals) {
				retVal.add(createCompletionProposal(proposal, offset));
			}
		}
		return retVal.toArray(new ICompletionProposal[0]);
	}

	private ICompletionProposal createCompletionProposal(Proposal proposal, int offset) {
		return new XtextCompletionProposal(proposal, offset);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.IContentAssistProcessor#
	 * computeContextInformation(org.eclipse.jface.text.ITextViewer, int)
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		List<IContextInformation> retVal = new ArrayList<IContextInformation>();
		for (Proposal proposal : proposalProvider.getProposals(viewer, offset)) {
			XtextCompletionProposal xtextCP = new XtextCompletionProposal(proposal, offset);
			retVal.add(xtextCP.getContextInformation());
		}
		return retVal.toArray(new IContextInformation[0]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.IContentAssistProcessor#
	 * getCompletionProposalAutoActivationCharacters()
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		// TODO ask preference store
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.IContentAssistProcessor#
	 * getContextInformationAutoActivationCharacters()
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		// TODO ask preference store
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.IContentAssistProcessor#
	 * getContextInformationValidator()
	 */
	public IContextInformationValidator getContextInformationValidator() {
		return new ContextInformationValidator(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage
	 * ()
	 */
	public String getErrorMessage() {
		// TODO create error handler
		return errorMessage;
	}

}

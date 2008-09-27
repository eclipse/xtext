package org.eclipse.xtext.ui.common.editor.codecompletion;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.xtext.service.Inject;

public class DefaultContentAssistProcessor implements IContentAssistProcessor {
	
	@Inject
	private IProposalProvider proposalProvider; 

	/**
	 * computes the possible grammar elements following the one at the given offset and calls
	 * the respective methods on the proposal provider.
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		
		return null;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	public String getErrorMessage() {
		return null;
	}
	
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

}

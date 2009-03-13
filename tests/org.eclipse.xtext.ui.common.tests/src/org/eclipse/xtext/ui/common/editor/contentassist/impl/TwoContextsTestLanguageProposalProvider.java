
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

public class TwoContextsTestLanguageProposalProvider extends org.eclipse.xtext.ui.common.editor.contentassist.impl.GenTwoContextsTestLanguageProposalProvider {

	@Override
	public List<? extends ICompletionProposal> completeKeyword(Keyword keyword,
			IContentAssistContext contentAssistContext) {
		List<? extends ICompletionProposal> completeKeyword = super.completeKeyword(keyword, contentAssistContext);
		for (ICompletionProposal iCompletionProposal : completeKeyword) {
			if (!iCompletionProposal.getDisplayString().startsWith(contentAssistContext.getMatchString()))
				throw new IllegalStateException("proposed element '"+iCompletionProposal.getDisplayString()+"' does not start with '"+ contentAssistContext.getMatchString()+"'");
		}
		return completeKeyword;
	}
}

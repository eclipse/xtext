package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;

public interface IProposalProvider {
	
	List<ICompletionProposal> getProposalsForAssignment(Assignment ass, String prefix, IXtextDocument doc);
	List<ICompletionProposal> getProposalsForKeyword(Keyword kw, String prefix, IXtextDocument doc);
}

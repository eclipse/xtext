package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;


/**
 * 
 * This is just a marker interface.
 * Implementers declare methods with the pattern:
 * 
 * public List<ICompletionProposal> completeTypename_featureName(AbstractElement ele, EObject model, String prefix)
 * 
 */
public interface IProposalProvider {
	
	public List<ICompletionProposal> sortAndFilter(List<ICompletionProposal> proposals);
	
	public List<ICompletionProposal> completeKeyword(Keyword ele, EObject model, String prefix);

	public List<ICompletionProposal> completeRuleCall(RuleCall ele, EObject model, String prefix);
}

package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;


/**
 * 
 * This is just a marker interface.
 * 
 * In addition to the declared methods, the framework tries to call grammar dependent methods for assignments using reflection.
 * The signature of such methods invoked reflectively follows the following pattern:
 * 
 * public List<ICompletionProposal> complete[Typename]_[featureName](Assignment ele, EObject model, String prefix)
 * 
 * <b>Example</b>
 *  Given the following grammar :
 *  <code>
 *  RuleA returns MyType :
 *  	"myType" name=ID;
 *  </code>
 *
 * One could provide the following method in an implementation of this interface:
 *  <code>
 * 	public List<ICompletionProposal> completeMyType_name(Assignment ele, EObject model, String prefix, IDocument doc) {...}
 *  </code>
 *  Note that if you have generated Java classes for your domain model (meta model) you can alternatively declare the second parameter using 
 *  a specific type:
 *  <code>
 * 	public List<ICompletionProposal> completeMyType_name(Assignment ele, MyType model, String prefix, IDocument doc) {...}
 *  </code>
 *   
 */
public interface IProposalProvider {
	
	/**
	 * Is invoked by the framework if (with respect to the grammar) it is possible that the keyword passed as first parameter
	 * can occure next up.
	 * 
	 * @param ele - the keyword to be completed
	 * @param model - the most specific model element under the cursor. 
	 * @param prefix - the prefix under the cursor or null if there is no prefix
	 * @param doc - the IDocument instance used by the editor
	 * @return
	 */
	public List<ICompletionProposal> completeKeyword(Keyword ele, EObject model, String prefix, IDocument doc);

	/**
	 * Is invoked by the framework if (with respect to the grammar) it is possible that the keyword passed as first parameter
	 * can occure next up.
	 * 
	 * @param ele - the keyword to be completed
	 * @param model - the most specific model element under the cursor. 
	 * @param prefix - the prefix under the cursor or null if there is no prefix
	 * @param doc - the IDocument instance used by the editor
	 * @return
	 */
	public List<ICompletionProposal> completeRuleCall(RuleCall ele, EObject model, String prefix, IDocument doc);

	/**
	 * used to filter and sort a list of completion proposals.
	 * is invoked by the framework after all possible completions have been collected.
	 * @param proposals
	 * @return
	 */
	public List<ICompletionProposal> sortAndFilter(List<ICompletionProposal> proposals);
}

package org.eclipse.xtext.ui.common.editor.contentassist;

import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

/**
 * TODO: Rewrite these JavaDocs !
 * 
 * COMMMENT JavaDocs refer to default implementation rather than the interface
 * 
 * In addition to the declared methods, the framework tries to call grammar
 * dependent methods for assignments using reflection. The signature of such
 * methods invoked reflectively follows the following pattern:
 * 
 * public List<ICompletionProposal> complete[Typename][featureName](Assignment
 * ele, EObject model, String prefix)
 * 
 * <b>Example</b> Given the following grammar : <code>
 *  RuleA returns MyType :
 *  	"myType" name=ID;
 *  </code>
 * 
 * One could provide the following method in an implementation of this
 * interface: <code>
 * 	public List<ICompletionProposal> completeMyTypeName(Assignment ele, EObject model, String prefix, IDocument doc) {...}
 *  </code> Note that if you have generated Java classes for your
 * domain model (meta model) you can alternatively declare the second parameter
 * using a specific type: <code>
 * 	public List<ICompletionProposal> completeMyTypeName(Assignment ele, MyType model, String prefix, IDocument doc) {...}
 *  </code>
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public interface IProposalProvider {

	/**
	 * Is invoked by the framework if (with respect to the grammar) it is
	 * possible that the keyword passed as first parameter can occur next up.
	 * 
	 * @param keyword
	 *            the <code>Keyword</code> to be completed
	 * @param contentAssistContext
	 *            the current context of the content assist
	 * @return a list of matching {@link ICompletionProposal}
	 */
	List<? extends ICompletionProposal> completeKeyword(Keyword keyword, IContentAssistContext contentAssistContext);

	/**
	 * Is invoked by the framework if (with respect to the grammar) it is
	 * possible that the rule call passed as first parameter can occur next up.
	 * 
	 * @param ruleCall
	 *            the <code>RuleCall</code> to be completed
	 * @param contentAssistContext
	 *            the current context of the content assist
	 * @return a list of matching {@link ICompletionProposal}
	 */
	List<? extends ICompletionProposal> completeRuleCall(RuleCall ruleCall, IContentAssistContext contentAssistContext);

	/**
	 * Is invoked by the framework if (with respect to the grammar) it is
	 * possible that the assignment passed as first parameter can occur next up.
	 * 
	 * @param assignment
	 *            the <code>Assignment</code> to be completed
	 * @param contentAssistContext
	 *            the current context of the content assist
	 * @return a list of matching {@link ICompletionProposal}
	 */
	List<? extends ICompletionProposal> completeAssignment(Assignment assignment, IContentAssistContext contentAssistContext);

	/**
	 * Returns the context type that can handle template insertion at the given
	 * region in the viewer's document.
	 * 
	 * @param keyword
	 *            the <code>Keyword</code> to be completed
	 * @param contentAssistContext
	 *            the current context of the content assist
	 * @return the context type that can handle template expansion for the given
	 *         location, or <code>null</code> if none exists
	 */
	TemplateContextType getTemplateContextType(Keyword keyword, IContentAssistContext contentAssistContext);

	/**
	 * Returns the context type that can handle template insertion at the given
	 * region in the viewer's document.
	 * 
	 * @param ruleCall
	 *            the <code>RuleCall</code>
	 * @param contentAssistContext
	 *            the current context of the content assist
	 * @return the context type that can handle template expansion for the given
	 *         location, or <code>null</code> if none exists
	 */
	TemplateContextType getTemplateContextType(RuleCall ruleCall, IContentAssistContext contentAssistContext);

	/**
	 * Returns the templates valid for the context type specified by
	 * <code>contextTypeId</code>.
	 * 
	 * @param contextTypeId
	 *            the context type id
	 * @return the templates valid for this context type id
	 */
	Template[] getTemplates(String contextTypeId);

	/**
	 * Used to filter and sort a list of completion proposals. This method is
	 * invoked by the framework after all possible completions have been
	 * collected.
	 * 
	 * @param completionProposalList
	 *            matching {@link ICompletionProposal} to sort and filter
	 * @param contentAssistContext
	 *            the current context of the content assist
	 * @return the sorted and filtered <code>ICompletionProposal</code> list.
	 */
	List<? extends ICompletionProposal> sortAndFilter(List<? extends ICompletionProposal> completionProposalList,
			IContentAssistContext contentAssistContext);

}

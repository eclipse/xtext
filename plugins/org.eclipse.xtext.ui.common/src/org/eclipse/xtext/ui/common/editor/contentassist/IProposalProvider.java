/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public interface IProposalProvider {
	/**
	 * Is invoked by the framework if (with respect to the grammar) it is
	 * possible that the keyword passed as first parameter can occur next up.
	 * 
	 * @param keyword the <code>Keyword</code> to be completed
	 * @param contentAssistContext the current context of the content assist
	 * @return a list of matching {@link ICompletionProposal}
	 */
	List<? extends ICompletionProposal> completeKeyword(Keyword keyword, IContentAssistContext contentAssistContext);

	/**
	 * Is invoked by the framework if (with respect to the grammar) it is
	 * possible that the rule call passed as first parameter can occur next up.
	 * 
	 * @param ruleCall the <code>RuleCall</code> to be completed
	 * @param contentAssistContext the current context of the content assist
	 * @return a list of matching {@link ICompletionProposal}
	 */
	List<? extends ICompletionProposal> completeRuleCall(RuleCall ruleCall, IContentAssistContext contentAssistContext);

	/**
	 * Is invoked by the framework if (with respect to the grammar) it is
	 * possible that the assignment passed as first parameter can occur next up.
	 * 
	 * @param assignment the <code>Assignment</code> to be completed
	 * @param contentAssistContext the current context of the content assist
	 * @return a list of matching {@link ICompletionProposal}
	 */
	List<? extends ICompletionProposal> completeAssignment(Assignment assignment, IContentAssistContext contentAssistContext);

	/**
	 * Returns the context type that can handle template insertion at the given
	 * region in the viewer's document.
	 * 
	 * @param keyword the <code>Keyword</code> to be completed
	 * @param contentAssistContext the current context of the content assist
	 * @return the context type that can handle template expansion for the given
	 *         location, or <code>null</code> if none exists
	 */
	TemplateContextType getTemplateContextType(Keyword keyword, IContentAssistContext contentAssistContext);

	/**
	 * Returns the context type that can handle template insertion at the given
	 * region in the viewer's document.
	 * 
	 * @param ruleCall the <code>RuleCall</code>
	 * @param contentAssistContext the current context of the content assist
	 * @return the context type that can handle template expansion for the given
	 *         location, or <code>null</code> if none exists
	 */
	TemplateContextType getTemplateContextType(RuleCall ruleCall, IContentAssistContext contentAssistContext);
	
	/**
	 * Returns the templates valid for the context type specified by
	 * <code>contextTypeId</code>.
	 * 
	 * @param contextTypeId the context type id
	 * @return the templates valid for this context type id
	 */
	Template[] getTemplates(String contextTypeId);
	
	/**
	 * Used to filter the given list of completion proposals. 
	 * <p/>
	 * This method is after all possible completions and templates have been collected.
	 * 
	 * @param completionProposalList the collected list of {@link ICompletionProposal} to filter
	 * @param contentAssistContext the current context of the content assist
	 * @return the filtered <code>ICompletionProposal</code> list.
	 */
	List<? extends ICompletionProposal> filter(List<ICompletionProposal> completionProposalList,IContentAssistContext contentAssistContext);
	
	/**
	 * Used to sort the given list of completion proposals. 
	 * <p/>
	 * This method is after all possible completions and templates have been collected and filtered.
	 * 
	 * @param completionProposalList the collected list of {@link ICompletionProposal} to sort
	 * @return the sorted <code>ICompletionProposal</code> list.
	 */
	List<? extends ICompletionProposal> sort(List<ICompletionProposal> completionProposalList);
}

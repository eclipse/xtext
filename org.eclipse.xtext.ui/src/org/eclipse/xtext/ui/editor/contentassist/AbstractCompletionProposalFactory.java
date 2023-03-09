/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import com.google.inject.Inject;

/**
 * @author Christian Dietrich - Initial contribution and API
 * 
 * @since 2.13
 */
public abstract class AbstractCompletionProposalFactory implements ICompletionProposalFactory {

	@Inject
	private IContentProposalPriorities priorities;

	@Inject
	private IProposalConflictHelper conflictHelper;

	public ICompletionProposal createCompletionProposal(String proposal, String displayString, Image image,
			ContentAssistContext contentAssistContext) {
		return createCompletionProposal(proposal, new StyledString(displayString), image, getPriorityHelper()
				.getDefaultPriority(), contentAssistContext.getPrefix(), contentAssistContext);
	}
	
	public void setConflictHelper(IProposalConflictHelper conflictHelper) {
		this.conflictHelper = conflictHelper;
	}

	public IProposalConflictHelper getConflictHelper() {
		return conflictHelper;
	}
	
	public void setPriorityHelper(IContentProposalPriorities priorities) {
		this.priorities = priorities;
	}

	public IContentProposalPriorities getPriorityHelper() {
		return priorities;
	}
	
	protected ICompletionProposal createCompletionProposal(String proposal, ContentAssistContext contentAssistContext) {
		return createCompletionProposal(proposal, null, null, getPriorityHelper().getDefaultPriority(),
				contentAssistContext.getPrefix(), contentAssistContext);
	}

	@Override
	public ICompletionProposal createCompletionProposal(String proposal, StyledString displayString, Image image,
			ContentAssistContext contentAssistContext) {
		return createCompletionProposal(proposal, displayString, image, getPriorityHelper().getDefaultPriority(),
				contentAssistContext.getPrefix(), contentAssistContext);
	}

	/**
	 * @see #isValidProposal(String, String, ContentAssistContext)
	 * @see #doCreateProposal(String, StyledString, Image, int, ContentAssistContext)
	 */
	protected ICompletionProposal createCompletionProposal(String proposal, StyledString displayString, Image image,
			int priority, String prefix, ContentAssistContext context) {
		if (isValidProposal(proposal, prefix, context)) {
			return doCreateProposal(proposal, displayString, image, priority, context);
		}
		return null;
	}

	protected boolean isValidProposal(String proposal, String prefix, ContentAssistContext context) {
		if (proposal == null)
			return false;
		if (!context.getMatcher().isCandidateMatchingPrefix(proposal, prefix))
			return false;
		if (conflictHelper.existsConflict(proposal, context))
			return false;
		return true;
	}
	

	protected ConfigurableCompletionProposal doCreateProposal(String proposal, StyledString displayString, Image image,
			int replacementOffset, int replacementLength) {
		return new ConfigurableCompletionProposal(proposal, replacementOffset, replacementLength, proposal.length(),
				image, displayString, null, null);
	}

	protected ConfigurableCompletionProposal doCreateProposal(String proposal, StyledString displayString, Image image,
			int priority, ContentAssistContext context) {
		int replacementOffset = context.getReplaceRegion().getOffset();
		int replacementLength = context.getReplaceRegion().getLength();
		ConfigurableCompletionProposal result = doCreateProposal(proposal, displayString, image, replacementOffset,
				replacementLength);
		result.setPriority(priority);
		result.setMatcher(context.getMatcher());
		result.setReplaceContextLength(getReplacementContextLength(context));
		return result;
	}
	
	protected int getReplacementContextLength(ContentAssistContext context) {
		return context.getReplaceContextLength();
	}

}
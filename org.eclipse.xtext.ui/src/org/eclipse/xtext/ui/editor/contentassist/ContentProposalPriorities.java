/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.util.Strings;

public class ContentProposalPriorities implements IContentProposalPriorities {
	
	protected int crossReferencePriority = 500;
	protected int keywordPriority = 300;
	protected int defaultPriority = 400;
	protected int proposalWithPrefixMultiplier = 2;
	// do not treat perfect matches differently, by default, but allow subclasses to change this:
	protected double sameTextMultiplier = proposalWithPrefixMultiplier;
	
	protected void adjustPriority(ICompletionProposal proposal, String prefix, int priority) {
		if (proposal == null || !(proposal instanceof ConfigurableCompletionProposal))
			return;
		ConfigurableCompletionProposal castedProposal = (ConfigurableCompletionProposal) proposal;
		if (castedProposal.getPriority() != getDefaultPriority())
			return;
		int adjustedPriority = priority;
		if (!Strings.isEmpty(prefix)) {
			if (castedProposal.getReplacementString().equals(prefix))
				adjustedPriority = (int) (adjustedPriority * sameTextMultiplier);
			else
				adjustedPriority = adjustedPriority * proposalWithPrefixMultiplier;
		}
		castedProposal.setPriority(adjustedPriority);
	}
	
	@Override
	public void adjustKeywordPriority(ICompletionProposal proposal, String prefix) {
		adjustPriority(proposal, prefix, keywordPriority);
	}

	@Override
	public void adjustCrossReferencePriority(ICompletionProposal proposal, String prefix) {
		adjustPriority(proposal, prefix, crossReferencePriority);
	}

	@Override
	public int getDefaultPriority() {
		return defaultPriority;
	}

}
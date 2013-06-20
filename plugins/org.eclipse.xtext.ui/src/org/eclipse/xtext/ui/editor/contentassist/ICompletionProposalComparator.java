/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import java.util.Comparator;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.xtext.ui.editor.quickfix.QuickAssistCompletionProposal;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ICompletionProposalComparator.NaturalOrder.class)
public interface ICompletionProposalComparator extends Comparator<ICompletionProposal> {

	class NaturalOrder implements ICompletionProposalComparator {
		public int compare(ICompletionProposal o1, ICompletionProposal o2) {
			Integer relevance1 = getRelevance(o1);
			Integer relevance2 = getRelevance(o2);
			if (relevance1 != null && relevance2 != null) {
				int res = relevance2.compareTo(relevance1);
				if (res != 0) {
					return res;
				}
			}
			return o1.getDisplayString().compareTo(o2.getDisplayString());
		}

		/**
		 * Returns relevance of given proposal.
		 * 
		 * @param proposal either a {@link ConfigurableCompletionProposal} or a {@link TemplateProposal}
		 * @return relevance (higher value indicates higher relevance) or <code>null</code>
		 * @since 2.3
		 */
		protected Integer getRelevance(ICompletionProposal proposal) {
			if (proposal instanceof ConfigurableCompletionProposal) {
				return ((ConfigurableCompletionProposal) proposal).getPriority();
			} else if (proposal instanceof TemplateProposal) {
				return ((TemplateProposal) proposal).getRelevance();
			} else if (proposal instanceof QuickAssistCompletionProposal) {
				return ((QuickAssistCompletionProposal) proposal).getRelevance();
			}
			return null;
		}
	}
}

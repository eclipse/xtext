/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ProposalFilterSorterUtil {
	protected static final Comparator<ICompletionProposal> PROPOSAL_COMPARATOR = new Comparator<ICompletionProposal>() {
		public int compare(ICompletionProposal o1, ICompletionProposal o2) {
			return o1.getDisplayString().compareTo(o2.getDisplayString());
		}
	};
	
	private static Logger logger = Logger.getLogger(IProposalProvider.class);
	
	public static List<? extends ICompletionProposal> sortAndFilter(
			List<? extends ICompletionProposal> completionProposalList, IContentAssistContext contentAssistContext) {
		Map<String, ICompletionProposal> displayString2ICompletionProposalMap = new HashMap<String, ICompletionProposal>();
		for (Iterator<? extends ICompletionProposal> iterator = completionProposalList.iterator(); iterator.hasNext();) {
			ICompletionProposal completionProposal = iterator.next();
			// filter duplicate
			if (!displayString2ICompletionProposalMap.containsKey(completionProposal.getDisplayString())) {
				displayString2ICompletionProposalMap.put(completionProposal.getDisplayString(), completionProposal);
				// filter by prefix
				if (isFiltered(completionProposal)) {
					if (logger.isDebugEnabled()) {
						logger.debug("filter completionProposal '" + completionProposal + "'");
					}
					iterator.remove();
				}
			}
			else {
				if (logger.isDebugEnabled()) {
					logger.debug("filter duplicate completionProposal '" + completionProposal + "'");
				}
				iterator.remove();
			}
		}
		Collections.sort(completionProposalList, PROPOSAL_COMPARATOR);
		return completionProposalList;
	}

	/**
	 * The default behavior of this method delegates to
	 * {@link XtextCompletionProposal#matches(String)} to test if the given
	 * prefix string matches or not.
	 * 
	 * @param completionProposal
	 *            contains information used to present the proposed completion
	 *            to the user
	 * @return true or false whether the given prefix matches the text of this
	 *         completion proposal
	 */
	protected static boolean isFiltered(ICompletionProposal completionProposal) {
		if (completionProposal instanceof XtextCompletionProposal) {
			XtextCompletionProposal xtextCompletionProposal = (XtextCompletionProposal) completionProposal;
			return !xtextCompletionProposal.matches();
		}
		return false;
	}

}

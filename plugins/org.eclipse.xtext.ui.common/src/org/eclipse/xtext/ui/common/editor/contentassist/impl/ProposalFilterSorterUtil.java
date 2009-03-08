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
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Michael Clay - Initial contribution and API
 */
public class ProposalFilterSorterUtil {
	private static Logger logger = Logger.getLogger(IProposalProvider.class);
	
	protected static final Comparator<ICompletionProposal> PROPOSAL_COMPARATOR = new Comparator<ICompletionProposal>() {
		public int compare(ICompletionProposal o1, ICompletionProposal o2) {
			return o1.getDisplayString().compareTo(o2.getDisplayString());
		}
	};
	
	public static List<? extends ICompletionProposal> filter(
			List<? extends ICompletionProposal> completionProposalList, IContentAssistContext contentAssistContext) {
		Map<String, ICompletionProposal> displayString2ICompletionProposalMap = new HashMap<String, ICompletionProposal>();
		for (Iterator<? extends ICompletionProposal> iterator = completionProposalList.iterator(); iterator.hasNext();) {
			ICompletionProposal completionProposal = iterator.next();
			if (!displayString2ICompletionProposalMap.containsKey(completionProposal.getDisplayString())) {
				displayString2ICompletionProposalMap.put(completionProposal.getDisplayString(), completionProposal);
				if (!Strings.isEmpty(contentAssistContext.getMatchString()) && 
						(!completionProposal.getDisplayString().toUpperCase().startsWith(contentAssistContext.getMatchString().toUpperCase()) ||
								completionProposal.getDisplayString().equalsIgnoreCase(contentAssistContext.getMatchString()))) {
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
		return completionProposalList;
	}
	
	public static List<? extends ICompletionProposal> sort(List<? extends ICompletionProposal> completionProposalList) { 
		Collections.sort(completionProposalList, PROPOSAL_COMPARATOR);
		return completionProposalList;
	}

}

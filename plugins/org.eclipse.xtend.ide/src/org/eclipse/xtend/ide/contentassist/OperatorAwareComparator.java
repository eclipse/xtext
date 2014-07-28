/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalComparator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OperatorAwareComparator extends ICompletionProposalComparator.NaturalOrder {

	@Override
	public int compare(ICompletionProposal o1, ICompletionProposal o2) {
		Integer relevance1 = getRelevance(o1);
		Integer relevance2 = getRelevance(o2);
		if (relevance1 != null && relevance2 != null) {
			int res = relevance2.compareTo(relevance1);
			if (res != 0) {
				return res;
			}
		}
		String displayString1 = o1.getDisplayString();
		String displayString2 = o2.getDisplayString();
		if (Character.isJavaIdentifierStart(displayString1.charAt(0))) {
			if (!Character.isJavaIdentifierStart(displayString2.charAt(0))) {
				return -1;
			}
		} else if (Character.isJavaIdentifierStart(displayString2.charAt(0))) {
			return 1;
		}
		return displayString1.compareToIgnoreCase(displayString2);
	}
	
}

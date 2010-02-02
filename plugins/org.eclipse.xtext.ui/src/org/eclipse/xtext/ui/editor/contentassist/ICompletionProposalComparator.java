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

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ICompletionProposalComparator.NaturalOrder.class)
public interface ICompletionProposalComparator extends Comparator<ICompletionProposal> {

	class NaturalOrder implements ICompletionProposalComparator {
		@SuppressWarnings("unchecked")
		public int compare(ICompletionProposal o1, ICompletionProposal o2) {
			if (o1 instanceof Comparable<?> && o2 instanceof Comparable<?>)
				return ((Comparable<ICompletionProposal>) o1).compareTo(o2);
			return o1.getDisplayString().compareTo(o2.getDisplayString());
		}
	}
}

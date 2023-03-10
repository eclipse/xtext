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

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ICompletionProposalPostProcessor.NullProcessor.class)
public interface ICompletionProposalPostProcessor {

	ICompletionProposal[] postProcess(ICompletionProposal[] proposals);

	public class NullProcessor implements ICompletionProposalPostProcessor {

		@Override
		public ICompletionProposal[] postProcess(ICompletionProposal[] proposals) {
			return proposals;
		}

	}
}

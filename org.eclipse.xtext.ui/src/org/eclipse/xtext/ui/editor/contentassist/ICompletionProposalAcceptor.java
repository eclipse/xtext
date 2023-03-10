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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ICompletionProposalAcceptor {

	void accept(ICompletionProposal proposal);
	
	boolean canAcceptMoreProposals();
	
	class Delegate implements ICompletionProposalAcceptor {

		private final ICompletionProposalAcceptor delegate;
		
		public Delegate(ICompletionProposalAcceptor delegate) {
			this.delegate = delegate;
		}

		public ICompletionProposalAcceptor getDelegate() {
			return delegate;
		}
		
		@Override
		public void accept(ICompletionProposal proposal) {
			delegate.accept(proposal);
		}

		@Override
		public boolean canAcceptMoreProposals() {
			return delegate.canAcceptMoreProposals();
		}
		
	}
}
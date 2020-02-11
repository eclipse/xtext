/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CompletionProposalBasedModification implements IModification {

	private final ICompletionProposal proposal;

	public CompletionProposalBasedModification(ICompletionProposal proposal) {
		this.proposal = proposal;
	}
	
	@Override
	public void apply(IModificationContext context) throws Exception {
		proposal.apply(context.getXtextDocument());
	}
	
}

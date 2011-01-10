/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	public void apply(IModificationContext context) throws Exception {
		proposal.apply(context.getXtextDocument());
	}
	
}

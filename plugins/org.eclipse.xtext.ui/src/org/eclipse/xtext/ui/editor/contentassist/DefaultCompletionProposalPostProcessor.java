/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultCompletionProposalPostProcessor implements ICompletionProposalPostProcessor {

	public ICompletionProposal[] postProcess(ICompletionProposal[] proposals) {
		if (proposals.length == 1) {
			if (proposals[0] instanceof ConfigurableCompletionProposal) {
				ConfigurableCompletionProposal proposal = (ConfigurableCompletionProposal) proposals[0];
				if (proposal.isAutoInsertable() && proposal.getReplaceContextLength() > proposal.getReplacementLength()) {
					proposal.setAutoInsertable(false);
				}
			}
		}
		return proposals;
	}
	
}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal.IReplacementTextApplier;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class ReplacementTextApplier implements IReplacementTextApplier {

	@Override
	public void apply(IDocument document, ConfigurableCompletionProposal proposal) throws BadLocationException {
		String replacementString = getActualReplacementString(proposal);
		proposal.setCursorPosition(replacementString.length());
		document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(), replacementString);
	}

	public abstract String getActualReplacementString(ConfigurableCompletionProposal proposal);

}

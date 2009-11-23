/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.common.editor.contentassist.ICompletionProposalFactory;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConvertingCompletionProposalFactory implements ICompletionProposalFactory {

	private final ICompletionProposalFactory delegate;

	public ConvertingCompletionProposalFactory(ICompletionProposalFactory delegate) {
		this.delegate = delegate;
	}
	
	public ICompletionProposal createCompletionProposal(String proposal, String displayString, Image image,
			ContentAssistContext contentAssistContext) {
		return delegate.createCompletionProposal(
				convertProposal(proposal), 
				convertDisplayString(displayString), 
				image, 
				contentAssistContext);
	}

	public String convertProposal(String proposal) {
		return proposal;
	}
	
	public String convertDisplayString(String displayString) {
		return displayString;
	}
}

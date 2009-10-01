/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ICompletionProposalFactory {

	public ICompletionProposal createCompletionProposal(String proposal, ContentAssistContext contentAssistContext);

	public ICompletionProposal createCompletionProposal(String proposal, Image image, ContentAssistContext contentAssistContext);

	public ICompletionProposal createCompletionProposal(String proposal, String displayString, Image image, ContentAssistContext contentAssistContext);

}

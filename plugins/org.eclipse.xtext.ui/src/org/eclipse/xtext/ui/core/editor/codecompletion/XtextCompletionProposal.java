/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.codecompletion;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension2;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension6;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.ui.core.internal.CoreLog;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextCompletionProposal implements ICompletionProposal, ICompletionProposalExtension2,
		ICompletionProposalExtension6 {

	private final Proposal proposal;
	private final int offset;

	public XtextCompletionProposal(Proposal proposal, int offset) {
		this.proposal = proposal;
		this.offset = offset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposal#apply(org.eclipse
	 * .jface.text.IDocument)
	 */
	public void apply(IDocument document) {
		try {
			document.replace(offset, 0, proposal.getText());
		}
		catch (BadLocationException e) {
			CoreLog.logError(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.ICompletionProposal#
	 * getAdditionalProposalInfo()
	 */
	public String getAdditionalProposalInfo() {
		return proposal.getDescription() == null ? "" : proposal.getDescription() + " Additional";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.ICompletionProposal#
	 * getContextInformation()
	 */
	public IContextInformation getContextInformation() {
		return new ContextInformation(proposal.getImage(), proposal.getText(), proposal.getDescription());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposal#getDisplayString
	 * ()
	 */
	public String getDisplayString() {
		return proposal.getLabel().getString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getImage()
	 */
	public Image getImage() {
		return proposal.getImage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#apply
	 * (org.eclipse.jface.text.ITextViewer, char, int, int)
	 */
	public void apply(ITextViewer viewer, char trigger, int stateMask, int offset) {
		apply(viewer.getDocument());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#selected
	 * (org.eclipse.jface.text.ITextViewer, boolean)
	 */
	public void selected(ITextViewer viewer, boolean smartToggle) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#unselected
	 * (org.eclipse.jface.text.ITextViewer)
	 */
	public void unselected(ITextViewer viewer) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#validate
	 * (org.eclipse.jface.text.IDocument, int,
	 * org.eclipse.jface.text.DocumentEvent)
	 */
	public boolean validate(IDocument document, int offset, DocumentEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.ICompletionProposalExtension6#
	 * getStyledDisplayString()
	 */
	public StyledString getStyledDisplayString() {
		return proposal.getLabel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposal#getSelection
	 * (org.eclipse.jface.text.IDocument)
	 */
	public Point getSelection(IDocument document) {
		return null;
	}
}

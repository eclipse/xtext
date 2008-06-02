/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.codecompletion;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
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
import org.eclipse.xtext.ui.core.internal.Activator;
import org.eclipse.xtext.ui.core.internal.CoreLog;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextCompletionProposal implements ICompletionProposal, ICompletionProposalExtension2,
		ICompletionProposalExtension6 {

	private final Proposal proposal;
	private final int offset;
	private final StyledString styledString;
	private Image image;

	public XtextCompletionProposal(Proposal proposal, int offset) {
		this.proposal = proposal;
		this.offset = offset;
		if (proposal.getLabel() != null) {
			this.styledString = proposal.getLabel();
		}
		else {
			this.styledString = new StyledString(proposal.getText());
		}
		if (proposal.getImage() != null)
			initializeImage();
	}

	private void initializeImage() {
		Image im = JFaceResources.getImage(proposal.getImage());
		if (im == null) {
			ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
					proposal.getImage());
			if (imageDescriptorFromPlugin != null) {
				JFaceResources.getImageRegistry().put(proposal.getImage(), imageDescriptorFromPlugin);
				im = JFaceResources.getImage(proposal.getImage());
			}
		}
		this.image = im;
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
		return proposal.getDescription() == null ? null : proposal.getDescription() + " Additional";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.ICompletionProposal#
	 * getContextInformation()
	 */
	public IContextInformation getContextInformation() {
		return new ContextInformation(getImage(), proposal.getText(), proposal.getDescription());
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
		return this.image;
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
		if (Activator.DEBUG_PROPOSALS_PROVIDER)
			System.out.println("XtextCompletionProposal.selected(): " + proposal.getLabel());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#unselected
	 * (org.eclipse.jface.text.ITextViewer)
	 */
	public void unselected(ITextViewer viewer) {
		if (Activator.DEBUG_PROPOSALS_PROVIDER)
			System.out.println("XtextCompletionProposal.unselected(): " + proposal.getLabel());
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
		return this.styledString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposal#getSelection
	 * (org.eclipse.jface.text.IDocument)
	 */
	public Point getSelection(IDocument document) {
		return new Point(offset + proposal.getText().length(), 0);
	}
}

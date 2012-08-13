/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class QuickAssistCompletionProposal implements ICompletionProposal, ICompletionProposalExtension3 {

	private Position pos;
	private IssueResolution resolution;
	private Image image;

	public QuickAssistCompletionProposal(Position pos, IssueResolution resolution, Image image) {
		this.pos = pos;
		this.resolution = resolution;
		this.image = image;
	}

	public void apply(IDocument document) {
		resolution.apply();
	}

	public Point getSelection(IDocument document) {
		return new Point(pos.offset, 0);
	}

	public String getAdditionalProposalInfo() {
		return resolution.getDescription();
	}

	public String getDisplayString() {
		return resolution.getLabel();
	}
	
	/**
	 * @since 2.4
	 */
	public int getRelevance() {
		return resolution.getRelevance();
	}

	public Image getImage() {
		return image;
	}

	public IContextInformation getContextInformation() {
		return null;
	}

	public IInformationControlCreator getInformationControlCreator() {
		return null;
	}

	public int getPrefixCompletionStart(IDocument document, int completionOffset) {
		return 0;
	}

	public CharSequence getPrefixCompletionText(IDocument document, int completionOffset) {
		return null;
	}

}
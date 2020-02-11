/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.core.runtime.Assert;
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
		Assert.isNotNull(pos);
		Assert.isNotNull(resolution);
		this.pos = pos;
		this.resolution = resolution;
		this.image = image;
	}

	@Override
	public void apply(IDocument document) {
		resolution.apply();
	}

	@Override
	public Point getSelection(IDocument document) {
		return new Point(pos.offset, 0);
	}

	@Override
	public String getAdditionalProposalInfo() {
		return resolution.getDescription();
	}

	@Override
	public String getDisplayString() {
		return resolution.getLabel();
	}
	
	/**
	 * @since 2.4
	 */
	public int getRelevance() {
		return resolution.getRelevance();
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public IContextInformation getContextInformation() {
		return null;
	}

	@Override
	public IInformationControlCreator getInformationControlCreator() {
		return null;
	}

	@Override
	public int getPrefixCompletionStart(IDocument document, int completionOffset) {
		return 0;
	}

	@Override
	public CharSequence getPrefixCompletionText(IDocument document, int completionOffset) {
		return null;
	}

}
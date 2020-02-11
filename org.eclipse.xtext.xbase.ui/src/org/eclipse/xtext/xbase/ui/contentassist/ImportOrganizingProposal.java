/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportOrganizingProposal extends ConfigurableCompletionProposal {

	protected ITextRegion importRegion;

	protected String organizedImportSection;

	protected ReplacingAppendable appendable;

	public ImportOrganizingProposal(ReplacingAppendable appendable, int replacementOffset, int replacementLength,
			int cursorPosition, Image image, StyledString displayString) {
		super(appendable.getCode(), replacementOffset, replacementLength, cursorPosition, image, displayString, null, null);
		this.appendable = appendable;
	}
	
	@Override
	public void setTextApplier(IReplacementTextApplier textApplier) {
		throw new UnsupportedOperationException("ImportOrganizingProposal does not support custom text appliers");
	}

	@Override
	public void apply(IDocument document) {
		try {
			int shiftOffsetBy = appendable.commitChanges(getReplacementOffset(), getReplacementLength());
			setSelectionStart(getSelectionStart() + shiftOffsetBy);
			setCursorPosition(getCursorPosition() + shiftOffsetBy);
			if (isLinkedMode()) {
				setUpLinkedMode(document);
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Public for testing purpose.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public ReplacingAppendable getAppendable() {
		return appendable;
	}

}

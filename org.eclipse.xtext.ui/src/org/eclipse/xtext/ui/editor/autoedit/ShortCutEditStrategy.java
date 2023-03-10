/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;

/**
 * A simple {@link IAutoEditStrategy} for shortcuts. Replaces the given shortcut by the given replacement.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ShortCutEditStrategy extends AbstractEditStrategy implements ISourceViewerAware {

	private String shortcut, longForm;
	private boolean matched = false;
	private ISourceViewer sourceViewer;

	public ShortCutEditStrategy configure(String shortcut, String replacement) {
		this.shortcut = shortcut;
		this.longForm = replacement;
		return this;
	}

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		matched = false;
		int shortCutIndex = shortcut.length() - 1;
		boolean isLastCharacterOfShortCut = command.text.equals(shortcut.substring(shortCutIndex));
		int startOffset = command.offset - shortCutIndex;
		boolean isShortCut = startOffset>=0 && document.get(startOffset, shortCutIndex).equals(shortcut.subSequence(0, shortCutIndex));
		if (isLastCharacterOfShortCut && isShortCut) {
			command.offset = startOffset;
			command.length = shortCutIndex;
			command.text = longForm;
			matched = true;
		}
	}

	@Override
	public void setSourceViewer(ISourceViewer sourceViewer) {
		if (sourceViewer instanceof SourceViewer)
			this.sourceViewer = sourceViewer;
		((SourceViewer) sourceViewer).prependVerifyKeyListener(this);
	}

	@Override
	public void verifyKey(VerifyEvent event) {
		if (matched && event.keyCode == 27) {
			Point range = sourceViewer.getSelectedRange();
			try {
				sourceViewer.getDocument().replace(range.x - longForm.length(), longForm.length(), shortcut);
				sourceViewer.setSelectedRange(range.x - longForm.length() + shortcut.length(), 0);
				matched = false;
			} catch (BadLocationException e) {
				handleBadLocationException(e);
			}
		}
	}

}

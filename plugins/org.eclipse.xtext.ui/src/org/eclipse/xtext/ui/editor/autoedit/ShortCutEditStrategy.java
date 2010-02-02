/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;

/**
 * 
 * A simple {@link IAutoEditStrategy} for shortcuts.
 * Replaces the given shortcut by the given replacement. 
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ShortCutEditStrategy implements IAutoEditStrategy, ISourceViewerAware, VerifyKeyListener {
	
	private String shortcut,longForm;
	private boolean matched = false;
	private ISourceViewer sourceViewer;
	
	public ShortCutEditStrategy configure(String shortcut, String replacement) {
		this.shortcut = shortcut;
		this.longForm = replacement;
		return this;
	}

	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		try {
			matched  = false;
			int shortCutIndex = shortcut.length()-1;
			boolean isLastCharacterOfShortCut = command.text.equals(shortcut.substring(shortCutIndex));
			boolean isShortCut = document.get(command.offset-shortCutIndex, shortCutIndex).equals(shortcut.subSequence(0, shortCutIndex));
			if (isLastCharacterOfShortCut && isShortCut) {
				command.offset = command.offset-shortCutIndex;
				command.length = shortCutIndex;
				command.text = longForm;
				matched = true;
			}
		} catch (BadLocationException e) {
		}
		
	}

	public void setSourceViewer(ISourceViewer sourceViewer) {
		if (sourceViewer instanceof SourceViewer)
			this.sourceViewer = sourceViewer;
			((SourceViewer) sourceViewer).prependVerifyKeyListener(this);
	}

	public void verifyKey(VerifyEvent event) {
		if (matched && event.keyCode == 27) {
			Point range = sourceViewer.getSelectedRange();
			try {
				sourceViewer.getDocument().replace(range.x - longForm.length(), longForm.length(), shortcut);
				sourceViewer.setSelectedRange(range.x - longForm.length() + shortcut.length(), 0);
			} catch (BadLocationException e) {
			}
		}
	}

}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.hover;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.ui.core.XtextUIMessages;

/**
 * @author Patrick Schoenbach - Initial API and implementation
 */

public abstract class AbstractHover implements IAnnotationHover, ITextHover, ITextHoverExtension2 {

	protected final ISourceViewer sourceViewer;

	public AbstractHover(final ISourceViewer sourceViewer) {
		if (sourceViewer == null)
			throw new IllegalArgumentException();

		this.sourceViewer = sourceViewer;
	}

	public IDocument getDocument() {
		return sourceViewer.getDocument();
	}

	public String getHoverInfo(final ISourceViewer sourceViewer, final int lineNumber) {
		return getHoverInfoInternal(lineNumber, -1);
	}

	@Deprecated
	public String getHoverInfo(final ITextViewer textViewer, final IRegion hoverRegion) {
		return getHoverInfo2(textViewer, hoverRegion);
	}

	// for TextHover
	public String getHoverInfo2(final ITextViewer textViewer, final IRegion hoverRegion) {
		int lineNumber;
		try {
			lineNumber = getDocument().getLineOfOffset(hoverRegion.getOffset());
		}
		catch (final BadLocationException e) {
			return null;
		}
		return getHoverInfoInternal(lineNumber, hoverRegion.getOffset());
	}

	public IRegion getHoverRegion(final ITextViewer textViewer, final int offset) {
		final Point selection = textViewer.getSelectedRange();
		if (selection.x <= offset && offset < selection.x + selection.y)
			return new Region(selection.x, selection.y);
		return new Region(offset, 0);
	}

	protected String formatInfo(final List<String> messages) {
		final StringBuffer buffer = new StringBuffer();
		if (messages.size() > 1) {
			buffer.append(XtextUIMessages.AbstractHover_MultipleMarkers);
			final Iterator<String> e = messages.iterator();
			while (e.hasNext()) {
				splitInfo("- " + e.next() + "\n", buffer);
			}
		}
		else if (messages.size() == 1) {
			splitInfo(messages.get(0), buffer);
		}
		return buffer.toString();
	}

	protected abstract String getHoverInfoInternal(final int lineNumber, final int offset);

	private String splitInfo(final String message, final StringBuffer buffer) {
		String msg = message;
		String prefix = "";
		int pos;
		do {
			pos = msg.indexOf(" ", 60);
			if (pos > -1) {
				buffer.append(prefix + msg.substring(0, pos) + "\n");
				msg = msg.substring(pos);
				prefix = "  ";
			}
			else {
				buffer.append(prefix + msg);
			}
		} while (pos > -1);
		return buffer.toString();
	}
}

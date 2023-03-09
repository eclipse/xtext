/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import java.util.ResourceBundle;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.custom.StyledText;


/**
 * Action for joining two or more lines together by deleting the
 * line delimiters and trimming the whitespace between them.
 *
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public class TextViewerJoinLinesAction extends TextViewerAction {

	private String fJoint= null;

	/**
	 * Creates a line joining action.
	 *
	 * @param bundle the resource bundle for UI strings
	 * @param prefix the prefix for the property keys into <code>bundle</code>
	 * @param viewer the viewer
	 * @param joint the string to put between the lines
	 */
	public TextViewerJoinLinesAction(ResourceBundle bundle, String prefix, ITextViewer viewer, String joint) {
		super(bundle, prefix, viewer);
		Assert.isLegal(joint != null);
		fJoint= joint;
		update();
	}

	@Override
	public void run() {

		ITextViewer viewer= getTextViewer();
		if (viewer == null)
			return;

		if (!canModifyViewer())
			return;

		IDocument document= viewer.getDocument();
		if (document == null)
			return;

		ITextSelection selection= getSelection(viewer);
		if (selection == null)
			return;

		int startLine= selection.getStartLine();
		int endLine= selection.getEndLine();
		try {
			int caretOffset= joinLines(document, startLine, endLine);
			if (caretOffset > -1) {
				StyledText widget= viewer.getTextWidget();
				widget.setRedraw(false);
				adjustHighlightRange(viewer, caretOffset, 0);
				viewer.revealRange(caretOffset, 0);

				viewer.setSelectedRange(caretOffset, 0);
				widget.setRedraw(true);
			}
		} catch (BadLocationException e) {
			// should not happen
		}

	}
	
	/**
	 * Adjusts the highlight range so that at least the specified range
	 * is highlighted.
	 * <p>
	 * Subclasses may re-implement this method.</p>
	 *
	 * @param offset the offset of the range which at least should be highlighted
	 * @param length the length of the range which at least should be highlighted
	 */
	protected void adjustHighlightRange(ITextViewer viewer, int offset, int length) {
		if (viewer == null)
			return;

		if (viewer instanceof ITextViewerExtension5) {
			ITextViewerExtension5 extension= (ITextViewerExtension5) viewer;
			extension.exposeModelRange(new Region(offset, length));
		} else if (!isVisible(viewer, offset, length)) {
			viewer.resetVisibleRegion();
		}
	}
	
	protected boolean isVisible(ITextViewer viewer, int offset, int length) {
		if (viewer instanceof ITextViewerExtension5) {
			ITextViewerExtension5 extension= (ITextViewerExtension5) viewer;
			IRegion overlap= extension.modelRange2WidgetRange(new Region(offset, length));
			return overlap != null;
		}
		return viewer.overlapsWithVisibleRegion(offset, length);
	}

	@Override
	public void update() {
		super.update();
		if (!isEnabled())
			return;

		if (!canModifyViewer()) {
			setEnabled(false);
			return;
		}

		ITextViewer viewer= getTextViewer();
		setEnabled(viewer.isEditable());
	}

	/**
	 * Joins several text lines to one line.
	 *
	 * @param document the document
	 * @param startLine the start line
	 * @param endLine the end line
	 * @return the new caret offset
	 * @throws BadLocationException if the document is accessed with wrong line or offset
	 */
	private int joinLines(IDocument document, int startLine, int endLine) throws BadLocationException {
		if (startLine == document.getNumberOfLines() - 1) {
			// do nothing because we are in the last line
			return -1;
		}

		if (startLine == endLine)
			endLine++; // append join with the next line

		StringBuffer buffer= new StringBuffer();
		for (int line= startLine; line <= endLine; line++) {
			buffer.append(trim(document, line, line == startLine));
			if (line != endLine)
				buffer.append(fJoint);
		}

		int startLineOffset= document.getLineOffset(startLine);
		int endLineOffset= document.getLineOffset(endLine)	+ document.getLineLength(endLine) - getLineDelimiterLength(document, endLine);
		String replaceString= buffer.toString();
		document.replace(startLineOffset, endLineOffset - startLineOffset, replaceString);
		return startLineOffset + replaceString.length();
	}

	private String trim(IDocument document, int line, boolean ignoreLeadingWhitespace) throws BadLocationException {
		int lineOffset= document.getLineOffset(line);
		int lineLength= document.getLineLength(line);
		lineLength= lineLength - getLineDelimiterLength(document, line);
		if (!ignoreLeadingWhitespace)
			return document.get(lineOffset, lineLength).trim();

		while (lineLength > 0 && Character.isWhitespace(document.getChar(lineOffset + lineLength - 1)))
			lineLength--;

		return document.get(lineOffset, lineLength);
	}

	private int getLineDelimiterLength(IDocument document, int line) throws BadLocationException {
		String lineDelimiter= document.getLineDelimiter(line);
		return lineDelimiter != null ? lineDelimiter.length() : 0;

	}

}

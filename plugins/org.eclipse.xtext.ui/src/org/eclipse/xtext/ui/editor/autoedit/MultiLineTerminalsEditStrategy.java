/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.ui.editor.model.DocumentUtil;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * This strategy applies auto edits when typing a newline character within a block (denoted by a start and end terminal).
 * 
 */
public class MultiLineTerminalsEditStrategy extends AbstractEditStrategy {

	static class CommandInfo {
		String text = "";
		int offset = -1;
		int length = 0;
		int cursorOffset = -1;
		boolean isChange = false;

		public void modifyCommand(DocumentCommand command) {
			if (!isChange)
				return;
			if (cursorOffset != -1) {
				command.caretOffset = cursorOffset;
				command.shiftsCaret = false;
			}
			if (offset != -1)
				command.offset = offset;
			command.length = length;
			command.text = text;
		}
	}

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(MultiLineTerminalsEditStrategy.class);

	private String leftTerminal, rightTerminal, indentationString;

	@Inject
	private IIndentationInformation indentationInformation;

	@Inject
	private DocumentUtil util = new DocumentUtil();

	public MultiLineTerminalsEditStrategy configure(String leftTerminal, String indentationString, String rightTerminal) {
		this.leftTerminal = leftTerminal;
		this.rightTerminal = rightTerminal;
		this.indentationString = indentationString == null ? indentationInformation.getIndentString()
				: indentationString;
		return this;
	}

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (command.length != 0)
			return;
		String originalText = command.text;
		String[] lineDelimiters = document.getLegalLineDelimiters();
		int delimiterIndex = TextUtilities.startsWith(lineDelimiters, originalText);
		if (delimiterIndex != -1) {
			IRegion startTerminal = findStartTerminal(document, command.offset);
			if (startTerminal == null)
				return;
			IRegion stopTerminal = findStopTerminal(document, command.offset);
			if (util.isSameLine(document, startTerminal.getOffset(), command.offset)) {
				CommandInfo newC = handleCursorInFirstLine(document, command, startTerminal, stopTerminal);
				if (newC != null)
					newC.modifyCommand(command);
				return;
			} else if (stopTerminal == null) {
				CommandInfo newC = handleNoStopTerminal(document, command, startTerminal, stopTerminal);
				if (newC != null)
					newC.modifyCommand(command);
				return;
			} else if (!util.isSameLine(document, stopTerminal.getOffset(), command.offset)) {
				CommandInfo newC = handleCursorBetweenStartAndStopLine(document, command, startTerminal, stopTerminal);
				if (newC != null)
					newC.modifyCommand(command);
				return;
			} else {
				CommandInfo newC = handleCursorInStopLine(document, command, startTerminal, stopTerminal);
				if (newC != null)
					newC.modifyCommand(command);
				return;
			}
		}
	}

	/**
	 * finds the first start terminal which is not closed before the cursor position.
	 */
	protected IRegion findStopTerminal(IDocument document, int offset) throws BadLocationException {
		IRegion stop = util.searchInSamePartition(rightTerminal, document, offset);
		if (stop==null)
			return null;
		IRegion start = util.searchInSamePartition(leftTerminal, document, offset);
		if (start != null && start.getOffset()<stop.getOffset())
			return findStopTerminal(document, stop.getOffset()+stop.getLength());
		return stop;
	}

	/**
	 * finds the first stop terminal which has not been started after the cursor position.
	 */
	protected IRegion findStartTerminal(IDocument document, int offset) throws BadLocationException {
		IRegion start = util.searchBackwardsInSamePartition(leftTerminal, document, offset);
		if (start==null)
			return null;
		IRegion stop = util.searchBackwardsInSamePartition(rightTerminal, document, offset);
		if (stop != null && stop.getOffset()>start.getOffset())
			return findStartTerminal(document, start.getOffset());
		return start;
	}

	/**
	 * Expects the cursor to be in the same line as the start terminal
	 * puts any text between start terminal and cursor into a separate newline before the cursor.
	 * puts any text between cursor and end terminal into a separate newline after the cursor.
	 * puts the closing terminal into a separate line at the end.
	 * adds a closing terminal if not existent.
	 */
	protected CommandInfo handleCursorInFirstLine(IDocument document, DocumentCommand command, IRegion startTerminal,
			IRegion stopTerminal) throws BadLocationException {
		CommandInfo newC = new CommandInfo();
		newC.isChange = true;
		int afterStartTerminal = startTerminal.getOffset() + startTerminal.getLength();
		String string = document.get(afterStartTerminal, command.offset - afterStartTerminal);
		newC.offset = afterStartTerminal;
		if (string.trim().length() > 0)
			newC.text += command.text + indentationString + (string.trim());
		newC.text += command.text + indentationString;
		newC.cursorOffset = afterStartTerminal + newC.text.length();
		newC.length += string.length();
		if (stopTerminal == null) {
			IRegion line = document.getLineInformation(document.getLineOfOffset(command.offset));
			if (document.get(command.offset, line.getOffset() + line.getLength() - command.offset).trim().length() == 0) {
				newC.text += command.text + rightTerminal + command.text;
			}
		}
		if (stopTerminal != null && util.isSameLine(document, stopTerminal.getOffset(), command.offset)) {
			string = document.get(command.offset, stopTerminal.getOffset() - command.offset);
			if (string.trim().length() > 0)
				newC.text += command.text + indentationString + (string.trim());
			newC.text += command.text;
			newC.length += string.length();
		}
		return newC;
	}

	/**
	 * Expects the cursor not to be in the first line of the block
	 * inserts a closing terminal if not existent.
	 */
	protected CommandInfo handleNoStopTerminal(IDocument document, DocumentCommand command, IRegion startTerminal,
			IRegion stopTerminal) throws BadLocationException {
		IRegion line = document.getLineInformation(document.getLineOfOffset(command.offset));
		if (document.get(command.offset, line.getOffset() + line.getLength() - command.offset).trim().length() == 0) {
			CommandInfo newC = new CommandInfo();
			newC.isChange = true;
			newC.cursorOffset = command.offset + command.text.length();
			newC.text += command.text + rightTerminal + command.text;
			return newC;
		}
		return null;
	}

	/**
	 * Does nothing subclasses may override
	 */
	protected CommandInfo handleCursorBetweenStartAndStopLine(IDocument document, DocumentCommand command,
			IRegion startTerminal, IRegion stopTerminal) throws BadLocationException {
		return null;
	}

	/**
	 * puts any text between cursor and end terminal into a separate newline after the cursor.
	 * puts the closing terminal into a separate line at the end.
	 */
	protected CommandInfo handleCursorInStopLine(IDocument document, DocumentCommand command, IRegion startTerminal,
			IRegion stopTerminal) throws BadLocationException {
		CommandInfo newC = new CommandInfo();
		newC.isChange = true;
		newC.text += command.text + indentationString;
		newC.cursorOffset = command.offset+newC.text.length();
		String string = document.get(command.offset, stopTerminal.getOffset() - command.offset);
		newC.length = string.length();
		newC.text += string.trim()+command.text;
		return newC;
	}
}
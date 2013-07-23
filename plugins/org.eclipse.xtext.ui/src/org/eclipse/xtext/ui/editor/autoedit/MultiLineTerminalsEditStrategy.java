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
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * This strategy applies auto edits when typing a newline character within a block (denoted by a start and end terminal).
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class MultiLineTerminalsEditStrategy extends AbstractTerminalsEditStrategy {
	
	public static class Factory {
		@Inject
		private MembersInjector<MultiLineTerminalsEditStrategy> injector;
		@Inject
		private IIndentationInformation indentationInformation;
		
		public MultiLineTerminalsEditStrategy newInstance(String leftTerminal, String indentationString, String rightTerminal) {
			return newInstance(leftTerminal, indentationString, rightTerminal, true);
		}
		
		/**	
		 * @since 2.4	
		 * */	
		public MultiLineTerminalsEditStrategy newInstance(String leftTerminal, String indentationString, String rightTerminal, boolean nested) {	
			indentationString = indentationString == null ? indentationInformation.getIndentString() : indentationString;
			MultiLineTerminalsEditStrategy strategy = new MultiLineTerminalsEditStrategy(leftTerminal, indentationString, rightTerminal, nested);
			injector.injectMembers(strategy);	
			return strategy;
		}
	}

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(MultiLineTerminalsEditStrategy.class);
	
	/**	
	 * <p>Whether the pair of terminals can be nested or not.</p>
	 * */
	private final boolean nested;

	private String indentationString;
	
	public MultiLineTerminalsEditStrategy(String leftTerminal, String indentationString, String rightTerminal) {
		this(leftTerminal, indentationString, rightTerminal, true);
	}

	/**
	 * @since 2.4
	 */
	public MultiLineTerminalsEditStrategy(String leftTerminal, String indentationString, String rightTerminal, boolean nested) {
		super(leftTerminal,rightTerminal);
		this.nested = nested;
		this.indentationString = indentationString;
	}

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (isLineDelimiter(document, command)) {
			IRegion startTerminal = findStartTerminal(document, command.offset);
			if (startTerminal == null)
				return;
			IRegion stopTerminal = findStopTerminal(document, command.offset);
			// check whether this is our stop terminal
			if (stopTerminal != null && nested) {
				IRegion previousStart = startTerminal;
				IRegion previousStop = stopTerminal;
				while(stopTerminal != null && previousStart != null && previousStop != null) {
					previousStart = findStartTerminal(document, previousStart.getOffset());
					if (previousStart != null) {
						previousStop = findStopTerminal(document, previousStop.getOffset() + 1);
						if (previousStop == null) {
							stopTerminal = null;
						}
					}
				}
			}
			if (util.isSameLine(document, startTerminal.getOffset(), command.offset)) {
				if (stopTerminal != null && stopTerminal.getLength() < getRightTerminal().length())
					stopTerminal = null;
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

	private boolean isLineDelimiter(IDocument document, DocumentCommand command) {
		if (command.length != 0) {
			return false;
		}
		String originalText = command.text;
		String[] lineDelimiters = document.getLegalLineDelimiters();
		int delimiterIndex = TextUtilities.startsWith(lineDelimiters, originalText);
		return delimiterIndex != -1 && originalText.trim().length() == 0;
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
		newC.offset = command.offset;
		newC.text += command.text + indentationString;
		newC.cursorOffset = command.offset + newC.text.length();
		if (stopTerminal == null && atEndOfLineInput(document, command.offset)) {
			newC.text += command.text + getRightTerminal();
		}
		if (stopTerminal != null && stopTerminal.getOffset() >= command.offset && util.isSameLine(document, stopTerminal.getOffset(), command.offset)) {
			String string = document.get(command.offset, stopTerminal.getOffset() - command.offset);
			if (string.trim().length() > 0)
				newC.text += string.trim();
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
		if (atEndOfLineInput(document, command.offset)) {
			CommandInfo newC = new CommandInfo();
			newC.isChange = true;
			String textPartBeforeCursor = command.text + Strings.removeLeadingWhitespace(indentationString);
			newC.cursorOffset = command.offset+textPartBeforeCursor.length();
			newC.text = textPartBeforeCursor + command.text + Strings.removeLeadingWhitespace(getRightTerminal());
			return newC;
		}
		return null;
	}

	/**
	 * adds a new line with required indentation after the cursor.
	 */
	protected CommandInfo handleCursorBetweenStartAndStopLine(IDocument document, DocumentCommand command,
			IRegion startTerminal, IRegion stopTerminal) throws BadLocationException {
		if (indentationString.trim().length()>0 && !atBeginningOfLineInput(document, command.offset)) {
			CommandInfo newC = new CommandInfo();
			newC.isChange = true;
			newC.text += command.text + Strings.removeLeadingWhitespace(indentationString);
			return newC;
		}
		return null;
	}

	/**
	 * delegates to {@link #handleCursorBetweenStartAndStopLine(IDocument, DocumentCommand, IRegion, IRegion)}.
	 */
	protected CommandInfo handleCursorInStopLine(IDocument document, DocumentCommand command, IRegion startTerminal,
			IRegion stopTerminal) throws BadLocationException {
		return handleCursorBetweenStartAndStopLine(document, command, startTerminal, stopTerminal);
	}

	/**
	 * determines whether the given offset is at the beginning of the input in the line. leading whitespace is disregarded.
	 */
	private boolean atBeginningOfLineInput(IDocument document, int offset) throws BadLocationException {
		IRegion line = document.getLineInformation(document.getLineOfOffset(offset));
		return document.get(line.getOffset(), offset - line.getOffset()).trim().length() == 0;
	}

	/**
	 * determines whether the given offset is at the end of the input in the line. trailing whitespace is disregarded.
	 */
	protected boolean atEndOfLineInput(IDocument document, int offset) throws BadLocationException {
		IRegion line = document.getLineInformation(document.getLineOfOffset(offset));
		return document.get(offset, line.getOffset() + line.getLength() - offset).trim().length() == 0;
	}

}
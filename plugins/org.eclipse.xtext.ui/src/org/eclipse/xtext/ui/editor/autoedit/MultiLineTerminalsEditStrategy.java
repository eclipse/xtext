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
 * This strategy applies certain auto edits for blocks when typing a newline character. 
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
			IRegion startTerminal = util.searchBackwardsInSamePartition(leftTerminal, document, command.offset);
			if (startTerminal == null)
				return;
			IRegion stopTerminal = util.searchInSamePartition(rightTerminal, document, command.offset);
			if (stopTerminal == null) {
				// is there a closing terminal between the start and the cursor?
				if (util.searchInSamePartition(rightTerminal, document, startTerminal.getOffset()+startTerminal.getLength())!=null)
					return;
			}
			CommandInfo newC = new CommandInfo();
			if (util.isSameLine(document, startTerminal.getOffset(), command.offset)) {
				newC.isChange = true;
				int afterStartTerminal = startTerminal.getOffset() + startTerminal.getLength();
				String string = document.get(afterStartTerminal, command.offset - afterStartTerminal);
				newC.offset = afterStartTerminal;
				if (string.trim().length() > 0)
					newC.text += command.text + indentationString + (string.trim());
				newC.text += command.text + indentationString;
				newC.cursorOffset = afterStartTerminal + newC.text.length();
				newC.length += string.length();
			}
			if (stopTerminal==null) {
				newC.isChange = true;
				IRegion line = document.getLineInformation(document.getLineOfOffset(command.offset));
				if (document.get(command.offset, line.getOffset()+line.getLength()-command.offset).trim().length()==0) {
					newC.text+=command.text+rightTerminal+command.text;
				}
			}
			if (stopTerminal!=null && util.isSameLine(document, stopTerminal.getOffset(), command.offset)) {
				newC.isChange = true;
				String string = document.get(command.offset, stopTerminal.getOffset() - command.offset);
				if (string.trim().length() > 0)
					newC.text += command.text + indentationString + (string.trim());
				newC.text += command.text;
				newC.length += string.length();
			}
			newC.modifyCommand(command);
		}
	}

}
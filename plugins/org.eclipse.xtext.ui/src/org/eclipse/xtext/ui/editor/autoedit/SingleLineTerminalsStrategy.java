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
import org.eclipse.jface.text.IDocument;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SingleLineTerminalsStrategy extends AbstractEditStrategy  {

	private String left;
	private String right;

	public SingleLineTerminalsStrategy configure(char left, char right) {
		this.left = String.valueOf(left);
		this.right = String.valueOf(right);
		return this;
	}

	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		try {
			handleInsertLeftTerminal(document, command);
			handleInsertRightTerminal(document, command);
			handleDeletion(document, command);
		} catch (BadLocationException e) {
		}
	}

	protected void handleInsertLeftTerminal(IDocument document, DocumentCommand command) throws BadLocationException {
		if (command.text.equals(left) && !isIdentifierPart(document, command.offset)) {
			int opening = count(left, getTextToScan(document));
			int closing = count(right, getTextToScan(document));
			int occurences = opening + closing;
			if (occurences % 2 == 0) {
				command.text = left + right;
				command.length = 0;
				command.caretOffset = command.offset + left.length();
				command.shiftsCaret = false;
			}
		}
	}

	protected void handleDeletion(IDocument document, DocumentCommand command) throws BadLocationException {
		if (command.text.equals("")) {
			String string = document.get(command.offset - left.length() + 1, left.length() + right.length());
			if (string.equals(left + right)) {
				command.offset = command.offset - (left.length() - 1);
				command.length = left.length() + right.length();
			}
		}
	}

	protected void handleInsertRightTerminal(IDocument document, DocumentCommand command) throws BadLocationException {
		//closing terminal
		if (command.text.equals(right)) {
			int opening = count(left, getTextToScan(document));
			int closing = count(right, getTextToScan(document));
			if (opening == closing && (opening + closing) % 2 == 0) {
				command.length++;
			}
		}
	}
}

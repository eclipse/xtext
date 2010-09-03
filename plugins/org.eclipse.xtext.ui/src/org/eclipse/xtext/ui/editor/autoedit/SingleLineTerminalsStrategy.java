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
public class SingleLineTerminalsStrategy extends AbstractEditStrategy {

	private String left;
	private String right;

	public SingleLineTerminalsStrategy configure(String left, String right) {
		this.left = left;
		this.right = right;
		return this;
	}
	
	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		handleInsertLeftTerminal(document, command);
		handleInsertRightTerminal(document, command);
		handleDeletion(document, command);
	}

	protected void handleInsertLeftTerminal(IDocument document, DocumentCommand command) throws BadLocationException {
		if (command.text.length() > 0 && (appliedText(document, command) + command.text).endsWith(left)
				&& !isIdentifierPart(document, command.offset + command.length)) {
			String documentContent = getDocumentContent(document, command);
			int opening = count(left, documentContent);
			int closing = count(right, documentContent);
			int occurences = opening + closing;
			if (occurences % 2 == 0) {
				command.caretOffset = command.offset + command.text.length();
				command.text = command.text + right;
				command.shiftsCaret = false;
			}
		}
	}

	protected String appliedText(IDocument document, DocumentCommand command) throws BadLocationException {
		String string = document.get(0, command.offset);
		return string + command.text;
	}

	protected void handleDeletion(IDocument document, DocumentCommand command) throws BadLocationException {
		if (command.text.equals("") && command.length == 1) {
			if (command.offset + right.length() + left.length() > document.getLength())
				return;
			if (command.offset + command.length - left.length() < 0)
				return;
			if (command.length != left.length())
				return;
			String string = document.get(command.offset, left.length() + right.length());
			if (string.equals(left + right)) {
				command.length = left.length() + right.length();
			}
		}
	}

	protected void handleInsertRightTerminal(IDocument document, DocumentCommand command) throws BadLocationException {
		//closing terminal
		if (command.text.equals(right) && command.length == 0) {
			if (command.offset + right.length() > document.getLength())
				return;
			String documentContent = getDocumentContent(document, command);
			int opening = count(left, documentContent);
			int closing = count(right, documentContent);
			if (opening <= closing && right.equals(document.get(command.offset, command.text.length()))) {
				command.length += right.length();
			}
		}
	}

}

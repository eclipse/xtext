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

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SameTerminalsEditStrategy extends AbstractEditStrategy {

	private final static Logger log = Logger.getLogger(SameTerminalsEditStrategy.class);
	
	private String terminal;

	public SameTerminalsEditStrategy configure(char terminal) {
		this.terminal = String.valueOf(terminal);
		return this;
	}

	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		try {
			if (command.text.equals(terminal) && !isIdentifierPart(document, command.offset + command.length)) {
				String documentContent = getDocumentContent(document, command);
				int count = count(terminal, documentContent);
				if (count % 2 == 0) {
					if (command.offset + command.length < document.getLength()) {
						String nextChar = String.valueOf(document.getChar(command.offset + command.length));
						if (terminal.equals(nextChar)) {
							if (command.length == 0) {
								command.length = 1;
							}
						} else {
							appendClosingTerminal(documentContent, count, command);
						}
					} else {
						appendClosingTerminal(documentContent, count, command);
					}
				}
			}
			if (command.text.equals("") && command.length == terminal.length()) {
				if (command.offset + 2 * terminal.length() > document.getLength())
					return;
				if (command.offset + command.length - terminal.length() < 0)
					return;
				String string = document.get(command.offset, 2 * terminal.length());
				if (string.equals(terminal + terminal)) {
					command.length*=2;
				}
			}
		} catch (BadLocationException ex) {
			log.error("Exception in AutoEditStrategy", ex);
		}
	}

	protected void appendClosingTerminal(String documentContent, int occurenceCount, DocumentCommand command) throws BadLocationException {
		if (documentContent.length() > command.offset) {
			String leadingContent = documentContent.substring(0, command.offset);
			int leadingCount = count(terminal, leadingContent);
			if (leadingCount == occurenceCount / 2)
				return;
		}
		command.text = terminal + terminal;
		command.caretOffset = command.offset + terminal.length();
		command.shiftsCaret = false;
	}

}

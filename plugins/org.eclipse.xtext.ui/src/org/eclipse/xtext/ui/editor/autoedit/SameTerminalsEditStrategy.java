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
public class SameTerminalsEditStrategy extends AbstractEditStrategy {

	private String terminal;

	public SameTerminalsEditStrategy configure(char terminal) {
		this.terminal = String.valueOf(terminal);
		return this;
	}

	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		try {
			if (command.text.equals(terminal)) {
				int count = count(terminal, getTextToScan(document));
				if (count % 2 == 0) {
					// closing terminal
					try {
						if (terminal.equals(document.get(command.offset, terminal.length()))) {
							command.text = terminal;
							command.length = 1;
							command.caretOffset = command.offset + 1;
							command.shiftsCaret = false;
							return;
						}
					} catch (BadLocationException e) {
						//ignore
					}
					if (!isIdentifierPart(document, command.offset)) {
						command.text = terminal + terminal;
						command.length = 0;
						command.caretOffset = command.offset + 1;
						command.shiftsCaret = false;
					}
				}
			}
			if (command.text.equals("") && document.get(command.offset, 2).equals(terminal + terminal)) {
				command.length++;
			}
		} catch (BadLocationException e) {
			//ignore
		}
	}

}

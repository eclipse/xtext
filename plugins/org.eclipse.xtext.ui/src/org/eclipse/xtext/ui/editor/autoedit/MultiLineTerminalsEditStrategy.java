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
import org.eclipse.xtext.formatting.IIndentationInformation;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MultiLineTerminalsEditStrategy extends AbstractEditStrategy {

	private final static Logger log = Logger.getLogger(MultiLineTerminalsEditStrategy.class);
	
	private String leftTerminal, rightTerminal, indentationString;

	@Inject
	private IIndentationInformation indentationInformation;

	public MultiLineTerminalsEditStrategy configure(String leftTerminal, String indentationString, String rightTerminal) {
		this.leftTerminal = leftTerminal;
		this.rightTerminal = rightTerminal;
		this.indentationString = indentationString == null ? indentationInformation.getIndentString()
				: indentationString;
		return this;
	}

	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		try {
			String originalText = command.text;
			if (originalText.startsWith(getNewLine())) {
				if (isAfter(document, command.offset, leftTerminal)
						|| (lineStartsWith(document, command.offset, indentationString))) {
					command.text = concat(originalText, indentationString);
					command.caretOffset = command.offset + command.text.length();
					String documentContent = getDocumentContent(document, command);
					int opening = count(leftTerminal, documentContent);
					int closing = count(rightTerminal, documentContent);
					if (opening > closing)
						command.text = command.text + originalText + rightTerminal;
					command.shiftsCaret = false;
				}
			}
		} catch (BadLocationException ex) {
			log.error("Exception in AutoEditStrategy", ex);
		}
	}

	private String concat(String originalText, String indentationString) {
		if (originalText.endsWith(indentationString.substring(0, 1))) {
			return originalText + indentationString.substring(1);
		} else {
			return originalText + indentationString;
		}
	}

	private boolean lineStartsWith(IDocument document, int offset, String indentationString)
			throws BadLocationException {
		IRegion region = document.getLineInformationOfOffset(offset);
		String line = document.get(region.getOffset(), region.getLength());
		if (line.startsWith(indentationString)) {
			return true;
		}
		return false;
	}

	protected String getNewLine() {
		return "\n";
	}

	private boolean isAfter(IDocument doc, int offset, String leftTerminal) throws BadLocationException {
		return doc.getLength() >= offset && offset >= leftTerminal.length() &&
			doc.get(offset - leftTerminal.length(), leftTerminal.length()).equals(leftTerminal);
	}

}

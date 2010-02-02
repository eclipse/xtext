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
import org.eclipse.xtext.formatting.IIndentationInformation;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MultiLineTerminalsEditStrategy extends AbstractEditStrategy {
	
	private String leftTerminal,rightTerminal,indentationString;
	
	@Inject
	private IIndentationInformation indentationInformation;
	
	public MultiLineTerminalsEditStrategy configure(String leftTerminal, String indentationString, String rightTerminal) {
		this.leftTerminal = leftTerminal;
		this.rightTerminal = rightTerminal;
		this.indentationString = indentationString==null?indentationInformation.getIndentString():indentationString;
		return this;
	}

	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		try {
			String originalText = command.text;
			if (originalText.startsWith(getNewLine()) && isAfter(document, command.offset, leftTerminal)) {
				command.caretOffset=command.offset+originalText.length()+indentationString.length();
				command.text = originalText + indentationString;
				int opening = count(leftTerminal, getTextToScan(document));
				int closing = count(rightTerminal, getTextToScan(document));
				if (opening>closing)
					command.text = command.text+originalText+rightTerminal;
				command.shiftsCaret=false;
			}
		} catch (BadLocationException e) {
		}
	}

	protected String getNewLine() {
		return "\n";
	}

	private boolean isAfter(IDocument doc, int offset, String leftTerminal) throws BadLocationException {
		return doc.get(offset - leftTerminal.length(), leftTerminal.length()).equals(leftTerminal);
	}

}

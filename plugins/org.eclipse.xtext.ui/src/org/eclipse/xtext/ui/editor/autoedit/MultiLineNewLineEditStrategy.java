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
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextUtilities;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MultiLineNewLineEditStrategy extends AbstractEditStrategy {
	
	private String separator;
	private String endTerminal;

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (!isNewLine(document, command))
			return;
		String indentation = getIndentation(document,command);
		
		int length = 0;
		String text = "";
		// handle first newline
		if (isFirstLine(document, command)) {
			ITypedRegion partition = document.getPartition(command.offset);
			String suffix = document.get(command.offset, partition.getOffset() + partition.getLength() - command.offset);
			if (suffix.trim().equals(endTerminal.trim())) {
				length += suffix.length();
				text += command.text +indentation+ endTerminal;
			}
		}
		command.shiftsCaret = false;
		command.caretOffset = command.offset + command.text.length() + indentation.length() + separator.length();
		command.text += indentation + separator + text;
		command.length = length;
	}
	
	protected boolean isFirstLine(IDocument document, DocumentCommand command) throws BadLocationException {
		ITypedRegion partition = document.getPartition(command.offset);
		return document.getLineOfOffset(partition.getOffset()) == document.getLineOfOffset(partition.getOffset()
				+ partition.getLength());
	}

	protected String getIndentation(IDocument document, DocumentCommand command) throws BadLocationException {
		ITypedRegion partition = document.getPartition(command.offset);
		int line = document.getLineOfOffset(partition.getOffset());
		IRegion lineInformation = document.getLineInformation(line);
		String prefix = document.get(lineInformation.getOffset(), partition.getOffset()-lineInformation.getOffset());
		if (prefix.trim().length()==0)
			return prefix;
		StringBuilder b = new StringBuilder(prefix.length());
		for (int i=0;i<prefix.length();i++)
			b.append(" ");
		return b.toString();
	}

	protected boolean isNewLine(IDocument document, DocumentCommand command) {
		String[] lineDelimiters = document.getLegalLineDelimiters();
		return TextUtilities.startsWith(lineDelimiters, command.text)!=-1;
	}

	public IAutoEditStrategy configure(String separator, String endTerminal) {
		this.separator = separator;
		this.endTerminal = endTerminal;
		return this;
	}

}

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
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractEditStrategy implements IAutoEditStrategy{
	
	private final static Logger log = Logger.getLogger(AbstractEditStrategy.class);

	/**
	 * @deprecated use {@link #count(String, String)} instead.
	 */
	@Deprecated
	public int count(String toFind, StringBuilder searchMe) throws BadLocationException {
		return count(toFind, searchMe.toString());
	}
	
	public int count(String toFind, String searchMe) throws BadLocationException {
		int count = 0;
		int index = -toFind.length();
		while (true) {
			index = searchMe.indexOf(toFind, index + toFind.length());
			if (index == -1) {
				return count;
			} else {
				count++;
			}
		}
	}
	
	/**
	 * @deprecated use {@link #getDocumentContent(IDocument)}
	 */
	@Deprecated
	protected StringBuilder getTextToScan(IDocument document) {
		return new StringBuilder(document.get());
	}
	
	protected String getDocumentContent(IDocument document, DocumentCommand command) {
		if (command.length == 0)
			return document.get();
		try {
			StringBuilder result = new StringBuilder(document.getLength() + command.length);
			if (command.offset > 0)
				result.append(document.get(0, command.offset));
			if (command.offset + command.length < document.getLength())
				result.append(document.get(command.offset + command.length, document.getLength() - command.offset + command.length));
			return result.toString();
		} catch(BadLocationException ex) {
			log.error("Exception in AutoEditStrategy", ex);
			return document.get();
		}
	}
	
	protected boolean isIdentifierPart(IDocument doc, int offset) {
		if (doc.getLength()<=offset) {
			return false;
		}
		try {
			char c = doc.getChar(offset);
			return Character.isJavaIdentifierPart(c);
		} catch (BadLocationException e) {
			log.debug(e.getMessage(), e);
		}
		return false;
	}
}

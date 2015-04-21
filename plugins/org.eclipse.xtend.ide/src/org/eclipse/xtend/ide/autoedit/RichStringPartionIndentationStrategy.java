/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.autoedit;

import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IRegion;

/**
 * This strategy handles a paste of multiline text into a RichtString.
 * It applies the current indentation to the line 2..n of the pasted text.
 * 
 * @author Holger Schill - Initial contribution and API
 */
public class RichStringPartionIndentationStrategy extends DefaultIndentLineAutoEditStrategy {

	@Override
	public void customizeDocumentCommand(IDocument d, DocumentCommand c) {
		if(c.text.length() > 1){
			try {
				int line = d.getLineOfOffset(c.offset);
				String lineIndentation = getLineIndentation(d, c.offset);
				String[] legalLineDelimiters = d.getLegalLineDelimiters();
				String regex = "[";
				for(String s : legalLineDelimiters) {
					regex+= Pattern.quote(s);
				}
				regex += "]";
				String[] lines = c.text.split(regex);
				String convertedText = lines[0];
				for(int i = 1; i < lines.length ; i++){
					convertedText += ((IDocumentExtension4) d).getDefaultLineDelimiter() +  lineIndentation + lines[i];
				}
				c.text = convertedText;
			} catch (BadLocationException e) {
				super.customizeDocumentCommand(d, c);
			}
		}
		super.customizeDocumentCommand(d, c);
	}

	private String getLineIndentation(IDocument document, int offset) throws BadLocationException {
		int adjustedOffset= (offset == document.getLength() ? offset  - 1 : offset);
		IRegion line= document.getLineInformationOfOffset(adjustedOffset);
		int start= line.getOffset();
		int end= findEndOfWhiteSpace(document, start, offset);
		return document.get(start, end - start);
	}
}

/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.autoedit

import java.util.regex.Pattern
import org.eclipse.jface.text.BadLocationException
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy
import org.eclipse.jface.text.DocumentCommand
import org.eclipse.jface.text.IDocument

import static extension org.eclipse.jface.text.TextUtilities.*

class RichStringPartionIndentationStrategy extends DefaultIndentLineAutoEditStrategy {
	override void customizeDocumentCommand(IDocument d, DocumentCommand c) {
		if (c.text.length() > 1 && !d.legalLineDelimiters.contains(c.text)) {
			try {
				val lineIndentation = getLineIndentation(d, c.offset)
				val legalLineDelimiters = d.legalLineDelimiters.sortBy[s|s.length].reverseView
				val defaultLineDelimiter = d.defaultLineDelimiter
				val regex = legalLineDelimiters.join('(', ')|(', ')')[delimiter|Pattern.quote(delimiter)]
				val pattern = Pattern.compile(regex)
				val matcher = pattern.matcher(c.text)
				val convertedText = new StringBuilder
				var currentStart = 0 
				var currentEnd = 0
				while(matcher.find) {
					currentEnd = matcher.start
					if(currentStart != 0) 
						convertedText.append(lineIndentation)
					convertedText.append(c.text.substring(currentStart, currentEnd))
					convertedText.append(defaultLineDelimiter)
					currentStart = matcher.end
				}
				if(currentStart < c.text.length) {
					if(currentStart != 0) 
						convertedText.append(lineIndentation)
					convertedText.append(c.text.substring(currentStart))
				}
				c.text = convertedText.toString
			} catch (BadLocationException e) {
				super.customizeDocumentCommand(d, c)
			}
		}
		super.customizeDocumentCommand(d, c)
	}

	def String getLineIndentation(IDocument document, int offset) throws BadLocationException {
		var adjustedOffset = if(offset === document.getLength()) offset - 1 else offset
		var line = document.getLineInformationOfOffset(adjustedOffset)
		var start = line.offset
		var end = findEndOfWhiteSpace(document, start, offset)
		document.get(start, end - start)
	}
}

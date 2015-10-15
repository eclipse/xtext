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
				val regex = legalLineDelimiters.join('(', ')|(', ')')[delimiter|Pattern.quote(delimiter)]
				val lines = c.text.split(regex)
				val defaultLineDelimiter = d.defaultLineDelimiter
				val convertedText = '''«lines.head»«FOR line : lines.tail»«defaultLineDelimiter»«lineIndentation»«line»«ENDFOR»'''
				c.text = convertedText
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

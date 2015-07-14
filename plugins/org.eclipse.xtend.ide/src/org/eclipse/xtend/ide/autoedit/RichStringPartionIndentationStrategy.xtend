package org.eclipse.xtend.ide.autoedit

import java.util.regex.Pattern
import org.eclipse.jface.text.BadLocationException
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy
import org.eclipse.jface.text.DocumentCommand
import org.eclipse.jface.text.IDocument
import org.eclipse.jface.text.IDocumentExtension4

class RichStringPartionIndentationStrategy extends DefaultIndentLineAutoEditStrategy {
	override void customizeDocumentCommand(IDocument d, DocumentCommand c) {
		if (c.text.length() > 1 && !d.legalLineDelimiters.contains(c.text)) {
			try {
				var lineIndentation = getLineIndentation(d, c.offset)
				var legalLineDelimiters = d.getLegalLineDelimiters().sortBy[ s | s.length].reverseView
				var StringBuilder regex = new StringBuilder(Pattern.quote(legalLineDelimiters.get(0)))
				for(delimiter: legalLineDelimiters.tail){
					regex.append("|(" + Pattern.quote(delimiter) + ")")
				}
				var lines = c.text.split(regex.toString)
				var defaultLineDelimiter = (d as IDocumentExtension4).getDefaultLineDelimiter()
				var convertedText = '''«FOR l : lines SEPARATOR defaultLineDelimiter + lineIndentation»«l»«ENDFOR»'''
				c.text = convertedText
			} catch (BadLocationException e) {
				super.customizeDocumentCommand(d, c)
			}

		}
		super.customizeDocumentCommand(d, c)
	}

	def String getLineIndentation(IDocument document, int offset) throws BadLocationException {
		var adjustedOffset = (if(offset === document.getLength()) offset - 1 else offset )
		var line = document.getLineInformationOfOffset(adjustedOffset)
		var start = line.getOffset()
		var end = findEndOfWhiteSpace(document, start, offset)
		document.get(start, end - start)
	}

}

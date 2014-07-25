package org.eclipse.xtend.core.formatting2

import com.google.inject.Inject
import java.util.List
import java.util.Stack
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler
import org.eclipse.xtend.core.richstring.RichStringProcessor
import org.eclipse.xtend.core.xtend.RichString
import org.eclipse.xtend.core.xtend.RichStringElseIf
import org.eclipse.xtend.core.xtend.RichStringForLoop
import org.eclipse.xtend.core.xtend.RichStringIf
import org.eclipse.xtend.core.xtend.RichStringLiteral
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.ITextSegment
import org.eclipse.xtext.formatting2.internal.TextSegment
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XbasePackage

import static org.eclipse.xtext.formatting2.FormatterPreferenceKeys.*

/**
 * cases to distinguish:
 * 	1. single-line
 *  2. multi-line with text after opening ''': lines start with semantic whitespace
 *  3. multi-line with text before closing ''': no indentation
 *  4. multi-line with only whitespace after opening ''' and before closing ''': one level of extra indentation between ''' and '''
 */
@FinalFieldsConstructor class RichStringFormatter {

	public static class Factory {
		@Inject RichStringProcessor richStringProcessor

		def RichStringFormatter create(ITextRegionAccess regionAccess, XtendFormatter formatter) {
			new RichStringFormatter(this, regionAccess, formatter)
		}
	}

	val Factory factory
	val extension ITextRegionAccess
	val XtendFormatter formatter

	def void format(IFormattableDocument doc, RichString richString) {
		if (EcoreUtil2.getContainerOfType(richString.eContainer, RichString) != null)
			return;
		if (richString.hasSyntaxError)
			return;
		val impl = new RichStringToLineModel(_iTextRegionAccess, richString)
		factory.richStringProcessor.process(richString, impl, new DefaultIndentationHandler())
		impl.finish()

		//		println()
		//		println("-------------------------")
		//		println(richString.nodeForEObject.text)
		//		println("-------------------------")
		//		println(impl.model)
		//		println("-------------------------")
		fmt(doc, richString)
		val lines = impl.model.lines
		val canIndent = !lines.empty && lines.last.content.nullOrEmpty
		for (line : lines) {
			if (impl.model.rootIndentLenght > 0) {
				val increaseIndentationChange = if(canIndent && line == lines.head) 1 else 0
				val decraseIndentationChange = if(canIndent && line == lines.last) 1 else 0
				val nloffset = if(line.leadingSemanticNewLine) line.offset + line.newLineCharCount else line.offset
				val i = Math.min(line.indentLength, impl.model.rootIndentLenght)
				val nllength = if(line.leadingSemanticNewLine) i else line.newLineCharCount + i
				if (line.leadingSemanticNewLine) {
					doc.setNewLines(nloffset, nllength, increaseIndentationChange, decraseIndentationChange, 0)
				} else {
					doc.setNewLines(nloffset, nllength, increaseIndentationChange, decraseIndentationChange, 1)
				}
				if (!line.chunks.empty) {
					val offset = nloffset + nllength
					val length = line.indentLength - impl.model.rootIndentLenght
					val text = line.chunks.map [ chunk |
						switch chunk {
							SemanticWhitespace: chunk.text
							TemplateWhitespace: doc.preferences.getPreference(indentation)
						}
					].join
					doc.setSpace(offset, length, text)
				}
			}
		}
		println()
	}

	def protected setNewLines(IFormattableDocument doc, int offset, int length, int indentationIncrease,
		int indentationDecrease, int newLines) {
		val fmt = formatter.createHiddenRegionFormatting => [
			it.indentationIncrease = indentationIncrease
			it.indentationDecrease = indentationDecrease
			it.newLinesMin = newLines
			it.newLinesDefault = newLines
			it.newLinesMax = newLines
		]
		val replacer = formatter.createWhitespaceReplacer(new TextSegment(_iTextRegionAccess, offset, length), fmt)
		doc.addReplacer(replacer)
	}

	def protected setSpace(IFormattableDocument doc, int offset, int length, String space) {
		val fmt = formatter.createHiddenRegionFormatting => [
			it.space = space
		]
		val replacer = formatter.createWhitespaceReplacer(new TextSegment(_iTextRegionAccess, offset, length), fmt)
		doc.addReplacer(replacer)
	}

	def protected dispatch void fmt(IFormattableDocument doc, RichString expr) {
		for (e : expr.expressions)
			fmt(doc, e)
	}

	def protected dispatch void fmt(IFormattableDocument doc, RichStringLiteral expr) {
	}

	def protected dispatch void fmt(IFormattableDocument doc, Void expr) {
	}

	def protected dispatch void fmt(extension IFormattableDocument doc, XExpression expr) {
		expr.surround[noSpace]
		formatter.format(expr, doc)
	}

	def protected dispatch void fmt(extension IFormattableDocument doc, RichStringIf expr) {
		expr.regionForKeyword("IF").prepend[noSpace].append[oneSpace]
		expr.elseIfs.last.append[noSpace]
		formatter.format(expr.^if, doc)
		fmt(doc, expr.then)
		for (elseif : expr.elseIfs)
			fmt(doc, elseif)
		expr.regionForKeyword("ELSE").surround[noSpace]
		fmt(doc, expr.^else)
		expr.regionForKeyword("ENDIF").surround[noSpace]
	}

	def protected dispatch void fmt(extension IFormattableDocument doc, RichStringElseIf expr) {
		expr.regionForKeyword("ELSEIF").prepend[noSpace].append[oneSpace]
		expr.^if.append[noSpace]
		formatter.format(expr.^if, doc)
	}

	def protected dispatch void fmt(extension IFormattableDocument doc, RichStringForLoop expr) {
		expr.regionForKeyword("FOR").prepend[noSpace].append[oneSpace]
		expr.regionForKeyword(":").prepend[oneSpace].append[oneSpace]
		formatter.format(expr.declaredParam, doc)
		formatter.format(expr.forExpression, doc)
		fmt(doc, expr.eachExpression)
		expr.regionForKeyword("BEFORE").surround[oneSpace]
		formatter.format(expr.before, doc)
		expr.regionForKeyword("SEPARATOR").surround[oneSpace]
		formatter.format(expr.separator, doc)
		expr.regionForKeyword("AFTER").surround[oneSpace]
		formatter.format(expr.after, doc)
		expr.eachExpression.prepend[noSpace]
		expr.regionForKeyword("ENDFOR").surround[noSpace]
	}
}

class RichStringToLineModel extends AbstractRichStringPartAcceptor.ForLoopOnce {
	private val RichString string
	private val String document
	private val ITextRegionAccess nodeModelAccess
	@Accessors val LineModel model = new LineModel
	int offset = - 1
	int contentStartOffset = - 1
	int contentStartColumn = - 1
	private Stack<Chunk> indentationStack = new Stack
	private boolean content = false
	private boolean indentNextLine = false
	private boolean _outdentThisLine = false
	private int lastLiteralEndOffset

	new(ITextRegionAccess nodeModelAccess, RichString string) {
		this.nodeModelAccess = nodeModelAccess
		this.string = string
		this.document = (nodeModelAccess as ITextSegment).getText()
	}

	def outdentThisLine() {
		if (indentNextLine)
			indentNextLine = false
		else
			_outdentThisLine = true
	}

	def finish() {
		acceptLineBreak(0, false, false)
	}

	def protected literalPrefixLenght(ITextSegment node) {
		switch t:node.text {
			case t.startsWith("'''"): 3
			case t.startsWith("»»"): 2
			case t.startsWith("»"): 1
			default: 1
		}
	}

	def protected literalPostfixLenght(ITextSegment node) {
		switch t:node.text {
			case t.endsWith("'''"): 3
			case t.endsWith('««'): 2
			case t.endsWith("«"): 1
			default: 1
		}
	}

	override announceNextLiteral(RichStringLiteral object) {
		super.announceNextLiteral(object)

		//		println("announceNextLiteral()")
		if (lastLiteralEndOffset > 0 && contentStartOffset < 0)
			contentStartOffset = lastLiteralEndOffset
		val node = nodeModelAccess.regionForFeature(object, XbasePackage.Literals.XSTRING_LITERAL__VALUE)
		if (node != null) {
			offset = node.offset + node.literalPrefixLenght
			lastLiteralEndOffset = node.endOffset - node.literalPostfixLenght
		}
		content = true
	}

	override acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
		super.acceptSemanticLineBreak(charCount, origin, controlStructureSeen)

		//		println("acceptSemanticLineBreak()")
		acceptLineBreak(charCount, true, true)
		offset = offset + charCount
	}

	override acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
		super.acceptTemplateLineBreak(charCount, origin)

		//		println("acceptTemplateLineBreak()")
		acceptLineBreak(charCount, false, true)
		offset = offset + charCount
	}

	def void acceptLineBreak(int charCount, boolean semantic, boolean startNewLine) {
		startContent()
		if (contentStartOffset > 0) {
			val lastLinesContent = document.substring(contentStartOffset, offset)
			if (model.lines.empty) {
				model.leadingText = lastLinesContent
				contentStartColumn = 0
			} else {
				val lastLine = model.lines.last
				lastLine.content = lastLinesContent
				val newContentStartColumn = contentStartOffset - (lastLine.offset + lastLine.newLineCharCount)
				if (lastLine.leadingSemanticNewLine) {
					if (newContentStartColumn > contentStartColumn) {
						val length = newContentStartColumn - contentStartColumn
						val text = document.substring(contentStartOffset - length, contentStartOffset)
						indentationStack.push(new SemanticWhitespace(text, newContentStartColumn))
					}
				}
				if (newContentStartColumn < contentStartColumn) {
					for (ws : indentationStack.filter(SemanticWhitespace).toList) {
						if (ws.column > newContentStartColumn)
							indentationStack.remove(ws)
					}
					val lastWs = indentationStack.last
					val length = if (lastWs === null)
							newContentStartColumn - model.rootIndentLenght
						else if (lastWs instanceof SemanticWhitespace)
							newContentStartColumn - lastWs.column
						else
							0
					if (length > 0) {
						val text = document.substring(contentStartOffset - length, contentStartOffset)
						indentationStack.push(new SemanticWhitespace(text, newContentStartColumn))
					}
				}

				if (_outdentThisLine) {
					if (!indentationStack.empty())
						indentationStack.pop()
					_outdentThisLine = false
				}

				lastLine.indentLength = newContentStartColumn

				// newContentStartColumn is 0 when the line before had a SN and no content -> This shouldn't have impact to a greyspace and should not lead to a increment for the following lines.
				// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=398718
				if (newContentStartColumn != 0)
					contentStartColumn = newContentStartColumn
				model.lines.last.chunks += indentationStack
			}
		}
		if (indentNextLine) {
			indentationStack.push(new TemplateWhitespace(""))
			indentNextLine = false
		}
		contentStartOffset = -1
		content = false
		if (startNewLine)
			model.lines += new Line(offset, semantic, charCount)
	}

	def void startContent() {
		if (!content) {
			contentStartOffset = offset
			content = true
		}
	}

	override acceptSemanticText(CharSequence text, RichStringLiteral origin) {
		super.acceptSemanticText(text, origin)

		//		println('''acceptSemanticText("«text»")''')
		if (!content) {
			if (text.length > 0 &&
				(0 .. (text.length - 1)).fold(false, [v, i|v || !Character.isWhitespace(text.charAt(i))]))
				startContent()
		}
		offset = offset + text.length
	}

	override acceptTemplateText(CharSequence text, RichStringLiteral origin) {
		super.acceptTemplateText(text, origin)

		//		println('''acceptTemplateText("«text»")''')
		if (!content) {
			if (model.rootIndentLenght < 0) {
				model.rootIndentLenght = text.length
				contentStartColumn = text.length
			}
		}
		offset = offset + text.length
	}

	override acceptExpression(XExpression expression, CharSequence indentation) {

		//		println("acceptExpression()")
		super.acceptExpression(expression, indentation)
		startContent()
	}

	override void acceptIfCondition(XExpression condition) {
		super.acceptIfCondition(condition)
		startContent()
		indentNextLine = true
	}

	override void acceptElseIfCondition(XExpression condition) {
		super.acceptElseIfCondition(condition)
		outdentThisLine()
		startContent()
		indentNextLine = true
	}

	override void acceptElse() {
		super.acceptElse()
		outdentThisLine()
		startContent()
		indentNextLine = true
	}

	override void acceptEndIf() {
		super.acceptEndIf()
		outdentThisLine()
		startContent()
	}

	override void acceptForLoop(JvmFormalParameter parameter, XExpression expression) {
		super.acceptForLoop(parameter, expression)
		startContent()
		indentNextLine = true
	}

	override void acceptEndFor(XExpression after, CharSequence indentation) {
		super.acceptEndFor(after, indentation)
		outdentThisLine()
		startContent()
	}
}

@Accessors
class LineModel {
	String leadingText
	int rootIndentLenght = -1
	val List<Line> lines = newArrayList

	override toString() '''
		rootIndentLenght=«rootIndentLenght»
		«leadingText»«lines.join»
	'''
}

@Accessors class Line {
	val int offset
	val boolean leadingSemanticNewLine
	val int newLineCharCount
	val List<Chunk> chunks = newArrayList
	String content
	int indentLength

	override toString() {
		(if(leadingSemanticNewLine) "SN" else "") + "\n" + chunks.join + content
	}
}

@Data abstract class Chunk {
	CharSequence text

	def int getLength() {
		text.length
	}
}

@Data class TemplateWhitespace extends Chunk {
	override toString() {
		"T" + text.length
	}
}

@Data class SemanticWhitespace extends Chunk {
	int column

	override toString() {
		"S" + text.length
	}
}

@Data class SemanitcText extends Chunk {
	override toString() {
		text.toString
	}
}

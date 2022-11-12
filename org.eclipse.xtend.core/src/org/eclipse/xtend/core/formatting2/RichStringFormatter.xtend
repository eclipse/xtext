/*******************************************************************************
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.formatting2

import com.google.inject.Inject
import java.util.List
import java.util.Stack
import org.eclipse.emf.ecore.EObject
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
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting
import org.eclipse.xtext.formatting2.ITextReplacer
import org.eclipse.xtext.formatting2.internal.HiddenRegionReplacer
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeEObjectRegion
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XbasePackage

import static org.eclipse.xtext.formatting2.FormatterPreferenceKeys.*
import org.eclipse.emf.ecore.plugin.EcorePlugin

/**
 * cases to distinguish:
 * 	1. single-line
 *  2. multi-line with text after opening ''': lines start with semantic whitespace
 *  3. multi-line with text before closing ''': no indentation
 *  4. multi-line with only whitespace after opening ''' and before closing ''': one level of extra indentation between ''' and '''
 * 
 * @author Moritz Eysholdt - Initial implementation and API
 * @author Arne Deutsch - Workaround for exception thrown for blank lines
 */
@FinalFieldsConstructor class RichStringFormatter {

	static class Factory {
		@Inject RichStringProcessor richStringProcessor

		def RichStringFormatter create(ITextRegionAccess regionAccess) {
			new RichStringFormatter(this, regionAccess.extensions)
		}
	}

	val Factory factory
	val extension ITextRegionExtensions

	def dispatch void format(RichString richString, IFormattableDocument doc) {
		if (EcoreUtil2.getContainerOfType(richString.eContainer, RichString) !== null)
			return;
		if (richString.regionForEObject.hasSyntaxError)
			return;
		val impl = new RichStringToLineModel(textRegionAccess)
		factory.richStringProcessor.process(richString, impl, new DefaultIndentationHandler())
		impl.finish()

		// println()
		// println("-------------------------")
		// println(richString.nodeForEObject.text)
		// println("-------------------------")
		// println(impl.model)
		// println("-------------------------")
		for (e : richString.expressions)
			format(e, doc)
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
							TemplateWhitespace: doc.formatter.getPreference(indentation)
						}
					].join
					// TODO The if statement is a workaround. Without it an exception is generated in case a blank line
					// without any whitespace is placed e.g. between an «IF». This way the indentation is not correct
					// but at least the file is formatted. There is a test case in XtendRichStringFormatterTest that
					// needs to be adapted as soon as the root cause of the issue is found.
					// See: https://github.com/eclipse/xtext-core/issues/710
					if (length >= 0) {
						doc.setSpace(offset, length, text)
					} else {
						EcorePlugin.INSTANCE.log(new RuntimeException("Programmatic error: length == " + length));
					}
				}
			}
		}
	}
	
	def protected dispatch boolean hasSyntaxError(IEObjectRegion region) {
		false
	}

	def protected dispatch boolean hasSyntaxError(NodeEObjectRegion region) {
		// TODO: remove if https://bugs.eclipse.org/bugs/show_bug.cgi?id=465299 gets fixed 
		val i = region.node.getAsTreeIterable().iterator();
		while (i.hasNext()) {
			if (i.next().getSyntaxErrorMessage() !== null)
				return true;
		}
		return false;
	}

	def protected setNewLines(IFormattableDocument doc, int offset, int length, int indentationIncrease,
		int indentationDecrease, int newLines) {
		val fmt = doc.formatter.createHiddenRegionFormatting => [
			it.indentationIncrease = indentationIncrease
			it.indentationDecrease = indentationDecrease
			it.newLinesMin = newLines
			it.newLinesDefault = newLines
			it.newLinesMax = newLines
		]
		val replacer = doc.formatter.createWhitespaceReplacer(new TextSegment(textRegionAccess, offset, length), fmt)
		doc.addReplacer(replacer)
	}

	def protected setSpace(IFormattableDocument doc, int offset, int length, String space) {
		val fmt = doc.formatter.createHiddenRegionFormatting => [
			it.space = space
		]
		val replacer = doc.formatter.createWhitespaceReplacer(new TextSegment(textRegionAccess, offset, length), fmt)
		doc.addReplacer(replacer)
	}

	def  dispatch void format(RichStringLiteral expr, IFormattableDocument doc) {
	}

	def dispatch void format(Void expr, IFormattableDocument doc) {
	}

	def protected void formatIntoSingleLine(IFormattableDocument doc, EObject obj) {
		doc.formatter.format(obj, doc.withReplacerFilter[suppressLineWraps(it); true])
	}

	def protected dispatch void suppressLineWraps(ITextReplacer it) {
	}

	def protected dispatch void suppressLineWraps(HiddenRegionReplacer it) {
		suppressLineWraps(formatting)
	}

	def protected dispatch  void suppressLineWraps(IHiddenRegionFormatting it) {
		if (space === null)
			space = " "
		it.newLinesMin = null
		newLinesDefault = null
		newLinesMax = null
		autowrap = null
	}

	def dispatch void format(XExpression expr, extension IFormattableDocument doc) {
		expr.surround[noSpace]
		formatIntoSingleLine(doc, expr)
	}

	def dispatch void format(RichStringIf expr, extension IFormattableDocument doc) {
		expr.regionFor.keyword("IF").prepend[noSpace].append[oneSpace]
		expr.elseIfs.last.append[noSpace]
		formatIntoSingleLine(doc, expr.^if)
		format(expr.then, doc)
		for (elseif : expr.elseIfs)
			format(elseif, doc)
		expr.regionFor.keyword("ELSE").surround[noSpace]
		format(expr.^else, doc)
		expr.regionFor.keyword("ENDIF").surround[noSpace]
	}

	def dispatch void format(RichStringElseIf expr, extension IFormattableDocument doc) {
		expr.regionFor.keyword("ELSEIF").prepend[noSpace].append[oneSpace]
		expr.^if.append[noSpace]
		formatIntoSingleLine(doc, expr.^if)
	}

	def dispatch void format(RichStringForLoop expr, extension IFormattableDocument doc) {
		expr.regionFor.keyword("FOR").prepend[noSpace].append[oneSpace]
		expr.regionFor.keyword(":").prepend[oneSpace].append[oneSpace]
		formatIntoSingleLine(doc, expr.declaredParam)
		formatIntoSingleLine(doc, expr.forExpression)
		format(expr.eachExpression, doc)
		expr.regionFor.keyword("BEFORE").surround[oneSpace]
		formatIntoSingleLine(doc, expr.before)
		expr.regionFor.keyword("SEPARATOR").surround[oneSpace]
		formatIntoSingleLine(doc, expr.separator)
		expr.regionFor.keyword("AFTER").surround[oneSpace]
		formatIntoSingleLine(doc, expr.after)
		expr.eachExpression.prepend[noSpace]
		expr.regionFor.keyword("ENDFOR").surround[noSpace]
	}
}

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
class RichStringToLineModel extends AbstractRichStringPartAcceptor.ForLoopOnce {
	val String document
	val ITextRegionAccess nodeModelAccess
	@Accessors val LineModel model = new LineModel
	int offset = - 1
	int contentStartOffset = - 1
	int contentStartColumn = - 1
	Stack<Chunk> indentationStack = new Stack
	boolean content = false
	boolean indentNextLine = false
	boolean _outdentThisLine = false
	int lastLiteralEndOffset

	new(ITextRegionAccess nodeModelAccess) {
		this.nodeModelAccess = nodeModelAccess
		this.document = nodeModelAccess.regionForDocument.text
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

		// println("announceNextLiteral()")
		if (lastLiteralEndOffset > 0 && contentStartOffset < 0)
			contentStartOffset = lastLiteralEndOffset
		val node = nodeModelAccess.regionForEObject(object)?.regionFor?.feature(XbasePackage.Literals.XSTRING_LITERAL__VALUE)
		if (node !== null) {
			offset = node.offset + node.literalPrefixLenght
			lastLiteralEndOffset = node.endOffset - node.literalPostfixLenght
		}
		content = true
	}

	override acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
		super.acceptSemanticLineBreak(charCount, origin, controlStructureSeen)

		// println("acceptSemanticLineBreak()")
		acceptLineBreak(charCount, true, true)
		offset = offset + charCount
	}

	override acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
		super.acceptTemplateLineBreak(charCount, origin)

		// println("acceptTemplateLineBreak()")
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

		// println('''acceptSemanticText("«text»")''')
		if (!content) {
			if (text.length > 0 && (0 .. (text.length - 1)).fold(false, [ v, i |
				v || !Character.isWhitespace(text.charAt(i))
			]))
				startContent()
		}
		offset = offset + text.length
	}

	override acceptTemplateText(CharSequence text, RichStringLiteral origin) {
		super.acceptTemplateText(text, origin)

		// println('''acceptTemplateText("«text»")''')
		if (!content) {
			if (model.rootIndentLenght < 0) {
				model.rootIndentLenght = text.length
				contentStartColumn = text.length
			}
		}
		offset = offset + text.length
	}

	override acceptExpression(XExpression expression, CharSequence indentation) {

		// println("acceptExpression()")
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

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
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

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
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

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Data abstract class Chunk {
	CharSequence text

	def int getLength() {
		text.length
	}
}

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Data class TemplateWhitespace extends Chunk {
	override toString() {
		"T" + text.length
	}
}

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Data class SemanticWhitespace extends Chunk {
	int column

	override toString() {
		"S" + text.length
	}
}

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Data class SemanticText extends Chunk {
	override toString() {
		text.toString
	}
}

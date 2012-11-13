package org.eclipse.xtend.core.formatting

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler
import org.eclipse.xtend.core.richstring.RichStringProcessor
import org.eclipse.xtend.core.xtend.RichString
import org.eclipse.xtend.core.xtend.RichStringIf
import org.eclipse.xtend.core.xtend.RichStringLiteral
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XbasePackage

/**
 * cases to distinguish:
 * 	1. single-line
 *  2. multi-line with text after opening ''': lines start with semantic whitespace
 *  3. multi-line with text before closing ''': no indentation
 *  4. multi-line with only whitespace after opening ''' and before closing ''': one level of extra indentation between ''' and '''
 */
class RichStringFormatter {
	@Inject RichStringProcessor richStringProcessor
	@Inject extension NodeModelAccess
	@Inject extension FormatterExtensions
	
	def format((EObject, FormattableDocument)=>void formatter, FormattableDocument doc, RichString richString) {
		if(EcoreUtil2::getContainerOfType(richString.eContainer, typeof(RichString)) != null)
			return;
		val impl  = new RichStringToLineModel(_nodeModelAccess, richString)
		richStringProcessor.process(richString, impl, new DefaultIndentationHandler())
//		println()
//		println("-------------------------")
//		println(richString.nodeForEObject.text)
//		println("-------------------------")
//		println(impl.model)
//		println("-------------------------")
		val lines = impl.model.otherLines
		if(!lines.empty && lines.forall[chunks.head instanceof TemplateWhitespace && chunks.head.length > 0]) {
			val canIndent = lines.last.chunks.forall[it instanceof TemplateWhitespace]
			for(line:lines) {
				val indentChange = if(canIndent && line == lines.head) 1 else if(canIndent && line == lines.last) -1 else 0
				if(line.leadingSemanticNewLine) 
					doc += new NewLineData(line.offset + line.newLineCharCount, line.chunks.head.length, indentChange, if(doc.debugConflicts) new RuntimeException, 0)
				else {
					doc += new NewLineData(line.offset, line.newLineCharCount + line.chunks.head.length, indentChange, if(doc.debugConflicts) new RuntimeException, 1)
				}
			}
		}
		if(!lines.empty) 
			for(col:(1.. (lines.fold(0, [seed, it | Math::max(seed, it.chunks.size)]))))   
				for(line:lines) {
					if(col < line.chunks.size && line.chunks.subList(0, col).forall[it instanceof TemplateWhitespace || it instanceof SemanitcWhitespace]) {
						val chunk = line.chunks.get(col)
						if(chunk instanceof TemplateWhitespace) {
							val space = doc.getIndentation(1)
							doc += new WhitespaceData(chunk.offset, chunk.length, 0, if(doc.debugConflicts) new RuntimeException, space)
						}
					}
				}
		for(chunk: impl.model.firstLine + lines.map[chunks].flatten) 
			switch chunk {
				Expression: {
					fmt(formatter, doc, chunk.expr)
				}
			}
	}
	
	def protected dispatch void fmt((EObject, FormattableDocument)=>void formatter, FormattableDocument doc, XExpression expr) {
		doc += expr.nodeForEObject.surround[noSpace]
		formatter.apply(expr, doc)
	}
	
	def protected dispatch void fmt((EObject, FormattableDocument)=>void formatter, FormattableDocument doc, RichStringIf expr) {
		doc += expr.nodeForKeyword("IF").surround([noSpace],[oneSpace])
		doc += expr.nodeForFeature(XtendPackage$Literals::RICH_STRING_ELSE_IF__IF).append[noSpace]
		formatter.apply(expr.^if, doc)
		doc += expr.nodeForKeyword("ELSE").surround[noSpace]
		doc += expr.nodeForKeyword("ENDIF").surround[noSpace]
	}
}

class RichStringToLineModel extends AbstractRichStringPartAcceptor$ForLoopOnce {
	private val RichString string
	private val NodeModelAccess nodeModelAccess
	@Property val LineModel model = new LineModel(string)
	int offset
	
	new(NodeModelAccess nodeModelAccess, RichString string) {
		this.nodeModelAccess = nodeModelAccess
		this.string = string
	}
	
	def protected List<Chunk> currentLine() {
		if(model.otherLines.empty) 
			model.firstLine
		else 
			model.otherLines.last.chunks
	}
	
	def protected literalPrefixLenght(INode node) {
		switch t:node.text {
			case t.startsWith("'''"): 3
			case t.startsWith("»»"): 2
			case t.startsWith("»"): 1
			default: 1
		}
	}
	
	override announceNextLiteral(RichStringLiteral object) {
		val node = nodeModelAccess.nodeForFeature(object, XbasePackage$Literals::XSTRING_LITERAL__VALUE)
		if(node != null) 
			offset = node.offset + node.literalPrefixLenght
	}
	
	override acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
		model.otherLines += new Line(offset, true, charCount)
		offset = offset + charCount
	}
	
	override acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
		model.otherLines += new Line(offset, false, charCount)
		offset = offset + charCount 
	}
	
	override acceptSemanticText(CharSequence text, RichStringLiteral origin) {
		if(text.length > 0 && (0..(text.length - 1)).fold(false, [v, i | v || !Character::isWhitespace(text.charAt(i))]))
			currentLine += new SemanitcText(offset, text)
		else 
			currentLine += new SemanitcWhitespace(offset, text)
		offset = offset + text.length
	}
	
	override acceptTemplateText(CharSequence text, RichStringLiteral origin) {
		currentLine += new TemplateWhitespace(offset, text)
		offset = offset + text.length
	}
	
	override acceptExpression(XExpression expression, CharSequence indentation) {
//		val text = nodeModelAccess.nodeForEObject(expression)?.text 
		currentLine += new Expression(offset, null, expression)		
	}
	
	override void acceptIfCondition(XExpression condition) {
		currentLine += new Expression(offset, null, (condition.eContainer() as XExpression))
	}

	override void acceptElseIfCondition(XExpression condition) {
		currentLine += new Dummy(offset, null)
	}

	override void acceptElse() {
		currentLine += new Dummy(offset, null)
	}

	override void acceptEndIf() {
		currentLine += new Dummy(offset, null)
	}
}

@Data class LineModel {
	RichString richString
	List<Chunk> firstLine = newArrayList 
	List<Line> otherLines = newArrayList
	
	override toString() {
		firstLine.join + otherLines.map["\n" + it].join 
	}
}

@Data class Line {
	int offset
	boolean leadingSemanticNewLine
	int newLineCharCount
	List<Chunk> chunks = newArrayList
	
	override toString() {
		(if(leadingSemanticNewLine) "SN" else "TN") + chunks.join
	}
}

@Data abstract class Chunk {
	int offset
	CharSequence text
	def int getLength() {
		text.length
	}
}

@Data class TemplateWhitespace extends Chunk{
	override toString() {
		"T" + text.length
	}	
}

@Data class SemanitcWhitespace extends Chunk {
	override toString() {
		"S" + text.length
	}
}

@Data class SemanitcText extends Chunk {
	override toString() {
		text.toString
	}
}

@Data class Expression extends Chunk {
	XExpression expr
	
	override toString() {
		"<<" + text?.toString + ">>"
	}
}

@Data class Dummy extends Chunk {
	override toString() {
		"<<" + text?.toString + ">>"
	}
}
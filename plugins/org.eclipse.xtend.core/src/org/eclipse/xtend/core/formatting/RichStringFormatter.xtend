package org.eclipse.xtend.core.formatting

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor$ForLoopOnce
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler
import org.eclipse.xtend.core.richstring.RichStringProcessor
import org.eclipse.xtend.core.xtend.RichString
import org.eclipse.xtend.core.xtend.RichStringLiteral
import org.eclipse.xtend.lib.Property
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.xbase.XbasePackage$Literals
import java.util.List
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtend.core.xtend.RichStringIf
import org.eclipse.emf.ecore.EObject

class RichStringFormatter {
	@Inject Provider<RichStringFormatterImpl> provider
	@Inject RichStringProcessor richStringProcessor
	
	def format((EObject, FormattableDocument)=>void formatter, FormattableDocument doc, RichString richString) {
		val impl = provider.get
		impl.formatter = formatter
		impl.document = doc
		richStringProcessor.process(richString, impl, new DefaultIndentationHandler())
		for(offs:impl.indentOffsets)
			doc += new NewLineData(offs, impl.bodyIndent, 0, 0)
		if(impl.indentOffset > 0 && impl.outdentOffset > 0) {
			doc += new WhitespaceData(impl.indentOffset, 0, 1, null)
			doc += new WhitespaceData(impl.outdentOffset, 0, -1, null)
		}
	}
}

class RichStringFormatterImpl extends AbstractRichStringPartAcceptor$ForLoopOnce {
	
	@Inject extension NodeModelAccess
	@Inject extension FormatterExtensions
	@Property var (EObject, FormattableDocument)=>void formatter
	@Property FormattableDocument document
	
	int offset
	boolean afterNewLine = false
	boolean semanticSeen = false
	RichStringLiteral lastLiteral
	@Property int bodyIndent = Integer::MAX_VALUE
	@Property List<Integer> indentOffsets = newArrayList()
	@Property int indentOffset = -1
	@Property int outdentOffset = -1
		
	def protected literalPrefixLenght(INode node) {
		switch t:node.text {
			case t.startsWith("'''"): 3
			case t.startsWith("»»"): 2
			case t.startsWith("»"): 1
			default: 1
		}
	}
	
	override announceNextLiteral(RichStringLiteral object) {
		val node = object.nodeForFeature(XbasePackage$Literals::XSTRING_LITERAL__VALUE)
		if(node.text.startsWith("»"))
			document += node.prepend[noSpace]
		if(node.text.endsWith("«"))
			document += node.append[noSpace]
			
		lastLiteral = object
		offset = node.offset + node.literalPrefixLenght
//					println('''announceNextLiteral(offset=«offset», object=«object.hashCode»)''')
		afterNewLine = false
	}
	
	override acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
//				println('''acceptSemanticLineBreak(offset=«offset», charCount=«charCount», origin=«origin.hashCode», controlStructureSeen=«controlStructureSeen»)''')
		offset = offset + charCount
		afterNewLine = true
		semanticSeen = true
	}
	
	override acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
//				println('''acceptTemplateLineBreak(offset=«offset», charCount=«charCount», origin=«origin.hashCode»)''')
//		document += new NewLineData(offset, charCount, 0, 1)
		if(!semanticSeen)
			indentOffset = offset
		offset = offset + charCount
		afterNewLine = true
	}
	
	override acceptSemanticText(CharSequence text, RichStringLiteral origin) {
//				println('''acceptSemanticText(offset=«offset», text="«text»", origin=«origin?.hashCode»)''')
		offset = offset + text.length
		afterNewLine = false
		semanticSeen = true
	}
	
	override acceptTemplateText(CharSequence text, RichStringLiteral origin) {
//				println('''acceptTemplateText(offset=«offset», text="«text»", origin=«origin?.hashCode»)''')
		if(text.length > 0) {
			if(afterNewLine && lastLiteral != null) {
				val node = lastLiteral.nodeForFeature(XbasePackage$Literals::XSTRING_LITERAL__VALUE)
				if(offset + text.length + 3 == node.offset + node.length) {
					document += new NewLineData(offset, text.length, 0, 0)
					outdentOffset = offset - 2
				} else {
					bodyIndent = Math::min(bodyIndent, text.length)
					indentOffsets += offset
				}
			}
			afterNewLine = false
		}
		offset = offset + text.length
	}
	
	override acceptIfCondition(XExpression condition) {
		if(condition.eContainer instanceof RichStringIf) {
			val rsif = condition.eContainer as RichStringIf
			document += rsif.nodeForKeyword("IF").append[oneSpace]
		}
		formatter.apply(condition, document)
	}
	
	override acceptExpression(XExpression expression, CharSequence indentation) {
		formatter.apply(expression, document)
	}
	
}

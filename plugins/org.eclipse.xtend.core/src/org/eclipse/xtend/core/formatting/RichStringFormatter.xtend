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

class RichStringFormatter {
	@Inject Provider<RichStringFormatterImpl> provider
	@Inject RichStringProcessor richStringProcessor
	
	def format(XtendFormatter formatter, FormattableDocument doc, RichString richString) {
		val impl = provider.get
		impl.formatter = formatter
		impl.document = doc
		richStringProcessor.process(richString, impl, new DefaultIndentationHandler())
	}
}

class RichStringFormatterImpl extends AbstractRichStringPartAcceptor$ForLoopOnce {
	
	@Inject extension NodeModelAccess
	@Inject extension FormatterExtensions
	@Property XtendFormatter formatter
	@Property FormattableDocument document
	
	int offset
	boolean afterSemanticNewLine = false
	
	def protected literalPrefixLenght(INode node) {
		switch t:node.text {
			case t.startsWith("'''"): 3
			case t.startsWith("\u00AB\u00AB"): 2
			case t.startsWith("\u00AB"): 1
			default: 1
		}
	}
	
	override announceNextLiteral(RichStringLiteral object) {
		val node = object.nodeForFeature(XbasePackage$Literals::XSTRING_LITERAL__VALUE)
		offset = node.offset + node.literalPrefixLenght
//		println('''announceNextLiteral(offset=«offset», object=«object.hashCode»)''')
		afterSemanticNewLine = false
	}
	
	override acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
//		println('''acceptSemanticLineBreak(offset=«offset», charCount=«charCount», origin=«origin.hashCode», controlStructureSeen=«controlStructureSeen»)''')
		offset = offset + charCount
		afterSemanticNewLine = true
	}
	
	override acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
//		println('''acceptTemplateLineBreak(offset=«offset», charCount=«charCount», origin=«origin.hashCode»)''')
		document += newFormattingData(offset -> charCount, [newLine])
		offset = offset + charCount
		afterSemanticNewLine = false
	}
	
	override acceptSemanticText(CharSequence text, RichStringLiteral origin) {
//		println('''acceptSemanticText(offset=«offset», text="«text»", origin=«origin?.hashCode»)''')
		offset = offset + text.length
		afterSemanticNewLine = false
	}
	
	override acceptTemplateText(CharSequence text, RichStringLiteral origin) {
//		println('''acceptTemplateText(offset=«offset», text="«text»", origin=«origin?.hashCode»)''')
		val length = text.length 
		if(length > 0) {
			if(afterSemanticNewLine)
				document += new NewLineData(offset, length, 0, 0)
			else 
				document += newFormattingData(offset -> length, [ space = document.cfg.getIndentation(1)])
		}
		offset = offset + length
		afterSemanticNewLine = false
	}
	
}
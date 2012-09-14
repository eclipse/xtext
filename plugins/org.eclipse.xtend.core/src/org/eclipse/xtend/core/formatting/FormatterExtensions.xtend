package org.eclipse.xtend.core.formatting

import com.google.inject.Inject
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.xbase.lib.util.ToStringHelper

class FormatterExtensions {
	
	@Inject extension NodeModelAccess
	
	def FormattingData newFormattingData(Pair<Integer, Integer> range, (FormattingDataInit)=>void init) {
		val it = new FormattingDataInit()
		init.apply(it)
		if(newLines == 0 || space == "")
			return new WhitespaceData(range.key, range.value, indentationChange, space)
		else if(space == null)
			return new NewLineData(range.key, range.value, indentationChange, newLines)
		else 
			throw new IllegalStateException(init.toString) 
	}
	
	def Iterable<FormattingData> newFormattingData(HiddenLeafs leafs, NewLineConfig configuration) {
		val result = <FormattingData>newArrayList
		var applied = false
		for(leaf : leafs.leafs) 
			switch leaf {
				WhitespaceInfo: {
					val next = leaf.trailingComment
					if(next?.trailing) {
						result += new WhitespaceData(leaf.offset, leaf.length, 0, " ")
					} else if (!applied) {
						var newLines = Math::min(Math::max(leafs.newLines, configuration.minNewLines), configuration.maxNewLines)
						if(leaf.leadingComment?.endsWithNewLine)
							newLines = newLines - 1
						result += new NewLineData(leaf.offset, leaf.length, 0, newLines)
						applied = true
					} else {
						var newLines = 1
						if(leaf.leadingComment?.endsWithNewLine)
							newLines = newLines - 1
						result += new NewLineData(leaf.offset, leaf.length, 0, newLines)
					}
				}
				CommentInfo: {} 
			}
		result
	}
	
	def WhitespaceInfo findWhitespaceToWrap(HiddenLeafs leafs) {
		var WhitespaceInfo ws = null
		for(l : leafs.leafs.reverse) 
			switch l {
				WhitespaceInfo: ws = l
				CommentInfo:  if(l.trailing) return  ws 
			}
		ws
	}
	
	def String lookahead(FormattableDocument fmt, int offset, int length, (FormattableDocument)=>void format) {
		val lookahead = new FormattableDocument(fmt)
		format.apply(lookahead)
		lookahead.renderToString(offset, length)
	}
	
	def boolean fitsIntoLine(FormattableDocument fmt, int offset, int length, (FormattableDocument)=>void format) {
		val lookahead = fmt.lookahead(offset, length, format)
		if(lookahead.contains("\n")) {
			return false
		} else {
			val line = fmt.lineLengthBefore(offset) + lookahead.length
			return line <= fmt.cfg.maxLineWidth
		}
	}
	
	def FormattingData append(INode node, (FormattingDataInit)=>void init) {
		if(node != null) {
			node.rangeAfter?.newFormattingData(init)
		}
	}
	
	def Iterable<FormattingData> append(INode node, NewLineConfig configuration) {
		if(node != null) {
			node.hiddenLeafsAfter.newFormattingData(configuration)
		}
	}
	
	def FormattingData prepend(INode node, (FormattingDataInit)=>void init) {
		if(node != null) {
			node.rangeBefore?.newFormattingData(init)
		}
	}
	
	def Iterable<FormattingData> prepend(INode node, NewLineConfig configuration) {
		if(node != null) {
			node.hiddenLeafsAfter.newFormattingData(configuration)
		}
	}
	
	
}

class FormattingDataInit {
	public String space = null
	public int newLines = 0
	public int indentationChange = 0
	
	def newLine() {
		newLines = 1
	}
	
	def noSpace() {
		space = ""
	}
	
	def oneSpace() {
		space = " "
	}
	
	def increaseIndentation() {
		indentationChange = indentationChange + 1
	}
	
	def decreaseIndentation() {
		indentationChange = indentationChange - 1
	}
	
	override toString() {
		new ToStringHelper().toString(this)
	}
	
}


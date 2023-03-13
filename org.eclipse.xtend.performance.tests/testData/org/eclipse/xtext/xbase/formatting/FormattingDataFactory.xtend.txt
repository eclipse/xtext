package org.eclipse.xtext.xbase.formatting

import com.google.inject.Inject
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.xbase.lib.util.ToStringHelper

import static org.eclipse.xtext.xbase.formatting.XbaseFormatterPreferenceKeys.*
import org.eclipse.xtext.preferences.PreferenceKey

class FormattingDataFactory {

	@Inject extension HiddenLeafAccess

	def protected (FormattableDocument)=>Iterable<FormattingData> newFormattingData(
		HiddenLeafs leafs,
		(FormattingDataInit)=>void init
	) {
		val data = new FormattingDataInit()
		init.apply(data)
		newFormattingData(leafs, data.key, data)
	}

	def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(HiddenLeafs leafs,
		Void key, FormattingDataInit it) {
		[ FormattableDocument doc |
			if (leafs.newLinesInComments == 0 && (newLines == 0 || space == ""))
				return newWhitespaceData(leafs, space, indentationChange, doc.debugConflicts)
			else
				return newNewLineData(leafs, newLines, newLines, indentationChange, doc.debugConflicts)
		]
	}

	def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(
		HiddenLeafs leafs,
		BlankLineKey key,
		FormattingDataInit it
	) {
		[ FormattableDocument doc |
			val blankline = doc.cfg.get(key)
			val preserve = doc.cfg.get(preserveBlankLines)
			val min = blankline + 1
			val max = Math::max(preserve + 1, min)
			newNewLineData(leafs, min, max, indentationChange, doc.debugConflicts)
		]
	}

	def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(
		HiddenLeafs leafs,
		NewLineOrPreserveKey key,
		FormattingDataInit it
	) {
		[ FormattableDocument doc |
			val newLine = doc.cfg.get(key)
			val preserve = doc.cfg.get(preserveNewLines)
			newNewLineData(leafs, if (newLine) 1 else 0, if (preserve || newLine) 1 else 0, indentationChange,
				doc.debugConflicts)
		]
	}

	def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(
		HiddenLeafs leafs,
		NewLineKey key,
		FormattingDataInit it
	) {
		[ FormattableDocument doc |
			val newLine = doc.cfg.get(key)
			val minmax = if (newLine) 1 else 0
			newNewLineData(leafs, minmax, minmax, indentationChange, doc.debugConflicts)
		]
	}

	def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(
		HiddenLeafs leafs,
		PreferenceKey key,
		FormattingDataInit it
	) {
		throw new RuntimeException("Unknown configuration key kind: " + key.^class)
	}

	def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(HiddenLeafs leafs,
		WhitespaceKey key, FormattingDataInit it) {
		[ FormattableDocument doc |
			val space = doc.cfg.get(key)
			newWhitespaceData(leafs, if (space) " " else "", indentationChange, doc.debugConflicts)
		]
	}

	def protected Iterable<FormattingData> newWhitespaceData(
		HiddenLeafs leafs,
		String space,
		int indentationChange,
		boolean trace
	) {
		val result = <FormattingData>newArrayList
		var isFirst = true
		for (leaf : leafs.leafs)
			switch leaf {
				WhitespaceInfo: {
					result += new WhitespaceData(leaf.offset, leaf.length, if(isFirst) indentationChange else 0,
						if (trace) new RuntimeException, space)
					isFirst = false
				}
				CommentInfo: {
				}
			}
		result
	}

	def protected Iterable<FormattingData> newNewLineData(
		HiddenLeafs leafs,
		int minNewLines,
		int maxNewLines,
		int indentationChange,
		boolean trace
	) {
		val result = <FormattingData>newArrayList
		var applied = false
		for (leaf : leafs.leafs)
			switch leaf {
				WhitespaceInfo: {
					if (leaf.trailingComment?.trailing && !leaf.trailingComment?.multiline) {
						val space = if (leaf.offset == 0) "" else " "
						result += new WhitespaceData(leaf.offset, leaf.length, 0, if (trace) new RuntimeException(), space)
					} else if (!applied) {
						var newLines = Math::min(Math::max(leafs.newLines, minNewLines), maxNewLines)
						if (newLines < 1 && leaf.offset > 0 &&
							(leaf.leadingComment?.multiline || leaf.trailingComment?.multiline))
							newLines = 1
						if (leaf.leadingComment?.endsWithNewLine)
							newLines = newLines - 1
						if (!leaf.leadingComment?.endsWithNewLine && newLines == 0)
							result += new WhitespaceData(leaf.offset, leaf.length, indentationChange,
								if (trace) new RuntimeException(), if (leaf.offset == 0) "" else " ")
						else
							result += new NewLineData(leaf.offset, leaf.length, indentationChange, if (trace) new RuntimeException(), newLines)
						applied = true
					} else {
						var newLines = 1
						if (leaf.leadingComment?.endsWithNewLine)
							newLines = newLines - 1
						result += new NewLineData(leaf.offset, leaf.length, 0, if (trace) new RuntimeException(), newLines)
					}
				}
				CommentInfo: {
				}
			}
		result
	}

	def (FormattableDocument)=>Iterable<FormattingData> append(
		INode node,
		(FormattingDataInit)=>void init
	) {
		if (node != null) {
			node.hiddenLeafsAfter.newFormattingData(init)
		}
	}

	def (FormattableDocument)=>Iterable<FormattingData> prepend(
		INode node,
		(FormattingDataInit)=>void init
	) {
		if (node != null) {
			node.hiddenLeafsBefore.newFormattingData(init)
		}
	}

	def (FormattableDocument)=>Iterable<FormattingData> surround(
		INode node,
		(FormattingDataInit)=>void init
	) {
		[ FormattableDocument doc |
			val result = <FormattingData>newArrayList()
			if (node != null) {
				result += node.hiddenLeafsBefore.newFormattingData(init)?.apply(doc) ?: emptyList
				result += node.hiddenLeafsAfter.newFormattingData(init)?.apply(doc) ?: emptyList
			}
			result
		]
	}

	def (FormattableDocument)=>Iterable<FormattingData> surround(
		INode node,
		(FormattingDataInit)=>void before,
		(FormattingDataInit)=>void after
	) {
		[ FormattableDocument doc |
			val result = <FormattingData>newArrayList()
			if (node != null) {
				result += node.hiddenLeafsBefore.newFormattingData(before)?.apply(doc) ?: emptyList
				result += node.hiddenLeafsAfter.newFormattingData(after)?.apply(doc) ?: emptyList
			}
			result
		]
	}
}

class FormattingDataInit {
	public String space = null
	public int newLines = 0
	public int indentationChange = 0
	public PreferenceKey key = null

	def void cfg(PreferenceKey key) {
		this.key = key
	}

	def void newLine() {
		newLines = 1
	}

	def void noSpace() {
		space = ""
	}

	def void oneSpace() {
		space = " "
	}

	def void increaseIndentation() {
		indentationChange = indentationChange + 1
	}

	def void decreaseIndentation() {
		indentationChange = indentationChange - 1
	}

	override String toString() {
		new ToStringHelper().toString(this)
	}
}

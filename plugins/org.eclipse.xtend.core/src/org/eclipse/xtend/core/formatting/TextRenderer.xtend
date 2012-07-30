package org.eclipse.xtend.core.formatting

import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.Data
import org.eclipse.xtend.lib.Property

@Data class TextRenderer {
	def List<TextReplacement> render(String document, RendererConfiguration cfg, Iterable<FormattingData> data) {
		var RenderState state = null
		val allanchors = <Anchors>newHashSet(new Anchors())
		do {
			val anchors = if(state != null) new Anchors(state.anchors) else new Anchors()
			state = new RenderState(0, 0, new Line(0, 0), anchors)
			render(document, cfg, data, state, false)
		} while(allanchors.add(state.anchors))
		state.replacements
	}
	
	def protected render(String document, RendererConfiguration cfg, Iterable<FormattingData> data, RenderState renderState, boolean cancelIfLineFull) {
		var state = renderState
		val fmt = data.filter[it != null && (length == 0 || document.substring(offset, offset + length).whitespace)].sortBy[offset]
		for(f:fmt) {
			val textlength = f.offset - state.offset
			switch f {
				WhitespaceData: {
					state.line.column = state.line.column + textlength
//					if(cancelIfLineFull && state.line.column > cfg.maxLineWidth)
//						return null
					val replacement = f.space
					state.replacements += new TextReplacement(f.offset, f.length, replacement)
				}
				NewLineData: {
					state.line.column = state.line.column + textlength
					state.indentation = state.indentation + f.indentationChange
					state.line = new Line(f.offset + f.length, state.indentation * cfg.indentationLength)
					val replacement = cfg.getWrap(f.newLines) + cfg.getIndentation(state.indentation)
					state.replacements += new TextReplacement(f.offset, f.length, replacement)
				}
//				FormattingAlternative: {
//					val gi = f.group.iterator
//					var applied = false
//					while(gi.hasNext && !applied) {
//						val newState = render(document, cfg, gi.next, new RenderState(state), true)
//						if(newState != null) {
//							state = newState
//							applied = true
//						}
//					}
//				}
			}
			state.offset = textlength + f.length
		}
		state
	}
	
	def boolean isWhitespace(String doc) {
		(0..doc.length-1).forall[Character::isWhitespace(doc.charAt(it))]
	}
}

class RenderState {
	@Property int offset
	@Property int indentation
	@Property Line line
	@Property val List<TextReplacement> replacements
	@Property val Anchors anchors
	
	new(int offset, int indentation, Line line, Anchors anchors) {
		this._offset = offset
		this._indentation = indentation
		this._line = line
		this._replacements = newArrayList()
		this._anchors = anchors
	}
	
	new(RenderState other) {
		this._offset = other._offset
		this._indentation = other._indentation
		this._line = new Line(other._line)
		this._replacements = other._replacements.toList
		this._anchors = new Anchors(other._anchors)
	}
}

class Line {
	@Property val int offset
	@Property int column
	@Property val List<TextReplacement> replacements
	
	new (int offset, int column) {
		this._offset = offset
		this._column = column
		this._replacements = newArrayList
	}
	
	new (Line line) {
		this._offset = line._offset
		this._column = line._column
		this._replacements = line._replacements.toList
	}
}

class Anchors {
	Map<Object, Integer> anchors = newHashMap
	
	new() {
	}
	
	new(Anchors other) {
		other.anchors.entrySet.forEach[set(key, value)]
	}
	
	def get(Object anchor) {
		anchors.get(anchor)
	} 
	
	def set(Object anchor, int column) {
		val old = anchors.get(anchor)
		if(old == null || old < column)
			anchors.put(anchor, column)
	}
	
//	def setAll(Anchors other) {
//		other.anchors.entrySet.forEach[set(key, value)]
//	}
	
	override equals(Object obj) {
		obj != null && obj.^class == ^class && this.anchors == (obj as Anchors).anchors
	}
	
	override hashCode() {
		this.anchors.hashCode
	}
	
}


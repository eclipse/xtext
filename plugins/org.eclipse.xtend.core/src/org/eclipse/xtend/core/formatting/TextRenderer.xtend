package org.eclipse.xtend.core.formatting

import java.util.List
import org.eclipse.xtend.lib.Data
import org.eclipse.xtend.lib.Property

@Data class TextRenderer {
	def List<TextReplacement> createEdits(String document, RendererConfiguration cfg, Iterable<FormattingData> data, int offset, int length) {
		val filtered = data.filter[e|e.offset >= offset && e.offset + e.length <= offset + length]
		var RenderState state = new RenderState(0, 0)
		render(document, cfg, filtered, state)
		state.replacements
	}
	
	def protected render(String document, RendererConfiguration cfg, Iterable<FormattingData> data, RenderState renderState) {
		var state = renderState
		val fmt = data.filter[it != null && (length == 0 || document.substring(offset, offset + length).whitespace)].sortBy[offset]
		for(f:fmt) {
			val textlength = f.offset - state.offset
			switch f {
				WhitespaceData: {
					state.indentation = state.indentation + f.indentationChange
//					state.line.column = state.line.column + textlength
					val replacement = f.space ?: " "
					state.replacements += new TextReplacement(f.offset, f.length, replacement)
				}
				NewLineData: {
					state.indentation = state.indentation + f.indentationChange
					if(f.newLines > 0) {
//						state.line.column = state.line.column + textlength
//						state.line = new Line(f.offset + f.length, state.indentation * cfg.indentationLength)
						val replacement = cfg.getWrap(f.newLines) + cfg.getIndentation(state.indentation)
						state.replacements += new TextReplacement(f.offset, f.length, replacement)
					}
				}
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
//	@Property Line line
	@Property val List<TextReplacement> replacements
	
	new(int offset, int indentation) {
		this._offset = offset
		this._indentation = indentation
//		this._line = line
		this._replacements = newArrayList()
	}
	
	new(RenderState other) {
		this._offset = other._offset
		this._indentation = other._indentation
//		this._line = new Line(other._line)
		this._replacements = other._replacements.toList
	}
}

//class Line {
//	@Property val int offset
//	@Property int column
//	@Property val List<TextReplacement> replacements
//	
//	new (int offset, int column) {
//		this._offset = offset
//		this._column = column
//		this._replacements = newArrayList
//	}
//	
//	new (Line line) {
//		this._offset = line._offset
//		this._column = line._column
//		this._replacements = line._replacements.toList
//	}
//}


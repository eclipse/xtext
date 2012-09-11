package org.eclipse.xtend.core.formatting

import org.eclipse.xtend.lib.Property
import java.util.List
import java.util.TreeMap
import org.eclipse.xtend.core.formatting.WhitespaceData

class FormattableDocument {
	@Property val RendererConfiguration cfg
	@Property val String document
	@Property TreeMap<Integer, FormattingData> formattings
	
	new(RendererConfiguration cfg, String document){
		this._cfg = cfg
		this._document = document
		this._formattings = new TreeMap()
	}
	
	new(FormattableDocument fmt) {
		this._cfg = fmt.cfg
		this._document = fmt.document
		this._formattings = new TreeMap(fmt.formattings)
	}
	
	def protected addFormatting(FormattingData data) {
		if(data != null) {
			if(data.length > 0) {
				val oldText = document.substring(data.offset, data.offset + data.length)
				if(!oldText.whitespace)
					throw new IllegalStateException("Can non format non-whitespace: "+oldText)
			}
			val old = formattings.get(data.offset)
			formattings.put(data.offset, if(old == null) data else merge(old, data))
		}
	}
	
	def protected FormattingData merge(FormattingData data1, FormattingData data2) {
		var FormattingData old = null
		var indentationChange = 0 
		if(!data1.empty && data2.empty) {
			indentationChange = data1.indentationChange + data2.indentationChange
			old = data1
		} else if(data1.empty) {
			indentationChange = data2.indentationChange + data1.indentationChange
			old = data2
		}
		if(old != null)
			switch old {
				NewLineData: new NewLineData(old.offset, old.length, indentationChange, old.newLines)
				WhitespaceData: new WhitespaceData(old.offset, old.length, indentationChange, old.space)
			}
		else 
			throw new IllegalStateException('''Can not merge «data1» and «data2».''')
	}
	
	def operator_add(FormattingData data) {
		addFormatting(data)
	}
	
	def List<TextReplacement> renderToEdits() {
		renderToEdits(0, document.length)
	}

	def List<TextReplacement> renderToEdits(int offset, int length) {
		val replacements = <TextReplacement>newArrayList
		var oldOffset = offset
		var indentation = 0
		for(f:formattings.values) {
			indentation = indentation + f.indentationChange
			if(f.offset >= offset && f.offset + f.length <= offset + length) {
				val textlength = f.offset - oldOffset
				switch f {
					WhitespaceData: {
						if(f.space != null) {
							val replacement = f.space
							replacements += new TextReplacement(f.offset, f.length, replacement)
						}
					}
					NewLineData: {
						val replacement = cfg.getWrap(f.newLines) + cfg.getIndentation(indentation)
						replacements += new TextReplacement(f.offset, f.length, replacement)
					}
				}
				oldOffset = textlength + f.length
			}
		}
		replacements
	}
	
	def String renderToString() {
		renderToString(0, document.length)
	}
	
	def String renderToString(int offset, int length) {
		val edits = renderToEdits(offset, length)
		var lastOffset = offset
		val newDocument = new StringBuilder()
		for(edit:edits.sortBy[offset]) {
			val text = document.substring(lastOffset, edit.offset)
			newDocument.append(text)
			newDocument.append(edit.text)
			lastOffset = edit.offset + edit.length
		}
		val text = document.substring(lastOffset, offset + length)
		newDocument.append(text)
		newDocument.toString
		
	}
	
	def protected boolean isWhitespace(String doc) {
		(0..doc.length-1).forall[Character::isWhitespace(doc.charAt(it))]
	}
	
	def int lineLengthBefore(int offset) {
		var currentIndentation = 0
		var NewLineData lastWrap = null
		var lastIndentation = 0
		
		// find last NewLineData before offset
		for(f:formattings.values) 
			if(f.offset < offset) {
				currentIndentation = currentIndentation + f.indentationChange
				if(f instanceof NewLineData) {
					lastWrap = f as NewLineData
					lastIndentation = currentIndentation
				}
			}
			
		// check if there is a \n between the NewLineData and offset 
		var lastOffset = lastWrap.offset + lastWrap.length
		var lineStart = lastOffset
		for(f:formattings.subMap(lastWrap.offset + 1, offset).values) {
			val text = document.substring(lastOffset, f.offset)
			val index = text.lastIndexOf("\n") 
			if(index >= 0 ) {
				lineStart = index + lastOffset
				currentIndentation = 0
			}
			lastOffset = f.offset + f.length
		}
		
		// calculate length between \n or NewLineData and offset
		var lengthDiff = 0
		for(f:formattings.subMap(lastWrap.offset + 1, offset).values) 
			if(f instanceof WhitespaceData)
				lengthDiff = lengthDiff + (((f as WhitespaceData).space?.length ?: 0) - f.length)
		(offset - lineStart) + cfg.getIndentationLenght(currentIndentation) + lengthDiff  
	}
	
	override toString() {
		var lastOffset = 0
		val debugTrace = new StringBuilder()
		for(edit:renderToEdits) {
			val text = document.substring(lastOffset, edit.offset)
			debugTrace.append(text)
			debugTrace.append('''[«document.substring(edit.offset, edit.offset + edit.length)»|«edit.text»]''')
			lastOffset = edit.offset + edit.length
		}
		val text = document.substring(lastOffset, document.length)
		debugTrace.append(text)
		debugTrace.toString
	}
	
}

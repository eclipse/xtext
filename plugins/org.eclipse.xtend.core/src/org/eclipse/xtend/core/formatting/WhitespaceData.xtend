package org.eclipse.xtend.core.formatting

import org.eclipse.xtend.lib.Data

@Data abstract class FormattingData /* extends FormatX */ {
	int offset
	int length
	int indentationChange
	Throwable trace
	def boolean isEmpty() 
}

@Data class WhitespaceData extends FormattingData {
	String space

	override isEmpty() {
		space == null
	}
}

@Data class NewLineData extends FormattingData {
	int newLines
	
	override isEmpty() {
		newLines == 0
	}
}

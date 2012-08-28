package org.eclipse.xtend.core.formatting

import org.eclipse.xtend.lib.Data

//class FormatX {}

@Data abstract class FormattingData /* extends FormatX */ {
	int offset
	int length
	int indentationChange
	def int newLength() 
}

@Data abstract class AnchoredData extends FormattingData {
	Object leftAnchor
	Object rightAnchor
}

@Data class WhitespaceData extends AnchoredData {
	String space
	boolean canWrap
	
	override int newLength() {
		space.length
	}
}

@Data class NewLineData extends AnchoredData {
	int newLines
	
	override int newLength() {
		newLines
	}
}

//@Data class FormattingAlternative extends FormattingData {
//	List<FormattingGroup> group = newArrayList
//}
//
//@Data class FormattingGroup extends Format {
//	List<FormattingData> data = newArrayList
//}
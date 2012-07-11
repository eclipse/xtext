package org.eclipse.xtend.core.formatting

import org.eclipse.xtend.lib.Data

class Format {}

@Data class FormattingData extends Format {
	int offset
	int length
}

@Data class AnchoredData extends FormattingData {
	Object leftAnchor
	Object rightAnchor
}

@Data class WhitespaceData extends AnchoredData {
	String space
	boolean canWrap
}

@Data class NewLineData extends AnchoredData {
	int newLines
	int indentationChange
}

//@Data class FormattingAlternative extends FormattingData {
//	List<FormattingGroup> group = newArrayList
//}
//
//@Data class FormattingGroup extends Format {
//	List<FormattingData> data = newArrayList
//}
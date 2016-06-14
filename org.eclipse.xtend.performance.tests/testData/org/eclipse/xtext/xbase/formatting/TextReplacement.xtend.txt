package org.eclipse.xtext.xbase.formatting

import org.eclipse.xtend.lib.Data

@Data class TextReplacement {
	int offset
	int length
	String text
}

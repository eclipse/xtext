package org.eclipse.xtext.xbase.formatting

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.formatting2.ITextReplacement

/**
 * @Deprecated use {@link ITextReplacement}
 */
@Deprecated @Data class TextReplacement {
	int offset
	int length
	String text
}

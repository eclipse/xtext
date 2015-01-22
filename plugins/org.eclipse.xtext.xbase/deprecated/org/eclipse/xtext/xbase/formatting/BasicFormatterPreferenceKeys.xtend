package org.eclipse.xtext.xbase.formatting

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys

/**
 * @deprecated use {@link FormatterPreferenceKeys}
 */
@Deprecated class BasicFormatterPreferenceKeys {
	public static val lineSeparator = new StringKey("line.separator", System.getProperty("line.separator"))
	public static val indentation = new StringKey("indentation", "\t")
	public static val indentationLength = new IntegerKey("indentation.length", 4)
	public static val maxLineWidth = new IntegerKey("line.width.max", 120)
}


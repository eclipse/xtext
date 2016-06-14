package org.eclipse.xtext.xbase.formatting

class BasicFormatterPreferenceKeys {
	public static val lineSeparator = new StringKey("line.separator", "\n")
	public static val indentation = new StringKey("indentation", "\t")
	public static val indentationLength = new IntegerKey("indentation.length", 4)
	public static val maxLineWidth = new IntegerKey("line.width.max", 120)
}


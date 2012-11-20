package org.eclipse.xtend.core.formatting

class AbstractFormatterConfigurationKeys extends AbstractConfigurationKeys {
	public val lineSeparator = new TransientKey("line.separator", "\n")
	public val indentation = new TransientKey ("indentation", "\t")
	public val indentationLength = new TransientKey("indentation.length", 4)
	public val maxLineWidth = new IntegerKey("line.width.max", 120)
}
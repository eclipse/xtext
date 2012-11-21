package org.eclipse.xtext.xbase.formatting

import org.eclipse.xtext.xbase.configuration.AbstractConfigurationKeys
import org.eclipse.xtext.xbase.configuration.IntegerKey
import org.eclipse.xtext.xbase.configuration.TransientKey

abstract class AbstractFormatterConfigurationKeys extends AbstractConfigurationKeys implements IFormatterConfigKeys {
	public val lineSeparator = new TransientKey("line.separator", "\n")
	public val indentation = new TransientKey("indentation", "\t")
	public val indentationLength = new TransientKey("indentation.length", 4)
	public val maxLineWidth = new IntegerKey("line.width.max", 120)
}

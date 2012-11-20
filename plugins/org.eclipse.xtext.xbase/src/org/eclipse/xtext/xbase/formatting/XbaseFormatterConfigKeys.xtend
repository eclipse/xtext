package org.eclipse.xtext.xbase.formatting

import org.eclipse.xtext.xbase.configuration.BooleanKey
import org.eclipse.xtext.xbase.configuration.IntegerKey

class XbaseFormatterConfigKeys extends AbstractFormatterConfigurationKeys {
	public val preserveBlankLines = new IntegerKey("preserve.blank.lines", 1)
	public val blankLinesAroundExpression = new BlankLineKey("blank.line.around.expressions", 0)

	public val preserveNewLines = new BooleanKey("preserve.new.lines", true)
	public val newLineAfterClassAnnotations = new NewLineOrPreserveKey("newline.after.class.annotations", false)
	public val newLineAfterFieldAnnotations = new NewLineOrPreserveKey("newline.after.field.annotations", false)
	public val newLineAfterMethodAnnotations = new NewLineOrPreserveKey("newline.after.method.annotations", false)
	public val newLineAfterConstructorAnnotations = new NewLineOrPreserveKey("newline.after.constructor.annotations", false)
	public val newLineAfterParameterAnnotations = new NewLineOrPreserveKey("newline.after.parameter.annotations", false)

	public val whitespaceBetweenKeywordAndParenthesisSL = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", false)
	public val whitespaceBetweenKeywordAndParenthesisML = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", true)

	public val bracesInNewLine = new NewLineKey("braces.in.new.line", false)
}

class BlankLineKey extends IntegerKey {
	new(String name, Integer defaultValue) {
		super(name, defaultValue)
	}
}

class NewLineOrPreserveKey extends BooleanKey {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}
}

class NewLineKey extends BooleanKey {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}
}

class WhitespaceKey extends BooleanKey {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}
}

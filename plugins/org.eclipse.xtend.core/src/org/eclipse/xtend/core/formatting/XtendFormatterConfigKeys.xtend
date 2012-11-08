package org.eclipse.xtend.core.formatting

import javax.inject.Singleton

@Singleton
class XtendFormatterConfigKeys extends AbstractConfigurationKeys {
	public val lineSeparator = new TransientKey("line.separator", "\n")
	public val indentation = new TransientKey ("indentation", "\t")
	public val indentationLength = new TransientKey("indentation.length", 4)
	public val maxLineWidth = new IntegerKey("line.width.max", 120)
	
	public val preserveBlankLines = new IntegerKey("preserve.blank.lines", 1)
	public val blankLinesAfterPackageDecl = new BlankLineKey("blank.lines.after.packagedecl", 1)
	public val blankLinesBetweenImports = new BlankLineKey("blank.lines.between.imports", 0)
	public val blankLinesAfterImports = new BlankLineKey("blank.lines.after.imports", 1)
	public val blankLinesBetweenClasses = new BlankLineKey("blank.lines.between.classes", 1)
	public val blankLinesBeforeFirstMember = new BlankLineKey("blank.lines.before.first.member", 0)
	public val blankLinesAfterLastMember = new BlankLineKey("blank.lines.after.last.member", 0)
	public val blankLinesBetweenFields = new BlankLineKey("blank.lines.between.fields", 0)
	public val blankLinesBetweenFieldsAndMethods = new BlankLineKey("blank.lines.between.fields.and.methods", 1)
	public val blankLinesBetweenMethods = new BlankLineKey("blank.lines.between.methods", 1)
	public val blankLinesAroundExpression = new BlankLineKey("blank.line.around.expressions", 0)
	
	public val preserveNewLines = new BooleanKey("preserve.new.lines", true)
	public val newLineAfterClassAnnotations = new NewLineKey("newline.after.class.annotations", false)
	public val newLineAfterFieldAnnotations = new NewLineKey("newline.after.field.annotations", false)
	public val newLineAfterMethodAnnotations = new NewLineKey("newline.after.method.annotations", false)
	public val newLineAfterConstructorAnnotations = new NewLineKey("newline.after.constructor.annotations", false)
	public val newLineAfterParameterAnnotations = new NewLineKey("newline.after.parameter.annotations", false)
	
	public val whitespaceBetweenKeywordAndParenthesisSL = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", false)
	public val whitespaceBetweenKeywordAndParenthesisML = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", true)
}

class BlankLineKey extends IntegerKey {
	new(String name, Integer defaultValue) {
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
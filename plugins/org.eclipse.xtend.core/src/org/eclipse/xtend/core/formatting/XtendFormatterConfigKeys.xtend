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
	public val blankLinesAfterImports = new BlankLineKey("blank.lines.after.imports", 2)
	public val blankLinesBetweenClasses = new BlankLineKey("blank.lines.between.classes", 2)
	public val blankLinesBeforeFirstMember = new BlankLineKey("blank.lines.before.first.member", 0)
	public val blankLinesAfterLastMember = new BlankLineKey("blank.lines.after.last.member", 0)
	public val blankLinesBetweenFields = new BlankLineKey("blank.lines.between.fields", 0)
	public val blankLinesBetweenFieldsAndMethods = new BlankLineKey("blank.lines.between.fields.and.methods", 1)
	public val blankLinesBetweenMethods = new BlankLineKey("blank.lines.between.methods", 1)
	public val newLineAfterAnnotations = new NewLineKey("newline.after.annotations", false)
	public val newLineAroundExpression = new NewLineKey("newlines.around.expressions", true)
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
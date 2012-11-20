package org.eclipse.xtend.core.formatting

import javax.inject.Singleton

@Singleton
class XtendFormatterConfigKeys extends XbaseFormatterConfigKeys {
	public val blankLinesAfterPackageDecl = new BlankLineKey("blank.lines.after.packagedecl", 1)
	public val blankLinesBetweenImports = new BlankLineKey("blank.lines.between.imports", 0)
	public val blankLinesAfterImports = new BlankLineKey("blank.lines.after.imports", 1)
	public val blankLinesBetweenClasses = new BlankLineKey("blank.lines.between.classes", 1)
	public val blankLinesBeforeFirstMember = new BlankLineKey("blank.lines.before.first.member", 0)
	public val blankLinesAfterLastMember = new BlankLineKey("blank.lines.after.last.member", 0)
	public val blankLinesBetweenFields = new BlankLineKey("blank.lines.between.fields", 0)
	public val blankLinesBetweenFieldsAndMethods = new BlankLineKey("blank.lines.between.fields.and.methods", 1)
	public val blankLinesBetweenMethods = new BlankLineKey("blank.lines.between.methods", 1)
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

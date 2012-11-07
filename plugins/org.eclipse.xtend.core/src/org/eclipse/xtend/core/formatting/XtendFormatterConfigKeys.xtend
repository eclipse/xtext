package org.eclipse.xtend.core.formatting

import javax.inject.Singleton

@Singleton
class XtendFormatterConfigKeys extends AbstractConfigurationKeys {
	public val lineSeparator = new TransientKey("line.separator", "\n")
	public val maxLineWidth = new IntegerKey("line.width.max", 120)
	public val indentation = new TransientKey ("indentation", "\t")
	public val indentationLength = new TransientKey("indentation.length", 4) 
	public val newLinesAfterPackageName = new NewLineConfig("newlines.after.packagename", 2, 2)
	public val newLinesBetweenImports = new NewLineConfig("newlines.between.imports", 1, 2)
	public val newLinesAfterImportSection = new NewLineConfig("newlines.after.importsection", 2, 3)
	public val newLinesBeforeFirstMember = new NewLineConfig("newlines.before.first.member", 1, 2)
	public val newLinesAfterLastMember = new NewLineConfig("newlines.after.last.member", 1, 2)
	public val newLinesBetweenFields = new NewLineConfig("newlines.between.fields", 1, 2)
	public val newLinesBetweenFieldsAndMethods = new NewLineConfig("newlines.between.fields.and.methods", 2, 2)
	public val newLinesBetweenMethods = new NewLineConfig("newlines.between.methods", 2, 2)
	public val newLinesBetweenClasses = new NewLineConfig("newlines.between.classes", 2, 3)
	public val newLinesAroundExpression = new NewLineConfig("newlines.around.expressions",1, 2)
	public val newLinesAfterAnnotations = new NewLineConfig("newlines.after.annotations", 0, 1)
}

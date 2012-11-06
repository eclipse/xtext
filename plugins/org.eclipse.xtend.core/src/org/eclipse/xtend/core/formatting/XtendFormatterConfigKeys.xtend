package org.eclipse.xtend.core.formatting

import javax.inject.Singleton

@Singleton
class XtendFormatterConfigKeys extends AbstractConfigurationKeys {
	@Property val lineSeparator = new TransientKey("line.separator", "\n")
	@Property val maxLineWidth = new IntegerKey("line.width.max", 120)
	@Property val indentation = new TransientKey ("indentation", "\t")
	@Property val indentationLength = new TransientKey("indentation.length", 4) 
	@Property val newLinesAfterPackageName = new NewLineConfig("newlines.after.packagename", 2, 2)
	@Property val newLinesBetweenImports = new NewLineConfig("newlines.between.imports", 1, 2)
	@Property val newLinesAfterImportSection = new NewLineConfig("newlines.after.importsection", 2, 3)
	@Property val newLinesBeforeFirstMember = new NewLineConfig("newlines.before.first.member", 1, 2)
	@Property val newLinesAfterLastMember = new NewLineConfig("newlines.after.last.member", 1, 2)
	@Property val newLinesBetweenFields = new NewLineConfig("newlines.between.fields", 1, 2)
	@Property val newLinesBetweenFieldsAndMethods = new NewLineConfig("newlines.between.fields.and.methods", 2, 2)
	@Property val newLinesBetweenMethods = new NewLineConfig("newlines.between.methods", 2, 2)
	@Property val newLinesBetweenClasses = new NewLineConfig("newlines.between.classes", 2, 3)
	@Property val newLinesAroundExpression = new NewLineConfig("newlines.around.expressions",1, 2)
	@Property val newLinesAfterAnnotations = new NewLineConfig("newlines.after.annotations", 0, 1)
}

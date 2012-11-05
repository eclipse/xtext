package org.eclipse.xtend.core.formatting

import java.util.Map

class XtendFormatterConfig extends AbstractConfiguration {
	@Property val lineSeparator = new StringEntry("line.separator", "\n")
	@Property val maxLineWidth = new IntegerEntry("line.width.max", 120)
	@Property val indentation = new StringEntry ("indentation", "\t")
	@Property val indentationLength = new IntegerEntry("indentation.length", 4) 
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

	new() {
		super(null as String)
	}
	
	new(Map<String, String> properties) {
		this()
		load(null, properties)
	}
	
	def getIndentation(int levels) {
		if (levels > 0)
			(0 .. levels - 1).map[_indentation.value].join
		else
			""
	}

	def getIndentationLenght(int levels) {
		levels * indentationLength.value
	}

	def getWrap(int levels) {
		if (levels > 0)
			(0 .. levels - 1).map[_lineSeparator.value].join
		else
			""
	}
}

class NewLineConfig extends AbstractConfiguration {
	@Property val minNewLines = new IntegerEntry("minNewLines")
	@Property val maxNewLines = new IntegerEntry("maxNewLines")
	
	new(String key, int minNewLines, int maxNewLines) {
		super(key)
		_minNewLines.value = minNewLines
		_maxNewLines.value = maxNewLines
	}
}

package org.eclipse.xtend.core.formatting

import com.google.inject.name.Named
import java.util.Map

class XtendFormatterConfig {
	@Property @Named("line.separator") String lineSeparator ="\n"
	@Property @Named("line.width.max") int maxLineWidth = 120
	@Property @Named("indentation") String indentation ="\t"
	@Property @Named("indentation.length") int indentationLength = 4
	@Property @Named("newlines.after.packagename") NewLineConfig newLinesAfterPackageName = new NewLineConfig(2, 2)
	@Property @Named("newlines.between.imports") NewLineConfig newLinesBetweenImports = new NewLineConfig(1, 2)
	@Property @Named("newlines.after.importsection") NewLineConfig newLinesAfterImportSection = new NewLineConfig(2, 3)
	@Property @Named("newlines.before.first.member") NewLineConfig newLinesBeforeFirstMember = new NewLineConfig(1, 2)
	@Property @Named("newlines.after.last.member") NewLineConfig newLinesAfterLastMember = new NewLineConfig(1, 2)
	@Property @Named("newlines.between.fields") NewLineConfig newLinesBetweenFields = new NewLineConfig(1, 2)
	@Property @Named("newlines.between.fields.and.methods") NewLineConfig newLinesBetweenFieldsAndMethods = new NewLineConfig(2, 2)
	@Property @Named("newlines.between.methods") NewLineConfig newLinesBetweenMethods = new NewLineConfig(2, 2)
	@Property @Named("newlines.between.classes") NewLineConfig newLinesBetweenClasses = new NewLineConfig(2, 3)
	@Property @Named("newlines.around.expressions") NewLineConfig newLinesAroundExpression = new NewLineConfig(1, 2)
	@Property @Named("newlines.after.annotations") NewLineConfig newLinesAfterAnnotations = new NewLineConfig(0, 1)

	new() {
	}
	
	new(Map<String, String> properties) {
		for(property:namedProperties.entrySet) {
			val str = properties.get(property.key)
			if(str != null) {
				val value = switch property.value.type {
					case typeof(int): if(str.nullOrEmpty) 0 else Integer::parseInt(str)
					case typeof(String): str
					case typeof(NewLineConfig): new NewLineConfig(str)
				}
				property.value.set(this, value)
			}
		}
	}

	def Map<String, String> asMap() {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=389512
		namedProperties.mapValues[
			try {
				it.setAccessible(true)
				it.get(this)?.toString ?: ""
			} catch (Exception e) {
				""
			}]
	}

	def getNamedProperties() {
		^class.declaredFields.filter[ getAnnotation(typeof(Named)) != null].toMap[ getAnnotation(typeof(Named)).value]
	}

	def getIndentation(int levels) {
		if (levels > 0)
			(0 .. levels - 1).map[_indentation].join
		else
			""
	}

	def getIndentationLenght(int levels) {
		levels * indentationLength
	}

	def getWrap(int levels) {
		if (levels > 0)
			(0 .. levels - 1).map[_lineSeparator].join
		else
			""
	}
}

class NewLineConfig {
	@Property int minNewLines = 1
	@Property int maxNewLines = 1

	new(int min, int max) {
		_minNewLines = min
		_maxNewLines = max
	}

	new(String data) {
		val parsed = data.split(",")
		if(parsed.size == 2) {
			_minNewLines = Integer::parseInt(parsed.get(0).trim)
			_maxNewLines = Integer::parseInt(parsed.get(1).trim)
		}
	}

	//TODO implement equals method
	
	override toString() 
		'''«_minNewLines»,«_maxNewLines»'''
}


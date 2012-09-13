package org.eclipse.xtend.core.formatting

import com.google.inject.name.Named
import java.util.Map
import org.eclipse.xtend.lib.Property

class RendererConfiguration { 
	@Property @Named("line.separator") String lineSeparator
	@Property @Named("line.width.max") int maxLineWidth = 120
	@Property @Named("indentation") String indentation
	@Property @Named("indentation.length") int indentationLength = 4
	@Property @Named("newlines.after.packagename") NewLineConfiguration newLinesAfterPackageName = new NewLineConfiguration(2, 2)
	@Property @Named("newlines.between.imports") NewLineConfiguration newLinesBetweenImports = new NewLineConfiguration(1, 2)
	@Property @Named("newlines.after.importsection") NewLineConfiguration newLinesAfterImportSection = new NewLineConfiguration(2, 3)
	@Property @Named("newlines.between.fields") NewLineConfiguration newLinesBetweenFields = new NewLineConfiguration(1, 2)
	@Property @Named("newlines.between.fields.and.methods") NewLineConfiguration newLinesBetweenFieldsAndMethods = new NewLineConfiguration(2, 2)
	@Property @Named("newlines.between.methods") NewLineConfiguration newLinesBetweenMethods = new NewLineConfiguration(2, 2)
	@Property @Named("newlines.between.classes") NewLineConfiguration newLinesBetweenClasses = new NewLineConfiguration(2, 3)
	
	new() {
	}
	
	new(Map<String, String> properties) {
		for(property:namedProperties.entrySet) {
			val str = properties.get(property.key)
			if(str != null) {
				val value = switch property.value.type {
					case typeof(int): Integer::parseInt(str)
					case typeof(String): str
					case typeof(NewLineConfiguration): new NewLineConfiguration(str)
				}
				property.value.set(this, value)
			}
		}
	}
	
	def Map<String, String> asMap() {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=389512
		namedProperties.mapValues[try { get(this)?.toString ?: "" } catch(Exception e) {}]
	}
	
	def protected getNamedProperties() {
		^class.declaredFields.filter[getAnnotation(typeof(Named)) != null].toMap[getAnnotation(typeof(Named)).value]
	}
	
	def getIndentation(int levels) {
		if(levels > 0) 
			(0..levels - 1).map[_indentation].join 
		else 
			""
	}
	
	def getIndentationLenght(int levels) {
		levels * indentationLength
	}
	
	def getWrap(int levels) {
		if(levels > 0) 
			(0..levels - 1).map[_lineSeparator].join 
		else 
			""
	}
}

class NewLineConfiguration {
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
			_maxNewLines = Integer::parseInt(parsed.get(0).trim)
		}
	}
	
	override toString() '''
		«_minNewLines», «_maxNewLines»
	'''
}

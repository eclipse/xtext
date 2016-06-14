/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import com.google.common.base.Splitter
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@Accessors
class LanguageDescriptor {
	String name
	FileExtensions fileExtensions

	def String getBasePackage() {
		val i = name.lastIndexOf(".")
		name.substring(0, (if(i === -1) name.length else i ))
	}

	def String getBasePackagePath() {
		basePackage.replaceAll("\\.", "/")
	}

	def String getSimpleName() {
		val segments = name.split("\\.")
		return segments.last.toFirstUpper
	}

	def String getNsURI() {
		val strings = name.split("\\.")
		if (strings.length < 2) {
			return '''http://www.«name»'''
		}
		var s = '''http://www.«strings.get(1)».«strings.get(0)»'''
		for (var i = 2; i < strings.length; i++) {
			s += '''/«strings.get(i)»'''
		}
		return s
	}
	
	@FinalFieldsConstructor
	static class FileExtensions implements Iterable<String> {
		static def fromString(String fileExtensions) {
			val splitFileExtensions = Splitter.on(',').trimResults.omitEmptyStrings.split(fileExtensions)
			new FileExtensions(splitFileExtensions)
		}
		
		val Iterable<String> fileExtensions
		
		override iterator() {
			fileExtensions.iterator
		}
		
		override toString() {
			fileExtensions.join(",")
		}
		
	}
}
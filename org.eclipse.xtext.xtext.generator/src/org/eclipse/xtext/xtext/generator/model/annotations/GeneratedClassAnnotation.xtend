/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.annotations

import java.text.SimpleDateFormat
import java.util.Date
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xtext.generator.XtextGenerator
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

/** 
 * A class annotation configuration for the <code>@Generated</code> annotation.
 */
@Accessors
class GeneratedClassAnnotation implements IClassAnnotation {
	
	boolean includeDate = false
	
	String comment

	override generate() {
		val stringBuilder = new StringBuilder('@Generated(')
		if (includeDate || !Strings.isEmpty(comment)) {
			stringBuilder += 'value = '
		}
		stringBuilder += '"'
		stringBuilder += generatorName
		stringBuilder += '"'
		if (includeDate) {
			val dateFormat = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mmZ')
			val date = dateFormat.format(new Date)
			stringBuilder += ', date = "'
			stringBuilder += date
			stringBuilder += '"'
		}
		if (!Strings.isEmpty(comment)) {
			val convertedComment = Strings.convertToJavaString(comment)
			stringBuilder += ', comments = "'
			stringBuilder += convertedComment
			stringBuilder += '"'
		}
		stringBuilder += ')'
		return stringBuilder
	}

	protected def String getGeneratorName() {
		return XtextGenerator.name
	}
	
	override appliesTo(JavaFileAccess javaFile) {
		return javaFile.markedAsGenerated
	}

	override getAnnotationImport() {
		return new TypeReference('javax.annotation.Generated')
	}
	
	private def void +=(StringBuilder stringBuilder, String s) {
		stringBuilder.append(s)
	}
	
	override toString() {
		generate.toString
	}
	
	override equals(Object obj) {
		return obj instanceof GeneratedClassAnnotation
	}
	
	override hashCode() {
		return class.name.hashCode;
	}

}

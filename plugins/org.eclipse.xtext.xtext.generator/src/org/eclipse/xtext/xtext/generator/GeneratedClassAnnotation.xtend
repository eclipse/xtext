/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import java.text.SimpleDateFormat
import java.util.Date
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.Strings

/** 
 * A class annotation configuration for the <code>@Generated</code> annotation.
 */
class GeneratedClassAnnotation implements IClassAnnotation {
	
	@Accessors
	boolean includeDate = false
	
	@Accessors
	String comment

	override String toString() {
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
		return stringBuilder.toString()
	}

	protected def String getGeneratorName() {
		return XtextGenerator.name
	}

	override getAnnotationImport() {
		return 'javax.annotation.Generated'
	}
	
	private def void +=(StringBuilder stringBuilder, String s) {
		stringBuilder.append(s)
	}

}

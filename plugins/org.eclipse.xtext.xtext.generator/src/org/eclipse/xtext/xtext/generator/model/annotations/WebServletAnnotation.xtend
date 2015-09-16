/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.annotations

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

/** 
 * A class annotation configuration for the <code>@WebServlet</code> annotation.
 */
@Accessors
class WebServletAnnotation implements IClassAnnotation {
	
	String name
	
	String urlPatterns
	
	override generate() {
		val stringBuilder = new StringBuilder('@WebServlet(')
		if (!name.nullOrEmpty) {
			stringBuilder += 'name = "'
			stringBuilder += name
			stringBuilder += '"'
		}
		if (!urlPatterns.nullOrEmpty) {
			if (!name.nullOrEmpty)
				stringBuilder += ', '
			stringBuilder += 'urlPatterns = "'
			stringBuilder += urlPatterns
			stringBuilder += '"'
		}
		stringBuilder += ')'
		return stringBuilder
	}
	
	override appliesTo(JavaFileAccess javaFile) {
		true
	}
	
	override getAnnotationImport() {
		return new TypeReference('javax.servlet.annotation.WebServlet')
	}
	
	private def void +=(StringBuilder stringBuilder, String s) {
		stringBuilder.append(s)
	}
	
	override toString() {
		return generate.toString
	}
	
}

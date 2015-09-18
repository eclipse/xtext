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
 * A class annotation configuration for the <code>@SuppressWarnings</code> annotation.
 */
@Accessors
class SuppressWarningsAnnotation implements IClassAnnotation {
	
	String suppress = 'all'
	
	override generate() {
		val stringBuilder = new StringBuilder('@SuppressWarnings(')
		val suppressedWarnings = suppress.split("\\s*,\\s*")
		if (suppressedWarnings.length != 1)
			stringBuilder.append('{')
		stringBuilder.append(suppressedWarnings.join('"', '", "', '"', [it]))
		if (suppressedWarnings.length != 1)
			stringBuilder.append('}')
		stringBuilder.append(')')
		return stringBuilder
	}

	override appliesTo(JavaFileAccess javaFile) {
		return true
	}

	override getAnnotationImport() {
		return new TypeReference(SuppressWarnings)
	}

	override toString() {
		generate.toString
	}	
}

/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.annotations

import com.google.inject.Singleton
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

/** 
 * A class annotation configuration for the <code>@Singleton</code> annotation.
 */
class SingletonClassAnnotation implements IClassAnnotation {
	
	override generate() {
		'@Singleton'
	}
	
	override appliesTo(JavaFileAccess javaFile) {
		true
	}
	
	override getAnnotationImport() {
		return new TypeReference(Singleton)
	}
	
	override toString() {
		generate.toString
	}
}

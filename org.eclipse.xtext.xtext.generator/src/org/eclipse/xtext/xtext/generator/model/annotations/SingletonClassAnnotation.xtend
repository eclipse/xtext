/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	
	override equals(Object obj) {
		return obj instanceof SingletonClassAnnotation
	}
	
	override hashCode() {
		return class.name.hashCode;
	}
}

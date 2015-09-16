/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtend2.lib.StringConcatenationClient

class FileAccessFactory {
	
	@Inject CodeConfig codeConfig
	
	def TextFileAccess createTextFile() {
		new TextFileAccess()
	}
	
	def TextFileAccess createTextFile(String path) {
		val result = createTextFile()
		result.path = path
		return result
	}
	
	def TextFileAccess createTextFile(String path, StringConcatenationClient content) {
		val result = createTextFile(path)
		result.content = content
		return result
	}
	
	def JavaFileAccess createJavaFile(TypeReference typeRef) {
		val result = new JavaFileAccess(typeRef, codeConfig)
		return result
	}
	
	def JavaFileAccess createJavaFile(TypeReference typeRef, StringConcatenationClient content) {
		val result = createJavaFile(typeRef)
		result.content = content
		return result
	}
	
	def XtendFileAccess createXtendFile(TypeReference typeRef) {
		new XtendFileAccess(typeRef, codeConfig)
	}
	
	def XtendFileAccess createXtendFile(TypeReference typeRef, StringConcatenationClient content) {
		val result = createXtendFile(typeRef)
		result.content = content
		return result
	}
	
	def GeneratedJavaFileAccess createGeneratedJavaFile(TypeReference typeRef) {
		val result = new GeneratedJavaFileAccess(typeRef, codeConfig)
		return result
	}
}
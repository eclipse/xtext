/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtend2.lib.StringConcatenationClient

/**
 * Factory for creating text files, Java files, and Xtend files.
 */
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
		new JavaFileAccess(typeRef, codeConfig)
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
		new GeneratedJavaFileAccess(typeRef, codeConfig)
	}
	
	def BinaryFileAccess createBinaryFile() {
		new BinaryFileAccess()
	}
	
	def BinaryFileAccess createBinaryFile(String path) {
		val result = createBinaryFile()
		result.path = path
		return result
	}
	
}

/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.inject.Inject
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.LanguageConfig2

class FileAccessFactory {
	
	@Inject CodeConfig codeConfig
	
	@Inject IEncodingProvider encodingProvider

	def TextFileAccess createTextFile() {
		new TextFileAccess()
	}
	
	def JavaFileAccess createJavaFile(LanguageConfig2 language, TypeReference typeRef) {
		val file = new JavaFileAccess(typeRef, codeConfig, encodingProvider)
		file.resourceSet = language.resourceSet
		return file
	}
	
	def XtendFileAccess createXtendFile(LanguageConfig2 language, TypeReference typeRef) {
		val file = new XtendFileAccess(typeRef, codeConfig, encodingProvider)
		file.resourceSet = language.resourceSet
		return file
	}
	
}
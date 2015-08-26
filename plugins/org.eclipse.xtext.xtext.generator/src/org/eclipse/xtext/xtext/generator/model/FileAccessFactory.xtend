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

class FileAccessFactory {
	
	@Inject CodeConfig codeConfig
	
	def TextFileAccess createTextFile() {
		new TextFileAccess()
	}
	
	def JavaFileAccess createJavaFile(TypeReference typeRef) {
		new JavaFileAccess(typeRef, codeConfig)
	}
	
	def XtendFileAccess createXtendFile(TypeReference typeRef) {
		new XtendFileAccess(typeRef, codeConfig)
	}
	
}
/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.xtext.generator.CodeConfig

class FileAccessFactory {
	
	@Inject CodeConfig codeConfig
	
	@Inject IEncodingProvider encodingProvider
	
	@Inject Provider<ResourceSet> resourceSetProvider
	
	@Accessors(PUBLIC_SETTER)
	ResourceSet resourceSet
	
	def TextFileAccess createTextFile() {
		new TextFileAccess(encodingProvider)
	}
	
	def JavaFileAccess createJavaFile(TypeReference typeRef) {
		val file = new JavaFileAccess(typeRef, codeConfig, encodingProvider)
		file.resourceSet = resourceSet ?: resourceSetProvider.get
		return file
	}
	
	def XtendFileAccess createXtendFile(TypeReference typeRef) {
		val file = new XtendFileAccess(typeRef, codeConfig, encodingProvider)
		file.resourceSet = resourceSet ?: resourceSetProvider.get
		return file
	}
	
}
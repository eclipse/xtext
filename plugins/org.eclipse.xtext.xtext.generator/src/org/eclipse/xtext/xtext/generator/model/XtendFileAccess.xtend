/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import org.eclipse.xtext.xtext.generator.CodeConfig

class XtendFileAccess extends JavaFileAccess {
	
	new(String qualifiedName, CodeConfig codeConfig) {
		super(qualifiedName, codeConfig)
	}
	
	new(TypeReference typeRef, CodeConfig codeConfig) {
		super(typeRef, codeConfig)
	}
	
	override protected getFileExtension() {
		'xtend'
	}
	
	override protected appendSemicolons() {
		false
	}
	
}
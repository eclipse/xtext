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
	
	/**
	 * A list of keywords in the Xtend language. Use this to avoid illegal variable names.
	 */
	public static val XTEND_KEYWORDS = #{
		'abstract', 'for', 'new', 'switch', 'default', 'package', 'synchronized', 'boolean',
		'do', 'if', 'private', 'this', 'double', 'implements', 'protected', 'throw', 'byte',
		'else', 'import', 'public', 'throws', 'case', 'enum', 'instanceof', 'return', 'transient',
		'catch', 'extends', 'int', 'short', 'try', 'char', 'final', 'interface', 'static',
		'void', 'class', 'finally', 'long', 'strictfp', 'volatile', 'float', 'native', 'super',
		'while', 'val', 'var', 'def', 'override', 'annotation', 'extension', 'create', 'dispatch'
	}
	
	protected new(TypeReference typeRef, CodeConfig codeConfig) {
		super(typeRef, codeConfig)
	}
	
	override protected getFileExtension() {
		'xtend'
	}
	
	override protected appendSemicolons() {
		false
	}
	
}
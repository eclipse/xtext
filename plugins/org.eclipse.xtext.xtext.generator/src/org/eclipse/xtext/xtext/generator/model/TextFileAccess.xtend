/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtend2.lib.StringConcatenation

class TextFileAccess {

	@Accessors
	String path

	protected CharSequence internalContents
	
	def setContent(StringConcatenationClient content) {
		internalContents = new StringConcatenation() => [
			append(content)
		]
	}

	def CharSequence generate() {
		return internalContents.toString
	}

	def void writeTo(IFileSystemAccess2 fileSystemAccess) {
		if (fileSystemAccess != null) {
			fileSystemAccess.generateFile(path, generate())
		}
	}
	
}
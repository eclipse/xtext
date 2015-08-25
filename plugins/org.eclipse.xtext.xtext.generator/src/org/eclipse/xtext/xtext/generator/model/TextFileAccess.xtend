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

class TextFileAccess {

	@Accessors
	String path

	@Accessors
	CharSequence content

	def CharSequence generate() {
		return content
	}

	def writeTo(IFileSystemAccess2 fileSystemAccess) {
		if (fileSystemAccess != null) {
			fileSystemAccess.generateFile(path, generate())
		}
	}

}
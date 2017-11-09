/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import java.io.ByteArrayInputStream
import java.util.Arrays
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.IFileSystemAccess2

/**
 * A utility class for generating binary files.
 */
class BinaryFileAccess {

	@Accessors
	String path

	protected byte[] internalContents

	def void setContent(byte[] content) {
		internalContents = content
	}

	def byte[] getContent() {
		return Arrays.copyOf(internalContents, internalContents.length)
	}

	def void writeTo(IFileSystemAccess2 fileSystemAccess) {
		if (fileSystemAccess !== null) {
			fileSystemAccess.generateFile(path, new ByteArrayInputStream(internalContents))
		}
	}

}

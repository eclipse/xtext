/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.common.io.Files
import java.io.File
import java.nio.charset.Charset
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.parser.IEncodingProvider

class TextFileAccess {
	
	@Accessors
	String path
	
	@Accessors
	CharSequence content
	
	@Accessors
	IEncodingProvider encodingProvider
	
	def CharSequence generate() {
		return content
	}
	
	def writeTo(IFileSystemAccess2 fileSystemAccess) {
		fileSystemAccess.generateFile(path, generate())
	}
	
	def writeToFile() {
		var Charset charset
		if (encodingProvider !== null) {
			val uri = URI.createFileURI(path)
			charset = Charset.forName(encodingProvider.getEncoding(uri))
		} else {
			charset = Charset.defaultCharset
		}
		Files.write(generate(), new File(path), charset)
	}
	
}
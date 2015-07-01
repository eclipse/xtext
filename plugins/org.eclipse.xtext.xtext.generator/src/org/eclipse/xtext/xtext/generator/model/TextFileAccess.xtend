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
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.parser.IEncodingProvider

class TextFileAccess {
	
	@Accessors
	String path
	
	@Accessors
	val List<CharSequence> codeFragments = newArrayList
	
	@Accessors
	IEncodingProvider encodingProvider
	
	def CharSequence generate() {
		val result = new StringConcatenation
		for (fragment : codeFragments) {
			result.append(fragment)
		}
		return result
	}
	
	def writeTo(IFileSystemAccess2 fileSystemAccess) {
		fileSystemAccess.generateFile(path, generate())
	}
	
	def writeToFile() {
		val uri = URI.createFileURI(path)
		val charset = Charset.forName(encodingProvider.getEncoding(uri))
		Files.write(generate(), new File(path), charset)
	}
	
}
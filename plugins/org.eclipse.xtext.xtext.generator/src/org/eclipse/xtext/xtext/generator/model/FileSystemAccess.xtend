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
import java.io.FileInputStream
import java.io.InputStream
import java.nio.charset.Charset
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.util.RuntimeIOException

class FileSystemAccess implements IFileSystemAccess2 {
	
	@Accessors
	val String path
	
	val URI baseUri
	val IEncodingProvider encodingProvider
	
	new(String path, IEncodingProvider encodingProvider) {
		this.path = path
		this.baseUri = URI.createFileURI(path)
		this.encodingProvider = encodingProvider
	}
	
	protected def getCharset(URI uri) {
		Charset.forName(encodingProvider.getEncoding(uri))
	}
	
	override getURI(String path) {
		getURI(path, DEFAULT_OUTPUT)
	}
	
	override getURI(String path, String outputConfiguration) {
		if (outputConfiguration == DEFAULT_OUTPUT) {
			return baseUri.appendSegments(path.split('/'))
		} else {
			throw new IllegalArgumentException('Unsupported configuration: ' + outputConfiguration)
		}
	}
	
	override isFile(String path) throws RuntimeIOException {
		isFile(path, DEFAULT_OUTPUT)
	}
	
	override isFile(String path, String outputConfiguration) throws RuntimeIOException {
		if (outputConfiguration == DEFAULT_OUTPUT) {
			val file = new File(path.URI.toFileString)
			return file.exists && !file.isDirectory
		} else {
			throw new IllegalArgumentException('Unsupported configuration: ' + outputConfiguration)
		}
	}
	
	override deleteFile(String fileName) {
		deleteFile(fileName, DEFAULT_OUTPUT)
	}
	
	override deleteFile(String fileName, String outputConfiguration) {
		if (outputConfiguration == DEFAULT_OUTPUT) {
			val file = new File(fileName.URI.toFileString)
			file.delete()
		} else {
			throw new IllegalArgumentException('Unsupported configuration: ' + outputConfiguration)
		}
	}
	
	override generateFile(String fileName, CharSequence contents) {
		generateFile(fileName, DEFAULT_OUTPUT, contents)
	}
	
	override generateFile(String fileName, String outputConfiguration, CharSequence contents) {
		if (outputConfiguration == DEFAULT_OUTPUT) {
			val uri = fileName.URI
			Files.write(contents, new File(uri.toFileString), uri.charset)
		} else {
			throw new IllegalArgumentException('Unsupported configuration: ' + outputConfiguration)
		}
	}
	
	override generateFile(String fileName, InputStream content) throws RuntimeIOException {
		generateFile(fileName, DEFAULT_OUTPUT, content)
	}
	
	override generateFile(String fileName, String outputConfiguration, InputStream content) throws RuntimeIOException {
		if (outputConfiguration == DEFAULT_OUTPUT) {
			val uri = fileName.URI
			val fileWriter = Files.newWriter(new File(uri.toFileString), uri.charset)
			try {
				var c = content.read()
				while (c >= 0) {
					fileWriter.write(c)
					c = content.read()
				}
			} finally {
				fileWriter.close()
			}
		} else {
			throw new IllegalArgumentException('Unsupported configuration: ' + outputConfiguration)
		}
	}
	
	override readBinaryFile(String fileName) throws RuntimeIOException {
		readBinaryFile(fileName, DEFAULT_OUTPUT)
	}
	
	override readBinaryFile(String fileName, String outputConfiguration) throws RuntimeIOException {
		if (outputConfiguration == DEFAULT_OUTPUT) {
			return new FileInputStream(fileName.URI.toFileString)
		} else {
			throw new IllegalArgumentException('Unsupported configuration: ' + outputConfiguration)
		}
	}
	
	override readTextFile(String fileName) throws RuntimeIOException {
		readTextFile(fileName, DEFAULT_OUTPUT)
	}
	
	override readTextFile(String fileName, String outputConfiguration) throws RuntimeIOException {
		if (outputConfiguration == DEFAULT_OUTPUT) {
			val uri = fileName.URI
			return Files.toString(new File(uri.toFileString), uri.charset)
		} else {
			throw new IllegalArgumentException('Unsupported configuration: ' + outputConfiguration)
		}
	}
	
}
/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing.util

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIHandler
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @since 2.9
 * 
 * @noimplement
 * @noreference
 */
class InMemoryURIHandler implements URIHandler {

	@Accessors @FinalFieldsConstructor static class InMemFile {
		val URI uri
		byte[] contents
		boolean exists

		def OutputStream createOutputstream() {
			return new ByteArrayOutputStream() {
				override close() throws IOException {
					contents = toByteArray
					exists = true
				}
			}
		}

		def InputStream createInputStream() {
			if (contents == null || !exists) {
				throw new IOException("File " + uri + " does not exist.")
			}
			return new ByteArrayInputStream(contents)
		}
	}

	public final static String SCHEME = 'inmemory'
	
	Map<URI, InMemFile> files = newHashMap()

	override canHandle(URI uri) {
		uri.scheme == SCHEME
	}

	override contentDescription(URI uri, Map<?, ?> options) throws IOException {
		emptyMap
	}

	override createInputStream(URI uri, Map<?, ?> options) throws IOException {
		uri.inMemoryFile.createInputStream
	}

	override createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		return uri.inMemoryFile.createOutputstream
	}

	override delete(URI uri, Map<?, ?> options) throws IOException {
		uri.inMemoryFile.exists = false
	}

	override exists(URI uri, Map<?, ?> options) {
		uri.inMemoryFile.exists
	}

	override getAttributes(URI uri, Map<?, ?> options) {
		emptyMap
	}

	override setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
	}

	protected def getInMemoryFile(URI uri) {
		var result = files.get(uri)
		if (result == null) {
			result = new InMemFile(uri)
			files.put(uri, result)
		}
		return result
	}
}

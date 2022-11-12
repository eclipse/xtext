/*******************************************************************************
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import java.io.InputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.generator.FileSystemAccessQueue

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @author Arne Deutsch - Add wait to read operations
 */
class ParallelFileSystemSupport implements MutableFileSystemSupport {
	
	val URI uri
	
	val MutableFileSystemSupport delegate
	
	val extension FileSystemAccessQueue queue
	
	new(URI uri, MutableFileSystemSupport delegate, FileSystemAccessQueue queue) {
		this.uri = uri
		this.delegate = delegate
		this.queue = queue
	}
	
	override delete(Path path) { 
		sendAsync(uri) [
			delegate.delete(path)
		]
	}
	
	@Deprecated
	override mkdir(Path path) {
		sendAsync(uri) [
			delegate.mkdir(path)
		]
	}
	
	override setContents(Path path, CharSequence contents) {
		sendAsync(uri) [
			delegate.setContents(path, contents)
		]
	}
	
	override setContentsAsStream(Path path, InputStream source) {
		sendAsync(uri) [
			delegate.setContentsAsStream(path, source)
		]
	}
	
	override exists(Path path) {
		queue.waitForEmptyQueue
		delegate.exists(path)
	}
	
	override getCharset(Path path) {
		queue.waitForEmptyQueue
		delegate.getCharset(path)
	}
	
	override getChildren(Path path) {
		queue.waitForEmptyQueue
		delegate.getChildren(path)
	}
	
	override getContents(Path path) {
		queue.waitForEmptyQueue
		delegate.getContents(path)
	}
	
	override getContentsAsStream(Path path) {
		queue.waitForEmptyQueue
		delegate.getContentsAsStream(path)
	}
	
	override getLastModification(Path path) {
		queue.waitForEmptyQueue
		delegate.getLastModification(path)
	}
	
	override isFile(Path path) {
		queue.waitForEmptyQueue
		delegate.isFile(path)
	}
	
	override isFolder(Path path) {
		queue.waitForEmptyQueue
		delegate.isFolder(path)
	}
	
	override toURI(Path path) {
		queue.waitForEmptyQueue
		delegate.toURI(path)
	}
	
}

/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.file

import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtext.generator.FileSystemAccessQueue
import org.eclipse.xtend.lib.macro.file.Path
import java.io.InputStream

/**
 * @author kosyakov - Initial contribution and API
 */
class ParallelFileSystemSupport implements MutableFileSystemSupport {
	
	AbstractFileSystemSupport delegate
	
	extension FileSystemAccessQueue queue
	
	new(AbstractFileSystemSupport delegate, FileSystemAccessQueue queue) {
		this.delegate = delegate
		this.queue = queue
	}
	
	override delete(Path path) { 
		send [|
			delegate.delete(path)
		]
	}
	
	override mkdir(Path path) {
		send [|
			delegate.mkdir(path)
		]
	}
	
	override setContents(Path path, CharSequence contents) {
		sendAsync [|
			delegate.setContents(path, contents)
		]
	}
	
	override setContentsAsStream(Path path, InputStream source) {
		sendAsync [|
			delegate.setContentsAsStream(path, source)
		]
	}
	
	override exists(Path path) {
		delegate.exists(path)
	}
	
	override getCharset(Path path) {
		delegate.getCharset(path)
	}
	
	override getChildren(Path path) {
		delegate.getChildren(path)
	}
	
	override getContents(Path path) {
		delegate.getContents(path)
	}
	
	override getContentsAsStream(Path path) {
		delegate.getContentsAsStream(path)
	}
	
	override getLastModification(Path path) {
		delegate.getLastModification(path)
	}
	
	override isFile(Path path) {
		delegate.isFile(path)
	}
	
	override isFolder(Path path) {
		delegate.isFolder(path)
	}
	
	override toURI(Path path) {
		delegate.toURI(path)
	}
	
}

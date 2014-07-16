/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import java.io.InputStream
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path

@Accessors
class ChangeListenerAddingFileSystemSupport implements MutableFileSystemSupport {

	val MutableFileSystemSupport delegate
	val CompilationUnitImpl compilationUnit

	protected def registerChangeListener(Path path) {
		compilationUnit.resourceChangeRegistry.register(new org.eclipse.core.runtime.Path(path.toString),
			compilationUnit.xtendFile)
	}

	override delete(Path path) {
		delegate.delete(path)
	}

	override mkdir(Path path) {
		delegate.mkdir(path)
	}

	override setContents(Path path, CharSequence contents) {
		delegate.setContents(path, contents)
	}

	override setContentsAsStream(Path path, InputStream source) {
		delegate.setContentsAsStream(path, source)
	}

	override exists(Path path) {
		registerChangeListener(path)
		delegate.exists(path)
	}

	override getCharset(Path path) {
		registerChangeListener(path)
		delegate.getCharset(path)
	}

	override getChildren(Path path) {
		registerChangeListener(path)
		delegate.getChildren(path)
	}

	override getContents(Path path) {
		registerChangeListener(path)
		delegate.getContents(path)
	}

	override getContentsAsStream(Path path) {
		registerChangeListener(path)
		delegate.getContentsAsStream(path)
	}

	override getLastModification(Path path) {
		registerChangeListener(path)
		delegate.getLastModification(path)
	}

	override isFile(Path path) {
		registerChangeListener(path)
		delegate.isFile(path)
	}

	override isFolder(Path path) {
		registerChangeListener(path)
		delegate.isFolder(path)
	}

	override toURI(Path path) {
		delegate.toURI(path)
	}
}

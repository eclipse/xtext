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
		compilationUnit.resourceChangeRegistry.registerExists(path.toString, compilationUnit.xtendFile.eResource.URI)
		delegate.exists(path)
	}

	override getCharset(Path path) {
		compilationUnit.resourceChangeRegistry.registerGetCharset(path.toString, compilationUnit.xtendFile.eResource.URI)
		delegate.getCharset(path)
	}

	override getChildren(Path path) {
		compilationUnit.resourceChangeRegistry.registerGetChildren(path.toString, compilationUnit.xtendFile.eResource.URI)
		delegate.getChildren(path)
	}

	override getContents(Path path) {
		compilationUnit.resourceChangeRegistry.registerGetContents(path.toString, compilationUnit.xtendFile.eResource.URI)
		delegate.getContents(path)
	}

	override getContentsAsStream(Path path) {
		compilationUnit.resourceChangeRegistry.registerGetContents(path.toString, compilationUnit.xtendFile.eResource.URI)
		delegate.getContentsAsStream(path)
	}

	override getLastModification(Path path) {
		compilationUnit.resourceChangeRegistry.registerGetContents(path.toString, compilationUnit.xtendFile.eResource.URI)
		delegate.getLastModification(path)
	}

	override isFile(Path path) {
		compilationUnit.resourceChangeRegistry.registerExists(path.toString, compilationUnit.xtendFile.eResource.URI)
		delegate.isFile(path)
	}

	override isFolder(Path path) {
		compilationUnit.resourceChangeRegistry.registerExists(path.toString, compilationUnit.xtendFile.eResource.URI)
		delegate.isFolder(path)
	}

	override toURI(Path path) {
		delegate.toURI(path)
	}
}

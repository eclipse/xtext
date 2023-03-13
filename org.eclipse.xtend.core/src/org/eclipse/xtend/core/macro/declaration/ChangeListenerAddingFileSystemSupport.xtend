/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import java.io.InputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path

@Accessors
class ChangeListenerAddingFileSystemSupport implements MutableFileSystemSupport {

	val URI resourceURI
	val MutableFileSystemSupport delegate
	val IResourceChangeRegistry resourceChangeRegistry

	override delete(Path path) {
		resourceChangeRegistry.registerCreateOrModify(path.toString, URI)
		delegate.delete(path)
	}

	@Deprecated
	override mkdir(Path path) {
		resourceChangeRegistry.registerCreateOrModify(path.toString, URI)
		delegate.mkdir(path)
	}

	override setContents(Path path, CharSequence contents) {
		resourceChangeRegistry.registerCreateOrModify(path.toString, URI)
		delegate.setContents(path, contents)
	}

	override setContentsAsStream(Path path, InputStream source) {
		resourceChangeRegistry.registerCreateOrModify(path.toString, URI)
		delegate.setContentsAsStream(path, source)
	}

	override exists(Path path) {
		resourceChangeRegistry.registerExists(path.toString, URI)
		return delegate.exists(path)
	}
	
	private def URI getURI() {
		resourceURI
	}

	override getCharset(Path path) {
		resourceChangeRegistry.registerGetCharset(path.toString, URI)
		return delegate.getCharset(path)
	}

	override getChildren(Path path) {
		resourceChangeRegistry.registerGetChildren(path.toString, URI)
		return delegate.getChildren(path)
	}

	override getContents(Path path) {
		resourceChangeRegistry.registerGetContents(path.toString, URI)
		return delegate.getContents(path)
	}

	override getContentsAsStream(Path path) {
		resourceChangeRegistry.registerGetContents(path.toString, URI)
		return delegate.getContentsAsStream(path)
	}

	override getLastModification(Path path) {
		resourceChangeRegistry.registerGetContents(path.toString, URI)
		return delegate.getLastModification(path)
	}

	override isFile(Path path) {
		resourceChangeRegistry.registerExists(path.toString, URI)
		return delegate.isFile(path)
	}

	override isFolder(Path path) {
		resourceChangeRegistry.registerExists(path.toString, URI)
		return delegate.isFolder(path)
	}

	override toURI(Path path) {
		return delegate.toURI(path)
	}
}

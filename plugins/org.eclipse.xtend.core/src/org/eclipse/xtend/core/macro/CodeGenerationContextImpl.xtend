/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.file.Path
import java.io.InputStream
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.FileLocations

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class CodeGenerationContextImpl implements CodeGenerationContext {
	
	@Property MutableFileSystemSupport fileSystemSupport
	@Property FileLocations fileLocations
	
	override delete(Path path) {
		fileSystemSupport.delete(path)
	}
	
	override mkdir(Path path) {
		fileSystemSupport.mkdir(path)
	}
	
	override setContents(Path path, CharSequence contents) {
		fileSystemSupport.setContents(path, contents)
	}
	
	override setContentsAsStream(Path path, InputStream stream) {
		fileSystemSupport.setContentsAsStream(path, stream)
	}
	
	override exists(Path path) {
		fileSystemSupport.exists(path)
	}
	
	override getCharset(Path path) {
		fileSystemSupport.getCharset(path)
	}
	
	override getChildren(Path path) {
		fileSystemSupport.getChildren(path)
	}
	
	override getContents(Path path) {
		fileSystemSupport.getContents(path)
	}
	
	override getContentsAsStream(Path path) {
		fileSystemSupport.getContentsAsStream(path)
	}
	
	override getLastModification(Path path) {
		fileSystemSupport.getLastModification(path)
	}
	
	override getProjectFolder(Path path) {
		fileLocations.getProjectFolder(path)
	}
	
	override getSourceFolder(Path path) {
		fileLocations.getSourceFolder(path)
	}
	
	override getTargetFolder(Path sourceFolder) {
		fileLocations.getTargetFolder(sourceFolder)
	}
	
	override isFile(Path path) {
		fileSystemSupport.isFile(path)
	}
	
	override isFolder(Path path) {
		fileSystemSupport.isFolder(path)
	}
	
	override toURI(Path path) {
		fileSystemSupport.toURI(path)
	}
	
}
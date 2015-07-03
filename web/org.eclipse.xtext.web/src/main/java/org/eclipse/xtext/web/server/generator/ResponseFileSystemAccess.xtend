/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.generator

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.generator.IFileSystemAccess

/**
 * A file system access that simply stores all generated file contents in a list.
 * Attempts to write files to output configurations other than the default output
 * are ignored.
 */
class ResponseFileSystemAccess implements IFileSystemAccess {
	
	@Data
	static class ResponseFile {
		String name
		CharSequence content
	}
	
	@Accessors
	val List<ResponseFile> files = newArrayList
	
	override generateFile(String fileName, CharSequence contents) {
		if (!fileName.nullOrEmpty)
			deleteFile(fileName)
		files += new ResponseFile(fileName, contents)
	}
	
	override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		if (outputConfigurationName == IFileSystemAccess.DEFAULT_OUTPUT) {
			generateFile(fileName, contents)
		}
	}
	
	override deleteFile(String fileName) {
		if (fileName === null)
			throw new NullPointerException
		val iterator = files.iterator
		while (iterator.hasNext) {
			if (iterator.next.name == fileName) {
				iterator.remove()
				return
			}
		}
	}
	
}
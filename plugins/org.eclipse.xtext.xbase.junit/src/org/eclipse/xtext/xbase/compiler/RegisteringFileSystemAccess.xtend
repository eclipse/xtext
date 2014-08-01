/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler

import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.generator.FileSystemSupportBasedFileSystemAccess

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class RegisteringFileSystemAccess extends FileSystemSupportBasedFileSystemAccess {
	
	@Data static class GeneratedFile {
		Path path
		String javaClassName
		CharSequence contents
	}
	
	@Accessors val Set<RegisteringFileSystemAccess.GeneratedFile> textFiles = newHashSet()
	
	override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		super.generateFile(fileName, outputConfigurationName, contents)
		val path = getPath(fileName, outputConfigurationName)
		val javaName = if (fileName.endsWith(".java")) {
			fileName.substring(0, fileName.length-5).replace('/','.')
		}
		textFiles.add(new RegisteringFileSystemAccess.GeneratedFile(path, javaName, contents))
	}
}
/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator

import java.io.InputStream
import org.eclipse.xtext.util.RuntimeIOException
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.file.Path
import com.google.inject.Inject
import org.eclipse.emf.common.util.URI

/**
 * 
 * An adapter between {org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport} and {org.eclipse.xtext.generator.IFileSystemAccess}
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.7
 */
class FileSystemSupportBasedFileSystemAccess extends AbstractFileSystemAccess2 implements IFileSystemAccess, IFileSystemAccessExtension, IFileSystemAccessExtension2, IFileSystemAccessExtension3 {
	
	@Inject @Accessors(PUBLIC_SETTER) extension MutableFileSystemSupport fileSystemSupport
	@Accessors(PUBLIC_SETTER) String projectName;
	
	protected def getPath(String fileName, String outputConfigurationName) {
		val path = pathes.get(outputConfigurationName)
		return new Path("/"+projectName+"/"+path+"/"+fileName)
	}
	
	override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		val path = getPath(fileName, outputConfigurationName)
		path.contents = contents
	}
	
	override getURI(String fileName, String outputConfiguration) {
		return URI.createFileURI(getPath(fileName, outputConfiguration).toURI.toURL.file)
	}
	
	override generateFile(String fileName, String outputConfigurationName, InputStream content) throws RuntimeIOException {
		val path = getPath(fileName, outputConfigurationName)
		path.contentsAsStream = content
	}
	
	override readBinaryFile(String fileName, String outputConfigurationName) throws RuntimeIOException {
		val path = getPath(fileName, outputConfigurationName)
		return path.contentsAsStream
	}
	
	override readTextFile(String fileName, String outputConfigurationName) throws RuntimeIOException {
		val path = getPath(fileName, outputConfigurationName)
		return path.contents
	}
	
}
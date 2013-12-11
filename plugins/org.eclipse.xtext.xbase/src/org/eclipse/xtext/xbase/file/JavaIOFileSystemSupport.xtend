/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.file

import com.google.common.io.ByteStreams
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.util.Files
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.BufferedInputStream
import java.io.BufferedOutputStream

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class JavaIOFileSystemSupport extends AbstractFileSystemSupport {
	
	@Inject @Property Provider<WorkspaceConfig> projectInformationProvider
	
	override Iterable<? extends Path> getChildren(Path path) {
		if (!path.exists) {
			return emptyList
		}
		if (path.file) {
			return emptyList
		}
		path.javaIOFile.list.map[path.getAbsolutePath(it)]
	}

	protected def File getJavaIOFile(Path path) {
		return new File(projectInformationProvider.get.absoluteFileSystemPath, path.toString())
	}

	override boolean exists(Path path) {
		path.javaIOFile.exists
	}

	override boolean isFolder(Path path) {
		path.javaIOFile.isDirectory
	}

	override boolean isFile(Path path) {
		path.javaIOFile.isFile
	}

	override long getLastModification(Path path) {
		path.javaIOFile.lastModified
	}

	override String getCharset(Path path) {
		return encodingProvider.getEncoding(URI.createFileURI(path.javaIOFile.absolutePath))
	}

	override InputStream getContentsAsStream(Path path) {
		return new BufferedInputStream(new FileInputStream(path.javaIOFile))
	}
	
	override boolean mkdir(Path path) {
		if (path.exists)
			return false;
		val parent = path.parent
		if (parent != null) {
			parent.mkdir
		}
		path.javaIOFile.mkdir
		return true
	}
	
	override boolean delete(Path path) {
		if (!path.exists)
			return false;
		if (path.javaIOFile.directory) {
			Files.sweepFolder(path.javaIOFile)
		}
		path.javaIOFile.delete
		return true
	}

	override void setContentsAsStream(Path path, InputStream stream) {
		path.parent.mkdir
		ByteStreams.copy(|stream) [| new BufferedOutputStream(new FileOutputStream(path.javaIOFile))]
	}
	
	override toURI(Path path) {
		path.javaIOFile.toURI
	}
	
}

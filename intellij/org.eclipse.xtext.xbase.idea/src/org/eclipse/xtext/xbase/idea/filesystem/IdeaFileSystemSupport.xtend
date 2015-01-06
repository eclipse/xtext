/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.filesystem

import com.google.common.io.ByteStreams
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import java.io.InputStream
import java.net.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport

class IdeaFileSystemSupport extends AbstractFileSystemSupport {

	override getPath(Resource res) {
		val file = VirtualFileManager.instance.findFileByUrl(res.URI.toString)
		file.toPath
	}

	override delete(Path path) {
		path.toVirtualFile.delete(this)
	}

	override mkdir(Path path) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override setContentsAsStream(Path path, InputStream source) {
		val out = path.toVirtualFile.getOutputStream(this)
		try {
			ByteStreams.copy(source, out)
		} finally {
			out.close
		}
	}

	override exists(Path path) {
		path.toVirtualFile?.exists
	}

	override getCharset(Path path) {
		path.toVirtualFile.charset.name
	}

	override getChildren(Path path) {
		path.toVirtualFile.children.map[toPath]
	}

	override getContentsAsStream(Path path) {
		path.toVirtualFile.inputStream
	}

	override getLastModification(Path path) {
		path.toVirtualFile.modificationStamp
	}

	override isFile(Path path) {
		!path.isFolder
	}

	override isFolder(Path path) {
		path.toVirtualFile.isDirectory
	}

	override toURI(Path path) {
		URI.create(path.toVirtualFile.url)
	}

	private def toVirtualFile(Path path) {
		val project = ProjectManager.instance.openProjects.head
		project.baseDir.findFileByRelativePath(path.toString)
	}

	private def toPath(VirtualFile file) {
		val project = ProjectManager.instance.openProjects.head
		new Path(VfsUtil.getRelativePath(file, project.baseDir, Path.SEGMENT_SEPARATOR))
	}

}
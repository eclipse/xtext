/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.macro

import com.google.common.io.ByteStreams
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import java.io.IOException
import java.io.InputStream
import java.net.URI
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path

import static org.eclipse.xtend.lib.macro.file.Path.*

import static extension com.intellij.openapi.vfs.VfsUtilCore.*
import static extension org.eclipse.xtext.idea.resource.ModuleProvider.*

class IdeaFileSystemSupport extends AbstractFileSystemSupport {

	override getPath(Resource res) {
		val file = VirtualFileManager.instance.findFileByUrl(res.getURI.toString)
		file.toPath
	}

	override delete(Path path) {
		try {
			if (path.exists)
				path.toVirtualFile.delete(this)
		} catch (IOException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}

	override mkdir(Path path) {
		if (path.exists)
			return;

		if (path == null)
			throw new IllegalAccessException('The path cannot be null: ' + path)

		path.parent.mkdir
		val parentDir = path.parent.toVirtualFile

		try {
			parentDir.createChildDirectory(this, path.lastSegment)
		} catch (IOException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}

	override setContentsAsStream(Path path, InputStream source) {
		if (!path.exists) {
			path.parent.mkdir
			try {
				path.parent.toVirtualFile.createChildData(this, path.lastSegment)
			} catch (IOException exc) {
				throw new IllegalArgumentException(exc.message, exc)
			}
		}
		val file = path.toVirtualFile
		if (!file.directory) {
			file.contents = source
		}
	}

	protected def void setContents(VirtualFile file, InputStream source) {
		try {
			val out = file.getOutputStream(this)
			try {
				ByteStreams.copy(source, out)
			} finally {
				out.close
			}
		} catch (IOException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}

	override exists(Path path) {
		path.toVirtualFile?.exists
	}

	override getCharset(Path path) {
		if (path == null)
			throw new IllegalAccessException('The path cannot be null: ' + path)

		val file = path.toVirtualFile
		if (file != null)
			file.charset.name
		else
			path.parent.charset
	}

	override getChildren(Path path) {
		if (!path.folder)
			return emptyList

		return path.toVirtualFile.children.map[toPath].filterNull
	}

	override getContentsAsStream(Path path) {
		if (!path.file)
			throw new IllegalAccessException('The file cannot be found: ' + path)

		try {
			path.toVirtualFile.inputStream
		} catch (IOException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}

	override getLastModification(Path path) {
		if (!path.file)
			return 0L

		return path.toVirtualFile.modificationStamp
	}

	override isFile(Path path) {
		val file = path.toVirtualFile
		if(file != null) !file.directory
	}

	override isFolder(Path path) {
		val file = path.toVirtualFile
		file?.directory
	}

	override toURI(Path path) {
		path.toURI(newArrayList)
	}

	protected def URI toURI(Path path, List<String> trailingSegments) {
		val file = path.toVirtualFile
		if (file == null) {
			trailingSegments += path.lastSegment
			return toURI(path.parent, trailingSegments)
		}
		val url = trailingSegments.reverse.fold(file.url)[url, segment|url + VfsUtilCore.VFS_SEPARATOR_CHAR + segment]
		VfsUtilCore.convertToURL(url).toURI
	}

	protected def toVirtualFile(Path path) {
		if(path == null) return null

		if (path.segments.size == 0)
			return project.baseDir

		val moduleName = path.segments.head
		val module = ModuleManager.getInstance(project).findModuleByName(moduleName)
		if(module == null) return null

		if (path.segments.size == 1) {
			// FIXME
			return ModuleRootManager.getInstance(module).contentRoots.head
		}

		val moduleRelativePath = path.relativize(ROOT.append(moduleName))?.toString
		if(moduleRelativePath == null) return null

		val contentRoots = ModuleRootManager.getInstance(module).contentRoots
		contentRoots.map[findFileByRelativePath(moduleRelativePath)].filterNull.filter[valid].head
	}

	protected def toPath(VirtualFile file) {
		if(file == null) return null

		val fileIndex = ProjectRootManager.getInstance(project).fileIndex
		val module = fileIndex.getModuleForFile(file)
		if(module == null) return null

		val contentRoot = fileIndex.getContentRootForFile(file)
		if(contentRoot == null) return null

		val relativePath = file.getRelativePath(contentRoot)
		if(relativePath == null) return null

		ROOT.append(module.name).append(relativePath)
	}

	protected def getProject() {
		context.findModule.project
	}

}

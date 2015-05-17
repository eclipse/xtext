/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.filesystem

import com.google.common.io.ByteStreams
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.SourceFolder
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import java.io.InputStream
import java.net.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport

import static org.eclipse.xtend.lib.macro.file.Path.*

import static extension com.intellij.openapi.vfs.VfsUtilCore.*
import static extension org.eclipse.xtext.idea.extensions.RootModelExtensions.*
import com.google.common.base.Joiner

class IdeaFileSystemSupport extends AbstractFileSystemSupport {

	override getPath(Resource res) {
		val file = VirtualFileManager.instance.findFileByUrl(res.URI.toString)
		file.toPath
	}

	override delete(Path path) {
		path.toVirtualFile.delete(this)
	}

	override mkdir(Path path) {
		path.toVirtualFile.mkdir
	}

	private def void mkdir(VirtualFile file) {
		val parent = file.parent
		if (parent.exists) {
			parent.createChildData(null, file.name)
		} else {
			parent.mkdir
		}
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
		val project = currentlyActiveProject
		val moduleName = path.segments.head
		val module = ModuleManager.getInstance(project).findModuleByName(moduleName)
		val moduleRelativePath = path.relativize(SEGMENT_SEPARATOR + moduleName)
		module.sourceFolders.map[findFileByModuleRelativePath(moduleRelativePath)].filterNull.head
	}

	private def toPath(VirtualFile file) {
		val project = currentlyActiveProject
		val module = ProjectRootManager.getInstance(project).fileIndex.getModuleForFile(file)
		val sourceFolder = module.sourceFolders.findFirst[it.file.isAncestor(file, true)]
		val relativePath = file.getRelativePath(sourceFolder.file)
		createAbsolutePath(module, sourceFolder, relativePath)
	}

	private def getCurrentlyActiveProject() {
		// FIXME hack
		ProjectManager.instance.openProjects.head
	}

	private def findFileByModuleRelativePath(SourceFolder sourceFolder, Path moduleRelativePath) {
		val sourceRelativePath = moduleRelativePath.relativize(sourceFolder.relativePath)
		if (sourceRelativePath == null)
			null
		else
			sourceFolder.file.findFileByRelativePath(sourceRelativePath.toString)
	}

	def static Path createAbsolutePath(Module module, SourceFolder sourceFolder) {
		createAbsolutePath(module, sourceFolder, null)
	}
	
	def static Path createAbsolutePath(Module module, SourceFolder sourceFolder, String relativePath) {
		val segments = #[module.name, sourceFolder.relativePath, relativePath]
		new Path(SEGMENT_SEPARATOR + Joiner.on(SEGMENT_SEPARATOR).skipNulls.join(segments))
	}
}
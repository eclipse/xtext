/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.filesystem

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.SourceFolder
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.IProjectConfigProvider
import org.eclipse.xtext.workspace.ISourceFolder

import static extension com.intellij.ide.projectView.impl.ProjectRootsUtil.*
import static extension org.eclipse.xtext.idea.extensions.RootModelExtensions.*
import static extension org.eclipse.xtext.util.UriUtil.*
import org.eclipse.xtend.lib.annotations.Accessors

class IdeaProjectConfigProvider implements IProjectConfigProvider {

	override IdeaProjectConfig getProjectConfig(ResourceSet context) {
		if (context instanceof XtextResourceSet) {
			val uriContext = context.classpathURIContext
			if (uriContext instanceof Module)
				return uriContext.projectConfig
		}
		throw new IllegalArgumentException("Could not determine the project")
	}
	
	def IdeaProjectConfig getProjectConfig(Module module) {
		return new IdeaProjectConfig(module)
	}
	
}

@Accessors class IdeaProjectConfig implements IProjectConfig {

	val Module module
	
	val VirtualFile contentRoot
	
	new (Module module) {
		this.module = module
		this.contentRoot = ModuleRootManager.getInstance(module).contentRoots.head
	}

	override IdeaSourceFolder findSourceFolderContaining(URI member) {
		val file = VirtualFileManager.instance.findFileByUrl(member.toString)
		if (file == null)
			return null

		val sourceRoot = ProjectRootManager.getInstance(module.project).fileIndex.getSourceRootForFile(file)
		if (sourceRoot == null) return null
		
		val sourceFolder = module.findSourceFolder(sourceRoot)
		if (sourceFolder == null || sourceFolder.contentEntry.file != contentRoot) return null

		return new IdeaSourceFolder(sourceFolder)
	}

	override getName() {
		module.name
	}

	override getPath() {
		URI.createURI(contentRoot.url).toFolderURI
	}

	override Set<? extends IdeaSourceFolder> getSourceFolders() {
		module.existingSourceFolders.filter[
			file == contentRoot
		].map[sourceFolder|new IdeaSourceFolder(sourceFolder)].toSet
	}

}

@Data
class IdeaSourceFolder implements ISourceFolder {
	val SourceFolder folder

	override getName() {
		folder.relativePath
	}

	override getPath() {
		URI.createURI(folder.file.url).toFolderURI
	}
}
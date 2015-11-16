/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.filesystem

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project
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
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.IProjectConfigProvider
import org.eclipse.xtext.workspace.ISourceFolder
import org.eclipse.xtext.workspace.IWorkspaceConfig

import static extension com.intellij.ide.projectView.impl.ProjectRootsUtil.*
import static extension org.eclipse.xtext.idea.extensions.RootModelExtensions.*
import static extension org.eclipse.xtext.util.UriUtil.*
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil
import com.intellij.openapi.vfs.VfsUtil

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

@Data class IdeaProjectConfig implements IProjectConfig {

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
			file == contentRoot || VfsUtil.isAncestor(contentRoot, file, false)
		].map[sourceFolder|new IdeaSourceFolder(sourceFolder)].toSet
	}
	
	override getWorkspaceConfig() {
		return new IdeaWorkspaceConfig(module.project)
	}
	
}

@Data @Log
class IdeaWorkspaceConfig implements IWorkspaceConfig {
	
	val Project project
	
	override getProjects() {
		val modules = ApplicationManager.application.<Module[]>runReadAction[
			ModuleManager.getInstance(project).modules
		]
		return modules.map[toIdeaProjectConfig].toSet
	}

	override IdeaProjectConfig findProjectByName(String name) {
		val module = ApplicationManager.application.<Module>runReadAction[
			ModuleManager.getInstance(project).findModuleByName(name)	
		]
		if (module !== null) {
			return module.toIdeaProjectConfig
		} else {
			return null
		}
	}
	
	private def toIdeaProjectConfig(Module module) {
		return new IdeaProjectConfig(module)
	}

	override IdeaProjectConfig findProjectContaining(URI member) {
		val file = VirtualFileURIUtil.getVirtualFile(member)
		if (file === null)
			return null

		val fileIndex = ProjectRootManager.getInstance(project).fileIndex
		val module = fileIndex.getModuleForFile(file, true)
		if (module === null)
			return null

		val contentRoot = fileIndex.getContentRootForFile(file, true)
		if (contentRoot === null)
			return null

		val result = new IdeaProjectConfig(module)
		if (contentRoot != result.contentRoot)
			LOG.error('''The file («member») should belong to the first content root («result.contentRoot») but belongs to «contentRoot».''')

		return result
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
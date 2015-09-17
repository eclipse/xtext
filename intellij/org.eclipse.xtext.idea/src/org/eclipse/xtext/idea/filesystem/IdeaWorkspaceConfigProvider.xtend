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
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.ISourceFolder
import org.eclipse.xtext.workspace.IWorkspaceConfig
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider

import static extension com.intellij.ide.projectView.impl.ProjectRootsUtil.*
import static extension org.eclipse.xtext.idea.extensions.RootModelExtensions.*
import static extension org.eclipse.xtext.util.UriUtil.*
import com.intellij.openapi.diagnostic.Logger

class IdeaWorkspaceConfigProvider implements IWorkspaceConfigProvider {

	override IdeaWorkspaceConfig getWorkspaceConfig(ResourceSet context) {
		if (context instanceof XtextResourceSet) {
			val uriContext = context.classpathURIContext
			if (uriContext instanceof Module)
				return uriContext.workspaceConfig
		}
		throw new IllegalArgumentException("Could not determine the project")
	}
	
	def IdeaWorkspaceConfig getWorkspaceConfig(Module module) {
		module.project.workspaceConfig
	}
	
	def IdeaWorkspaceConfig getWorkspaceConfig(Project project) {
		new IdeaWorkspaceConfig(project)
	}

}

@Data
class IdeaWorkspaceConfig implements IWorkspaceConfig {
	
	static val LOGGER = Logger.getInstance(IdeaWorkspaceConfig)

	val Project project
	
	override getProjects() {
		ApplicationManager.application.<Module[]>runReadAction[
			ModuleManager.getInstance(project).modules
		].map[toIdeaModuleConfig].toSet
	}

	override IdeaModuleConfig findProjectByName(String name) {
		ApplicationManager.application.<Module>runReadAction[
			ModuleManager.getInstance(project).findModuleByName(name)	
		].toIdeaModuleConfig
	}
	
	protected def toIdeaModuleConfig(Module module) {
		if (module == null) return null

		val contentRoot = module.defaultContentRoot
		if (contentRoot == null) return null

		return new IdeaModuleConfig(module, contentRoot)
	}

	override IdeaModuleConfig findProjectContaining(URI member) {
		val file = VirtualFileManager.instance.findFileByUrl(member.toString)
		if (file == null) return null
			
		val fileIndex = ProjectRootManager.getInstance(project).fileIndex
		val module = fileIndex.getModuleForFile(file, false)
		if (module == null) return null
		
		val contentRoot = fileIndex.getContentRootForFile(file, false)
		if (contentRoot == null) return null
		
		val defaultContentRoot = module.defaultContentRoot
		if (contentRoot != defaultContentRoot)
			LOGGER.error('''The file («member») should belong to the first content root («defaultContentRoot») but belongs to «contentRoot».''')
			
		return new IdeaModuleConfig(module, contentRoot)
	}
	
	protected def getDefaultContentRoot(Module module) {
		ModuleRootManager.getInstance(module).contentRoots.head
	}
	
}

@Data
class IdeaModuleConfig implements IProjectConfig {

	val Module module
	
	val VirtualFile contentRoot

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
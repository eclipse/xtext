/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.filesystem

import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.SourceFolder
import com.intellij.openapi.vfs.VirtualFileManager
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.ISourceFolder
import org.eclipse.xtext.workspace.IWorkspaceConfig
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider

import static extension org.eclipse.xtext.idea.extensions.RootModelExtensions.*

class IdeaWorkspaceConfigProvider implements IWorkspaceConfigProvider {

	override getWorkspaceConfig(ResourceSet context) {
		if (context instanceof XtextResourceSet) {
			val uriContext = context.classpathURIContext
			if (uriContext instanceof Module) {
				val project = uriContext.project
				return new IdeaWorkspaceConfig(project)
			}
		}
		throw new IllegalArgumentException("Could not determine the project")
	}

}

@Data
class IdeaWorkspaceConfig implements IWorkspaceConfig {

	val Project project

	override findProjectByName(String name) {
		val module = ModuleManager.getInstance(project).findModuleByName(name)
		if (module == null)
			return null
		return new IdeaModuleConfig(module)
	}

	override findProjectContaining(URI member) {
		val file = VirtualFileManager.instance.findFileByUrl(member.toString)
		if (file == null)
			return null
		val module = ProjectRootManager.getInstance(project).fileIndex.getModuleForFile(file)
		if (module == null)
			return null
		return new IdeaModuleConfig(module)
	}

	override getProjects() {
		val modules = ModuleManager.getInstance(project).modules
		val usableModules = modules.filter [
			!ModuleRootManager.getInstance(it).contentEntries.isEmpty
		]
		usableModules.map[new IdeaModuleConfig(it)].toSet
	}

}

@Data
class IdeaModuleConfig implements IProjectConfig {

	val Module module

	override findSourceFolderContaing(URI member) {
		val file = VirtualFileManager.instance.findFileByUrl(member.toString)
		if (file == null)
			return null
		val sourceRoot = ProjectRootManager.getInstance(module.project).fileIndex.getSourceRootForFile(file)
		if (sourceRoot == null)
			return null
		val sourceFolder = module.existingSourceFolders.findFirst[file == sourceRoot]
		if (sourceFolder == null)
			return null
		return new IdeaSourceFolder(sourceFolder)
	}

	override getName() {
		module.name
	}

	override getPath() {
		val contentRoot = ModuleRootManager.getInstance(module).contentEntries.head
		val path = URI.createURI(contentRoot.file.url)
		if (path.hasTrailingPathSeparator) 
			path
		else 
			path.appendSegment("")
		
	}

	override getSourceFolders() {
		module.existingSourceFolders.map[new IdeaSourceFolder(it)].toSet
	}

}

@Data
class IdeaSourceFolder implements ISourceFolder {
	val SourceFolder folder

	override getName() {
		folder.relativePath
	}

	override getPath() {
		val path = URI.createURI(folder.file.url)
		if (path.hasTrailingPathSeparator) 
			path
		else 
			path.appendSegment("")
	}
}
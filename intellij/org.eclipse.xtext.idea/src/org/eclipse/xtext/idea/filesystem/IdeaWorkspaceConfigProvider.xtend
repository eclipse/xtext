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
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.SourceFolder
import com.intellij.openapi.vfs.VfsUtil
import java.net.URL
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.ISourceFolder
import org.eclipse.xtext.workspace.IWorkspaceConfig
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider

import static extension org.eclipse.xtext.idea.extensions.RootModelExtensions.*

class IdeaWorkspaceConfigProvider implements IWorkspaceConfigProvider {

	override getWorkspaceConfig(Resource context) {
		val resourceSet = context.resourceSet
		if (resourceSet instanceof XtextResourceSet) {
			val uriContext = resourceSet.classpathURIContext
			if (uriContext instanceof Module) {
				val project = uriContext.project
				return new IdeaWorkspaceConfig(project)
			}
		}
		throw new IllegalArgumentException("Could not determine the project for " + context.URI)
	}

}

@FinalFieldsConstructor
class IdeaWorkspaceConfig implements IWorkspaceConfig {

	val Project project

	override findProjectByName(String name) {
		projects.findFirst[it.name == name]
	}

	override findProjectContaining(URI member) {
		val file = VfsUtil.findFileByURL(new URL(member.toString))
		val module = ProjectRootManager.getInstance(project).fileIndex.getModuleForFile(file)
		new IdeaModuleConfig(module)
	}

	override getPath() {
		URI.createURI(project.baseDir.url)
	}

	override getProjects() {
		val modules = ModuleManager.getInstance(project).modules
		modules.map[new IdeaModuleConfig(it)].toSet
	}

}

@FinalFieldsConstructor
class IdeaModuleConfig implements IProjectConfig {

	val Module module

	override findSourceFolderContaing(URI member) {
		sourceFolders.findFirst[source|member.deresolve(source.path).isRelative]
	}

	override getName() {
		module.name
	}

	override getPath() {
		null
	}

	override getSourceFolders() {
		module.sourceFolders.map[new IdeaSourceFolder(it)].toSet
	}

}

@FinalFieldsConstructor
class IdeaSourceFolder implements ISourceFolder {
	val SourceFolder folder

	override getName() {
		folder.relativePath
	}

	override getPath() {
		URI.createURI(folder.file.url)
	}

}
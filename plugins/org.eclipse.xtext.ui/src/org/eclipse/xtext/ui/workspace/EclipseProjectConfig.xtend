/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.workspace

import com.google.inject.Inject
import java.util.Set
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.ui.util.IJdtHelper
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.IProjectConfigProvider
import org.eclipse.xtext.workspace.ISourceFolder
import org.eclipse.xtext.workspace.IWorkspaceConfig
import org.eclipse.xtext.workspace.ProjectConfigAdapter

import static extension org.eclipse.xtext.util.UriUtil.*
import com.google.inject.Singleton

@Singleton
class EclipseProjectConfigProvider implements IProjectConfigProvider {
	
	@Inject IJdtHelper jdtHelper
	
	override getProjectConfig(ResourceSet context) {
		return ProjectConfigAdapter.findInEmfObject(context)?.projectConfig
	}
	
	def void installProjectConfig(IProject eclipseProject, ResourceSet resourceSet) {
		val config = createProjectConfig(eclipseProject)
		ProjectConfigAdapter.install(resourceSet, config)
	}
	
	def createProjectConfig(IProject eclipseProject) {
		if (jdtHelper.isJavaCoreAvailable) {
			new JdtProjectConfig(eclipseProject, this)
		} else {
			new EclipseProjectConfig(eclipseProject, this)
		}
	}
	
}

@Data
class EclipseProjectConfig implements IProjectConfig {

	val IProject project
	val EclipseProjectConfigProvider projectConfigProvider

	override getName() {
		project.name
	}

	override getPath() {
		URI.createPlatformResourceURI("/" + name + "/", true)
	}

	override getSourceFolders() {
		emptySet
	}

	override findSourceFolderContaining(URI member) {
		sourceFolders.findFirst[folder|folder.path.isPrefixOf(member)]
	}
	
	override getWorkspaceConfig() {
		new EclipseWorkspaceConfig(project.workspace.root, projectConfigProvider)
	}
	
	override toString() {
		return project.toString
	}
	
}

@Data
class EclipseWorkspaceConfig implements IWorkspaceConfig {
	
	IWorkspaceRoot workspaceRoot
	val EclipseProjectConfigProvider projectConfigProvider
	
	override Set<? extends EclipseProjectConfig> getProjects() {
		workspaceRoot.projects.filter[project.isAccessible].map[projectConfigProvider.createProjectConfig(project)].toSet
	}

	override EclipseProjectConfig findProjectByName(String name) {
		try {
			val project = workspaceRoot.getProject(name)
			if (project.isAccessible) {
				return projectConfigProvider.createProjectConfig(project)
			}
			return null
		} catch (IllegalArgumentException e) {
			return null
		}
	}

	override EclipseProjectConfig findProjectContaining(URI member) {
		if (member.isPlatformResource) {
			return findProjectByName(URI.decode(member.segment(1)))
		}
		return null
	}

}

@Data
class EclipseSourceFolder implements ISourceFolder {
	val IProject project
	val String name

	override getName() {
		name
	}

	override getPath() {
		URI.createPlatformResourceURI("/" + project.name + "/" + name + "/", true)
	}
}

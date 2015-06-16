/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.workspace

import com.google.inject.Inject
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.ISourceFolder
import org.eclipse.xtext.workspace.IWorkspaceConfig
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider
import org.eclipse.xtend.lib.annotations.Accessors

class EclipseWorkspaceConfigProvider implements IWorkspaceConfigProvider {

	@Accessors @Inject IWorkspaceRoot workspaceRoot

	override getWorkspaceConfig(ResourceSet context) {
		new EclipseWorkspaceConfig(this, workspaceRoot)
	}

	public def getProjectConfig(IProject project) {
		new EclipseProjectConfig(project)
	}

}

@FinalFieldsConstructor
class EclipseWorkspaceConfig implements IWorkspaceConfig {
	val EclipseWorkspaceConfigProvider provider
	val IWorkspaceRoot workspaceRoot

	override findProjectByName(String name) {
		try {
			val project = workspaceRoot.getProject(name)
			if (project.exists) {
				return provider.getProjectConfig(project)
			}
			return null
		} catch (IllegalArgumentException e) {
			return null
		}
	}

	override findProjectContaining(URI member) {
		if (member.isPlatformResource) {
			return findProjectByName(member.segment(1))
		}
		return null
	}

	override getProjects() {
		workspaceRoot.projects.map[provider.getProjectConfig(it)].toSet
	}

}

@Data
class EclipseProjectConfig implements IProjectConfig {

	val IProject project

	override getName() {
		project.name
	}

	override getPath() {
		URI.createPlatformResourceURI("/" + name + "/", true)
	}

	override getSourceFolders() {
		emptySet
	}

	override findSourceFolderContaing(URI member) {
		sourceFolders.findFirst[folder|member.toString.startsWith(folder.path.toString)]
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

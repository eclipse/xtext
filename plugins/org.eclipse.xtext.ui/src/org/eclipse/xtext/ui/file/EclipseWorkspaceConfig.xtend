/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.file

import com.google.inject.Inject
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.ISourceFolder
import org.eclipse.xtext.workspace.IWorkspaceConfig
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider

class EclipseWorkspaceConfigProvider implements IWorkspaceConfigProvider {

	@Accessors @Inject IWorkspaceRoot workspaceRoot

	@Accessors @Inject IContextualOutputConfigurationProvider configurationProvider

	override getWorkspaceConfig(Resource context) {
		new EclipseWorkspaceConfig(workspaceRoot, context, configurationProvider)
	}

}

@FinalFieldsConstructor
class EclipseWorkspaceConfig implements IWorkspaceConfig {
	val IWorkspaceRoot workspaceRoot
	val Resource context
	val IContextualOutputConfigurationProvider configurationProvider

	override getPath() {
		URI.createPlatformResourceURI("/", true)
	}

	override findProjectByName(String name) {
		try {
			val project = workspaceRoot.getProject(name)
			if (project.exists) {
				return new EclipseProjectConfig(project, context, configurationProvider)
			}
			return null
		} catch (IllegalArgumentException e) {
			return null
		}
	}

	override findProjectContaining(URI member) {
		projects.findFirst[project|member.deresolve(project.path).isRelative]
	}

	override getProjects() {
		workspaceRoot.projects.map[new EclipseProjectConfig(it, context, configurationProvider)].toSet
	}

}

@FinalFieldsConstructor
class EclipseProjectConfig implements IProjectConfig {

	val IProject project
	val Resource context
	val IContextualOutputConfigurationProvider configurationProvider

	override getName() {
		project.name
	}

	override getPath() {
		URI.createPlatformResourceURI("/" + name, true)
	}

	override getSourceFolders() {
		val outputConfigurations = configurationProvider.getOutputConfigurations(context)
		val sourceFolders = outputConfigurations.map[sourceFolders].flatten
		sourceFolders.map[new EclipseSourceFolder(project, it)].toSet
	}

	override findSourceFolderContaing(URI member) {
		sourceFolders.findFirst[folder|member.deresolve(folder.path).isRelative]
	}
}

@FinalFieldsConstructor
class EclipseSourceFolder implements ISourceFolder {
	val IProject project
	val String name

	override getName() {
		name
	}

	override getPath() {
		URI.createPlatformResourceURI("/" + project.name + "/" + name, true)
	}
}

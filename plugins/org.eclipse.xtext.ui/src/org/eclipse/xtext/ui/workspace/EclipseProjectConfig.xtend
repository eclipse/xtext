/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.workspace

import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.ISourceFolder

import static extension org.eclipse.xtext.util.UriUtil.*
import org.eclipse.xtext.workspace.IProjectConfigProvider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.workspace.ProjectConfigAdapter
import com.google.inject.Inject
import org.eclipse.xtext.ui.util.IJdtHelper

class EclipseProjectConfigProvider implements IProjectConfigProvider {
	
	@Inject IJdtHelper jdtHelper
	
	override getProjectConfig(ResourceSet context) {
		return ProjectConfigAdapter.findInEmfObject(context)?.projectConfig
	}
	
	def void installProjectConfig(IProject eclipseProject, ResourceSet resourceSet) {
		val config = createProjectConfig(eclipseProject)
		new ProjectConfigAdapter(config).attachToEmfObject(resourceSet)
	}
	
	def createProjectConfig(IProject eclipseProject) {
		if (jdtHelper.isJavaCoreAvailable) {
			new JdtProjectConfig(eclipseProject)
		} else {
			new EclipseProjectConfig(eclipseProject)
		}
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

	override findSourceFolderContaining(URI member) {
		sourceFolders.findFirst[folder|folder.path.isPrefixOf(member)]
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

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
import static extension org.eclipse.xtext.util.UriUtil.*
import org.eclipse.core.resources.IWorkspace
import org.eclipse.xtext.ui.util.IJdtHelper
import com.google.inject.Provider

class EclipseWorkspaceConfigProvider implements IWorkspaceConfigProvider {

	@Accessors @Inject IWorkspace workspace
	@Accessors @Inject IJdtHelper jdtHelper

	override getWorkspaceConfig(ResourceSet context) {
		new EclipseWorkspaceConfig(this, workspace.root)
	}

	public def EclipseProjectConfig getProjectConfig(IProject project) {
		if (jdtHelper!=null && jdtHelper.isJavaCoreAvailable) {
			return new Provider<EclipseProjectConfig>() {
				override get() {
					return new JdtProjectConfig(project)
				}
			}.get
		}
		return new EclipseProjectConfig(project)
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

	override equals(Object obj) {
		if (obj instanceof EclipseWorkspaceConfig) {
			return obj.workspaceRoot == workspaceRoot
		}
		return false
	}
	
	override hashCode() {
		workspaceRoot.hashCode
	}
	
	override toString() {
		workspaceRoot.toString
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

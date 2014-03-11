/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.file

import com.google.inject.Inject
import javax.inject.Provider
import org.eclipse.core.resources.IProject
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider
import org.eclipse.xtext.xbase.file.ProjectConfig
import org.eclipse.xtext.xbase.file.WorkspaceConfig
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.IPackageFragmentRoot
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.core.resources.IFolder

class EclipseWorkspaceConfigProvider implements Provider<WorkspaceConfig> {
	
	@Property @Inject IWorkspaceRoot workspaceRoot
	
	@Property @Inject EclipseOutputConfigurationProvider configurationProvider
	
	override get() {
		val wsRoot = workspaceRoot.location.toString
		val result = new WorkspaceConfig(wsRoot)
		workspaceRoot.projects.forEach [
			result.projects.put(name, new EclipseProjectConfig(it, configurationProvider))
		]
		return result
	}
	
}

class EclipseProjectConfig extends ProjectConfig {
	
	IProject project
	EclipseOutputConfigurationProvider configurationProvider
	
	new(IProject project, EclipseOutputConfigurationProvider configurationProvider) {
		super(project.name)
		this.project = project;
		this.configurationProvider = configurationProvider
	}
	
	override getSourceFolderMappings() {
		val map = super.sourceFolderMappings
		if (map.empty) {
			val config = configurationProvider.getOutputConfigurations(project).head
			val jp  = JavaCore.create(project)
			for (root : jp.packageFragmentRoots) {
				if (root.kind == IPackageFragmentRoot.K_SOURCE && root.underlyingResource != null) {
					val container = root.underlyingResource as IContainer
					var IFolder target
					if (config.useOutputPerSourceFolder) {
						val projectRelativeSource = container.fullPath.makeRelativeTo(project.fullPath).toString
						target = project.getFolder(new org.eclipse.core.runtime.Path(config.getOutputDirectory(projectRelativeSource)))
					}else {
						target = container.parent.getFolder(new org.eclipse.core.runtime.Path(config.outputDirectory))
					}
					if (container != target) {
						map.put(new Path(container.fullPath.toString), new Path(target.fullPath.toString))
					}
				}
			}
		}
		return map;
	}
	
}
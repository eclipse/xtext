/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.file

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.IPackageFragmentRoot
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider
import org.eclipse.xtext.xbase.file.ProjectConfig
import org.eclipse.xtext.xbase.file.WorkspaceConfig

class EclipseWorkspaceConfigProvider implements Provider<WorkspaceConfig> {
	
	@Accessors @Inject IWorkspaceRoot workspaceRoot
	
	@Accessors @Inject EclipseOutputConfigurationProvider configurationProvider
	
	override get() {
		val result = new EclipseWorkspaceConfig(workspaceRoot, configurationProvider)
		return result
	}
	
}

@Data
class EclipseWorkspaceConfig extends WorkspaceConfig {
	IWorkspaceRoot workspaceRoot
	EclipseOutputConfigurationProvider configurationProvider
	
	override getAbsoluteFileSystemPath() {
		return workspaceRoot.location.toString
	}
	
	override getProject(String name) {
		try {
			val project = workspaceRoot.getProject(name)
			if (project.exists) {
				return new EclipseProjectConfig(project, configurationProvider)
			}
			return null
		} catch(IllegalArgumentException e) {
			return null
		}
	}
	
	override getProjects() {
		workspaceRoot.projects.map [ new EclipseProjectConfig(it, configurationProvider) ].unmodifiableView
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
	
	override getContainingSourceFolder(Path path) {
		if (super.sourceFolderMappings.empty) {
			for(cp: JavaCore.create(project).rawClasspath) {
				if (cp.entryKind == IClasspathEntry.CPE_SOURCE) {
					val cpPath = new Path(cp.path.toString)
					if (path.startsWith(cpPath)) {
						return cpPath
					}
				} 
			}
		}
		return super.getContainingSourceFolder(path)
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
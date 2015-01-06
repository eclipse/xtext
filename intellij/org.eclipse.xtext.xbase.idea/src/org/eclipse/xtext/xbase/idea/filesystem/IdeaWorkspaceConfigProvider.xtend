/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.filesystem

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.vfs.VfsUtil
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.xbase.file.ProjectConfig
import org.eclipse.xtext.xbase.file.WorkspaceConfig

class IdeaWorkspaceConfigProvider implements Provider<WorkspaceConfig> {

	@Inject
	IOutputConfigurationProvider outputConfigurations

	override get() {
		val project = ProjectManager.instance.openProjects.head
		val result = new WorkspaceConfig(project.basePath)
		ModuleManager.getInstance(project).modules.forEach [ m |
			result.addProjectConfig(new IdeaModuleConfig(m, outputConfigurations))
		]
		result
	}

}

class IdeaModuleConfig extends ProjectConfig {

	val Module module
	val IOutputConfigurationProvider outputConfigurations

	new(Module module, IOutputConfigurationProvider outputConfigurations) {
		super(module.name)
		this.module = module
		this.outputConfigurations = outputConfigurations
	}

	override getSourceFolderMappings() {
		val mappings = super.sourceFolderMappings
		if (mappings.isEmpty) {
			ModuleRootManager.getInstance(module).sourceRoots.forEach [ root |
				val project = module.project
				val moduleBaseDir = project.baseDir.findChild(module.name)
				val relativeSourceFolder = VfsUtil.getRelativePath(root, moduleBaseDir, Path.SEGMENT_SEPARATOR)
				val sourcePath = module.name + Path.SEGMENT_SEPARATOR + relativeSourceFolder
				val outputPath = module.name + Path.SEGMENT_SEPARATOR + outputConfigurations.outputConfigurations.head.getOutputDirectory(sourcePath)
				mappings.put(new Path(sourcePath), new Path(outputPath))
			]
		}
		mappings
	}
	
	override getRootPath() {
		new Path(module.name)
	}

}
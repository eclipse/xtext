/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.file

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtend.lib.macro.file.FileLocations
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.xbase.file.ProjectConfig
import org.eclipse.xtext.xbase.file.WorkspaceConfig
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class FileLocationsImpl implements FileLocations {
	
	@Inject @Accessors Provider<WorkspaceConfig> projectInformationProvider
	
	protected def ProjectConfig getProjectConfig(Path path) {
		val string = path.getSegments().get(0)
		val projectConfig = projectInformationProvider.get.projects.get(string)
		if (projectConfig == null) {
			throw new IllegalArgumentException("The project '"+string+"' has not been configured.")
		}
		return projectConfig
	}
	
	override Path getSourceFolder(Path path) {
		val config = getProjectConfig(path)
		for (Path src : config.sourceFolderMappings.keySet()) {
			if (path.startsWith(src)) {
				return src
			}
		}
		return null
	}

	override Path getTargetFolder(Path path) {
		val config = getProjectConfig(path)
		for (Path src : config.sourceFolderMappings.keySet()) {
			if (path.startsWith(src)) {
				return config.sourceFolderMappings.get(src)
			}
		}
		return null
	}

	override Path getProjectFolder(Path path) {
		val config = getProjectConfig(path)
		return config.rootPath
	}
	
	override getProjectSourceFolders(Path path) {
		val config = getProjectConfig(path)
		return config.sourceFolderMappings.keySet.immutableCopy
	}
	
}
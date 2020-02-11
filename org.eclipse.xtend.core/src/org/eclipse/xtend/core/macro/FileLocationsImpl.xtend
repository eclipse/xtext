/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.file.FileLocations
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.IProjectConfigProvider

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class FileLocationsImpl implements FileLocations {
	
	@Inject @Accessors IProjectConfigProvider projectInformationProvider
	@Inject @Accessors IContextualOutputConfigurationProvider outputConfigurationProvider
	@Accessors Resource context
	
	protected def IProjectConfig getProjectConfig(Path path) {
		val firstSegment = path.getSegments().get(0)
		val projectConfig = projectInformationProvider.getProjectConfig(context.resourceSet)
		if (projectConfig === null || projectConfig.name != firstSegment) {
			throw new IllegalArgumentException("The project '"+firstSegment+"' has not been configured.")
		}
		return projectConfig
	}
	
	override Path getSourceFolder(Path path) {
		getProjectSourceFolders(path).findFirst[sourceFolder| path.startsWith(sourceFolder)]
	}

	override Path getTargetFolder(Path path) {
		val projectFolder = getProjectFolder(path)
		if (projectFolder === null) {
		 return null
		}
		val outputConfiguration = outputConfigurationProvider.getOutputConfigurations(context).head
		val sourceFolder = getSourceFolder(path)
		val outputFolder = if (sourceFolder === null) {
			outputConfiguration.outputDirectory
		} else {
			val projectRelativeSourceFolder = sourceFolder.segments.tail.join('/')
			outputConfiguration.getOutputDirectory(projectRelativeSourceFolder)
		}
		projectFolder.append(outputFolder)
	}

	override Path getProjectFolder(Path path) {
		val config = getProjectConfig(path)
		return Path.ROOT.append(config.name)
	}
	
	override getProjectSourceFolders(Path path) {
		getProjectConfig(path).sourceFolders.map[path.projectFolder.append(name)].toSet
	}
	
}

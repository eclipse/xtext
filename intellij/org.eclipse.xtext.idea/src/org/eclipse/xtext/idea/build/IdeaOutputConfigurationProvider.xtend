/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build

import com.google.common.collect.Sets
import com.google.inject.Inject
import com.intellij.openapi.module.Module
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.generator.OutputConfiguration.SourceMapping
import org.eclipse.xtext.idea.facet.FacetProvider
import org.eclipse.xtext.resource.XtextResourceSet

import static extension org.eclipse.xtext.idea.extensions.RootModelExtensions.*

/**
 * @author dhuebner - Initial contribution and API
 */
class IdeaOutputConfigurationProvider implements IContextualOutputConfigurationProvider {

	@Inject FacetProvider facetProvider;
	@Inject IOutputConfigurationProvider defaultOutput

	override Set<OutputConfiguration> getOutputConfigurations(Resource context) {
		val module = (context.resourceSet as XtextResourceSet).classpathURIContext
		if (module instanceof Module) {
			return module.outputConfigurations
		}
		return defaultOutput.outputConfigurations
	}
	
	def Set<OutputConfiguration> getOutputConfigurations(Module module) {
		val facet = facetProvider.getFacet(module)
		if (facet != null) {
			val generatorConf = facet.configuration.state
			val defOut = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT)
			defOut.outputDirectory = generatorConf.outputDirectory
			defOut.createOutputDirectory = generatorConf.createDirectory
			defOut.canClearOutputDirectory = generatorConf.deleteGenerated
			defOut.overrideExistingResources = generatorConf.overwriteExisting
			defOut.useOutputPerSourceFolder = true
			val allSrcFolders = module.existingSourceFolders
			for (srcFolder : allSrcFolders) {
				val mapping = new SourceMapping(srcFolder.relativePath)
				if (srcFolder.testSource) {
					mapping.outputDirectory = generatorConf.testOutputDirectory
				} else {
					mapping.outputDirectory = generatorConf.outputDirectory
				}
				defOut.sourceMappings.add(mapping)
			}
			return Sets.newHashSet(defOut)
		}
		return defaultOutput.outputConfigurations
	}

}
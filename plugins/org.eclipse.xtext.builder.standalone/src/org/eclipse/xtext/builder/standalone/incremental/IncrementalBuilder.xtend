/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.builder.standalone.ClusteringConfig
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.URIBasedFileSystemAccess
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy
import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.generator.GeneratorDelegate

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
@Log class IncrementalBuilder {
	
	@Data static class Result {
		IndexState indexState
		List<IResourceDescription.Delta> affectedResources
	}
	
	@Log protected static class InternalStatefulIncrementalBuilder {
	
		@Accessors(PROTECTED_SETTER) extension BuildContext context
		@Accessors(PROTECTED_SETTER) BuildRequest request
	
		@Inject Indexer indexer
	
		def Result launch() {
			val newSource2GeneratedMapping = request.previousState.fileMappings.copy
			request.deletedFiles.forEach [
				newSource2GeneratedMapping.deleteSource(it).forEach [
					if (LOG.isInfoEnabled)
						LOG.info("Deleting " + it)
					
					context.resourceSet.URIConverter.delete(it, emptyMap)
					request.afterDeleteFile.apply(it)
				]
			]
			val result = indexer.computeAndIndexAffected(request, context)
			result.resourceDeltas.filter[getNew != null].map[uri]
				.executeClustered [
					Resource resource |
					resource.contents // fully initialize
					EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl)
					val manager = context.getResourceServiceProvider(resource.URI).resourceDescriptionManager
					val description = manager.getResourceDescription(resource);
                    val copiedDescription = SerializableResourceDescription.createCopy(description);
                    result.newIndex.addDescription(resource.URI, copiedDescription)
					if (resource.validate) {
						resource.generate(request, newSource2GeneratedMapping)
					}
					return true
				]
			return new Result(new IndexState(result.newIndex, newSource2GeneratedMapping), result.resourceDeltas)
		}
		
		def protected boolean validate(Resource resource) {
			val resourceValidator = getResourceServiceProvider(resource.URI).getResourceValidator();
			if (resourceValidator == null) {
				return true
			}
			LOG.info("Starting validation for input: '" + resource.URI.lastSegment + "'");
			val validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
			return request.afterValidate.afterValidate(resource.URI, validationResult)
		}
	
		protected def void generate(Resource resource, BuildRequest request, Source2GeneratedMapping newMappings) {
			val serviceProvider = resource.URI.getResourceServiceProvider
			val generator = serviceProvider.get(GeneratorDelegate)
			if (generator == null) {
				return;
			}
			LOG.info("Starting generator for input: '" + resource.URI.lastSegment + "'");
			val previous = newMappings.deleteSource(resource.URI)
			val fileSystemAccess = new URIBasedFileSystemAccess() => [
				val outputConfigProvider = serviceProvider.get(IContextualOutputConfigurationProvider)
				outputConfigurations = outputConfigProvider.getOutputConfigurations(resource).toMap[name]
				
				baseDir = request.baseDir
				converter = resource.resourceSet.URIConverter
				
				beforeWrite = [ uri, contents |
					newMappings.addSource2Generated(resource.URI, uri)
					previous.remove(uri)
					request.afterGenerateFile.apply(resource.URI, uri)
					return contents
				]
				beforeDelete = [ uri |
					newMappings.deleteGenerated(uri)
					request.afterDeleteFile.apply(uri)
					return true
				]
			]
			fileSystemAccess.context = resource
			if (request.isWriteStorageResources) {
				switch resource {
					StorageAwareResource case resource.resourceStorageFacade != null: {
						resource.resourceStorageFacade.saveResource(resource, fileSystemAccess)
					}
				}
			}
			generator.beforeGenerate(resource, fileSystemAccess)
			generator.doGenerate(resource, fileSystemAccess)
			generator.afterGenerate(resource, fileSystemAccess)
			// delete everything that was previously generated, but not this time
			previous.forEach[
				LOG.info('Deleting stale generated file ' + it)
				context.resourceSet.URIConverter.delete(it, emptyMap)
				request.getAfterDeleteFile.apply(it)
			]
		}
	
	}

	@Inject Provider<IncrementalBuilder.InternalStatefulIncrementalBuilder> provider

	def Result build(BuildRequest request, IResourceServiceProvider.Registry languages) {
		build(request, languages, null)
	}
	
	def Result build(BuildRequest request, IResourceServiceProvider.Registry languages, ClusteringConfig clusteringConfig) {
		val strategy = if (clusteringConfig != null) {
				LOG.info("Clustering configured.")
				new DynamicResourceClusteringPolicy => [
					// Convert MB to byte to make it easier for the user
					minimumFreeMemory = clusteringConfig.minimumFreeMemory * 1024 * 1024
					minimumClusterSize = clusteringConfig.minimumClusterSize
					minimumPercentFreeMemory = clusteringConfig.minimumPercentFreeMemory
				]
			} else
				new DisabledClusteringPolicy
				
		val resourceSet = request.resourceSet
		resourceSet.addLoadOption(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE, true)
		val context = new BuildContext(languages
									, resourceSet
									, strategy)
		val builder = provider.get
		builder.context = context
		builder.request = request
		return builder.launch
	}
}

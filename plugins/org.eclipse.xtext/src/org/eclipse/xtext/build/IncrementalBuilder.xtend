/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.build

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.generator.GeneratorDelegate
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import org.eclipse.xtext.generator.URIBasedFileSystemAccess
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider

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
			val newSource2GeneratedMapping = request.newState.fileMappings
			request.deletedFiles.forEach [
				newSource2GeneratedMapping.deleteSource(it).forEach [
					if (LOG.isInfoEnabled)
						LOG.info("Deleting " + it)
					
					context.resourceSet.getURIConverter.delete(it, emptyMap)
					request.afterDeleteFile.apply(it)
				]
			]
			val result = indexer.computeAndIndexAffected(request, context)
			
			val resolvedDeltas = newArrayList
			// add deleted deltas
			resolvedDeltas += result.resourceDeltas.filter[getNew == null]
			// add changed and added as fully resolved
			resolvedDeltas += result.resourceDeltas.filter[getNew != null].map[uri]
				.executeClustered [
					Resource resource |
					resource.contents // fully initialize
					EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl)
					val manager = context.getResourceServiceProvider(resource.getURI).resourceDescriptionManager
					val description = manager.getResourceDescription(resource);
                    val copiedDescription = SerializableResourceDescription.createCopy(description);
                    result.newIndex.addDescription(resource.getURI, copiedDescription)
					if (resource.validate) {
						resource.generate(request, newSource2GeneratedMapping)
					}
					val old = request.previousState.resourceDescriptions.getResourceDescription(resource.getURI)
					return manager.createDelta(old, copiedDescription)
				]
			return new Result(request.newState, resolvedDeltas)
		}
		
		def protected boolean validate(Resource resource) {
			val resourceValidator = getResourceServiceProvider(resource.getURI).getResourceValidator();
			if (resourceValidator == null) {
				return true
			}
			LOG.info("Starting validation for input: '" + resource.getURI.lastSegment + "'");
			val validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
			return request.afterValidate.afterValidate(resource.getURI, validationResult)
		}
	
		protected def void generate(Resource resource, BuildRequest request, Source2GeneratedMapping newMappings) {
			val serviceProvider = resource.getURI.getResourceServiceProvider
			val generator = serviceProvider.get(GeneratorDelegate)
			if (generator == null) {
				return;
			}
//			LOG.info("Starting generator for input: '" + resource.URI.lastSegment + "'");
			val previous = newMappings.deleteSource(resource.getURI)
			val workspaceConfigProvider = serviceProvider.get(IWorkspaceConfigProvider)
			val workspaceConfig = workspaceConfigProvider?.getWorkspaceConfig(resource.resourceSet)
			val sourceFolder = workspaceConfig?.findProjectContaining(resource.getURI)?.findSourceFolderContaining(resource.getURI)
			val fileSystemAccess = new URIBasedFileSystemAccess() => [
				val outputConfigProvider = serviceProvider.get(IContextualOutputConfigurationProvider)
				outputConfigurations = outputConfigProvider.getOutputConfigurations(resource).toMap[name]
				
				baseDir = request.baseDir
				currentSource = sourceFolder?.name
				converter = resource.resourceSet.getURIConverter
				
				beforeWrite = [ uri, contents |
					newMappings.addSource2Generated(resource.getURI, uri)
					previous.remove(uri)
					request.afterGenerateFile.apply(resource.getURI, uri)
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
				context.resourceSet.getURIConverter.delete(it, emptyMap)
				request.getAfterDeleteFile.apply(it)
			]
		}
	
	}

	@Inject Provider<IncrementalBuilder.InternalStatefulIncrementalBuilder> provider

	def Result build(BuildRequest request, IResourceServiceProvider.Registry languages) {
		build(request, languages, new DisabledClusteringPolicy())
	}
	
	def Result build(BuildRequest request, IResourceServiceProvider.Registry languages, IResourceClusteringPolicy clusteringPolicy) {
		val resourceSet = request.resourceSet
		val context = new BuildContext(languages
									, resourceSet
									, clusteringPolicy)
		val builder = provider.get
		builder.context = context
		builder.request = request
		return builder.launch
	}
}

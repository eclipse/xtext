/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.build

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.generator.GeneratorDelegate
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider2
import org.eclipse.xtext.generator.IFilePostProcessor
import org.eclipse.xtext.generator.IShouldGenerate
import org.eclipse.xtext.generator.URIBasedFileSystemAccess
import org.eclipse.xtext.generator.trace.TraceFileNameProvider
import org.eclipse.xtext.generator.trace.TraceRegionSerializer
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.workspace.IProjectConfigProvider
import org.eclipse.xtext.generator.GeneratorContext
import org.eclipse.xtext.resource.XtextResource
import com.google.inject.Singleton

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
class IncrementalBuilder {
	
	@Data static class Result {
		IndexState indexState
		List<IResourceDescription.Delta> affectedResources
	}
	
	static class InternalStatefulIncrementalBuilder {
	
		@Accessors(#[PROTECTED_SETTER, PROTECTED_GETTER]) extension BuildContext context
		@Accessors(#[PROTECTED_SETTER, PROTECTED_GETTER]) BuildRequest request
	
		@Inject Indexer indexer
		@Inject extension OperationCanceledManager
		
		protected def void unloadResource(URI uri) {
		    val resource = request.resourceSet.getResource(uri, false)
            if (resource !== null) {
                request.resourceSet.resources.remove(resource)
                resource.unload
            }
		}
		
		def Result launch() {
			val newSource2GeneratedMapping = request.state.fileMappings
			val unloaded = newHashSet()
		    for (deleted : request.deletedFiles) {
                if (unloaded.add(deleted)) {
                    unloadResource(deleted)
                }
            }
            for (dirty : request.dirtyFiles) {
                if (unloaded.add(dirty)) {
                    unloadResource(dirty)
                }
            }
			request.deletedFiles.forEach [ source |
				request.afterValidate.afterValidate(source, newArrayList)
				newSource2GeneratedMapping.deleteSource(source).forEach [ generated |
					val serviceProvider = source.resourceServiceProvider
					val configs = serviceProvider.get(IContextualOutputConfigurationProvider2).getOutputConfigurations(request.resourceSet)
					val configName = newSource2GeneratedMapping.getOutputConfigName(generated)
					val config = configs.findFirst[name == configName]
					if (config !== null && config.isCleanUpDerivedResources) {
						context.resourceSet.getURIConverter.delete(generated, emptyMap)
						request.afterDeleteFile.apply(generated)
					}
				]
			]
			val result = indexer.computeAndIndexAffected(request, context)
			request.cancelIndicator.checkCanceled
		    for (delta : result.resourceDeltas) {
                if (unloaded.add(delta.uri)) {
                    unloadResource(delta.uri)
                }
		    }
			
			val resolvedDeltas = newArrayList
			// add deleted deltas
			resolvedDeltas += result.resourceDeltas.filter[getNew === null]
			// add changed and added as fully resolved
			resolvedDeltas += result.resourceDeltas.filter[getNew !== null].map[uri]
				.executeClustered [
					Resource resource |
					request.cancelIndicator.checkCanceled
					resource.contents // fully initialize
					EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl)
					request.cancelIndicator.checkCanceled
					val serviceProvider = resource.resourceServiceProvider
					val manager = serviceProvider.resourceDescriptionManager
					val description = manager.getResourceDescription(resource);
                    val copiedDescription = SerializableResourceDescription.createCopy(description);
                    result.newIndex.addDescription(resource.getURI, copiedDescription)
                    request.cancelIndicator.checkCanceled
					if (!request.indexOnly 
						&& resource.validate 
						&& serviceProvider.get(IShouldGenerate).shouldGenerate(resource, CancelIndicator.NullImpl)
					) {
						request.cancelIndicator.checkCanceled
						resource.generate(request, newSource2GeneratedMapping)
					}
					val old = oldState.resourceDescriptions.getResourceDescription(resource.getURI)
					return manager.createDelta(old, copiedDescription)
				]
			return new Result(request.state, resolvedDeltas)
		}
		
		def private IResourceServiceProvider getResourceServiceProvider(Resource resource) {
			if (resource instanceof XtextResource) {
				return resource.resourceServiceProvider;
			}
			return resource.getURI.resourceServiceProvider
		}
		
		def protected boolean validate(Resource resource) {
			val resourceValidator = resource.resourceServiceProvider.resourceValidator;
			if (resourceValidator === null) {
				return true
			}
			val validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
			return request.afterValidate.afterValidate(resource.getURI, validationResult)
		}
	
		protected def void generate(Resource resource, BuildRequest request, Source2GeneratedMapping newMappings) {
			val serviceProvider = resource.resourceServiceProvider
			val generator = serviceProvider.get(GeneratorDelegate)
			if (generator === null) {
				return;
			}
			val previous = newMappings.deleteSource(resource.getURI)
			val fileSystemAccess = createFileSystemAccess(serviceProvider, resource) => [
				beforeWrite = [ uri, outputCfgName, contents |
					newMappings.addSource2Generated(resource.getURI, uri, outputCfgName)
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
					StorageAwareResource case resource.resourceStorageFacade !== null: {
						resource.resourceStorageFacade.saveResource(resource, fileSystemAccess)
					}
				}
			}
			val generatorContext = new GeneratorContext
			generatorContext.cancelIndicator = request.cancelIndicator
			generator.generate(resource, fileSystemAccess, generatorContext)
			// delete everything that was previously generated, but not this time
			previous.forEach[
				context.resourceSet.getURIConverter.delete(it, emptyMap)
				request.getAfterDeleteFile.apply(it)
			]
		}
		
		@Singleton
		static class URIBasedFileSystemAccessFactory {
			@Inject IContextualOutputConfigurationProvider outputConfigurationProvider;
			@Inject IFilePostProcessor postProcessor;
			@Inject(optional=true) IEncodingProvider encodingProvider
			@Inject TraceFileNameProvider traceFileNameProvider
			@Inject TraceRegionSerializer traceRegionSerializer
			@Inject(optional=true) IProjectConfigProvider projectConfigProvider
			
			def URIBasedFileSystemAccess newFileSystemAccess(Resource resource, BuildRequest request) {
				return new URIBasedFileSystemAccess() => [
					outputConfigurations = outputConfigurationProvider.getOutputConfigurations(resource).toMap[name]
					
					it.postProcessor = postProcessor
					if (encodingProvider !== null)
						it.encodingProvider = encodingProvider
					it.traceFileNameProvider = traceFileNameProvider
					it.traceRegionSerializer = traceRegionSerializer
					generateTraces = true
					
					baseDir = request.baseDir
					if (projectConfigProvider !== null) {
						val sourceFolder = projectConfigProvider.getProjectConfig(resource.resourceSet)?.findSourceFolderContaining(resource.getURI)
						currentSource = sourceFolder?.name
					}
					converter = resource.resourceSet.getURIConverter
				]
			}
		}
	
		protected def createFileSystemAccess(IResourceServiceProvider serviceProvider, Resource resource) {
			return serviceProvider.get(URIBasedFileSystemAccessFactory).newFileSystemAccess(resource, request)
		}
	
	}

	@Inject Provider<IncrementalBuilder.InternalStatefulIncrementalBuilder> provider
	@Inject extension OperationCanceledManager

	def Result build(BuildRequest request, (URI)=>IResourceServiceProvider languages) {
		build(request, languages, new DisabledClusteringPolicy())
	}
	
	def Result build(BuildRequest request, (URI)=>IResourceServiceProvider languages, IResourceClusteringPolicy clusteringPolicy) {
		val resourceSet = request.resourceSet
		val oldState = new IndexState(request.state.resourceDescriptions.copy, request.state.fileMappings.copy)
		val context = new BuildContext(languages
									, resourceSet
									, oldState
									, clusteringPolicy,
									request.cancelIndicator)
		val builder = provider.get
		builder.setContext(context)
		builder.setRequest(request)
		try {
			return builder.launch
		} catch(Throwable t) {
			t.propagateIfCancelException
			throw t
		}
	}
}

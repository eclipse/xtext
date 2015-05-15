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
import java.io.File
import java.util.Map
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.builder.standalone.ClusteringConfig
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess.IFileCallback
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy
import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.Files
import org.eclipse.xtext.validation.CheckMode

import static org.eclipse.xtext.builder.standalone.incremental.IncrementalStandaloneBuilder.*

import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
class IncrementalStandaloneBuilder {
	static final Logger LOG = Logger.getLogger(IncrementalStandaloneBuilder);
	
	protected static class InternalStatefulIncrementalBuilder {
	
		@Accessors(PROTECTED_SETTER) extension BuildContext context
		@Accessors(PROTECTED_SETTER) BuildRequest request
	
		@Inject Indexer indexer
	
		def IndexState launch() {
			initialize
			cleanup
			val newSource2GeneratedMapping = request.previousState.fileMappings.copy
			request.deletedFiles.forEach [
				newSource2GeneratedMapping.deleteSource(it).forEach [
					LOG.info("Deleting " + it)
					asFile.delete
					request.afterDeleteFile.apply(it)
				]
			]
			val result = indexer.computeAndIndexAffected(request, context)
			result.affectedResources
				.executeClustered [
					Resource resource |
					resource.contents // fully initialize
					EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl)
					if(resource.validate) {
						resource.generate(request, newSource2GeneratedMapping)
						return true				
					}
					return false 
				]
	//		cleanup
			return new IndexState(result.newIndex, newSource2GeneratedMapping)
		}
		
		def protected initialize() {
			if (request.defaultEncoding != null) {
				LOG.info("Setting encoding.")
				for (lang : languages.values) {
					switch provider : lang.encodingProvider {
						IEncodingProvider.Runtime: {
							provider.setDefaultEncoding(request.defaultEncoding)
						}
						default: {
							LOG.info("Couldn't set encoding '" + request.defaultEncoding + "' for provider '" + provider +
								"'. Only subclasses of IEncodingProvider.Runtime are supported.")
						}
					}
				}
			}
		}
		
		def protected cleanup() {
			if(tempDir.exists) {
				LOG.info('Removing temp folder ' + tempDir)
				Files.sweepFolder(tempDir)
				tempDir.delete		
			}
		}
	
		def protected boolean validate(Resource resource) {
			LOG.info("Starting validation for input: '" + resource.URI.lastSegment + "'");
			val resourceValidator = resource.URI.languageAccess.getResourceValidator();
			val validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
			return request.issueHandler.handleIssue(validationResult)
		}
	
		protected def void generate(Resource resource, BuildRequest request, Source2GeneratedMapping newMappings) {
			LOG.info("Starting generator for input: '" + resource.URI.lastSegment + "'");
			val access = resource.URI.languageAccess
			val previous = newMappings.deleteSource(resource.URI)
			val fileSystemAccess = access.getFileSystemAccess(request)
			fileSystemAccess.setCallBack(new IFileCallback() {
				override fileAdded(File file) {
					val uri = file.asURI
					newMappings.addSource2Generated(resource.URI, uri)
					previous.remove(uri)
					request.afterGenerateFile.apply(resource.URI, uri)
				}
				
				override fileDeleted(File file) {
					val uri = file.asURI
					newMappings.deleteGenerated(uri)
					request.afterDeleteFile.apply(uri)
				}
			})
			if (request.isWriteStorageResources) {
				switch resource {
					StorageAwareResource case resource.resourceStorageFacade != null: {
						resource.resourceStorageFacade.saveResource(resource, fileSystemAccess)
					}
				}
			}
			access.generator.doGenerate(resource, fileSystemAccess)
			// delete everything that was previously generated, but not this time
			previous.forEach[
				LOG.info('Deleting stale generated file ' + it)
				asFile.delete
				request.getAfterDeleteFile.apply(it)
			]
		}
	
		Map<LanguageAccess, JavaIoFileSystemAccess> configuredFsas = newHashMap()
	
		protected def getFileSystemAccess(LanguageAccess language, BuildRequest request) {
			var fsa = configuredFsas.get(language)
			if (fsa == null) {
				fsa = language.createFileSystemAccess(request.baseDir.asFile)
				configuredFsas.put(language, fsa)
			}
			return fsa
		}
	
	}

	@Inject Provider<IncrementalStandaloneBuilder.InternalStatefulIncrementalBuilder> provider
	@Inject Provider<XtextResourceSet> resourceSetProvider

	def IndexState build(BuildRequest request, Map<String, LanguageAccess> languages) {
		build(request, languages, null)
	}
	
	def IndexState build(BuildRequest request, Map<String, LanguageAccess> languages, ClusteringConfig clusteringConfig) {
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
				
		val tempDir = new File(request.baseDir.asFile, 'xtext-tmp')
		val resourceSet = resourceSetProvider.get
		resourceSet.addLoadOption(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE, true)
		val context = new BuildContext(languages
									, resourceSet
									, strategy
									, tempDir)
		val builder = provider.get
		builder.context = context
		builder.request = request
		return builder.launch
	}
}

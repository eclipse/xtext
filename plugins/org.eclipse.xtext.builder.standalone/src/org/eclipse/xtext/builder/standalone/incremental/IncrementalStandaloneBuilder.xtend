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
import java.util.List
import java.util.Map
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.builder.standalone.ClusteringConfig
import org.eclipse.xtext.builder.standalone.IIssueHandler
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
 @Accessors(PROTECTED_GETTER)
class IncrementalStandaloneBuilder {
	static final Logger LOG = Logger.getLogger(IncrementalStandaloneBuilder);

	@Accessors(PROTECTED_SETTER, PUBLIC_GETTER) extension BuildContext context
	@Accessors(PROTECTED_SETTER, PUBLIC_GETTER) BuildRequest request

	File baseDir

	@Inject Indexer indexer
	@Inject IIssueHandler issueHandler
	@Inject Source2GeneratedMapping source2GeneratedMapping

	URI currentResourceURI

	protected new() {
	}

	def launch() {
		initialize
		cleanup
		request.deletedFiles.forEach [
			source2GeneratedMapping.getGenerated(it).forEach [
				LOG.info("Deleting " + it)
				asFile.delete
			]
		]
		val affectedResources = indexer.computeAndIndexAffected(request, context)
		val isErrorFree = affectedResources
			.executeClustered [
				Resource resource |
				resource.contents // fully initialize
				EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl)
				if(resource.validate) {
					resource.generate
					return true				
				}
				return false 
			]
			.reduce[$0 && $1]
//		cleanup
		return isErrorFree
	}
	
	def protected initialize() {
		baseDir = request.baseDir.asFile ?: {
			val userDir = System.getProperty('user.dir')
			LOG.warn("Property baseDir not set. Using '" + userDir + "'")
			new File(userDir)
		}
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
			Files.sweepFolder(tempDir)
			tempDir.delete			
		}
	}

	def protected validate(Resource resource) {
		LOG.info("Starting validation for input: '" + resource.URI.lastSegment + "'");
		val resourceValidator = resource.URI.languageAccess.getResourceValidator();
		val validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
		return issueHandler.handleIssue(validationResult)
	}

	def protected generate(Resource resource) {
		LOG.info("Starting generator for input: '" + resource.URI.lastSegment + "'");
		val access = resource.URI.languageAccess
		val fileSystemAccess = access.fileSystemAccess
		if (request.isWriteStorageResources) {
			switch resource {
				StorageAwareResource case resource.resourceStorageFacade != null: {
					resource.resourceStorageFacade.saveResource(resource, fileSystemAccess)
				}
			}
		}
		currentResourceURI = resource.URI
		access.generator.doGenerate(resource, fileSystemAccess)
	}

	Map<LanguageAccess, JavaIoFileSystemAccess> configuredFsas = newHashMap()

	protected def getFileSystemAccess(LanguageAccess language) {
		var fsa = configuredFsas.get(language)
		if (fsa == null) {
			fsa = language.createFileSystemAccess(baseDir)
			fsa = fsa.configureFileSystemAccess(language)
			configuredFsas.put(language, fsa)
		}
		return fsa
	}

	protected def configureFileSystemAccess(JavaIoFileSystemAccess fsa, LanguageAccess language) {
		fsa.setCallBack(new IFileCallback() {
			override fileAdded(File file) {
				val uri = file.asURI
				source2GeneratedMapping.addSource2Generated(currentResourceURI, uri)
				listeners.forEach[
					fileGenerated(currentResourceURI, uri)
				]
			}
			
			override fileDeleted(File file) {
				val uri = file.asURI
				source2GeneratedMapping.deleteGenerated(uri)
				listeners.forEach[
					fileDeleted(uri)
				]
			}
		})
		fsa
	}
	
	static interface FileListener {
		def void fileGenerated(URI source, URI target)
		def void fileDeleted(URI file)
	}

	List<FileListener> listeners = newArrayList

	def addListener(FileListener listener) {
		listeners.add(listener)
	}

	def removeListener(FileListener listener) {
		listeners.remove(listener)
	}
	
	static class Factory {

		@Inject Provider<IncrementalStandaloneBuilder> provider
		@Inject Provider<XtextResourceSet> resourceSetProvider

		def create(BuildRequest request, Map<String, LanguageAccess> languages) {
			create(request, languages, null)
		}
		
		def create(BuildRequest request, Map<String, LanguageAccess> languages, ClusteringConfig clusteringConfig) {
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
			val context = new BuildContext(languages, resourceSet, strategy, tempDir)
			val builder = provider.get
			builder.context = context
			builder.request = request
			builder
		}
	}
}

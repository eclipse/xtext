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
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.builder.standalone.ClusteringConfig
import org.eclipse.xtext.builder.standalone.IIssueHandler
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy
import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode

import static org.eclipse.xtext.builder.standalone.incremental.IncrementalStandaloneBuilder.*

import static extension org.eclipse.emf.common.util.URI.createFileURI

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
 @Accessors(PROTECTED_GETTER)
class IncrementalStandaloneBuilder {
	static final Logger LOG = Logger.getLogger(IncrementalStandaloneBuilder);

	@Accessors(PROTECTED_SETTER, PROTECTED_GETTER) extension BuildContext context
	@Accessors(PROTECTED_SETTER, PROTECTED_GETTER) BuildRequest request

	File baseDir

	@Inject Indexer indexer
	@Inject IIssueHandler issueHandler

	protected new() {
	}

	def launch() {
		initialize
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
		return isErrorFree
	}
	
	def protected initialize() {
		baseDir = request.baseDir ?: {
			val userDir = System.getProperty('user.dir')
			LOG.warn("Property baseDir not set. Using '" + userDir + "'")
			new File(userDir)
		}
		if (needsJava) 
			LOG.info("Using common types.")
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

	def protected validate(Resource resource) {
		LOG.info("Starting validation for input: '" + resource.getURI().lastSegment() + "'");
		val resourceValidator = resource.URI.languageAccess.getResourceValidator();
		val validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
		return issueHandler.handleIssue(validationResult)
	}

	def protected generate(Resource resource) {
		LOG.info("Starting generator for input: '" + resource.getURI().lastSegment() + "'");
		registerCurrentSource(resource.URI)
		val access = resource.URI.languageAccess
		val fileSystemAccess = access.fileSystemAccess
		if (request.isWriteStorageResources) {
			switch resource {
				StorageAwareResource case resource.resourceStorageFacade != null: {
					resource.resourceStorageFacade.saveResource(resource, fileSystemAccess)
				}
			}
		}
		access.generator.doGenerate(resource, fileSystemAccess);
	}

	def protected registerCurrentSource(URI uri) {
		val fsa = uri.languageAccess.fileSystemAccess
		val absoluteSource = request.sourceRoots.map[absolutePath.createFileURI.toString].filter [
			uri.toString.startsWith(it)
		].reduce[longest, current|if(current.length > longest.length) current else longest]?.createFileURI
		if (absoluteSource == null) {
			throw new IllegalStateException(
				'''Resource «uri» is not contained in any of the known source folders «request.sourceRoots».''')
		}
		for (output : fsa.outputConfigurations.values) {
			for (relativeSource : output.sourceFolders) {
				if (absoluteSource.toString.endsWith(relativeSource)) {
					fsa.currentSource = relativeSource
				}
			}
		}
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
		fsa
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
			val needsJava = languages.values.exists[linksAgainstJava]
			val context = new BuildContext(languages, needsJava, resourceSetProvider.get, strategy)
			val builder = provider.get
			builder.context = context
			builder.request = request
			builder
		}
	}
}

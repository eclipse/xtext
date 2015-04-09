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
import java.io.IOException
import java.util.Collection
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
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler.CompilationResult
import org.eclipse.xtext.generator.AbstractFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess
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

	@Accessors(PROTECTED_SETTER, PROTECTED_GETTER) BuildContext context
	@Accessors(PROTECTED_SETTER, PROTECTED_GETTER) BuildRequest request

	File baseDir

	@Inject Indexer indexer
	@Inject AbstractFileSystemAccess commonFileAccess
	@Inject IIssueHandler issueHandler
	@Inject IJavaCompiler compiler
	@Inject JavaSupport javaSupport
	@Inject extension ResourceSetClearer

	protected new() {
	}

	def launch() {
		baseDir = request.baseDir ?: {
			val userDir = System.getProperty('user.dir')
			LOG.warn("Property baseDir not set. Using '" + userDir + "'")
			new File(userDir)
		}
		if (context.needsJava) {
			LOG.info("Using common types.")
		}
		val resourceSet = context.resourceSet
		if (request.defaultEncoding != null) {
			LOG.info("Setting encoding.")
			fileEncodingSetup(context.languages.values, request.defaultEncoding)
		}

		val indexerResult = indexer.computeAffected(request, context)

		// Generate Stubs
		if (context.needsJava) {
			val stubsClasses = compileStubs(generateStubs(indexerResult))
			LOG.info("Installing type provider for stubs.")
			javaSupport.installTypeProvider(request.sourceRoots + request.classPath + newArrayList(stubsClasses),
				resourceSet)
		}

		// Validate and generate
		LOG.info("Validate and generate.")
		val sourceResourceIterator = indexerResult.changedResources.iterator
		var isErrorFree = true
		while (sourceResourceIterator.hasNext) {
			var List<Resource> resources = newArrayList()
			var int clusterIndex = 0
			var continue = true
			while (sourceResourceIterator.hasNext && continue) {
				val uri = sourceResourceIterator.next
				val resource = resourceSet.getResource(uri, true)
				resources.add(resource)
				resource.contents // full initialize
				EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl)
				isErrorFree = validate(resource)
				clusterIndex++
				if (!context.clusteringPolicy.continueProcessing(resourceSet, null, clusterIndex)) {
					continue = false
				}
			}
			if (request.failOnValidationError && !isErrorFree) {
				return isErrorFree
			}
			generate(resources)
			if (!continue)
				resourceSet.clearResourceSet
		}
		return isErrorFree
	}

	def fileEncodingSetup(Collection<LanguageAccess> langs, String encoding) {
		for (lang : langs) {
			switch provider : lang.encodingProvider {
				IEncodingProvider.Runtime: {
					provider.setDefaultEncoding(encoding)
				}
				default: {
					LOG.info("Couldn't set encoding '" + encoding + "' for provider '" + provider +
						"'. Only subclasses of IEncodingProvider.Runtime are supported.")
				}
			}
		}
	}

	def protected compileStubs(File stubsDir) {
		val stubsClassesFolder = createTempDir("classes")
		compiler.setClassPath(request.classPath.map[absolutePath])
		LOG.info("Compiling stubs located in " + stubsDir.absolutePath)
		val sourcesToCompile = uniqueEntries(request.sourceRoots.map[absolutePath] +
			newArrayList(stubsDir.absolutePath))
		LOG.info("Compiler source roots: " + sourcesToCompile.join(','))
		val result = compiler.compile(sourcesToCompile, stubsClassesFolder)
		switch (result) {
			case CompilationResult.SKIPPED:
				LOG.info("Nothing to compile. Stubs compilation was skipped.")
			case CompilationResult.FAILED:
				LOG.info("Stubs compilation finished with errors.")
			case CompilationResult.SUCCEEDED:
				LOG.info("Stubs compilation successfully finished.")
		}
		return stubsClassesFolder
	}

	def protected uniqueEntries(Iterable<String> pathes) {
		pathes.map[new File(it).absolutePath].toSet
	}

	def protected generateStubs(IndexerResult result) {
		val stubsDir = createTempDir("stubs")
		LOG.info("Generating stubs into " + stubsDir.absolutePath)
		commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, stubsDir.absolutePath)
		val generateStubs = result.changedResources.filter[languageAccess.linksAgainstJava]
		generateStubs.forEach [
			languageAccess.stubGenerator.doGenerateStubs(commonFileAccess, result.newIndex.getResourceDescription(it))
		]
		return stubsDir
	}

	def protected validate(Resource resource) {
		LOG.info("Starting validation for input: '" + resource.getURI().lastSegment() + "'");
		val resourceValidator = languageAccess(resource.URI).getResourceValidator();
		val validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
		return issueHandler.handleIssue(validationResult)
	}

	def protected generate(List<Resource> sourceResources) {
		for (Resource it : sourceResources) {
			LOG.info("Starting generator for input: '" + getURI().lastSegment() + "'");
			registerCurrentSource(it.URI)
			val access = URI.languageAccess
			val fileSystemAccess = access.fileSystemAccess
			if (request.isWriteStorageResources) {
				switch it {
					StorageAwareResource case resourceStorageFacade != null: {
						resourceStorageFacade.saveResource(it, fileSystemAccess)
					}
				}
			}
			access.generator.doGenerate(it, fileSystemAccess);
		}
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

	private def getFileSystemAccess(LanguageAccess language) {
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

	def private languageAccess(URI uri) {
		context.languages.get(uri.fileExtension)
	}

	def protected createTempDir(String subDir) {
		val file = new File(request.tempDir, subDir)
		if (!file.mkdirs && !file.exists)
			throw new IOException("Failed to create directory '" + file.absolutePath + "'")
		return file
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
						setMinimumFreeMemory(clusteringConfig.minimumFreeMemory * 1024 * 1024)
						setMinimumClusterSize(clusteringConfig.minimumClusterSize)
						setMinimumPercentFreeMemory(clusteringConfig.minimumPercentFreeMemory)
					]
				} else
					new DisabledClusteringPolicy
			val needsJava = languages.values.exists[linksAgainstJava]
			val context = new BuildContext(languages, needsJava, resourceSetProvider.get, strategy)
			val builder = provider.get()
			builder.setContext(context)
			builder.setRequest(request)
			builder
		}
	}
}

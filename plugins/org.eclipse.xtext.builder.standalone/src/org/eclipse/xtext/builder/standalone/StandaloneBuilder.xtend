package org.eclipse.xtext.builder.standalone

import com.google.common.io.Files
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.File
import java.io.IOException
import java.net.URLClassLoader
import java.util.Collection
import java.util.List
import java.util.Map
import java.util.jar.JarFile
import java.util.jar.Manifest
import java.util.regex.Pattern
import java.util.zip.ZipException
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler.CompilationResult
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess
import org.eclipse.xtext.generator.AbstractFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.mwe.NameBasedFilter
import org.eclipse.xtext.mwe.PathTraverser
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy
import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.UriUtil
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.generator.GeneratorContext

class StandaloneBuilder {
	static final Logger LOG = Logger.getLogger(StandaloneBuilder);

	/**  Map key is a file extension provided by Language FileExtensionProvider   */
	@Accessors Map<String, LanguageAccess> languages
	@Accessors String baseDir
	@Accessors Iterable<String> sourceDirs
	@Accessors Iterable<String> javaSourceDirs = newArrayList
	@Accessors Iterable<String> classPathEntries
	@Accessors File tempDir = Files.createTempDir
	@Accessors String encoding
	@Accessors String classPathLookUpFilter
	/**
	 * If failOnValidationError is set to <code>false</code>, StandaloneBuilder will try to execute<br>
	 * language generator in spite of validation errors.<br>
	 * Note that {@link #launch()} will still return the current validation state.
	 * <br>Default is <code>true</code>
	 */
	@Accessors boolean failOnValidationError = true
	@Accessors boolean debugLog
	@Accessors boolean writeStorageResources
	@Accessors ClusteringConfig clusteringConfig = null

	@Inject IndexedJvmTypeAccess jvmTypeAccess
	@Inject Provider<XtextResourceSet> resourceSetProvider
	@Inject AbstractFileSystemAccess commonFileAccess
	@Inject protected IIssueHandler issueHandler
	@Inject IEncodingProvider.Runtime encodingProvider
	@Inject IJavaCompiler compiler

	def void setTempDir(String pathAsString) {
		if (pathAsString != null) {
			tempDir = new File(pathAsString)
		}
	}

	/**
	 * 
	 *  @return <code>false</code> if some of processed resources contains severe validation issues. <code>true</code> otherwise
	 */
	def boolean launch() {
		val needsJava = languages.values.exists[linksAgainstJava]
		if (baseDir == null) {
			baseDir = System.getProperty('user.dir')
			LOG.warn("Property baseDir not set. Using '" + baseDir + "'")
		}
		if (needsJava) {
			LOG.info("Using common types.")
		}

		val resourceSet = resourceSetProvider.get

		if (encoding != null) {
			forceDebugLog("Setting encoding.")
			fileEncodingSetup(languages.values, encoding)
		}

		LOG.info("Collecting source models.")
		val startedAt = System.currentTimeMillis
		var rootsToTravers = classPathEntries
		if (classPathLookUpFilter != null) {
			LOG.info("Class path look up filter is active.")
			val cpLookUpFilter = Pattern.compile(classPathLookUpFilter)
			rootsToTravers = classPathEntries.filter[root|cpLookUpFilter.matcher(root).matches]
			LOG.info(
				"Investigating " + rootsToTravers.length + " of " + classPathEntries.length + " class path entries.");
		}
		val sourceResourceURIs = collectResources(sourceDirs, resourceSet)
		val allResourcesURIs = sourceResourceURIs + collectResources(rootsToTravers, resourceSet)
		forceDebugLog("Finished collecting source models. Took: " + (System.currentTimeMillis - startedAt) + " ms.")

		val allClassPathEntries = (sourceDirs + classPathEntries)
		if (needsJava) {
			LOG.info("Installing type provider.")
			installTypeProvider(allClassPathEntries, resourceSet, null)
		}
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

		// Fill index
		var ResourceDescriptionsData index = new ResourceDescriptionsData(newArrayList());
		var allResourceIterator = allResourcesURIs.iterator
		while (allResourceIterator.hasNext) {
			var List<Resource> resources = newArrayList()
			var int clusterIndex = 0
			var continue = true
			while (allResourceIterator.hasNext && continue) {
				val uri = allResourceIterator.next
				val resource = resourceSet.getResource(uri, true)
				resources.add(resource)
				fillIndex(uri, resource, index)
				clusterIndex++
				if (!strategy.continueProcessing(resourceSet, null, clusterIndex)) {
					continue = false
				}
			}
			if (!continue)
				resourceSet.clearResourceSet
		}
		installIndex(resourceSet, index)

		// Generate Stubs
		if (needsJava) {
			val stubsClasses = compileStubs(generateStubs(index, sourceResourceURIs))
			LOG.info("Installing type provider for stubs.")
			installTypeProvider(allClassPathEntries + newArrayList(stubsClasses), resourceSet, jvmTypeAccess)
		}

		// Validate and generate
		LOG.info("Validate and generate.")
		val sourceResourceIterator = sourceResourceURIs.iterator
		var hasValidationErrors = false
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
				hasValidationErrors = !validate(resource) || hasValidationErrors
				clusterIndex++
				if (!strategy.continueProcessing(resourceSet, null, clusterIndex)) {
					continue = false
				}
			}
			if (failOnValidationError && hasValidationErrors) {
				return !hasValidationErrors
			}
			generate(resources)
			if (!continue)
				resourceSet.clearResourceSet
		}
		return !hasValidationErrors
	}

	def fillIndex(URI uri, Resource resource, ResourceDescriptionsData index) {
		val description = languageAccess(uri).resourceDescriptionManager.getResourceDescription(resource)
		index.addDescription(uri, description)
	}

	def fileEncodingSetup(Collection<LanguageAccess> langs, String encoding) {
		for (lang : langs) {
			switch provider : lang.encodingProvider {
				IEncodingProvider.Runtime: {
					provider.setDefaultEncoding(encoding)
				}
				default: {
					forceDebugLog("Couldn't set encoding '" + encoding + "' for provider '" + provider +
						"'. Only subclasses of IEncodingProvider.Runtime are supported.")
				}
			}
		}
	}

	def protected installIndex(XtextResourceSet resourceSet, ResourceDescriptionsData index) {
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index)
	}

	def protected compileStubs(File stubsDir) {
		val stubsClasses = createTempDir("classes")
		compiler.setClassPath(classPathEntries)
		LOG.info("Compiling stubs located in " + stubsDir.absolutePath)
		val sourcesToCompile = uniqueEntries(javaSourceDirs + sourceDirs + newArrayList(stubsDir.absolutePath))
		forceDebugLog("Compiler source roots: " + sourcesToCompile.join(','))
		val result = compiler.compile(sourcesToCompile, stubsClasses)
		switch (result) {
			case CompilationResult.SKIPPED:
				LOG.info("Nothing to compile. Stubs compilation was skipped.")
			case CompilationResult.FAILED:
				forceDebugLog("Stubs compilation finished with errors.")
			case CompilationResult.SUCCEEDED:
				forceDebugLog("Stubs compilation successfully finished.")
		}
		return stubsClasses.absolutePath
	}

	def protected uniqueEntries(Iterable<String> pathes) {
		pathes.map[new File(it).absolutePath].toSet
	}

	def protected generateStubs(ResourceDescriptionsData data, List<URI> sourceResourceURIs) {
		val stubsDir = createTempDir("stubs")
		LOG.info("Generating stubs into " + stubsDir.absolutePath)
		if (encoding != null)
			encodingProvider.setDefaultEncoding(encoding)
		commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, stubsDir.absolutePath)
		val generateStubs = sourceResourceURIs.filter[languageAccess.linksAgainstJava]
		generateStubs.forEach [
			languageAccess.stubGenerator.doGenerateStubs(commonFileAccess, data.getResourceDescription(it))
		]
		return stubsDir
	}

	def protected boolean validate(Resource resource) {
		LOG.info("Starting validation for input: '" + resource.getURI().lastSegment() + "'");
		val resourceValidator = languageAccess(resource.URI).getResourceValidator();
		val validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
		return issueHandler.handleIssue(validationResult)
	}

	def protected generate(List<Resource> sourceResources) {
		val context = new GeneratorContext
		context.cancelIndicator = CancelIndicator.NullImpl
		for (Resource it : sourceResources) {
			LOG.info("Starting generator for input: '" + getURI().lastSegment() + "'");
			registerCurrentSource(it.URI)
			val access = URI.languageAccess
			val fileSystemAccess = access.fileSystemAccess
			if (isWriteStorageResources) {
				switch it {
					StorageAwareResource case resourceStorageFacade != null: {
						resourceStorageFacade.saveResource(it, fileSystemAccess)
					}
				}
			}
			access.generator.generate(it, fileSystemAccess, context);
		}
	}

	def protected registerCurrentSource(URI uri) {
		val fsa = uri.languageAccess.fileSystemAccess
		val absoluteSource = sourceDirs
			.map[UriUtil.createFolderURI(new File(it))]
			.findFirst [UriUtil.isPrefixOf(it, uri)]
		if (absoluteSource == null) {
			throw new IllegalStateException(
				'''Resource «uri» is not contained in any of the known source folders «sourceDirs».''')
		}
		val projectBaseURI = UriUtil.createFolderURI(new File(baseDir))
		for (output : fsa.outputConfigurations.values) {
			for (sourceFolder : output.sourceFolders) {
				var sourceFolderURI = URI.createURI(sourceFolder+'/')
				if (sourceFolderURI.isRelative) {
					sourceFolderURI = sourceFolderURI.resolve(projectBaseURI)
				}
				if (absoluteSource == sourceFolderURI) {
					fsa.currentSource = sourceFolder
				}
			}
		}
	}

	Map<LanguageAccess, JavaIoFileSystemAccess> configuredFsas = newHashMap()

	private def getFileSystemAccess(LanguageAccess language) {
		var fsa = configuredFsas.get(language)
		if (fsa == null) {
			fsa = language.createFileSystemAccess(new File(baseDir))
			fsa = fsa.configureFileSystemAccess(language)
			configuredFsas.put(language, fsa)
		}
		return fsa
	}

	protected def configureFileSystemAccess(JavaIoFileSystemAccess fsa, LanguageAccess language) {
		fsa
	}

	def private languageAccess(URI uri) {
		languages.get(uri.fileExtension)
	}

	def protected createTempDir(String subDir) {
		val file = new File(tempDir, subDir)
		if(!file.mkdirs && !file.exists) throw new IOException("Failed to create directory '" + file.absolutePath + "'")
		return file
	}

	def protected void installTypeProvider(Iterable<String> classPathRoots, XtextResourceSet resSet,
		IndexedJvmTypeAccess typeAccess) {
		val classLoader = createURLClassLoader(classPathRoots)
		new ClasspathTypeProvider(classLoader, resSet, typeAccess, null)
		resSet.setClasspathURIContext(classLoader);
	}

	def private URLClassLoader createURLClassLoader(Iterable<String> classPathEntries) {
		val classPathUrls = classPathEntries.map[str|new File(str).toURI().toURL()]
		return new URLClassLoader(classPathUrls)
	}

	def protected List<URI> collectResources(Iterable<String> roots, ResourceSet resourceSet) {
		val extensions = languages.keySet.join("|")
		val nameBasedFilter = new NameBasedFilter

		// TODO test with whitespaced file extensions
		nameBasedFilter.setRegularExpression(".*\\.(?:(" + extensions + "))$");
		val List<URI> resources = newArrayList();

		val modelsFound = new PathTraverser().resolvePathes(
			roots.toList,
			[ input |
				val matches = nameBasedFilter.matches(input)
				if (matches) {
					forceDebugLog("Adding file '" + input + "'");
					resources.add(input);
				}
				return matches
			]
		)
		modelsFound.asMap.forEach [ uri, resource |
			val file = new File(uri)
			if (resource != null && !file.directory && file.name.endsWith(".jar")) {
				registerBundle(file)
			}
		]
		return resources;
	}

	def protected registerBundle(File file) {

		// copied from org.eclipse.emf.mwe.utils.StandaloneSetup.registerBundle(File)
		var JarFile jarFile = null;
		try {
			jarFile = new JarFile(file);
			val Manifest manifest = jarFile.getManifest();
			if (manifest == null)
				return;
			var String name = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
			if (name != null) {
				val int indexOf = name.indexOf(';');
				if (indexOf > 0)
					name = name.substring(0, indexOf);
				if (EcorePlugin.getPlatformResourceMap().containsKey(name))
					return;
				val String path = "archive:" + file.toURI() + "!/";
				val URI uri = URI.createURI(path);
				EcorePlugin.getPlatformResourceMap().put(name, uri);
			}
		} catch (ZipException e) {
			forceDebugLog("Could not open Jar file " + file.getAbsolutePath() + ".");
		} catch (Exception e) {
			LOG.error(file.absolutePath, e);
		} finally {
			try {
				if (jarFile != null)
					jarFile.close();
			} catch (IOException e) {
				LOG.error(jarFile, e);
			}
		}
	}

	def getCompiler() {
		compiler
	}

	/**
	 * Clears the content of the resource set without sending notifications.
	 * This avoids unnecessary, explicit unloads.
	 */
	def void clearResourceSet(ResourceSet resourceSet) {
		val wasDeliver = resourceSet.eDeliver();
		try {
			resourceSet.eSetDeliver(false);
			resourceSet.getResources().clear();
		} finally {
			resourceSet.eSetDeliver(wasDeliver);
		}
	}

	def protected forceDebugLog(String logMessage) {
		if (LOG.debugEnabled) {
			LOG.debug(logMessage)
		} else if (debugLog) {
			LOG.info(logMessage)
		}
	}
}

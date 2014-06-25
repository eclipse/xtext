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
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler.CompilationResult
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess
import org.eclipse.xtext.generator.AbstractFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.mwe.NameBasedFilter
import org.eclipse.xtext.mwe.PathTraverser
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode

import static extension org.eclipse.emf.common.util.URI.createFileURI

class StandaloneBuilder {
	static final Logger LOG = Logger.getLogger(StandaloneBuilder);

	/**  Map key is a file extension provided by Language FileExtensionProvider   */
	@Property Map<String, LanguageAccess> languages
	@Property Iterable<String> sourceDirs
	@Property Iterable<String> classPathEntries
	@Property File tempDir = Files.createTempDir
	@Property String encoding
	@Property String classPathLookUpFilter
	@Property boolean failOnValidationError = true
	@Property ClusteringConfig clusteringConfig = null

	@Inject IndexedJvmTypeAccess jvmTypeAccess
	@Inject Provider<XtextResourceSet> resourceSetProvider
	@Inject AbstractFileSystemAccess commonFileAccess
	@Inject IIssueHandler issueHandler
	@Inject IEncodingProvider.Runtime encodingProvider
	@Inject IJavaCompiler compiler

	def void setTempDir(String pathAsString) {
		if (pathAsString != null) {
			_tempDir = new File(pathAsString)
		}
	}

	def launch() {
		val needsJava = languages.values.exists[linksAgainstJava]
		if (needsJava) {
			LOG.info("Using common types.")
		}

		val resourceSet = resourceSetProvider.get

		if (encoding != null) {
			LOG.debug("Setting encoding.")
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
		val allResourcesURIs = sourceResourceURIs + collectResources(rootsToTravers,resourceSet)
		LOG.debug("Finished collecting source models. Took: " + (System.currentTimeMillis - startedAt) + " ms.")

		val allClassPathEntries = (sourceDirs + classPathEntries)
		if (needsJava) {
			LOG.info("Installing type provider.")
			installTypeProvider(allClassPathEntries, resourceSet, null)
		}
		val strategy = if(clusteringConfig != null){
			LOG.info("Clustering configured.")
			new DynamicResourceClusteringStrategy(clusteringConfig)
		} else new DisabledClusteringStrategy
		// Fill index
		var ResourceDescriptionsData index = new ResourceDescriptionsData(newArrayList());
		var allResourceIterator =  allResourcesURIs.iterator
		while(allResourceIterator.hasNext){
			var List<Resource> resources = newArrayList()
			var int clusterIndex = 0
			var continue = true
			while(allResourceIterator.hasNext && continue){
				val uri = allResourceIterator.next
				val resource = resourceSet.getResource(uri,true)
				resources.add(resource)
				val description = languageAccess(uri).resourceDescriptionManager.getResourceDescription(resource)
				index.addDescription(uri, description)
				clusterIndex++
				if(!strategy.continueProcessing(resourceSet,clusterIndex)){
					continue = false
				}
			}
			if(!continue)
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
		val sourceResourceIterator =  sourceResourceURIs.iterator
		var isErrorFree = true
		while(sourceResourceIterator.hasNext){
			var List<Resource> resources = newArrayList()
			var int clusterIndex = 0
			var continue = true
			while(sourceResourceIterator.hasNext && continue){
				val uri = sourceResourceIterator.next
				val resource = resourceSet.getResource(uri,true)
				resources.add(resource)
				resource.contents // full initialize
				EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl)
				clusterIndex++
				if(!strategy.continueProcessing(resourceSet,clusterIndex)){
					continue = false
				}
			}
			isErrorFree = validate(resources)
			if (failOnValidationError && !isErrorFree) {
				return isErrorFree
			}
			generate(resources)
			if(!continue)
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
					LOG.debug(
						"Couldn't set encoding '" + encoding + "' for provider '" + provider +
							"'. Only subclasses of IEncodingProvider.Runtime are supported.")
				}
			}
		}
	}

	def protected installIndex(XtextResourceSet resourceSet, ResourceDescriptionsData index){
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index)
	}

	def protected compileStubs(File stubsDir) {
		val stubsClasses = createTempDir("classes")
		compiler.setClassPath(classPathEntries)
		LOG.info("Compiling stubs located in " + stubsDir.absolutePath)
		val result = compiler.compile(sourceDirs + newArrayList(stubsDir.absolutePath), stubsClasses)
		switch (result) {
			case CompilationResult.SKIPPED:
				LOG.info("Nothing to compile. Stubs compilation was skipped.")
			case CompilationResult.FAILED:
				LOG.debug("Stubs compilation finished with errors.")
			case CompilationResult.SUCCEEDED:
				LOG.debug("Stubs compilation successfully finished.")
		}
		return stubsClasses.absolutePath
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

	def protected validate(List<Resource> sourceResources) {
		val allIssues = newArrayList()
		for (Resource resource : sourceResources) {
			val resourceValidator = languageAccess(resource.URI).getResourceValidator();
			val validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
			allIssues.addAll(validationResult)
		}
		return issueHandler.handleIssue(allIssues)
	}

	def protected generate(List<Resource> sourceResources) {
		for (Resource it : sourceResources) {
			LOG.info("Starting generator for input: '" + getURI().lastSegment() + "'");
			registerCurrentSource(it.URI)
			val access = URI.languageAccess
			access.generator.doGenerate(it, access.fileSystemAccess);
		}
	}

	def protected registerCurrentSource(URI uri) {
		val fsa = uri.languageAccess.fileSystemAccess
		val absoluteSource = sourceDirs.map[new File(it).absolutePath.createFileURI.toString].filter[
			uri.toString.startsWith(it)].reduce[longest, current|
			if(current.length > longest.length) current else longest]?.createFileURI
		if (absoluteSource == null) {
			throw new IllegalStateException(
				'''Resource «uri» is not contained in any of the known source folders «sourceDirs».''')
		}
		for (output : fsa.outputConfigurations.values) {
			for (relativeSource : output.sourceFolders) {
				if (absoluteSource.toString.endsWith(relativeSource)) {
					fsa.currentSource = relativeSource
				}
			}
		}
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
		new ClasspathTypeProvider(classLoader, resSet, typeAccess)
		resSet.setClasspathURIContext(classLoader);
	}

	def private URLClassLoader createURLClassLoader(Iterable<String> classPathEntries) {
		val classPathUrls = classPathEntries.map[str|new File(str).toURI().toURL()]
		return new URLClassLoader(classPathUrls)
	}

	def protected List<URI> collectResources(Iterable<String> roots, ResourceSet resourceSet) {
		val extensions = languages.keySet.join("|")
		val nameBasedFilter = new NameBasedFilter

		//TODO test with whitespaced file extensions
		nameBasedFilter.setRegularExpression(".*\\.(?:(" + extensions + "))$");
		val List<URI> resources = newArrayList();

		val modelsFound = new PathTraverser().resolvePathes(
			roots.toList,
			[ input |
				val matches = nameBasedFilter.matches(input)
				if (matches) {
					LOG.debug("Adding file '" + input + "'");
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
			LOG.debug("Could not open Jar file " + file.getAbsolutePath() + ".");
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
}

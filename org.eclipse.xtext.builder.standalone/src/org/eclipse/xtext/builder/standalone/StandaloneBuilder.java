/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import java.util.zip.ZipException;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.mwe.NameBasedFilter;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy;
import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class StandaloneBuilder {
	private static final Logger LOG = Logger.getLogger(StandaloneBuilder.class);

	/**
	 * Map key is a file extension provided by Language FileExtensionProvider
	 */
	private Map<String, LanguageAccess> languages;

	private String baseDir;

	private Iterable<String> sourceDirs;

	private Iterable<String> javaSourceDirs = new ArrayList<>();

	private Iterable<String> classPathEntries;

	private File tempDir = null;

	private String encoding;

	private String classPathLookUpFilter;

	/**
	 * If failOnValidationError is set to <code>false</code>, StandaloneBuilder
	 * will try to execute<br>
	 * language generator in spite of validation errors.<br>
	 * Note that {@link #launch()} will still return the current validation
	 * state. <br>
	 * Default is <code>true</code>
	 */
	private boolean failOnValidationError = true;

	private boolean debugLog;

	private boolean writeStorageResources;

	private ClusteringConfig clusteringConfig = null;

	@Inject
	private IndexedJvmTypeAccess jvmTypeAccess;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private AbstractFileSystemAccess commonFileAccess;

	@Inject
	protected IIssueHandler issueHandler;

	@Inject
	private IEncodingProvider.Runtime encodingProvider;

	@Inject
	private IJavaCompiler compiler;
	
	public StandaloneBuilder() {
		try {
			tempDir = Files.createTempDirectory("StandaloneBuilder").toFile();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void setTempDir(String pathAsString) {
		if (pathAsString != null) {
			tempDir = new File(pathAsString);
		}
	}

	/**
	 * @return <code>false</code> if some of processed resources contains severe
	 * validation issues. <code>true</code> otherwise
	 */
	public boolean launch() {
		boolean needsJava = IterableExtensions.exists(languages.values(), l -> l.isLinksAgainstJava());
		if (baseDir == null) {
			baseDir = System.getProperty("user.dir");
			LOG.warn("Property baseDir not set. Using '" + baseDir + "'");
		}
		if (needsJava) {
			LOG.info("Using common types.");
		}
		XtextResourceSet resourceSet = resourceSetProvider.get();
		if (encoding != null) {
			forceDebugLog("Setting encoding.");
			fileEncodingSetup(languages.values(), encoding);
		}
		LOG.info("Collecting source models.");
		long startedAt = System.currentTimeMillis();
		Iterable<String> rootsToTravers = classPathEntries;
		if (classPathLookUpFilter != null) {
			LOG.info("Class path look up filter is active.");
			Pattern cpLookUpFilter = Pattern.compile(classPathLookUpFilter);
			rootsToTravers = Iterables.filter(classPathEntries, root -> cpLookUpFilter.matcher(root).matches());
			LOG.info("Investigating " + Iterables.size(rootsToTravers) + " of " + Iterables.size(classPathEntries)
					+ " class path entries.");
		}
		List<URI> sourceResourceURIs = collectResources(sourceDirs, resourceSet);
		Iterable<URI> allResourcesURIs = Iterables.concat(sourceResourceURIs,
				collectResources(rootsToTravers, resourceSet));
		forceDebugLog("Finished collecting source models. Took: " + (System.currentTimeMillis() - startedAt) + " ms.");
		Iterable<String> allClassPathEntries = Iterables.concat(sourceDirs, classPathEntries);
		if (needsJava) {
			LOG.info("Installing type provider.");
			installTypeProvider(allClassPathEntries, resourceSet, null);
		}
		IResourceClusteringPolicy strategy = null;
		if (clusteringConfig != null) {
			LOG.info("Clustering configured.");
			DynamicResourceClusteringPolicy dynamicResourceClusteringPolicy = new DynamicResourceClusteringPolicy();
			// Convert MB to byte to make it easier for the user
			dynamicResourceClusteringPolicy.setMinimumFreeMemory(clusteringConfig.getMinimumFreeMemory() * 1024 * 1024);
			dynamicResourceClusteringPolicy.setMinimumClusterSize(clusteringConfig.getMinimumClusterSize());
			dynamicResourceClusteringPolicy.setMinimumPercentFreeMemory(clusteringConfig.getMinimumPercentFreeMemory());
			strategy = dynamicResourceClusteringPolicy;
		} else {
			strategy = new DisabledClusteringPolicy();
		}
		// Fill index
		ResourceDescriptionsData index = new ResourceDescriptionsData(new ArrayList<>());
		Iterator<URI> allResourceIterator = allResourcesURIs.iterator();
		while (allResourceIterator.hasNext()) {
			List<Resource> resources = new ArrayList<>();
			int clusterIndex = 0;
			boolean canContinue = true;
			while (allResourceIterator.hasNext() && canContinue) {
				URI uri = allResourceIterator.next();
				Resource resource = resourceSet.getResource(uri, true);
				resources.add(resource);
				fillIndex(uri, resource, index);
				clusterIndex++;
				if (!strategy.continueProcessing(resourceSet, null, clusterIndex)) {
					canContinue = false;
				}
			}
			if (!canContinue) {
				clearResourceSet(resourceSet);
			}
		}
		installIndex(resourceSet, index);
		// Generate Stubs
		if (needsJava) {
			String stubsClasses = compileStubs(generateStubs(index, sourceResourceURIs));
			LOG.info("Installing type provider for stubs.");
			installTypeProvider(Iterables.concat(allClassPathEntries, Lists.newArrayList(stubsClasses)), resourceSet,
					jvmTypeAccess);
		}
		// Validate and generate
		LOG.info("Validate and generate.");
		Iterator<URI> sourceResourceIterator = sourceResourceURIs.iterator();
		boolean hasValidationErrors = false;
		while (sourceResourceIterator.hasNext()) {
			List<Resource> resources = new ArrayList<>();
			int clusterIndex = 0;
			boolean canContinue = true;
			while (sourceResourceIterator.hasNext() && canContinue) {
				URI uri = sourceResourceIterator.next();
				Resource resource = resourceSet.getResource(uri, true);
				resources.add(resource);
				resource.getContents(); // full initialize
				EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
				hasValidationErrors = !validate(resource) || hasValidationErrors;
				clusterIndex++;
				if (!strategy.continueProcessing(resourceSet, null, clusterIndex)) {
					canContinue = false;
				}
			}
			if (failOnValidationError && hasValidationErrors) {
				return !hasValidationErrors;
			}
			generate(resources);
			if (!canContinue) {
				clearResourceSet(resourceSet);
			}
		}
		return !hasValidationErrors;
	}

	public void fillIndex(URI uri, Resource resource, ResourceDescriptionsData index) {
		IResourceDescription description = languageAccess(uri).getResourceDescriptionManager()
				.getResourceDescription(resource);
		index.addDescription(uri, description);
	}

	public void fileEncodingSetup(Collection<LanguageAccess> langs, String encoding) {
		for (LanguageAccess lang : langs) {
			IEncodingProvider provider = lang.getEncodingProvider();
			if (provider instanceof IEncodingProvider.Runtime) {
				((IEncodingProvider.Runtime) provider).setDefaultEncoding(encoding);
			} else {
				forceDebugLog("Couldn't set encoding '" + encoding + "' for provider '" + provider
						+ "'. Only subclasses of IEncodingProvider.Runtime are supported.");
			}
		}
	}

	protected void installIndex(XtextResourceSet resourceSet, ResourceDescriptionsData index) {
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index);
	}

	protected String compileStubs(File stubsDir) {
		File stubsClasses = createTempDir("classes");
		compiler.setClassPath(classPathEntries);
		LOG.info("Compiling stubs located in " + stubsDir.getAbsolutePath());
		Set<String> sourcesToCompile = uniqueEntries(
				Iterables.concat(javaSourceDirs, sourceDirs, Lists.newArrayList(stubsDir.getAbsolutePath())));
		forceDebugLog("Compiler source roots: " + Joiner.on(",").join(sourcesToCompile));
		IJavaCompiler.CompilationResult result = compiler.compile(sourcesToCompile, stubsClasses);
		if (result != null) {
			switch (result) {
			case SKIPPED:
				LOG.info("Nothing to compile. Stubs compilation was skipped.");
				break;
			case FAILED:
				forceDebugLog("Stubs compilation finished with errors.");
				break;
			case SUCCEEDED:
				forceDebugLog("Stubs compilation successfully finished.");
				break;
			default:
				break;
			}
		}
		return stubsClasses.getAbsolutePath();
	}

	protected Set<String> uniqueEntries(Iterable<String> pathes) {
		return IterableExtensions.toSet(Iterables.transform(pathes, (String it) -> new File(it).getAbsolutePath()));
	}

	protected File generateStubs(ResourceDescriptionsData data, List<URI> sourceResourceURIs) {
		File stubsDir = createTempDir("stubs");
		LOG.info("Generating stubs into " + stubsDir.getAbsolutePath());
		if (encoding != null) {
			encodingProvider.setDefaultEncoding(encoding);
		}
		commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, stubsDir.getAbsolutePath());
		Iterable<URI> generateStubs = Iterables.filter(sourceResourceURIs,
				(URI it) -> languageAccess(it).isLinksAgainstJava());
		for (URI it : generateStubs) {
			languageAccess(it).getStubGenerator().doGenerateStubs(commonFileAccess, data.getResourceDescription(it));
		}
		return stubsDir;
	}

	protected boolean validate(Resource resource) {
		LOG.info("Starting validation for input: '" + resource.getURI().lastSegment() + "'");
		IResourceValidator resourceValidator = languageAccess(resource.getURI()).getResourceValidator();
		List<Issue> validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
		return issueHandler.handleIssue(validationResult);
	}

	protected void generate(List<Resource> sourceResources) {
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		for (Resource it : sourceResources) {
			LOG.info("Starting generator for input: '" + it.getURI().lastSegment() + "'");
			registerCurrentSource(it.getURI());
			LanguageAccess access = languageAccess(it.getURI());
			JavaIoFileSystemAccess fileSystemAccess = getFileSystemAccess(access);
			if (isWriteStorageResources()) {
				if (it instanceof StorageAwareResource) {
					IResourceStorageFacade resourceStorageFacade = ((StorageAwareResource) it)
							.getResourceStorageFacade();
					if (resourceStorageFacade != null) {
						resourceStorageFacade.saveResource((StorageAwareResource) it, fileSystemAccess);
					}
				}
			}
			access.getGenerator().generate(it, fileSystemAccess, context);
		}
	}

	protected void registerCurrentSource(URI uri) {
		JavaIoFileSystemAccess fsa = getFileSystemAccess(languageAccess(uri));
		Iterable<URI> folders = Iterables.transform(sourceDirs, (String it) -> UriUtil.createFolderURI(new File(it)));
		URI absoluteSource = IterableExtensions.findFirst(folders, (URI it) -> UriUtil.isPrefixOf(it, uri));
		if (absoluteSource == null) {
			throw new IllegalStateException(
					"Resource " + uri + " is not contained in any of the known source folders " + sourceDirs + ".");
		}
		URI projectBaseURI = UriUtil.createFolderURI(new File(baseDir));
		for (OutputConfiguration output : fsa.getOutputConfigurations().values()) {
			for (String sourceFolder : output.getSourceFolders()) {
				URI sourceFolderURI = URI.createURI((sourceFolder + "/"));
				if (sourceFolderURI.isRelative()) {
					sourceFolderURI = sourceFolderURI.resolve(projectBaseURI);
				}
				if (Objects.equal(absoluteSource, sourceFolderURI)) {
					fsa.setCurrentSource(sourceFolder);
				}
			}
		}
	}

	private Map<LanguageAccess, JavaIoFileSystemAccess> configuredFsas = new HashMap<>();

	private JavaIoFileSystemAccess getFileSystemAccess(LanguageAccess language) {
		JavaIoFileSystemAccess fsa = configuredFsas.get(language);
		if (fsa == null) {
			fsa = language.createFileSystemAccess(new File(baseDir));
			fsa = this.configureFileSystemAccess(fsa, language);
			configuredFsas.put(language, fsa);
		}
		return fsa;
	}

	protected JavaIoFileSystemAccess configureFileSystemAccess(JavaIoFileSystemAccess fsa, LanguageAccess language) {
		return fsa;
	}

	private LanguageAccess languageAccess(URI uri) {
		return languages.get(uri.fileExtension());
	}

	protected File createTempDir(String subDir) {
		try {
			File file = new File(this.tempDir, subDir);
			if (!file.mkdirs() && !file.exists()) {
				throw new IOException("Failed to create directory '" + file.getAbsolutePath() + "'");
			}
			return file;
		} catch (Throwable e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected void installTypeProvider(Iterable<String> classPathRoots, XtextResourceSet resSet,
			IndexedJvmTypeAccess typeAccess) {
		URLClassLoader classLoader = createURLClassLoader(classPathRoots);
		new ClasspathTypeProvider(classLoader, resSet, typeAccess, null);
		resSet.setClasspathURIContext(classLoader);
	}

	private URLClassLoader createURLClassLoader(Iterable<String> classPathEntries) {
		URL[] classPathUrls = FluentIterable.from(classPathEntries).transform((String str) -> {
			try {
				return new File(str).toURI().toURL();
			} catch (Throwable e) {
				throw Exceptions.sneakyThrow(e);
			}
		}).toArray(URL.class);
		return new URLClassLoader(classPathUrls);
	}

	protected List<URI> collectResources(Iterable<String> roots, ResourceSet resourceSet) {
		String extensions = Joiner.on("|").join(languages.keySet());
		NameBasedFilter nameBasedFilter = new NameBasedFilter();
		// TODO test with whitespaced file extensions
		nameBasedFilter.setRegularExpression(".*\\.(?:(" + extensions + "))$");
		List<URI> resources = new ArrayList<>();
		Multimap<String, URI> modelsFound = new PathTraverser().resolvePathes(IterableExtensions.toList(roots),
				(URI input) -> {
					boolean matches = nameBasedFilter.matches(input);
					if (matches) {
						forceDebugLog("Adding file \'" + input + "\'");
						resources.add(input);
					}
					return matches;
				});
		modelsFound.asMap().forEach((String uri, Collection<URI> resource) -> {
			File file = new File(uri);
			if (resource != null && !file.isDirectory() && file.getName().endsWith(".jar")) {
				registerBundle(file);
			}
		});
		return resources;
	}

	protected void registerBundle(File file) {
		// copied from
		// org.eclipse.emf.mwe.utils.StandaloneSetup.registerBundle(File)
		JarFile jarFile = null;
		try {
			jarFile = new JarFile(file);
			Manifest manifest = jarFile.getManifest();
			if (manifest == null) {
				return;
			}
			String name = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
			if (name != null) {
				int indexOf = name.indexOf(";");
				if (indexOf > 0) {
					name = name.substring(0, indexOf);
				}
				if (EcorePlugin.getPlatformResourceMap().containsKey(name)) {
					return;
				}
				String path = "archive:" + file.toURI() + "!/";
				URI uri = URI.createURI(path);
				EcorePlugin.getPlatformResourceMap().put(name, uri);
			}
		} catch (ZipException e) {
			forceDebugLog("Could not open Jar file " + file.getAbsolutePath() + ".");
		} catch (Exception e) {
			LOG.error(file.getAbsolutePath(), e);
		} finally {
			try {
				if (jarFile != null) {
					jarFile.close();
				}
			} catch (IOException e) {
				LOG.error(jarFile, e);
			}
		}
	}

	public IJavaCompiler getCompiler() {
		return this.compiler;
	}

	/**
	 * Clears the content of the resource set without sending notifications.
	 * This avoids unnecessary, explicit unloads.
	 */
	public void clearResourceSet(ResourceSet resourceSet) {
		boolean wasDeliver = resourceSet.eDeliver();
		try {
			resourceSet.eSetDeliver(false);
			resourceSet.getResources().clear();
		} finally {
			resourceSet.eSetDeliver(wasDeliver);
		}
	}

	protected void forceDebugLog(String logMessage) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(logMessage);
		} else {
			if (debugLog) {
				LOG.info(logMessage);
			}
		}
	}

	public Map<String, LanguageAccess> getLanguages() {
		return languages;
	}

	public void setLanguages(Map<String, LanguageAccess> languages) {
		this.languages = languages;
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public Iterable<String> getSourceDirs() {
		return sourceDirs;
	}

	public void setSourceDirs(Iterable<String> sourceDirs) {
		this.sourceDirs = sourceDirs;
	}

	public Iterable<String> getJavaSourceDirs() {
		return javaSourceDirs;
	}

	public void setJavaSourceDirs(Iterable<String> javaSourceDirs) {
		this.javaSourceDirs = javaSourceDirs;
	}

	public Iterable<String> getClassPathEntries() {
		return classPathEntries;
	}

	public void setClassPathEntries(Iterable<String> classPathEntries) {
		this.classPathEntries = classPathEntries;
	}

	public File getTempDir() {
		return tempDir;
	}

	public void setTempDir(File tempDir) {
		this.tempDir = tempDir;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getClassPathLookUpFilter() {
		return classPathLookUpFilter;
	}

	public void setClassPathLookUpFilter(String classPathLookUpFilter) {
		this.classPathLookUpFilter = classPathLookUpFilter;
	}

	public boolean isFailOnValidationError() {
		return failOnValidationError;
	}

	public void setFailOnValidationError(boolean failOnValidationError) {
		this.failOnValidationError = failOnValidationError;
	}

	public boolean isDebugLog() {
		return debugLog;
	}

	public void setDebugLog(boolean debugLog) {
		this.debugLog = debugLog;
	}

	public boolean isWriteStorageResources() {
		return writeStorageResources;
	}

	public void setWriteStorageResources(boolean writeStorageResources) {
		this.writeStorageResources = writeStorageResources;
	}

	public ClusteringConfig getClusteringConfig() {
		return clusteringConfig;
	}

	public void setClusteringConfig(ClusteringConfig clusteringConfig) {
		this.clusteringConfig = clusteringConfig;
	}
}

/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import java.util.zip.ZipException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.build.ResolvedResourceDescription;
import org.eclipse.xtext.builder.standalone.compiler.CompilerConfiguration;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.builder.standalone.incremental.BinaryFileHashing;
import org.eclipse.xtext.builder.standalone.incremental.ClasspathInfos;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.mwe.NameBasedFilter;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProviderExtension;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy;
import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.resource.persistence.SourceLevelURIsAdapter;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.Runnables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/*
 * TODO Serialize
 * - input to output mapping
 * - hashes of input files and output files accordingly (collect output configurations up-front and scan for all files)
 * - extract file scanning logic from compiler and move to standalone.incremental
 * - consider stub directory as output directory, too
 * - store validation results and output these, too
 */
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

	@Inject
	private ClasspathInfos classpathInfos;

	@Inject
	private CompilerPhases compilerPhases;

	private StandaloneBuilderState builderState;

	private final Map<LanguageAccess, JavaIoFileSystemAccess> configuredFsas = new HashMap<>();

	private boolean incremental = false;

	public StandaloneBuilder() {
		try {
			tempDir = Files.createTempDirectory("StandaloneBuilder").toFile();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void setIncrementalBuild(boolean enable) {
		incremental = enable;
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
		Stopwatch rootStopwatch = Stopwatch.createStarted();
		File stubsDirectory = stubsDirectory();
		ensureBaseDir();
		handleEncoding();
		LOG.info("Collecting source models.");
		Iterable<String> rootsToTravers = rootsToTraverse();
		List<URI> sourceResourceURIs = collectResources(sourceDirs);
		File stateFile;
		try {
			stateFile = readOrCreateBuilderState(stubsDirectory);

			Set<URI> changedSourceFiles = new HashSet<>();
			Map<URI, IResourceDescription.Delta> allDeltas = new LinkedHashMap<>();
			aggregateDeltas(builderState.sourceChanges(sourceResourceURIs, changedSourceFiles), allDeltas);

			Set<URI> changedLibraryFiles = new HashSet<>();
			List<URI> libraryResourceURIs = Collections.emptyList();
			if (builderState.updateLibraryHash(hashClasspath(rootsToTravers))) {
				libraryResourceURIs = collectResources(rootsToTravers);
				aggregateDeltas(builderState.libraryChanges(libraryResourceURIs, changedLibraryFiles), allDeltas);
			} else {
				libraryResourceURIs = new ArrayList<>(builderState.libraryFiles.keySet());
			}

			forceDebugLog("Collected source models. Took: " + rootStopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms.");
			
			XtextResourceSet resourceSet = resourceSetProvider.get();
			Iterable<String> allClassPathEntries = Iterables.concat(sourceDirs, classPathEntries);
			if (stubsDirectory != null) {
				LOG.info("Installing type provider.");
				installTypeProvider(allClassPathEntries, resourceSet, null);
			}
			IResourceClusteringPolicy strategy = getClusteringPolicy();
			aggregateDeltas(indexResources(resourceSet, changedSourceFiles, changedLibraryFiles, strategy), allDeltas);
			// Generate Stubs
			String stubsClasses = generateStubs(stubsDirectory, changedSourceFiles, allDeltas);
			if (stubsClasses != null) {
				LOG.info("Installing type provider for stubs.");
				installTypeProvider(FluentIterable.from(allClassPathEntries).append(stubsClasses), resourceSet, jvmTypeAccess);
			}
			// Validate and generate
			ResourceDescriptionsData index = builderState.index;
			boolean hasValidationErrors = false;
			while (!changedSourceFiles.isEmpty() || !allDeltas.isEmpty()) {
				LOG.info("Validate and generate.");
				installSourceLevelURIs(resourceSet, changedSourceFiles);
				Iterator<URI> sourceResourceIterator = changedSourceFiles.iterator();
				while (sourceResourceIterator.hasNext()) {
					List<Resource> resources = new ArrayList<>();
					int clusterIndex = 0;
					boolean canContinue = true;
					while (sourceResourceIterator.hasNext() && canContinue) {
						URI uri = sourceResourceIterator.next();
						Resource resource = resourceSet.getResource(uri, true);
						resources.add(resource);
						resource.getContents(); // fully initialize
						EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
						IResourceDescription.Manager manager = resourceDescriptionManager(resource);

						IResourceDescription oldDescription = index.getResourceDescription(uri);
						IResourceDescription newDescription = SerializableResourceDescription
								.createCopy(manager.getResourceDescription(resource));
						index.addDescription(uri, newDescription);
						aggregateDelta(manager.createDelta(oldDescription, newDescription), allDeltas);

						// TODO adjust to handle validations that need an up-to-date index
						hasValidationErrors = validate(resource) || hasValidationErrors;
						clusterIndex++;
						if (!strategy.continueProcessing(resourceSet, null, clusterIndex)) {
							canContinue = false;
						}
					}
					if (failOnValidationError && hasValidationErrors) {
						if (incremental) {
							// since we didn't generate anything yet, we don't want to persist the builder state
							builderState.processIssues(issueHandler);
						}
						return false;
					}
					generate(resources);
					if (!canContinue) {
						clearResourceSet(resourceSet);
					}
				}
				if (!allDeltas.isEmpty()) {
					sourceResourceURIs.removeAll(changedSourceFiles);
					changedSourceFiles.clear();
					for (URI candidate : sourceResourceURIs) {
						IResourceDescription description = index.getResourceDescription(candidate);
						if (resourceDescriptionManager(candidate).isAffected(allDeltas.values(), description,
								index)) {
							changedSourceFiles.add(candidate);
						}
					}
					allDeltas.clear();
				} else {
					changedSourceFiles.clear();
				}
			}
			return commitBuilderState(stateFile, hasValidationErrors);
		} finally {
			builderState = null;
			configuredFsas.clear();

			LOG.info("Build took " + rootStopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms.");
		}
	}

	private String generateStubs(File stubsDirectory, Set<URI> changedSourceFiles,
			Map<URI, IResourceDescription.Delta> allDeltas) {
		if (stubsDirectory == null) {
			return null;
		}
		generateStubs(changedSourceFiles, stubsDirectory);
		CompilerConfiguration configuration = compiler.getConfiguration();
		if (incremental) {
			configuration.enableIncrementalCompilation(createTempDir("state"), event -> {
				aggregateDeltas(event, allDeltas);
			});
		}
		String stubsClasses = compileStubs(stubsDirectory);
		if (incremental) {
			configuration.disableIncrementalCompilation();
		}
		return stubsClasses;
	}

	private File readOrCreateBuilderState(File stubsDirectory) {
		File stateFile;
		if (incremental) {
			stateFile = new File(createTempDir("state"), "xtext.state");
			builderState = StandaloneBuilderState.from(stateFile);
			// Process the existing output folders and invalidate all cached
			// data for source files
			// that do not have their matching output anymore
			builderState.processOutputDirectories(outputDirectories());
			if (stubsDirectory != null) {
				builderState.processStubDirectory(stubsDirectory.getAbsolutePath());
			}
		} else {
			stateFile = null;
			builderState = new StandaloneBuilderState();
		}
		return stateFile;
	}

	private Iterable<String> rootsToTraverse() {
		Iterable<String> rootsToTravers = classPathEntries;
		if (classPathLookUpFilter != null) {
			LOG.info("Class path look up filter is active.");
			Pattern cpLookUpFilter = Pattern.compile(classPathLookUpFilter);
			rootsToTravers = Lists
					.newArrayList(Iterables.filter(classPathEntries, root -> cpLookUpFilter.matcher(root).matches()));
			LOG.info("Investigating " + Iterables.size(rootsToTravers) + " of " + Iterables.size(classPathEntries)
					+ " class path entries.");
		}
		return rootsToTravers;
	}

	private void handleEncoding() {
		if (encoding != null) {
			forceDebugLog("Setting encoding.");
			fileEncodingSetup(languages.values(), encoding);
		}
	}

	private void ensureBaseDir() {
		if (baseDir == null) {
			baseDir = System.getProperty("user.dir");
			LOG.warn("Property baseDir not set. Using '" + baseDir + "'");
		}
	}

	private File stubsDirectory() {
		boolean needsJava = IterableExtensions.exists(languages.values(), LanguageAccess::isLinksAgainstJava);
		File stubsDirectory;
		if (needsJava) {
			forceDebugLog("Using common types.");
			stubsDirectory = createTempDir("stubs");
		} else {
			stubsDirectory = null;
		}
		return stubsDirectory;
	}

	private void installSourceLevelURIs(ResourceSet resourceSet, Collection<URI> changes) {
		Set<URI> effectiveSourceLevelUris = new HashSet<>();
		for (URI uri : changes) {
			if (isSource(uri)) {
				effectiveSourceLevelUris.add(uri);
				Resource resource = resourceSet.getResource(uri, false);
				if (resource != null && isLoadedFromStorage(resource)) {
					resourceSet.getResources().remove(resource);
					// proxify
					resource.unload();
				}
			}
		}
		SourceLevelURIsAdapter.setSourceLevelUris(resourceSet, effectiveSourceLevelUris);
	}

	private boolean isLoadedFromStorage(Resource resource) {
		return resource instanceof StorageAwareResource && ((StorageAwareResource) resource).isLoadedFromStorage();
	}

	private boolean isSource(URI uri) {
		IResourceServiceProvider provider = languageAccess(uri).getResourceServiceProvider();
		return provider instanceof IResourceServiceProviderExtension
				&& ((IResourceServiceProviderExtension) provider).isSource(uri);
	}

	private Set<String> outputDirectories() {
		Set<String> outputFolders = new HashSet<>();
		for (LanguageAccess language : languages.values()) {
			Map<String, OutputConfiguration> outputConfigs = getFileSystemAccess(language).getOutputConfigurations();
			for (OutputConfiguration outputConfig : outputConfigs.values()) {
				outputFolders.addAll(outputConfig.getOutputDirectories());
			}
		}
		return outputFolders;
	}

	private void aggregateDeltas(Event event, Map<URI, Delta> allDeltas) {
		for (Delta delta : event.getDeltas()) {
			aggregateDelta(delta, allDeltas);
		}
	}

	private void aggregateDelta(Delta delta, Map<URI, Delta> allDeltas) {
		URI uri = delta.getUri();
		allDeltas.merge(uri, delta, (prev, current) -> {
			return resourceDescriptionManager(uri).createDelta(prev.getOld(), current.getNew());
		});
	}

	private HashCode hashClasspath(Iterable<String> filteredClasspath) {
		NameBasedFilter nameFilter = dslFileNamePattern();
		List<ForkJoinTask<byte[]>> hashCodes = new ArrayList<>();
		for (String classpathEntry : filteredClasspath) {
			IPath path = new Path(classpathEntry);
			if ("jar".equalsIgnoreCase(path.getFileExtension())) {
				hashCodes.add(ForkJoinPool.commonPool().submit(() -> classpathInfos.hashClassesOrJar(path)));
			} else {
				hashCodes.add(ForkJoinPool.commonPool().submit(() -> hashDslFiles(path, nameFilter)));
			}
		}
		Hasher hasher = BinaryFileHashing.hashFunction().newHasher();
		for (ForkJoinTask<byte[]> hashCode : hashCodes) {
			try {
				hasher.putBytes(hashCode.get(30, TimeUnit.SECONDS));
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				hasher.putBoolean(false);
			}
		}
		return hasher.hash();
	}

	private byte[] hashDslFiles(IPath path, NameBasedFilter nameFilter) {
		Hasher hasher = BinaryFileHashing.hashFunction().newHasher();
		try (OutputStream hasherAsStream = Funnels.asOutputStream(hasher)) {
			com.google.common.io.Files.fileTraverser().breadthFirst(path.toFile()).forEach(file -> {
				if (file.isFile()) {
					if (nameFilter.matches(URI.createFileURI(file.getAbsolutePath()))) {
						try (InputStream in = new BufferedInputStream(new FileInputStream(file), 16384)) {
							ByteStreams.copy(in, hasherAsStream);
						} catch (IOException e) {
							hasher.putBoolean(false);
						}
					}
				}
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return hasher.hash().asBytes();
	}

	private boolean commitBuilderState(File stateFile, boolean hasValidationErrors) {
		if (incremental) {
			builderState.to(stateFile);
			return builderState.processIssues(issueHandler) && !hasValidationErrors;
		}
		return !hasValidationErrors;
	}

	protected IResourceDescription.Event indexResources(XtextResourceSet resourceSet,
			Collection<URI> sourceResourceURIs, Collection<URI> libraryResourceURIs,
			IResourceClusteringPolicy strategy) {
		// TODO consider loading resources in parallel
		compilerPhases.setIndexing(resourceSet, true);
		try {
			Iterator<URI> allResourceIterator = Iterables.concat(sourceResourceURIs, libraryResourceURIs).iterator();
			List<IResourceDescription.Delta> deltas = new ArrayList<>();
			ResourceDescriptionsData index = builderState.index;
			while (allResourceIterator.hasNext()) {
				int clusterIndex = 0;
				boolean canContinue = true;
				while (allResourceIterator.hasNext() && canContinue) {
					URI uri = allResourceIterator.next();
					Resource resource = resourceSet.getResource(uri, true);
					IResourceDescription oldDescription = index.getResourceDescription(uri);
					Manager resourceDescriptionManager = resourceDescriptionManager(resource);
					IResourceDescription description = resourceDescriptionManager.getResourceDescription(resource);
					IResourceDescription newDescription = new ResolvedResourceDescription(description);
					index.addDescription(uri, newDescription);
					deltas.add(resourceDescriptionManager.createDelta(oldDescription, newDescription));
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
			return new ResourceDescriptionChangeEvent(deltas);
		} finally {
			compilerPhases.setIndexing(resourceSet, false);
		}
	}

	protected IResourceClusteringPolicy getClusteringPolicy() {
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
		return strategy;
	}
	
	private IResourceDescription.Manager resourceDescriptionManager(Resource resource) {
		if (resource instanceof XtextResource) {
			return ((XtextResource) resource).getResourceServiceProvider().getResourceDescriptionManager();
		}
		return resourceDescriptionManager(resource.getURI());
	}

	private IResourceDescription.Manager resourceDescriptionManager(URI uri) {
		return languageAccess(uri).getResourceDescriptionManager();
	}

	public void fileEncodingSetup(Collection<LanguageAccess> languages, String encoding) {
		for (LanguageAccess language : languages) {
			IEncodingProvider provider = language.getEncodingProvider();
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
		File stubsClasses = createTempDir("stub-classes");
		compiler.setClassPath(classPathEntries);
		LOG.info("Compiling stubs located in " + stubsDir.getAbsolutePath());
		// TODO Don't compile regular output directories in this step
		Set<String> sourcesToCompile = uniqueEntries(
				Iterables.concat(javaSourceDirs, sourceDirs, Lists.newArrayList(stubsDir.getAbsolutePath())));
		for (String outputDir : outputDirectories()) {
			sourcesToCompile.remove(new File(outputDir).getAbsolutePath());
		}
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
		return FluentIterable.from(pathes).transform(path -> new File(path).getAbsolutePath()).copyInto(new LinkedHashSet<>());
	}

	protected void generateStubs(Set<URI> sourceResourceURIs, File stubsDir) {
		LOG.info("Generating stubs into " + stubsDir.getAbsolutePath() + " for " + sourceResourceURIs.size() + " resources");
		if (encoding != null) {
			encodingProvider.setDefaultEncoding(encoding);
		}
		commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, stubsDir.getAbsolutePath());
		Iterable<URI> resourceURIs = Iterables.filter(sourceResourceURIs,
				uri -> languageAccess(uri).isLinksAgainstJava());
		JavaIoFileSystemAccess casted = (JavaIoFileSystemAccess) commonFileAccess;
		for (URI resourceURI : resourceURIs) {
			Runnable r;
			if (incremental) {
				r = withCallback(casted, new StandaloneBuilderFileCallback(resourceURI, builderState.stubFiles,
						builderState.inputToStubFiles, builderState.stubToInputFile));
			} else {
				r = Runnables.doNothing();
			}
			languageAccess(resourceURI).getStubGenerator().doGenerateStubs(commonFileAccess,
					builderState.index.getResourceDescription(resourceURI));
			r.run();
		}
	}

	private Runnable withCallback(JavaIoFileSystemAccess casted, StandaloneBuilderFileCallback callback) {
		Runnable r;
		Runnable reset = casted.withCallBack(callback);
		r = () -> {
			reset.run();
			callback.done();
		};
		return r;
	}

	/**
	 * Returns true if there was an error.
	 */
	protected boolean validate(Resource resource) {
		LOG.info("Validating: '" + resource.getURI().lastSegment() + "'");
		IIssueHandler issueHandler;
		if (incremental) {
			issueHandler = (issues) -> {
				builderState.setIssues(resource.getURI(), issues);
				for (Issue issue : issues) {
					if (issue.getSeverity() == Severity.ERROR) {
						return false;
					}
				}
				return true;
			};
		} else {
			issueHandler = this.issueHandler;
		}
		IResourceValidator resourceValidator = languageAccess(resource.getURI()).getResourceValidator();
		List<Issue> validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
		return !issueHandler.handleIssue(validationResult);
	}

	protected void generate(List<Resource> sourceResources) {
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		for (Resource resource : sourceResources) {
			URI uri = resource.getURI();
			LOG.info("Starting generator for input: '" + uri.lastSegment() + "'");
			registerCurrentSource(uri);
			LanguageAccess access = languageAccess(uri);
			JavaIoFileSystemAccess fileSystemAccess = getFileSystemAccess(access);
			Runnable r;
			if (incremental) {
				r = withCallback(fileSystemAccess, new StandaloneBuilderFileCallback(uri, builderState.outputFiles,
						builderState.inputToOutputFiles, builderState.outputToInputFile));
			} else {
				r = Runnables.doNothing();
			}
			if (isWriteStorageResources() && resource instanceof StorageAwareResource) {
				StorageAwareResource casted = (StorageAwareResource) resource;
				IResourceStorageFacade resourceStorageFacade = casted.getResourceStorageFacade();
				if (resourceStorageFacade != null) {
					resourceStorageFacade.saveResource(casted, fileSystemAccess);
				}
			}
			access.getGenerator().generate(resource, fileSystemAccess, context);
			r.run();
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
				if (absoluteSource.equals(sourceFolderURI)) {
					fsa.setCurrentSource(sourceFolder);
				}
			}
		}
	}

	private JavaIoFileSystemAccess getFileSystemAccess(LanguageAccess language) {
		return configuredFsas.computeIfAbsent(language, l->{
			return configureFileSystemAccess(l.createFileSystemAccess(new File(baseDir)), l);
		});
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

	protected List<URI> collectResources(Iterable<String> roots) {
		NameBasedFilter nameBasedFilter = dslFileNamePattern();
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
		modelsFound.asMap().forEach((uri, resource) -> {
			File file = new File(uri);
			if (resource != null && !file.isDirectory() && file.getName().endsWith(".jar")) {
				registerBundle(file);
			}
		});
		return resources;
	}

	private NameBasedFilter dslFileNamePattern() {
		String extensions = Joiner.on("|").join(languages.keySet());
		NameBasedFilter nameBasedFilter = new NameBasedFilter();
		// TODO test with file extension that contain spaces
		nameBasedFilter.setRegularExpression(".*\\.(?:(" + extensions + "))$");
		return nameBasedFilter;
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

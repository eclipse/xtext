package org.eclipse.xtend.core.compiler.batch;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.compiler.batch.BatchCompiler;
import org.eclipse.xtext.util.internal.AlternateJdkLoader;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.descriptions.IStubGenerator;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationAdapter;
import org.eclipse.xtext.mwe.NameBasedFilter;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.FileWorkspaceConfig;
import org.eclipse.xtext.workspace.WorkspaceConfigAdapter;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.GeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JavaVersion;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.8
 */
public class XtendBatchCompiler {

	private final static class SeverityFilter implements Predicate<Issue> {
		private static final SeverityFilter WARNING = new SeverityFilter(Severity.WARNING);
		private static final SeverityFilter ERROR = new SeverityFilter(Severity.ERROR);
		private Severity severity;

		private SeverityFilter(Severity severity) {
			this.severity = severity;
		}

		@Override
		public boolean apply(Issue issue) {
			return this.severity == issue.getSeverity();
		}
	}

	private static Logger log = Logger.getLogger(XtendBatchCompiler.class.getName());

	protected static final FileFilter ACCEPT_ALL_FILTER = new FileFilter() {
		@Override
		public boolean accept(File pathname) {
			return true;
		}
	};

	protected Provider<ResourceSet> resourceSetProvider;
	@Inject
	protected Provider<JavaIoFileSystemAccess> javaIoFileSystemAccessProvider;
	@Inject
	protected FileExtensionProvider fileExtensionProvider;
	@Inject
	protected Provider<ResourceSetBasedResourceDescriptions> resourceSetDescriptionsProvider;
	@Inject
	private GeneratorDelegate generator;
	@Inject
	private IndexedJvmTypeAccess indexedJvmTypeAccess;
	@Inject
	private IEncodingProvider.Runtime encodingProvider;
	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;
	@Inject
	private CompilerPhases compilerPhases;
	@Inject
	private IStubGenerator stubGenerator;
	@Inject 
	private IOutputConfigurationProvider outputConfigurationProvider;
	@Inject
	private GeneratorConfigProvider generatorConfigProvider;
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	protected String sourcePath;
	protected String classPath;
	/**
	 * @since 2.7
	 */
	protected String bootClassPath;
	protected boolean useCurrentClassLoaderAsParent;
	protected String outputPath;
	protected String fileEncoding;
	protected boolean verbose = false;
	protected String tempDirectory = System.getProperty("java.io.tmpdir");
	protected boolean deleteTempDirectory = true;
	protected List<File> tempFolders = Lists.newArrayList();
	protected boolean writeTraceFiles = true;
	/**
	 * @since 2.8
	 */
	protected boolean writeStorageFiles = false;
	private GeneratorConfig generatorConfig = new GeneratorConfig();
	protected ClassLoader currentClassLoader = getClass().getClassLoader();

	private URI baseURI;

	private ClassLoader jvmTypesClassLoader;

	private ClassLoader annotationProcessingClassLoader;

	private FileWorkspaceConfig workspaceConfig;

	private OutputConfiguration outputConfiguration;

	public void setCurrentClassLoader(ClassLoader currentClassLoader) {
		this.currentClassLoader = currentClassLoader;
	}

	public void setUseCurrentClassLoaderAsParent(boolean useCurrentClassLoaderAsParent) {
		this.useCurrentClassLoaderAsParent = useCurrentClassLoaderAsParent;
	}

	public String getTempDirectory() {
		return tempDirectory;
	}

	public void setTempDirectory(String tempDirectory) {
		this.tempDirectory = tempDirectory;
	}

	public boolean isWriteTraceFiles() {
		return writeTraceFiles;
	}

	public void setWriteTraceFiles(boolean writeTraceFiles) {
		this.writeTraceFiles = writeTraceFiles;
	}
	
	/**
	 * @since 2.8
	 */
	public boolean isWriteStorageFiles() {
		return writeStorageFiles;
	}

	/**
	 * @since 2.8
	 */
	public void setWriteStorageFiles(boolean writeStorageFiles) {
		this.writeStorageFiles = writeStorageFiles;
	}
	
	@Inject
	public void setResourceSetProvider(Provider<ResourceSet> resourceSetProvider) {
		this.resourceSetProvider = resourceSetProvider;
	}

	public boolean isDeleteTempDirectory() {
		return deleteTempDirectory;
	}

	public void setDeleteTempDirectory(boolean deletetempDirectory) {
		this.deleteTempDirectory = deletetempDirectory;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	/**
	 * @since 2.7
	 */
	public void setBootClassPath(String bootClassPath) {
		this.bootClassPath = bootClassPath;
	}
	
	/**
	 * @since 2.8
	 */
	public void setBasePath(String basePath) {
		this.baseURI = UriUtil.createFolderURI(new File(basePath));
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}
	
	@Deprecated // use getJavaSourceVersion()
	protected String getComplianceLevel() {
		return getJavaSourceVersion();
	}

	/**
	 * @since 2.8
	 */
	public boolean isGenerateSyntheticSuppressWarnings() {
		return generatorConfig.isGenerateSyntheticSuppressWarnings();
	}

	/**
	 * @since 2.8
	 */
	public void setGenerateSyntheticSuppressWarnings(final boolean generateSyntheticSuppressWarnings) {
		generatorConfig.setGenerateSyntheticSuppressWarnings(generateSyntheticSuppressWarnings);
	}

	/**
	 * @since 2.8
	 */
	public boolean isGenerateGeneratedAnnotation() {
		return generatorConfig.isGenerateGeneratedAnnotation();
	}

	/**
	 * @since 2.8
	 */
	public void setGenerateGeneratedAnnotation(final boolean generateGeneratedAnnotation) {
		generatorConfig.setGenerateGeneratedAnnotation(generateGeneratedAnnotation);
	}

	/**
	 * @since 2.8
	 */
	public boolean isIncludeDateInGeneratedAnnotation() {
		return generatorConfig.isIncludeDateInGeneratedAnnotation();
	}

	/**
	 * @since 2.8
	 */
	public void setIncludeDateInGeneratedAnnotation(final boolean includeDateInGeneratedAnnotation) {
		generatorConfig.setIncludeDateInGeneratedAnnotation(includeDateInGeneratedAnnotation);
	}

	/**
	 * @since 2.8
	 */
	public String getGeneratedAnnotationComment() {
		return generatorConfig.getGeneratedAnnotationComment();
	}

	/**
	 * @since 2.8
	 */
	public void setGeneratedAnnotationComment(final String generatedAnnotationComment) {
		generatorConfig.setGeneratedAnnotationComment(generatedAnnotationComment);
	}

	/**
	 * @since 2.8
	 */
	public String getJavaSourceVersion() {
		return generatorConfig.getJavaSourceVersion().getQualifier();
	}

	/**
	 * @since 2.8
	 */
	public void setJavaSourceVersion(final String javaSourceVersion) {
		generatorConfig.setJavaSourceVersion(JavaVersion.fromQualifier(javaSourceVersion));
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	protected boolean isVerbose() {
		return verbose;
	}

	public String getFileEncoding() {
		return fileEncoding;
	}

	public void setFileEncoding(String encoding) {
		this.fileEncoding = encoding;
	}
	
	/**
	 * @noreference Only for testing
	 */
	public OutputConfiguration getOutputConfiguration() {
		return outputConfiguration;
	}
	
	/**
	 * @noreference Only for testing
	 */
	public FileWorkspaceConfig getWorkspaceConfig() {
		return workspaceConfig;
	}

	private boolean configureWorkspace(ResourceSet resourceSet) {
		List<File> sourceFileList = getSourcePathFileList();
		File outputFile = getOutputPathFile();
		if (sourceFileList == null || outputFile == null) {
			return false;
		}

		File commonRoot = determineCommonRoot(outputFile, sourceFileList);

		// We don't want to use root ("/") as a workspace folder, didn't we?
		if (commonRoot == null || commonRoot.getParent() == null || commonRoot.getParentFile().getParent() == null) {
			log.error("All source folders and the output folder should have "
					+ "a common parent non-top level folder (like project folder)");
			for (File sourceFile : sourceFileList) {
				log.error("(Source folder: '" + sourceFile + "')");
			}
			log.error("(Output folder: '" + outputFile + "')");
			return false;
		}
		workspaceConfig = new FileWorkspaceConfig(commonRoot.getParentFile());
		FileProjectConfig projectConfig = workspaceConfig.addProject(commonRoot.getName());

		java.net.URI commonURI = commonRoot.toURI();
		java.net.URI relativizedTarget = commonURI.relativize(outputFile.toURI());
		if (relativizedTarget.isAbsolute()) {
			log.error("Target folder '" + outputFile + "' must be a child of the project folder '" + commonRoot + "'");
			return false;
		}
		CharMatcher slash = CharMatcher.is('/');
		String relativeTargetFolder = slash.trimTrailingFrom(relativizedTarget.getPath());
		outputConfiguration = Iterables.getOnlyElement(outputConfigurationProvider.getOutputConfigurations());
		outputConfiguration.setOutputDirectory(relativeTargetFolder);
		for (File source : sourceFileList) {
			java.net.URI relativizedSrc = commonURI.relativize(source.toURI());
			if (relativizedSrc.isAbsolute()) {
				log.error("Source folder '" + source + "' must be a child of the project folder '" + commonRoot + "'");
				return false;
			}
			projectConfig.addSourceFolder(slash.trimTrailingFrom(relativizedSrc.getPath()));
		}
		Map<String, Set<OutputConfiguration>> outputConfigurations = newHashMap();
		outputConfigurations.put(languageName, newHashSet(outputConfiguration));
		resourceSet.eAdapters().add(new WorkspaceConfigAdapter(workspaceConfig));
		resourceSet.eAdapters().add(new OutputConfigurationAdapter(outputConfigurations));
		return true;
	}

	private File getOutputPathFile() {
		return new File(outputPath).getAbsoluteFile();
	}

	private List<File> getSourcePathFileList() {
		List<File> sourceFileList = new ArrayList<File>();
		for (String path : getSourcePathDirectories()) {
			sourceFileList.add(new File(path).getAbsoluteFile());
		}
		return sourceFileList;
	}

	private File determineCommonRoot(File outputFile, List<File> sourceFileList) {
		if (baseURI != null && baseURI.isFile()) {
			return new File(baseURI.toFileString());
		}
		List<File> pathList = new ArrayList<File>(sourceFileList);
		pathList.add(outputFile);

		List<List<File>> pathParts = new ArrayList<List<File>>();

		for (File path : pathList) {
			List<File> partsList = new ArrayList<File>();
			File subdir = path;
			while (subdir != null) {
				partsList.add(subdir);
				subdir = subdir.getParentFile();
			}
			pathParts.add(partsList);
		}
		int i = 1;
		File result = null;
		while (true) {
			File compareWith = null;
			for (List<File> parts : pathParts) {
				if (parts.size() < i) {
					return result;
				}
				File part = parts.get(parts.size() - i);
				if (compareWith == null) {
					compareWith = part;
				} else {
					if (!compareWith.equals(part)) {
						return result;
					}
				}
			}
			result = compareWith;
			i++;
		}
	}

	public boolean compile() {
		try {
			if (!checkConfiguration()) {
				return false;
			}
			ResourceSet resourceSet = resourceSetProvider.get();
			if (!configureWorkspace(resourceSet)) {
				return false;
			}
			generatorConfigProvider.install(resourceSet, generatorConfig);
			File classDirectory = createTempDir("classes");
			try {
				compilerPhases.setIndexing(resourceSet, true);
				// install a type provider without index lookup for the first phase
				installJvmTypeProvider(resourceSet, classDirectory, true);
				loadXtendFiles(resourceSet);
				File sourceDirectory = createStubs(resourceSet);
				if (!preCompileStubs(sourceDirectory, classDirectory)) {
					log.warn("Compilation of stubs had errors.");
				}
				if (!preCompileJava(sourceDirectory, classDirectory)) {
					log.debug("Compilation of Java code against stubs had errors. This is expected and usually is not a probblem.");
				}
			} finally {
				compilerPhases.setIndexing(resourceSet, false);
			}
			// install a fresh type provider for the second phase, so we clear all previously cached classes and misses.
			installJvmTypeProvider(resourceSet, classDirectory, false);
			EcoreUtil.resolveAll(resourceSet);
			List<Issue> issues = validate(resourceSet);
			Iterable<Issue> errors = Iterables.filter(issues, SeverityFilter.ERROR);
			Iterable<Issue> warnings = Iterables.filter(issues, SeverityFilter.WARNING);
			reportIssues(Iterables.concat(errors, warnings));
			if (!Iterables.isEmpty(errors)) {
				return false;
			}
			generateJavaFiles(resourceSet);
		} finally {
			destroyClassLoader(jvmTypesClassLoader);
			destroyClassLoader(annotationProcessingClassLoader);
			if (isDeleteTempDirectory()) {
				deleteTmpFolders();
			}
		}
		return true;
	}
	
	

	/**
	 * @since 2.8
	 */
	protected void destroyClassLoader(ClassLoader classLoader) {
		if (classLoader instanceof Closeable) {
			try {
				((Closeable) classLoader).close();
			} catch (Exception e) {
				log.warn("Unable to close a classloader", e);
			}
		}
	}

	/**
	 * @since 2.8
	 */
	protected boolean checkConfiguration() {
		File output = getOutputPathFile();
		for (String sourcePath : getSourcePathDirectories()) {
			File sourceDirectory = new File(sourcePath);
			try {
				if (isContainedIn(output.getCanonicalFile(), sourceDirectory.getCanonicalFile())) {
					log.error("The configured output path \""+getOutputPathFile()+"\" cannot be a child of the configured source directory \""+sourcePath+"\".");
					return false;
				}
			} catch (IOException e) {
				log.error("invalid configuration", e);
			}
		}
		return true;
	}
	
	private boolean isContainedIn(File child, File possibleParent) {
		File parent = child;
		while(parent != null) {
			if (parent.equals(possibleParent)) {
				return true;
			}
			parent = parent.getParentFile();
		}
		return false;
	}

	protected ResourceSet loadXtendFiles(final ResourceSet resourceSet) {
		encodingProvider.setDefaultEncoding(getFileEncoding());
		final NameBasedFilter nameBasedFilter = new NameBasedFilter();
		nameBasedFilter.setExtension(fileExtensionProvider.getPrimaryFileExtension());
		PathTraverser pathTraverser = new PathTraverser();
		List<String> sourcePathDirectories = getSourcePathDirectories();
		Multimap<String, URI> pathes = pathTraverser.resolvePathes(sourcePathDirectories, new Predicate<URI>() {
			@Override
			public boolean apply(URI input) {
				boolean matches = nameBasedFilter.matches(input);
				return matches;
			}
		});
		for (String src : pathes.keySet()) {
			for (URI uri : pathes.get(src)) {
				if (log.isDebugEnabled()) {
					log.debug("load xtend file '" + uri + "'");
				}
				resourceSet.getResource(uri, true);
			}
		}
		return resourceSet;
	}

	@Deprecated
	protected ResourceSet loadXtendFiles() {
		final ResourceSet resourceSet = resourceSetProvider.get();
		return loadXtendFiles(resourceSet);
	}

	protected File createStubs(ResourceSet resourceSet) {
		File outputDirectory = createTempDir("stubs");
		JavaIoFileSystemAccess fileSystemAccess = javaIoFileSystemAccessProvider.get();
		fileSystemAccess.setOutputPath(outputDirectory.toString());
		List<Resource> resources = Lists.newArrayList(resourceSet.getResources());
		for (Resource resource : resources) {
			IResourceDescription description = resourceDescriptionManager.getResourceDescription(resource);
			stubGenerator.doGenerateStubs(fileSystemAccess, description);
		}
		return outputDirectory;
	}

	protected boolean preCompileStubs(File tmpSourceDirectory, File classDirectory) {
		return preCompile(tmpSourceDirectory, singletonList(tmpSourceDirectory.toString()), getClassPathEntries());
	}	
	
	/**
	 * @since 2.8
	 */
	protected boolean preCompileJava(File tmpSourceDirectory, File classDirectory) {
		return preCompile(classDirectory, getSourcePathDirectories(), concat(singletonList(tmpSourceDirectory.toString()), getClassPathEntries()));
	}
	
	/**
	 * @since 2.8
	 */
	protected boolean preCompile(File classDirectory, Iterable<String> sourcePathDirectories, Iterable<String> classPathEntries) {
		List<String> commandLine = Lists.newArrayList();
		// todo args
		if (isVerbose()) {
			commandLine.add("-verbose");
		}
		if (!isEmpty(bootClassPath)) {
			commandLine.add("-bootclasspath \"" + concat(File.pathSeparator, getBootClassPathEntries()) + "\"");
		}
		if (!isEmpty(classPath)) {
			commandLine.add("-cp \"" + Joiner.on(File.pathSeparator).join(classPathEntries) + "\"");
		}
		commandLine.add("-d \"" + classDirectory.toString() + "\"");
		commandLine.add("-" + getComplianceLevel());
		commandLine.add("-proceedOnError");
		if (encodingProvider.getDefaultEncoding() != null) {
			commandLine.add("-encoding \"" + encodingProvider.getDefaultEncoding() + "\"");
		}
		List<String> sourceDirectories = newArrayList(sourcePathDirectories);
		commandLine.add(concat(" ", transform(sourceDirectories, new Function<String, String>() {
			@Override
			public String apply(String path) {
				return "\"" + path + "\"";
			}
		})));
		if (log.isDebugEnabled()) {
			log.debug("invoke batch compiler with '" + concat(" ", commandLine) + "'");
		}
		PrintWriter outWriter = getStubCompilerOutputWriter();
		return BatchCompiler.compile(concat(" ", commandLine), outWriter, outWriter, null);
	}

	private PrintWriter getStubCompilerOutputWriter() {
		Writer debugWriter = new Writer() {
			@Override
			public void write(char[] data, int offset, int count) throws IOException {
				String message = String.copyValueOf(data, offset, count);
				log.debug(message);
			}

			@Override
			public void flush() throws IOException {
			}

			@Override
			public void close() throws IOException {
			}
		};
		return new PrintWriter(debugWriter);
	}

	protected List<Issue> validate(ResourceSet resourceSet) {
		List<Issue> issues = Lists.newArrayList();
		List<Resource> resources = Lists.newArrayList(resourceSet.getResources());
		for (Resource resource : resources) {
			IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE
					.getResourceServiceProvider(resource.getURI());
			if (resourceServiceProvider != null && isSourceFile(resource)) {
				IResourceValidator resourceValidator = resourceServiceProvider.getResourceValidator();
				List<Issue> result = resourceValidator.validate(resource, CheckMode.ALL, null);
				addAll(issues, result);
			}
		}
		return issues;
	}

	/**
	 * @since 2.8
	 */
	protected boolean isSourceFile(Resource resource) {
		if (resource instanceof BatchLinkableResource) {
			return !((BatchLinkableResource) resource).isLoadedFromStorage();
		}
		return false;
	}

	/**
	 * Installs the complete JvmTypeProvider including index access into the {@link ResourceSet}. The lookup classpath
	 * is enhanced with the given tmp directory.
	 * 
	 * @deprecated use the explicit variant {@link #installJvmTypeProvider(ResourceSet, File, boolean)} instead.
	 */
	@Deprecated
	protected void installJvmTypeProvider(ResourceSet resourceSet, File tmpClassDirectory) {
		internalInstallJvmTypeProvider(resourceSet, tmpClassDirectory, false);
	}

	/**
	 * Installs the JvmTypeProvider optionally including index access into the {@link ResourceSet}. The lookup classpath
	 * is enhanced with the given tmp directory.
	 */
	protected void installJvmTypeProvider(ResourceSet resourceSet, File tmpClassDirectory, boolean skipIndexLookup) {
		if (skipIndexLookup) {
			internalInstallJvmTypeProvider(resourceSet, tmpClassDirectory, skipIndexLookup);
		} else {
			// delegate to the deprecated signature in case it was overridden by clients
			installJvmTypeProvider(resourceSet, tmpClassDirectory);
		}
	}

	/**
	 * Performs the actual installation of the JvmTypeProvider.
	 */
	private void internalInstallJvmTypeProvider(ResourceSet resourceSet, File tmpClassDirectory, boolean skipIndexLookup) {
		Iterable<String> classPathEntries = concat(getClassPathEntries(), getSourcePathDirectories(),
				asList(tmpClassDirectory.toString()));
		classPathEntries = filter(classPathEntries, new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return !Strings.isEmpty(input.trim());
			}
		});
		
		Iterable<File> classpath = transform(classPathEntries, TO_FILE);
		if (log.isDebugEnabled()) {
			log.debug("classpath used for Xtend compilation : " + classpath);
		}
		ClassLoader parentClassLoader;
		if (useCurrentClassLoaderAsParent) {
			parentClassLoader = currentClassLoader;
		} else {
			if (isEmpty(bootClassPath)) {
				parentClassLoader = ClassLoader.getSystemClassLoader().getParent();
			} else {
				Iterable<File> bootClassPathEntries = transform(getBootClassPathEntries(), TO_FILE);
				parentClassLoader = new AlternateJdkLoader(bootClassPathEntries);
			}
		}
		jvmTypesClassLoader = createClassLoader(classpath, parentClassLoader);
		new ClasspathTypeProvider(jvmTypesClassLoader, resourceSet, skipIndexLookup ? null : indexedJvmTypeAccess, null);
		((XtextResourceSet) resourceSet).setClasspathURIContext(jvmTypesClassLoader);

		// for annotation processing we need to have the compiler's classpath as a parent.
		annotationProcessingClassLoader = createClassLoader(classpath, currentClassLoader);
		resourceSet.eAdapters().add(new ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter(annotationProcessingClassLoader));
	}
	
	private static final Function<String, File> TO_FILE = new Function<String, File>() {
		@Override
		public File apply(String from) {
			return new File(from);
		}
	};
	
	private static final Function<File, URL> TO_URL= new Function<File, URL>() {
		@SuppressWarnings("deprecation")
		@Override
		public URL apply(File from) {
			try {
				return from.toURL();
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
		}
	};

	/**
	 * @since 2.8
	 */
	protected ClassLoader createClassLoader(Iterable<File> jarsAndFolders, ClassLoader parentClassLoader) {
		return new URLClassLoader(toArray(transform(jarsAndFolders, TO_URL), URL.class), parentClassLoader);
	}

	protected void reportIssues(Iterable<Issue> issues) {
		for (Issue issue : issues) {
			StringBuilder issueBuilder = createIssueMessage(issue);
			if (Severity.ERROR == issue.getSeverity()) {
				log.error(issueBuilder.toString());
			} else if (Severity.WARNING == issue.getSeverity()) {
				log.warn(issueBuilder.toString());
			}
		}
	}

	private StringBuilder createIssueMessage(Issue issue) {
		StringBuilder issueBuilder = new StringBuilder("\n");
		issueBuilder.append(issue.getSeverity()).append(": \t");
		URI uriToProblem = issue.getUriToProblem();
		if (uriToProblem != null) {
			URI resourceUri = uriToProblem.trimFragment();
			issueBuilder.append(resourceUri.lastSegment()).append(" - ");
			if (resourceUri.isFile()) {
				issueBuilder.append(resourceUri.toFileString());
			}
		}
		issueBuilder.append("\n").append(issue.getLineNumber()).append(": ").append(issue.getMessage());
		return issueBuilder;
	}

	protected void generateJavaFiles(ResourceSet resourceSet) {
		JavaIoFileSystemAccess javaIoFileSystemAccess = javaIoFileSystemAccessProvider.get();
		javaIoFileSystemAccess.setOutputPath(outputPath);
		javaIoFileSystemAccess.setWriteTrace(writeTraceFiles);

		for (Resource resource : newArrayList(resourceSet.getResources())) {
			if (isSourceFile(resource)) {
				if (isWriteStorageFiles()) {
					StorageAwareResource storageAwareResource = (StorageAwareResource)resource;
					storageAwareResource.getResourceStorageFacade().saveResource(storageAwareResource, javaIoFileSystemAccess);
				}
				generator.generate(resource, javaIoFileSystemAccess);
			}
		}
	}

	protected ResourceSetBasedResourceDescriptions getResourceDescriptions(ResourceSet resourceSet) {
		ResourceSetBasedResourceDescriptions resourceDescriptions = resourceSetDescriptionsProvider.get();
		resourceDescriptions.setContext(resourceSet);
		resourceDescriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		return resourceDescriptions;
	}

	/* @Nullable */protected XtendFile getXtendFile(Resource resource) {
		XtextResource xtextResource = (XtextResource) resource;
		IParseResult parseResult = xtextResource.getParseResult();
		if (parseResult != null) {
			EObject model = parseResult.getRootASTElement();
			if (model instanceof XtendFile) {
				XtendFile xtendFile = (XtendFile) model;
				return xtendFile;
			}
		}
		return null;
	}

	protected List<String> getClassPathEntries() {
		return getDirectories(classPath);
	}

	/**
	 * @since 2.7
	 */
	protected List<String> getBootClassPathEntries() {
		return getDirectories(bootClassPath);
	}

	protected List<String> getSourcePathDirectories() {
		return getDirectories(sourcePath);
	}

	protected List<String> getDirectories(String path) {
		if (Strings.isEmpty(path)) {
			return Lists.newArrayList();
		}
		final List<String> split = split(emptyIfNull(path), File.pathSeparator);
		return transform(split, new Function<String, String>() {
			@Override
			public String apply(String from) {
				return new File(new File(from).getAbsoluteFile().toURI().normalize()).getAbsolutePath();
			}
		});
	}

	protected File createTempDir(String prefix) {
		File tempDir = new File(getTempDirectory(), prefix + System.nanoTime());
		cleanFolder(tempDir, ACCEPT_ALL_FILTER, true, true);
		if (!tempDir.mkdirs()) {
			throw new RuntimeException("Error creating temp directory '" + tempDir.getAbsolutePath() + "'");
		}
		tempFolders.add(tempDir);
		return tempDir;
	}

	protected void deleteTmpFolders() {
		for (File file : tempFolders) {
			cleanFolder(file, ACCEPT_ALL_FILTER, true, true);
		}
	}

	protected static boolean cleanFolder(File parentFolder, FileFilter filter, boolean continueOnError,
			boolean deleteParentFolder) {
		try {
			log.debug("Cleaning folder " + parentFolder.toString());
			return Files.cleanFolder(parentFolder, null, continueOnError, deleteParentFolder);
		} catch (FileNotFoundException e) {
			return true;
		}
	}
	
	@Deprecated
	protected Writer outputWriter = new CharArrayWriter();
	@Deprecated
	protected Writer errorWriter = new CharArrayWriter();

	@Deprecated
	public Writer getOutputWriter() {
		log.warn("XtendBatchCompiler.getOutputWriter has been deprecated");
		return outputWriter;
	}

	@Deprecated
	public void setOutputWriter(Writer ouputWriter) {
		log.warn("XtendBatchCompiler.setOutputWriter has been deprecated");
		this.outputWriter = ouputWriter;
	}

	@Deprecated
	public Writer getErrorWriter() {
		log.warn("XtendBatchCompiler.getErrorWriter has been deprecated");
		return errorWriter;
	}

	@Deprecated
	public void setErrorWriter(Writer errorWriter) {
		log.warn("XtendBatchCompiler.setErrorWriter has been deprecated");
		this.errorWriter = errorWriter;
	}
}

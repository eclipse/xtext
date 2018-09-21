package org.eclipse.xtext.builder.standalone;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import java.util.zip.ZipException;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.standalone.ClusteringConfig;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class StandaloneBuilder {
  private static final Logger LOG = Logger.getLogger(StandaloneBuilder.class);
  
  /**
   * Map key is a file extension provided by Language FileExtensionProvider
   */
  @Accessors
  private Map<String, LanguageAccess> languages;
  
  @Accessors
  private String baseDir;
  
  @Accessors
  private Iterable<String> sourceDirs;
  
  @Accessors
  private Iterable<String> javaSourceDirs = CollectionLiterals.<String>newArrayList();
  
  @Accessors
  private Iterable<String> classPathEntries;
  
  @Accessors
  private File tempDir = Files.createTempDir();
  
  @Accessors
  private String encoding;
  
  @Accessors
  private String classPathLookUpFilter;
  
  /**
   * If failOnValidationError is set to <code>false</code>, StandaloneBuilder will try to execute<br>
   * language generator in spite of validation errors.<br>
   * Note that {@link #launch()} will still return the current validation state.
   * <br>Default is <code>true</code>
   */
  @Accessors
  private boolean failOnValidationError = true;
  
  @Accessors
  private boolean debugLog;
  
  @Accessors
  private boolean writeStorageResources;
  
  @Accessors
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
  
  public void setTempDir(final String pathAsString) {
    if ((pathAsString != null)) {
      File _file = new File(pathAsString);
      this.tempDir = _file;
    }
  }
  
  /**
   * @return <code>false</code> if some of processed resources contains severe validation issues. <code>true</code> otherwise
   */
  public boolean launch() {
    final Function1<LanguageAccess, Boolean> _function = (LanguageAccess it) -> {
      return Boolean.valueOf(it.isLinksAgainstJava());
    };
    final boolean needsJava = IterableExtensions.<LanguageAccess>exists(this.languages.values(), _function);
    if ((this.baseDir == null)) {
      this.baseDir = System.getProperty("user.dir");
      StandaloneBuilder.LOG.warn((("Property baseDir not set. Using \'" + this.baseDir) + "\'"));
    }
    if (needsJava) {
      StandaloneBuilder.LOG.info("Using common types.");
    }
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    if ((this.encoding != null)) {
      this.forceDebugLog("Setting encoding.");
      this.fileEncodingSetup(this.languages.values(), this.encoding);
    }
    StandaloneBuilder.LOG.info("Collecting source models.");
    final long startedAt = System.currentTimeMillis();
    Iterable<String> rootsToTravers = this.classPathEntries;
    if ((this.classPathLookUpFilter != null)) {
      StandaloneBuilder.LOG.info("Class path look up filter is active.");
      final Pattern cpLookUpFilter = Pattern.compile(this.classPathLookUpFilter);
      final Function1<String, Boolean> _function_1 = (String root) -> {
        return Boolean.valueOf(cpLookUpFilter.matcher(root).matches());
      };
      rootsToTravers = IterableExtensions.<String>filter(this.classPathEntries, _function_1);
      final Iterable<String> _converted_rootsToTravers = (Iterable<String>)rootsToTravers;
      int _length = ((Object[])Conversions.unwrapArray(_converted_rootsToTravers, Object.class)).length;
      String _plus = ("Investigating " + Integer.valueOf(_length));
      String _plus_1 = (_plus + " of ");
      int _length_1 = ((Object[])Conversions.unwrapArray(this.classPathEntries, Object.class)).length;
      String _plus_2 = (_plus_1 + Integer.valueOf(_length_1));
      String _plus_3 = (_plus_2 + " class path entries.");
      StandaloneBuilder.LOG.info(_plus_3);
    }
    final List<URI> sourceResourceURIs = this.collectResources(this.sourceDirs, resourceSet);
    List<URI> _collectResources = this.collectResources(rootsToTravers, resourceSet);
    final Iterable<URI> allResourcesURIs = Iterables.<URI>concat(sourceResourceURIs, _collectResources);
    long _currentTimeMillis = System.currentTimeMillis();
    long _minus = (_currentTimeMillis - startedAt);
    String _plus_4 = ("Finished collecting source models. Took: " + Long.valueOf(_minus));
    String _plus_5 = (_plus_4 + " ms.");
    this.forceDebugLog(_plus_5);
    final Iterable<String> allClassPathEntries = Iterables.<String>concat(this.sourceDirs, this.classPathEntries);
    if (needsJava) {
      StandaloneBuilder.LOG.info("Installing type provider.");
      this.installTypeProvider(allClassPathEntries, resourceSet, null);
    }
    IResourceClusteringPolicy _xifexpression = null;
    if ((this.clusteringConfig != null)) {
      DynamicResourceClusteringPolicy _xblockexpression = null;
      {
        StandaloneBuilder.LOG.info("Clustering configured.");
        DynamicResourceClusteringPolicy _dynamicResourceClusteringPolicy = new DynamicResourceClusteringPolicy();
        final Procedure1<DynamicResourceClusteringPolicy> _function_2 = (DynamicResourceClusteringPolicy it) -> {
          long _minimumFreeMemory = this.clusteringConfig.getMinimumFreeMemory();
          long _multiply = (_minimumFreeMemory * 1024);
          long _multiply_1 = (_multiply * 1024);
          it.setMinimumFreeMemory(_multiply_1);
          it.setMinimumClusterSize(this.clusteringConfig.getMinimumClusterSize());
          it.setMinimumPercentFreeMemory(this.clusteringConfig.getMinimumPercentFreeMemory());
        };
        _xblockexpression = ObjectExtensions.<DynamicResourceClusteringPolicy>operator_doubleArrow(_dynamicResourceClusteringPolicy, _function_2);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = new DisabledClusteringPolicy();
    }
    final IResourceClusteringPolicy strategy = _xifexpression;
    ArrayList<IResourceDescription> _newArrayList = CollectionLiterals.<IResourceDescription>newArrayList();
    ResourceDescriptionsData index = new ResourceDescriptionsData(_newArrayList);
    Iterator<URI> allResourceIterator = allResourcesURIs.iterator();
    while (allResourceIterator.hasNext()) {
      {
        List<Resource> resources = CollectionLiterals.<Resource>newArrayList();
        int clusterIndex = 0;
        boolean continue_ = true;
        while ((allResourceIterator.hasNext() && continue_)) {
          {
            final URI uri = allResourceIterator.next();
            final Resource resource = resourceSet.getResource(uri, true);
            resources.add(resource);
            this.fillIndex(uri, resource, index);
            clusterIndex++;
            boolean _continueProcessing = strategy.continueProcessing(resourceSet, null, clusterIndex);
            boolean _not = (!_continueProcessing);
            if (_not) {
              continue_ = false;
            }
          }
        }
        if ((!continue_)) {
          this.clearResourceSet(resourceSet);
        }
      }
    }
    this.installIndex(resourceSet, index);
    if (needsJava) {
      final String stubsClasses = this.compileStubs(this.generateStubs(index, sourceResourceURIs));
      StandaloneBuilder.LOG.info("Installing type provider for stubs.");
      ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList(stubsClasses);
      Iterable<String> _plus_6 = Iterables.<String>concat(allClassPathEntries, _newArrayList_1);
      this.installTypeProvider(_plus_6, resourceSet, this.jvmTypeAccess);
    }
    StandaloneBuilder.LOG.info("Validate and generate.");
    final Iterator<URI> sourceResourceIterator = sourceResourceURIs.iterator();
    boolean hasValidationErrors = false;
    while (sourceResourceIterator.hasNext()) {
      {
        List<Resource> resources = CollectionLiterals.<Resource>newArrayList();
        int clusterIndex = 0;
        boolean continue_ = true;
        while ((sourceResourceIterator.hasNext() && continue_)) {
          {
            final URI uri = sourceResourceIterator.next();
            final Resource resource = resourceSet.getResource(uri, true);
            resources.add(resource);
            resource.getContents();
            EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
            hasValidationErrors = ((!this.validate(resource)) || hasValidationErrors);
            clusterIndex++;
            boolean _continueProcessing = strategy.continueProcessing(resourceSet, null, clusterIndex);
            boolean _not = (!_continueProcessing);
            if (_not) {
              continue_ = false;
            }
          }
        }
        if ((this.failOnValidationError && hasValidationErrors)) {
          return (!hasValidationErrors);
        }
        this.generate(resources);
        if ((!continue_)) {
          this.clearResourceSet(resourceSet);
        }
      }
    }
    return (!hasValidationErrors);
  }
  
  public void fillIndex(final URI uri, final Resource resource, final ResourceDescriptionsData index) {
    final IResourceDescription description = this.languageAccess(uri).getResourceDescriptionManager().getResourceDescription(resource);
    index.addDescription(uri, description);
  }
  
  public void fileEncodingSetup(final Collection<LanguageAccess> langs, final String encoding) {
    for (final LanguageAccess lang : langs) {
      IEncodingProvider _encodingProvider = lang.getEncodingProvider();
      final IEncodingProvider provider = _encodingProvider;
      boolean _matched = false;
      if (provider instanceof IEncodingProvider.Runtime) {
        _matched=true;
        ((IEncodingProvider.Runtime)provider).setDefaultEncoding(encoding);
      }
      if (!_matched) {
        this.forceDebugLog((((("Couldn\'t set encoding \'" + encoding) + "\' for provider \'") + provider) + 
          "\'. Only subclasses of IEncodingProvider.Runtime are supported."));
      }
    }
  }
  
  protected void installIndex(final XtextResourceSet resourceSet, final ResourceDescriptionsData index) {
    ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index);
  }
  
  protected String compileStubs(final File stubsDir) {
    final File stubsClasses = this.createTempDir("classes");
    this.compiler.setClassPath(this.classPathEntries);
    String _absolutePath = stubsDir.getAbsolutePath();
    String _plus = ("Compiling stubs located in " + _absolutePath);
    StandaloneBuilder.LOG.info(_plus);
    Iterable<String> _plus_1 = Iterables.<String>concat(this.javaSourceDirs, this.sourceDirs);
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(stubsDir.getAbsolutePath());
    Iterable<String> _plus_2 = Iterables.<String>concat(_plus_1, _newArrayList);
    final Set<String> sourcesToCompile = this.uniqueEntries(_plus_2);
    String _join = IterableExtensions.join(sourcesToCompile, ",");
    String _plus_3 = ("Compiler source roots: " + _join);
    this.forceDebugLog(_plus_3);
    final IJavaCompiler.CompilationResult result = this.compiler.compile(sourcesToCompile, stubsClasses);
    if (result != null) {
      switch (result) {
        case SKIPPED:
          StandaloneBuilder.LOG.info("Nothing to compile. Stubs compilation was skipped.");
          break;
        case FAILED:
          this.forceDebugLog("Stubs compilation finished with errors.");
          break;
        case SUCCEEDED:
          this.forceDebugLog("Stubs compilation successfully finished.");
          break;
        default:
          break;
      }
    }
    return stubsClasses.getAbsolutePath();
  }
  
  protected Set<String> uniqueEntries(final Iterable<String> pathes) {
    final Function1<String, String> _function = (String it) -> {
      return new File(it).getAbsolutePath();
    };
    return IterableExtensions.<String>toSet(IterableExtensions.<String, String>map(pathes, _function));
  }
  
  protected File generateStubs(final ResourceDescriptionsData data, final List<URI> sourceResourceURIs) {
    final File stubsDir = this.createTempDir("stubs");
    String _absolutePath = stubsDir.getAbsolutePath();
    String _plus = ("Generating stubs into " + _absolutePath);
    StandaloneBuilder.LOG.info(_plus);
    if ((this.encoding != null)) {
      this.encodingProvider.setDefaultEncoding(this.encoding);
    }
    this.commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, stubsDir.getAbsolutePath());
    final Function1<URI, Boolean> _function = (URI it) -> {
      return Boolean.valueOf(this.languageAccess(it).isLinksAgainstJava());
    };
    final Iterable<URI> generateStubs = IterableExtensions.<URI>filter(sourceResourceURIs, _function);
    final Consumer<URI> _function_1 = (URI it) -> {
      this.languageAccess(it).getStubGenerator().doGenerateStubs(this.commonFileAccess, data.getResourceDescription(it));
    };
    generateStubs.forEach(_function_1);
    return stubsDir;
  }
  
  protected boolean validate(final Resource resource) {
    String _lastSegment = resource.getURI().lastSegment();
    String _plus = ("Starting validation for input: \'" + _lastSegment);
    String _plus_1 = (_plus + "\'");
    StandaloneBuilder.LOG.info(_plus_1);
    final IResourceValidator resourceValidator = this.languageAccess(resource.getURI()).getResourceValidator();
    final List<Issue> validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
    return this.issueHandler.handleIssue(validationResult);
  }
  
  protected void generate(final List<Resource> sourceResources) {
    final GeneratorContext context = new GeneratorContext();
    context.setCancelIndicator(CancelIndicator.NullImpl);
    for (final Resource it : sourceResources) {
      {
        String _lastSegment = it.getURI().lastSegment();
        String _plus = ("Starting generator for input: \'" + _lastSegment);
        String _plus_1 = (_plus + "\'");
        StandaloneBuilder.LOG.info(_plus_1);
        this.registerCurrentSource(it.getURI());
        final LanguageAccess access = this.languageAccess(it.getURI());
        final JavaIoFileSystemAccess fileSystemAccess = this.getFileSystemAccess(access);
        boolean _isWriteStorageResources = this.isWriteStorageResources();
        if (_isWriteStorageResources) {
          boolean _matched = false;
          if (it instanceof StorageAwareResource) {
            IResourceStorageFacade _resourceStorageFacade = ((StorageAwareResource)it).getResourceStorageFacade();
            boolean _tripleNotEquals = (_resourceStorageFacade != null);
            if (_tripleNotEquals) {
              _matched=true;
              ((StorageAwareResource)it).getResourceStorageFacade().saveResource(((StorageAwareResource)it), fileSystemAccess);
            }
          }
        }
        access.getGenerator().generate(it, fileSystemAccess, context);
      }
    }
  }
  
  protected void registerCurrentSource(final URI uri) {
    final JavaIoFileSystemAccess fsa = this.getFileSystemAccess(this.languageAccess(uri));
    final Function1<String, URI> _function = (String it) -> {
      File _file = new File(it);
      return UriUtil.createFolderURI(_file);
    };
    final Function1<URI, Boolean> _function_1 = (URI it) -> {
      return Boolean.valueOf(UriUtil.isPrefixOf(it, uri));
    };
    final URI absoluteSource = IterableExtensions.<URI>findFirst(IterableExtensions.<String, URI>map(this.sourceDirs, _function), _function_1);
    if ((absoluteSource == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Resource ");
      _builder.append(uri);
      _builder.append(" is not contained in any of the known source folders ");
      _builder.append(this.sourceDirs);
      _builder.append(".");
      throw new IllegalStateException(_builder.toString());
    }
    File _file = new File(this.baseDir);
    final URI projectBaseURI = UriUtil.createFolderURI(_file);
    Collection<OutputConfiguration> _values = fsa.getOutputConfigurations().values();
    for (final OutputConfiguration output : _values) {
      Set<String> _sourceFolders = output.getSourceFolders();
      for (final String sourceFolder : _sourceFolders) {
        {
          URI sourceFolderURI = URI.createURI((sourceFolder + "/"));
          boolean _isRelative = sourceFolderURI.isRelative();
          if (_isRelative) {
            sourceFolderURI = sourceFolderURI.resolve(projectBaseURI);
          }
          boolean _equals = Objects.equal(absoluteSource, sourceFolderURI);
          if (_equals) {
            fsa.setCurrentSource(sourceFolder);
          }
        }
      }
    }
  }
  
  private Map<LanguageAccess, JavaIoFileSystemAccess> configuredFsas = CollectionLiterals.<LanguageAccess, JavaIoFileSystemAccess>newHashMap();
  
  private JavaIoFileSystemAccess getFileSystemAccess(final LanguageAccess language) {
    JavaIoFileSystemAccess fsa = this.configuredFsas.get(language);
    if ((fsa == null)) {
      File _file = new File(this.baseDir);
      fsa = language.createFileSystemAccess(_file);
      fsa = this.configureFileSystemAccess(fsa, language);
      this.configuredFsas.put(language, fsa);
    }
    return fsa;
  }
  
  protected JavaIoFileSystemAccess configureFileSystemAccess(final JavaIoFileSystemAccess fsa, final LanguageAccess language) {
    return fsa;
  }
  
  private LanguageAccess languageAccess(final URI uri) {
    return this.languages.get(uri.fileExtension());
  }
  
  protected File createTempDir(final String subDir) {
    try {
      final File file = new File(this.tempDir, subDir);
      if (((!file.mkdirs()) && (!file.exists()))) {
        String _absolutePath = file.getAbsolutePath();
        String _plus = ("Failed to create directory \'" + _absolutePath);
        String _plus_1 = (_plus + "\'");
        throw new IOException(_plus_1);
      }
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void installTypeProvider(final Iterable<String> classPathRoots, final XtextResourceSet resSet, final IndexedJvmTypeAccess typeAccess) {
    final URLClassLoader classLoader = this.createURLClassLoader(classPathRoots);
    new ClasspathTypeProvider(classLoader, resSet, typeAccess, null);
    resSet.setClasspathURIContext(classLoader);
  }
  
  private URLClassLoader createURLClassLoader(final Iterable<String> classPathEntries) {
    final Function1<String, URL> _function = (String str) -> {
      try {
        return new File(str).toURI().toURL();
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    final Iterable<URL> classPathUrls = IterableExtensions.<String, URL>map(classPathEntries, _function);
    return new URLClassLoader(((URL[])Conversions.unwrapArray(classPathUrls, URL.class)));
  }
  
  protected List<URI> collectResources(final Iterable<String> roots, final ResourceSet resourceSet) {
    final String extensions = IterableExtensions.join(this.languages.keySet(), "|");
    final NameBasedFilter nameBasedFilter = new NameBasedFilter();
    nameBasedFilter.setRegularExpression(((".*\\.(?:(" + extensions) + "))$"));
    final List<URI> resources = CollectionLiterals.<URI>newArrayList();
    final Predicate<URI> _function = (URI input) -> {
      final boolean matches = nameBasedFilter.matches(input);
      if (matches) {
        this.forceDebugLog((("Adding file \'" + input) + "\'"));
        resources.add(input);
      }
      return matches;
    };
    final Multimap<String, URI> modelsFound = new PathTraverser().resolvePathes(
      IterableExtensions.<String>toList(roots), _function);
    final BiConsumer<String, Collection<URI>> _function_1 = (String uri, Collection<URI> resource) -> {
      final File file = new File(uri);
      if ((((resource != null) && (!file.isDirectory())) && file.getName().endsWith(".jar"))) {
        this.registerBundle(file);
      }
    };
    modelsFound.asMap().forEach(_function_1);
    return resources;
  }
  
  protected void registerBundle(final File file) {
    JarFile jarFile = null;
    try {
      JarFile _jarFile = new JarFile(file);
      jarFile = _jarFile;
      final Manifest manifest = jarFile.getManifest();
      if ((manifest == null)) {
        return;
      }
      String name = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
      if ((name != null)) {
        final int indexOf = name.indexOf(";");
        if ((indexOf > 0)) {
          name = name.substring(0, indexOf);
        }
        boolean _containsKey = EcorePlugin.getPlatformResourceMap().containsKey(name);
        if (_containsKey) {
          return;
        }
        java.net.URI _uRI = file.toURI();
        String _plus = ("archive:" + _uRI);
        final String path = (_plus + "!/");
        final URI uri = URI.createURI(path);
        EcorePlugin.getPlatformResourceMap().put(name, uri);
      }
    } catch (final Throwable _t) {
      if (_t instanceof ZipException) {
        String _absolutePath = file.getAbsolutePath();
        String _plus_1 = ("Could not open Jar file " + _absolutePath);
        String _plus_2 = (_plus_1 + ".");
        this.forceDebugLog(_plus_2);
      } else if (_t instanceof Exception) {
        final Exception e_1 = (Exception)_t;
        StandaloneBuilder.LOG.error(file.getAbsolutePath(), e_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      try {
        if ((jarFile != null)) {
          jarFile.close();
        }
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof IOException) {
          final IOException e_2 = (IOException)_t_1;
          StandaloneBuilder.LOG.error(jarFile, e_2);
        } else {
          throw Exceptions.sneakyThrow(_t_1);
        }
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
  public void clearResourceSet(final ResourceSet resourceSet) {
    final boolean wasDeliver = resourceSet.eDeliver();
    try {
      resourceSet.eSetDeliver(false);
      resourceSet.getResources().clear();
    } finally {
      resourceSet.eSetDeliver(wasDeliver);
    }
  }
  
  protected void forceDebugLog(final String logMessage) {
    boolean _isDebugEnabled = StandaloneBuilder.LOG.isDebugEnabled();
    if (_isDebugEnabled) {
      StandaloneBuilder.LOG.debug(logMessage);
    } else {
      if (this.debugLog) {
        StandaloneBuilder.LOG.info(logMessage);
      }
    }
  }
  
  @Pure
  public Map<String, LanguageAccess> getLanguages() {
    return this.languages;
  }
  
  public void setLanguages(final Map<String, LanguageAccess> languages) {
    this.languages = languages;
  }
  
  @Pure
  public String getBaseDir() {
    return this.baseDir;
  }
  
  public void setBaseDir(final String baseDir) {
    this.baseDir = baseDir;
  }
  
  @Pure
  public Iterable<String> getSourceDirs() {
    return this.sourceDirs;
  }
  
  public void setSourceDirs(final Iterable<String> sourceDirs) {
    this.sourceDirs = sourceDirs;
  }
  
  @Pure
  public Iterable<String> getJavaSourceDirs() {
    return this.javaSourceDirs;
  }
  
  public void setJavaSourceDirs(final Iterable<String> javaSourceDirs) {
    this.javaSourceDirs = javaSourceDirs;
  }
  
  @Pure
  public Iterable<String> getClassPathEntries() {
    return this.classPathEntries;
  }
  
  public void setClassPathEntries(final Iterable<String> classPathEntries) {
    this.classPathEntries = classPathEntries;
  }
  
  @Pure
  public File getTempDir() {
    return this.tempDir;
  }
  
  public void setTempDir(final File tempDir) {
    this.tempDir = tempDir;
  }
  
  @Pure
  public String getEncoding() {
    return this.encoding;
  }
  
  public void setEncoding(final String encoding) {
    this.encoding = encoding;
  }
  
  @Pure
  public String getClassPathLookUpFilter() {
    return this.classPathLookUpFilter;
  }
  
  public void setClassPathLookUpFilter(final String classPathLookUpFilter) {
    this.classPathLookUpFilter = classPathLookUpFilter;
  }
  
  @Pure
  public boolean isFailOnValidationError() {
    return this.failOnValidationError;
  }
  
  public void setFailOnValidationError(final boolean failOnValidationError) {
    this.failOnValidationError = failOnValidationError;
  }
  
  @Pure
  public boolean isDebugLog() {
    return this.debugLog;
  }
  
  public void setDebugLog(final boolean debugLog) {
    this.debugLog = debugLog;
  }
  
  @Pure
  public boolean isWriteStorageResources() {
    return this.writeStorageResources;
  }
  
  public void setWriteStorageResources(final boolean writeStorageResources) {
    this.writeStorageResources = writeStorageResources;
  }
  
  @Pure
  public ClusteringConfig getClusteringConfig() {
    return this.clusteringConfig;
  }
  
  public void setClusteringConfig(final ClusteringConfig clusteringConfig) {
    this.clusteringConfig = clusteringConfig;
  }
}

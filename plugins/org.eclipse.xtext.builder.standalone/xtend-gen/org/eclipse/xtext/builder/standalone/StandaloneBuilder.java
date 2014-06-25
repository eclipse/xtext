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
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipException;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.standalone.ClusteringConfig;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.descriptions.IStubGenerator;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
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
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class StandaloneBuilder {
  private final static Logger LOG = Logger.getLogger(StandaloneBuilder.class);
  
  /**
   * Map key is a file extension provided by Language FileExtensionProvider
   */
  @Property
  private Map<String, LanguageAccess> _languages;
  
  @Property
  private Iterable<String> _sourceDirs;
  
  @Property
  private Iterable<String> _classPathEntries;
  
  @Property
  private File _tempDir = Files.createTempDir();
  
  @Property
  private String _encoding;
  
  @Property
  private String _classPathLookUpFilter;
  
  @Property
  private boolean _failOnValidationError = true;
  
  @Property
  private ClusteringConfig _clusteringConfig = null;
  
  @Inject
  private IndexedJvmTypeAccess jvmTypeAccess;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private AbstractFileSystemAccess commonFileAccess;
  
  @Inject
  private IIssueHandler issueHandler;
  
  @Inject
  private IEncodingProvider.Runtime encodingProvider;
  
  @Inject
  private IJavaCompiler compiler;
  
  public void setTempDir(final String pathAsString) {
    boolean _notEquals = (!Objects.equal(pathAsString, null));
    if (_notEquals) {
      File _file = new File(pathAsString);
      this._tempDir = _file;
    }
  }
  
  public boolean launch() {
    Map<String, LanguageAccess> _languages = this.getLanguages();
    Collection<LanguageAccess> _values = _languages.values();
    final Function1<LanguageAccess, Boolean> _function = new Function1<LanguageAccess, Boolean>() {
      public Boolean apply(final LanguageAccess it) {
        return Boolean.valueOf(it.isLinksAgainstJava());
      }
    };
    final boolean needsJava = IterableExtensions.<LanguageAccess>exists(_values, _function);
    if (needsJava) {
      StandaloneBuilder.LOG.info("Using common types.");
    }
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    String _encoding = this.getEncoding();
    boolean _notEquals = (!Objects.equal(_encoding, null));
    if (_notEquals) {
      StandaloneBuilder.LOG.debug("Setting encoding.");
      Map<String, LanguageAccess> _languages_1 = this.getLanguages();
      Collection<LanguageAccess> _values_1 = _languages_1.values();
      String _encoding_1 = this.getEncoding();
      this.fileEncodingSetup(_values_1, _encoding_1);
    }
    StandaloneBuilder.LOG.info("Collecting source models.");
    final long startedAt = System.currentTimeMillis();
    Iterable<String> rootsToTravers = this.getClassPathEntries();
    String _classPathLookUpFilter = this.getClassPathLookUpFilter();
    boolean _notEquals_1 = (!Objects.equal(_classPathLookUpFilter, null));
    if (_notEquals_1) {
      StandaloneBuilder.LOG.info("Class path look up filter is active.");
      String _classPathLookUpFilter_1 = this.getClassPathLookUpFilter();
      final Pattern cpLookUpFilter = Pattern.compile(_classPathLookUpFilter_1);
      Iterable<String> _classPathEntries = this.getClassPathEntries();
      final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
        public Boolean apply(final String root) {
          Matcher _matcher = cpLookUpFilter.matcher(root);
          return Boolean.valueOf(_matcher.matches());
        }
      };
      Iterable<String> _filter = IterableExtensions.<String>filter(_classPathEntries, _function_1);
      rootsToTravers = _filter;
      final Iterable<String> _converted_rootsToTravers = (Iterable<String>)rootsToTravers;
      int _length = ((Object[])Conversions.unwrapArray(_converted_rootsToTravers, Object.class)).length;
      String _plus = ("Investigating " + Integer.valueOf(_length));
      String _plus_1 = (_plus + " of ");
      Iterable<String> _classPathEntries_1 = this.getClassPathEntries();
      int _length_1 = ((Object[])Conversions.unwrapArray(_classPathEntries_1, Object.class)).length;
      String _plus_2 = (_plus_1 + Integer.valueOf(_length_1));
      String _plus_3 = (_plus_2 + " class path entries.");
      StandaloneBuilder.LOG.info(_plus_3);
    }
    Iterable<String> _sourceDirs = this.getSourceDirs();
    final List<URI> sourceResourceURIs = this.collectResources(_sourceDirs, resourceSet);
    List<URI> _collectResources = this.collectResources(rootsToTravers, resourceSet);
    final Iterable<URI> allResourcesURIs = Iterables.<URI>concat(sourceResourceURIs, _collectResources);
    long _currentTimeMillis = System.currentTimeMillis();
    long _minus = (_currentTimeMillis - startedAt);
    String _plus_4 = ("Finished collecting source models. Took: " + Long.valueOf(_minus));
    String _plus_5 = (_plus_4 + " ms.");
    StandaloneBuilder.LOG.debug(_plus_5);
    Iterable<String> _sourceDirs_1 = this.getSourceDirs();
    Iterable<String> _classPathEntries_2 = this.getClassPathEntries();
    final Iterable<String> allClassPathEntries = Iterables.<String>concat(_sourceDirs_1, _classPathEntries_2);
    if (needsJava) {
      StandaloneBuilder.LOG.info("Installing type provider.");
      this.installTypeProvider(allClassPathEntries, resourceSet, null);
    }
    IResourceClusteringPolicy _xifexpression = null;
    ClusteringConfig _clusteringConfig = this.getClusteringConfig();
    boolean _notEquals_2 = (!Objects.equal(_clusteringConfig, null));
    if (_notEquals_2) {
      DynamicResourceClusteringPolicy _xblockexpression = null;
      {
        StandaloneBuilder.LOG.info("Clustering configured.");
        DynamicResourceClusteringPolicy _dynamicResourceClusteringPolicy = new DynamicResourceClusteringPolicy();
        final Procedure1<DynamicResourceClusteringPolicy> _function_2 = new Procedure1<DynamicResourceClusteringPolicy>() {
          public void apply(final DynamicResourceClusteringPolicy it) {
            ClusteringConfig _clusteringConfig = StandaloneBuilder.this.getClusteringConfig();
            long _minimumFreeMemory = _clusteringConfig.getMinimumFreeMemory();
            long _multiply = (_minimumFreeMemory * 1024);
            long _multiply_1 = (_multiply * 1024);
            it.setMinimumFreeMemory(_multiply_1);
            ClusteringConfig _clusteringConfig_1 = StandaloneBuilder.this.getClusteringConfig();
            int _minimumClusterSize = _clusteringConfig_1.getMinimumClusterSize();
            it.setMinimumClusterSize(_minimumClusterSize);
            ClusteringConfig _clusteringConfig_2 = StandaloneBuilder.this.getClusteringConfig();
            long _minimumPercentFreeMemory = _clusteringConfig_2.getMinimumPercentFreeMemory();
            it.setMinimumPercentFreeMemory(_minimumPercentFreeMemory);
          }
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
    boolean _hasNext = allResourceIterator.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        List<Resource> resources = CollectionLiterals.<Resource>newArrayList();
        int clusterIndex = 0;
        boolean continue_ = true;
        boolean _and = false;
        boolean _hasNext_1 = allResourceIterator.hasNext();
        if (!_hasNext_1) {
          _and = false;
        } else {
          _and = continue_;
        }
        boolean _while_1 = _and;
        while (_while_1) {
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
          boolean _and_1 = false;
          boolean _hasNext_2 = allResourceIterator.hasNext();
          if (!_hasNext_2) {
            _and_1 = false;
          } else {
            _and_1 = continue_;
          }
          _while_1 = _and_1;
        }
        if ((!continue_)) {
          this.clearResourceSet(resourceSet);
        }
      }
      boolean _hasNext_1 = allResourceIterator.hasNext();
      _while = _hasNext_1;
    }
    this.installIndex(resourceSet, index);
    if (needsJava) {
      File _generateStubs = this.generateStubs(index, sourceResourceURIs);
      final String stubsClasses = this.compileStubs(_generateStubs);
      StandaloneBuilder.LOG.info("Installing type provider for stubs.");
      ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList(stubsClasses);
      Iterable<String> _plus_6 = Iterables.<String>concat(allClassPathEntries, _newArrayList_1);
      this.installTypeProvider(_plus_6, resourceSet, this.jvmTypeAccess);
    }
    final Iterator<URI> sourceResourceIterator = sourceResourceURIs.iterator();
    boolean isErrorFree = true;
    boolean _hasNext_1 = sourceResourceIterator.hasNext();
    boolean _while_1 = _hasNext_1;
    while (_while_1) {
      {
        List<Resource> resources = CollectionLiterals.<Resource>newArrayList();
        int clusterIndex = 0;
        boolean continue_ = true;
        boolean _and = false;
        boolean _hasNext_2 = sourceResourceIterator.hasNext();
        if (!_hasNext_2) {
          _and = false;
        } else {
          _and = continue_;
        }
        boolean _while_2 = _and;
        while (_while_2) {
          {
            final URI uri = sourceResourceIterator.next();
            final Resource resource = resourceSet.getResource(uri, true);
            resources.add(resource);
            resource.getContents();
            EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
            clusterIndex++;
            boolean _continueProcessing = strategy.continueProcessing(resourceSet, null, clusterIndex);
            boolean _not = (!_continueProcessing);
            if (_not) {
              continue_ = false;
            }
          }
          boolean _and_1 = false;
          boolean _hasNext_3 = sourceResourceIterator.hasNext();
          if (!_hasNext_3) {
            _and_1 = false;
          } else {
            _and_1 = continue_;
          }
          _while_2 = _and_1;
        }
        boolean _validateAndGenerate = this.validateAndGenerate(resources);
        isErrorFree = _validateAndGenerate;
        boolean _and_1 = false;
        boolean _isFailOnValidationError = this.isFailOnValidationError();
        if (!_isFailOnValidationError) {
          _and_1 = false;
        } else {
          _and_1 = (!isErrorFree);
        }
        if (_and_1) {
          return isErrorFree;
        }
        if ((!continue_)) {
          this.clearResourceSet(resourceSet);
        }
      }
      boolean _hasNext_2 = sourceResourceIterator.hasNext();
      _while_1 = _hasNext_2;
    }
    return isErrorFree;
  }
  
  public void fillIndex(final URI uri, final Resource resource, final ResourceDescriptionsData index) {
    LanguageAccess _languageAccess = this.languageAccess(uri);
    IResourceDescription.Manager _resourceDescriptionManager = _languageAccess.getResourceDescriptionManager();
    final IResourceDescription description = _resourceDescriptionManager.getResourceDescription(resource);
    index.addDescription(uri, description);
  }
  
  public boolean validateAndGenerate(final List<Resource> resources) {
    boolean _xblockexpression = false;
    {
      final boolean isErrorFree = this.validate(resources);
      if (isErrorFree) {
        this.generate(resources);
      }
      _xblockexpression = isErrorFree;
    }
    return _xblockexpression;
  }
  
  public void fileEncodingSetup(final Collection<LanguageAccess> langs, final String encoding) {
    for (final LanguageAccess lang : langs) {
      IEncodingProvider _encodingProvider = lang.getEncodingProvider();
      final IEncodingProvider provider = _encodingProvider;
      boolean _matched = false;
      if (!_matched) {
        if (provider instanceof IEncodingProvider.Runtime) {
          _matched=true;
          ((IEncodingProvider.Runtime)provider).setDefaultEncoding(encoding);
        }
      }
      if (!_matched) {
        StandaloneBuilder.LOG.debug(
          (((("Couldn\'t set encoding \'" + encoding) + "\' for provider \'") + provider) + 
            "\'. Only subclasses of IEncodingProvider.Runtime are supported."));
      }
    }
  }
  
  protected void installIndex(final XtextResourceSet resourceSet, final ResourceDescriptionsData index) {
    ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index);
  }
  
  protected String compileStubs(final File stubsDir) {
    final File stubsClasses = this.createTempDir("classes");
    Iterable<String> _classPathEntries = this.getClassPathEntries();
    this.compiler.setClassPath(_classPathEntries);
    String _absolutePath = stubsDir.getAbsolutePath();
    String _plus = ("Compiling stubs located in " + _absolutePath);
    StandaloneBuilder.LOG.info(_plus);
    Iterable<String> _sourceDirs = this.getSourceDirs();
    String _absolutePath_1 = stubsDir.getAbsolutePath();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(_absolutePath_1);
    Iterable<String> _plus_1 = Iterables.<String>concat(_sourceDirs, _newArrayList);
    final IJavaCompiler.CompilationResult result = this.compiler.compile(_plus_1, stubsClasses);
    if (result != null) {
      switch (result) {
        case SKIPPED:
          StandaloneBuilder.LOG.info("Nothing to compile. Stubs compilation was skipped.");
          break;
        case FAILED:
          StandaloneBuilder.LOG.debug("Stubs compilation finished with errors.");
          break;
        case SUCCEEDED:
          StandaloneBuilder.LOG.debug("Stubs compilation successfully finished.");
          break;
        default:
          break;
      }
    }
    return stubsClasses.getAbsolutePath();
  }
  
  protected File generateStubs(final ResourceDescriptionsData data, final List<URI> sourceResourceURIs) {
    final File stubsDir = this.createTempDir("stubs");
    String _absolutePath = stubsDir.getAbsolutePath();
    String _plus = ("Generating stubs into " + _absolutePath);
    StandaloneBuilder.LOG.info(_plus);
    String _encoding = this.getEncoding();
    boolean _notEquals = (!Objects.equal(_encoding, null));
    if (_notEquals) {
      String _encoding_1 = this.getEncoding();
      this.encodingProvider.setDefaultEncoding(_encoding_1);
    }
    String _absolutePath_1 = stubsDir.getAbsolutePath();
    this.commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, _absolutePath_1);
    final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
      public Boolean apply(final URI it) {
        LanguageAccess _languageAccess = StandaloneBuilder.this.languageAccess(it);
        return Boolean.valueOf(_languageAccess.isLinksAgainstJava());
      }
    };
    final Iterable<URI> generateStubs = IterableExtensions.<URI>filter(sourceResourceURIs, _function);
    final Procedure1<URI> _function_1 = new Procedure1<URI>() {
      public void apply(final URI it) {
        LanguageAccess _languageAccess = StandaloneBuilder.this.languageAccess(it);
        IStubGenerator _stubGenerator = _languageAccess.getStubGenerator();
        IResourceDescription _resourceDescription = data.getResourceDescription(it);
        _stubGenerator.doGenerateStubs(StandaloneBuilder.this.commonFileAccess, _resourceDescription);
      }
    };
    IterableExtensions.<URI>forEach(generateStubs, _function_1);
    return stubsDir;
  }
  
  protected boolean validate(final List<Resource> sourceResources) {
    final ArrayList<Issue> allIssues = CollectionLiterals.<Issue>newArrayList();
    for (final Resource resource : sourceResources) {
      {
        URI _uRI = resource.getURI();
        LanguageAccess _languageAccess = this.languageAccess(_uRI);
        final IResourceValidator resourceValidator = _languageAccess.getResourceValidator();
        final List<Issue> validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
        allIssues.addAll(validationResult);
      }
    }
    return this.issueHandler.handleIssue(allIssues);
  }
  
  protected void generate(final List<Resource> sourceResources) {
    for (final Resource it : sourceResources) {
      {
        URI _uRI = it.getURI();
        String _lastSegment = _uRI.lastSegment();
        String _plus = ("Starting generator for input: \'" + _lastSegment);
        String _plus_1 = (_plus + "\'");
        StandaloneBuilder.LOG.info(_plus_1);
        URI _uRI_1 = it.getURI();
        this.registerCurrentSource(_uRI_1);
        URI _uRI_2 = it.getURI();
        final LanguageAccess access = this.languageAccess(_uRI_2);
        IGenerator _generator = access.getGenerator();
        JavaIoFileSystemAccess _fileSystemAccess = access.getFileSystemAccess();
        _generator.doGenerate(it, _fileSystemAccess);
      }
    }
  }
  
  protected void registerCurrentSource(final URI uri) {
    LanguageAccess _languageAccess = this.languageAccess(uri);
    final JavaIoFileSystemAccess fsa = _languageAccess.getFileSystemAccess();
    Iterable<String> _sourceDirs = this.getSourceDirs();
    final Function1<String, String> _function = new Function1<String, String>() {
      public String apply(final String it) {
        File _file = new File(it);
        String _absolutePath = _file.getAbsolutePath();
        URI _createFileURI = URI.createFileURI(_absolutePath);
        return _createFileURI.toString();
      }
    };
    Iterable<String> _map = IterableExtensions.<String, String>map(_sourceDirs, _function);
    final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        String _string = uri.toString();
        return Boolean.valueOf(_string.startsWith(it));
      }
    };
    Iterable<String> _filter = IterableExtensions.<String>filter(_map, _function_1);
    final Function2<String, String, String> _function_2 = new Function2<String, String, String>() {
      public String apply(final String longest, final String current) {
        String _xifexpression = null;
        int _length = current.length();
        int _length_1 = longest.length();
        boolean _greaterThan = (_length > _length_1);
        if (_greaterThan) {
          _xifexpression = current;
        } else {
          _xifexpression = longest;
        }
        return _xifexpression;
      }
    };
    String _reduce = IterableExtensions.<String>reduce(_filter, _function_2);
    URI _createFileURI = null;
    if (_reduce!=null) {
      _createFileURI=URI.createFileURI(_reduce);
    }
    final URI absoluteSource = _createFileURI;
    boolean _equals = Objects.equal(absoluteSource, null);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Resource ");
      _builder.append(uri, "");
      _builder.append(" is not contained in any of the known source folders ");
      Iterable<String> _sourceDirs_1 = this.getSourceDirs();
      _builder.append(_sourceDirs_1, "");
      _builder.append(".");
      throw new IllegalStateException(_builder.toString());
    }
    Map<String, OutputConfiguration> _outputConfigurations = fsa.getOutputConfigurations();
    Collection<OutputConfiguration> _values = _outputConfigurations.values();
    for (final OutputConfiguration output : _values) {
      Set<String> _sourceFolders = output.getSourceFolders();
      for (final String relativeSource : _sourceFolders) {
        String _string = absoluteSource.toString();
        boolean _endsWith = _string.endsWith(relativeSource);
        if (_endsWith) {
          fsa.setCurrentSource(relativeSource);
        }
      }
    }
  }
  
  private LanguageAccess languageAccess(final URI uri) {
    Map<String, LanguageAccess> _languages = this.getLanguages();
    String _fileExtension = uri.fileExtension();
    return _languages.get(_fileExtension);
  }
  
  protected File createTempDir(final String subDir) {
    try {
      File _tempDir = this.getTempDir();
      final File file = new File(_tempDir, subDir);
      boolean _and = false;
      boolean _mkdirs = file.mkdirs();
      boolean _not = (!_mkdirs);
      if (!_not) {
        _and = false;
      } else {
        boolean _exists = file.exists();
        boolean _not_1 = (!_exists);
        _and = _not_1;
      }
      if (_and) {
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
    new ClasspathTypeProvider(classLoader, resSet, typeAccess);
    resSet.setClasspathURIContext(classLoader);
  }
  
  private URLClassLoader createURLClassLoader(final Iterable<String> classPathEntries) {
    final Function1<String, URL> _function = new Function1<String, URL>() {
      public URL apply(final String str) {
        try {
          File _file = new File(str);
          java.net.URI _uRI = _file.toURI();
          return _uRI.toURL();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    final Iterable<URL> classPathUrls = IterableExtensions.<String, URL>map(classPathEntries, _function);
    return new URLClassLoader(((URL[])Conversions.unwrapArray(classPathUrls, URL.class)));
  }
  
  protected List<URI> collectResources(final Iterable<String> roots, final ResourceSet resourceSet) {
    Map<String, LanguageAccess> _languages = this.getLanguages();
    Set<String> _keySet = _languages.keySet();
    final String extensions = IterableExtensions.join(_keySet, "|");
    final NameBasedFilter nameBasedFilter = new NameBasedFilter();
    nameBasedFilter.setRegularExpression(((".*\\.(?:(" + extensions) + "))$"));
    final List<URI> resources = CollectionLiterals.<URI>newArrayList();
    PathTraverser _pathTraverser = new PathTraverser();
    List<String> _list = IterableExtensions.<String>toList(roots);
    final Predicate<URI> _function = new Predicate<URI>() {
      public boolean apply(final URI input) {
        final boolean matches = nameBasedFilter.matches(input);
        if (matches) {
          StandaloneBuilder.LOG.debug((("Adding file \'" + input) + "\'"));
          resources.add(input);
        }
        return matches;
      }
    };
    final Multimap<String, URI> modelsFound = _pathTraverser.resolvePathes(_list, _function);
    Map<String, Collection<URI>> _asMap = modelsFound.asMap();
    final Procedure2<String, Collection<URI>> _function_1 = new Procedure2<String, Collection<URI>>() {
      public void apply(final String uri, final Collection<URI> resource) {
        final File file = new File(uri);
        boolean _and = false;
        boolean _and_1 = false;
        boolean _notEquals = (!Objects.equal(resource, null));
        if (!_notEquals) {
          _and_1 = false;
        } else {
          boolean _isDirectory = file.isDirectory();
          boolean _not = (!_isDirectory);
          _and_1 = _not;
        }
        if (!_and_1) {
          _and = false;
        } else {
          String _name = file.getName();
          boolean _endsWith = _name.endsWith(".jar");
          _and = _endsWith;
        }
        if (_and) {
          StandaloneBuilder.this.registerBundle(file);
        }
      }
    };
    MapExtensions.<String, Collection<URI>>forEach(_asMap, _function_1);
    return resources;
  }
  
  protected void registerBundle(final File file) {
    JarFile jarFile = null;
    try {
      JarFile _jarFile = new JarFile(file);
      jarFile = _jarFile;
      final Manifest manifest = jarFile.getManifest();
      boolean _equals = Objects.equal(manifest, null);
      if (_equals) {
        return;
      }
      Attributes _mainAttributes = manifest.getMainAttributes();
      String name = _mainAttributes.getValue("Bundle-SymbolicName");
      boolean _notEquals = (!Objects.equal(name, null));
      if (_notEquals) {
        final int indexOf = name.indexOf(";");
        if ((indexOf > 0)) {
          String _substring = name.substring(0, indexOf);
          name = _substring;
        }
        Map<String, URI> _platformResourceMap = EcorePlugin.getPlatformResourceMap();
        boolean _containsKey = _platformResourceMap.containsKey(name);
        if (_containsKey) {
          return;
        }
        java.net.URI _uRI = file.toURI();
        String _plus = ("archive:" + _uRI);
        final String path = (_plus + "!/");
        final URI uri = URI.createURI(path);
        Map<String, URI> _platformResourceMap_1 = EcorePlugin.getPlatformResourceMap();
        _platformResourceMap_1.put(name, uri);
      }
    } catch (final Throwable _t) {
      if (_t instanceof ZipException) {
        final ZipException e = (ZipException)_t;
        String _absolutePath = file.getAbsolutePath();
        String _plus_1 = ("Could not open Jar file " + _absolutePath);
        String _plus_2 = (_plus_1 + ".");
        StandaloneBuilder.LOG.debug(_plus_2);
      } else if (_t instanceof Exception) {
        final Exception e_1 = (Exception)_t;
        String _absolutePath_1 = file.getAbsolutePath();
        StandaloneBuilder.LOG.error(_absolutePath_1, e_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      try {
        boolean _notEquals_1 = (!Objects.equal(jarFile, null));
        if (_notEquals_1) {
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
      EList<Resource> _resources = resourceSet.getResources();
      _resources.clear();
    } finally {
      resourceSet.eSetDeliver(wasDeliver);
    }
  }
  
  @Pure
  public Map<String, LanguageAccess> getLanguages() {
    return this._languages;
  }
  
  public void setLanguages(final Map<String, LanguageAccess> languages) {
    this._languages = languages;
  }
  
  @Pure
  public Iterable<String> getSourceDirs() {
    return this._sourceDirs;
  }
  
  public void setSourceDirs(final Iterable<String> sourceDirs) {
    this._sourceDirs = sourceDirs;
  }
  
  @Pure
  public Iterable<String> getClassPathEntries() {
    return this._classPathEntries;
  }
  
  public void setClassPathEntries(final Iterable<String> classPathEntries) {
    this._classPathEntries = classPathEntries;
  }
  
  @Pure
  public File getTempDir() {
    return this._tempDir;
  }
  
  public void setTempDir(final File tempDir) {
    this._tempDir = tempDir;
  }
  
  @Pure
  public String getEncoding() {
    return this._encoding;
  }
  
  public void setEncoding(final String encoding) {
    this._encoding = encoding;
  }
  
  @Pure
  public String getClassPathLookUpFilter() {
    return this._classPathLookUpFilter;
  }
  
  public void setClassPathLookUpFilter(final String classPathLookUpFilter) {
    this._classPathLookUpFilter = classPathLookUpFilter;
  }
  
  @Pure
  public boolean isFailOnValidationError() {
    return this._failOnValidationError;
  }
  
  public void setFailOnValidationError(final boolean failOnValidationError) {
    this._failOnValidationError = failOnValidationError;
  }
  
  @Pure
  public ClusteringConfig getClusteringConfig() {
    return this._clusteringConfig;
  }
  
  public void setClusteringConfig(final ClusteringConfig clusteringConfig) {
    this._clusteringConfig = clusteringConfig;
  }
}

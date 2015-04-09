/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.standalone.ClusteringConfig;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.builder.standalone.incremental.BuildContext;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.Indexer;
import org.eclipse.xtext.builder.standalone.incremental.IndexerResult;
import org.eclipse.xtext.builder.standalone.incremental.JavaSupport;
import org.eclipse.xtext.builder.standalone.incremental.ResourceSetClearer;
import org.eclipse.xtext.common.types.descriptions.IStubGenerator;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
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
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@Accessors(AccessorType.PROTECTED_GETTER)
@SuppressWarnings("all")
public class IncrementalStandaloneBuilder {
  public static class Factory {
    @Inject
    private Provider<IncrementalStandaloneBuilder> provider;
    
    @Inject
    private Provider<XtextResourceSet> resourceSetProvider;
    
    public IncrementalStandaloneBuilder create(final BuildRequest request, final Map<String, LanguageAccess> languages) {
      return this.create(request, languages, null);
    }
    
    public IncrementalStandaloneBuilder create(final BuildRequest request, final Map<String, LanguageAccess> languages, final ClusteringConfig clusteringConfig) {
      IncrementalStandaloneBuilder _xblockexpression = null;
      {
        IResourceClusteringPolicy _xifexpression = null;
        boolean _notEquals = (!Objects.equal(clusteringConfig, null));
        if (_notEquals) {
          DynamicResourceClusteringPolicy _xblockexpression_1 = null;
          {
            IncrementalStandaloneBuilder.LOG.info("Clustering configured.");
            DynamicResourceClusteringPolicy _dynamicResourceClusteringPolicy = new DynamicResourceClusteringPolicy();
            final Procedure1<DynamicResourceClusteringPolicy> _function = new Procedure1<DynamicResourceClusteringPolicy>() {
              @Override
              public void apply(final DynamicResourceClusteringPolicy it) {
                long _minimumFreeMemory = clusteringConfig.getMinimumFreeMemory();
                long _multiply = (_minimumFreeMemory * 1024);
                long _multiply_1 = (_multiply * 1024);
                it.setMinimumFreeMemory(_multiply_1);
                int _minimumClusterSize = clusteringConfig.getMinimumClusterSize();
                it.setMinimumClusterSize(_minimumClusterSize);
                long _minimumPercentFreeMemory = clusteringConfig.getMinimumPercentFreeMemory();
                it.setMinimumPercentFreeMemory(_minimumPercentFreeMemory);
              }
            };
            _xblockexpression_1 = ObjectExtensions.<DynamicResourceClusteringPolicy>operator_doubleArrow(_dynamicResourceClusteringPolicy, _function);
          }
          _xifexpression = _xblockexpression_1;
        } else {
          _xifexpression = new DisabledClusteringPolicy();
        }
        final IResourceClusteringPolicy strategy = _xifexpression;
        Collection<LanguageAccess> _values = languages.values();
        final Function1<LanguageAccess, Boolean> _function = new Function1<LanguageAccess, Boolean>() {
          @Override
          public Boolean apply(final LanguageAccess it) {
            return Boolean.valueOf(it.isLinksAgainstJava());
          }
        };
        final boolean needsJava = IterableExtensions.<LanguageAccess>exists(_values, _function);
        XtextResourceSet _get = this.resourceSetProvider.get();
        final BuildContext context = new BuildContext(languages, needsJava, _get, strategy);
        final IncrementalStandaloneBuilder builder = this.provider.get();
        builder.setContext(context);
        builder.setRequest(request);
        _xblockexpression = builder;
      }
      return _xblockexpression;
    }
  }
  
  private final static Logger LOG = Logger.getLogger(IncrementalStandaloneBuilder.class);
  
  @Accessors({ AccessorType.PROTECTED_SETTER, AccessorType.PROTECTED_GETTER })
  private BuildContext context;
  
  @Accessors({ AccessorType.PROTECTED_SETTER, AccessorType.PROTECTED_GETTER })
  private BuildRequest request;
  
  private File baseDir;
  
  @Inject
  private Indexer indexer;
  
  @Inject
  private AbstractFileSystemAccess commonFileAccess;
  
  @Inject
  private IIssueHandler issueHandler;
  
  @Inject
  private IJavaCompiler compiler;
  
  @Inject
  private JavaSupport javaSupport;
  
  @Inject
  @Extension
  private ResourceSetClearer _resourceSetClearer;
  
  protected IncrementalStandaloneBuilder() {
  }
  
  public boolean launch() {
    File _elvis = null;
    File _baseDir = this.request.getBaseDir();
    if (_baseDir != null) {
      _elvis = _baseDir;
    } else {
      File _xblockexpression = null;
      {
        final String userDir = System.getProperty("user.dir");
        IncrementalStandaloneBuilder.LOG.warn((("Property baseDir not set. Using \'" + userDir) + "\'"));
        _xblockexpression = new File(userDir);
      }
      _elvis = _xblockexpression;
    }
    this.baseDir = _elvis;
    boolean _isNeedsJava = this.context.isNeedsJava();
    if (_isNeedsJava) {
      IncrementalStandaloneBuilder.LOG.info("Using common types.");
    }
    final XtextResourceSet resourceSet = this.context.getResourceSet();
    String _defaultEncoding = this.request.getDefaultEncoding();
    boolean _notEquals = (!Objects.equal(_defaultEncoding, null));
    if (_notEquals) {
      IncrementalStandaloneBuilder.LOG.info("Setting encoding.");
      Map<String, LanguageAccess> _languages = this.context.getLanguages();
      Collection<LanguageAccess> _values = _languages.values();
      String _defaultEncoding_1 = this.request.getDefaultEncoding();
      this.fileEncodingSetup(_values, _defaultEncoding_1);
    }
    final IndexerResult indexerResult = this.indexer.computeAffected(this.request, this.context);
    boolean _isNeedsJava_1 = this.context.isNeedsJava();
    if (_isNeedsJava_1) {
      File _generateStubs = this.generateStubs(indexerResult);
      final File stubsClasses = this.compileStubs(_generateStubs);
      IncrementalStandaloneBuilder.LOG.info("Installing type provider for stubs.");
      List<File> _sourceRoots = this.request.getSourceRoots();
      List<File> _classPath = this.request.getClassPath();
      Iterable<File> _plus = Iterables.<File>concat(_sourceRoots, _classPath);
      ArrayList<File> _newArrayList = CollectionLiterals.<File>newArrayList(stubsClasses);
      Iterable<File> _plus_1 = Iterables.<File>concat(_plus, _newArrayList);
      this.javaSupport.installTypeProvider(_plus_1, resourceSet);
    }
    IncrementalStandaloneBuilder.LOG.info("Validate and generate.");
    List<URI> _changedResources = indexerResult.getChangedResources();
    final Iterator<URI> sourceResourceIterator = _changedResources.iterator();
    boolean isErrorFree = true;
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
            boolean _validate = this.validate(resource);
            isErrorFree = _validate;
            clusterIndex++;
            IResourceClusteringPolicy _clusteringPolicy = this.context.getClusteringPolicy();
            boolean _continueProcessing = _clusteringPolicy.continueProcessing(resourceSet, null, clusterIndex);
            boolean _not = (!_continueProcessing);
            if (_not) {
              continue_ = false;
            }
          }
        }
        boolean _and = false;
        boolean _isFailOnValidationError = this.request.isFailOnValidationError();
        if (!_isFailOnValidationError) {
          _and = false;
        } else {
          _and = (!isErrorFree);
        }
        if (_and) {
          return isErrorFree;
        }
        this.generate(resources);
        if ((!continue_)) {
          this._resourceSetClearer.clearResourceSet(resourceSet);
        }
      }
    }
    return isErrorFree;
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
        IncrementalStandaloneBuilder.LOG.info((((("Couldn\'t set encoding \'" + encoding) + "\' for provider \'") + provider) + 
          "\'. Only subclasses of IEncodingProvider.Runtime are supported."));
      }
    }
  }
  
  protected File compileStubs(final File stubsDir) {
    final File stubsClassesFolder = this.createTempDir("classes");
    List<File> _classPath = this.request.getClassPath();
    final Function1<File, String> _function = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        return it.getAbsolutePath();
      }
    };
    List<String> _map = ListExtensions.<File, String>map(_classPath, _function);
    this.compiler.setClassPath(_map);
    String _absolutePath = stubsDir.getAbsolutePath();
    String _plus = ("Compiling stubs located in " + _absolutePath);
    IncrementalStandaloneBuilder.LOG.info(_plus);
    List<File> _sourceRoots = this.request.getSourceRoots();
    final Function1<File, String> _function_1 = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        return it.getAbsolutePath();
      }
    };
    List<String> _map_1 = ListExtensions.<File, String>map(_sourceRoots, _function_1);
    String _absolutePath_1 = stubsDir.getAbsolutePath();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(_absolutePath_1);
    Iterable<String> _plus_1 = Iterables.<String>concat(_map_1, _newArrayList);
    final Set<String> sourcesToCompile = this.uniqueEntries(_plus_1);
    String _join = IterableExtensions.join(sourcesToCompile, ",");
    String _plus_2 = ("Compiler source roots: " + _join);
    IncrementalStandaloneBuilder.LOG.info(_plus_2);
    final IJavaCompiler.CompilationResult result = this.compiler.compile(sourcesToCompile, stubsClassesFolder);
    if (result != null) {
      switch (result) {
        case SKIPPED:
          IncrementalStandaloneBuilder.LOG.info("Nothing to compile. Stubs compilation was skipped.");
          break;
        case FAILED:
          IncrementalStandaloneBuilder.LOG.info("Stubs compilation finished with errors.");
          break;
        case SUCCEEDED:
          IncrementalStandaloneBuilder.LOG.info("Stubs compilation successfully finished.");
          break;
        default:
          break;
      }
    }
    return stubsClassesFolder;
  }
  
  protected Set<String> uniqueEntries(final Iterable<String> pathes) {
    final Function1<String, String> _function = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        File _file = new File(it);
        return _file.getAbsolutePath();
      }
    };
    Iterable<String> _map = IterableExtensions.<String, String>map(pathes, _function);
    return IterableExtensions.<String>toSet(_map);
  }
  
  protected File generateStubs(final IndexerResult result) {
    final File stubsDir = this.createTempDir("stubs");
    String _absolutePath = stubsDir.getAbsolutePath();
    String _plus = ("Generating stubs into " + _absolutePath);
    IncrementalStandaloneBuilder.LOG.info(_plus);
    String _absolutePath_1 = stubsDir.getAbsolutePath();
    this.commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, _absolutePath_1);
    List<URI> _changedResources = result.getChangedResources();
    final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
      @Override
      public Boolean apply(final URI it) {
        LanguageAccess _languageAccess = IncrementalStandaloneBuilder.this.languageAccess(it);
        return Boolean.valueOf(_languageAccess.isLinksAgainstJava());
      }
    };
    final Iterable<URI> generateStubs = IterableExtensions.<URI>filter(_changedResources, _function);
    final Procedure1<URI> _function_1 = new Procedure1<URI>() {
      @Override
      public void apply(final URI it) {
        LanguageAccess _languageAccess = IncrementalStandaloneBuilder.this.languageAccess(it);
        IStubGenerator _stubGenerator = _languageAccess.getStubGenerator();
        ResourceDescriptionsData _newIndex = result.getNewIndex();
        IResourceDescription _resourceDescription = _newIndex.getResourceDescription(it);
        _stubGenerator.doGenerateStubs(IncrementalStandaloneBuilder.this.commonFileAccess, _resourceDescription);
      }
    };
    IterableExtensions.<URI>forEach(generateStubs, _function_1);
    return stubsDir;
  }
  
  protected boolean validate(final Resource resource) {
    URI _uRI = resource.getURI();
    String _lastSegment = _uRI.lastSegment();
    String _plus = ("Starting validation for input: \'" + _lastSegment);
    String _plus_1 = (_plus + "\'");
    IncrementalStandaloneBuilder.LOG.info(_plus_1);
    URI _uRI_1 = resource.getURI();
    LanguageAccess _languageAccess = this.languageAccess(_uRI_1);
    final IResourceValidator resourceValidator = _languageAccess.getResourceValidator();
    final List<Issue> validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
    return this.issueHandler.handleIssue(validationResult);
  }
  
  protected void generate(final List<Resource> sourceResources) {
    for (final Resource it : sourceResources) {
      {
        URI _uRI = it.getURI();
        String _lastSegment = _uRI.lastSegment();
        String _plus = ("Starting generator for input: \'" + _lastSegment);
        String _plus_1 = (_plus + "\'");
        IncrementalStandaloneBuilder.LOG.info(_plus_1);
        URI _uRI_1 = it.getURI();
        this.registerCurrentSource(_uRI_1);
        URI _uRI_2 = it.getURI();
        final LanguageAccess access = this.languageAccess(_uRI_2);
        final JavaIoFileSystemAccess fileSystemAccess = this.getFileSystemAccess(access);
        boolean _isWriteStorageResources = this.request.isWriteStorageResources();
        if (_isWriteStorageResources) {
          boolean _matched = false;
          if (!_matched) {
            if (it instanceof StorageAwareResource) {
              IResourceStorageFacade _resourceStorageFacade = ((StorageAwareResource)it).getResourceStorageFacade();
              boolean _notEquals = (!Objects.equal(_resourceStorageFacade, null));
              if (_notEquals) {
                _matched=true;
                IResourceStorageFacade _resourceStorageFacade_1 = ((StorageAwareResource)it).getResourceStorageFacade();
                _resourceStorageFacade_1.saveResource(((StorageAwareResource)it), fileSystemAccess);
              }
            }
          }
        }
        IGenerator _generator = access.getGenerator();
        _generator.doGenerate(it, fileSystemAccess);
      }
    }
  }
  
  protected void registerCurrentSource(final URI uri) {
    LanguageAccess _languageAccess = this.languageAccess(uri);
    final JavaIoFileSystemAccess fsa = this.getFileSystemAccess(_languageAccess);
    List<File> _sourceRoots = this.request.getSourceRoots();
    final Function1<File, String> _function = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        String _absolutePath = it.getAbsolutePath();
        URI _createFileURI = URI.createFileURI(_absolutePath);
        return _createFileURI.toString();
      }
    };
    List<String> _map = ListExtensions.<File, String>map(_sourceRoots, _function);
    final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        String _string = uri.toString();
        return Boolean.valueOf(_string.startsWith(it));
      }
    };
    Iterable<String> _filter = IterableExtensions.<String>filter(_map, _function_1);
    final Function2<String, String, String> _function_2 = new Function2<String, String, String>() {
      @Override
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
      List<File> _sourceRoots_1 = this.request.getSourceRoots();
      _builder.append(_sourceRoots_1, "");
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
  
  private Map<LanguageAccess, JavaIoFileSystemAccess> configuredFsas = CollectionLiterals.<LanguageAccess, JavaIoFileSystemAccess>newHashMap();
  
  private JavaIoFileSystemAccess getFileSystemAccess(final LanguageAccess language) {
    JavaIoFileSystemAccess fsa = this.configuredFsas.get(language);
    boolean _equals = Objects.equal(fsa, null);
    if (_equals) {
      JavaIoFileSystemAccess _createFileSystemAccess = language.createFileSystemAccess(this.baseDir);
      fsa = _createFileSystemAccess;
      JavaIoFileSystemAccess _configureFileSystemAccess = this.configureFileSystemAccess(fsa, language);
      fsa = _configureFileSystemAccess;
      this.configuredFsas.put(language, fsa);
    }
    return fsa;
  }
  
  protected JavaIoFileSystemAccess configureFileSystemAccess(final JavaIoFileSystemAccess fsa, final LanguageAccess language) {
    return fsa;
  }
  
  private LanguageAccess languageAccess(final URI uri) {
    Map<String, LanguageAccess> _languages = this.context.getLanguages();
    String _fileExtension = uri.fileExtension();
    return _languages.get(_fileExtension);
  }
  
  protected File createTempDir(final String subDir) {
    try {
      File _tempDir = this.request.getTempDir();
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
  
  @Pure
  protected BuildContext getContext() {
    return this.context;
  }
  
  protected void setContext(final BuildContext context) {
    this.context = context;
  }
  
  @Pure
  protected BuildRequest getRequest() {
    return this.request;
  }
  
  protected void setRequest(final BuildRequest request) {
    this.request = request;
  }
  
  @Pure
  protected File getBaseDir() {
    return this.baseDir;
  }
  
  @Pure
  protected Indexer getIndexer() {
    return this.indexer;
  }
  
  @Pure
  protected AbstractFileSystemAccess getCommonFileAccess() {
    return this.commonFileAccess;
  }
  
  @Pure
  protected IIssueHandler getIssueHandler() {
    return this.issueHandler;
  }
  
  @Pure
  protected IJavaCompiler getCompiler() {
    return this.compiler;
  }
  
  @Pure
  protected JavaSupport getJavaSupport() {
    return this.javaSupport;
  }
  
  @Pure
  protected ResourceSetClearer get_resourceSetClearer() {
    return this._resourceSetClearer;
  }
  
  @Pure
  protected Map<LanguageAccess, JavaIoFileSystemAccess> getConfiguredFsas() {
    return this.configuredFsas;
  }
}

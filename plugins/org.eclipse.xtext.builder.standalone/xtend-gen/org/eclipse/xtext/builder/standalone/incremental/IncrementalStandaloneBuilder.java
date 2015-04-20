/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.util.Collection;
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
import org.eclipse.xtext.builder.standalone.incremental.BuildContext;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.Indexer;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy;
import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
        builder.context = context;
        builder.request = request;
        _xblockexpression = builder;
      }
      return _xblockexpression;
    }
  }
  
  private final static Logger LOG = Logger.getLogger(IncrementalStandaloneBuilder.class);
  
  @Accessors({ AccessorType.PROTECTED_SETTER, AccessorType.PROTECTED_GETTER })
  @Extension
  private BuildContext context;
  
  @Accessors({ AccessorType.PROTECTED_SETTER, AccessorType.PROTECTED_GETTER })
  private BuildRequest request;
  
  private File baseDir;
  
  @Inject
  private Indexer indexer;
  
  @Inject
  private IIssueHandler issueHandler;
  
  protected IncrementalStandaloneBuilder() {
  }
  
  public Boolean launch() {
    this.initialize();
    final Iterable<URI> affectedResources = this.indexer.computeAndIndexAffected(this.request, this.context);
    final Function1<Resource, Boolean> _function = new Function1<Resource, Boolean>() {
      @Override
      public Boolean apply(final Resource resource) {
        resource.getContents();
        EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
        boolean _validate = IncrementalStandaloneBuilder.this.validate(resource);
        if (_validate) {
          IncrementalStandaloneBuilder.this.generate(resource);
          return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
      }
    };
    Iterable<Boolean> _executeClustered = this.context.<Boolean>executeClustered(affectedResources, _function);
    final Function2<Boolean, Boolean, Boolean> _function_1 = new Function2<Boolean, Boolean, Boolean>() {
      @Override
      public Boolean apply(final Boolean $0, final Boolean $1) {
        boolean _and = false;
        if (!($0).booleanValue()) {
          _and = false;
        } else {
          _and = ($1).booleanValue();
        }
        return Boolean.valueOf(_and);
      }
    };
    final Boolean isErrorFree = IterableExtensions.<Boolean>reduce(_executeClustered, _function_1);
    return isErrorFree;
  }
  
  protected void initialize() {
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
    String _defaultEncoding = this.request.getDefaultEncoding();
    boolean _notEquals = (!Objects.equal(_defaultEncoding, null));
    if (_notEquals) {
      IncrementalStandaloneBuilder.LOG.info("Setting encoding.");
      Map<String, LanguageAccess> _languages = this.context.getLanguages();
      Collection<LanguageAccess> _values = _languages.values();
      for (final LanguageAccess lang : _values) {
        IEncodingProvider _encodingProvider = lang.getEncodingProvider();
        final IEncodingProvider provider = _encodingProvider;
        boolean _matched = false;
        if (!_matched) {
          if (provider instanceof IEncodingProvider.Runtime) {
            _matched=true;
            String _defaultEncoding_1 = this.request.getDefaultEncoding();
            ((IEncodingProvider.Runtime)provider).setDefaultEncoding(_defaultEncoding_1);
          }
        }
        if (!_matched) {
          String _defaultEncoding_1 = this.request.getDefaultEncoding();
          String _plus = ("Couldn\'t set encoding \'" + _defaultEncoding_1);
          String _plus_1 = (_plus + "\' for provider \'");
          String _plus_2 = (_plus_1 + provider);
          String _plus_3 = (_plus_2 + 
            "\'. Only subclasses of IEncodingProvider.Runtime are supported.");
          IncrementalStandaloneBuilder.LOG.info(_plus_3);
        }
      }
    }
  }
  
  protected boolean validate(final Resource resource) {
    URI _uRI = resource.getURI();
    String _lastSegment = _uRI.lastSegment();
    String _plus = ("Starting validation for input: \'" + _lastSegment);
    String _plus_1 = (_plus + "\'");
    IncrementalStandaloneBuilder.LOG.info(_plus_1);
    URI _uRI_1 = resource.getURI();
    LanguageAccess _languageAccess = this.context.getLanguageAccess(_uRI_1);
    final IResourceValidator resourceValidator = _languageAccess.getResourceValidator();
    final List<Issue> validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
    return this.issueHandler.handleIssue(validationResult);
  }
  
  protected void generate(final Resource resource) {
    URI _uRI = resource.getURI();
    String _lastSegment = _uRI.lastSegment();
    String _plus = ("Starting generator for input: \'" + _lastSegment);
    String _plus_1 = (_plus + "\'");
    IncrementalStandaloneBuilder.LOG.info(_plus_1);
    URI _uRI_1 = resource.getURI();
    this.registerCurrentSource(_uRI_1);
    URI _uRI_2 = resource.getURI();
    final LanguageAccess access = this.context.getLanguageAccess(_uRI_2);
    final JavaIoFileSystemAccess fileSystemAccess = this.getFileSystemAccess(access);
    boolean _isWriteStorageResources = this.request.isWriteStorageResources();
    if (_isWriteStorageResources) {
      boolean _matched = false;
      if (!_matched) {
        if (resource instanceof StorageAwareResource) {
          IResourceStorageFacade _resourceStorageFacade = ((StorageAwareResource)resource).getResourceStorageFacade();
          boolean _notEquals = (!Objects.equal(_resourceStorageFacade, null));
          if (_notEquals) {
            _matched=true;
            IResourceStorageFacade _resourceStorageFacade_1 = ((StorageAwareResource)resource).getResourceStorageFacade();
            _resourceStorageFacade_1.saveResource(((StorageAwareResource)resource), fileSystemAccess);
          }
        }
      }
    }
    IGenerator _generator = access.getGenerator();
    _generator.doGenerate(resource, fileSystemAccess);
  }
  
  protected void registerCurrentSource(final URI uri) {
    LanguageAccess _languageAccess = this.context.getLanguageAccess(uri);
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
  
  protected JavaIoFileSystemAccess getFileSystemAccess(final LanguageAccess language) {
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
  protected IIssueHandler getIssueHandler() {
    return this.issueHandler;
  }
  
  @Pure
  protected Map<LanguageAccess, JavaIoFileSystemAccess> getConfiguredFsas() {
    return this.configuredFsas;
  }
}

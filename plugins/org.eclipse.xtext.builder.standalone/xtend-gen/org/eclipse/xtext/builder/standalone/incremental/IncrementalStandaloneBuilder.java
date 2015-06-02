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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.standalone.ClusteringConfig;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.BuildContext;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.builder.standalone.incremental.IndexState;
import org.eclipse.xtext.builder.standalone.incremental.Indexer;
import org.eclipse.xtext.builder.standalone.incremental.Source2GeneratedMapping;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy;
import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public class IncrementalStandaloneBuilder {
  protected static class InternalStatefulIncrementalBuilder {
    @Accessors(AccessorType.PROTECTED_SETTER)
    @Extension
    private BuildContext context;
    
    @Accessors(AccessorType.PROTECTED_SETTER)
    private BuildRequest request;
    
    @Inject
    private Indexer indexer;
    
    public IndexState launch() {
      this.initialize();
      this.cleanup();
      IndexState _previousState = this.request.getPreviousState();
      Source2GeneratedMapping _fileMappings = _previousState.getFileMappings();
      final Source2GeneratedMapping newSource2GeneratedMapping = _fileMappings.copy();
      List<URI> _deletedFiles = this.request.getDeletedFiles();
      final Procedure1<URI> _function = new Procedure1<URI>() {
        @Override
        public void apply(final URI it) {
          Set<URI> _deleteSource = newSource2GeneratedMapping.deleteSource(it);
          final Procedure1<URI> _function = new Procedure1<URI>() {
            @Override
            public void apply(final URI it) {
              IncrementalStandaloneBuilder.LOG.info(("Deleting " + it));
              File _asFile = FilesAndURIs.asFile(it);
              _asFile.delete();
              Procedure1<? super URI> _afterDeleteFile = InternalStatefulIncrementalBuilder.this.request.getAfterDeleteFile();
              _afterDeleteFile.apply(it);
            }
          };
          IterableExtensions.<URI>forEach(_deleteSource, _function);
        }
      };
      IterableExtensions.<URI>forEach(_deletedFiles, _function);
      final Indexer.IndexResult result = this.indexer.computeAndIndexAffected(this.request, this.context);
      Set<URI> _affectedResources = result.getAffectedResources();
      final Function1<Resource, Boolean> _function_1 = new Function1<Resource, Boolean>() {
        @Override
        public Boolean apply(final Resource resource) {
          resource.getContents();
          EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
          boolean _validate = InternalStatefulIncrementalBuilder.this.validate(resource);
          if (_validate) {
            InternalStatefulIncrementalBuilder.this.generate(resource, InternalStatefulIncrementalBuilder.this.request, newSource2GeneratedMapping);
            return Boolean.valueOf(true);
          }
          return Boolean.valueOf(false);
        }
      };
      this.context.<Boolean>executeClustered(_affectedResources, _function_1);
      ResourceDescriptionsData _newIndex = result.getNewIndex();
      return new IndexState(_newIndex, newSource2GeneratedMapping);
    }
    
    protected void initialize() {
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
    
    protected boolean cleanup() {
      try {
        boolean _xifexpression = false;
        File _tempDir = this.context.getTempDir();
        boolean _exists = _tempDir.exists();
        if (_exists) {
          boolean _xblockexpression = false;
          {
            File _tempDir_1 = this.context.getTempDir();
            String _plus = ("Removing temp folder " + _tempDir_1);
            IncrementalStandaloneBuilder.LOG.info(_plus);
            File _tempDir_2 = this.context.getTempDir();
            Files.sweepFolder(_tempDir_2);
            File _tempDir_3 = this.context.getTempDir();
            _xblockexpression = _tempDir_3.delete();
          }
          _xifexpression = _xblockexpression;
        }
        return _xifexpression;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
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
      IIssueHandler _issueHandler = this.request.getIssueHandler();
      return _issueHandler.handleIssue(validationResult);
    }
    
    protected void generate(final Resource resource, final BuildRequest request, final Source2GeneratedMapping newMappings) {
      URI _uRI = resource.getURI();
      String _lastSegment = _uRI.lastSegment();
      String _plus = ("Starting generator for input: \'" + _lastSegment);
      String _plus_1 = (_plus + "\'");
      IncrementalStandaloneBuilder.LOG.info(_plus_1);
      URI _uRI_1 = resource.getURI();
      final LanguageAccess access = this.context.getLanguageAccess(_uRI_1);
      URI _uRI_2 = resource.getURI();
      final Set<URI> previous = newMappings.deleteSource(_uRI_2);
      final JavaIoFileSystemAccess fileSystemAccess = this.getFileSystemAccess(access, request);
      fileSystemAccess.setCallBack(new JavaIoFileSystemAccess.IFileCallback() {
        @Override
        public void fileAdded(final File file) {
          final URI uri = FilesAndURIs.asURI(file);
          URI _uRI = resource.getURI();
          newMappings.addSource2Generated(_uRI, uri);
          previous.remove(uri);
          Procedure2<? super URI, ? super URI> _afterGenerateFile = request.getAfterGenerateFile();
          URI _uRI_1 = resource.getURI();
          _afterGenerateFile.apply(_uRI_1, uri);
        }
        
        @Override
        public void fileDeleted(final File file) {
          final URI uri = FilesAndURIs.asURI(file);
          newMappings.deleteGenerated(uri);
          Procedure1<? super URI> _afterDeleteFile = request.getAfterDeleteFile();
          _afterDeleteFile.apply(uri);
        }
      });
      boolean _isWriteStorageResources = request.isWriteStorageResources();
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
      final Procedure1<URI> _function = new Procedure1<URI>() {
        @Override
        public void apply(final URI it) {
          IncrementalStandaloneBuilder.LOG.info(("Deleting stale generated file " + it));
          File _asFile = FilesAndURIs.asFile(it);
          _asFile.delete();
          Procedure1<? super URI> _afterDeleteFile = request.getAfterDeleteFile();
          _afterDeleteFile.apply(it);
        }
      };
      IterableExtensions.<URI>forEach(previous, _function);
    }
    
    private Map<LanguageAccess, JavaIoFileSystemAccess> configuredFsas = CollectionLiterals.<LanguageAccess, JavaIoFileSystemAccess>newHashMap();
    
    protected JavaIoFileSystemAccess getFileSystemAccess(final LanguageAccess language, final BuildRequest request) {
      JavaIoFileSystemAccess fsa = this.configuredFsas.get(language);
      boolean _equals = Objects.equal(fsa, null);
      if (_equals) {
        URI _baseDir = request.getBaseDir();
        File _asFile = FilesAndURIs.asFile(_baseDir);
        JavaIoFileSystemAccess _createFileSystemAccess = language.createFileSystemAccess(_asFile);
        fsa = _createFileSystemAccess;
        this.configuredFsas.put(language, fsa);
      }
      return fsa;
    }
    
    protected void setContext(final BuildContext context) {
      this.context = context;
    }
    
    protected void setRequest(final BuildRequest request) {
      this.request = request;
    }
  }
  
  private final static Logger LOG = Logger.getLogger(IncrementalStandaloneBuilder.class);
  
  @Inject
  private Provider<IncrementalStandaloneBuilder.InternalStatefulIncrementalBuilder> provider;
  
  public IndexState build(final BuildRequest request, final Map<String, LanguageAccess> languages) {
    return this.build(request, languages, null);
  }
  
  public IndexState build(final BuildRequest request, final Map<String, LanguageAccess> languages, final ClusteringConfig clusteringConfig) {
    IResourceClusteringPolicy _xifexpression = null;
    boolean _notEquals = (!Objects.equal(clusteringConfig, null));
    if (_notEquals) {
      DynamicResourceClusteringPolicy _xblockexpression = null;
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
        _xblockexpression = ObjectExtensions.<DynamicResourceClusteringPolicy>operator_doubleArrow(_dynamicResourceClusteringPolicy, _function);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = new DisabledClusteringPolicy();
    }
    final IResourceClusteringPolicy strategy = _xifexpression;
    URI _baseDir = request.getBaseDir();
    File _asFile = FilesAndURIs.asFile(_baseDir);
    final File tempDir = new File(_asFile, "xtext-tmp");
    final XtextResourceSet resourceSet = request.getResourceSet();
    resourceSet.addLoadOption(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE, Boolean.valueOf(true));
    final BuildContext context = new BuildContext(languages, resourceSet, strategy, tempDir);
    final IncrementalStandaloneBuilder.InternalStatefulIncrementalBuilder builder = this.provider.get();
    builder.context = context;
    builder.request = request;
    return builder.launch();
  }
}

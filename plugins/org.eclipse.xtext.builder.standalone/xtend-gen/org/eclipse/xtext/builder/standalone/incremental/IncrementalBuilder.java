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
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.standalone.ClusteringConfig;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.BuildContext;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.IndexState;
import org.eclipse.xtext.builder.standalone.incremental.Indexer;
import org.eclipse.xtext.builder.standalone.incremental.Source2GeneratedMapping;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.URIBasedFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy;
import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.internal.Log;
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
@Log
@SuppressWarnings("all")
public class IncrementalBuilder {
  @Log
  protected static class InternalStatefulIncrementalBuilder {
    @Accessors(AccessorType.PROTECTED_SETTER)
    @Extension
    private BuildContext context;
    
    @Accessors(AccessorType.PROTECTED_SETTER)
    private BuildRequest request;
    
    @Inject
    private Indexer indexer;
    
    public IndexState launch() {
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
              try {
                boolean _isInfoEnabled = IncrementalBuilder.InternalStatefulIncrementalBuilder.LOG.isInfoEnabled();
                if (_isInfoEnabled) {
                  IncrementalBuilder.InternalStatefulIncrementalBuilder.LOG.info(("Deleting " + it));
                }
                XtextResourceSet _resourceSet = InternalStatefulIncrementalBuilder.this.context.getResourceSet();
                URIConverter _uRIConverter = _resourceSet.getURIConverter();
                Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
                _uRIConverter.delete(it, _emptyMap);
                Procedure1<? super URI> _afterDeleteFile = InternalStatefulIncrementalBuilder.this.request.getAfterDeleteFile();
                _afterDeleteFile.apply(it);
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
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
          InternalStatefulIncrementalBuilder.this.validate(resource);
          InternalStatefulIncrementalBuilder.this.generate(resource, InternalStatefulIncrementalBuilder.this.request, newSource2GeneratedMapping);
          return Boolean.valueOf(true);
        }
      };
      this.context.<Boolean>executeClustered(_affectedResources, _function_1);
      ResourceDescriptionsData _newIndex = result.getNewIndex();
      return new IndexState(_newIndex, newSource2GeneratedMapping);
    }
    
    protected boolean validate(final Resource resource) {
      URI _uRI = resource.getURI();
      String _lastSegment = _uRI.lastSegment();
      String _plus = ("Starting validation for input: \'" + _lastSegment);
      String _plus_1 = (_plus + "\'");
      IncrementalBuilder.InternalStatefulIncrementalBuilder.LOG.info(_plus_1);
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
      IncrementalBuilder.InternalStatefulIncrementalBuilder.LOG.info(_plus_1);
      URI _uRI_1 = resource.getURI();
      final LanguageAccess access = this.context.getLanguageAccess(_uRI_1);
      URI _uRI_2 = resource.getURI();
      final Set<URI> previous = newMappings.deleteSource(_uRI_2);
      URI _baseDir = request.getBaseDir();
      URIBasedFileSystemAccess _createUriBasedFileSystemAccess = access.createUriBasedFileSystemAccess(_baseDir);
      final Procedure1<URIBasedFileSystemAccess> _function = new Procedure1<URIBasedFileSystemAccess>() {
        @Override
        public void apply(final URIBasedFileSystemAccess it) {
          ResourceSet _resourceSet = resource.getResourceSet();
          URIConverter _uRIConverter = _resourceSet.getURIConverter();
          it.setConverter(_uRIConverter);
          final URIBasedFileSystemAccess.BeforeWrite _function = new URIBasedFileSystemAccess.BeforeWrite() {
            @Override
            public InputStream beforeWrite(final URI uri, final InputStream contents) {
              URI _uRI = resource.getURI();
              newMappings.addSource2Generated(_uRI, uri);
              previous.remove(uri);
              Procedure2<? super URI, ? super URI> _afterGenerateFile = request.getAfterGenerateFile();
              URI _uRI_1 = resource.getURI();
              _afterGenerateFile.apply(_uRI_1, uri);
              return contents;
            }
          };
          it.setBeforeWrite(_function);
          final URIBasedFileSystemAccess.BeforeDelete _function_1 = new URIBasedFileSystemAccess.BeforeDelete() {
            @Override
            public boolean beforeDelete(final URI uri) {
              newMappings.deleteGenerated(uri);
              Procedure1<? super URI> _afterDeleteFile = request.getAfterDeleteFile();
              _afterDeleteFile.apply(uri);
              return true;
            }
          };
          it.setBeforeDelete(_function_1);
        }
      };
      final URIBasedFileSystemAccess fileSystemAccess = ObjectExtensions.<URIBasedFileSystemAccess>operator_doubleArrow(_createUriBasedFileSystemAccess, _function);
      fileSystemAccess.setContext(resource);
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
      final Procedure1<URI> _function_1 = new Procedure1<URI>() {
        @Override
        public void apply(final URI it) {
          try {
            IncrementalBuilder.InternalStatefulIncrementalBuilder.LOG.info(("Deleting stale generated file " + it));
            XtextResourceSet _resourceSet = InternalStatefulIncrementalBuilder.this.context.getResourceSet();
            URIConverter _uRIConverter = _resourceSet.getURIConverter();
            Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
            _uRIConverter.delete(it, _emptyMap);
            Procedure1<? super URI> _afterDeleteFile = request.getAfterDeleteFile();
            _afterDeleteFile.apply(it);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      IterableExtensions.<URI>forEach(previous, _function_1);
    }
    
    private final static Logger LOG = Logger.getLogger(InternalStatefulIncrementalBuilder.class);
    
    protected void setContext(final BuildContext context) {
      this.context = context;
    }
    
    protected void setRequest(final BuildRequest request) {
      this.request = request;
    }
  }
  
  @Inject
  private Provider<IncrementalBuilder.InternalStatefulIncrementalBuilder> provider;
  
  public IndexState build(final BuildRequest request, final Map<String, LanguageAccess> languages) {
    return this.build(request, languages, null);
  }
  
  public IndexState build(final BuildRequest request, final Map<String, LanguageAccess> languages, final ClusteringConfig clusteringConfig) {
    IResourceClusteringPolicy _xifexpression = null;
    boolean _notEquals = (!Objects.equal(clusteringConfig, null));
    if (_notEquals) {
      DynamicResourceClusteringPolicy _xblockexpression = null;
      {
        IncrementalBuilder.LOG.info("Clustering configured.");
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
    final XtextResourceSet resourceSet = request.getResourceSet();
    resourceSet.addLoadOption(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE, Boolean.valueOf(true));
    final BuildContext context = new BuildContext(languages, resourceSet, strategy);
    final IncrementalBuilder.InternalStatefulIncrementalBuilder builder = this.provider.get();
    builder.context = context;
    builder.request = request;
    return builder.launch();
  }
  
  private final static Logger LOG = Logger.getLogger(IncrementalBuilder.class);
}

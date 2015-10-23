/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.build;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.InputStream;
import java.util.ArrayList;
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
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.build.BuildContext;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.build.Indexer;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider2;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.generator.IShouldGenerate;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.URIBasedFileSystemAccess;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@Log
@SuppressWarnings("all")
public class IncrementalBuilder {
  @Data
  public static class Result {
    private final IndexState indexState;
    
    private final List<IResourceDescription.Delta> affectedResources;
    
    public Result(final IndexState indexState, final List<IResourceDescription.Delta> affectedResources) {
      super();
      this.indexState = indexState;
      this.affectedResources = affectedResources;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.indexState== null) ? 0 : this.indexState.hashCode());
      result = prime * result + ((this.affectedResources== null) ? 0 : this.affectedResources.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      IncrementalBuilder.Result other = (IncrementalBuilder.Result) obj;
      if (this.indexState == null) {
        if (other.indexState != null)
          return false;
      } else if (!this.indexState.equals(other.indexState))
        return false;
      if (this.affectedResources == null) {
        if (other.affectedResources != null)
          return false;
      } else if (!this.affectedResources.equals(other.affectedResources))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("indexState", this.indexState);
      b.add("affectedResources", this.affectedResources);
      return b.toString();
    }
    
    @Pure
    public IndexState getIndexState() {
      return this.indexState;
    }
    
    @Pure
    public List<IResourceDescription.Delta> getAffectedResources() {
      return this.affectedResources;
    }
  }
  
  @Log
  protected static class InternalStatefulIncrementalBuilder {
    @Accessors(AccessorType.PROTECTED_SETTER)
    @Extension
    private BuildContext context;
    
    @Accessors(AccessorType.PROTECTED_SETTER)
    private BuildRequest request;
    
    @Inject
    private Indexer indexer;
    
    @Inject
    @Extension
    private OperationCanceledManager _operationCanceledManager;
    
    public IncrementalBuilder.Result launch() {
      IndexState _state = this.request.getState();
      final Source2GeneratedMapping newSource2GeneratedMapping = _state.getFileMappings();
      List<URI> _deletedFiles = this.request.getDeletedFiles();
      final Procedure1<URI> _function = new Procedure1<URI>() {
        @Override
        public void apply(final URI source) {
          Set<URI> _deleteSource = newSource2GeneratedMapping.deleteSource(source);
          final Procedure1<URI> _function = new Procedure1<URI>() {
            @Override
            public void apply(final URI generated) {
              try {
                boolean _isInfoEnabled = IncrementalBuilder.InternalStatefulIncrementalBuilder.LOG.isInfoEnabled();
                if (_isInfoEnabled) {
                  IncrementalBuilder.InternalStatefulIncrementalBuilder.LOG.info(("Deleting " + generated));
                }
                final IResourceServiceProvider serviceProvider = InternalStatefulIncrementalBuilder.this.context.getResourceServiceProvider(source);
                IContextualOutputConfigurationProvider2 _get = serviceProvider.<IContextualOutputConfigurationProvider2>get(IContextualOutputConfigurationProvider2.class);
                XtextResourceSet _resourceSet = InternalStatefulIncrementalBuilder.this.request.getResourceSet();
                final Set<OutputConfiguration> configs = _get.getOutputConfigurations(_resourceSet);
                final String configName = newSource2GeneratedMapping.getOutputConfigName(generated);
                final Function1<OutputConfiguration, Boolean> _function = new Function1<OutputConfiguration, Boolean>() {
                  @Override
                  public Boolean apply(final OutputConfiguration it) {
                    String _name = it.getName();
                    return Boolean.valueOf(Objects.equal(_name, configName));
                  }
                };
                final OutputConfiguration config = IterableExtensions.<OutputConfiguration>findFirst(configs, _function);
                boolean _and = false;
                boolean _notEquals = (!Objects.equal(config, null));
                if (!_notEquals) {
                  _and = false;
                } else {
                  boolean _isCleanUpDerivedResources = config.isCleanUpDerivedResources();
                  _and = _isCleanUpDerivedResources;
                }
                if (_and) {
                  XtextResourceSet _resourceSet_1 = InternalStatefulIncrementalBuilder.this.context.getResourceSet();
                  URIConverter _uRIConverter = _resourceSet_1.getURIConverter();
                  Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
                  _uRIConverter.delete(generated, _emptyMap);
                  Procedure1<? super URI> _afterDeleteFile = InternalStatefulIncrementalBuilder.this.request.getAfterDeleteFile();
                  _afterDeleteFile.apply(generated);
                }
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
      CancelIndicator _cancelIndicator = this.request.getCancelIndicator();
      this._operationCanceledManager.checkCanceled(_cancelIndicator);
      final ArrayList<IResourceDescription.Delta> resolvedDeltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
      List<IResourceDescription.Delta> _resourceDeltas = result.getResourceDeltas();
      final Function1<IResourceDescription.Delta, Boolean> _function_1 = new Function1<IResourceDescription.Delta, Boolean>() {
        @Override
        public Boolean apply(final IResourceDescription.Delta it) {
          IResourceDescription _new = it.getNew();
          return Boolean.valueOf(Objects.equal(_new, null));
        }
      };
      Iterable<IResourceDescription.Delta> _filter = IterableExtensions.<IResourceDescription.Delta>filter(_resourceDeltas, _function_1);
      Iterables.<IResourceDescription.Delta>addAll(resolvedDeltas, _filter);
      List<IResourceDescription.Delta> _resourceDeltas_1 = result.getResourceDeltas();
      final Function1<IResourceDescription.Delta, Boolean> _function_2 = new Function1<IResourceDescription.Delta, Boolean>() {
        @Override
        public Boolean apply(final IResourceDescription.Delta it) {
          IResourceDescription _new = it.getNew();
          return Boolean.valueOf((!Objects.equal(_new, null)));
        }
      };
      Iterable<IResourceDescription.Delta> _filter_1 = IterableExtensions.<IResourceDescription.Delta>filter(_resourceDeltas_1, _function_2);
      final Function1<IResourceDescription.Delta, URI> _function_3 = new Function1<IResourceDescription.Delta, URI>() {
        @Override
        public URI apply(final IResourceDescription.Delta it) {
          return it.getUri();
        }
      };
      Iterable<URI> _map = IterableExtensions.<IResourceDescription.Delta, URI>map(_filter_1, _function_3);
      final Function1<Resource, IResourceDescription.Delta> _function_4 = new Function1<Resource, IResourceDescription.Delta>() {
        @Override
        public IResourceDescription.Delta apply(final Resource resource) {
          CancelIndicator _cancelIndicator = InternalStatefulIncrementalBuilder.this.request.getCancelIndicator();
          InternalStatefulIncrementalBuilder.this._operationCanceledManager.checkCanceled(_cancelIndicator);
          resource.getContents();
          EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
          CancelIndicator _cancelIndicator_1 = InternalStatefulIncrementalBuilder.this.request.getCancelIndicator();
          InternalStatefulIncrementalBuilder.this._operationCanceledManager.checkCanceled(_cancelIndicator_1);
          URI _uRI = resource.getURI();
          final IResourceServiceProvider serviceProvider = InternalStatefulIncrementalBuilder.this.context.getResourceServiceProvider(_uRI);
          final IResourceDescription.Manager manager = serviceProvider.getResourceDescriptionManager();
          final IResourceDescription description = manager.getResourceDescription(resource);
          final SerializableResourceDescription copiedDescription = SerializableResourceDescription.createCopy(description);
          ResourceDescriptionsData _newIndex = result.getNewIndex();
          URI _uRI_1 = resource.getURI();
          _newIndex.addDescription(_uRI_1, copiedDescription);
          CancelIndicator _cancelIndicator_2 = InternalStatefulIncrementalBuilder.this.request.getCancelIndicator();
          InternalStatefulIncrementalBuilder.this._operationCanceledManager.checkCanceled(_cancelIndicator_2);
          boolean _and = false;
          boolean _validate = InternalStatefulIncrementalBuilder.this.validate(resource);
          if (!_validate) {
            _and = false;
          } else {
            IShouldGenerate _get = serviceProvider.<IShouldGenerate>get(IShouldGenerate.class);
            boolean _shouldGenerate = _get.shouldGenerate(resource, CancelIndicator.NullImpl);
            _and = _shouldGenerate;
          }
          if (_and) {
            CancelIndicator _cancelIndicator_3 = InternalStatefulIncrementalBuilder.this.request.getCancelIndicator();
            InternalStatefulIncrementalBuilder.this._operationCanceledManager.checkCanceled(_cancelIndicator_3);
            InternalStatefulIncrementalBuilder.this.generate(resource, InternalStatefulIncrementalBuilder.this.request, newSource2GeneratedMapping);
          }
          IndexState _oldState = InternalStatefulIncrementalBuilder.this.context.getOldState();
          ResourceDescriptionsData _resourceDescriptions = _oldState.getResourceDescriptions();
          URI _uRI_2 = resource.getURI();
          final IResourceDescription old = _resourceDescriptions.getResourceDescription(_uRI_2);
          return manager.createDelta(old, copiedDescription);
        }
      };
      Iterable<IResourceDescription.Delta> _executeClustered = this.context.<IResourceDescription.Delta>executeClustered(_map, _function_4);
      Iterables.<IResourceDescription.Delta>addAll(resolvedDeltas, _executeClustered);
      IndexState _state_1 = this.request.getState();
      return new IncrementalBuilder.Result(_state_1, resolvedDeltas);
    }
    
    protected boolean validate(final Resource resource) {
      URI _uRI = resource.getURI();
      IResourceServiceProvider _resourceServiceProvider = this.context.getResourceServiceProvider(_uRI);
      final IResourceValidator resourceValidator = _resourceServiceProvider.getResourceValidator();
      boolean _equals = Objects.equal(resourceValidator, null);
      if (_equals) {
        return true;
      }
      URI _uRI_1 = resource.getURI();
      String _lastSegment = _uRI_1.lastSegment();
      String _plus = ("Starting validation for input: \'" + _lastSegment);
      String _plus_1 = (_plus + "\'");
      IncrementalBuilder.InternalStatefulIncrementalBuilder.LOG.info(_plus_1);
      final List<Issue> validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
      BuildRequest.IPostValidationCallback _afterValidate = this.request.getAfterValidate();
      URI _uRI_2 = resource.getURI();
      return _afterValidate.afterValidate(_uRI_2, validationResult);
    }
    
    protected void generate(final Resource resource, final BuildRequest request, final Source2GeneratedMapping newMappings) {
      URI _uRI = resource.getURI();
      final IResourceServiceProvider serviceProvider = this.context.getResourceServiceProvider(_uRI);
      final GeneratorDelegate generator = serviceProvider.<GeneratorDelegate>get(GeneratorDelegate.class);
      boolean _equals = Objects.equal(generator, null);
      if (_equals) {
        return;
      }
      URI _uRI_1 = resource.getURI();
      final Set<URI> previous = newMappings.deleteSource(_uRI_1);
      URIBasedFileSystemAccess _createFileSystemAccess = this.createFileSystemAccess(serviceProvider, resource);
      final Procedure1<URIBasedFileSystemAccess> _function = new Procedure1<URIBasedFileSystemAccess>() {
        @Override
        public void apply(final URIBasedFileSystemAccess it) {
          final URIBasedFileSystemAccess.BeforeWrite _function = new URIBasedFileSystemAccess.BeforeWrite() {
            @Override
            public InputStream beforeWrite(final URI uri, final String outputCfgName, final InputStream contents) {
              URI _uRI = resource.getURI();
              newMappings.addSource2Generated(_uRI, uri, outputCfgName);
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
      final URIBasedFileSystemAccess fileSystemAccess = ObjectExtensions.<URIBasedFileSystemAccess>operator_doubleArrow(_createFileSystemAccess, _function);
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
      final GeneratorContext generatorContext = new GeneratorContext();
      CancelIndicator _cancelIndicator = request.getCancelIndicator();
      generatorContext.setCancelIndicator(_cancelIndicator);
      generator.generate(resource, fileSystemAccess, generatorContext);
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
    
    protected URIBasedFileSystemAccess createFileSystemAccess(final IResourceServiceProvider serviceProvider, final Resource resource) {
      URIBasedFileSystemAccess _xblockexpression = null;
      {
        final IProjectConfigProvider projectConfigProvider = serviceProvider.<IProjectConfigProvider>get(IProjectConfigProvider.class);
        IProjectConfig _projectConfig = null;
        if (projectConfigProvider!=null) {
          ResourceSet _resourceSet = resource.getResourceSet();
          _projectConfig=projectConfigProvider.getProjectConfig(_resourceSet);
        }
        final IProjectConfig projectConfig = _projectConfig;
        ISourceFolder _findSourceFolderContaining = null;
        if (projectConfig!=null) {
          URI _uRI = resource.getURI();
          _findSourceFolderContaining=projectConfig.findSourceFolderContaining(_uRI);
        }
        final ISourceFolder sourceFolder = _findSourceFolderContaining;
        URIBasedFileSystemAccess _uRIBasedFileSystemAccess = new URIBasedFileSystemAccess();
        final Procedure1<URIBasedFileSystemAccess> _function = new Procedure1<URIBasedFileSystemAccess>() {
          @Override
          public void apply(final URIBasedFileSystemAccess it) {
            final IContextualOutputConfigurationProvider outputConfigProvider = serviceProvider.<IContextualOutputConfigurationProvider>get(IContextualOutputConfigurationProvider.class);
            Set<OutputConfiguration> _outputConfigurations = outputConfigProvider.getOutputConfigurations(resource);
            final Function1<OutputConfiguration, String> _function = new Function1<OutputConfiguration, String>() {
              @Override
              public String apply(final OutputConfiguration it) {
                return it.getName();
              }
            };
            Map<String, OutputConfiguration> _map = IterableExtensions.<String, OutputConfiguration>toMap(_outputConfigurations, _function);
            it.setOutputConfigurations(_map);
            IFilePostProcessor _get = serviceProvider.<IFilePostProcessor>get(IFilePostProcessor.class);
            it.setPostProcessor(_get);
            final IEncodingProvider newEncodingProvider = serviceProvider.<IEncodingProvider>get(IEncodingProvider.class);
            boolean _notEquals = (!Objects.equal(newEncodingProvider, null));
            if (_notEquals) {
              it.setEncodingProvider(newEncodingProvider);
            }
            TraceFileNameProvider _get_1 = serviceProvider.<TraceFileNameProvider>get(TraceFileNameProvider.class);
            it.setTraceFileNameProvider(_get_1);
            TraceRegionSerializer _get_2 = serviceProvider.<TraceRegionSerializer>get(TraceRegionSerializer.class);
            it.setTraceRegionSerializer(_get_2);
            it.setGenerateTraces(true);
            URI _baseDir = InternalStatefulIncrementalBuilder.this.request.getBaseDir();
            it.setBaseDir(_baseDir);
            String _name = null;
            if (sourceFolder!=null) {
              _name=sourceFolder.getName();
            }
            it.setCurrentSource(_name);
            ResourceSet _resourceSet = resource.getResourceSet();
            URIConverter _uRIConverter = _resourceSet.getURIConverter();
            it.setConverter(_uRIConverter);
          }
        };
        _xblockexpression = ObjectExtensions.<URIBasedFileSystemAccess>operator_doubleArrow(_uRIBasedFileSystemAccess, _function);
      }
      return _xblockexpression;
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
  
  @Inject
  @Extension
  private OperationCanceledManager _operationCanceledManager;
  
  public IncrementalBuilder.Result build(final BuildRequest request, final Function1<? super URI, ? extends IResourceServiceProvider> languages) {
    DisabledClusteringPolicy _disabledClusteringPolicy = new DisabledClusteringPolicy();
    return this.build(request, languages, _disabledClusteringPolicy);
  }
  
  public IncrementalBuilder.Result build(final BuildRequest request, final Function1<? super URI, ? extends IResourceServiceProvider> languages, final IResourceClusteringPolicy clusteringPolicy) {
    try {
      final XtextResourceSet resourceSet = request.getResourceSet();
      IndexState _state = request.getState();
      ResourceDescriptionsData _resourceDescriptions = _state.getResourceDescriptions();
      ResourceDescriptionsData _copy = _resourceDescriptions.copy();
      IndexState _state_1 = request.getState();
      Source2GeneratedMapping _fileMappings = _state_1.getFileMappings();
      Source2GeneratedMapping _copy_1 = _fileMappings.copy();
      final IndexState oldState = new IndexState(_copy, _copy_1);
      CancelIndicator _cancelIndicator = request.getCancelIndicator();
      final BuildContext context = new BuildContext(languages, resourceSet, oldState, clusteringPolicy, _cancelIndicator);
      final IncrementalBuilder.InternalStatefulIncrementalBuilder builder = this.provider.get();
      builder.context = context;
      builder.request = request;
      try {
        return builder.launch();
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          this._operationCanceledManager.propagateIfCancelException(t);
          throw t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private final static Logger LOG = Logger.getLogger(IncrementalBuilder.class);
}

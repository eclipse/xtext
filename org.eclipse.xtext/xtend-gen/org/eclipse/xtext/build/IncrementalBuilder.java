/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
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
import com.google.inject.Singleton;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.DisabledClusteringPolicy;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
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
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
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
      return prime * result + ((this.affectedResources== null) ? 0 : this.affectedResources.hashCode());
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
  
  public static class InternalStatefulIncrementalBuilder {
    @Singleton
    public static class URIBasedFileSystemAccessFactory {
      @Inject
      private IContextualOutputConfigurationProvider outputConfigurationProvider;
      
      @Inject
      private IFilePostProcessor postProcessor;
      
      @Inject(optional = true)
      private IEncodingProvider encodingProvider;
      
      @Inject
      private TraceFileNameProvider traceFileNameProvider;
      
      @Inject
      private TraceRegionSerializer traceRegionSerializer;
      
      @Inject(optional = true)
      private IProjectConfigProvider projectConfigProvider;
      
      public URIBasedFileSystemAccess newFileSystemAccess(final Resource resource, final BuildRequest request) {
        URIBasedFileSystemAccess _uRIBasedFileSystemAccess = new URIBasedFileSystemAccess();
        final Procedure1<URIBasedFileSystemAccess> _function = (URIBasedFileSystemAccess it) -> {
          final Function1<OutputConfiguration, String> _function_1 = (OutputConfiguration it_1) -> {
            return it_1.getName();
          };
          it.setOutputConfigurations(IterableExtensions.<String, OutputConfiguration>toMap(this.outputConfigurationProvider.getOutputConfigurations(resource), _function_1));
          it.setPostProcessor(this.postProcessor);
          if ((this.encodingProvider != null)) {
            it.setEncodingProvider(this.encodingProvider);
          }
          it.setTraceFileNameProvider(this.traceFileNameProvider);
          it.setTraceRegionSerializer(this.traceRegionSerializer);
          it.setGenerateTraces(true);
          it.setBaseDir(request.getBaseDir());
          if ((this.projectConfigProvider != null)) {
            IProjectConfig _projectConfig = this.projectConfigProvider.getProjectConfig(resource.getResourceSet());
            ISourceFolder _findSourceFolderContaining = null;
            if (_projectConfig!=null) {
              _findSourceFolderContaining=_projectConfig.findSourceFolderContaining(resource.getURI());
            }
            final ISourceFolder sourceFolder = _findSourceFolderContaining;
            String _name = null;
            if (sourceFolder!=null) {
              _name=sourceFolder.getName();
            }
            it.setCurrentSource(_name);
          }
          it.setConverter(resource.getResourceSet().getURIConverter());
        };
        return ObjectExtensions.<URIBasedFileSystemAccess>operator_doubleArrow(_uRIBasedFileSystemAccess, _function);
      }
    }
    
    @Accessors({ AccessorType.PROTECTED_SETTER, AccessorType.PROTECTED_GETTER })
    @Extension
    private BuildContext context;
    
    @Accessors({ AccessorType.PROTECTED_SETTER, AccessorType.PROTECTED_GETTER })
    private BuildRequest request;
    
    @Inject
    private Indexer indexer;
    
    @Inject
    @Extension
    private OperationCanceledManager _operationCanceledManager;
    
    protected void unloadResource(final URI uri) {
      final Resource resource = this.request.getResourceSet().getResource(uri, false);
      if ((resource != null)) {
        this.request.getResourceSet().getResources().remove(resource);
        resource.unload();
      }
    }
    
    public IncrementalBuilder.Result launch() {
      final Source2GeneratedMapping newSource2GeneratedMapping = this.request.getState().getFileMappings();
      final HashSet<URI> unloaded = CollectionLiterals.<URI>newHashSet();
      List<URI> _deletedFiles = this.request.getDeletedFiles();
      for (final URI deleted : _deletedFiles) {
        boolean _add = unloaded.add(deleted);
        if (_add) {
          this.unloadResource(deleted);
        }
      }
      List<URI> _dirtyFiles = this.request.getDirtyFiles();
      for (final URI dirty : _dirtyFiles) {
        boolean _add_1 = unloaded.add(dirty);
        if (_add_1) {
          this.unloadResource(dirty);
        }
      }
      final Consumer<URI> _function = (URI source) -> {
        this.request.getAfterValidate().afterValidate(source, CollectionLiterals.<Issue>newArrayList());
        final Consumer<URI> _function_1 = (URI generated) -> {
          try {
            final IResourceServiceProvider serviceProvider = this.context.getResourceServiceProvider(source);
            final Set<OutputConfiguration> configs = serviceProvider.<IContextualOutputConfigurationProvider2>get(IContextualOutputConfigurationProvider2.class).getOutputConfigurations(this.request.getResourceSet());
            final String configName = newSource2GeneratedMapping.getOutputConfigName(generated);
            final Function1<OutputConfiguration, Boolean> _function_2 = (OutputConfiguration it) -> {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, configName));
            };
            final OutputConfiguration config = IterableExtensions.<OutputConfiguration>findFirst(configs, _function_2);
            if (((config != null) && config.isCleanUpDerivedResources())) {
              this.context.getResourceSet().getURIConverter().delete(generated, CollectionLiterals.<Object, Object>emptyMap());
              this.request.getAfterDeleteFile().apply(generated);
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        };
        newSource2GeneratedMapping.deleteSource(source).forEach(_function_1);
      };
      this.request.getDeletedFiles().forEach(_function);
      final Indexer.IndexResult result = this.indexer.computeAndIndexAffected(this.request, this.context);
      this._operationCanceledManager.checkCanceled(this.request.getCancelIndicator());
      List<IResourceDescription.Delta> _resourceDeltas = result.getResourceDeltas();
      for (final IResourceDescription.Delta delta : _resourceDeltas) {
        boolean _add_2 = unloaded.add(delta.getUri());
        if (_add_2) {
          this.unloadResource(delta.getUri());
        }
      }
      final ArrayList<IResourceDescription.Delta> resolvedDeltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
      final Function1<IResourceDescription.Delta, Boolean> _function_1 = (IResourceDescription.Delta it) -> {
        IResourceDescription _new = it.getNew();
        return Boolean.valueOf((_new == null));
      };
      Iterable<IResourceDescription.Delta> _filter = IterableExtensions.<IResourceDescription.Delta>filter(result.getResourceDeltas(), _function_1);
      Iterables.<IResourceDescription.Delta>addAll(resolvedDeltas, _filter);
      final Function1<IResourceDescription.Delta, Boolean> _function_2 = (IResourceDescription.Delta it) -> {
        IResourceDescription _new = it.getNew();
        return Boolean.valueOf((_new != null));
      };
      final Function1<IResourceDescription.Delta, URI> _function_3 = (IResourceDescription.Delta it) -> {
        return it.getUri();
      };
      final Function1<Resource, IResourceDescription.Delta> _function_4 = (Resource resource) -> {
        this._operationCanceledManager.checkCanceled(this.request.getCancelIndicator());
        resource.getContents();
        EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
        this._operationCanceledManager.checkCanceled(this.request.getCancelIndicator());
        final IResourceServiceProvider serviceProvider = this.getResourceServiceProvider(resource);
        final IResourceDescription.Manager manager = serviceProvider.getResourceDescriptionManager();
        final IResourceDescription description = manager.getResourceDescription(resource);
        final SerializableResourceDescription copiedDescription = SerializableResourceDescription.createCopy(description);
        result.getNewIndex().addDescription(resource.getURI(), copiedDescription);
        this._operationCanceledManager.checkCanceled(this.request.getCancelIndicator());
        if ((((!this.request.isIndexOnly()) && this.validate(resource)) && serviceProvider.<IShouldGenerate>get(IShouldGenerate.class).shouldGenerate(resource, CancelIndicator.NullImpl))) {
          this._operationCanceledManager.checkCanceled(this.request.getCancelIndicator());
          this.generate(resource, this.request, newSource2GeneratedMapping);
        }
        final IResourceDescription old = this.context.getOldState().getResourceDescriptions().getResourceDescription(resource.getURI());
        return manager.createDelta(old, copiedDescription);
      };
      Iterable<IResourceDescription.Delta> _executeClustered = this.context.<IResourceDescription.Delta>executeClustered(IterableExtensions.<IResourceDescription.Delta, URI>map(IterableExtensions.<IResourceDescription.Delta>filter(result.getResourceDeltas(), _function_2), _function_3), _function_4);
      Iterables.<IResourceDescription.Delta>addAll(resolvedDeltas, _executeClustered);
      IndexState _state = this.request.getState();
      return new IncrementalBuilder.Result(_state, resolvedDeltas);
    }
    
    private IResourceServiceProvider getResourceServiceProvider(final Resource resource) {
      if ((resource instanceof XtextResource)) {
        return ((XtextResource)resource).getResourceServiceProvider();
      }
      return this.context.getResourceServiceProvider(resource.getURI());
    }
    
    protected boolean validate(final Resource resource) {
      final IResourceValidator resourceValidator = this.getResourceServiceProvider(resource).getResourceValidator();
      if ((resourceValidator == null)) {
        return true;
      }
      final List<Issue> validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
      return this.request.getAfterValidate().afterValidate(resource.getURI(), validationResult);
    }
    
    protected void generate(final Resource resource, final BuildRequest request, final Source2GeneratedMapping newMappings) {
      final IResourceServiceProvider serviceProvider = this.getResourceServiceProvider(resource);
      final GeneratorDelegate generator = serviceProvider.<GeneratorDelegate>get(GeneratorDelegate.class);
      if ((generator == null)) {
        return;
      }
      final Set<URI> previous = newMappings.deleteSource(resource.getURI());
      URIBasedFileSystemAccess _createFileSystemAccess = this.createFileSystemAccess(serviceProvider, resource);
      final Procedure1<URIBasedFileSystemAccess> _function = (URIBasedFileSystemAccess it) -> {
        final URIBasedFileSystemAccess.BeforeWrite _function_1 = (URI uri, String outputCfgName, InputStream contents) -> {
          newMappings.addSource2Generated(resource.getURI(), uri, outputCfgName);
          previous.remove(uri);
          request.getAfterGenerateFile().apply(resource.getURI(), uri);
          return contents;
        };
        it.setBeforeWrite(_function_1);
        final URIBasedFileSystemAccess.BeforeDelete _function_2 = (URI uri) -> {
          newMappings.deleteGenerated(uri);
          request.getAfterDeleteFile().apply(uri);
          return true;
        };
        it.setBeforeDelete(_function_2);
      };
      final URIBasedFileSystemAccess fileSystemAccess = ObjectExtensions.<URIBasedFileSystemAccess>operator_doubleArrow(_createFileSystemAccess, _function);
      fileSystemAccess.setContext(resource);
      boolean _isWriteStorageResources = request.isWriteStorageResources();
      if (_isWriteStorageResources) {
        boolean _matched = false;
        if (resource instanceof StorageAwareResource) {
          IResourceStorageFacade _resourceStorageFacade = ((StorageAwareResource)resource).getResourceStorageFacade();
          boolean _tripleNotEquals = (_resourceStorageFacade != null);
          if (_tripleNotEquals) {
            _matched=true;
            ((StorageAwareResource)resource).getResourceStorageFacade().saveResource(((StorageAwareResource)resource), fileSystemAccess);
          }
        }
      }
      final GeneratorContext generatorContext = new GeneratorContext();
      generatorContext.setCancelIndicator(request.getCancelIndicator());
      generator.generate(resource, fileSystemAccess, generatorContext);
      final Consumer<URI> _function_1 = (URI it) -> {
        try {
          this.context.getResourceSet().getURIConverter().delete(it, CollectionLiterals.<Object, Object>emptyMap());
          request.getAfterDeleteFile().apply(it);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      previous.forEach(_function_1);
    }
    
    protected URIBasedFileSystemAccess createFileSystemAccess(final IResourceServiceProvider serviceProvider, final Resource resource) {
      return serviceProvider.<IncrementalBuilder.InternalStatefulIncrementalBuilder.URIBasedFileSystemAccessFactory>get(IncrementalBuilder.InternalStatefulIncrementalBuilder.URIBasedFileSystemAccessFactory.class).newFileSystemAccess(resource, this.request);
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
      ResourceDescriptionsData _copy = request.getState().getResourceDescriptions().copy();
      Source2GeneratedMapping _copy_1 = request.getState().getFileMappings().copy();
      final IndexState oldState = new IndexState(_copy, _copy_1);
      CancelIndicator _cancelIndicator = request.getCancelIndicator();
      final BuildContext context = new BuildContext(languages, resourceSet, oldState, clusteringPolicy, _cancelIndicator);
      final IncrementalBuilder.InternalStatefulIncrementalBuilder builder = this.provider.get();
      builder.setContext(context);
      builder.setRequest(request);
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
}

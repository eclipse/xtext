/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.build;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.build.BuildContext;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@Log
@SuppressWarnings("all")
public class Indexer {
  @Data
  public static class IndexResult {
    private final List<IResourceDescription.Delta> resourceDeltas;
    
    private final ResourceDescriptionsData newIndex;
    
    public IndexResult(final List<IResourceDescription.Delta> resourceDeltas, final ResourceDescriptionsData newIndex) {
      super();
      this.resourceDeltas = resourceDeltas;
      this.newIndex = newIndex;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.resourceDeltas== null) ? 0 : this.resourceDeltas.hashCode());
      result = prime * result + ((this.newIndex== null) ? 0 : this.newIndex.hashCode());
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
      Indexer.IndexResult other = (Indexer.IndexResult) obj;
      if (this.resourceDeltas == null) {
        if (other.resourceDeltas != null)
          return false;
      } else if (!this.resourceDeltas.equals(other.resourceDeltas))
        return false;
      if (this.newIndex == null) {
        if (other.newIndex != null)
          return false;
      } else if (!this.newIndex.equals(other.newIndex))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("resourceDeltas", this.resourceDeltas);
      b.add("newIndex", this.newIndex);
      return b.toString();
    }
    
    @Pure
    public List<IResourceDescription.Delta> getResourceDeltas() {
      return this.resourceDeltas;
    }
    
    @Pure
    public ResourceDescriptionsData getNewIndex() {
      return this.newIndex;
    }
  }
  
  @Log
  protected static class ResolvedResourceDescription extends AbstractResourceDescription {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private URI URI;
    
    private ImmutableList<IEObjectDescription> exported;
    
    public ResolvedResourceDescription(final IResourceDescription original) {
      URI _uRI = original.getURI();
      this.URI = _uRI;
      Iterable<IEObjectDescription> _exportedObjects = original.getExportedObjects();
      final Function1<IEObjectDescription, IEObjectDescription> _function = new Function1<IEObjectDescription, IEObjectDescription>() {
        @Override
        public IEObjectDescription apply(final IEObjectDescription from) {
          EObject _eObjectOrProxy = from.getEObjectOrProxy();
          boolean _eIsProxy = _eObjectOrProxy.eIsProxy();
          if (_eIsProxy) {
            return from;
          }
          EClass _eClass = from.getEClass();
          EObject _create = EcoreUtil.create(_eClass);
          InternalEObject result = ((InternalEObject) _create);
          URI _eObjectURI = from.getEObjectURI();
          result.eSetProxyURI(_eObjectURI);
          Map<String, String> userData = null;
          String[] _userDataKeys = from.getUserDataKeys();
          for (final String key : _userDataKeys) {
            {
              boolean _equals = Objects.equal(userData, null);
              if (_equals) {
                HashMap<String, String> _newHashMapWithExpectedSize = Maps.<String, String>newHashMapWithExpectedSize(2);
                userData = _newHashMapWithExpectedSize;
              }
              String _userData = from.getUserData(key);
              userData.put(key, _userData);
            }
          }
          QualifiedName _name = from.getName();
          return EObjectDescription.create(_name, result, userData);
        }
      };
      Iterable<IEObjectDescription> _map = IterableExtensions.<IEObjectDescription, IEObjectDescription>map(_exportedObjects, _function);
      ImmutableList<IEObjectDescription> _copyOf = ImmutableList.<IEObjectDescription>copyOf(_map);
      this.exported = _copyOf;
    }
    
    @Override
    protected List<IEObjectDescription> computeExportedObjects() {
      return this.exported;
    }
    
    @Override
    public Iterable<QualifiedName> getImportedNames() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("getImportedNames ");
      _builder.append(this.URI, "");
      IllegalStateException exception = new IllegalStateException(_builder.toString());
      Indexer.ResolvedResourceDescription.LOG.error(exception, exception);
      return CollectionLiterals.<QualifiedName>emptyList();
    }
    
    @Override
    public Iterable<IReferenceDescription> getReferenceDescriptions() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("getReferenceDescriptions ");
      _builder.append(this.URI, "");
      IllegalStateException exception = new IllegalStateException(_builder.toString());
      Indexer.ResolvedResourceDescription.LOG.error(exception, exception);
      return CollectionLiterals.<IReferenceDescription>emptyList();
    }
    
    private final static Logger LOG = Logger.getLogger(ResolvedResourceDescription.class);
    
    @Pure
    public URI getURI() {
      return this.URI;
    }
  }
  
  @Inject
  private CompilerPhases compilerPhases;
  
  @Inject
  @Extension
  private OperationCanceledManager _operationCanceledManager;
  
  public Indexer.IndexResult computeAndIndexAffected(final BuildRequest request, @Extension final BuildContext context) {
    IndexState _oldState = context.getOldState();
    final ResourceDescriptionsData previousIndex = _oldState.getResourceDescriptions();
    IndexState _state = request.getState();
    final ResourceDescriptionsData newIndex = _state.getResourceDescriptions();
    final List<IResourceDescription.Delta> deltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
    boolean _isInfoEnabled = Indexer.LOG.isInfoEnabled();
    if (_isInfoEnabled) {
      List<URI> _deletedFiles = request.getDeletedFiles();
      Set<URI> _set = IterableExtensions.<URI>toSet(_deletedFiles);
      String _plus = ("Creating Deltas for changes. Deleted : " + _set);
      String _plus_1 = (_plus + ", Changed : ");
      List<URI> _dirtyFiles = request.getDirtyFiles();
      Set<URI> _set_1 = IterableExtensions.<URI>toSet(_dirtyFiles);
      String _plus_2 = (_plus_1 + _set_1);
      String _plus_3 = (_plus_2 + ".");
      Indexer.LOG.info(_plus_3);
    }
    List<IResourceDescription.Delta> _deltasForDeletedResources = this.getDeltasForDeletedResources(request, previousIndex, context);
    deltas.addAll(_deltasForDeletedResources);
    List<URI> _dirtyFiles_1 = request.getDirtyFiles();
    List<IResourceDescription.Delta> _deltasForChangedResources = this.getDeltasForChangedResources(_dirtyFiles_1, previousIndex, context);
    deltas.addAll(_deltasForChangedResources);
    for (final IResourceDescription.Delta delta : deltas) {
      newIndex.register(delta);
    }
    final HashSet<IResourceDescription.Delta> allDeltas = new HashSet<IResourceDescription.Delta>(deltas);
    List<IResourceDescription.Delta> _externalDeltas = request.getExternalDeltas();
    boolean _isEmpty = _externalDeltas.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List<IResourceDescription.Delta> _externalDeltas_1 = request.getExternalDeltas();
      allDeltas.addAll(_externalDeltas_1);
    }
    Iterable<IResourceDescription> _allResourceDescriptions = previousIndex.getAllResourceDescriptions();
    final Function1<IResourceDescription, URI> _function = new Function1<IResourceDescription, URI>() {
      @Override
      public URI apply(final IResourceDescription it) {
        return it.getURI();
      }
    };
    Iterable<URI> _map = IterableExtensions.<IResourceDescription, URI>map(_allResourceDescriptions, _function);
    final Set<URI> remainingURIs = IterableExtensions.<URI>toSet(_map);
    final Function1<IResourceDescription.Delta, URI> _function_1 = new Function1<IResourceDescription.Delta, URI>() {
      @Override
      public URI apply(final IResourceDescription.Delta it) {
        return it.getUri();
      }
    };
    List<URI> _map_1 = ListExtensions.<IResourceDescription.Delta, URI>map(deltas, _function_1);
    remainingURIs.removeAll(_map_1);
    final Function1<URI, Boolean> _function_2 = new Function1<URI, Boolean>() {
      @Override
      public Boolean apply(final URI it) {
        IResourceServiceProvider _resourceServiceProvider = context.getResourceServiceProvider(it);
        final IResourceDescription.Manager manager = _resourceServiceProvider.getResourceDescriptionManager();
        final IResourceDescription resourceDescription = previousIndex.getResourceDescription(it);
        final boolean isAffected = Indexer.this.isAffected(resourceDescription, manager, allDeltas, allDeltas, newIndex);
        return Boolean.valueOf(isAffected);
      }
    };
    Iterable<URI> _filter = IterableExtensions.<URI>filter(remainingURIs, _function_2);
    final List<URI> allAffected = IterableExtensions.<URI>toList(_filter);
    boolean _and = false;
    boolean _isInfoEnabled_1 = Indexer.LOG.isInfoEnabled();
    if (!_isInfoEnabled_1) {
      _and = false;
    } else {
      boolean _isEmpty_1 = allAffected.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _and = _not_1;
    }
    if (_and) {
      Set<URI> _set_2 = IterableExtensions.<URI>toSet(allAffected);
      String _plus_4 = ("Creating Deltas for affected resources : " + _set_2);
      String _plus_5 = (_plus_4 + ".");
      Indexer.LOG.info(_plus_5);
    }
    List<IResourceDescription.Delta> _deltasForChangedResources_1 = this.getDeltasForChangedResources(allAffected, previousIndex, context);
    deltas.addAll(_deltasForChangedResources_1);
    return new Indexer.IndexResult(deltas, newIndex);
  }
  
  protected List<IResourceDescription.Delta> getDeltasForDeletedResources(final BuildRequest request, final ResourceDescriptionsData oldIndex, @Extension final BuildContext context) {
    final ArrayList<IResourceDescription.Delta> deltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
    List<URI> _deletedFiles = request.getDeletedFiles();
    final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
      @Override
      public Boolean apply(final URI it) {
        IResourceServiceProvider _resourceServiceProvider = context.getResourceServiceProvider(it);
        return Boolean.valueOf((!Objects.equal(_resourceServiceProvider, null)));
      }
    };
    Iterable<URI> _filter = IterableExtensions.<URI>filter(_deletedFiles, _function);
    for (final URI it : _filter) {
      {
        CancelIndicator _cancelIndicator = context.getCancelIndicator();
        this._operationCanceledManager.checkCanceled(_cancelIndicator);
        IResourceDescription _resourceDescription = null;
        if (oldIndex!=null) {
          _resourceDescription=oldIndex.getResourceDescription(it);
        }
        final IResourceDescription oldDescription = _resourceDescription;
        boolean _notEquals = (!Objects.equal(oldDescription, null));
        if (_notEquals) {
          final DefaultResourceDescriptionDelta delta = new DefaultResourceDescriptionDelta(oldDescription, null);
          deltas.add(delta);
        }
      }
    }
    return deltas;
  }
  
  protected List<IResourceDescription.Delta> getDeltasForChangedResources(final Iterable<URI> affectedUris, final ResourceDescriptionsData oldIndex, @Extension final BuildContext context) {
    try {
      XtextResourceSet _resourceSet = context.getResourceSet();
      this.compilerPhases.setIndexing(_resourceSet, true);
      final Function1<Resource, IResourceDescription.Delta> _function = new Function1<Resource, IResourceDescription.Delta>() {
        @Override
        public IResourceDescription.Delta apply(final Resource it) {
          return Indexer.this.addToIndex(it, true, oldIndex, context);
        }
      };
      Iterable<IResourceDescription.Delta> _executeClustered = context.<IResourceDescription.Delta>executeClustered(affectedUris, _function);
      return IterableExtensions.<IResourceDescription.Delta>toList(_executeClustered);
    } finally {
      XtextResourceSet _resourceSet_1 = context.getResourceSet();
      this.compilerPhases.setIndexing(_resourceSet_1, false);
    }
  }
  
  protected IResourceDescription.Delta addToIndex(final Resource resource, final boolean isPreIndexing, final ResourceDescriptionsData oldIndex, final BuildContext context) {
    CancelIndicator _cancelIndicator = context.getCancelIndicator();
    this._operationCanceledManager.checkCanceled(_cancelIndicator);
    final URI uri = resource.getURI();
    final IResourceServiceProvider serviceProvider = context.getResourceServiceProvider(uri);
    final IResourceDescription.Manager manager = serviceProvider.getResourceDescriptionManager();
    final IResourceDescription newDescription = manager.getResourceDescription(resource);
    final IResourceDescription toBeAdded = new Indexer.ResolvedResourceDescription(newDescription);
    IResourceDescription _resourceDescription = null;
    if (oldIndex!=null) {
      _resourceDescription=oldIndex.getResourceDescription(uri);
    }
    final IResourceDescription.Delta delta = manager.createDelta(_resourceDescription, toBeAdded);
    return delta;
  }
  
  protected boolean isAffected(final IResourceDescription affectionCandidate, final IResourceDescription.Manager manager, final Collection<IResourceDescription.Delta> newDeltas, final Collection<IResourceDescription.Delta> allDeltas, final IResourceDescriptions resourceDescriptions) {
    if ((manager instanceof IResourceDescription.Manager.AllChangeAware)) {
      return ((IResourceDescription.Manager.AllChangeAware)manager).isAffectedByAny(allDeltas, affectionCandidate, resourceDescriptions);
    } else {
      boolean _isEmpty = newDeltas.isEmpty();
      if (_isEmpty) {
        return false;
      } else {
        return manager.isAffected(newDeltas, affectionCandidate, resourceDescriptions);
      }
    }
  }
  
  private final static Logger LOG = Logger.getLogger(Indexer.class);
}

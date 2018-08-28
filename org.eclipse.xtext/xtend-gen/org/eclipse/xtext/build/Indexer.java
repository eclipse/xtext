/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.build;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescriptionProvider;
import org.eclipse.xtext.service.OperationCanceledManager;
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
      return prime * result + ((this.newIndex== null) ? 0 : this.newIndex.hashCode());
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
      this.URI = original.getURI();
      final Function1<IEObjectDescription, IEObjectDescription> _function = (IEObjectDescription from) -> {
        if ((from instanceof SerializableEObjectDescriptionProvider)) {
          return ((SerializableEObjectDescriptionProvider)from).toSerializableEObjectDescription();
        }
        boolean _eIsProxy = from.getEObjectOrProxy().eIsProxy();
        if (_eIsProxy) {
          return from;
        }
        EObject _create = EcoreUtil.create(from.getEClass());
        InternalEObject result = ((InternalEObject) _create);
        result.eSetProxyURI(from.getEObjectURI());
        Map<String, String> userData = null;
        String[] _userDataKeys = from.getUserDataKeys();
        for (final String key : _userDataKeys) {
          {
            if ((userData == null)) {
              userData = Maps.<String, String>newHashMapWithExpectedSize(2);
            }
            userData.put(key, from.getUserData(key));
          }
        }
        return EObjectDescription.create(from.getName(), result, userData);
      };
      this.exported = ImmutableList.<IEObjectDescription>copyOf(
        IterableExtensions.<IEObjectDescription, IEObjectDescription>map(original.getExportedObjects(), _function));
    }
    
    @Override
    protected List<IEObjectDescription> computeExportedObjects() {
      return this.exported;
    }
    
    @Override
    public Iterable<QualifiedName> getImportedNames() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("getImportedNames ");
      _builder.append(this.URI);
      IllegalStateException exception = new IllegalStateException(_builder.toString());
      Indexer.ResolvedResourceDescription.LOG.error(exception, exception);
      return CollectionLiterals.<QualifiedName>emptyList();
    }
    
    @Override
    public Iterable<IReferenceDescription> getReferenceDescriptions() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("getReferenceDescriptions ");
      _builder.append(this.URI);
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
    final ResourceDescriptionsData previousIndex = context.getOldState().getResourceDescriptions();
    final ResourceDescriptionsData newIndex = request.getState().getResourceDescriptions();
    final List<IResourceDescription.Delta> deltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
    deltas.addAll(this.getDeltasForDeletedResources(request, previousIndex, context));
    deltas.addAll(this.getDeltasForChangedResources(request.getDirtyFiles(), previousIndex, context));
    for (final IResourceDescription.Delta delta : deltas) {
      newIndex.register(delta);
    }
    final HashSet<IResourceDescription.Delta> allDeltas = new HashSet<IResourceDescription.Delta>(deltas);
    boolean _isEmpty = request.getExternalDeltas().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      allDeltas.addAll(request.getExternalDeltas());
    }
    final Function1<IResourceDescription, URI> _function = (IResourceDescription it) -> {
      return it.getURI();
    };
    final Set<URI> remainingURIs = IterableExtensions.<URI>toSet(IterableExtensions.<IResourceDescription, URI>map(previousIndex.getAllResourceDescriptions(), _function));
    final Function1<IResourceDescription.Delta, URI> _function_1 = (IResourceDescription.Delta it) -> {
      return it.getUri();
    };
    remainingURIs.removeAll(ListExtensions.<IResourceDescription.Delta, URI>map(deltas, _function_1));
    final Function1<URI, Boolean> _function_2 = (URI it) -> {
      final IResourceDescription.Manager manager = context.getResourceServiceProvider(it).getResourceDescriptionManager();
      final IResourceDescription resourceDescription = previousIndex.getResourceDescription(it);
      final boolean isAffected = this.isAffected(resourceDescription, manager, allDeltas, allDeltas, newIndex);
      return Boolean.valueOf(isAffected);
    };
    final List<URI> allAffected = IterableExtensions.<URI>toList(IterableExtensions.<URI>filter(remainingURIs, _function_2));
    deltas.addAll(this.getDeltasForChangedResources(allAffected, previousIndex, context));
    return new Indexer.IndexResult(deltas, newIndex);
  }
  
  protected List<IResourceDescription.Delta> getDeltasForDeletedResources(final BuildRequest request, final ResourceDescriptionsData oldIndex, @Extension final BuildContext context) {
    final ArrayList<IResourceDescription.Delta> deltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
    final Function1<URI, Boolean> _function = (URI it) -> {
      IResourceServiceProvider _resourceServiceProvider = context.getResourceServiceProvider(it);
      return Boolean.valueOf((_resourceServiceProvider != null));
    };
    final Consumer<URI> _function_1 = (URI it) -> {
      this._operationCanceledManager.checkCanceled(context.getCancelIndicator());
      IResourceDescription _resourceDescription = null;
      if (oldIndex!=null) {
        _resourceDescription=oldIndex.getResourceDescription(it);
      }
      final IResourceDescription oldDescription = _resourceDescription;
      if ((oldDescription != null)) {
        final DefaultResourceDescriptionDelta delta = new DefaultResourceDescriptionDelta(oldDescription, null);
        deltas.add(delta);
      }
    };
    IterableExtensions.<URI>filter(request.getDeletedFiles(), _function).forEach(_function_1);
    return deltas;
  }
  
  protected List<IResourceDescription.Delta> getDeltasForChangedResources(final Iterable<URI> affectedUris, final ResourceDescriptionsData oldIndex, @Extension final BuildContext context) {
    try {
      this.compilerPhases.setIndexing(context.getResourceSet(), true);
      final Function1<Resource, IResourceDescription.Delta> _function = (Resource it) -> {
        return this.addToIndex(it, true, oldIndex, context);
      };
      return IterableExtensions.<IResourceDescription.Delta>toList(context.<IResourceDescription.Delta>executeClustered(affectedUris, _function));
    } finally {
      this.compilerPhases.setIndexing(context.getResourceSet(), false);
    }
  }
  
  protected IResourceDescription.Delta addToIndex(final Resource resource, final boolean isPreIndexing, final ResourceDescriptionsData oldIndex, final BuildContext context) {
    this._operationCanceledManager.checkCanceled(context.getCancelIndicator());
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
}

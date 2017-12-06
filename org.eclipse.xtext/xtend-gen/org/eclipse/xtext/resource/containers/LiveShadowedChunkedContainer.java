/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.containers;

import com.google.common.annotations.Beta;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.14
 */
@Beta
@FinalFieldsConstructor
@SuppressWarnings("all")
public class LiveShadowedChunkedContainer implements IContainer {
  private final LiveShadowedChunkedResourceDescriptions descriptions;
  
  private final String containerName;
  
  private IProjectConfig projectConfig;
  
  private boolean isProjectConfigSet = false;
  
  protected ChunkedResourceDescriptions getChunkedResourceDescriptions() {
    IResourceDescriptions _globalDescriptions = this.descriptions.getGlobalDescriptions();
    return ((ChunkedResourceDescriptions) _globalDescriptions);
  }
  
  protected IProjectConfig getProjectConfig() {
    if ((!this.isProjectConfigSet)) {
      IWorkspaceConfig _workspaceConfig = this.descriptions.getWorkspaceConfig();
      IProjectConfig _findProjectByName = null;
      if (_workspaceConfig!=null) {
        _findProjectByName=_workspaceConfig.findProjectByName(this.containerName);
      }
      this.projectConfig = _findProjectByName;
      this.isProjectConfigSet = true;
    }
    return this.projectConfig;
  }
  
  protected ResourceDescriptionsData getChunk() {
    ResourceDescriptionsData _elvis = null;
    ResourceDescriptionsData _container = this.getChunkedResourceDescriptions().getContainer(this.containerName);
    if (_container != null) {
      _elvis = _container;
    } else {
      ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(Collections.<IResourceDescription>unmodifiableList(CollectionLiterals.<IResourceDescription>newArrayList()));
      _elvis = _resourceDescriptionsData;
    }
    return _elvis;
  }
  
  protected Iterable<IResourceDescription> getContainedLocalDescriptions() {
    final Function1<IResourceDescription, Boolean> _function = (IResourceDescription it) -> {
      return Boolean.valueOf(this.isContained(it.getURI()));
    };
    return IterableExtensions.<IResourceDescription>filter(this.descriptions.getLocalDescriptions().getAllResourceDescriptions(), _function);
  }
  
  protected boolean isContained(final URI uri) {
    boolean _or = false;
    IResourceDescription _resourceDescription = this.getChunk().getResourceDescription(uri);
    boolean _tripleNotEquals = (_resourceDescription != null);
    if (_tripleNotEquals) {
      _or = true;
    } else {
      IProjectConfig _projectConfig = this.getProjectConfig();
      ISourceFolder _findSourceFolderContaining = null;
      if (_projectConfig!=null) {
        _findSourceFolderContaining=_projectConfig.findSourceFolderContaining(uri);
      }
      boolean _tripleNotEquals_1 = (_findSourceFolderContaining != null);
      _or = _tripleNotEquals_1;
    }
    return _or;
  }
  
  @Override
  public IResourceDescription getResourceDescription(final URI uri) {
    IResourceDescription _xifexpression = null;
    boolean _isContained = this.isContained(uri);
    if (_isContained) {
      _xifexpression = this.descriptions.getResourceDescription(uri);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  @Override
  public int getResourceDescriptionCount() {
    return IterableExtensions.size(this.getResourceDescriptions());
  }
  
  @Override
  public Iterable<IResourceDescription> getResourceDescriptions() {
    final Set<URI> localURIs = this.getExistingOrRenamedResourceURIs();
    Iterable<IResourceDescription> _containedLocalDescriptions = this.getContainedLocalDescriptions();
    final Function1<IResourceDescription, Boolean> _function = (IResourceDescription it) -> {
      boolean _contains = localURIs.contains(it.getURI());
      return Boolean.valueOf((!_contains));
    };
    Iterable<IResourceDescription> _filter = IterableExtensions.<IResourceDescription>filter(this.getChunk().getAllResourceDescriptions(), _function);
    return Iterables.<IResourceDescription>concat(_containedLocalDescriptions, _filter);
  }
  
  @Override
  public boolean hasResourceDescription(final URI uri) {
    IResourceDescription _resourceDescription = this.getChunk().getResourceDescription(uri);
    return (_resourceDescription != null);
  }
  
  @Override
  public Iterable<IEObjectDescription> getExportedObjects() {
    final Set<URI> localURIs = this.getExistingOrRenamedResourceURIs();
    final Function1<IResourceDescription, Iterable<IEObjectDescription>> _function = (IResourceDescription it) -> {
      return it.getExportedObjects();
    };
    final Iterable<IEObjectDescription> flatten = Iterables.<IEObjectDescription>concat(IterableExtensions.<IResourceDescription, Iterable<IEObjectDescription>>map(this.getContainedLocalDescriptions(), _function));
    final Function1<IEObjectDescription, Boolean> _function_1 = (IEObjectDescription it) -> {
      boolean _contains = localURIs.contains(it.getEObjectURI().trimFragment());
      return Boolean.valueOf((!_contains));
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(this.getChunk().getExportedObjects(), _function_1);
    return Iterables.<IEObjectDescription>concat(flatten, _filter);
  }
  
  @Override
  public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name, final boolean ignoreCase) {
    final Set<URI> localURIs = this.getExistingOrRenamedResourceURIs();
    final Function1<IResourceDescription, Iterable<IEObjectDescription>> _function = (IResourceDescription it) -> {
      return it.getExportedObjects(type, name, ignoreCase);
    };
    Iterable<IEObjectDescription> _flatten = Iterables.<IEObjectDescription>concat(IterableExtensions.<IResourceDescription, Iterable<IEObjectDescription>>map(this.getContainedLocalDescriptions(), _function));
    final Function1<IEObjectDescription, Boolean> _function_1 = (IEObjectDescription it) -> {
      boolean _contains = localURIs.contains(it.getEObjectURI().trimFragment());
      return Boolean.valueOf((!_contains));
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(this.getChunk().getExportedObjects(type, name, ignoreCase), _function_1);
    return Iterables.<IEObjectDescription>concat(_flatten, _filter);
  }
  
  @Override
  public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
    final Set<URI> localURIs = this.getExistingOrRenamedResourceURIs();
    final Function1<IResourceDescription, Iterable<IEObjectDescription>> _function = (IResourceDescription it) -> {
      return it.getExportedObjectsByObject(object);
    };
    Iterable<IEObjectDescription> _flatten = Iterables.<IEObjectDescription>concat(IterableExtensions.<IResourceDescription, Iterable<IEObjectDescription>>map(this.getContainedLocalDescriptions(), _function));
    final Function1<IEObjectDescription, Boolean> _function_1 = (IEObjectDescription it) -> {
      boolean _contains = localURIs.contains(it.getEObjectURI().trimFragment());
      return Boolean.valueOf((!_contains));
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(this.getChunk().getExportedObjectsByObject(object), _function_1);
    return Iterables.<IEObjectDescription>concat(_flatten, _filter);
  }
  
  @Override
  public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
    final Set<URI> localURIs = this.getExistingOrRenamedResourceURIs();
    final Function1<IResourceDescription, Iterable<IEObjectDescription>> _function = (IResourceDescription it) -> {
      return it.getExportedObjectsByType(type);
    };
    Iterable<IEObjectDescription> _flatten = Iterables.<IEObjectDescription>concat(IterableExtensions.<IResourceDescription, Iterable<IEObjectDescription>>map(this.getContainedLocalDescriptions(), _function));
    final Function1<IEObjectDescription, Boolean> _function_1 = (IEObjectDescription it) -> {
      boolean _contains = localURIs.contains(it.getEObjectURI().trimFragment());
      return Boolean.valueOf((!_contains));
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(this.getChunk().getExportedObjectsByType(type), _function_1);
    return Iterables.<IEObjectDescription>concat(_flatten, _filter);
  }
  
  @Override
  public boolean isEmpty() {
    return (IterableExtensions.isEmpty(this.getContainedLocalDescriptions()) && this.getChunk().isEmpty());
  }
  
  protected Set<URI> getExistingOrRenamedResourceURIs() {
    final ResourceSet resourceSet = this.descriptions.getResourceSet();
    if ((resourceSet instanceof ResourceSetImpl)) {
      return ((ResourceSetImpl)resourceSet).getURIResourceMap().keySet();
    }
    throw new IllegalStateException("ResourceSet is not a ResourceSetImpl");
  }
  
  public LiveShadowedChunkedContainer(final LiveShadowedChunkedResourceDescriptions descriptions, final String containerName) {
    super();
    this.descriptions = descriptions;
    this.containerName = containerName;
  }
}

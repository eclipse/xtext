/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeLocationProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
@SuppressWarnings("all")
public abstract class AbstractHierarchyBuilder implements IHierarchyBuilder {
  private IReferenceFinder.IResourceAccess resourceAccess;
  
  private IResourceDescriptions indexData;
  
  @Inject
  private IReferenceFinder referenceFinder;
  
  @Inject
  private TargetURICollector targetURICollector;
  
  @Inject
  private Provider<TargetURIs> targetURIProvider;
  
  @Inject
  private IHierarchyNodeLocationProvider hierarchyNodeLocationProvider;
  
  @Inject
  private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
  
  protected <R extends Object> R readOnly(final URI objectURI, final IUnitOfWork<R, EObject> work) {
    IReferenceFinder.IResourceAccess _resourceAccess = this.getResourceAccess();
    final IUnitOfWork<R, ResourceSet> _function = new IUnitOfWork<R, ResourceSet>() {
      @Override
      public R exec(final ResourceSet resourceSet) throws Exception {
        final EObject targetObject = resourceSet.getEObject(objectURI, true);
        return work.exec(targetObject);
      }
    };
    return _resourceAccess.<R>readOnly(objectURI, _function);
  }
  
  protected IEObjectDescription getDescription(final URI objectURI) {
    IResourceDescriptions _indexData = this.getIndexData();
    URI _trimFragment = objectURI.trimFragment();
    final IResourceDescription resourceDescription = _indexData.getResourceDescription(_trimFragment);
    if ((resourceDescription == null)) {
      return null;
    }
    Iterable<IEObjectDescription> _exportedObjects = resourceDescription.getExportedObjects();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return Boolean.valueOf(Objects.equal(_eObjectURI, objectURI));
      }
    };
    return IterableExtensions.<IEObjectDescription>findFirst(_exportedObjects, _function);
  }
  
  protected IEObjectDescription getDescription(final EObject object) {
    if ((object == null)) {
      return null;
    }
    IResourceDescriptions _indexData = this.getIndexData();
    Iterable<IEObjectDescription> _exportedObjectsByObject = _indexData.getExportedObjectsByObject(object);
    return IterableExtensions.<IEObjectDescription>head(_exportedObjectsByObject);
  }
  
  protected boolean isAssignable(final EClass superType, final EClassifier type) {
    if ((type instanceof EClass)) {
      return EcoreUtil2.isAssignableFrom(superType, ((EClass)type));
    }
    return false;
  }
  
  @Pure
  protected IReferenceFinder.IResourceAccess getResourceAccess() {
    return this.resourceAccess;
  }
  
  public void setResourceAccess(final IReferenceFinder.IResourceAccess resourceAccess) {
    this.resourceAccess = resourceAccess;
  }
  
  @Pure
  protected IResourceDescriptions getIndexData() {
    return this.indexData;
  }
  
  public void setIndexData(final IResourceDescriptions indexData) {
    this.indexData = indexData;
  }
  
  @Pure
  protected IReferenceFinder getReferenceFinder() {
    return this.referenceFinder;
  }
  
  public void setReferenceFinder(final IReferenceFinder referenceFinder) {
    this.referenceFinder = referenceFinder;
  }
  
  @Pure
  protected TargetURICollector getTargetURICollector() {
    return this.targetURICollector;
  }
  
  public void setTargetURICollector(final TargetURICollector targetURICollector) {
    this.targetURICollector = targetURICollector;
  }
  
  @Pure
  protected Provider<TargetURIs> getTargetURIProvider() {
    return this.targetURIProvider;
  }
  
  public void setTargetURIProvider(final Provider<TargetURIs> targetURIProvider) {
    this.targetURIProvider = targetURIProvider;
  }
  
  @Pure
  protected IHierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
    return this.hierarchyNodeLocationProvider;
  }
  
  public void setHierarchyNodeLocationProvider(final IHierarchyNodeLocationProvider hierarchyNodeLocationProvider) {
    this.hierarchyNodeLocationProvider = hierarchyNodeLocationProvider;
  }
  
  @Pure
  protected IResourceServiceProvider.Registry getResourceServiceProviderRegistry() {
    return this.resourceServiceProviderRegistry;
  }
  
  public void setResourceServiceProviderRegistry(final IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
    this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
  }
}

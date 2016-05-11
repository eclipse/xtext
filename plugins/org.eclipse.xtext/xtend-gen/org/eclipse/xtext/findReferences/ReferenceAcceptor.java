/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.findReferences;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * For local references, populates an {@link IReferenceDescription} that knows its exported container URI.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author kosyakov - Pulled up to the runtime project
 * 
 * @since 2.10
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class ReferenceAcceptor implements IReferenceFinder.Acceptor {
  private final IResourceServiceProvider.Registry resourceServiceProviderRegistry;
  
  private final IAcceptor<IReferenceDescription> delegate;
  
  private Resource currentResource;
  
  private Map<EObject, URI> exportedContainersInCurrentResource;
  
  @Override
  public void accept(final EObject source, final URI sourceURI, final EReference eReference, final int index, final EObject targetOrProxy, final URI targetURI) {
    if (((this.currentResource == null) || (source.eResource() != this.currentResource))) {
      this.computeExportedObjectsMap(source);
      Resource _eResource = source.eResource();
      this.currentResource = _eResource;
    }
    URI _findExportedContainer = this.findExportedContainer(source);
    IReferenceDescription _createReferenceDescription = this.createReferenceDescription(sourceURI, targetURI, eReference, index, _findExportedContainer);
    this.accept(_createReferenceDescription);
  }
  
  protected void computeExportedObjectsMap(final EObject source) {
    final Resource resource = source.eResource();
    URI _uRI = resource.getURI();
    final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderRegistry.getResourceServiceProvider(_uRI);
    if ((resourceServiceProvider != null)) {
      IResourceDescription.Manager _resourceDescriptionManager = resourceServiceProvider.getResourceDescriptionManager();
      final IResourceDescription resourceDescription = _resourceDescriptionManager.getResourceDescription(resource);
      HashMap<EObject, URI> _newHashMap = CollectionLiterals.<EObject, URI>newHashMap();
      this.exportedContainersInCurrentResource = _newHashMap;
      Iterable<IEObjectDescription> _exportedObjects = resourceDescription.getExportedObjects();
      for (final IEObjectDescription description : _exportedObjects) {
        {
          EObject instance = description.getEObjectOrProxy();
          boolean _eIsProxy = instance.eIsProxy();
          if (_eIsProxy) {
            URI _eObjectURI = description.getEObjectURI();
            String _fragment = _eObjectURI.fragment();
            EObject _eObject = resource.getEObject(_fragment);
            instance = _eObject;
          }
          URI _eObjectURI_1 = description.getEObjectURI();
          this.exportedContainersInCurrentResource.put(instance, _eObjectURI_1);
        }
      }
    } else {
      Map<EObject, URI> _emptyMap = CollectionLiterals.<EObject, URI>emptyMap();
      this.exportedContainersInCurrentResource = _emptyMap;
    }
  }
  
  protected URI findExportedContainer(final EObject obj) {
    EObject source = obj;
    boolean _isEmpty = this.exportedContainersInCurrentResource.isEmpty();
    if (_isEmpty) {
      return null;
    }
    URI result = this.exportedContainersInCurrentResource.get(source);
    while ((result == null)) {
      {
        boolean _containsKey = this.exportedContainersInCurrentResource.containsKey(source);
        if (_containsKey) {
          return result;
        }
        EObject _eContainer = source.eContainer();
        source = _eContainer;
        if ((source == null)) {
          return null;
        }
        URI _get = this.exportedContainersInCurrentResource.get(source);
        result = _get;
      }
    }
    this.exportedContainersInCurrentResource.put(source, result);
    return result;
  }
  
  @Override
  public void accept(final IReferenceDescription description) {
    this.delegate.accept(description);
  }
  
  protected IReferenceDescription createReferenceDescription(final URI sourceURI, final URI targetURI, final EReference eReference, final int index, final URI containerURI) {
    return new DefaultReferenceDescription(sourceURI, targetURI, eReference, index, containerURI);
  }
  
  public ReferenceAcceptor(final IResourceServiceProvider.Registry resourceServiceProviderRegistry, final IAcceptor<IReferenceDescription> delegate) {
    super();
    this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
    this.delegate = delegate;
  }
}

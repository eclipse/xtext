/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.findReferences;

import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.EcoreUtil2;
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
      this.currentResource = source.eResource();
    }
    this.accept(this.createReferenceDescription(EcoreUtil2.getFragmentPathURI(source), targetURI, eReference, index, this.findExportedContainer(source)));
  }
  
  protected void computeExportedObjectsMap(final EObject source) {
    final Resource resource = source.eResource();
    final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderRegistry.getResourceServiceProvider(resource.getURI());
    if ((resourceServiceProvider != null)) {
      final IResourceDescription resourceDescription = resourceServiceProvider.getResourceDescriptionManager().getResourceDescription(resource);
      this.exportedContainersInCurrentResource = CollectionLiterals.<EObject, URI>newHashMap();
      Iterable<IEObjectDescription> _exportedObjects = resourceDescription.getExportedObjects();
      for (final IEObjectDescription description : _exportedObjects) {
        {
          EObject instance = description.getEObjectOrProxy();
          boolean _eIsProxy = instance.eIsProxy();
          if (_eIsProxy) {
            instance = resource.getEObject(description.getEObjectURI().fragment());
          }
          this.exportedContainersInCurrentResource.put(instance, description.getEObjectURI());
        }
      }
    } else {
      this.exportedContainersInCurrentResource = CollectionLiterals.<EObject, URI>emptyMap();
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
        source = source.eContainer();
        if ((source == null)) {
          return null;
        }
        result = this.exportedContainersInCurrentResource.get(source);
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

/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Maps;

/**
 * For local references, populates an {@link IReferenceDescription} that knows its exported container URI.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReferenceAcceptor implements org.eclipse.xtext.findReferences.IReferenceFinder.Acceptor {

	private final IAcceptor<IReferenceDescription> delegate;
	private final IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	private Resource currentResource;
	private Map<EObject, URI> exportedContainersInCurrentResource;
	
	protected ReferenceAcceptor(IAcceptor<IReferenceDescription> delegate, IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
		this.delegate = delegate;
		this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
	}
	
	@Override
	public void accept(EObject source, URI sourceURI, EReference eReference, int index, EObject targetOrProxy,
			URI targetURI) {
		if (currentResource == null || source.eResource() != currentResource) {
			computeExportedObjectsMap(source);
			currentResource = source.eResource();
		}
		accept(createReferenceDescription(sourceURI, targetURI, eReference, index, findExportedContainer(source)));
	}

	private void computeExportedObjectsMap(EObject source) {
		Resource resource = source.eResource();
		IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(resource.getURI());
		if (resourceServiceProvider != null) {
			IResourceDescription resourceDescription = resourceServiceProvider.getResourceDescriptionManager().getResourceDescription(resource);
			exportedContainersInCurrentResource = Maps.newHashMap();
			for(IEObjectDescription description: resourceDescription.getExportedObjects()) {
				EObject instance = description.getEObjectOrProxy();
				if (instance.eIsProxy()) {
					instance = resource.getEObject(description.getEObjectURI().fragment());
				}
				exportedContainersInCurrentResource.put(instance, description.getEObjectURI());
			}
		} else {
			exportedContainersInCurrentResource = Collections.emptyMap();
		}
	}
	
	protected URI findExportedContainer(EObject source) {
		if (exportedContainersInCurrentResource.isEmpty()) {
			return null;
		}
		URI result = exportedContainersInCurrentResource.get(source);
		while(result == null) {
			if (exportedContainersInCurrentResource.containsKey(source)) {
				return result;
			}
			source = source.eContainer();
			if (source == null) {
				return null;
			}
			result = exportedContainersInCurrentResource.get(source);
		}
		exportedContainersInCurrentResource.put(source, result);
		return result;
	}

	@Override
	public void accept(IReferenceDescription description) {
		this.delegate.accept(description);
	}
	
	protected DefaultReferenceDescription createReferenceDescription(URI sourceURI, URI targetURI, EReference eReference,
			int index, URI containerURI) {
		return new DefaultReferenceDescription(sourceURI, targetURI, eReference, index, containerURI);
	}
	
}
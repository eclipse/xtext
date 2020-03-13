/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.findReferences;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;

/**
 * For local references, populates an {@link IReferenceDescription} that knows its exported container URI.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author kosyakov - Pulled up to the runtime project
 */
public class ReferenceAcceptor implements IReferenceFinder.Acceptor {
	private final IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	private final IAcceptor<IReferenceDescription> delegate;

	private Resource currentResource;

	private Map<EObject, URI> exportedContainersInCurrentResource;

	public ReferenceAcceptor(IResourceServiceProvider.Registry resourceServiceProviderRegistry,
			IAcceptor<IReferenceDescription> delegate) {
		this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
		this.delegate = delegate;
	}

	@Override
	public void accept(EObject source, URI sourceURI, EReference eReference, int index, EObject targetOrProxy,
			URI targetURI) {
		if (currentResource == null || source.eResource() != currentResource) {
			computeExportedObjectsMap(source);
			currentResource = source.eResource();
		}
		accept(createReferenceDescription(EcoreUtil2.getFragmentPathURI(source), targetURI, eReference, index,
				findExportedContainer(source)));
	}

	@Override
	public void accept(IReferenceDescription description) {
		delegate.accept(description);
	}

	protected void computeExportedObjectsMap(EObject source) {
		Resource resource = source.eResource();
		IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry
				.getResourceServiceProvider(resource.getURI());
		if (resourceServiceProvider != null) {
			exportedContainersInCurrentResource = new HashMap<>();
			Iterable<IEObjectDescription> exportedObjects = resourceServiceProvider.getResourceDescriptionManager()
					.getResourceDescription(resource).getExportedObjects();
			for (IEObjectDescription description : exportedObjects) {
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

	protected URI findExportedContainer(EObject obj) {
		if (exportedContainersInCurrentResource.isEmpty()) {
			return null;
		}
		EObject source = obj;
		URI result = exportedContainersInCurrentResource.get(source);
		while (result == null) {
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

	protected IReferenceDescription createReferenceDescription(URI sourceURI, URI targetURI, EReference eReference,
			int index, URI containerURI) {
		return new DefaultReferenceDescription(sourceURI, targetURI, eReference, index, containerURI);
	}

}

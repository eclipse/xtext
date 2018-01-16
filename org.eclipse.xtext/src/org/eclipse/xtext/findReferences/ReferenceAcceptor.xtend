/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.findReferences

import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.EcoreUtil2

/**
 * For local references, populates an {@link IReferenceDescription} that knows its exported container URI.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author kosyakov - Pulled up to the runtime project
 */
@FinalFieldsConstructor
class ReferenceAcceptor implements IReferenceFinder.Acceptor {

	val IResourceServiceProvider.Registry resourceServiceProviderRegistry
	val IAcceptor<IReferenceDescription> delegate

	Resource currentResource
	Map<EObject, URI> exportedContainersInCurrentResource

	override void accept(
		EObject source,
		URI sourceURI,
		EReference eReference,
		int index,
		EObject targetOrProxy,
		URI targetURI
	) {
		if (currentResource === null || source.eResource() !== currentResource) {
			computeExportedObjectsMap(source)
			currentResource = source.eResource()
		}
		accept(createReferenceDescription(EcoreUtil2.getFragmentPathURI(source), targetURI, eReference, index, findExportedContainer(source)))
	}

	protected def void computeExportedObjectsMap(EObject source) {
		val resource = source.eResource
		val resourceServiceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(resource.URI)
		if (resourceServiceProvider !== null) {
			val resourceDescription = resourceServiceProvider.resourceDescriptionManager.getResourceDescription(resource)
			exportedContainersInCurrentResource = newHashMap
			for (description : resourceDescription.exportedObjects) {
				var instance = description.EObjectOrProxy
				if (instance.eIsProxy) {
					instance = resource.getEObject(description.EObjectURI.fragment)
				}
				exportedContainersInCurrentResource.put(instance, description.EObjectURI)
			}
		} else {
			exportedContainersInCurrentResource = emptyMap
		}
	}

	protected def URI findExportedContainer(EObject obj) {
		var source = obj
		if (exportedContainersInCurrentResource.isEmpty()) {
			return null
		}
		var result = exportedContainersInCurrentResource.get(source)
		while (result === null) {
			if (exportedContainersInCurrentResource.containsKey(source)) {
				return result
			}
			source = source.eContainer
			if (source === null) {
				return null
			}
			result = exportedContainersInCurrentResource.get(source)
		}
		exportedContainersInCurrentResource.put(source, result)
		return result
	}

	override void accept(IReferenceDescription description) {
		this.delegate.accept(description)
	}

	protected def IReferenceDescription createReferenceDescription(
		URI sourceURI,
		URI targetURI,
		EReference eReference,
		int index,
		URI containerURI
	) {
		return new DefaultReferenceDescription(sourceURI, targetURI, eReference, index, containerURI)
	}
}

/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy

import com.google.inject.Inject
import javax.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.findReferences.IReferenceFinder
import org.eclipse.xtext.findReferences.IReferenceFinder.IResourceAccess
import org.eclipse.xtext.findReferences.TargetURICollector
import org.eclipse.xtext.findReferences.TargetURIs
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.concurrent.IUnitOfWork

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Accessors(PUBLIC_SETTER, PROTECTED_GETTER)
abstract class AbstractHierarchyBuilder implements IHierarchyBuilder {

	IResourceAccess resourceAccess

	IResourceDescriptions indexData

	@Inject
	IReferenceFinder referenceFinder

	@Inject
	TargetURICollector targetURICollector

	@Inject
	Provider<TargetURIs> targetURIProvider

	@Inject
	IHierarchyNodeLocationProvider hierarchyNodeLocationProvider

	@Inject
	IResourceServiceProvider.Registry resourceServiceProviderRegistry
	
	protected def <R> R readOnly(URI objectURI, IUnitOfWork<R, EObject> work) {
		return getResourceAccess.readOnly(objectURI) [ resourceSet |
			val targetObject = resourceSet.getEObject(objectURI, true)
			return work.exec(targetObject)
		]
	}

	protected def IEObjectDescription getDescription(URI objectURI) {
		val resourceDescription = getIndexData.getResourceDescription(objectURI.trimFragment)
		if(resourceDescription === null) return null

		return resourceDescription.exportedObjects.findFirst[EObjectURI == objectURI]
	}

	protected def IEObjectDescription getDescription(EObject object) {
		if(object === null) return null
		return getIndexData.getExportedObjectsByObject(object).head
	}
	
	protected def isAssignable(EClass superType, EClassifier type) {
		if (type instanceof EClass)
			return superType.isAssignableFrom(type)
		return false
	}

}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContainerBasedScope extends AbstractScope {
	
	private final IScope outer;
	private final EReference reference;
	private final IContainer container;

	public ContainerBasedScope(IScope outer, EReference reference, IContainer container) {
		this.outer = outer;
		this.reference = reference;
		this.container = container;
	}

	@Override
	public Iterable<IEObjectDescription> internalGetContents() {
		return container.findAllEObjects(reference.getEReferenceType());
	}

	@Override
	public IEObjectDescription getContentByName(String name) {
		Iterable<IEObjectDescription> allDescriptions = container.findAllEObjects(
				reference.getEReferenceType(), name);
		Iterator<IEObjectDescription> iter = allDescriptions.iterator();
		IEObjectDescription result = null;
		while (iter.hasNext()) {
			if (result != null)
				return getOuterScope().getContentByName(name);
			result = iter.next();
		}
		if (result != null)
			return result;
		return getOuterScope().getContentByName(name);
	}

	@Override
	public IEObjectDescription getContentByEObject(EObject object) {
		URI resourceURI = EcoreUtil.getURI(object).trimFragment();
		IResourceDescription description = container.getResourceDescription(resourceURI);
		if (description != null) {
			Iterable<IEObjectDescription> allDescriptions = description.getExportedObjectsForEObject(object);
			Iterator<IEObjectDescription> iter = allDescriptions.iterator();
			boolean hadNext = false;
			while (iter.hasNext()) {
				hadNext = true;
				IEObjectDescription result = iter.next();
				if (isValidForEObject(result))
					return result;
			}
			if (hadNext)
				return null;
		}
		return getOuterScope().getContentByEObject(object);
	}

	private boolean isValidForEObject(IEObjectDescription result) {
		Iterable<IEObjectDescription> allDescriptionsByName = container.findAllEObjects(reference
				.getEReferenceType(), result.getName());
		Iterator<IEObjectDescription> iter = allDescriptionsByName.iterator();
		IEObjectDescription inverted = null;
		while (iter.hasNext()) {
			if (inverted != null)
				return false;
			inverted = iter.next();
		}
		return inverted != null && inverted.getEObjectURI().equals(result.getEObjectURI());
	}

	public IScope getOuterScope() {
		return outer;
	}
}
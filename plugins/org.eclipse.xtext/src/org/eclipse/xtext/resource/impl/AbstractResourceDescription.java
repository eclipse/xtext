/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractResourceDescription implements IResourceDescription {
	
	private EObjectDescriptionLookUp lookup;
	private boolean invalidated;
	
	protected AbstractResourceDescription() {
		invalidated = true;
	}

	public Iterable<IEObjectDescription> getExportedObjects(EClass clazz, String name) {
		updateLookup();
		return lookup.getExportedObjects(clazz, name);
	}

	public Iterable<IEObjectDescription> getExportedObjects(EClass clazz) {
		updateLookup();
		return lookup.getExportedObjects(clazz);
	}

	public Iterable<IEObjectDescription> getExportedObjectsForEObject(EObject object) {
		updateLookup();
		return lookup.getExportedObjectsForEObject(object);
	}
	
	public Iterable<IEObjectDescription> getExportedObjects() {
		updateLookup();
		return lookup.getExportedObjects();
	}
	
	public void invalidateCache() {
		invalidated = true;
	}
	
	protected abstract List<IEObjectDescription> computeExportedObjects();
	
	protected void updateLookup() {
		if (lookup == null) {
			lookup = new EObjectDescriptionLookUp(computeExportedObjects());
		} else if (isInvalid()) {
			lookup.setExportedObjects(computeExportedObjects());
		}
		invalidated = false;
	}

	protected boolean isInvalid() {
		return invalidated;
	}
	
	protected URI findContainerEObjectURI(EObject referenceOwner, Iterable<IEObjectDescription> exportedEObjects) {
		List<URI> allContainers = EcoreUtil2.allContainerURIs(referenceOwner);
		URI currentExportedContainerURI = null;
		int currentIndex = Integer.MAX_VALUE;
		for (IEObjectDescription eObjectDescription : exportedEObjects) {
			int index = allContainers.indexOf(eObjectDescription.getEObjectURI());
			if(index != -1 && index < currentIndex) {
				currentIndex = index;
				currentExportedContainerURI = eObjectDescription.getEObjectURI();
				if(currentIndex == 0) {
					break;
				}
				allContainers = allContainers.subList(0, currentIndex);
			}
		}
		return currentExportedContainerURI;
	}


}

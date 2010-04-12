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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ignorecase.IIgnoreCaseResourceDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractResourceDescription implements IIgnoreCaseResourceDescription {
	
	private EObjectDescriptionLookUp lookup;
	
	public Iterable<IEObjectDescription> getExportedObjects(EClass clazz, String name) {
		return getLookUp().getExportedObjects(clazz, name);
	}

	public Iterable<IEObjectDescription> getExportedObjectsIgnoreCase(EClass clazz, String name) {
		return getLookUp().getExportedObjectsIgnoreCase(clazz, name);
	}
	
	public Iterable<IEObjectDescription> getExportedObjects(EClass clazz) {
		return getLookUp().getExportedObjects(clazz);
	}

	public Iterable<IEObjectDescription> getExportedObjectsForEObject(EObject object) {
		return getLookUp().getExportedObjectsForEObject(object);
	}
	
	public Iterable<IEObjectDescription> getExportedObjects() {
		return getLookUp().getExportedObjects();
	}
	
	protected abstract List<IEObjectDescription> computeExportedObjects();
	
	protected EObjectDescriptionLookUp getLookUp() {
		if (lookup == null)
			lookup = new EObjectDescriptionLookUp(computeExportedObjects());
		return lookup;
	}

	protected URI getNormalizedURI(Resource resource) {
		if (resource.getResourceSet() != null)
			return resource.getResourceSet().getURIConverter().normalize(resource.getURI());
		else
			return resource.getURI();
	}
	
}

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
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractResourceDescription implements IResourceDescription {
	
	protected EObjectDescriptionLookUp lookup;
	
	public boolean isEmpty() {
		return getLookUp().isEmpty();
	}
	
	public Iterable<IEObjectDescription> getExportedObjects() {
		return getLookUp().getExportedObjects();
	}
	
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return getLookUp().getExportedObjectsByType(type);
	}
	
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return getLookUp().getExportedObjectsByObject(object);
	}
	
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		return getLookUp().getExportedObjects(type, name, ignoreCase);
	}
	
	protected abstract List<IEObjectDescription> computeExportedObjects();
	
	protected EObjectDescriptionLookUp getLookUp() {
		if (lookup == null)
			lookup = new EObjectDescriptionLookUp(computeExportedObjects());
		return lookup;
	}

	protected URI getNormalizedURI(Resource resource) {
		URI uri = resource.getURI();
		if (uri != null && !uri.isPlatform() && resource.getResourceSet() != null)
			return resource.getResourceSet().getURIConverter().normalize(uri);
		else
			return uri;
	}
	
}

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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.ISelector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractResourceDescription implements IResourceDescription {
	
	private EObjectDescriptionLookUp lookup;
	
	public Iterable<IEObjectDescription> getExportedObjects() {
		return getLookUp().getExportedObjects();
	}
	
	public Iterable<IEObjectDescription> getExportedObjects(ISelector selector) {
		return getLookUp().getExportedObjects(selector);
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
